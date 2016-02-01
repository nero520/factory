package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.AdminEntity;
/**
 * 
 * <br>
 * <b>功能：</b>AdminMapper<br>
 * <b>作者：</b>xiaoxiong<br>
 * <b>日期：</b> 2015-12-24 11:04:44 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface AdminMapper extends BaseMapper<AdminEntity> {

	AdminEntity findByAdmin(AdminEntity entity);
	
	
}
