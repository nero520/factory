package com.msds.km.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.mapper.BespeakMapper;
import com.msds.km.model.BespeakDetailModel;
import com.msds.km.model.BespeakModel;
import com.msds.km.model.ListModel;
import com.msds.km.service.BespeakService;
import com.msds.open.api.OpenApiException;
import com.msds.util.DateUtils;
import com.msds.util.NumberUtils;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakServiceImpl<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("bespeakService")
public class BespeakServiceImpl extends BaseServiceImpl<BespeakEntity>
		implements BespeakService {

	@Autowired
	private BespeakMapper bespeakMapper;

	public BespeakMapper baseMapper() {
		return bespeakMapper;
	}

	@Override
	public void updateBespeak(BespeakEntity entity) {

		bespeakMapper.update(entity);
	}

	@Override
	public void addBespeak(BespeakEntity entity) throws Exception {

		bespeakMapper.addBespeak(entity);
	}

	@Override
	public BespeakEntity findByBespeakId(BespeakEntity bespeakEntity) {

		return bespeakMapper.findByBespeakId(bespeakEntity);
	}

	@Override
	public List<ProcessEntity> getFirstLevel() {
		// TODO Auto-generated method stub
		return bespeakMapper.getFirstLevel();
	}

	@Override
	public List<ProcessEntity> getSecondById(Integer id) {
		// TODO Auto-generated method stub
		return bespeakMapper.getSecondById(id);
	}

	@Override
	public List<MemberEntity> getMemberList(MemberEntity member) {
		// TODO Auto-generated method stub
		return bespeakMapper.getMemberList(member);
	}

	@Override
	public ListModel<BespeakModel> getBespeakModelList(
			BespeakEntity bespeakEntity) {
		List<BespeakModel> bespeakModelList = new ArrayList<BespeakModel>();
		int totalCount = this.bespeakMapper.queryBespeakCount(bespeakEntity);
		List<BespeakEntity> bespeakEntityList =   bespeakMapper.getBespeakModelList(bespeakEntity);
		 
		BespeakModel bespeakModel = null;
		for(BespeakEntity bespeak : bespeakEntityList){
			bespeakModel = new BespeakModel();
			bespeakModel.setBespeakSn(bespeak.getBespeakSn());
			bespeakModel.setBespeakDate(DateUtils.DateToString(bespeak.getBespeakDate()));
			bespeakModel.setLicense(bespeak.getLicense());
			bespeakModel.setModelGroupName(bespeak.getModelGroupName());
			bespeakModel.setPhone(bespeak.getPhone());
			bespeakModel.setStateName("已确认");
			bespeakModelList.add(bespeakModel);
		}
		
		ListModel<BespeakModel> models = new ListModel<BespeakModel>();
		models.setModels(bespeakModelList);
		models.setTotalCount(totalCount);
		return models;
		
	}

	@Override
	public int queryBespeakCount(BespeakEntity bespeakEntity) {
		return bespeakMapper.queryBespeakCount(bespeakEntity);
	}

	@Override
	public BespeakDetailModel findDetailedBySnAndCompanyId(String bespeakSn,
			Integer companyId) throws Exception {
		BespeakEntity bespeak = bespeakMapper.findDetailedBySnAndCompanyId(bespeakSn,companyId);
		if(bespeak == null){
			throw new OpenApiException("预约单不存在");
		}
//		BespeakDetailEntity queryBespeak = new BespeakDetailEntity();
//		queryBespeak.setBespeakSn(bespeakSn);
//		List<BespeakDetailEntity> bespeakDetails = bespeakDetailService.findListByCondition(queryBespeak);
//		if(bespeakDetails.size() <= 0){
//			throw new OpenApiException("预约单服务项目信息不存在");
//		}
		
		
		BespeakDetailModel bespeakDetailModel = new BespeakDetailModel();
		bespeakDetailModel.setAnswer(bespeak.getAnswer());
		bespeakDetailModel.setBespeakDate(DateUtils.DateToString(bespeak.getBespeakDate()));
		bespeakDetailModel.setBespeakSn(bespeakSn);
		bespeakDetailModel.setCompanyAddress(bespeak.getCompanyAddress());
		bespeakDetailModel.setCompanyName(bespeak.getCompanyName());
		bespeakDetailModel.setCompanyTel(bespeak.getCompanyTel());
		bespeakDetailModel.setMemberName(bespeak.getMemberName());
		bespeakDetailModel.setMileage(bespeak.getMileage() == null?"0":(bespeak.getMileage().intValue()+""));
		bespeakDetailModel.setModelGroupName(bespeak.getModelGroupName());
		bespeakDetailModel.setPhone(bespeak.getPhone());
		bespeakDetailModel.setProblem(bespeak.getProblem());
		bespeakDetailModel.setStateName("已确认");
		bespeakDetailModel.setTotalPrice(NumberUtils.formatMoney(bespeak.getTotalPrice()));
		bespeakDetailModel.setVin(bespeak.getVin());
		bespeakDetailModel.setLicense(bespeak.getLicense());
		bespeakDetailModel.setBespeakType(bespeak.getBespeakType());
		bespeakDetailModel.setServiceContent(bespeak.getServiceContent());
//		List<ServiceItemModel> serviceItems = new ArrayList<ServiceItemModel>();
//		ServiceItemModel serviceItemModel = null;
//		for(BespeakDetailEntity bespeakDetail : bespeakDetails){
//			serviceItemModel = new ServiceItemModel();
//			serviceItemModel.setPrice(bespeakDetail.getPrice().toString());
//			serviceItemModel.setServiceCategory(bespeakDetail.getProcessPname());
//			serviceItemModel.setServiceName(bespeakDetail.getProcessName());
//			serviceItems.add(serviceItemModel);
//		}
//		
//		bespeakDetailModel.setServiceItems(serviceItems);
		
		return bespeakDetailModel;
	}
	

}
