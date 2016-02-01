package com.msds.km.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.CodeGenerator;
import com.msds.km.base.BaseController;
import com.msds.km.entity.ActivityNewEntity;
import com.msds.km.enums.ActivityLimitStateEnum;
import com.msds.km.enums.ActivityStateEnum;
import com.msds.km.message.ActivityNewResponseEnum;
import com.msds.km.service.ActivityNewService;
import com.msds.km.service.CouponService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.MemberTicketService;
import com.msds.km.service.ModelService;

/**
 * 
 * <br>
 * 活动 <b>功能：</b>ActivityController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/activityNew")
public class ActivityNewController extends BaseController {

	@Resource
	private ActivityNewService activityNewService;
	@Resource
	private CouponService couponService;
	@Resource
	private MemberTicketService memberTicketService;
	@Resource
	private MemberModelService memberModelService;
	@Resource
	private ModelService modelService;
	@Resource
	private CodeGenerator codeGenerator;
	
	private static int COUNT= 0;

	/**
	 * 活动列表
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 */
	
	@RequestMapping("/list")
	@ResponseBody
	public Object datalist(ActivityNewEntity entity, HttpServletRequest request)
			throws Exception {
		entity.setState(1);
		List<ActivityNewEntity> list = activityNewService.queryByList(entity);
		return returnSuccessResponse(list);
	}

	/**
	 * 获取活动详情
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/info")
	@ResponseBody
	public Object info(String sn, HttpServletRequest request) throws Exception {
		
		ActivityNewEntity activityEntity = activityNewService.findActivityBySn(sn);
		
		if (activityEntity != null) {
			Date date = new Date();
			if (date.before(activityEntity.getStartDate())) {
				return retEnumResponse(ActivityNewResponseEnum.code_2100);
			} else if (date.after(activityEntity.getEndDate())) {
				return retEnumResponse(ActivityNewResponseEnum.code_2101);
			} else if (activityEntity.getState() != ActivityStateEnum.start.getId()) {
				return retEnumResponse(ActivityNewResponseEnum.code_2101);
			} else if (activityEntity.getActivityLimitState() ==ActivityLimitStateEnum.astrict.getId() && activityEntity.getActivityLimitNum()==COUNT) {
				return retEnumResponse(ActivityNewResponseEnum.code_2102);
			} else {
				
				return returnSuccessResponse(activityEntity);
			}

		}
		return FAILURE;
	}
}
