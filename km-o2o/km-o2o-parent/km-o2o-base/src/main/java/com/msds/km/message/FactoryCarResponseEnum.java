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
public enum FactoryCarResponseEnum implements DescriptionEnum{
	code_1001(1001,"卡已使用"),
	;
	
	private int id;
	private String name;
	
	private FactoryCarResponseEnum(int id,String name){
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
	public static FactoryCarResponseEnum getEnumById(int id){
		FactoryCarResponseEnum [] values = FactoryCarResponseEnum.values();
		for(FactoryCarResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		FactoryCarResponseEnum [] values = FactoryCarResponseEnum.values();
		for(FactoryCarResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
