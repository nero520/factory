package com.msds.km.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.RepairListService;
import com.msds.km.vo.QueryDefault;
import com.msds.util.BeanUtil;

/**
 * 
 * <br>
 * <b>功能：</b>IndexController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 15:26:23 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Resource(name = "memberModelService")
	private MemberModelService memberModelService;
	// @Resource(name = "modelService")
	// private ModelService modelService;
	@Resource(name = "repairListService")
	private RepairListService repairListService;

	/**
	 * 
	 * 首页业务数据项
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryDefault", method = RequestMethod.GET)
	public BaseResponse queryDefault(HttpServletRequest request)
			throws Exception {
		MemberEntity memberInfo = super.getMemberInfo(request);
		QueryDefault queryDefault = new QueryDefault();
		if (StringUtils.isNotBlank(memberInfo.getOpenId())) {
			queryDefault.setWxBindFlag(true);
		}
		MemberModelEntity memberModel = memberModelService
				.queryDefaultById(memberInfo.getId());
		if (memberModel != null) {
			BeanUtil.copyProperties(memberModel, queryDefault);
			// String logo =
			// modelService.findLogoById(memberModel.getModelId());
			// memberModel.setLogo(logo);
			String vin = memberModel.getVin();
			if (vin != null) {
				Integer exists = repairListService.existsByMemberPhoneOrvin(
						memberInfo.getPhone(), vin);
				if (exists != null && exists > 0) {
					queryDefault.setConsumeFlag(true);
				}
			}
		}
		return super.returnResponse("0000", queryDefault);
	}
}
