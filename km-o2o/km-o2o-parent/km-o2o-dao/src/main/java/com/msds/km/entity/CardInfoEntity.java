package com.msds.km.entity;

import java.math.BigDecimal;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CardInfoEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:48 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CardInfoEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 会员卡号 */
	private java.lang.String cardNo;
	/** 开卡时间 */
	private java.util.Date beginDate;
	/** 余额 */
	private BigDecimal balance;
	/** 总消费 */
	private BigDecimal totalCost;
	/** 会员电话 */
	private java.lang.String custPhone;
	/** 会员名称 */
	private java.lang.String custName;
	/** 会员卡图片路径 */
	private java.lang.String cardImage;

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
	 * @return: java.util.Date 开卡时间
	 */
	public java.util.Date getBeginDate() {
		return this.beginDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 开卡时间
	 */
	public void setBeginDate(java.util.Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 余额
	 */
	public BigDecimal getBalance() {
		return this.balance;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 余额
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 总消费
	 */
	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 总消费
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 会员电话
	 */
	public java.lang.String getCustPhone() {
		return this.custPhone;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 会员电话
	 */
	public void setCustPhone(java.lang.String custPhone) {
		this.custPhone = custPhone;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 会员名称
	 */
	public java.lang.String getCustName() {
		return this.custName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 会员名称
	 */
	public void setCustName(java.lang.String custName) {
		this.custName = custName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 会员卡图片路径
	 */
	public java.lang.String getCardImage() {
		return this.cardImage;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 会员卡图片路径
	 */
	public void setCardImage(java.lang.String cardImage) {
		this.cardImage = cardImage;
	}
}
