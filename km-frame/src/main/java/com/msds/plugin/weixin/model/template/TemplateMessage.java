package com.msds.plugin.weixin.model.template;

import com.msds.plugin.weixin.model.WeixinReqBase;

/**
 * 模板消息封装
 * 
 * @author Lilong
 * @date 2015年11月9日14:14:26
 * 
 */
public class TemplateMessage extends WeixinReqBase {

	private String touser;

	private String template_id;

	private String url;

	private String topcolor;

	private TemplateParam data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	public TemplateParam getData() {
		return data;
	}

	public void setData(TemplateParam data) {
		this.data = data;
	}

}
