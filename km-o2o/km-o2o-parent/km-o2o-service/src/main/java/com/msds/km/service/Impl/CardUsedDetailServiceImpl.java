package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CardUsedDetailEntity;
import com.msds.km.mapper.CardUsedDetailMapper;
import com.msds.km.service.CardUsedDetailService;

/**
 * 
 * <br>
 * <b>功能：</b>CardUsedDetailService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("cardUsedDetailService")
public class CardUsedDetailServiceImpl extends
		BaseServiceImpl<CardUsedDetailEntity> implements CardUsedDetailService {

	@Autowired
	private CardUsedDetailMapper cardUsedDetailMapper;

	public CardUsedDetailMapper baseMapper() {
		return cardUsedDetailMapper;
	}

}
