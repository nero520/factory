package com.msds.km.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.msds.km.common.MapiConstants;
import com.msds.km.entity.MemberEntity;
import com.msds.km.message.LoginResponseEnum;
import com.msds.km.model.CompanyMemberPrincipal;
import com.msds.km.response.BaseResponse;
import com.msds.util.JsonUtils;
import com.msds.util.RedisUtil;

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
//		HttpSession session = request.getSession();
//		MemberEntity member = (MemberEntity) session
//				.getAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO);
//		if (member != null) {
//			response.addHeader("Cache-Control", "no-store");
//			response.addHeader("Pragma", "no-cache");
//			return true;
//		} else {
//			response.addHeader("loginStatus", "accessDenied");
//			response.sendError(HttpServletResponse.SC_FORBIDDEN);
//			return false;
//		}
		String token = request.getHeader("token");
		CompanyMemberPrincipal memberPrincipal = null;
		if(StringUtils.isNotEmpty(token)){
			memberPrincipal = RedisUtil.getValue(MapiConstants.TOKEN_PREFFIX+token);
		}
		if(StringUtils.isEmpty(token) || memberPrincipal == null){
			PrintWriter out = response.getWriter();
			response.setHeader("Content-type", "text/html;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
			out.println(JsonUtils.toJson(new BaseResponse(String.valueOf(LoginResponseEnum.code_9999.getId()), LoginResponseEnum.code_9999.getName())));
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

}