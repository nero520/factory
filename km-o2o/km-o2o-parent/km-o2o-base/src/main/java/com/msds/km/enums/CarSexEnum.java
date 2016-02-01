package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 订单状态
 * 
 * @ClassName CarRoleEnum
 * @Description TODO
 * @author zhengxd
 * @date 2015年10月20日 下午4:42:32
 * 
 */
public enum CarSexEnum implements DescriptionEnum {


	woman(0, "女"),
	man(1, "男")
	;

	private int id;
	private String name;

	private CarSexEnum(int id, String name) {
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

	public static CarSexEnum getEnumById(int id) {
		CarSexEnum[] values = CarSexEnum.values();
		for (CarSexEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		CarSexEnum[] values = CarSexEnum.values();
		for (CarSexEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
