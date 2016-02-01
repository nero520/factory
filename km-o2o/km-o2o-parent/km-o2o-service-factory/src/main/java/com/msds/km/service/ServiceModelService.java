package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.ServiceModelEntity;
import com.msds.km.vo.Service;
import com.msds.km.vo.ServiceMode;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ServiceModelService extends BaseService<ServiceModelEntity> {

	/**
	 * 查询服务车型详细数据，包括服务、车型、商品、工时等
	 * 
	 * @Description TODO
	 * @param serviceCode
	 * @param modeId
	 * @return
	 * @return ServiceMode
	 */
	ServiceMode findDetailed(String serviceCode, Integer modeId);

	/**
	 * 
	 *  查询服务列表
	 * @param mmodelId
	 *        车系ID
	 * @param cityId
	 *        市Id
	 * @return
	 */
	List<Service> findServiceLists(Integer mmodelId,Integer cityId);
}
