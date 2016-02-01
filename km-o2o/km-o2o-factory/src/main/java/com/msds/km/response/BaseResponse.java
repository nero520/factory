package com.msds.km.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5049643673054601032L;

	/**
	 * 返回码
	 */
	private String code;

	/**
	 * 返回信息
	 */
	private Object msg;

	public BaseResponse() {
	}

	public BaseResponse(String code) {
		this.code = code;
	}

	public BaseResponse(String code, Object msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
