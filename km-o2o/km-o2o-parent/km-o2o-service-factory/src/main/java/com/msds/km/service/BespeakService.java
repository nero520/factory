package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.model.BespeakDetailModel;
import com.msds.km.model.BespeakModel;
import com.msds.km.model.ListModel;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakService<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface BespeakService extends BaseService<BespeakEntity> {

	/**
	 * 
	 * @param entity
	 */
	public void updateBespeak(BespeakEntity entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void addBespeak(BespeakEntity entity)
			throws Exception;
	
	/**
	 * 
	 * @param bespeakSn
	 * @return
	 */
	public BespeakEntity findByBespeakId(BespeakEntity bespeakEntity);
	
	public List<ProcessEntity> getFirstLevel();
	
	public List<ProcessEntity> getSecondById(Integer id);
	
	public List<MemberEntity> getMemberList(MemberEntity member);

	public ListModel<BespeakModel> getBespeakModelList(
			BespeakEntity bespeakEntity);
	
	public int queryBespeakCount(BespeakEntity bespeakEntity);

	public BespeakDetailModel findDetailedBySnAndCompanyId(String bespeakSn,
			Integer companyId) throws Exception;
	
}
