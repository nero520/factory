package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 活动优惠券及红包的使用状态
 * 
 * @author 
 * @date 2015年010月22日
 */
public enum ActivityNewDetailStateEnum implements DescriptionEnum {
	/**
	 * 暂停
	 */
	stop(0, "暂停"),
	/**
	 * 使用
	 */
	use(1, "使用") ,
	/**
	 *已使用
	 */
	used(2, "已使用") ;
	
	
	private int id;
	private String name;

	private ActivityNewDetailStateEnum(int id, String name) {
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

	public static ActivityNewDetailStateEnum getEnumById(int id) {
		ActivityNewDetailStateEnum[] values = ActivityNewDetailStateEnum.values();
		for (ActivityNewDetailStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ActivityNewDetailStateEnum[] values = ActivityNewDetailStateEnum.values();
		for (ActivityNewDetailStateEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
