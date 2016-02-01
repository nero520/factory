package com.msds.km.reparifacoty.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.message.VersionResponseEnum;
import com.msds.km.model.VersionModel;
import com.msds.km.service.VersionMaxService;

/**
 * Controller - 版本升级
 * 
 */
@Controller
@RequestMapping("/rf/version")
public class VersionController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VersionMaxService versionMaxService;

	/**
	 * 当前版本
	 */
	@RequestMapping(value="/current")
	@ResponseBody
	public Object current(HttpServletRequest request) {
		VersionModel versionModel = null;
		try {
			versionModel = versionMaxService.getCurrentVersionByOsType(getOsType(request));
		} catch (Exception e) {
			logger.error("/version/current.action throw excetion,msg : " + e);
			return this.retEnumResponse(VersionResponseEnum.code_1800);
		}
		if(versionModel == null){
			return  this.retEnumResponse(VersionResponseEnum.code_1801);
		}
		return this.returnResponse(SUCCESS_CODE,versionModel);
	}

}