package com.msds.km.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CouponEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CouponEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**优惠券编号*/
	private java.lang.String couponSn;
	/**优惠名称*/
	private java.lang.String couponName;
	/**优惠类型*/
	private java.lang.Integer type;
	/**开始日期*/
	private java.util.Date startDate;
	/**结束日期*/
	private java.util.Date endDate;
	/**使用说明*/
	private java.lang.String instructions;
	/**状态 0暂停 1可用*/
	private java.lang.Integer state;
	/**操作人ID*/
	private java.lang.Integer operator;
	
	/****** 显示使用 *****begin */
	/** 类型名称 */
	private String typeName;
	/****** 显示使用 *****end */
	
	/******** 条件使用 *****begin**/
	/** 小于开始日期 */
	private Date beforeDate;
	/** 大于结束日期 */
	private Date afterDate;
	/******** 条件使用 *****end**/

		/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	public java.lang.Integer getId(){
		return this.id;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠券编号
	 */
	public java.lang.String getCouponSn(){
		return this.couponSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠券编号
	 */
	public void setCouponSn(java.lang.String couponSn){
		this.couponSn = couponSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠名称
	 */
	public java.lang.String getCouponName(){
		return this.couponName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠名称
	 */
	public void setCouponName(java.lang.String couponName){
		this.couponName = couponName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  优惠类型
	 */
	public java.lang.Integer getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  优惠类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期
	 */
	public java.util.Date getStartDate(){
		return this.startDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期
	 */
	public java.util.Date getEndDate(){
		return this.endDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期
	 */
	public void setEndDate(java.util.Date endDate){
		this.endDate = endDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  使用说明
	 */
	public java.lang.String getInstructions(){
		return this.instructions;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  使用说明
	 */
	public void setInstructions(java.lang.String instructions){
		this.instructions = instructions;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态 0暂停 1可用
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态 0暂停 1可用
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  操作人ID
	 */
	public java.lang.Integer getOperator(){
		return this.operator;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  操作人ID
	 */
	public void setOperator(java.lang.Integer operator){
		this.operator = operator;
	}
	/**
	 * 获取  类型名称
	 * @return  typeName  类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置  类型名称
	 * @param  typeName  类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取  显示使用
	 * @return  beforeDate  显示使用
	 */
	public Date getBeforeDate() {
		return beforeDate;
	}
	/**
	 * 设置  显示使用
	 * @param  beforeDate  显示使用
	 */
	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}
	/**
	 * 获取  大于结束日期
	 * @return  afterDate  大于结束日期
	 */
	public Date getAfterDate() {
		return afterDate;
	}
	/**
	 * 设置  大于结束日期
	 * @param  afterDate  大于结束日期
	 */
	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}
	
}

