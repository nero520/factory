package com.msds.km.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.FactoryCarEntity;
import com.msds.km.vo.DateRankVo;
import com.msds.km.vo.RankVo;
/**
 * 
 * <br>
 * <b>功能：</b>FactoryCarMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface FactoryCarMapper extends BaseMapper<FactoryCarEntity> {

	/**
	 * 按日、月统计
	 * @param state
	 * @return
	 */
	List<RankVo> findRankList(@Param("state") Integer state);
	
	/**
	 * 根据修理厂ID查询日统计
	 * @param id
	 * @return
	 */
	List<DateRankVo> findDayRankListById(@Param("id") Integer id);
	
	
}
