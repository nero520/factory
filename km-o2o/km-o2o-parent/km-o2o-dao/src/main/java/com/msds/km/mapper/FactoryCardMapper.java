package com.msds.km.mapper;


import java.util.List;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.FactoryCardEntity;
/**
 * 
 * <br>
 * <b>功能：</b>FactoryCardMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface FactoryCardMapper extends BaseMapper<FactoryCardEntity> {
	
	List<FactoryCardEntity> findByFactoryCard(Integer factoryId); 
}
