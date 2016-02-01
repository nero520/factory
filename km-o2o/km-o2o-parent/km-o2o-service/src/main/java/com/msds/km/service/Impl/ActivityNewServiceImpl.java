package com.msds.km.service.Impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ActivityNewMapper;
import com.msds.km.entity.ActivityNewEntity;
import com.msds.km.enums.ActivityNewTypeEnum;
import com.msds.km.service.ActivityNewService;
import com.msds.util.DateUtils;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("activityNewService")
public class ActivityNewServiceImpl extends BaseServiceImpl<ActivityNewEntity> implements ActivityNewService{
	private final static Logger log= Logger.getLogger(ActivityNewService.class);

	@Autowired
    private ActivityNewMapper activityNewMapper;
		
	public ActivityNewMapper baseMapper() {
		return activityNewMapper;
	}

	@Override
	public ActivityNewEntity findActivityBySn(String sn) {
		
		return activityNewMapper.findActivityBySn(sn);
	}

	@Override
	public List<ActivityNewEntity> queryList(ActivityNewEntity entity) throws Exception{
		Date today = new Date();
		Date nowDate = new Date();
		Date afterDate = entity.getAfterDate();
		if(afterDate != null){
			entity.setAfterDate(DateUtils.getDayEnd(afterDate));
		}
		Date beforeDate = entity.getBeforeDate();
		if(beforeDate != null){
			entity.setBeforeDate(DateUtils.getDayStart(beforeDate));
		}
		nowDate = DateUtils.getDayStart(nowDate);
		entity.setNowDate(nowDate);
		List<ActivityNewEntity> dataList = this.queryByList(entity);
		for (ActivityNewEntity activityNew : dataList) {
			String typeName = ActivityNewTypeEnum.getEnumById(activityNew.getType()).getName();
			activityNew.setTypeName(typeName);
			String stateName = "";
			Date startDate = DateUtils.getDayStart(activityNew.getStartDate());
			Date endDate = DateUtils.getDayEnd(activityNew.getEndDate());
			if(activityNew.getState() == 0){
				stateName = "暂停";
			}else if(activityNew.getState() == 1){
				if(today.before(startDate)){
					stateName = "未开始";
				}else if(today.after(endDate)){
					stateName = "已结束";
				}else{
					stateName = "进行中";
				}
			}
			activityNew.setStateName(stateName);
		}
		return dataList;
	}

}
