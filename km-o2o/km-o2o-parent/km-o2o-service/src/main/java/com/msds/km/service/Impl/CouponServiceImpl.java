package com.msds.km.service.Impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.CouponMapper;
import com.msds.km.entity.CouponEntity;
import com.msds.km.service.CouponService;

/**
 * 
 * <br>
 * <b>功能：</b>CouponService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("couponService")
public class CouponServiceImpl extends BaseServiceImpl<CouponEntity> implements CouponService{
	private final static Logger log= Logger.getLogger(CouponService.class);

	@Autowired
    private CouponMapper couponMapper;
		
	public CouponMapper baseMapper() {
		return couponMapper;
	}

	@Override
	public List<CouponEntity> findInIds(String[] ids) throws Exception {
		if(ids!=null && ids.length!=0){
			return couponMapper.findInIds(ids);
		}
		return null;
	}
}
