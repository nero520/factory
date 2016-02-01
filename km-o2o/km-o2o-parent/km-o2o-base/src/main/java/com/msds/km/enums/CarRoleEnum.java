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
public enum CarRoleEnum implements DescriptionEnum {

	nvshen(1, "女神"),
	nvhanzi(2, "女汉子"),
	xianqiliangmu(3, "贤妻良母"),
	mengmeizi(4, "萌妹子"),
	mengdashu(5, "萌大叔"),
	chunyemen(6, "纯爷们"),
	nuannan(7, "暖男"),
	xiaoxianrou(8, "小鲜肉")
	
	;

	private int id;
	private String name;

	private CarRoleEnum(int id, String name) {
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

	public static CarRoleEnum getEnumById(int id) {
		CarRoleEnum[] values = CarRoleEnum.values();
		for (CarRoleEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		CarRoleEnum[] values = CarRoleEnum.values();
		for (CarRoleEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
