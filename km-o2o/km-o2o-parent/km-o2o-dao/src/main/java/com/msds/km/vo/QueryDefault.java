package com.msds.km.vo;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>QueryDefault<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015年11月6日14:20:30 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 */
public class QueryDefault extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** ID */
	private java.lang.Integer id;
	/** 会员id */
	private java.lang.Integer memberId;
	/** 车型ID */
	private java.lang.Integer modelId;
	/** 车型组合名称(品牌车系排量年份) */
	private java.lang.String modelGroupName;
	/** 是否默认 */
	private java.lang.Integer defaultFlag;
	/** 所属区域 */
	private java.lang.String region;
	/** 车牌号 */
	private java.lang.String license;
	/** 里程数 */
	private java.lang.Integer mileage;
	/** 购买日期 */
	private java.util.Date buyDate;
	/** 车架号 */
	private java.lang.String vin;
	/** 消费标识 */
	private Boolean consumeFlag;
	/** 微信绑定标识 */
	private Boolean WxBindFlag;

	/**
	 * @return the ID
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * @param ID
	 *            the id to set
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * @return the 会员id
	 */
	public java.lang.Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param 会员id
	 *            the memberId to set
	 */
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the 车型ID
	 */
	public java.lang.Integer getModelId() {
		return modelId;
	}

	/**
	 * @param 车型ID
	 *            the modelId to set
	 */
	public void setModelId(java.lang.Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the 车型组合名称(品牌车系排量年份)
	 */
	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}

	/**
	 * @param 车型组合名称
	 *            (品牌车系排量年份) the modelGroupName to set
	 */
	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	/**
	 * @return the 是否默认
	 */
	public java.lang.Integer getDefaultFlag() {
		return defaultFlag;
	}

	/**
	 * @param 是否默认
	 *            the defaultFlag to set
	 */
	public void setDefaultFlag(java.lang.Integer defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	/**
	 * @return the 所属区域
	 */
	public java.lang.String getRegion() {
		return region;
	}

	/**
	 * @param 所属区域
	 *            the region to set
	 */
	public void setRegion(java.lang.String region) {
		this.region = region;
	}

	/**
	 * @return the 车牌号
	 */
	public java.lang.String getLicense() {
		return license;
	}

	/**
	 * @param 车牌号
	 *            the license to set
	 */
	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	/**
	 * @return the 里程数
	 */
	public java.lang.Integer getMileage() {
		return mileage;
	}

	/**
	 * @param 里程数
	 *            the mileage to set
	 */
	public void setMileage(java.lang.Integer mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the 购买日期
	 */
	public java.util.Date getBuyDate() {
		return buyDate;
	}

	/**
	 * @param 购买日期
	 *            the buyDate to set
	 */
	public void setBuyDate(java.util.Date buyDate) {
		this.buyDate = buyDate;
	}

	/**
	 * @return the 车架号
	 */
	public java.lang.String getVin() {
		return vin;
	}

	/**
	 * @param 车架号
	 *            the vin to set
	 */
	public void setVin(java.lang.String vin) {
		this.vin = vin;
	}

	/**
	 * @return the 消费标识
	 */
	public Boolean getConsumeFlag() {
		return consumeFlag;
	}

	/**
	 * @param 消费标识
	 *            the consumeFlag to set
	 */
	public void setConsumeFlag(Boolean consumeFlag) {
		this.consumeFlag = consumeFlag;
	}

	/**
	 * @return the wxBindFlag
	 */
	public Boolean getWxBindFlag() {
		return WxBindFlag;
	}

	/**
	 * @param wxBindFlag
	 *            the wxBindFlag to set
	 */
	public void setWxBindFlag(Boolean wxBindFlag) {
		WxBindFlag = wxBindFlag;
	}

}
