package com.msds.km.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.FactoryEntity;
import com.msds.km.message.FactoryResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.FactoryService;

/**
 * 
 * <br>
 * <b>功能：</b>FactoryController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:03 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/factory") 
public class FactoryController extends BaseController{
	
	
	@Autowired
	private FactoryService factoryService; 
	
	
    /**
     * 登录授权
     * @param name
     * @param password
     * @param request
     * @return
     */
	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public BaseResponse authorize(String name,String password,
			HttpServletRequest request) {

		try {	
			FactoryEntity entity = new FactoryEntity();
			entity.setPassword(DigestUtils.md5Hex(password));
			entity.setName(name);
			FactoryEntity factoryEntity =  factoryService.findByFatory(entity);
			HttpSession session = request.getSession();
			if (factoryEntity != null) {
			session.setAttribute(CommonAttributes.FACTORY_PRINCIPAL_INFO,
					factoryEntity);					
			} else {
			return super.retEnumResponse(FactoryResponseEnum.code_1000);
			}
		} catch (Exception e) {
			logger.error("类方法：authorize，登录数据库异常{}", e.getMessage());
			return super.retEnumResponse(FactoryResponseEnum.code_1001);
		}
		return SUCCESSFUL;
	}
	
	
	 /**
	  * 查询登录用户信息
	  * @param request
	  * @return
	  */
	@RequestMapping(value = "/queryUser", method = RequestMethod.GET)
	public BaseResponse queryUser(HttpServletRequest request) {
		FactoryEntity entity = super.getFactoryInfo(request);
		entity.setPassword("");
		return  returnSuccessResponse(entity);
	}

}
