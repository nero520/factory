package com.msds.km.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.entity.MaintenanceHistoryDetailEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MaintenanceHistoryDetailService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.RepairListService;

/**
 * 保养历史
 * 
 * @ClassName MaintenanceHistoryController
 * @Description TODO
 * @author LiLong
 * @date 2015年07月09日 11:21:29
 * 
 */
@Controller
@RequestMapping("/maintenanceHistory")
public class MaintenanceHistoryController extends BaseController {

	@Resource(name = "maintenanceHistoryDetailService")
	MaintenanceHistoryDetailService maintenanceHistoryDetailService;
	@Resource(name = "memberModelService")
	private MemberModelService memberModelService;
	@Resource(name = "repairListService")
	private RepairListService repairListService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseResponse list(
			MaintenanceHistoryDetailEntity maintenanceHistoryDetail,
			HttpServletRequest request) {

		MemberModelEntity memberModel = memberModelService
				.queryDefaultById(super.getMemberId(request));
		// 判断用户是否添加了车型
		if (memberModel != null) {
			// 判断用户是否有vin
			String vin = memberModel.getVin();
			if (StringUtils.isNotBlank(vin)) {
				// 判断用户是否在门店消费过
				Integer exists = repairListService.existsByMemberPhoneOrvin(
						getMemberInfo(request).getPhone(), vin);
				if (exists != null && exists > 0) {
					List<MaintenanceHistoryDetailEntity> MaintenanceHistoryList = null;
					try {
						maintenanceHistoryDetail.setVin(vin);
						MaintenanceHistoryList = maintenanceHistoryDetailService
								.queryByList(maintenanceHistoryDetail);
					} catch (Exception e) {
						return FAILURE;
					}
					return returnSuccessResponse(MaintenanceHistoryList);
				}
			}
		}
		return returnResponse("2000", "不满足条件");
	}
}
