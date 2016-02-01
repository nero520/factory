package com.msds.plugin.weixin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.plugin.entity.PluginConfigEntity;
import com.msds.plugin.service.PluginConfigAttributeService;
import com.msds.plugin.service.PluginConfigService;
import com.msds.plugin.weixin.model.template.SendMessageResponse;
import com.msds.plugin.weixin.model.template.TemplateMessage;
import com.msds.util.JsonUtils;
import com.msds.util.RedisUtil;

/**
 * Plugin - 微信
 * 
 * @TODO 初步封装，后续改善
 * @author lilong
 * @date 2015年11月9日13:30:08
 */
@Service("weixinPlugin")
public class WeiXinPlugin {

	protected final Logger logger = LoggerFactory.getLogger(getClass());;

	/** 微信 AccessToken CACHE */
	private static final String ACCESS_TOKEN_CACHE = "WEIXIN_ACCESS_TOKEN_CACHE";
	/** 微信 AccessToken */
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	/** 发送模板消息 */
	private static final String SEND_TEMPLATE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	/** 授权AccessToken */
	private static final String AUTHORIZE_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

	private static String APPID = null;
	private static String APPSECRET = null;

	@Resource(name = "pluginConfigService")
	private PluginConfigService pluginConfigService;
	@Resource(name = "pluginConfigAttributeService")
	private PluginConfigAttributeService pluginConfigAttributeService;

	/**
	 * 获取插件参数
	 * 
	 * @return 插件配置
	 */
	@PostConstruct
	private final void getPluginConfig() {
		PluginConfigEntity pluginConfigEntity = pluginConfigService
				.findByPluginId("weixinPlugin");
		if (pluginConfigEntity != null) {
			Map<String, String> Attribute = pluginConfigAttributeService
					.findMapByPluginConfig(pluginConfigEntity.getId());
			if (Attribute != null) {
				APPID = Attribute.get("appid");
				APPSECRET = Attribute.get("secret");
			}
		}
	}

	private final String getAccessToken() {
		String token = RedisUtil.getValue(ACCESS_TOKEN_CACHE);
		if (StringUtils.isNotBlank(token))
			return token;

		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("appid", APPID);
		parameterMap.put("secret", APPSECRET);
		String ret = get(ACCESS_TOKEN_URL, parameterMap);

		if (null != ret) {
			Map<String, String> retMap = JsonUtils.toObject(ret, Map.class);
			if (retMap != null) {
				token = retMap.get("access_token");
				RedisUtil.setValue(ACCESS_TOKEN_CACHE, token, 7000,
						TimeUnit.SECONDS);
			}
		}
		return token;
	}

	public boolean sendTemplateMsg(TemplateMessage templateMessage) {
		if (templateMessage != null) {
			String jsonData = JsonUtils.toJson(templateMessage);
			String ret = post(SEND_TEMPLATE_MSG_URL + this.getAccessToken(),
					jsonData);
			if (ret != null) {
				SendMessageResponse sendMessageResponse = JsonUtils.toObject(
						ret, SendMessageResponse.class);
				if (sendMessageResponse != null) {
					if ("0".equals(sendMessageResponse.getErrcode())) {
						return true;
					} else {
						logger.info("发送模板消息出错:{},{}",
								sendMessageResponse.getErrcode(),
								sendMessageResponse.getErrmsg());
					}
				}
			}
		}
		return false;
	}

	public String getOpenId(String code) {
		if (code != null) {
			Map<String, Object> sParaTemp = new HashMap<String, Object>();
			sParaTemp.put("appid", APPID);
			sParaTemp.put("secret", APPSECRET);
			sParaTemp.put("code", code);
			sParaTemp.put("grant_type", "authorization_code");
			String ret = get(AUTHORIZE_ACCESS_TOKEN_URL, sParaTemp);
			if (StringUtils.isNotBlank(ret)) {
				Map<String, String> map = JsonUtils.toObject(ret, Map.class);
				if (map != null) {
					return map.get("openid");
				}
			}
		}
		return null;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String post(String url, Map<String, Object> parameterMap) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (parameterMap != null) {
				for (Entry<String, Object> entry : parameterMap.entrySet()) {
					String name = entry.getKey();
					String value = ConvertUtils.convert(entry.getValue());
					if (StringUtils.isNotEmpty(name)) {
						nameValuePairs.add(new BasicNameValuePair(name, value));
					}
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String post(String url, String parameter) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpPost.setConfig(requestConfig);
			if (parameter != null) {
				httpPost.setEntity(new StringEntity(parameter, "UTF-8"));
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity, "UTF-8");
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * GET请求
	 * 
	 * @param url
	 *            URL
	 * @param parameterMap
	 *            请求参数
	 * @return 返回结果
	 */
	protected String get(String url, Map<String, Object> parameterMap) {
		Assert.hasText(url);
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (parameterMap != null) {
				for (Entry<String, Object> entry : parameterMap.entrySet()) {
					String name = entry.getKey();
					String value = ConvertUtils.convert(entry.getValue());
					if (StringUtils.isNotEmpty(name)) {
						nameValuePairs.add(new BasicNameValuePair(name, value));
					}
				}
			}
			HttpGet httpGet = new HttpGet(url
					+ (StringUtils.contains(url, "?") ? "&" : "?")
					+ EntityUtils.toString(new UrlEncodedFormEntity(
							nameValuePairs, "UTF-8")));
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			result = EntityUtils.toString(httpEntity);
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}