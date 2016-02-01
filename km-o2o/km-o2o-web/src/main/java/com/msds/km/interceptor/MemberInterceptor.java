package com.msds.km.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.AdminEntity;
import com.msds.km.entity.FactoryEntity;

/**
 * 登录拦截器
 * 
 * @ClassName MemberInterceptor
 * @Description TODO
 * @author LiLong
 * @date 2014年12月6日 上午11:36:08
 * 
 */
public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		FactoryEntity factory = (FactoryEntity) session
				.getAttribute(CommonAttributes.FACTORY_PRINCIPAL_INFO);
		AdminEntity member = (AdminEntity) session
				.getAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO);
		if (member != null || factory != null) {
			response.addHeader("Cache-Control", "no-store");
			response.addHeader("Pragma", "no-cache");
			return true;
		} else {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

}