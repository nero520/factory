package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.CouponEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CouponService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface CouponService extends BaseService<CouponEntity> {

	public List<CouponEntity> findInIds(String[] ids) throws Exception;
}
