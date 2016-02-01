package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CardItemDetailEntity;
import com.msds.km.mapper.CardItemDetailMapper;
import com.msds.km.service.CardItemDetailService;

/**
 * 
 * <br>
 * <b>功能：</b>CardItemDetailService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("cardItemDetailService")
public class CardItemDetailServiceImpl extends
		BaseServiceImpl<CardItemDetailEntity> implements CardItemDetailService {

	@Autowired
	private CardItemDetailMapper cardItemDetailMapper;

	public CardItemDetailMapper baseMapper() {
		return cardItemDetailMapper;
	}

}
