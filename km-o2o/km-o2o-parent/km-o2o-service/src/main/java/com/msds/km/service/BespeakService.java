package com.msds.km.service;

import java.util.Date;
import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.km.enums.BespeakTypeEnum;
import com.msds.km.enums.SourceEnum;
import com.msds.km.vo.BespeakOrderDetailVo;
import com.msds.km.vo.Order;

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

	
	public List<BespeakEntity> getBespeakList(BespeakEntity entity);
	
	public int getBespeakListCount(BespeakEntity entity);
	
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
	public BespeakEntity findByBespeakId(BespeakEntity entity);
	
	public List<ProcessEntity> getFirstLevel();
	
	public List<ProcessEntity> getSecondById(Integer id);
	
	public List<MemberEntity> getMemberList(MemberEntity member);

	/**
	 * 
	 * 通过修理厂Id与预约单查询详情列表
	 * @param bespeakSn
	 * @param id
	 * @return
	 */
	public BespeakOrderDetailVo findBespeakOrderInfo(String bespeakSn, Integer id);
	
	public BespeakEntity findDetailedBySnAndCompanyId(String bespeakSn,
			Integer companyId) throws Exception;
	
	/**
	 * 车主预约单消息列表
	 * @param bespeakEntity
	 * @return
	 */
	public List<BespeakEntity> getMemberBespeakList(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单消息列表
	 * @param bespeakEntity
	 * @return
	 */
	public List<BespeakEntity> queryBespeakList(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单明细
	 * @param bespeakEntity
	 * @return
	 */
	public BespeakEntity findDetailByBespeak(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单消息列表(菜单链接)
	 * @param bespeakEntity
	 * @return
	 * @author lijingkun
	 */
	public List<BespeakEntity> findBespeakList(BespeakEntity bespeakEntity);

	/**创建预约单
	 * @param sn
	 * @param memberEntity
	 * @param memberModelId
	 * @param serviceCode
	 * @param companyId
	 * @param serviceTime
	 * @param remark
	 * @param online
	 * @param toconfirmation
	 * @param wap
	 * @return
	 * @throws Exception 
	 */
	public BespeakEntity create(String sn, MemberEntity memberEntity,
			Integer memberModelId, String serviceCode, Integer companyId,
			Date serviceTime, String remark, BespeakTypeEnum online,
			BespeakStateEnum toconfirmation, SourceEnum wap) throws Exception;

	public BespeakEntity findBySnAndMemberId(String bespeakSn, Integer memberId);
	
}
