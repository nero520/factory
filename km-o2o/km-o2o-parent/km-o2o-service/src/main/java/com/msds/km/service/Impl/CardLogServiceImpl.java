package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.CardLogMapper;
import com.msds.km.entity.CardLogEntity;
import com.msds.km.service.CardLogService;

/**
 * 
 * <br>
 * <b>功能：</b>CardLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-24 11:04:46 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("cardLogService")
public class CardLogServiceImpl extends BaseServiceImpl<CardLogEntity> implements CardLogService{
	private final static Logger log= Logger.getLogger(CardLogService.class);

	@Autowired
    private CardLogMapper cardLogMapper;
		
	public CardLogMapper baseMapper() {
		return cardLogMapper;
	}

}
