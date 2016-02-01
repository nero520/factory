package com.msds.km.model;

import java.io.Serializable;

/**
 * 预约单信息
 * @author hebiao
 */
public class BespeakModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**预约单号 */
	private String bespeakSn;
	
	/** 预约时间 */
	private String bespeakDate;
	
	/** 车牌号 */
	private String license;
	
	/** 联系电话 */
	private String phone;
	
	/** 车型组合名称(品牌车系排量年份) */
	private String modelGroupName;
	
	/**状态名称 */
	private String stateName;

	public String getBespeakSn() {
		return bespeakSn;
	}

	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}

	public String getBespeakDate() {
		return bespeakDate;
	}

	public void setBespeakDate(String bespeakDate) {
		this.bespeakDate = bespeakDate;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getModelGroupName() {
		return modelGroupName;
	}

	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
