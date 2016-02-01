package com.msds.km.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 行驶证模型信息。该模型以08版标准的行驶证为准。
 *
 */
@XStreamAlias("drivingLicense")  
public class DrivingLicense  implements Serializable{
	
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
	private String cardno;
	
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
	@XStreamAlias("enginePN")
	private String engineNO;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCardno() {
		return cardno;
	}


	public void setCardno(String cardno) {
		this.cardno = cardno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getUseCharacte() {
		return useCharacte;
	}


	public void setUseCharacte(String useCharacte) {
		this.useCharacte = useCharacte;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getEngineNO() {
		return engineNO;
	}


	public void setEngineNO(String engineNO) {
		this.engineNO = engineNO;
	}


	@Override
	public String toString() {
		return "DrivingLicense [name=" + name + ", cardno=" + cardno
				+ ", address=" + address + ", registerDate=" + registerDate
				+ ", issueDate=" + issueDate + ", vehicleType=" + vehicleType
				+ ", useCharacte=" + useCharacte + ", model=" + model
				+ ", vin=" + vin + ", engineNO=" + engineNO + "]";
	}
	
}
