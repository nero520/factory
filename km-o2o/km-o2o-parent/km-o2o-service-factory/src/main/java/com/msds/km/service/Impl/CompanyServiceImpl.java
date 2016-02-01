package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.CompanyMapper;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.service.CompanyService;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:35 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<CompanyEntity> implements CompanyService{

	@Autowired
    private CompanyMapper companyMapper;
		
	public CompanyMapper baseMapper() {
		return companyMapper;
	}

	@Override
	public List<CompanyEntity> findListByserviceCode(String serviceCode) {
		
		return companyMapper.findListByserviceCode(serviceCode);
	}

	
}
