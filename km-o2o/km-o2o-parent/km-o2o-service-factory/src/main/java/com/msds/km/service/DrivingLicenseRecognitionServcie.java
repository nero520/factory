package com.msds.km.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import com.msds.km.model.DrivingLicense;
import com.msds.open.api.RecognitionException;


/**
 * 
 * 该接口是定义了一个行驶证图片识别的接口类。
 * 可以识别图片文件，返回一个行驶证对象。
 * @author wubingyang
 */
public interface DrivingLicenseRecognitionServcie{
	
	/**
	 * 识别行驶证图片文件为行驶证信息对象。
	 * @param file 行驶证图片，支持的图片格式是jpg/jpeg/bmp，图片大小不超过5M.
	 * @throws RecognitionException 如果识别出错则抛出该异常，详细的异常信息见message.
	 * @return 行驶证信息。
	 */
	public DrivingLicense recognition(File file) throws RecognitionException;
	
	
	/**
	 * 识别行驶证图片二进制输入流为行驶证信息对象。
	 * @param inputStream 行驶证图片二进制输入流，支持的图片格式是jpg/jpeg/bmp，图片大小不超过5M.
	 * @throws RecognitionException 如果识别出错则抛出该异常，详细的异常信息见message.
	 * @return 行驶证信息。
	 */
	public DrivingLicense recognition(InputStream inputStream) throws RecognitionException;
	

	/**
	 * 识别行驶证图片二进制输入流为行驶证信息对象。
	 * @param image 行驶证图片对象，支持的图片格式是jpg/jpeg/bmp，图片大小不超过5M.
	 * @throws RecognitionException 如果识别出错则抛出该异常，详细的异常信息见message.
	 * @return 行驶证信息。
	 */
	public DrivingLicense recognition(BufferedImage image) throws RecognitionException;
}
