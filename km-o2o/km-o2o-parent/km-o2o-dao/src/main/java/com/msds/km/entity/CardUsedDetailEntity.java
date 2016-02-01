package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CardUsedDetailEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CardUsedDetailEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 会员卡号 */
	private java.lang.String cardNo;
	/** 使用时间 */
	private java.util.Date usedDate;
	/** 使用类型 */
	private java.lang.String usedName;
	/** 类型 1充值 2消费 */
	private java.lang.String type;
	/** 使用描述 */
	private java.lang.String usedDescription;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer ID
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 会员卡号
	 */
	public java.lang.String getCardNo() {
		return this.cardNo;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 会员卡号
	 */
	public void setCardNo(java.lang.String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 使用时间
	 */
	public java.util.Date getUsedDate() {
		return this.usedDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 使用时间
	 */
	public void setUsedDate(java.util.Date usedDate) {
		this.usedDate = usedDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 使用类型
	 */
	public java.lang.String getUsedName() {
		return this.usedName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 使用类型
	 */
	public void setUsedName(java.lang.String usedName) {
		this.usedName = usedName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 使用描述
	 */
	public java.lang.String getUsedDescription() {
		return this.usedDescription;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 使用描述
	 */
	public void setUsedDescription(java.lang.String usedDescription) {
		this.usedDescription = usedDescription;
	}

	/**
	 * @return the 类型1充值2消费
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * @param 类型1充值2消费
	 *            the type to set
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}
}
