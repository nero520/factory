package com.msds.km.vo;

import java.util.List;

import com.msds.km.entity.CheckBillNumEntity;
import com.msds.km.entity.MemberModelEntity;

public class CheckBillVo {
	
	private MemberModelEntity modelEntity;
	private List<CheckBillNumEntity> billEntities;
	
	private int billCount;


	
	public int getBillCount() {
		return billCount;
	}
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}
	public List<CheckBillNumEntity> getBillEntities() {
		return billEntities;
	}
	public void setBillEntities(List<CheckBillNumEntity> billEntities) {
		this.billEntities = billEntities;
	}
	public MemberModelEntity getModelEntity() {
		return modelEntity;
	}
	public void setModelEntity(MemberModelEntity modelEntity) {
		this.modelEntity = modelEntity;
	}
}
