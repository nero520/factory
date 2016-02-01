package com.msds.km.model;

import java.io.Serializable;

/**
 * 订单信息--订单列表接口使用
 * @author hebiao
 */
public class OrderModel implements Serializable {
	private static final long serialVersionUID = 8914106249693836150L;
	
	/** 订单编号 */
	private String orderSn;
	/** 服务时间 */
	private String serviceTime;
	/** 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成 */
	private String orderStateName;
	/** 联系电话 */
	private String phone;
	/** 服务名称 */
	private String serviceName;
	/** 车型组合名称(品牌车系排量年份) */
	private String modelGroupName;
	/** 车牌号 */
	private String license;
	/** 实际价格 */
	private String amount;
	
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public String getOrderStateName() {
		return orderStateName == null ? "" : orderStateName;
	}
	public void setOrderStateName(String orderStateName) {
		this.orderStateName = orderStateName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getServiceName() {
		return serviceName == null ? "" : serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getModelGroupName() {
		return modelGroupName;
	}
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getAmount() {
		return amount == null ? "0.00" : amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	
}
