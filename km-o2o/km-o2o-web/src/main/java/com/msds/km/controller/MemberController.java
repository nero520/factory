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
import com.msds.km.message.MemberResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.CardInfoService;
import com.msds.km.service.MemberService;
import com.msds.util.CheckUtils;

/**
 * 会员
 * 
 * @ClassName MemberController
 * @Description TODO
 * @author LiLong
 * @date 2015年4月27日 上午11:21:29
 * 
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Resource(name = "memberService")
	private MemberService memberService;
	@Resource(name = "cardInfoService")
	private CardInfoService cardInfoService;

	/**
	 * 查看会员信息
	 * 
	 * @Description TODO
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public BaseResponse show(HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);
		MemberEntity memberEntity = null;
		try {
			memberEntity = memberService.findById(memberId);
			memberEntity.setId(null);
			memberEntity.setPassword(null);
			memberEntity.setOpenId(null);
		} catch (Exception e) {
			e.printStackTrace();
			return FAILURE;
		}
		return returnResponse(SUCCESS_CODE, memberEntity);
	}

	/**
	 * 修改会员信息
	 * 
	 * @Description TODO
	 * @param memberEntity
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public BaseResponse update(MemberEntity memberEntity,
			HttpServletRequest request) {
		String name = memberEntity.getName();
		if (StringUtils.isNotBlank(name)) {
//			if (!CheckUtils.checkName(name)) {
//				return retEnumResponse(MemberResponseEnum.code_1400);
//			}
		} else {
			memberEntity.setName("");
		}

		Integer memberId = super.getMemberId(request);
		memberEntity.setId(memberId);
		memberEntity.setUsername(null);
		memberEntity.setPassword(null);
		memberEntity.setPhone(null);
		memberEntity.setOpenId(null);
		try {
			memberService.update(memberEntity);
			MemberEntity member = memberService.findById(memberId);
			memberEntity.setId(null);
			memberEntity.setPassword(null);
			memberEntity.setOpenId(null);
			request.getSession().setAttribute(
					CommonAttributes.MEMBER_PRINCIPAL_INFO, member);
		} catch (Exception e) {
			e.printStackTrace();
			return FAILURE;
		}
		return SUCCESSFUL;
	}

}
