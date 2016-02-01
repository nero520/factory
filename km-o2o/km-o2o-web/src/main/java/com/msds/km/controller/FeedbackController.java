package com.msds.km.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.FeedbackEntity;
import com.msds.km.service.FeedbackService;

@Controller("feedbackController")
@RequestMapping("/feedback")
public class FeedbackController extends BaseController {

	@Autowired
	private FeedbackService feedbackService;

	/**
	 * 增加意见反馈
	 */

	@RequestMapping(value = "/add")
	public @ResponseBody Object add(String content, HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);
		if (StringUtils.isNotEmpty(content) && content.length() < 100) {
			try {
				FeedbackEntity feedback = new FeedbackEntity();
				feedback.setContent(content.replaceAll(
						"[^0-9a-zA-Z\u4e00-\u9fa5]", ""));
				feedback.setMemberId(memberId);
				feedback.setCreateDate(new Date());
				this.feedbackService.add(feedback);
				return SUCCESSFUL;
			} catch (Exception e) {
				logger.error("增加意见反馈异常", e);
			}
		}
		return FAILURE;
	}

}
