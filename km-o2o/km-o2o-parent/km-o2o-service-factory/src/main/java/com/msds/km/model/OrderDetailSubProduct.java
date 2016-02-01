package com.msds.km.model;
/**
 * 订单详细商品信息
 * @author LiJingkun 
 * @date 2015年6月24日
 * @version 1.0
 */
public class OrderDetailSubProduct {
	/** 商品ID */
	private String productId;
	/** 商品名称 */
	private String productName;
	/** 图标 */
	private String icon;
	/** 数量 */
	private String quantity;
	/** 商场价格 */
	private String marketPrice;
	/** 康民价格 */
	private String kmprice;
	/**
	 * 获取  商品ID
	 * @return  productId  商品ID
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * 设置  商品ID
	 * @param  productId  商品ID
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 获取  商品名称
	 * @return  productName  商品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置  商品名称
	 * @param  productName  商品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取  图标
	 * @return  icon  图标
	 */
	public String getIcon() {
		return icon==null?"":icon;
	}
	/**
	 * 设置  图标
	 * @param  icon  图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取  数量
	 * @return  quantity  数量
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * 设置  数量
	 * @param  quantity  数量
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取  商场价格
	 * @return  marketPrice  商场价格
	 */
	public String getMarketPrice() {
		return marketPrice;
	}
	/**
	 * 设置  商场价格
	 * @param  marketPrice  商场价格
	 */
	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}
	/**
	 * 获取  康民价格
	 * @return  kmprice  康民价格
	 */
	public String getKmprice() {
		return kmprice==null?"":kmprice;
	}
	/**
	 * 设置  康民价格
	 * @param  kmprice  康民价格
	 */
	public void setKmprice(String kmprice) {
		this.kmprice = kmprice;
	}
	
}
