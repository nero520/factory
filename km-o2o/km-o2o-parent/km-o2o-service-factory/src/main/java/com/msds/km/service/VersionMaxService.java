package com.msds.km.service;

import com.msds.base.service.BaseService;
import com.msds.km.entity.VersionMaxEntity;
import com.msds.km.model.VersionModel;

/**
 * 
 * <br>
 * <b>功能：</b>VersionMaxService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-01-13 09:55:50 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface VersionMaxService extends BaseService<VersionMaxEntity> {
	public VersionModel getCurrentVersionByOsType(int osType) throws Exception;
}
