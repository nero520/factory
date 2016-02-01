package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;


public enum CouponStateEnum implements DescriptionEnum {

	stop(0, "暂停"),
	start(1, "开始"),
	
	;

	private int id;
	private String name;

	private CouponStateEnum(int id, String name) {
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

	public static CouponStateEnum getEnumById(int id) {
		CouponStateEnum[] values = CouponStateEnum.values();
		for (CouponStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		CouponStateEnum[] values = CouponStateEnum.values();
		for (CouponStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
