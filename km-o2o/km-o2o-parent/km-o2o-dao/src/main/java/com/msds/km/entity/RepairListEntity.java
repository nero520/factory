package com.msds.km.entity;

import java.util.Date;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>RepairListEntity<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-10-26 15:57:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class RepairListEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** ID */
	private java.lang.Integer id;
	private java.lang.String repairNo;
	private java.lang.String repairType;
	private java.lang.String cardNo;
	private java.lang.String memberName;
	private java.lang.String memberPhone;
	private java.lang.String license;
	private java.lang.String modelGroupName	;
	private java.lang.String vin;
	private java.lang.String mileage;
	private java.lang.String settleType;
	private String settleAmount;
	private java.util.Date settleDate;
	private Date startDate;
	private Date endDate;
	
	/** 大于开始日期 */
	private String afterDate;
	/** 小于结束日期 */
	private String beforeDate;
	
	
	
	public String getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}
	public String getBeforeDate() {
		return beforeDate;
	}
	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}
	private String filePath;
	
	
	
	
	
	
	

	public java.lang.String getMileage() {
		return mileage;
	}
	public void setMileage(java.lang.String mileage) {
		this.mileage = mileage;
	}
	public String getSettleAmount() {
		return settleAmount;
	}
	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(java.lang.String repairNo) {
		this.repairNo = repairNo;
	}
	public java.lang.String getRepairType() {
		return repairType;
	}
	public void setRepairType(java.lang.String repairType) {
		this.repairType = repairType;
	}
	public java.lang.String getCardNo() {
		return cardNo;
	}
	public void setCardNo(java.lang.String cardNo) {
		this.cardNo = cardNo;
	}
	public java.lang.String getMemberName() {
		return memberName;
	}
	public void setMemberName(java.lang.String memberName) {
		this.memberName = memberName;
	}
	public java.lang.String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(java.lang.String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public java.lang.String getLicense() {
		return license;
	}
	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}
	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	public java.lang.String getVin() {
		return vin;
	}
	public void setVin(java.lang.String vin) {
		this.vin = vin;
	}
	public java.lang.String getSettleType() {
		return settleType;
	}
	public void setSettleType(java.lang.String settleType) {
		this.settleType = settleType;
	}
	public java.util.Date getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(java.util.Date settleDate) {
		this.settleDate = settleDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	

}
