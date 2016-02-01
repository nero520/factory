package com.msds.km.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.util.RedisUtil;

/**
 * 推送消息总入口，短信、app、微信
 * 
 * @author lilong
 * @date 2015年11月9日13:22:15
 */
@Service("pushService")
public class PushService {

	@Resource(name = "bespeakService")
	private BespeakService bespeakService;

	/**
	 * 追加预约单推送信息
	 * 
	 * @param bespeak
	 */
	public void addBespeakPushMsg(Integer id, BespeakStateEnum state) {
		BespeakEntity bespeak = new BespeakEntity();
		bespeak.setId(id);
		bespeak.setState(state.getId());
		RedisUtil.rpush(CommonAttributes.BESPEAK_QUEUE, bespeak);
	}

	/**
	 * 取出预约单推送数据
	 * 
	 * @return
	 */
	public BespeakEntity GetBespeakPushMsg() {
		BespeakEntity bespeak = RedisUtil.lpop(CommonAttributes.BESPEAK_QUEUE);
		if (bespeak != null) {
			bespeak = bespeakService.findDetailByBespeak(bespeak);
			if (bespeak != null) {
				return bespeak;
			}
		}
		return null;
	}

}
