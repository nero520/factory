package com.msds.km.entity;

import java.util.Date;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ActivityNewEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**活动编号*/
	private java.lang.String activitySn;
	/**活动名称*/
	private java.lang.String activityName;
	/**开始日期*/
	private java.util.Date startDate;
	/**结束日期*/
	private java.util.Date endDate;
	/**活动说明*/
	private java.lang.String description;
	/**活动范围*/
	private java.lang.String activityScope;
	/**每人限量*/
	private java.lang.Integer personLimit;
	/**活动限量标识 0不限 1限*/
	private java.lang.Integer activityLimitState;
	/**活动限量数量*/
	private java.lang.Integer activityLimitNum;
	/**活动类型 1红包 2优惠券*/
	private java.lang.Integer type;
	/**活动状态 0暂停 1开始*/
	private java.lang.Integer state;
	/**操作人*/
	private java.lang.Integer operator;
	
	
	/** 优惠券ids */
	private String couponIds;
	/** 活动下已选的优惠编号，逗号分隔 */
	private String CouponSns;
	/** 活动类型名称 */
	private String typeName;
	/** 状态名称 */
	private String stateName;
	/** 限量标识名称 */
	private String limitStateName;
	/** 范围名称 */
	private String scopeName;
	/** 小于开始日期 */
	private Date beforeDate;
	/** 大于结束日期 */
	private Date afterDate;
	/** 当前日期 */
	private Date nowDate;
	
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
	 *@return: java.lang.String  活动编号
	 */
	public java.lang.String getActivitySn(){
		return this.activitySn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动编号
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
	 *@return: java.lang.String  活动说明
	 */
	public java.lang.String getDescription(){
		return this.description;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动说明
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动范围
	 */
	public java.lang.String getActivityScope(){
		return this.activityScope;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动范围
	 */
	public void setActivityScope(java.lang.String activityScope){
		this.activityScope = activityScope;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  每人限量
	 */
	public java.lang.Integer getPersonLimit(){
		return this.personLimit;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  每人限量
	 */
	public void setPersonLimit(java.lang.Integer personLimit){
		this.personLimit = personLimit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动限量标识 0不限 1限
	 */
	public java.lang.Integer getActivityLimitState(){
		return this.activityLimitState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动限量标识 0不限 1限
	 */
	public void setActivityLimitState(java.lang.Integer activityLimitState){
		this.activityLimitState = activityLimitState;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动限量数量
	 */
	public java.lang.Integer getActivityLimitNum(){
		return this.activityLimitNum;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动限量数量
	 */
	public void setActivityLimitNum(java.lang.Integer activityLimitNum){
		this.activityLimitNum = activityLimitNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动类型 1红包 2优惠券
	 */
	public java.lang.Integer getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动类型 1红包 2优惠券
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动状态 0暂停 1开始
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动状态 0暂停 1开始
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  操作人
	 */
	public java.lang.Integer getOperator(){
		return this.operator;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  操作人
	 */
	public void setOperator(java.lang.Integer operator){
		this.operator = operator;
	}
	/**
	 * 获取  优惠券ids
	 * @return  couponIds  优惠券ids
	 */
	public String getCouponIds() {
		return couponIds;
	}
	/**
	 * 设置  优惠券ids
	 * @param  couponIds  优惠券ids
	 */
	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}
	/**
	 * 获取  couponSns
	 * @return  couponSns  couponSns
	 */
	public String getCouponSns() {
		return CouponSns;
	}
	/**
	 * 设置  couponSns
	 * @param  couponSns  couponSns
	 */
	public void setCouponSns(String couponSns) {
		CouponSns = couponSns;
	}
	/**
	 * 获取  活动类型名称
	 * @return  typeName  活动类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置  活动类型名称
	 * @param  typeName  活动类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取  小于开始日期
	 * @return  beforeDate  小于开始日期
	 */
	public Date getBeforeDate() {
		return beforeDate;
	}
	/**
	 * 设置  小于开始日期
	 * @param  beforeDate  小于开始日期
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
	/**
	 * 获取  状态名称
	 * @return  stateName  状态名称
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * 设置  状态名称
	 * @param  stateName  状态名称
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * 获取  限量标识名称
	 * @return  limitStateName  限量标识名称
	 */
	public String getLimitStateName() {
		return limitStateName;
	}
	/**
	 * 设置  限量标识名称
	 * @param  limitStateName  限量标识名称
	 */
	public void setLimitStateName(String limitStateName) {
		this.limitStateName = limitStateName;
	}
	/**
	 * 获取  范围名称
	 * @return  scopeName  范围名称
	 */
	public String getScopeName() {
		return scopeName;
	}
	/**
	 * 设置  范围名称
	 * @param  scopeName  范围名称
	 */
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	/**
	 * 获取  当前日期
	 * @return  nowDate  当前日期
	 */
	public Date getNowDate() {
		return nowDate;
	}
	/**
	 * 设置  当前日期
	 * @param  nowDate  当前日期
	 */
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	
}

