package com.msds.km.service;

import com.msds.km.model.DrivingLicense;

/**
 * 
 * 该接口是定义了一个行驶证图片识别的接口类。 可以识别图片文件，返回一个行驶证对象。
 * 
 */
public interface DrivingLicenseRecognitionServcie {

	/**
	 * 识别行驶证图片文件为行驶证信息对象。
	 * 
	 * @param b
	 *            行驶证图片，支持的图片格式是jpg/jpeg/bmp，图片大小不超过5M.
	 * @throws Exception
	 *             如果识别出错则抛出该异常，详细的异常信息见message.
	 * @return 行驶证信息。
	 */
	DrivingLicense recognition(byte[] b) throws Exception;

}
