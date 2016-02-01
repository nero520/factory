package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.VersionEntity;
import com.msds.km.entity.VersionMaxEntity;
import com.msds.km.enums.OsTypeEnum;
import com.msds.km.mapper.VersionMaxMapper;
import com.msds.km.model.VersionModel;
import com.msds.km.service.VersionMaxService;
import com.msds.km.service.VersionService;

/**
 * 
 * <br>
 * <b>功能：</b>VersionMaxService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-01-13 09:55:50 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("versionMaxService")
public class VersionMaxServiceImpl extends BaseServiceImpl<VersionMaxEntity> implements VersionMaxService{
	private final static Logger log= Logger.getLogger(VersionMaxService.class);

	@Autowired
    private VersionMaxMapper versionMaxMapper;
	
	@Autowired
    private VersionService versionService;
			
	public VersionMaxMapper baseMapper() {
		return versionMaxMapper;
	}
	
	@Override
	public VersionModel getCurrentVersionByOsType(int osType) throws Exception {
		OsTypeEnum osTypeEnum = OsTypeEnum.getEnumById(osType);
		if(osTypeEnum == null){
			log.error("param osType : " + osType + ", invalid");
			throw new Exception();
		}
		VersionMaxEntity versionMaxEntity = versionMaxMapper.getMaxByOsType(osType);
		if(versionMaxEntity == null){
			log.error("未找到 osType : " + osType + ",版本数据");
			throw new Exception();
		}
		VersionEntity versionEntity = versionService.findById(versionMaxEntity.getVersionId());
		VersionModel versionModel = new VersionModel();
		versionModel.setOsType(osType);
		versionModel.setUrl(versionEntity.getUrl());
		versionModel.setVersionCode(versionEntity.getVersionCode());
		versionModel.setVersionName(versionEntity.getVersionName());
		versionModel.setForceUpdate(versionEntity.getForceUpdate() == 1 ? true : false);
		versionModel.setDescription(versionEntity.getDescription() != null ? versionEntity.getDescription() : "");
		
		return versionModel;
	}

}
