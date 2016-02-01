package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>FactoryCarEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class FactoryCarEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**卡号*/
	private java.lang.String cardNo;
	/**车牌号*/
	private java.lang.String license;
	/**amount*/
	private BigDecimal amount;
	/**状态  1、接车   2、交车*/
	private java.lang.Integer state;
	/**修理厂ID*/
	private java.lang.Integer factoryId;
	/**修理厂名称*/
	private java.lang.String factoryName;

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
	 *@return: java.lang.String  卡号
	 */
	public java.lang.String getCardNo(){
		return this.cardNo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卡号
	 */
	public void setCardNo(java.lang.String cardNo){
		this.cardNo = cardNo;
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
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  amount
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  amount
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态  1、接车   2、交车
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态  1、接车   2、交车
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  修理厂ID
	 */
	public java.lang.Integer getFactoryId(){
		return this.factoryId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修理厂ID
	 */
	public void setFactoryId(java.lang.Integer factoryId){
		this.factoryId = factoryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修理厂名称
	 */
	public java.lang.String getFactoryName(){
		return this.factoryName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修理厂名称
	 */
	public void setFactoryName(java.lang.String factoryName){
		this.factoryName = factoryName;
	}
}

