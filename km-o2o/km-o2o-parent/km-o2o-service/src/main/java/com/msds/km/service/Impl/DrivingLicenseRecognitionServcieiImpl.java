package com.msds.km.service.Impl;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.msds.km.common.CommonAttributes;
import com.msds.km.model.DrivingLicense;
import com.msds.km.service.DrivingLicenseRecognitionServcie;
import com.msds.util.RedisUtil;
import com.msds.util.XMLUtils;

/**
 * 基于云脉公司的云识别api实现的行驶证识别实现。 请参考网址，http://ocr.ccyunmai.com/idcard/。
 * 该实现的稳定性依赖该服务的稳定性。
 * 
 */
@Service("drivingLicenseRecognitionServciei")
public class DrivingLicenseRecognitionServcieiImpl implements
		DrivingLicenseRecognitionServcie {

	private Logger logger = Logger
			.getLogger(DrivingLicenseRecognitionServcieiImpl.class);

	// public static final long MAX_FILE_SIZE = 5 * 1024 * 1024;

	public static final String POST_URL = "http://ocr.ccyunmai.com/UploadImg.action#demo";

	private CloseableHttpClient httpclient = null;

	public DrivingLicenseRecognitionServcieiImpl() {
		httpclient = HttpClients.createDefault();
	}

	@Override
	public DrivingLicense recognition(byte[] b) throws Exception {
		if (b == null) {
			throw new Exception("byte[] is null");
		}
		// if (b.length > MAX_FILE_SIZE) {
		// throw new Exception(
		// "the length of file can not bigger than the max file size ("
		// + MAX_FILE_SIZE + ")");
		// }

		// 先从缓存中获取识别对象信息，提升多次识别同一张图片的效率。
		String signature = this.getSignature(b);
		DrivingLicense license = RedisUtil.getMapValue(
				CommonAttributes.DRIVINGLICENSE_CACHE, signature);
		if (license != null) {
			return license;
		}
		license = this.parseDrivingLicense(this.recognitionInternal(b));
		// 放入缓存中。
		RedisUtil.setMapValue(CommonAttributes.DRIVINGLICENSE_CACHE, signature,
				license);

		return license;
	}

	/**
	 * 获得内容的MD5签名。
	 * 
	 * @return
	 * @throws IOException
	 */
	protected String getSignature(byte[] b) {
		if (b == null) {
			return null;
		}
		return DigestUtils.md5Hex(b);
	}

	private String recognitionInternal(byte[] b) throws Exception {
		try {
			HttpPost httppost = new HttpPost(POST_URL);

			HttpEntity reqEntity = MultipartEntityBuilder
					.create()
					.addBinaryBody("img", b, ContentType.MULTIPART_FORM_DATA,
							"test.jpg").addTextBody("action", "driving")
					.addTextBody("callbackurl", "/idcard/").build();

			httppost.setEntity(reqEntity);

			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				String content = EntityUtils.toString(response.getEntity());
				EntityUtils.consume(response.getEntity());
				return content;
			} catch (IOException e) {
				throw new Exception("can not post request to the url:"
						+ POST_URL + ", please check the network.", e);
			} finally {
				try {
					response.close();
				} catch (IOException e) {
					throw new Exception("can not post request to the url:"
							+ POST_URL + ", please check the network.", e);
				}
			}
		} catch (ClientProtocolException e) {
			throw new Exception("can not post request to the url:" + POST_URL
					+ ", please check the network.", e);
		} catch (IOException e) {
			throw new Exception("can not post request to the url:" + POST_URL
					+ ", please check the network.", e);
		}
	}

	/**
	 * 从html网页内容中解析出行驶证信息。
	 * 
	 * @param html
	 *            从云识别接口中获取识别的xml内容，解析为java对象。
	 * @return 行驶请对象。
	 * @throws Exception
	 */
	private DrivingLicense parseDrivingLicense(String html) throws Exception {
		if (html.isEmpty()) {
			logger.info("内容为空");
			return null;
		}
		Document document = Jsoup.parse(html);
		if (document == null) {
			logger.info("html内容为空");
			return null;
		}

		Elements fieldsets = document.select("div[class=left result] fieldset");
		if (fieldsets.size() != 1) {
			logger.info("网站结构变动");
			return null;
		}
		Element regResult = fieldsets.first();
		String result = regResult.html().trim();

		// 移除多余的字符。
		String removedStr = "<legend>识别结果</legend>";
		if (result.startsWith(removedStr)) {
			result = result.substring(removedStr.length());
		}

		// 反转义xml字符。
		result = StringEscapeUtils.unescapeXml(result);

		// 添加根节点。
		result = "<drivingLicense>" + result + "</drivingLicense>";
		return XMLUtils.toObject(result, DrivingLicense.class);
	}

}
