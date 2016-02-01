package com.msds.km.message;

import com.msds.enums.DescriptionEnum;

/**
 * 订单接口返回信息定义
 * 
 * @ClassName OrderResponseEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月30日 上午9:42:03
 * 
 */
public enum ActivityNewResponseEnum implements DescriptionEnum {
	code_2100(2100, "活动未开始"),
	code_2101(2101, "活动已结束"),
	code_2102(2102, "活动优惠券、红包已领完"),
	;

	private int id;
	private String name;

	private ActivityNewResponseEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return name;
	}
}
