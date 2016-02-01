package com.msds.km.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.AreaEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.AreaService;
import com.msds.lbs.BaiduLBSApi;

/**
 * 地理位置
 * 
 * @ClassName GeolcController
 * @Description TODO
 * @author LiLong
 * @date 2015年6月11日 上午10:18:19
 * 
 */
@Controller
@RequestMapping("/geolc")
public class GeolcController extends BaseController {

	@Resource(name = "areaService")
	private AreaService areaService;

	/**
	 * 获取城市
	 * 
	 * @Description TODO
	 * @param longitude
	 * @param latitude
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/eocoding")
	public BaseResponse geocoding(String longitude, String latitude,
			Integer cityCode, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String city = null;
		String address = null;
		if (cityCode != null) {
			try {
				AreaEntity areaEntity = areaService.findById(cityCode);
				if (areaEntity != null) {
					cityCode = areaEntity.getId();
					address = areaEntity.getName();
					city = areaEntity.getName();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (longitude != null && latitude != null) {
				session.setAttribute(CommonAttributes.GEO_LONGITUDE, longitude);
				session.setAttribute(CommonAttributes.GEO_LATITUDE, latitude);
				Map<String, Object> location = BaiduLBSApi.getAddress(
						longitude, latitude);
				if (location != null) {
					address = String.valueOf(location.get("address"));
					city = String.valueOf(location.get("city"));
					String province = String.valueOf(location.get("province"));
					cityCode = areaService.findIdByName(province, city);
				}
			}
		}
		session.setAttribute(CommonAttributes.GEO_ADDRESS, address);
		session.setAttribute(CommonAttributes.GEO_CITY_CODE, cityCode);
		return super.returnResponse("0000", city);
	}
}
