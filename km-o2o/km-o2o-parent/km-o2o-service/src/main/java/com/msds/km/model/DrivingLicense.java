package com.msds.km.model;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 行驶证模型信息
 * 
 */
public class DrivingLicense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5295049337034051048L;

	/**
	 * 行驶证所有者姓名。
	 */
	private String name;

	/**
	 * 车牌号码
	 */
	@JacksonXmlProperty(localName = "cardno")
	private String license;

	/**
	 * 住址
	 */
	private String address;

	/**
	 * 注册日期
	 */
	private String registerDate;

	/**
	 * 发证日期
	 */
	private String issueDate;

	/**
	 * 车辆类型
	 */
	private String vehicleType;

	/**
	 * 使用性质
	 */
	private String useCharacte;

	/**
	 * 品牌型号
	 */
	private String model;

	/**
	 * 车辆识别代码
	 */
	private String vin;

	/**
	 * 发动机号码
	 */
	@JacksonXmlProperty(localName = "enginePN")
	private String engineNO;

	/**
	 * @return the 行驶证所有者姓名。
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param 行驶证所有者姓名
	 *            。 the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the 车牌号码
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * @param 车牌号码
	 *            the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * @return the 住址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param 住址
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the 注册日期
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param 注册日期
	 *            the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the 发证日期
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * @param 发证日期
	 *            the issueDate to set
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the 车辆类型
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param 车辆类型
	 *            the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the 使用性质
	 */
	public String getUseCharacte() {
		return useCharacte;
	}

	/**
	 * @param 使用性质
	 *            the useCharacte to set
	 */
	public void setUseCharacte(String useCharacte) {
		this.useCharacte = useCharacte;
	}

	/**
	 * @return the 品牌型号
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param 品牌型号
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the 车辆识别代码
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param 车辆识别代码
	 *            the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the 发动机号码
	 */
	public String getEngineNO() {
		return engineNO;
	}

	/**
	 * @param 发动机号码
	 *            the engineNO to set
	 */
	public void setEngineNO(String engineNO) {
		this.engineNO = engineNO;
	}

}
