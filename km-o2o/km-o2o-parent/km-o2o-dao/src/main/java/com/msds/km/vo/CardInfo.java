package com.msds.km.vo;

import java.util.List;

import com.msds.km.entity.CardInfoEntity;
import com.msds.km.entity.CardItemDetailEntity;
import com.msds.km.entity.CardUsedDetailEntity;

/**
 * 前台会员卡信息包装类
 * 
 * @ClassName CardInfo
 * @Description TODO
 * @author LiLong
 * @date 2015年10月14日13:32:53
 * 
 */
public class CardInfo extends BaseVo {

	private static final long serialVersionUID = -3284024648243020035L;

	/**
	 * 会员主信息
	 */
	private CardInfoEntity cardInfo;

	/**
	 * 项目明细
	 */
	private List<CardItemDetailEntity> itemlList;

	/**
	 * 消费明细
	 */
	private List<CardUsedDetailEntity> consumeList;

	/**
	 * 充值明细
	 */
	private List<CardUsedDetailEntity> payList;

	/**
	 * @return the 会员主信息
	 */
	public CardInfoEntity getCardInfo() {
		return cardInfo;
	}

	/**
	 * @param 会员主信息
	 *            the cardInfo to set
	 */
	public void setCardInfo(CardInfoEntity cardInfo) {
		this.cardInfo = cardInfo;
	}

	/**
	 * @return the 项目明细
	 */
	public List<CardItemDetailEntity> getItemlList() {
		return itemlList;
	}

	/**
	 * @param 项目明细
	 *            the itemlList to set
	 */
	public void setItemlList(List<CardItemDetailEntity> itemlList) {
		this.itemlList = itemlList;
	}

	/**
	 * @return the 消费明细
	 */
	public List<CardUsedDetailEntity> getConsumeList() {
		return consumeList;
	}

	/**
	 * @param 消费明细
	 *            the consumeList to set
	 */
	public void setConsumeList(List<CardUsedDetailEntity> consumeList) {
		this.consumeList = consumeList;
	}

	/**
	 * @return the 充值明细
	 */
	public List<CardUsedDetailEntity> getPayList() {
		return payList;
	}

	/**
	 * @param 充值明细
	 *            the payList to set
	 */
	public void setPayList(List<CardUsedDetailEntity> payList) {
		this.payList = payList;
	}

}
