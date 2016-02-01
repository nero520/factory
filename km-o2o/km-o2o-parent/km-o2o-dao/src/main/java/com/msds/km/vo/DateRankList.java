package com.msds.km.vo;

import java.util.List;


public class DateRankList extends BaseVo{

	private static final long serialVersionUID = -721535476275437635L;

	/**
	 * 修理厂信息
	 */
	private String factoryName;
	
	/**
	 * 按日期数据
	 */
	private List<DateRankVo> datalist;
	
	/**
	 * 修理厂摄像头链接
	 */
	private String url ;

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public List<DateRankVo> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<DateRankVo> datalist) {
		this.datalist = datalist;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
