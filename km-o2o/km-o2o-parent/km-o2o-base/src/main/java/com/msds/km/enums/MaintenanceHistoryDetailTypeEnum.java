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
public enum MaintenanceHistoryDetailTypeEnum implements DescriptionEnum {

	maintain(1, "维修"),
	upkeep(2, "保养"),
	other(3,"其它")
	
	;

	private int id;
	private String name;

	private MaintenanceHistoryDetailTypeEnum(int id, String name) {
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

	public static MaintenanceHistoryDetailTypeEnum getEnumById(int id) {
		MaintenanceHistoryDetailTypeEnum[] values = MaintenanceHistoryDetailTypeEnum.values();
		for (MaintenanceHistoryDetailTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		MaintenanceHistoryDetailTypeEnum[] values = MaintenanceHistoryDetailTypeEnum.values();
		for (MaintenanceHistoryDetailTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
