package com.msds.km.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.MemberEntity;
import com.msds.km.message.LoginResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberService;
import com.msds.util.AppConstants;
import com.msds.util.CheckUtils;
import com.msds.util.RedisUtil;
import com.msds.util.SmsUtil;

/**
 * 
 * ClassName: CommonController 
 * @Description: 公共请求信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	@Autowired
	private AppConstants appConstants;
	
	@Autowired
	private MemberService memberService;

	
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public BaseResponse sendCode(MemberEntity memberEntity,
			HttpServletRequest request){
		//1.校验手机号格式
		if(!(memberEntity !=null && memberEntity.getPhone() != null && CheckUtils.checkPhone(memberEntity.getPhone()))){
		 return super.retEnumResponse(LoginResponseEnum.code_1000);
		}
		//1.1判断是否已经发送了验证码
		
		//1.2判断验证码一定时间内是否超过发送次数
		if(!SmsUtil.checkCount(memberEntity.getPhone())){			
			return super.retEnumResponse(LoginResponseEnum.code_1001);
		}
		//2.判断是否数据库存在手机号
		try {
		    
		   //3.生产验证码并且存储在redis,以及通过手机发送验证码
//			Integer code = SmsUtil.sendVerifyCode(memberEntity.getPhone(), appConstants.getSmsContent(), appConstants.getSmsUrl());
//			RedisUtil.setValue(CommonAttributes.Login_SendCode+memberEntity.getPhone(), String.valueOf(code),30,TimeUnit.MINUTES);//30分钟失效
		} catch (Exception e) {
			logger.error("类方法：sendCode发生异常：{}",e.getMessage());
			return super.retEnumResponse(LoginResponseEnum.code_1003);
		}
		
		return SUCCESSFUL;
	}

}
