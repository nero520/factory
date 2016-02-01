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
public enum ActivityNewTypeEnum implements DescriptionEnum {

	redenvelope(1, "红包"),
	coupon(2, "优惠券"),
	
	;

	private int id;
	private String name;

	private ActivityNewTypeEnum(int id, String name) {
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

	public static ActivityNewTypeEnum getEnumById(int id) {
		ActivityNewTypeEnum[] values = ActivityNewTypeEnum.values();
		for (ActivityNewTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ActivityNewTypeEnum[] values = ActivityNewTypeEnum.values();
		for (ActivityNewTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
