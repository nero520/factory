package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 13:45:55 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MaintenanceHistoryEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**VIN码*/
	private java.lang.String vin;
	/**品牌*/
	private java.lang.String brand;
	/**车型*/
	private java.lang.String model;
	/**报告时间*/
	private java.util.Date reportTime;
	/**生产商*/
	private java.lang.String producer;
	/**变速器*/
	private java.lang.String transmission;
	/**排气量*/
	private java.lang.String displacement;
	/**结构部件*/
	private java.lang.String structure;
	/**维修次数*/
	private java.lang.String maintenanceTimes;
	/**安全气囊*/
	private java.lang.String srs;
	/**维保周期*/
	private java.lang.String maintenancePeriod;
	/**召回记录*/
	private java.lang.String recallRecord;
	/**最大量程数*/
	private java.lang.String maxRange;
	/**操作人*/
	private java.lang.Integer operator;

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
	 *@return: java.lang.String  VIN码
	 */
	public java.lang.String getVin(){
		return this.vin;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  VIN码
	 */
	public void setVin(java.lang.String vin){
		this.vin = vin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌
	 */
	public java.lang.String getBrand(){
		return this.brand;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌
	 */
	public void setBrand(java.lang.String brand){
		this.brand = brand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型
	 */
	public java.lang.String getModel(){
		return this.model;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型
	 */
	public void setModel(java.lang.String model){
		this.model = model;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报告时间
	 */
	public java.util.Date getReportTime(){
		return this.reportTime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报告时间
	 */
	public void setReportTime(java.util.Date reportTime){
		this.reportTime = reportTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产商
	 */
	public java.lang.String getProducer(){
		return this.producer;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产商
	 */
	public void setProducer(java.lang.String producer){
		this.producer = producer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变速器
	 */
	public java.lang.String getTransmission(){
		return this.transmission;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变速器
	 */
	public void setTransmission(java.lang.String transmission){
		this.transmission = transmission;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排气量
	 */
	public java.lang.String getDisplacement(){
		return this.displacement;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排气量
	 */
	public void setDisplacement(java.lang.String displacement){
		this.displacement = displacement;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结构部件
	 */
	public java.lang.String getStructure(){
		return this.structure;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结构部件
	 */
	public void setStructure(java.lang.String structure){
		this.structure = structure;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维修次数
	 */
	public java.lang.String getMaintenanceTimes(){
		return this.maintenanceTimes;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维修次数
	 */
	public void setMaintenanceTimes(java.lang.String maintenanceTimes){
		this.maintenanceTimes = maintenanceTimes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安全气囊
	 */
	public java.lang.String getSrs(){
		return this.srs;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安全气囊
	 */
	public void setSrs(java.lang.String srs){
		this.srs = srs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维保周期*/
	public java.lang.String getMaintenancePeriod(){
		return this.maintenancePeriod;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维保周期
	 */
	public void setMaintenancePeriod(java.lang.String maintenancePeriod){
		this.maintenancePeriod = maintenancePeriod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  召回记录
	 */
	public java.lang.String getRecallRecord(){
		return this.recallRecord;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  召回记录
	 */
	public void setRecallRecord(java.lang.String recallRecord){
		this.recallRecord = recallRecord;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最大量程数
	 */
	public java.lang.String getMaxRange(){
		return this.maxRange;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最大量程数
	 */
	public void setMaxRange(java.lang.String maxRange){
		this.maxRange = maxRange;
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
}

