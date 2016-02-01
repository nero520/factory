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
public enum CouponTypeEnum implements DescriptionEnum {

	redenvelope(1, "红包"),
	coupon(2, "优惠券"),
	
	;

	private int id;
	private String name;

	private CouponTypeEnum(int id, String name) {
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

	public static CouponTypeEnum getEnumById(int id) {
		CouponTypeEnum[] values = CouponTypeEnum.values();
		for (CouponTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		CouponTypeEnum[] values = CouponTypeEnum.values();
		for (CouponTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
