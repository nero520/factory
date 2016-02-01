package com.msds.plugin.weixin.model.template;

/**
 * 微信模板返回
 * 
 * @author Lilong
 * @date 2015年11月9日14:14:26
 */
public class SendMessageResponse {

	private String errcode;
	private String errmsg;
	private String msgid;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMsgId() {
		return msgid;
	}

	public void setMsgId(String msgid) {
		this.msgid = msgid;
	}

	@Override
	public String toString() {
		return "SendMessageResponse [errcode=" + errcode + ", errmsg=" + errmsg
				+ ", msg_id=" + msgid + "]";
	}

}
