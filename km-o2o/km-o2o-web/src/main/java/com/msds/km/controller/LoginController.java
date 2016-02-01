package com.msds.km.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.MemberEntity;
import com.msds.km.message.LoginResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberService;
import com.msds.util.AppConstants;
import com.msds.util.CheckUtils;
import com.msds.util.RedisUtil;

/**
 * 
 * ClassName: LoginController
 * 
 * @Description: 登录相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private AppConstants appConstants;
	@Resource(name = "memberService")
	private MemberService memberService;

	/**
	 * 登录授权
	 * 
	 * @param memberEntity
	 * @param request
	 * @param code
	 *            验证码
	 * @return
	 */
	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public BaseResponse authorize(String phone, String code,
			HttpServletRequest request) {
		// 1.校验手机号格式
		if (phone == null || !CheckUtils.checkPhone(phone)) {
			return super.retEnumResponse(LoginResponseEnum.code_1000);
		}

		// // 1.1判断已发送验证码是否失效
		// String phonecode = RedisUtil.getValue(CommonAttributes.Login_SendCode
		// + phone);
		// if (phonecode == null) {
		// return super.retEnumResponse(LoginResponseEnum.code_1004);
		// }
		// // 2.校验验证码
		// if (!(code != null && phonecode.equals(code))) {
		// return super.retEnumResponse(LoginResponseEnum.code_1005);
		// }

		// 3.登录并且存储在session中;
		try {
			MemberEntity member = memberService.findByPhone(phone);
			HttpSession session = request.getSession();
			// TODO 临时
			String openId = (String) session.getAttribute("XEIXIN_OPENID");
			logger.info("获取微信渠道的的,openId:{}", openId);
			if (member != null) {
				member.setOpenId(null);
				session.setAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO,
						member);
				if (StringUtils.isNotBlank(openId)) {
					MemberEntity memberEntity = new MemberEntity();
					memberEntity.setId(member.getId());
					memberEntity.setOpenId(openId);
					try {
						memberService.update(memberEntity);
					} catch (Exception e) {
						logger.error("用户:{}绑定微信出错{}。", member.getPhone(),
								openId);
						e.printStackTrace();
					}
				}
			} else {
				Date date = new Date();
				member = new MemberEntity();
				member.setPhone(phone);
				member.setCreateDate(date);
				member.setModifyDate(date);
				member.setOpenId(openId);// TODO 临时
				memberService.add(member);
				session.setAttribute(CommonAttributes.MEMBER_PRINCIPAL_INFO,
						member);
			}
		} catch (Exception e) {
			logger.error("类方法：authorize，登录数据库异常{}", e.getMessage());
			return super.retEnumResponse(LoginResponseEnum.code_1006);
		}

		// 4.删除验证码
		RedisUtil.delValue(CommonAttributes.Login_SendCode + phone);
		return SUCCESSFUL;
	}

	/**
	 * 判断登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/isLogin")
	public BaseResponse isLogin(HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);
		if (memberId == null) {
			return FAILURE;
		}
		return SUCCESSFUL;
	}

}
