package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;


public enum ActivityNewStateEnum implements DescriptionEnum {

	stop(0, "暂停"),
	yes(1, "可用"),
	
	;

	private int id;
	private String name;

	private ActivityNewStateEnum(int id, String name) {
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

	public static ActivityNewStateEnum getEnumById(int id) {
		ActivityNewStateEnum[] values = ActivityNewStateEnum.values();
		for (ActivityNewStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ActivityNewStateEnum[] values = ActivityNewStateEnum.values();
		for (ActivityNewStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
