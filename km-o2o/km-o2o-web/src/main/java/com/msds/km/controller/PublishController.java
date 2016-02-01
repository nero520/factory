package com.msds.km.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.entity.PublishEntity;
import com.msds.km.enums.PublishTypeEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.PublishService;
import com.msds.util.RedisUtil;

/**
 * 页面配置
 * 
 * @ClassName PublishController
 * @Description TODO
 * @author LiLong
 * @date 2015年07月09日 11:21:29
 * 
 */
@Controller
@RequestMapping("/publish")
public class PublishController extends BaseController {

	private static final String PUBLISH_KEY = "publish";

	@Resource(name = "publishService")
	PublishService publishService;

	/**
	 * 首页配置
	 * 
	 * @param os
	 *            平台(SourceEnum)
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public BaseResponse index(Integer os, HttpServletRequest request) {
		try {
			Map<String, Object> map = RedisUtil.getMapValue(PUBLISH_KEY,
					String.valueOf(os));
			if (map == null) {
				List<PublishEntity> ads = publishService.findListByTypeOs(
						PublishTypeEnum.ADS.getId(), os);
				List<PublishEntity> issues = publishService.findListByTypeOs(
						PublishTypeEnum.ISSUES.getId(), os);
				List<PublishEntity> services = publishService.findListByTypeOs(
						PublishTypeEnum.SERVICE.getId(), os);
				List<PublishEntity> bubble = publishService.findListByTypeOs(
						PublishTypeEnum.BUBBLE.getId(), os);
				map = new HashMap<>();
				map.put("ads", ads);
				map.put("issues", issues);
				map.put("services", services);
				map.put("bubble", bubble);
				RedisUtil.setMapValue(PUBLISH_KEY, String.valueOf(os), map);
			}
			List<PublishEntity> bubbles = (List<PublishEntity>) map
					.get("bubble");
			if (bubbles != null && bubbles.size() > 0) {
				map.put("bubble",
						bubbles.get(new Random().nextInt(bubbles.size())));
			}
			return returnResponse(SUCCESS_CODE, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FAILURE;
	}
}
