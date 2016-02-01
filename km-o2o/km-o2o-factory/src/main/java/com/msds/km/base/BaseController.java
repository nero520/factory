package com.msds.km.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.base.controller.BasisController;
import com.msds.common.DataList;
import com.msds.enums.DescriptionEnum;
import com.msds.km.common.CommonAttributes;
import com.msds.km.common.MapiConstants;
import com.msds.km.entity.MemberEntity;
import com.msds.km.model.CompanyMemberPrincipal;
import com.msds.km.response.BaseResponse;
import com.msds.util.RedisUtil;

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
	protected static final BaseResponse SUCCESSFUL = new BaseResponse(SUCCESS_CODE,"操作成功");;
	/** 通用失败消息 */
	protected static final BaseResponse FAILURE = new BaseResponse(FAILURE_CODE,"操作失败");;

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
	 * 返回列表数据
	 * 
	 * @param total
	 * @param data
	 * @return
	 */
	public static DataList returnDataGrid(Integer total, List data) {
		return new DataList(total, data);
	}
	
	/**
	 * 获取当前用户主要信息
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected CompanyMemberPrincipal getCompanyInfo(HttpServletRequest request) {
		String token = request.getHeader("token");
		CompanyMemberPrincipal memberPrincipal = null;
		if(StringUtils.isNotEmpty(token)){
			memberPrincipal = RedisUtil.getValue(MapiConstants.TOKEN_PREFFIX+token);
			if(memberPrincipal != null){//继续设置有效期续命
				RedisUtil.expire(MapiConstants.TOKEN_PREFFIX+token, MapiConstants.EXPIRE_DATE, TimeUnit.DAYS);
				RedisUtil.expire(MapiConstants.TOKEN_PREFFIX+String.valueOf(memberPrincipal.getId()), MapiConstants.EXPIRE_DATE, TimeUnit.DAYS);
			}
		}
		String version = request.getHeader("version");
		String imei = request.getHeader("imei");
		String osType = request.getHeader("osType");
		logger.info("token is : " + token + ",osType is : " + osType + ",version is : "+ version + ", imei is : " + imei);
		return memberPrincipal;
	}

	/**
	 * 获取当前用户ID
	 * 
	 * @Description session中
	 * @param request
	 * @return
	 * @return Principal
	 */
	protected Integer getCompanyId(HttpServletRequest request) {
		CompanyMemberPrincipal memberPrincipal = getCompanyInfo(request);
		if (memberPrincipal != null) {
			return memberPrincipal.getId();
		}
		return null;
	}
	
	/**
	 * 获得当前系统类型 
	 * @see OsTypeEnum
	 * @param request
	 * @return
	 */
	protected Integer getOsType(HttpServletRequest request) {
		String osType = request.getHeader("osType");
		if(StringUtils.isEmpty(osType)){
			return null;
		}
		return new Integer(osType);
	}
	
	/**
	 * 获得token
	 * @param request
	 * @return
	 */
	protected String getToken(HttpServletRequest request) {
		String token = request.getHeader("token");
		return token;
	}
}