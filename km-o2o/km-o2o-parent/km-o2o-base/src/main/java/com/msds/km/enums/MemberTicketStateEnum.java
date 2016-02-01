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
public enum MemberTicketStateEnum implements DescriptionEnum {
	/**
	 * 未使用
	 */
	noUse(0, "未使用"),
	/**
	 * 使用
	 */
	use(1, "已使用") ;
	
	
	private int id;
	private String name;

	private MemberTicketStateEnum(int id, String name) {
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

	public static MemberTicketStateEnum getEnumById(int id) {
		MemberTicketStateEnum[] values = MemberTicketStateEnum.values();
		for (MemberTicketStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		MemberTicketStateEnum[] values = MemberTicketStateEnum.values();
		for (MemberTicketStateEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
