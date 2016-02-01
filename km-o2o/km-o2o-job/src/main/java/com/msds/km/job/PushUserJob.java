package com.msds.km.job;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import cn.jpush.api.push.PushResult;

import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.km.service.MemberService;
import com.msds.km.service.PushService;
import com.msds.plugin.weixin.WeiXinPlugin;
import com.msds.plugin.weixin.model.template.TemplateData;
import com.msds.plugin.weixin.model.template.TemplateMessage;
import com.msds.plugin.weixin.model.template.TemplateParam;
import com.msds.setting.SettingUtils;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;
import com.msds.util.JPushManagerUser;
import com.msds.util.SmsUtil;

/**
 * 推送用户任务
 * 
 * @ClassName PushUserJob
 * @Description 统一推送（微信、app、短息)
 * @author LiLong
 * @date 2015年11月9日11:12:16
 * 
 */
public class PushUserJob {

	private final static Logger log = LoggerFactory.getLogger(OrderJob.class);
	private final static String WX_CONFIRM_TEMPLATE_ID = "tRQqk4OUFi9LKxfBgzsOdvP_HZffuaI7bIA1t8jfLOg";
	private final static String WX_CANCEL_TEMPLATE_ID = "OQkZUy6R6dsqIxTzCrpCEkVFz6mRnWi_oiU0kHL8CGQ";
	private final static String TOP_COLOR = "#ffAADD";
	private final static String BESPEAK_DETAIL_URL = SettingUtils.get()
			.getBespeakDetailUrl();

	@Resource(name = "pushService")
	private PushService pushService;
	@Resource(name = "weixinPlugin")
	private WeiXinPlugin weixinPlugin;
	@Resource(name = "memberService")
	private MemberService memberService;

	@Value("${sso.sms.url}")
	private String SmsUrl;

	public void pushUser() throws Exception {
		BespeakEntity bespeak = pushService.GetBespeakPushMsg();
		if (bespeak != null) {
			// TODO 待确认
			if (bespeak.getState() == BespeakStateEnum.toConfirmation.getId()) {

			}
			// 确认
			else if (bespeak.getState() == BespeakStateEnum.confirmation
					.getId()) {
				// APP
				boolean appFlag = this.pushApp(bespeak);
				log.info("============= app推送:确认:{}:{} =======", appFlag,
						bespeak.getPhone());
				if (!appFlag) {
					// 微信
					boolean wxFlag = this.pushWeiXinForConfirm(bespeak);
					log.info("============= 微信推送:确认:{}:{} =======", wxFlag,
							bespeak.getPhone());
					if (!wxFlag) {
						// 短信
						boolean smsFlag = this.pushSMS(bespeak);
						log.info("============= SMS推送:确认:{}:{} =======",
								smsFlag, bespeak.getPhone());
					}
				}

			}
			// TODO 取消
			else if (bespeak.getState() == BespeakStateEnum.cancel.getId()) {
				// boolean wxFlag = this.pushWeiXinForCancel(bespeak);
				// log.info("============= 微信推送:取消:{}:{} =======", wxFlag,
				// bespeak.getPhone());
			}
		}
	}

	private Boolean pushApp(BespeakEntity bespeak) throws Exception {
		if (bespeak != null) {
			if (StringUtils.isNotBlank(bespeak.getPhone())) {
				try {
					return JPushManagerUser.getInstance().pushToAlias(
							"您有一张预约单已被确认", "u" + bespeak.getPhone());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	private Boolean pushSMS(BespeakEntity bespeak) throws Exception {
		if (bespeak != null) {
			if (StringUtils.isNotBlank(bespeak.getPhone())) {
				StringBuffer sb = new StringBuffer();
				sb.append(
						DateUtils.DateToString(new Date(),
								DateStyle.YYYY_MM_DD_HH_MM_SS))
						.append(" 您的预约已成功!")
						.append(" 预约时间为:")
						.append(DateUtils.DateToString(
								bespeak.getBespeakDate(), DateStyle.YYYY_MM_DD))
						.append(bespeak.getIsAm() == 0 ? "下午" : "上午")
						.append(" 预约门店:").append(bespeak.getCompanyName())
						.append("【车民生】");
				try {
					SmsUtil.sendGet(bespeak.getPhone(), SmsUrl, sb.toString());
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	private Boolean pushWeiXinForConfirm(BespeakEntity bespeak)
			throws Exception {
		if (bespeak != null) {
			MemberEntity member = memberService.findById(bespeak.getMemberId());
			if (StringUtils.isNotBlank(member.getOpenId())) {
				TemplateMessage templateMessage = new TemplateMessage();
				templateMessage.setTemplate_id(WX_CONFIRM_TEMPLATE_ID);
				templateMessage.setTouser(member.getOpenId());
				templateMessage.setUrl(BESPEAK_DETAIL_URL.replace(
						"{BESPEAKSN}", bespeak.getBespeakSn()));
				templateMessage.setTopcolor(TOP_COLOR);
				TemplateParam data = new TemplateParam();
				data.setFirst(new TemplateData("您的预约已成功！我们会尽快为您处理。"));
				data.setKeyword1(new TemplateData(bespeak.getLicense()));
				data.setKeyword2(new TemplateData(bespeak.getServiceContent()));
				data.setKeyword3(new TemplateData(bespeak.getCompanyName()));
				data.setKeyword4(new TemplateData(
						DateUtils.DateToString(bespeak.getBespeakDate(),
								DateStyle.YYYY_MM_DD_HH_MM_CN)));
				data.setRemark(new TemplateData("欢迎再次预约，点击查看详情。"));
				templateMessage.setData(data);
				return weixinPlugin.sendTemplateMsg(templateMessage);
			}
		}
		return false;
	}

	private Boolean pushWeiXinForCancel(BespeakEntity bespeak) throws Exception {
		if (bespeak != null) {
			MemberEntity member = memberService.findById(bespeak.getMemberId());
			if (StringUtils.isNotBlank(member.getOpenId())) {
				TemplateMessage templateMessage = new TemplateMessage();
				templateMessage.setTemplate_id(WX_CANCEL_TEMPLATE_ID);
				templateMessage.setTouser(member.getOpenId());
				templateMessage.setUrl(BESPEAK_DETAIL_URL.replace(
						"{BESPEAKSN}", bespeak.getBespeakSn()));
				templateMessage.setTopcolor(TOP_COLOR);
				TemplateParam data = new TemplateParam();
				data.setFirst(new TemplateData("您的预约已被取消。"));
				data.setKeyword1(new TemplateData(bespeak.getServiceContent()));
				data.setKeyword2(new TemplateData("已取消"));
				data.setRemark(new TemplateData("欢迎再次预约，点击查看详情。"));
				templateMessage.setData(data);
				return weixinPlugin.sendTemplateMsg(templateMessage);
			}
		}
		return false;
	}
}
