package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ActivityNewDetailMapper;
import com.msds.km.entity.ActivityNewDetailEntity;
import com.msds.km.service.ActivityNewDetailService;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewDetailService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-23 13:56:18 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("activityNewDetailService")
public class ActivityNewDetailServiceImpl extends BaseServiceImpl<ActivityNewDetailEntity> implements ActivityNewDetailService{
	private final static Logger log= Logger.getLogger(ActivityNewDetailService.class);

	@Autowired
    private ActivityNewDetailMapper activityNewDetailMapper;
		
	public ActivityNewDetailMapper baseMapper() {
		return activityNewDetailMapper;
	}

	@Override
	public void deleteByActivitySn(String activitySn) throws Exception {
		activityNewDetailMapper.deleteByActivitySn(activitySn);
		
	}

}
