package com.msds.km.vo;


public class DateRankVo extends BaseVo{

	private static final long serialVersionUID = -4718492388274071161L;

	/**
	 * 日期
	 */
	private String dateTime;
	
	/**
	 * 修理厂信息
	 */
	private String factoryName;
	
	/**
	 * 交车总数
	 */
	private Integer total ;
	
	/**
	 * 接车总数
	 */
	private Integer pickUpTotal;
	
	/**
	 * 交车总金额
	 */
	private Integer amount;
	
	/**
	 * 修理厂摄像头链接
	 */
	private String url ;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPickUpTotal() {
		return pickUpTotal;
	}

	public void setPickUpTotal(Integer pickUpTotal) {
		this.pickUpTotal = pickUpTotal;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
