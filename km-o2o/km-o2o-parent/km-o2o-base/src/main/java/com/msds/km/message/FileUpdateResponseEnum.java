package com.msds.km.message;

import com.msds.enums.DescriptionEnum;

/**
 * 文件处理回信息定义
 * 
 * @ClassName FileUpdateResponseEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年11月5日11:05:15
 * 
 */
public enum FileUpdateResponseEnum implements DescriptionEnum {
	/** 文件无法解析。 */
	code_1600(1600, "文件无法解析."),
	/** 文件上送过大,请不要超过3M。 */
	code_1601(1601, "文件上送过大,请不要超过3M。"),
	/** 请上传您的文件。 */
	code_1602(1602, "请上传您的文件。"), ;

	private int id;
	private String name;

	private FileUpdateResponseEnum(int id, String name) {
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
}
