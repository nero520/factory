package com.msds.km.reparifacoty.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msds.km.base.BaseController;
import com.msds.km.common.MapiConstants;
import com.msds.km.entity.SettleAccountEntity;

import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountModel;
import com.msds.km.response.BaseResponse;

 
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller("RfSettleAccountController")
@RequestMapping("/rf/settleAccount")
public class SettleAccountController extends BaseController{
	
	/**
	 * 结算列表
	 * @param settleState 1待结算 2已结算
	 * @param offset
	 * @param size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public BaseResponse list(Integer settleState ,Integer offset, Integer size, HttpServletRequest request) throws Exception {
		
		if(settleState == null){
			return FAILURE;
		}
		Integer companyId = this.getCompanyId(request);
		if(companyId == null){
			return FAILURE;
		}
		ListModel<SettleAccountModel> settleAccountModels = null;
		
		return returnResponse(SUCCESS_CODE, settleAccountModels);
	}
	
	
	/**
	 * 确认结算单
	 * @param settleSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/confirm")
	public BaseResponse confirm(String settleSn, HttpServletRequest request) throws Exception {
		if(StringUtils.isEmpty(settleSn)){
			return FAILURE;
		}
		Integer companyId = this.getCompanyId(request);
		if(companyId == null){
			return FAILURE;
		}
		
		
		return SUCCESSFUL;
	}
	

}