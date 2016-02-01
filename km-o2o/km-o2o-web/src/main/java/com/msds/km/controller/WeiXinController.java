package com.msds.km.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.MemberEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberService;
import com.msds.plugin.weixin.WeiXinPlugin;

/**
 * 
 * ClassName: WeiXinController
 * 
 * @author LiLong
 * @date 2015年11月10日13:28:08
 */
@Controller
@RequestMapping("/wx")
public class WeiXinController extends BaseController {

	@Resource(name = "memberService")
	private MemberService memberService;
	@Resource(name = "weixinPlugin")
	private WeiXinPlugin weixinPlugin;

	/**
	 * bind
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	public BaseResponse bind(HttpServletRequest request, String code) {
		MemberEntity member = super.getMemberInfo(request);
		if (member != null) {
			if (StringUtils.isNotBlank(code)) {
				String openId = weixinPlugin.getOpenId(code);
				if (StringUtils.isNotBlank(openId)) {
					MemberEntity memberEntity = new MemberEntity();
					memberEntity.setId(member.getId());
					memberEntity.setOpenId(openId);
					try {
						memberService.update(member);
					} catch (Exception e) {
						logger.error("用户:{}绑定微信出错{}。", member.getPhone(),
								openId);
						e.printStackTrace();
					}
					member.setOpenId(openId);
					request.getSession().setAttribute(
							CommonAttributes.MEMBER_PRINCIPAL_INFO, member);
					return SUCCESSFUL;
				}
			}
		}
		return FAILURE;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResponse wx(HttpServletRequest request, String code) {
		if (super.getMemberInfo(request) != null)
			return SUCCESSFUL;
		if (StringUtils.isNotBlank(code)) {
			String openId = weixinPlugin.getOpenId(code);
			if (StringUtils.isNotBlank(openId)) {
				MemberEntity memberEntity = memberService.findByOpenId(openId);
				if (memberEntity != null) {
					request.getSession().setAttribute(
							CommonAttributes.MEMBER_PRINCIPAL_INFO,
							memberEntity);
					return returnSuccessResponse(memberEntity.getPhone());
				} else {
					request.getSession().setAttribute("XEIXIN_OPENID", openId);
					logger.info("获取微信渠道的的,openId:{}", openId);
				}
			}
		}
		return FAILURE;
	}
}
