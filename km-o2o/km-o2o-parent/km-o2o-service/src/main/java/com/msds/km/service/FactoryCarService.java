package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.FactoryCarEntity;
import com.msds.km.vo.DateRankVo;
import com.msds.km.vo.RankVo;

/**
 * 
 * <br>
 * <b>功能：</b>FactoryCarService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface FactoryCarService extends BaseService<FactoryCarEntity> {

	/**
	 * 按日、月统计
	 * @param state
	 * @return
	 */
	List<RankVo> findRankList(Integer state);
	
	/**
	 * 根据修理厂ID查询日统计
	 * @param id
	 * @return
	 */
	List<DateRankVo> findDayRankListById(Integer id);
}
