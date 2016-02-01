package com.msds.km.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.message.DrivingLicenseResponseEnum;
import com.msds.km.message.FileUpdateResponseEnum;
import com.msds.km.model.DrivingLicense;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.DrivingLicenseRecognitionServcie;
import com.msds.util.Base64;

@Controller("drivingLicense")
@RequestMapping("/drivingLicense")
public class DrivingLicenseController extends BaseController {

	@Resource(name = "drivingLicenseRecognitionServciei")
	private DrivingLicenseRecognitionServcie drivingLicenseRecognitionServcie;

	/**
	 * 行驶证信息识别
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/recongnize", method = RequestMethod.POST)
	public BaseResponse recongnize(String file, HttpServletRequest request)
			throws IOException {
		if (StringUtils.isNotBlank(file)) {
			try {
				byte[] b = Base64.decode(file);
				if (b == null)
					return retEnumResponse(FileUpdateResponseEnum.code_1600);
				if (b.length > CommonAttributes.MAX_FILE_SIZE)
					return retEnumResponse(FileUpdateResponseEnum.code_1601);
				DrivingLicense drivingLicense = drivingLicenseRecognitionServcie
						.recognition(b);
				if (drivingLicense != null) {
					return returnResponse(SUCCESS_CODE, drivingLicense);
				} else {
					return retEnumResponse(DrivingLicenseResponseEnum.code_1300);
				}
			} catch (Exception e) {
				logger.error("行驶证识别失败，系统内容错误", e);
				return retEnumResponse(DrivingLicenseResponseEnum.code_1301);
			}

		} else {
			return retEnumResponse(DrivingLicenseResponseEnum.code_1302);
		}
	}

}
