package com.msds.km.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.CardUsedDetailEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CardUsedDetailMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-14 10:57:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface CardUsedDetailMapper extends BaseMapper<CardUsedDetailEntity> {

	List<CardUsedDetailEntity> findListByCardNo(String cardNo);

	List<CardUsedDetailEntity> findListByCardNoAndType(
			@Param("cardNo") String cardNo, @Param("type") Integer type);

}
