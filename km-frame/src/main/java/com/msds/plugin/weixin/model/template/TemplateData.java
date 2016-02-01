package com.msds.plugin.weixin.model.template;

/**
 * 模板参数值
 * 
 * @author Lilong
 * @date 2015年11月9日14:14:26
 * 
 */
public class TemplateData {

	private String value;

	private String color;

	public TemplateData(String value) {
		this.value = value;
		this.color = "#173177";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
