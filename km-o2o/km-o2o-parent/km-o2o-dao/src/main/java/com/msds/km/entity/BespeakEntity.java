package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakEntity<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-05-06 15:57:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class BespeakEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** ID */
	private java.lang.Integer id;
	/** 预约单号 */
	private java.lang.String bespeakSn;
	/** 车主问题描述 */
	private java.lang.String problem;
	/** 顾问建议方案说明 */
	private java.lang.String answer;
	/** 服务项目-顾问手动输入，在线存服务项目名称，用于显示 */
	private java.lang.String serviceContent;
	/** 总价 */
	private BigDecimal totalPrice;
	/** 预约时间 */
	private java.util.Date bespeakDate;
	/** 是否上午 1上午 0下午 */
	private java.lang.Integer isAm;
	/** 修理厂 */
	private java.lang.Integer companyId;
	/** 用户ID */
	private java.lang.Integer memberId;
	/** 车主车型id */
	private java.lang.Integer memberModelId;
	/** 操作人ID */
	private java.lang.Integer userId;
	/** 预约单类型：1顾问，2，在线 */
	private java.lang.Integer bespeakType;
	/** 预约单状态 1待确认 2已确认 3已取消 */
	private java.lang.Integer state;
	/** 行驶里程 */
	private java.lang.Integer mileage;
	/** 车牌 */
	private java.lang.String license;
	/** 车型全称 */
	private java.lang.String modelGroupName;
	/** vin */
	private java.lang.String vin;
	/** 来源 1通用 2微信 3web 4wap 5ios 6android */
	private java.lang.Integer source;
	/** 备注 */
	private java.lang.String remark;
	private Integer carSex;
	private Integer carRole;
	private String fullAddress;

	// 修理厂预约单使用
	private String region;
	/** 联系电话 */
	private String phone;
	/** 购买日期 */
	private Date buyDate;
	/** 上交保养日期 */
	private Date lastServiceDate;

	private String name;
	private Date startDate;
	private Date endDate;
	private Date nowDate;

	/** 修理厂名称 */
	private String companyName;
	/** 修理厂地址 */
	private String companyAddress;
	/** 修理厂电话 */
	private String companyTel;

	/** 车主联系姓名 */
	private String memberName;

	private Boolean isEdit;
	private String processJson;

	/** 大于开始日期 */
	private String afterDate;
	/** 小于结束日期 */
	private String beforeDate;

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
	 * @return the 预约单号
	 */
	public java.lang.String getBespeakSn() {
		return bespeakSn;
	}

	/**
	 * @param 预约单号
	 *            the bespeakSn to set
	 */
	public void setBespeakSn(java.lang.String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}

	/**
	 * @return the 车主问题描述
	 */
	public java.lang.String getProblem() {
		return problem;
	}

	/**
	 * @param 车主问题描述
	 *            the problem to set
	 */
	public void setProblem(java.lang.String problem) {
		this.problem = problem;
	}

	/**
	 * @return the 顾问建议方案说明
	 */
	public java.lang.String getAnswer() {
		return answer;
	}

	/**
	 * @param 顾问建议方案说明
	 *            the answer to set
	 */
	public void setAnswer(java.lang.String answer) {
		this.answer = answer;
	}

	/**
	 * @return the 服务项目-顾问手动输入，在线存服务项目名称，用于显示
	 */
	public java.lang.String getServiceContent() {
		return serviceContent;
	}

	/**
	 * @param 服务项目
	 *            -顾问手动输入，在线存服务项目名称，用于显示 the serviceContent to set
	 */
	public void setServiceContent(java.lang.String serviceContent) {
		this.serviceContent = serviceContent;
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
	 * @return the 预约时间
	 */
	public java.util.Date getBespeakDate() {
		return bespeakDate;
	}

	/**
	 * @param 预约时间
	 *            the bespeakDate to set
	 */
	public void setBespeakDate(java.util.Date bespeakDate) {
		this.bespeakDate = bespeakDate;
	}

	/**
	 * @return the 是否上午1上午0下午
	 */
	public java.lang.Integer getIsAm() {
		return isAm;
	}

	/**
	 * @param 是否上午1上午0下午
	 *            the isAm to set
	 */
	public void setIsAm(java.lang.Integer isAm) {
		this.isAm = isAm;
	}

	/**
	 * @return the 修理厂
	 */
	public java.lang.Integer getCompanyId() {
		return companyId;
	}

	/**
	 * @param 修理厂
	 *            the companyId to set
	 */
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the 用户ID
	 */
	public java.lang.Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param 用户ID
	 *            the memberId to set
	 */
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the 车主车型id
	 */
	public java.lang.Integer getMemberModelId() {
		return memberModelId;
	}

	/**
	 * @param 车主车型id
	 *            the memberModelId to set
	 */
	public void setMemberModelId(java.lang.Integer memberModelId) {
		this.memberModelId = memberModelId;
	}

	/**
	 * @return the 操作人ID
	 */
	public java.lang.Integer getUserId() {
		return userId;
	}

	/**
	 * @param 操作人ID
	 *            the userId to set
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the 预约单类型：1顾问，2，在线
	 */
	public java.lang.Integer getBespeakType() {
		return bespeakType;
	}

	/**
	 * @param 预约单类型
	 *            ：1顾问，2，在线 the bespeakType to set
	 */
	public void setBespeakType(java.lang.Integer bespeakType) {
		this.bespeakType = bespeakType;
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

	/**
	 * @return the 行驶里程
	 */
	public java.lang.Integer getMileage() {
		return mileage;
	}

	/**
	 * @param 行驶里程
	 *            the mileage to set
	 */
	public void setMileage(java.lang.Integer mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the 车牌
	 */
	public java.lang.String getLicense() {
		return license;
	}

	/**
	 * @param 车牌
	 *            the license to set
	 */
	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	/**
	 * @return the 车型全称
	 */
	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}

	/**
	 * @param 车型全称
	 *            the modelGroupName to set
	 */
	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	/**
	 * @return the vin
	 */
	public java.lang.String getVin() {
		return vin;
	}

	/**
	 * @param vin
	 *            the vin to set
	 */
	public void setVin(java.lang.String vin) {
		this.vin = vin;
	}

	/**
	 * @return the 来源1通用2微信3web4wap5ios6android
	 */
	public java.lang.Integer getSource() {
		return source;
	}

	/**
	 * @param 来源1通用2微信3web4wap5ios6android
	 *            the source to set
	 */
	public void setSource(java.lang.Integer source) {
		this.source = source;
	}

	/**
	 * @return the 备注
	 */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
	 * @param 备注
	 *            the remark to set
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * @return the carSex
	 */
	public Integer getCarSex() {
		return carSex;
	}

	/**
	 * @param carSex
	 *            the carSex to set
	 */
	public void setCarSex(Integer carSex) {
		this.carSex = carSex;
	}

	/**
	 * @return the carRole
	 */
	public Integer getCarRole() {
		return carRole;
	}

	/**
	 * @param carRole
	 *            the carRole to set
	 */
	public void setCarRole(Integer carRole) {
		this.carRole = carRole;
	}

	/**
	 * @return the fullAddress
	 */
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * @param fullAddress
	 *            the fullAddress to set
	 */
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the 联系电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param 联系电话
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the 购买日期
	 */
	public Date getBuyDate() {
		return buyDate;
	}

	/**
	 * @param 购买日期
	 *            the buyDate to set
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	/**
	 * @return the 上交保养日期
	 */
	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	/**
	 * @param 上交保养日期
	 *            the lastServiceDate to set
	 */
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the nowDate
	 */
	public Date getNowDate() {
		return nowDate;
	}

	/**
	 * @param nowDate
	 *            the nowDate to set
	 */
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	/**
	 * @return the 修理厂名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param 修理厂名称
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the 修理厂地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param 修理厂地址
	 *            the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the 修理厂电话
	 */
	public String getCompanyTel() {
		return companyTel;
	}

	/**
	 * @param 修理厂电话
	 *            the companyTel to set
	 */
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	/**
	 * @return the 车主联系姓名
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param 车主联系姓名
	 *            the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the isEdit
	 */
	public Boolean getIsEdit() {
		return isEdit;
	}

	/**
	 * @param isEdit
	 *            the isEdit to set
	 */
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	/**
	 * @return the processJson
	 */
	public String getProcessJson() {
		return processJson;
	}

	/**
	 * @param processJson
	 *            the processJson to set
	 */
	public void setProcessJson(String processJson) {
		this.processJson = processJson;
	}

	/**
	 * @return the 大于开始日期
	 */
	public String getAfterDate() {
		return afterDate;
	}

	/**
	 * @param 大于开始日期
	 *            the afterDate to set
	 */
	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}

	/**
	 * @return the 小于结束日期
	 */
	public String getBeforeDate() {
		return beforeDate;
	}

	/**
	 * @param 小于结束日期
	 *            the beforeDate to set
	 */
	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}

}
