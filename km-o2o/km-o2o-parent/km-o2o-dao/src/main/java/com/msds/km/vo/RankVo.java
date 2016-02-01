package com.msds.km.vo;


public class RankVo extends BaseVo{


	private static final long serialVersionUID = -6321844847440086711L;

	/**
	 * 修理厂ID
	 */
	private Integer id;
	
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
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPickUpTotal() {
		return pickUpTotal;
	}

	public void setPickUpTotal(Integer pickUpTotal) {
		this.pickUpTotal = pickUpTotal;
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	
	
	
}
