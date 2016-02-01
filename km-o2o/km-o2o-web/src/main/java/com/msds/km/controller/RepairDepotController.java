package com.msds.km.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.CompanyService;
import com.msds.lbs.BaiduLBSApi;

/**
 * 
 * ClassName: RepairDepotController
 * 
 * @Description: 维修车相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/repair")
public class RepairDepotController extends BaseController {

	@Autowired
	private CompanyService companyService;

	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseResponse datalist(String serviceCode, HttpServletRequest request)
			throws Exception {
		List<CompanyEntity> companyLists = companyService
				.findListByserviceCode(serviceCode);
		if (companyLists != null && companyLists.size() > 0) {
			HttpSession session = request.getSession();
			String longitude = (String) session
					.getAttribute(CommonAttributes.GEO_LONGITUDE);
			String latitude = (String) session
					.getAttribute(CommonAttributes.GEO_LATITUDE);
			if (longitude != null && latitude != null) {
				List<Map<String, Object>> nearbylist = BaiduLBSApi.getNearby(
						longitude, latitude, CommonAttributes.GEO_COMPANY_ID,
						CommonAttributes.GEO_COMPANY_RADIUS,
						CommonAttributes.GEO_COMPANY_QUERY);
				if (nearbylist != null && nearbylist.size() > 0) {
					// Set<CompanyEntity> companys = new LinkedHashSet<>();
					for (Map<String, Object> nearby : nearbylist) {
						for (CompanyEntity company : companyLists) {
							if (company.getId()
									.equals(nearby.get("company_id"))) {
								company.setDistance(Integer.valueOf(String
										.valueOf(nearby.get("distance"))));
								continue;
							}
						}
					}
					Collections.sort(companyLists,
							new Comparator<CompanyEntity>() {
								@Override
								public int compare(CompanyEntity c1,
										CompanyEntity c2) {
									if (c1.getDistance() == null) {
										return 1;
									} else if (c2.getDistance() == null) {
										return -1;
									} else {
										return c1.getDistance().compareTo(
												c2.getDistance());
									}
								}
							});
				}
			}
		}
		return super.returnResponse("0000", companyLists);
	}

}
