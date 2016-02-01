package com.msds.km.model;

import java.util.List;

/**
 * 订单详细信息返回值model类
 * @author LiJingkun 
 * @date 2015年6月24日
 * @version 1.0
 */
public class OrderDetailModel {
	/** 订单编号 */
	private String orderSn;
	/** 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成 */
	private String orderStateName;
	/** 确认标志 true:可确认 false:不可确认 */
	private boolean confirmFlag;
	/** 服务时间 */
	private String serviceTime;
	/** 工时费 */
	private String maintenance;
	/** 车牌 */
	private String license;
	/** 车型 */
	private String modelGroupName;
	/** 车主、联系人 */
	private String contact;
	/** 联系电话 */
	private String phone;
	/** 支付方式 */
	private String paymentMethod;
	/** 支付时间 */
	private String paymentDate;
	/** 支付金额 */
	private String amount;
	/** 备注*/
	private String remark;
	private String vin;
	/** 商品列表 */
	private List<OrderDetailSubProduct> productList;
	/**
	 * 获取  订单编号
	 * @return  orderSn  订单编号
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * 设置  订单编号
	 * @param  orderSn  订单编号
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * 获取  订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成
	 * @return  orderStateName  订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成
	 */
	public String getOrderStateName() {
		return orderStateName;
	}
	/**
	 * 设置  订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成
	 * @param  orderStateName  订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成
	 */
	public void setOrderStateName(String orderStateName) {
		this.orderStateName = orderStateName;
	}
	/**
	 * 获取  确认标志true:可确认false:不可确认
	 * @return  confirmFlag  确认标志true:可确认false:不可确认
	 */
	public boolean isConfirmFlag() {
		return confirmFlag;
	}
	/**
	 * 设置  确认标志true:可确认false:不可确认
	 * @param  confirmFlag  确认标志true:可确认false:不可确认
	 */
	public void setConfirmFlag(boolean confirmFlag) {
		this.confirmFlag = confirmFlag;
	}
	/**
	 * 获取  服务时间
	 * @return  serviceTime  服务时间
	 */
	public String getServiceTime() {
		return serviceTime;
	}
	/**
	 * 设置  服务时间
	 * @param  serviceTime  服务时间
	 */
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	/**
	 * 获取  工时费
	 * @return  maintenance  工时费
	 */
	public String getMaintenance() {
		return maintenance;
	}
	/**
	 * 设置  工时费
	 * @param  maintenance  工时费
	 */
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}
	/**
	 * 获取  车牌
	 * @return  license  车牌
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * 设置  车牌
	 * @param  license  车牌
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * 获取  车型
	 * @return  modelGroupName  车型
	 */
	public String getModelGroupName() {
		return modelGroupName;
	}
	/**
	 * 设置  车型
	 * @param  modelGroupName  车型
	 */
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	/**
	 * 获取  车主、联系人
	 * @return  contact  车主、联系人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置  车主、联系人
	 * @param  contact  车主、联系人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取  联系电话
	 * @return  phone  联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置  联系电话
	 * @param  phone  联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取  支付方式
	 * @return  paymentMethod  支付方式
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * 设置  支付方式
	 * @param  paymentMethod  支付方式
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * 获取  支付时间
	 * @return  paymentDate  支付时间
	 */
	public String getPaymentDate() {
		return paymentDate==null?"":paymentDate;
	}
	/**
	 * 设置  支付时间
	 * @param  paymentDate  支付时间
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * 获取  支付金额
	 * @return  amount  支付金额
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置  支付金额
	 * @param  amount  支付金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取  商品列表
	 * @return  productList  商品列表
	 */
	public List<OrderDetailSubProduct> getProductList() {
		return productList;
	}
	/**
	 * 设置  商品列表
	 * @param  productList  商品列表
	 */
	public void setProductList(List<OrderDetailSubProduct> productList) {
		this.productList = productList;
	}
	public String getRemark() {
		return remark==null?"":remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
}
