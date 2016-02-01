package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.ActivityNewEntity;
/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface ActivityNewMapper extends BaseMapper<ActivityNewEntity> {
	public ActivityNewEntity findActivityBySn(String sn);
}
