package com.msds.km.entity;

import java.util.Date;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>MemberTicketEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-28 16:57:48 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MemberTicketEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**优惠码*/
	private java.lang.String promotionCode;
	/**优惠券名称*/
	private java.lang.String couponName;
	/**优惠券编号*/
	private java.lang.String couponSn;
	/**活动的SN*/
	private java.lang.String activitySn;
	/**活动名称*/
	private java.lang.String activityName;
	/**活动类型 1红包 2优惠券*/
	private java.lang.Integer privilegeType;
	/** 开始时间*/
	private java.util.Date startTime;
	/**过期时间*/
	private java.util.Date expirationTime;
	/**0：未使用1：使用*/
	private java.lang.Integer state;
	/**手机号*/
	private java.lang.String phone;
	/**车牌号*/
	private java.lang.String license;
	/**车型*/
	private java.lang.String carType;
	
	/** 状态名称 */
	private String stateName;
	/** 活动状态名称 */
	private String privilegeTypeName;
	/** 小于开始日期 */
	private Date beforeDate;
	/** 大于结束日期 */
	private Date afterDate;

	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getPrivilegeTypeName() {
		return privilegeTypeName;
	}
	public void setPrivilegeTypeName(String privilegeTypeName) {
		this.privilegeTypeName = privilegeTypeName;
	}
	public Date getBeforeDate() {
		return beforeDate;
	}
	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}
	public Date getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  start_time
	 */
	public java.util.Date getStartTime(){
		return this.startTime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  start_time
	 */
	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}
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
	 *@return: java.lang.String  优惠码
	 */
	public java.lang.String getPromotionCode(){
		return this.promotionCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠码
	 */
	public void setPromotionCode(java.lang.String promotionCode){
		this.promotionCode = promotionCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠券名称
	 */
	public java.lang.String getCouponName(){
		return this.couponName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠券名称
	 */
	public void setCouponName(java.lang.String couponName){
		this.couponName = couponName;
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
	 *@return: java.lang.String  活动的SN
	 */
	public java.lang.String getActivitySn(){
		return this.activitySn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动的SN
	 */
	public void setActivitySn(java.lang.String activitySn){
		this.activitySn = activitySn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动名称
	 */
	public java.lang.String getActivityName(){
		return this.activityName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动名称
	 */
	public void setActivityName(java.lang.String activityName){
		this.activityName = activityName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动类型 1红包 2优惠券
	 */
	public java.lang.Integer getPrivilegeType(){
		return this.privilegeType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动类型 1红包 2优惠券
	 */
	public void setPrivilegeType(java.lang.Integer privilegeType){
		this.privilegeType = privilegeType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  过期时间
	 */
	public java.util.Date getExpirationTime(){
		return this.expirationTime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  过期时间
	 */
	public void setExpirationTime(java.util.Date expirationTime){
		this.expirationTime = expirationTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  0：未使用1：使用
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  0：未使用1：使用
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */
	public java.lang.String getPhone(){
		return this.phone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */
	public java.lang.String getLicense(){
		return this.license;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setLicense(java.lang.String license){
		this.license = license;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型
	 */
	public java.lang.String getCarType(){
		return this.carType;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型
	 */
	public void setCarType(java.lang.String carType){
		this.carType = carType;
	}
}

