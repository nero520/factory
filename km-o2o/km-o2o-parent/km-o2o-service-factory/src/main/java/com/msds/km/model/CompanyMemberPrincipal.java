package com.msds.km.model;

import java.io.Serializable;

/**
 * 身份信息
 * 
 */
public class CompanyMemberPrincipal implements Serializable {

	private static final long serialVersionUID = 5798882004228239559L;

	/** memberId */
	private Integer id;

	/** 用户名 */
	private String userName;
	
	/** 修理厂名称 */
	private String name;
	/** 直营店ID **/
	private String directShopId;
	/** 仓库ID(可能存在多个用,隔开) **/
	private String storeId;
	/**生成随机串*/
	private String token;
	//手机号码
	private String phone;
	
	public CompanyMemberPrincipal(){
		
	}
	public CompanyMemberPrincipal(Integer id, String username, String directShopId) {
		super();
		this.id = id;
		this.userName = username;
		this.directShopId = directShopId;
	}


	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return userName;
	}

	public String getDirectShopId() {
		return directShopId;
	}

	public void setDirectShopId(String directShopId) {
		this.directShopId = directShopId;
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}