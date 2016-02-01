package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.ActivityNewDetailEntity;
/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewDetailMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-23 13:56:18 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface ActivityNewDetailMapper extends BaseMapper<ActivityNewDetailEntity> {
	
	public void deleteByActivitySn(String activitySn);
}
