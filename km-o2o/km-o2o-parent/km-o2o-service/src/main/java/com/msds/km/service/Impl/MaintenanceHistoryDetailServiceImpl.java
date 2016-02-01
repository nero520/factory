package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.MaintenanceHistoryDetailMapper;
import com.msds.km.entity.MaintenanceHistoryDetailEntity;
import com.msds.km.service.MaintenanceHistoryDetailService;

/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryDetailService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 13:45:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("maintenanceHistoryDetailService")
public class MaintenanceHistoryDetailServiceImpl extends BaseServiceImpl<MaintenanceHistoryDetailEntity> implements MaintenanceHistoryDetailService{
	private final static Logger log= Logger.getLogger(MaintenanceHistoryDetailService.class);

	@Autowired
    private MaintenanceHistoryDetailMapper maintenanceHistoryDetailMapper;
		
	public MaintenanceHistoryDetailMapper baseMapper() {
		return maintenanceHistoryDetailMapper;
	}

	@Override
	public void deleteByVin(String vin) throws Exception {
		maintenanceHistoryDetailMapper.deleteByVin(vin);
		
	}

}
