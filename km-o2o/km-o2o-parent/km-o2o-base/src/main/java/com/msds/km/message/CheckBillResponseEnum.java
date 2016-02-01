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
public enum CheckBillResponseEnum implements DescriptionEnum {
	code_2000(2000, "未填写车辆信息"),
	code_2001(2001, "无档案"),
	code_2002(2002, "未填写VIN码"),
	;

	private int id;
	private String name;

	private CheckBillResponseEnum(int id, String name) {
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
