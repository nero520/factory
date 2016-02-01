package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.CompanyEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface CompanyService extends BaseService<CompanyEntity> {

	/**
	 * 
	 * 根据服务code查询相关维修厂信息
	 * @param serviceCode
	 * @return
	 */
	List<CompanyEntity> findListByserviceCode(String serviceCode);

}
