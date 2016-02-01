package com.msds.km.reparifacoty.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.MapiConstants;
import com.msds.km.model.CompanyMemberPrincipal;
import com.msds.km.response.BaseResponse;
import com.msds.util.RedisUtil;

/**
 * 
 * ClassName: LoginOutController 
 * @Description: 退出相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/rf/")
public class LogoutController extends BaseController {
	
	
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public BaseResponse  logout(HttpServletRequest request) {
		
		CompanyMemberPrincipal memberPrincipal = getCompanyInfo(request);
		if(memberPrincipal != null){
			RedisUtil.delValue(MapiConstants.TOKEN_PREFFIX+memberPrincipal.getToken());
//			RedisStore.delValue(MapiConstants.TOKEN_PREFFIX+String.valueOf(memberPrincipal.getId()));
			RedisUtil.lremove(MapiConstants.TOKEN_PREFFIX+String.valueOf(memberPrincipal.getId()), memberPrincipal.getToken());
		}
		return SUCCESSFUL;
	}
	
	
}
