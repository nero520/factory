package com.msds.km.reparifacoty.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msds.km.base.BaseController;
import com.msds.km.message.OrderResponseEnum;
import com.msds.km.model.ListModel;
import com.msds.km.model.OrderDetailModel;
import com.msds.km.model.OrderModel;
import com.msds.km.response.BaseResponse;

/**
 * 修理厂前台 订单Controller
 * @author hebiao
 *
 */
@Controller("RfOrderController")
@RequestMapping("/rf/order")
public class OrderController extends BaseController{

	
	/**
	 * 订单列表
	 * @param orderState
	 * @param offset
	 * @param size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public BaseResponse list(Integer orderState,String license,Integer offset, Integer size, HttpServletRequest request) throws Exception {
		Integer companyId = this.getCompanyId(request);
		if(companyId == null){
			return FAILURE;
		}
		ListModel<OrderModel> orderModels = null;
		
		
		return returnResponse(SUCCESS_CODE, orderModels);
	}
	
	/**
	 * 订单详细信息
	 * @param orderSn
	 * @return
	 * @throws Exception 
	 * BaseResponse
	 */
	@RequestMapping(value = "/detail")
	public BaseResponse detail(String orderSn, HttpServletRequest request) throws Exception {
		OrderDetailModel orderDetail = new OrderDetailModel();
		Integer companyId = super.getCompanyId(request);
		if (StringUtils.isBlank(orderSn)) {
			return retEnumResponse(OrderResponseEnum.code_1301);
		}
	
		return returnResponse(SUCCESS_CODE, orderDetail);
	}

	/**
	 * 修理厂确认订单
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/confirm")
	public BaseResponse confirm(String orderSn, HttpServletRequest request) {
		// 检验信息
		if (StringUtils.isBlank(orderSn)) {
			return retEnumResponse(OrderResponseEnum.code_1301);
		}
		Integer companyId = super.getCompanyId(request);

		return SUCCESSFUL;
	}
	
	/**
	 * 修理厂修改所属订单
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/update")
	public BaseResponse update(String orderSn,String license, String vin, String phone, HttpServletRequest request) {
		// 检验信息
		if (StringUtils.isBlank(orderSn)) {
			return retEnumResponse(OrderResponseEnum.code_1301);
		}
		Integer companyId = super.getCompanyId(request);
		
		return SUCCESSFUL;
	}
}