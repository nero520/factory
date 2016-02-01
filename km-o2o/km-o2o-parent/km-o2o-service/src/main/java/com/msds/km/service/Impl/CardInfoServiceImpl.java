package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CardInfoEntity;
import com.msds.km.mapper.CardInfoMapper;
import com.msds.km.mapper.CardItemDetailMapper;
import com.msds.km.mapper.CardUsedDetailMapper;
import com.msds.km.service.CardInfoService;
import com.msds.km.vo.CardInfo;

/**
 * 
 * <br>
 * <b>功能：</b>CardInfoService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:48 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("cardInfoService")
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfoEntity>
		implements CardInfoService {

	@Autowired
	private CardInfoMapper cardInfoMapper;
	@Autowired
	private CardUsedDetailMapper cardUsedDetailMapper;
	@Autowired
	private CardItemDetailMapper cardItemDetailMapper;

	public CardInfoMapper baseMapper() {
		return cardInfoMapper;
	}

	@Override
	public CardInfo findCardInfo(String phone) {
		CardInfoEntity cardInfoEntity = cardInfoMapper.findByPhone(phone);
		if (cardInfoEntity != null) {
			CardInfo cardInfo = new CardInfo();
			cardInfo.setCardInfo(cardInfoEntity);
			cardInfo.setItemlList(cardItemDetailMapper
					.findListByCardNo(cardInfoEntity.getCardNo()));
			cardInfo.setPayList(cardUsedDetailMapper.findListByCardNoAndType(
					cardInfoEntity.getCardNo(), 1));
			cardInfo.setConsumeList(cardUsedDetailMapper
					.findListByCardNoAndType(cardInfoEntity.getCardNo(), 2));

			return cardInfo;
		}
		return null;
	}

}
