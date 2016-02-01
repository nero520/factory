package com.msds.km.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.ActivityEntity;
import com.msds.km.entity.PrizeCordEntity;
import com.msds.km.enums.ActivityStateEnum;
import com.msds.km.service.ActivityService;
import com.msds.km.service.PrizeCordService;

/**
 * 
 * <br>
 * 兑奖码 <b>功能：</b>PrizeCordController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/prizeCord")
public class PrizeCordController extends BaseController {

	@Resource
	private PrizeCordService prizeCordService;
	@Resource
	private ActivityService activityService;

	/**
	 * 获取数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public Object get(String sn, String phone, String license, String model,
			String openid) throws Exception {
		if (StringUtils.isNoneBlank(sn, phone, license, model)) {
			ActivityEntity activityEntity = activityService.findBySn(sn);
			if (activityEntity != null) {
				Date date = new Date();
				if (date.before(activityEntity.getStartTime())) {
					return returnResponse(FAILURE_CODE, "活动未开始");
				} else if (date.after(activityEntity.getEndTime())) {
					return returnResponse(FAILURE_CODE, "活动已结束");
				} else if (activityEntity.getState() != ActivityStateEnum.start
						.getId()) {
					return returnResponse(FAILURE_CODE, "活动已结束");
				} else if (!(activityEntity.getQuantity() < activityEntity
						.getCount())) {
					return returnResponse(FAILURE_CODE, "活动红包已领完");
				} else {
					PrizeCordEntity prizeCordEntity = prizeCordService
							.findByActivitySnLicense(sn, license);
					if (prizeCordEntity == null) {
						String prizeCord = prizeCordService.generate(sn, phone,
								license, model, activityEntity.getEndTime(),
								openid);
						if (prizeCord != null) {
							return returnSuccessResponse(prizeCord);
						} else {
							return returnResponse(FAILURE_CODE, "来晚了啊");
						}
					} else {
						return returnResponse("0001", prizeCordEntity.getSn());
					}
				}

			}
		}
		return returnResponse(FAILURE_CODE, "数据不完整");
	}

}
