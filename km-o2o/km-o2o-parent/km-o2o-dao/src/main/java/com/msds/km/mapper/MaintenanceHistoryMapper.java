package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.MaintenanceHistoryEntity;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 13:45:55 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface MaintenanceHistoryMapper extends BaseMapper<MaintenanceHistoryEntity> {
	
	public MaintenanceHistoryEntity findByVin(String vin) throws Exception;
}
