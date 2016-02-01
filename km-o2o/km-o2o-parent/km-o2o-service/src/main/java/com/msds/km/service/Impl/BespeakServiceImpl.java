package com.msds.km.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.km.enums.BespeakTypeEnum;
import com.msds.km.enums.SourceEnum;
import com.msds.km.mapper.BespeakMapper;
import com.msds.km.service.BespeakService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.ServiceService;
import com.msds.km.vo.BespeakOrderDetailVo;
import com.msds.util.DateUtils;

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
	@Resource(name = "serviceService")
	private ServiceService serviceService;
	@Resource(name = "memberModelService")
	private MemberModelService memberModelService;
	@Resource(name = "companyService")
	private CompanyService companyService;

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
	public BespeakEntity findByBespeakId(BespeakEntity entity) {

		return bespeakMapper.findByBespeakId(entity);
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
	public List<BespeakEntity> getBespeakList(BespeakEntity entity) {
		return bespeakMapper.getBespeakList(entity);
	}

	@Override
	public int getBespeakListCount(BespeakEntity entity) {
		return bespeakMapper.getBespeakListCount(entity);
	}

	@Override
	public BespeakOrderDetailVo findBespeakOrderInfo(String bespeakSn,
			Integer id) {

		return bespeakMapper.findBespeakOrderInfo(bespeakSn, id);
	}

	@Override
	public BespeakEntity findDetailedBySnAndCompanyId(String bespeakSn,
			Integer companyId) throws Exception {

		return bespeakMapper.findDetailedBySnAndCompanyId(bespeakSn, companyId);
	}

	@Override
	public List<BespeakEntity> getMemberBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.queryMemberBespeakCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.getMemberBespeakList(bespeakEntity);
	}

	@Override
	public List<BespeakEntity> queryBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.getBespeakListCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.queryBespeakList(bespeakEntity);
	}

	@Override
	public BespeakEntity findDetailByBespeak(BespeakEntity bespeakEntity) {
		return bespeakMapper.findDetailByBespeak(bespeakEntity);
	}

	@Override
	public List<BespeakEntity> findBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.queryByBespeakCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.findBespeakList(bespeakEntity);
	}

	@Override
	public BespeakEntity create(String bespeakSn, MemberEntity memberEntity,
			Integer memberModelId, String serviceCode, Integer companyId,
			Date serviceTime, String remark, BespeakTypeEnum bespeakType,
			BespeakStateEnum bespeakState, SourceEnum source) throws Exception {
		Assert.hasText(bespeakSn);
		Assert.notNull(memberModelId);
		Assert.hasText(serviceCode);
		Assert.notNull(companyId);
		Assert.notNull(serviceTime);

		ServiceEntity serviceEntity = serviceService.findByCode(serviceCode);
		if (serviceEntity == null)
			return null;
		CompanyEntity companyEntity = companyService.findById(companyId);
		if (companyEntity == null)
			return null;
		MemberModelEntity memberModelEntity = memberModelService
				.findById(memberModelId);
		if (memberModelEntity == null)
			return null;
		BespeakEntity bespeakEntity = new BespeakEntity();
		bespeakEntity.setMemberId(memberEntity.getId());
		bespeakEntity.setServiceContent(serviceEntity.getServiceName());
		bespeakEntity.setTotalPrice(serviceEntity.getPrice());
		bespeakEntity.setMemberModelId(memberModelId);

		bespeakEntity.setVin(memberModelEntity.getVin());
		bespeakEntity.setModelGroupName(memberModelEntity.getModelGroupName());
		bespeakEntity.setMileage(memberModelEntity.getMileage());
		bespeakEntity.setLicense(memberModelEntity.getRegion()
				+ memberModelEntity.getLicense());

		Date date = new Date();
		bespeakEntity.setCreateDate(date);
		bespeakEntity.setModifyDate(date);
		bespeakEntity.setBespeakSn(bespeakSn);
		bespeakEntity.setState(bespeakState.getId());
		bespeakEntity.setBespeakType(bespeakType.getId());
		bespeakEntity.setRemark(remark);
		bespeakEntity.setSource(source.getId());
		bespeakEntity.setCompanyId(companyId);
		bespeakEntity.setBespeakDate(serviceTime);
		if (DateUtils.isAm(serviceTime)) {
			bespeakEntity.setIsAm(1);
		} else {
			bespeakEntity.setIsAm(0);
		}

		bespeakMapper.addBespeak(bespeakEntity);

		bespeakEntity.setCompanyName(companyEntity.getName());
		bespeakEntity.setCompanyTel(companyEntity.getTelephone());
		bespeakEntity.setCompanyAddress(companyEntity.getFullAddress());

		return bespeakEntity;
	}

	@Override
	public BespeakEntity findBySnAndMemberId(String bespeakSn, Integer memberId) {
		return bespeakMapper.findBySnAndMemberId(bespeakSn, memberId);
	}
}
