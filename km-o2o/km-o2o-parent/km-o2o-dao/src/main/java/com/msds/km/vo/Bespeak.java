package com.msds.km.vo;

import java.math.BigDecimal;

/**
 * 预约单数据包装类
 * 
 * @ClassName Order
 * @Description TODO
 * @author hebiao
 * @date 2015年4月27日 下午4:01:49
 * 
 */
public class Bespeak extends BaseVo {
	private static final long serialVersionUID = -5692739824088574357L;
	// 预约单号
	private String bespeakSn;
	// 创建时间
	private String createDate;
	// 初步方案
	private String answer;
	// 预约时间
	private String bespeakDate;
	// 修理厂名称
	private String companyName;
	// 服务名称
	private String serviceName;
	/** 预约单类型：1顾问，2，在线 */
	private Integer bespeakType;
	/** 总价 */
	private BigDecimal totalPrice;
	/** 预约单状态 1待确认 2已确认 3已取消 */
	private java.lang.Integer state;

	public String getBespeakSn() {
		return bespeakSn;
	}

	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}

	public String getCreateDate() {
		return createDate == null ? "" : createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getAnswer() {
		return answer == null ? "" : answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getBespeakDate() {
		return bespeakDate == null ? "" : bespeakDate;
	}

	public void setBespeakDate(String bespeakDate) {
		this.bespeakDate = bespeakDate;
	}

	public String getCompanyName() {
		return companyName == null ? "" : companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the 服务名称
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param 服务名称
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the 预约单类型：1顾问，2，在线
	 */
	public Integer getBespeakType() {
		return bespeakType;
	}

	/**
	 * @param 预约单类型
	 *            ：1顾问，2，在线 the bespeakType to set
	 */
	public void setBespeakType(Integer bespeakType) {
		this.bespeakType = bespeakType;
	}

	/**
	 * @return the 总价
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param 总价
	 *            the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the 预约单状态1待确认2已确认3已取消
	 */
	public java.lang.Integer getState() {
		return state;
	}

	/**
	 * @param 预约单状态1待确认2已确认3已取消
	 *            the state to set
	 */
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

}
