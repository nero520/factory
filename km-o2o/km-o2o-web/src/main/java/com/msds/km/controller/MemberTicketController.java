package com.msds.km.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.CodeGenerator;
import com.msds.km.base.BaseController;
import com.msds.km.entity.ActivityNewDetailEntity;
import com.msds.km.entity.ActivityNewEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.MemberTicketEntity;
import com.msds.km.enums.ActivityNewDetailStateEnum;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.enums.MemberTicketStateEnum;
import com.msds.km.service.ActivityNewDetailService;
import com.msds.km.service.ActivityNewService;
import com.msds.km.service.CouponService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.MemberTicketService;
import com.msds.km.service.ModelService;

/**
 * 
 * <br>
 * 活动 <b>功能：</b>ActivityController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/memberTicket")
public class MemberTicketController extends BaseController {

	@Resource
	private ActivityNewService activityNewService;
	@Resource
	private CouponService couponService;
	@Resource
	private MemberTicketService memberTicketService;
	@Resource
	private MemberModelService memberModelService;
	@Resource
	private ModelService modelService;
	@Resource
	private CodeGenerator codeGenerator;
	@Resource
	private ActivityNewDetailService activityNewDetailService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object findMemberTicket(HttpServletRequest request) throws Exception{
		MemberEntity memberEntity = getMemberInfo(request);
		if(memberEntity==null){
			return FAILURE;
		}
		MemberTicketEntity entity = new MemberTicketEntity();
		entity.setPhone(memberEntity.getPhone());
		List<MemberTicketEntity> entities = memberTicketService.queryByList(entity);
		return returnSuccessResponse(entities);
	}
	

	/**
	 * 参加活动
	 * @throws Exception 
	 */
	@RequestMapping("/campaign")
	@ResponseBody
	public Object campaign(String sn ,  HttpServletRequest request) throws Exception{
		
		//查询活动信息
		ActivityNewEntity activityEntity = activityNewService.findActivityBySn(sn);
		//通过活动sn查询相关联的优惠券和红包
		ActivityNewDetailEntity t = new ActivityNewDetailEntity();
		t.setActivitySn(sn);
		List<ActivityNewDetailEntity> activityNewDetails = activityNewDetailService.findListByCondition(t);
		ActivityNewDetailEntity entity = null;
		if(activityEntity==null && activityNewDetails==null){
			return FAILURE;
		}
		
		for (int i = 0; i < activityNewDetails.size(); i++) {
			entity=activityNewDetails.get(i);
			//判断用户是否参加过这个活动
			MemberTicketEntity memberTicketEntity = new MemberTicketEntity();
			memberTicketEntity.setCouponSn(entity.getCouponSn());
			memberTicketEntity.setPhone(getMemberInfo(request).getPhone());
			List<MemberTicketEntity> memberTicketEntities = memberTicketService.findListByCondition(memberTicketEntity);
			if(memberTicketEntities!=null &&  memberTicketEntities.size()>0){
				return returnResponse("2200", "您已经参加过这个活动"); 
			}
			Date date = new Date();
			//活动没有过期则允许参加
			if(!date.before(activityEntity.getStartDate()) && !date.after(activityEntity.getEndDate()) && ActivityNewDetailStateEnum.use.getId()==entity.getState()){
				//用户车辆信息
				MemberModelEntity modelEntity = memberModelService.queryDefaultById(getMemberId(request));
				
				MemberTicketEntity ticketEntity= new MemberTicketEntity();
				ticketEntity.setActivitySn(sn);
				ticketEntity.setActivityName(activityEntity.getActivityName());
				ticketEntity.setCarType(modelEntity.getModelGroupName());
				ticketEntity.setCouponName(entity.getCouponName());
				ticketEntity.setCouponSn(entity.getCouponSn());
				ticketEntity.setCreateDate(new Date());
				ticketEntity.setStartTime(entity.getStartDate());
				ticketEntity.setExpirationTime(entity.getEndDate());
				ticketEntity.setLicense(modelEntity.getRegion()+modelEntity.getLicense());
				ticketEntity.setModifyDate(new Date());
				ticketEntity.setPhone(getMemberInfo(request).getPhone());
				ticketEntity.setPrivilegeType(entity.getType());
				ticketEntity.setPromotionCode(codeGenerator.getCode(CodeTypeEnum.member_ticket_code.getName(), "",CodeTypeEnum.member_ticket_code.getId() ));
				ticketEntity.setState(MemberTicketStateEnum.noUse.getId());
				memberTicketService.add(ticketEntity);
				}
			}
		
		return SUCCESSFUL;
	}
	
}
