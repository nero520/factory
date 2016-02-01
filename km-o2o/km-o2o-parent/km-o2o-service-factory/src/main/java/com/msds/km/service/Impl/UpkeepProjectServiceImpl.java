package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.UpkeepProjectMapper;
import com.msds.km.entity.UpkeepProjectEntity;
import com.msds.km.service.UpkeepProjectService;

/**
 * 
 * <br>
 * <b>功能：</b>UpkeepProjectService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-10 15:14:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("upkeepProjectService")
public class UpkeepProjectServiceImpl extends BaseServiceImpl<UpkeepProjectEntity> implements UpkeepProjectService{
	private final static Logger log= Logger.getLogger(UpkeepProjectService.class);

	@Autowired
    private UpkeepProjectMapper upkeepProjectMapper;
		
	public UpkeepProjectMapper baseMapper() {
		return upkeepProjectMapper;
	}

}
