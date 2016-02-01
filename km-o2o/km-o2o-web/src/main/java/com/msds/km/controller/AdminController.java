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
import com.msds.km.entity.AdminEntity;
import com.msds.km.message.AdminResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.AdminService;
 
/**
 * 
 * <br>
 * <b>功能：</b>AdminController<br>
 * <b>作者：</b>xiaoxiong<br>
 * <b>日期：</b> 2015-12-24 11:04:44 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/admin") 
public class AdminController extends BaseController{
	
	@Autowired
	private AdminService adminService; 
	
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
		// 1.校验账号格式
//		if (entity == null || !CheckUtils.checkPhone(entity.getName())) {
//			return super.retEnumResponse(LoginResponseEnum.code_1000);
//		}
		// 2.登录并且存储在session中;
		try {	
			AdminEntity entity = new AdminEntity();
			entity.setPassword(DigestUtils.md5Hex(password));
			entity.setName(name);
			AdminEntity adminEntity =  adminService.findByAdmin(entity);
			HttpSession session = request.getSession();
			if (adminEntity != null) {
			session.setAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO,
							adminEntity);					
			} else {
			return super.retEnumResponse(AdminResponseEnum.code_1000);
			}
		} catch (Exception e) {
			logger.error("类方法：authorize，登录数据库异常{}", e.getMessage());
			return super.retEnumResponse(AdminResponseEnum.code_1001);
		}
		return SUCCESSFUL;
	}

	/**
	 * 判断登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/isLogin")
	public BaseResponse isLogin(HttpServletRequest request) {
		Integer memberId = super.getAdminId(request);
		if (memberId == null) {
			return FAILURE;
		}
		return SUCCESSFUL;
	}

	

}
