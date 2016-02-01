package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.ActivityNewEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ActivityNewService extends BaseService<ActivityNewEntity> {
	
	public ActivityNewEntity findActivityBySn(String sn);
	
	/**
	 * 查询列表
	 * @param entity
	 * @return 
	 * List<ActivityNewEntity>
	 */
	public List<ActivityNewEntity> queryList(ActivityNewEntity entity) throws Exception;
	
}
