package com.msds.km.reparifacoty.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msds.km.base.BaseController;
import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountItemModel;
import com.msds.km.response.BaseResponse;
 
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountItemController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller("RfSettleAccountItemController")
@RequestMapping("/rf/settleAccountItem")
public class SettleAccountItemController extends BaseController{
	
	
	/**
	 * 结算单明细
	 * @param settleSn
	 * @param offset
	 * @param size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public BaseResponse list(String settleSn ,Integer offset, Integer size, HttpServletRequest request) throws Exception {
		
		if(StringUtils.isEmpty(settleSn)){
			return FAILURE;
		}
		Integer companyId = this.getCompanyId(request);
		if(companyId == null){
			return FAILURE;
		}
		ListModel<SettleAccountItemModel> settleAccountItemModels = null;
	
		return returnResponse(SUCCESS_CODE, settleAccountItemModels);
	}

}