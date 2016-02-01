package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>FactoryEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2016-01-14 14:24:13 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class FactoryEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**name*/
	private java.lang.String name;
	/**password*/
	private java.lang.String password;
	/**factory_name*/
	private java.lang.String factoryName;
	/**修理厂摄像头链接*/
	private java.lang.String url;

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
	 *@return: java.lang.String  name
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  name
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  password
	 */
	public java.lang.String getPassword(){
		return this.password;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  password
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  factory_name
	 */
	public java.lang.String getFactoryName(){
		return this.factoryName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  factory_name
	 */
	public void setFactoryName(java.lang.String factoryName){
		this.factoryName = factoryName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修理厂摄像头链接
	 */
	public java.lang.String getUrl(){
		return this.url;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修理厂摄像头链接
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
}

