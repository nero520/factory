package com.msds.km.enums;   

import com.msds.enums.DescriptionEnum;

/**
 * 创建时间：2014-10-8 下午2:25:05 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum CodeTypeEnum implements DescriptionEnum {
	
	bespeak_code(10,"YYD","结算单号"),
	service_model_code(11,"SM","服务车型单号"),
	coupon_code(12,"YH","红包及优惠券编号"),
	member_ticket_code(13,"MTC","会员红包及优惠券"),
	activity_new_code(14,"HD","活动编号"),
	checkbill_code(15,"CKB","全车检查单单号");
	;
	
	private int id;
	private String name;
	private String prefix;
	
	private CodeTypeEnum(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	private CodeTypeEnum(int id,String prefix,String name){
		this.id = id;
		this.name = name;
		this.prefix = prefix;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * 获取  prefix
	 * @return  prefix  prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	
}
  
