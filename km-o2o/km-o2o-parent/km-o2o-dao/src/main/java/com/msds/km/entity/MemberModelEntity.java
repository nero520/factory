package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>MemberModelEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-30 14:31:12 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MemberModelEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**ID*/
	private java.lang.Integer id;
	/**会员id*/
	private java.lang.Integer memberId;
	/**车型ID*/
	private java.lang.Integer modelId;
	/**车型组合名称(品牌车系排量年份)*/
	private java.lang.String modelGroupName;
	/**是否默认*/
	private java.lang.Integer defaultFlag;
	/**所属区域*/
	private java.lang.String region;
	/**车牌号*/
	private java.lang.String license;
	/**里程数*/
	private java.lang.Integer mileage;
	/**购买日期*/
	private java.util.Date buyDate;
	/**车架号*/
	private java.lang.String vin;
	/**行驶证所有人*/
	private java.lang.String name;
	/**行驶证的住址*/
	private java.lang.String address;
	/**注册日期*/
	private java.lang.String registerDate;
	/**发证日期*/
	private java.lang.String issueDate;
	/**车辆类型*/
	private java.lang.String vehicleType;
	/**使用性质*/
	private java.lang.String useCharacte;
	/**品牌型号*/
	private java.lang.String model;
	/**发动机号码*/
	private java.lang.String engineNo;
	/**发动机型号*/
	private java.lang.String engineType;
	/**变速箱类型*/
	private java.lang.String gearBoxType;
	/**变速箱号*/
	private java.lang.String gearBoxNo;
	/**上次保养时间*/
	private java.util.Date lastServiceDate;
	/**上次顾问*/
	private java.lang.String lastServiceMan;
	/**年检到期日期*/
	private java.util.Date checkDate;
	/**保险到期时间*/
	private java.util.Date safeDate;
	/**底盘号*/
	private java.lang.String chassis;
	/**车昵称*/
	private java.lang.String nickName;
	/**车性别 1男 0女*/
	private java.lang.Integer sex;
	/**车角色*/
	private java.lang.Integer role;
	/**车头像*/
	private java.lang.String icon;

	/**
	 * 车品牌LOGO
	 */
	private String logo;

	/**
	 * @return the ID
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * @param ID the id to set
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
	 * @param 会员id the memberId to set
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
	 * @param 车型ID the modelId to set
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
	 * @param 车型组合名称(品牌车系排量年份) the modelGroupName to set
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
	 * @param 是否默认 the defaultFlag to set
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
	 * @param 所属区域 the region to set
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
	 * @param 车牌号 the license to set
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
	 * @param 里程数 the mileage to set
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
	 * @param 购买日期 the buyDate to set
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
	 * @param 车架号 the vin to set
	 */
	public void setVin(java.lang.String vin) {
		this.vin = vin;
	}

	/**
	 * @return the 行驶证所有人
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @param 行驶证所有人 the name to set
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * @return the 行驶证的住址
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * @param 行驶证的住址 the address to set
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * @return the 注册日期
	 */
	public java.lang.String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param 注册日期 the registerDate to set
	 */
	public void setRegisterDate(java.lang.String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the 发证日期
	 */
	public java.lang.String getIssueDate() {
		return issueDate;
	}

	/**
	 * @param 发证日期 the issueDate to set
	 */
	public void setIssueDate(java.lang.String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the 车辆类型
	 */
	public java.lang.String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param 车辆类型 the vehicleType to set
	 */
	public void setVehicleType(java.lang.String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the 使用性质
	 */
	public java.lang.String getUseCharacte() {
		return useCharacte;
	}

	/**
	 * @param 使用性质 the useCharacte to set
	 */
	public void setUseCharacte(java.lang.String useCharacte) {
		this.useCharacte = useCharacte;
	}

	/**
	 * @return the 品牌型号
	 */
	public java.lang.String getModel() {
		return model;
	}

	/**
	 * @param 品牌型号 the model to set
	 */
	public void setModel(java.lang.String model) {
		this.model = model;
	}

	/**
	 * @return the 发动机号码
	 */
	public java.lang.String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param 发动机号码 the engineNo to set
	 */
	public void setEngineNo(java.lang.String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return the 发动机型号
	 */
	public java.lang.String getEngineType() {
		return engineType;
	}

	/**
	 * @param 发动机型号 the engineType to set
	 */
	public void setEngineType(java.lang.String engineType) {
		this.engineType = engineType;
	}

	/**
	 * @return the 变速箱类型
	 */
	public java.lang.String getGearBoxType() {
		return gearBoxType;
	}

	/**
	 * @param 变速箱类型 the gearBoxType to set
	 */
	public void setGearBoxType(java.lang.String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}

	/**
	 * @return the 变速箱号
	 */
	public java.lang.String getGearBoxNo() {
		return gearBoxNo;
	}

	/**
	 * @param 变速箱号 the gearBoxNo to set
	 */
	public void setGearBoxNo(java.lang.String gearBoxNo) {
		this.gearBoxNo = gearBoxNo;
	}

	/**
	 * @return the 上次保养时间
	 */
	public java.util.Date getLastServiceDate() {
		return lastServiceDate;
	}

	/**
	 * @param 上次保养时间 the lastServiceDate to set
	 */
	public void setLastServiceDate(java.util.Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	/**
	 * @return the 上次顾问
	 */
	public java.lang.String getLastServiceMan() {
		return lastServiceMan;
	}

	/**
	 * @param 上次顾问 the lastServiceMan to set
	 */
	public void setLastServiceMan(java.lang.String lastServiceMan) {
		this.lastServiceMan = lastServiceMan;
	}

	/**
	 * @return the 年检到期日期
	 */
	public java.util.Date getCheckDate() {
		return checkDate;
	}

	/**
	 * @param 年检到期日期 the checkDate to set
	 */
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return the 保险到期时间
	 */
	public java.util.Date getSafeDate() {
		return safeDate;
	}

	/**
	 * @param 保险到期时间 the safeDate to set
	 */
	public void setSafeDate(java.util.Date safeDate) {
		this.safeDate = safeDate;
	}

	/**
	 * @return the 底盘号
	 */
	public java.lang.String getChassis() {
		return chassis;
	}

	/**
	 * @param 底盘号 the chassis to set
	 */
	public void setChassis(java.lang.String chassis) {
		this.chassis = chassis;
	}

	/**
	 * @return the 车昵称
	 */
	public java.lang.String getNickName() {
		return nickName;
	}

	/**
	 * @param 车昵称 the nickName to set
	 */
	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the 车性别1男0女
	 */
	public java.lang.Integer getSex() {
		return sex;
	}

	/**
	 * @param 车性别1男0女 the sex to set
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the 车角色
	 */
	public java.lang.Integer getRole() {
		return role;
	}

	/**
	 * @param 车角色 the role to set
	 */
	public void setRole(java.lang.Integer role) {
		this.role = role;
	}

	/**
	 * @return the 车头像
	 */
	public java.lang.String getIcon() {
		return icon;
	}

	/**
	 * @param 车头像 the icon to set
	 */
	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	/**
	 * @return the 车品牌LOGO
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param 车品牌LOGO the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
