package com.msds.km.entity;

import java.util.Date;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>MemberEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MemberEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 用户名 */
	private java.lang.String username;
	/** 密码 */
	private java.lang.String password;
	/** 昵称 */
	private java.lang.String name;
	/** 手机 */
	private java.lang.String phone;
	/** 性别 1男 2女 */
	private java.lang.Integer sex;
	/** 性格 */
	private java.lang.Integer role;
	/** 头像 */
	private java.lang.String ico;
	/** 省 */
	private java.lang.Integer province;
	/** 市 */
	private java.lang.Integer city;
	/** 区 */
	private java.lang.Integer area;
	/** 地址 */
	private java.lang.String address;
	/** 全地址 */
	private java.lang.String fullAddress;
	/** openId */
	private java.lang.String openId;

	private String provinceName;
	private String cityName;
	private String areaName;
	private String modelGroupName;
	private String license;
	private String vin;
	private Integer mileage;
	private Date buyDate;
	private String chassis;
	private Date lastServiceDate;
	private Integer modelId;
	private Integer memberId;
	private Integer memberModelId;

	private Integer shopId;
	private Integer seriesId;
	private Integer year;
	private String exhaustVolume;

	/**
	 * 下面字段用在历史服务列表
	 */
	private String engineType;
	private String engineNo;
	private String gearBoxType;
	private String gearBoxNo;
	private String checkDate;
	private String safeDate;

	private Boolean isEdit;

	private Integer carSex;
	private Integer carRole;

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
	 * @return the 用户名
	 */
	public java.lang.String getUsername() {
		return username;
	}

	/**
	 * @param 用户名
	 *            the username to set
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	/**
	 * @return the 密码
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/**
	 * @param 密码
	 *            the password to set
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	/**
	 * @return the 昵称
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @param 昵称
	 *            the name to set
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * @return the 手机
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * @param 手机
	 *            the phone to set
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * @return the 性别1男2女
	 */
	public java.lang.Integer getSex() {
		return sex;
	}

	/**
	 * @param 性别1男2女
	 *            the sex to set
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the 性格
	 */
	public java.lang.Integer getRole() {
		return role;
	}

	/**
	 * @param 性格
	 *            the role to set
	 */
	public void setRole(java.lang.Integer role) {
		this.role = role;
	}

	/**
	 * @return the 头像
	 */
	public java.lang.String getIco() {
		return ico;
	}

	/**
	 * @param 头像
	 *            the ico to set
	 */
	public void setIco(java.lang.String ico) {
		this.ico = ico;
	}

	/**
	 * @return the 省
	 */
	public java.lang.Integer getProvince() {
		return province;
	}

	/**
	 * @param 省
	 *            the province to set
	 */
	public void setProvince(java.lang.Integer province) {
		this.province = province;
	}

	/**
	 * @return the 市
	 */
	public java.lang.Integer getCity() {
		return city;
	}

	/**
	 * @param 市
	 *            the city to set
	 */
	public void setCity(java.lang.Integer city) {
		this.city = city;
	}

	/**
	 * @return the 区
	 */
	public java.lang.Integer getArea() {
		return area;
	}

	/**
	 * @param 区
	 *            the area to set
	 */
	public void setArea(java.lang.Integer area) {
		this.area = area;
	}

	/**
	 * @return the 地址
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * @param 地址
	 *            the address to set
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * @return the 全地址
	 */
	public java.lang.String getFullAddress() {
		return fullAddress;
	}

	/**
	 * @param 全地址
	 *            the fullAddress to set
	 */
	public void setFullAddress(java.lang.String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * @return the provinceName
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * @param provinceName
	 *            the provinceName to set
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the modelGroupName
	 */
	public String getModelGroupName() {
		return modelGroupName;
	}

	/**
	 * @param modelGroupName
	 *            the modelGroupName to set
	 */
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param license
	 *            the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin
	 *            the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the mileage
	 */
	public Integer getMileage() {
		return mileage;
	}

	/**
	 * @param mileage
	 *            the mileage to set
	 */
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the buyDate
	 */
	public Date getBuyDate() {
		return buyDate;
	}

	/**
	 * @param buyDate
	 *            the buyDate to set
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	/**
	 * @return the chassis
	 */
	public String getChassis() {
		return chassis;
	}

	/**
	 * @param chassis
	 *            the chassis to set
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	/**
	 * @return the lastServiceDate
	 */
	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	/**
	 * @param lastServiceDate
	 *            the lastServiceDate to set
	 */
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	/**
	 * @return the modelId
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * @param modelId
	 *            the modelId to set
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId
	 *            the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberModelId
	 */
	public Integer getMemberModelId() {
		return memberModelId;
	}

	/**
	 * @param memberModelId
	 *            the memberModelId to set
	 */
	public void setMemberModelId(Integer memberModelId) {
		this.memberModelId = memberModelId;
	}

	/**
	 * @return the shopId
	 */
	public Integer getShopId() {
		return shopId;
	}

	/**
	 * @param shopId
	 *            the shopId to set
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the seriesId
	 */
	public Integer getSeriesId() {
		return seriesId;
	}

	/**
	 * @param seriesId
	 *            the seriesId to set
	 */
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the exhaustVolume
	 */
	public String getExhaustVolume() {
		return exhaustVolume;
	}

	/**
	 * @param exhaustVolume
	 *            the exhaustVolume to set
	 */
	public void setExhaustVolume(String exhaustVolume) {
		this.exhaustVolume = exhaustVolume;
	}

	/**
	 * @return the 下面字段用在历史服务列表
	 */
	public String getEngineType() {
		return engineType;
	}

	/**
	 * @param 下面字段用在历史服务列表
	 *            the engineType to set
	 */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	/**
	 * @return the engineNo
	 */
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param engineNo
	 *            the engineNo to set
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return the gearBoxType
	 */
	public String getGearBoxType() {
		return gearBoxType;
	}

	/**
	 * @param gearBoxType
	 *            the gearBoxType to set
	 */
	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}

	/**
	 * @return the gearBoxNo
	 */
	public String getGearBoxNo() {
		return gearBoxNo;
	}

	/**
	 * @param gearBoxNo
	 *            the gearBoxNo to set
	 */
	public void setGearBoxNo(String gearBoxNo) {
		this.gearBoxNo = gearBoxNo;
	}

	/**
	 * @return the checkDate
	 */
	public String getCheckDate() {
		return checkDate;
	}

	/**
	 * @param checkDate
	 *            the checkDate to set
	 */
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return the safeDate
	 */
	public String getSafeDate() {
		return safeDate;
	}

	/**
	 * @param safeDate
	 *            the safeDate to set
	 */
	public void setSafeDate(String safeDate) {
		this.safeDate = safeDate;
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
	 * @return the openId
	 */
	public java.lang.String getOpenId() {
		return openId;
	}

	/**
	 * @param openId
	 *            the openId to set
	 */
	public void setOpenId(java.lang.String openId) {
		this.openId = openId;
	}

}
