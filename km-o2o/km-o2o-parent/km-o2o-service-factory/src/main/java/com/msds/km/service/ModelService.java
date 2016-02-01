package com.msds.km.service;

import java.util.List;
import java.util.Map;

import com.msds.base.service.BaseService;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ModelEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ModelService extends BaseService<ModelEntity> {

	/**
	 * 查询汽车品牌
	 * @return
	 */
	public Map<String,Object> queryBrandModels();
	
	/**
	 * 查询车型
	 * @param model
	 * @return
	 */
	public List<ModelEntity> queryVehicle(ModelEntity model);
	
	/**
	 * 
	 * 根据车型明细Id查询LOGO
	 * @param id
	 * @return
	 */
	String findLogoById(Integer id);
	
}
