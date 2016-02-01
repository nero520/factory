package com.msds.km.model;

import java.io.Serializable;

/**
 * 预约单服务项目
 * @author hebiao
 *
 */
public class ServiceItemModel  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**服务分类 */
	private String serviceCategory;
	/**服务内容*/
	private String serviceName;
	/**价格 */
	private String price;
	
	public String getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
