package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.mapper.BaseMapper;
import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.RepairListEntity;
import com.msds.km.mapper.RepairListMapper;
import com.msds.km.service.RepairListService;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakServiceImpl<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("repairListService")
public class RepairListServiceImpl extends BaseServiceImpl<RepairListEntity>
		implements RepairListService {

	@Autowired
	private RepairListMapper repairListMapper;

	@Override
	public List<RepairListEntity> getRepairList(RepairListEntity entity) {
		// TODO Auto-generated method stub
		return repairListMapper.getRepairList(entity);
	}

	@Override
	public int getRepairListCount(RepairListEntity entity) {
		// TODO Auto-generated method stub
		return repairListMapper.getRepairListCount(entity);
	}

	@Override
	public void importData(List<RepairListEntity> list) throws Exception {
		// TODO Auto-generated method stub
		repairListMapper.importData(list);
	}

	@Override
	public BaseMapper<RepairListEntity> baseMapper() {
		// TODO Auto-generated method stub
		return repairListMapper;
	}

	@Override
	public Integer existsByMemberPhoneOrvin(String memberPhone, String vin) {
		return repairListMapper.existsByMemberPhoneOrvin(memberPhone, vin);
	}

}
