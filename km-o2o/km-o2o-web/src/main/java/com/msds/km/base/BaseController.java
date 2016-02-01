package com.msds.km.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.base.controller.BasisController;
import com.msds.enums.DescriptionEnum;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.AdminEntity;
import com.msds.km.entity.FactoryEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.response.BaseResponse;

/**
 * 基类Controller
 * 
 * @ClassName BaseController
 * @Description TODO
 * @author LiLong
 * @date 2014年11月21日 下午3:15:14
 * 
 */
@ResponseBody
public class BaseController extends BasisController {

	/** 通用成功code */
	protected static final String SUCCESS_CODE = "0000";
	/** 通用失败code */
	protected static final String FAILURE_CODE = "9999";

	/** 通用成功消息 */
	protected static final BaseResponse SUCCESSFUL = new BaseResponse(
			SUCCESS_CODE);;
	/** 通用失败消息 */
	protected static final BaseResponse FAILURE = new BaseResponse(FAILURE_CODE);;

	/**
	 * 获取当前用户主要信息
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected MemberEntity getMemberInfo(HttpServletRequest request) {
		return (MemberEntity) request.getSession().getAttribute(
				CommonAttributes.MEMBER_PRINCIPAL_INFO);
	}

	/**
	 * 获取当前用户ID
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected Integer getMemberId(HttpServletRequest request) {
		MemberEntity memberEntity = getMemberInfo(request);
		if (memberEntity != null) {
			return memberEntity.getId();
		}
		return null;
	}
	
	
	/**
	 * 获取当前用户主要信息
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected AdminEntity getAdminInfo(HttpServletRequest request) {
		return (AdminEntity) request.getSession().getAttribute(
				CommonAttributes.MEMBER_PRINCIPAL_INFO);
	}

	/**
	 * 获取当前用户ID
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected Integer getAdminId(HttpServletRequest request) {
		AdminEntity memberEntity = getAdminInfo(request);
		if (memberEntity != null) {
			return memberEntity.getId();
		}
		return null;
	}
	
	/**
	 * 获取当前修理厂用户主要信息
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected FactoryEntity getFactoryInfo(HttpServletRequest request) {
		return (FactoryEntity) request.getSession().getAttribute(
				CommonAttributes.FACTORY_PRINCIPAL_INFO);
	}

	/**
	 * 获取当前修理厂用户ID
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected Integer getFactoryId(HttpServletRequest request) {
		FactoryEntity memberEntity = getFactoryInfo(request);
		if (memberEntity != null) {
			return memberEntity.getId();
		}
		return null;
	}


	/**
	 * 返回信息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	protected BaseResponse returnResponse(String code, Object msg) {
		return new BaseResponse(code, msg);
	}

	/**
	 * 返回成功信息
	 * 
	 * @param msg
	 * @return
	 */
	protected BaseResponse returnSuccessResponse(Object msg) {
		return new BaseResponse(SUCCESS_CODE, msg);
	}

	/**
	 * 返回枚举信息
	 * 
	 * @param descriptionEnum
	 * @return
	 */
	protected BaseResponse retEnumResponse(DescriptionEnum descriptionEnum) {
		return new BaseResponse(String.valueOf(descriptionEnum.getId()),
				descriptionEnum.getName());
	}

	/**
	 * 异常处理
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	protected BaseResponse exceptionHandler(Exception e) {
		logger.error("发现业务层未有效处理的异常,请完善!", e);
		return FAILURE;
	}
}