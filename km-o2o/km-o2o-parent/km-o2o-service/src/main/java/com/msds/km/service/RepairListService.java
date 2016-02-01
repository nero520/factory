package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.RepairListEntity;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakService<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface RepairListService extends BaseService<RepairListEntity> {

	
	public List<RepairListEntity> getRepairList(RepairListEntity entity);
	
	public int getRepairListCount(RepairListEntity entity);
	
	public void importData(List<RepairListEntity> list) throws Exception;
	/**
	 *  用户手机号或vin查询用户信息
	 * @param memberPhone
	 * @param vin
	 * @return
	 */
	Integer  existsByMemberPhoneOrvin(String memberPhone,String vin);
}
