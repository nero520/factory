package com.msds.km.service.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.msds.km.model.DrivingLicense;
import com.msds.km.service.AbstractDrivingLicenseRecognitionServcie;
import com.msds.open.api.RecognitionException;
import com.thoughtworks.xstream.XStream;

/**
 * 基于云脉公司的云识别api实现的行驶证识别实现。
 * 请参考网址，http://ocr.ccyunmai.com/idcard/。
 * 该实现的稳定性依赖该服务的稳定性。
 * @author wubingyang.
 */
@Service
public class YunmaiAPIDrivingLicenseRecognitionServcieiImpl extends
		AbstractDrivingLicenseRecognitionServcie {
	
	public static final String POST_URL = "http://ocr.ccyunmai.com/UploadImg.action#demo";
	
	private CloseableHttpClient httpclient = null;
	
	private XStream stream = null;
	
	public YunmaiAPIDrivingLicenseRecognitionServcieiImpl(){
		httpclient = HttpClients.createDefault();
		stream = new XStream();
		stream.processAnnotations(DrivingLicense.class);
	}

	@Override
	protected DrivingLicense recognitionInternal(File file)
			throws RecognitionException {
		try {
            HttpPost httppost = new HttpPost(POST_URL);
            FileBody fileBody = new FileBody(file);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("img", fileBody)
                    .addTextBody("action", "driving")
                    .addTextBody("callbackurl", "/idcard/")
                    .build();

            httppost.setEntity(reqEntity);
            
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                String content = EntityUtils.toString(response.getEntity());
                EntityUtils.consume(response.getEntity());
                return this.parseDrivingLicense(content);
            } catch (IOException e) {
				throw new RecognitionException("can not post request to the url:"+POST_URL+", please check the network.", e);
			} finally {
                try {
					response.close();
				} catch (IOException e) {
					throw new RecognitionException("can not post request to the url:"+POST_URL+", please check the network.", e);
				}
            }
        } catch (FileNotFoundException e) {
        	throw new RecognitionException("the file can not founded:"+file.getAbsolutePath()+", please check the file.", e);
		} catch (ClientProtocolException e) {
			throw new RecognitionException("can not post request to the url:"+POST_URL+", please check the network.", e);
		} catch (IOException e) {
			throw new RecognitionException("can not post request to the url:"+POST_URL+", please check the network.", e);
		}
	}
	
	/**
	 * 从html网页内容中解析出行驶证信息。
	 * @param html 从云识别接口中获取识别的xml内容，解析为java对象。
	 * @return 行驶请对象。
	 */
	protected DrivingLicense parseDrivingLicense(String html) {
		if(html.isEmpty()){
			throw new RecognitionException("the html content is empty");
		}
		Document document = Jsoup.parse(html);
		if(document==null){
			throw new RecognitionException("the document prased from html content is null, please check the website");
		}
		
		Elements fieldsets = document.select("div[class=left result] fieldset");
		if(fieldsets.size()!=1){
			throw new RecognitionException("the document should has result filedset, the content of the web page may be changed.");
		}
		Element regResult = fieldsets.first();
		String result = regResult.html().trim();
		
		//移除多余的字符。
		String removedStr = "<legend>识别结果</legend>";
		if(result.startsWith(removedStr)){
			result = result.substring(removedStr.length());
		}
		
		//反转义xml字符。
		result = StringEscapeUtils.unescapeXml(result);
		
		//添加根节点。
		result = "<drivingLicense>"+result+"</drivingLicense>";
		return (DrivingLicense)stream.fromXML(result);
	}

}
