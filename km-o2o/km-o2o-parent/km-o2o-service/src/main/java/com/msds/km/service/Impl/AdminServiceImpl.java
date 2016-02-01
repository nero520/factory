package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.AdminMapper;
import com.msds.km.entity.AdminEntity;
import com.msds.km.service.AdminService;

/**
 * 
 * <br>
 * <b>功能：</b>AdminService<br>
 * <b>作者：</b>xiaoxiong<br>
 * <b>日期：</b> 2015-12-24 11:04:44 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity> implements AdminService{
	private final static Logger log= Logger.getLogger(AdminService.class);

	@Autowired
    private AdminMapper adminMapper;
		
	public AdminMapper baseMapper() {
		return adminMapper;
	}

	@Override
	public AdminEntity findByAdmin(AdminEntity entity) {
		
		return adminMapper.findByAdmin(entity);
	}
	
	

}
