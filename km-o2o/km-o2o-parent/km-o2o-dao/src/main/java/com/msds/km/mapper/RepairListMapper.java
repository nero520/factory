package com.msds.km.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.RepairListEntity;

/**
 * 
 * <br>
 * <b>功能：</b>RepairListMapper<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-10-26 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface RepairListMapper extends BaseMapper<RepairListEntity> {

	public List<RepairListEntity> getRepairList(RepairListEntity entity);

	public int getRepairListCount(RepairListEntity entity);

	public void importData(List<RepairListEntity> list) throws Exception;

	Integer existsByMemberPhoneOrvin(
			@Param(value = "memberPhone") String memberPhone,
			@Param(value = "vin") String vin);

}
