package com.msds.km.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.FactoryCardMapper;
import com.msds.km.entity.FactoryCardEntity;
import com.msds.km.service.FactoryCardService;

/**
 * 
 * <br>
 * <b>功能：</b>FactoryCardService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("factoryCardService")
public class FactoryCardServiceImpl extends BaseServiceImpl<FactoryCardEntity> implements FactoryCardService{
	
	@Autowired
    private FactoryCardMapper factoryCardMapper;
		
	public FactoryCardMapper baseMapper() {
		return factoryCardMapper;
	}

	@Override
	public List<FactoryCardEntity> findByFactoryCard(Integer factoryId) {
		
		return factoryCardMapper.findByFactoryCard(factoryId);
	}

	
	

}
