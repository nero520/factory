package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 预约单类型
 * 
 * @ClassName OrderStateEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年10月21日16:22:28
 * 
 */
public enum BespeakTypeEnum implements DescriptionEnum {

	counselor(1, "顾问"), 
	online(2, "在线");

	private int id;
	private String name;

	private BespeakTypeEnum(int id, String name) {
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

	public static BespeakTypeEnum getEnumById(int id) {
		BespeakTypeEnum[] values = BespeakTypeEnum.values();
		for (BespeakTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		BespeakTypeEnum[] values = BespeakTypeEnum.values();
		for (BespeakTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
