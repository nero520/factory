package com.msds.km.reparifacoty.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.common.MapiConstants;
import com.msds.km.model.CompanyMemberPrincipal;
import com.msds.km.service.VersionMaxService;
import com.msds.util.RedisUtil;

/**
 * Controller - 登录控制
 * 
 */
@Controller
@RequestMapping("/rf/token")
public class TokenController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VersionMaxService versionMaxService;

	/**
	 * 校验token是否有效
	 */
	@RequestMapping(value="/expired")
	@ResponseBody
	public Object expired(HttpServletRequest request) {
		String token = getToken(request);
		Map<String ,Boolean> resultMap = new HashMap<String ,Boolean>(); 
		boolean expired = false;
		if(StringUtils.isEmpty(token)){//已经过期
			expired = true;
		}
		CompanyMemberPrincipal memberPrincipal = RedisUtil.getValue(MapiConstants.TOKEN_PREFFIX+token);
		if(memberPrincipal == null){
			expired = true;
		}
		resultMap.put("expired", expired);
		return this.returnResponse(SUCCESS_CODE,resultMap);
	}

}