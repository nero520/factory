package com.msds.km.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ModelMapper;
import com.msds.km.entity.ModelEntity;
import com.msds.km.service.ModelService;

/**
 * 
 * <br>
 * <b>功能：</b>ModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("modelService")
public class ModelServiceImpl extends BaseServiceImpl<ModelEntity> implements ModelService{

	@Autowired
    private ModelMapper modelMapper;
		
	public ModelMapper baseMapper() {
		return modelMapper;
	}

	@Override
	public Map<String, Object> queryBrandModels() {
		ModelEntity model = new ModelEntity();
		model.setLevel(1);//一级汽车品牌
		List<ModelEntity> models = this.modelMapper.findListByCondition(model);
		Set<String> letters = new TreeSet<String>(); //自动按升序排序字母并且去重复
		for(ModelEntity m : models) {
			letters.add(m.getFirstLetter().toUpperCase());
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("letters", letters.toArray(new String[0]));
		map.put("models", models);
		return map;
	}

	@Override
	public List<ModelEntity> queryVehicle(ModelEntity model) {
		List<ModelEntity> modelList = new ArrayList<ModelEntity>();
		modelList = modelMapper.findListByCondition(model);
		if (modelList != null && modelList.size() > 0) {
			for (ModelEntity me : modelList) {
				ModelEntity m = new ModelEntity();
				m.setPid(me.getId());
				me.setChildrenList(modelMapper.findListByCondition(m));
			}
		}
		return modelList;
	}

	@Override
	public String findLogoById(Integer id) {
		
		return modelMapper.findLogoById(id);
	}
	
	

}
