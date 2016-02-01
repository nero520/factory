package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.MaintenanceHistoryMapper;
import com.msds.km.entity.MaintenanceHistoryEntity;
import com.msds.km.service.MaintenanceHistoryService;

/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 13:45:55 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("maintenanceHistoryService")
public class MaintenanceHistoryServiceImpl extends BaseServiceImpl<MaintenanceHistoryEntity> implements MaintenanceHistoryService{
	private final static Logger log= Logger.getLogger(MaintenanceHistoryService.class);

	@Autowired
    private MaintenanceHistoryMapper maintenanceHistoryMapper;
		
	public MaintenanceHistoryMapper baseMapper() {
		return maintenanceHistoryMapper;
	}

	@Override
	public MaintenanceHistoryEntity findByVin(String vin) throws Exception {
		return maintenanceHistoryMapper.findByVin(vin);
	}

}
