package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CardLogEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-25 17:22:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CardLogEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**card_no*/
	private java.lang.String cardNo;
	/**opeartor*/
	private java.lang.String opeartor;
	/**1.接车；2.结束*/
	private java.lang.String state;

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
	 *@return: java.lang.String  card_no
	 */
	public java.lang.String getCardNo(){
		return this.cardNo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  card_no
	 */
	public void setCardNo(java.lang.String cardNo){
		this.cardNo = cardNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  opeartor
	 */
	public java.lang.String getOpeartor(){
		return this.opeartor;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  opeartor
	 */
	public void setOpeartor(java.lang.String opeartor){
		this.opeartor = opeartor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  1.接车；2.结束
	 */
	public java.lang.String getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  1.接车；2.结束
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
}

