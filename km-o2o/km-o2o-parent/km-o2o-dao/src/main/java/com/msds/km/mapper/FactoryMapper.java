package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.FactoryEntity;
/**
 * 
 * <br>
 * <b>功能：</b>FactoryMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:03 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface FactoryMapper extends BaseMapper<FactoryEntity> {

	FactoryEntity findByFatory(FactoryEntity entity);
	
	
}
