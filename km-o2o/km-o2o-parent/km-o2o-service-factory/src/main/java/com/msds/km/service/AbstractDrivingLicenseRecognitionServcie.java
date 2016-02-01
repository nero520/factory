package com.msds.km.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.msds.km.model.DrivingLicense;
import com.msds.open.api.RecognitionException;

public abstract class AbstractDrivingLicenseRecognitionServcie implements
		DrivingLicenseRecognitionServcie {
	
	private Logger logger = Logger.getLogger(AbstractDrivingLicenseRecognitionServcie.class);
	
	/**
	 * 缓存图像识别结果。提升多次识别的效率。key是文件内容的MD5值，value是对应的行驶证信息。
	 */
	private Map<String, DrivingLicense> cachedMap = new ConcurrentHashMap<String, DrivingLicense>();
	
	public static final long MAX_FILE_SIZE = 5*1024*1024;

	public DrivingLicense recognition(File file) throws RecognitionException {
		if(file == null){
			throw new RecognitionException("file is null");
		}
		if(file.length()> MAX_FILE_SIZE){
			throw new RecognitionException("the length of file can not bigger than the max file size ("+MAX_FILE_SIZE+")");
		}
		
		//先从缓存中获取识别对象信息，提升多次识别同一张图片的效率。
		String signature = this.getFileSignature(file);
		DrivingLicense license = cachedMap.get(signature);
		if(cachedMap.containsKey(signature) || license!=null){
			return license;
		}
		license = recognitionInternal(file);
		
		//放入缓存中。
		this.cachedMap.put(signature, license);
		
		return license;
	}
	
	/**
	 * 获得文件内容的MD5签名。
	 * @return 
	 */
	protected String getFileSignature(File file) {
		if(file==null || !file.exists()){
			return null;
		}
		try {
			byte[] bytes = IOUtils.toByteArray(new FileInputStream(file));
			return DigestUtils.md5Hex(bytes);
		} catch (FileNotFoundException e) {
			logger.error("file not founded", e);
			throw new RecognitionException(e);
		} catch (IOException e) {
			logger.error("io excepton", e);
			throw new RecognitionException(e);
		}
	}
	
	/**
	 * 由子类继续实现识别图片文件内容。
	 * @param file 图片文件。
	 * @return
	 * @throws RecognitionException
	 */
	protected abstract DrivingLicense recognitionInternal(File file) throws RecognitionException;

	public DrivingLicense recognition(InputStream inputStream)
			throws RecognitionException {
		throw new RecognitionException("暂未实现");
	}

	public DrivingLicense recognition(BufferedImage image)
			throws RecognitionException {
		throw new RecognitionException("暂未实现");
	}

}
