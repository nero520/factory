package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.FactoryMapper;
import com.msds.km.entity.FactoryEntity;
import com.msds.km.service.FactoryService;

/**
 * 
 * <br>
 * <b>功能：</b>FactoryService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:03 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("factoryService")
public class FactoryServiceImpl extends BaseServiceImpl<FactoryEntity> implements FactoryService{
	

	@Autowired
    private FactoryMapper factoryMapper;
		
	public FactoryMapper baseMapper() {
		return factoryMapper;
	}

	@Override
	public FactoryEntity findByFatory(FactoryEntity entity) {
		
		return factoryMapper.findByFatory(entity);
	}
	
	

}
