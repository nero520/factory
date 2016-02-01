package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.VersionEntity;
import com.msds.km.mapper.VersionMapper;
import com.msds.km.service.VersionService;

/**
 * 
 * <br>
 * <b>功能：</b>VersionService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-01-13 09:55:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("versionService")
public class VersionServiceImpl extends BaseServiceImpl<VersionEntity> implements VersionService{
	private final static Logger log= Logger.getLogger(VersionService.class);

	@Autowired
    private VersionMapper versionMapper;
		
	public VersionMapper baseMapper() {
		return versionMapper;
	}

}
