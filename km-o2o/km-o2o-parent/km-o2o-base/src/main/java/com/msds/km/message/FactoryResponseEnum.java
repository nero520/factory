package com.msds.km.message;   

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 来源
 * 创建时间：2014-9-25 上午11:06:17 
 * 项目名称：kmo2o
 * @author xiaoxiong  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum FactoryResponseEnum implements DescriptionEnum{
	code_1000(1000,"账号或密码有误"),
	code_1001(1001,"系统繁忙，请稍后再试"),
	code_9999(9999,"用户未登录，请先登录"),
	;
	
	private int id;
	private String name;
	
	private FactoryResponseEnum(int id,String name){
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
	public static FactoryResponseEnum getEnumById(int id){
		FactoryResponseEnum [] values = FactoryResponseEnum.values();
		for(FactoryResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		FactoryResponseEnum [] values = FactoryResponseEnum.values();
		for(FactoryResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
