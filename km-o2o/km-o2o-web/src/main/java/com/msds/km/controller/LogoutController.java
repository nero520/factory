package com.msds.km.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.response.BaseResponse;

/**
 * 
 * ClassName: LoginOutController 
 * @Description: 退出相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/logout")
public class LogoutController extends BaseController {
	
	
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/out", method = RequestMethod.POST)
	public BaseResponse  isLogin(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO);
		Integer memberId = super.getMemberId(request);
		if(memberId == null){
			return 	SUCCESSFUL;
		}
		return FAILURE;
	}
	
	
}
