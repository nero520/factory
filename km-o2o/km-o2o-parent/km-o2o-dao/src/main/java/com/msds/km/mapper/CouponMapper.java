package com.msds.km.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.CouponEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CouponMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface CouponMapper extends BaseMapper<CouponEntity> {
	
	public List<CouponEntity> findInIds(String[] ids) throws Exception;
}
