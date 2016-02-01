package com.msds.km.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.FactoryCarEntity;
import com.msds.km.mapper.FactoryCarMapper;
import com.msds.km.service.FactoryCarService;
import com.msds.km.vo.DateRankVo;
import com.msds.km.vo.RankVo;

/**
 * 
 * <br>
 * <b>功能：</b>FactoryCarService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("factoryCarService")
public class FactoryCarServiceImpl extends BaseServiceImpl<FactoryCarEntity> implements FactoryCarService{
	private final static Logger log= Logger.getLogger(FactoryCarService.class);

	@Autowired
    private FactoryCarMapper factoryCarMapper;
		
	public FactoryCarMapper baseMapper() {
		return factoryCarMapper;
	}

	@Override
	public List<RankVo> findRankList(Integer state) {
		
		return factoryCarMapper.findRankList(state);
	}

	@Override
	public List<DateRankVo> findDayRankListById(Integer id) {
		
		return factoryCarMapper.findDayRankListById(id);
	}
	
	
	

}
