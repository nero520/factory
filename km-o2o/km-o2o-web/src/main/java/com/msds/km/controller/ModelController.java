package com.msds.km.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.entity.ModelEntity;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.ModelService;

/**
 * ModelController
 * 
 * @Description: 汽车品牌，车型，排量年份三级
 * @author lilong
 * @date 2015年08月11日 13:42:19
 */
@Controller
@RequestMapping("/model")
public class ModelController extends BaseController {

	@Autowired
	private MemberModelService memberModelService;

	@Autowired
	private ModelService modelService;

	/**
	 * 获取汽车品牌及相应的字母
	 * 
	 * @return
	 */
	@RequestMapping(value = "/querybrands", method = RequestMethod.GET)
	public BaseResponse queryBrandModels() {
		ModelEntity model = new ModelEntity();
		model.setLevel(1);
		model.setIs_show(1);
		List<ModelEntity> modelList = null;
		try {
			modelList = this.modelService.findListByCondition(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (modelList != null) {
			Set<String> letters = new TreeSet<String>();
			for (ModelEntity m : modelList) {
				letters.add(m.getFirstLetter().toUpperCase());
			}
			map.put("letters", letters.toArray(new String[0]));
			map.put("models", modelList);
		}
		return super.returnResponse("0000", map);
	}

	/**
	 * 根据 Id查询车系、查询排量+年份
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/querySubset", method = RequestMethod.GET)
	public BaseResponse queryVehicle(Integer id, HttpServletRequest request) {
		List<ModelEntity> modelList = null;
		if (id != null) {
			ModelEntity model = new ModelEntity();
			model.setPid(id);
			model.setIs_show(1);
			try {
				modelList = modelService.findListByCondition(model);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.returnResponse("0000", modelList);
	}

}
