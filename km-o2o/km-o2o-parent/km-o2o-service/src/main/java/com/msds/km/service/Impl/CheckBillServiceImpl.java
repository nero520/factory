package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CheckBillEntity;
import com.msds.km.mapper.CheckBillMapper;
import com.msds.km.service.CheckBillService;

/**
 * 
 * <br>
 * <b>功能：</b>CheckBillService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-22 16:16:38 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("checkBillService")
public class CheckBillServiceImpl extends BaseServiceImpl<CheckBillEntity> implements CheckBillService{

	@Autowired
    private CheckBillMapper checkBillMapper;
		
	public CheckBillMapper baseMapper() {
		return checkBillMapper;
	}

}
