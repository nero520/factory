package com.msds.km.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.enums.MemberModelTypeEnum;
import com.msds.km.message.ServiceResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.CompanyService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.ModelService;
import com.msds.km.service.ServiceModelService;
import com.msds.km.service.ServiceService;
import com.msds.km.vo.ServiceMode;
import com.msds.km.vo.SimpleModelDetail;
import com.msds.lbs.BaiduLBSApi;
import com.msds.util.DateUtils;

/**
 * 
 * ClassName: ServiceController
 * 
 * @Description: 服务相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/service")
public class ServiceController extends BaseController {

	@Resource(name = "serviceService")
	private ServiceService serviceService;

	@Autowired
	private MemberModelService memberModelService;

	@Autowired
	private ServiceModelService serviceModelService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private CompanyService companyService;

	/**
	 * 列表数据
	 * 
	 * @param id
	 *            用户车型id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseResponse datalist(Integer id, HttpServletRequest request)
			throws Exception {
		// 1.判断登录
		Integer memberId = super.getMemberId(request);
		if (memberId == null) {
			return super.retEnumResponse(ServiceResponseEnum.code_1200);
		}
		HttpSession session = request.getSession();
		Integer cityId = (Integer) session
				.getAttribute(CommonAttributes.GEO_CITY_CODE);
		if (cityId == null) {
			cityId = 176;// TODO 临时方案
		}
		// 2.根据当前用户默认车型查找服务
		SimpleModelDetail simpleModelDetail = null;
		if (id == null) {// 为null默认车型
			MemberModelEntity memberModelEntity = new MemberModelEntity();
			memberModelEntity.setMemberId(memberId);
			memberModelEntity.setDefaultFlag(MemberModelTypeEnum.type.getId());
			List<MemberModelEntity> datas = memberModelService
					.findListByCondition(memberModelEntity);
			if (!(datas != null && datas.size() > 0)) {// 没有默认爱车，请添加爱车
				return super.retEnumResponse(ServiceResponseEnum.code_1201);
			}
			// 3.查询服务列表
			Integer mmid = datas.get(0).getId();
			simpleModelDetail = serviceService.getSimpleInfo(mmid, cityId);

		} else {
			simpleModelDetail = serviceService.getSimpleInfo(id, cityId);
		}
		return super.returnResponse("0000", simpleModelDetail);
	}

	/**
	 * 
	 * 服务详情
	 * 
	 * @param modelId
	 *            车系Id
	 * @param serviceCode
	 *            服务code
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public BaseResponse info(Integer modelId, String serviceCode,
			HttpServletRequest request) throws Exception {
		ServiceMode serviceMode = serviceModelService.findDetailed(serviceCode,
				modelId);
		if (serviceMode != null) {
			List<CompanyEntity> companyLists = companyService
					.findListByserviceCode(serviceCode);
			// 2015-07-03 lilong 处理修理厂距离，写的感觉有点复杂，先这样吧，时间紧O(∩_∩)O~
			if (companyLists != null && companyLists.size() > 0) {
				HttpSession session = request.getSession();
				String longitude = (String) session
						.getAttribute(CommonAttributes.GEO_LONGITUDE);
				String latitude = (String) session
						.getAttribute(CommonAttributes.GEO_LATITUDE);
				if (longitude != null && latitude != null) {
					List<Map<String, Object>> nearbylist = BaiduLBSApi
							.getNearby(longitude, latitude,
									CommonAttributes.GEO_COMPANY_ID,
									CommonAttributes.GEO_COMPANY_RADIUS,
									CommonAttributes.GEO_COMPANY_QUERY);
					if (nearbylist != null && nearbylist.size() > 0) {
						// Set<CompanyEntity> companys = new LinkedHashSet<>();
						for (Map<String, Object> nearby : nearbylist) {
							for (CompanyEntity company : companyLists) {
								if (company.getId().equals(
										nearby.get("company_id"))) {
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
			// end
			serviceMode.setRepairList(companyLists);
			serviceMode.setStartDate(DateUtils.addDay(
					DateUtils.getDayStart(new Date()), 1));
		}
		return super.returnResponse("0000", serviceMode);
	}

}
