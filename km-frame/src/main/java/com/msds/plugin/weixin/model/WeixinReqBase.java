package com.msds.plugin.weixin.model;

/**
 * 微信请求基础类
 * 
 * @author Lilong
 * @date 2015年11月9日14:14:26
 * 
 */
public class WeixinReqBase {

	/**
	 * 微信获取信息令牌
	 */
	private String access_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
