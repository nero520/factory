package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryDetailEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 16:48:44 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MaintenanceHistoryDetailEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**vin*/
	private java.lang.String vin;
	/**保养日期*/
	private java.util.Date maintenanceDate;
	/**公里数*/
	private java.lang.String mileage;
	/**类型*/
	private java.lang.String type;
	/**维修内容*/
	private java.lang.String maintenanceContent;
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
	 *@return: java.lang.String  vin
	 */
	public java.lang.String getVin(){
		return this.vin;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  vin
	 */
	public void setVin(java.lang.String vin){
		this.vin = vin;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  保养日期
	 */
	public java.util.Date getMaintenanceDate(){
		return this.maintenanceDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  保养日期
	 */
	public void setMaintenanceDate(java.util.Date maintenanceDate){
		this.maintenanceDate = maintenanceDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公里数
	 */
	public java.lang.String getMileage(){
		return this.mileage;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公里数
	 */
	public void setMileage(java.lang.String mileage){
		this.mileage = mileage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */
	public java.lang.String getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(java.lang.String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维修内容
	 */
	public java.lang.String getMaintenanceContent(){
		return this.maintenanceContent;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维修内容
	 */
	public void setMaintenanceContent(java.lang.String maintenanceContent){
		this.maintenanceContent = maintenanceContent;
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

