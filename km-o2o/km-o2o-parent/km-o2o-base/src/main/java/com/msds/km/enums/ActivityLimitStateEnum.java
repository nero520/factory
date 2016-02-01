package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 活动限量状态
 * 
 * @author 
 * @date 2015年010月22日
 */
public enum ActivityLimitStateEnum implements DescriptionEnum {
	/**
	 * 不限
	 */
	noAstrict(0, "不限"),
	/**
	 * 限
	 */
	astrict(1, "限量") ;
	
	
	private int id;
	private String name;

	private ActivityLimitStateEnum(int id, String name) {
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

	public static ActivityLimitStateEnum getEnumById(int id) {
		ActivityLimitStateEnum[] values = ActivityLimitStateEnum.values();
		for (ActivityLimitStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ActivityLimitStateEnum[] values = ActivityLimitStateEnum.values();
		for (ActivityLimitStateEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
