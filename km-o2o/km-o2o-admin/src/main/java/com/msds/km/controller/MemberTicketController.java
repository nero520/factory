package com.msds.km.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.km.base.BaseController;
import com.msds.km.entity.CouponEntity;
import com.msds.km.entity.MemberTicketEntity;
import com.msds.km.enums.ActivityNewTypeEnum;
import com.msds.km.enums.CouponStateEnum;
import com.msds.km.enums.MemberTicketStateEnum;
import com.msds.km.service.MemberTicketService;
import com.msds.util.DateUtils;
 
/**
 * 
 * <br>
 * <b>功能：</b>MemberTicketController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-28 15:36:00 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/memberTicket") 
public class MemberTicketController extends BaseController{
	
	private final static Logger log= Logger.getLogger(MemberTicketController.class);
	
	@Autowired
	private MemberTicketService memberTicketService; 
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/memberTicket/memberTicket_list",null); 
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public Object datalist(MemberTicketEntity entity,HttpServletRequest request) throws Exception{
		Date afterDate = entity.getAfterDate();
		if(afterDate != null){
			entity.setAfterDate(DateUtils.getDayEnd(afterDate));
		}
		Date beforeDate = entity.getBeforeDate();
		if(beforeDate != null){
			entity.setBeforeDate(DateUtils.getDayStart(beforeDate));
		}
		List<MemberTicketEntity> dataList = memberTicketService.queryByList(entity);
		for (MemberTicketEntity memberTicket : dataList) {
			String stateName = MemberTicketStateEnum.getEnumById(memberTicket.getState()).getName();
			memberTicket.setStateName(stateName);
			String privilegeTypeName = ActivityNewTypeEnum.getEnumById(memberTicket.getPrivilegeType()).getName();
			memberTicket.setPrivilegeTypeName(privilegeTypeName);
		}
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public Object updateState(String id,HttpServletRequest request) throws Exception{
		MemberTicketEntity entity = memberTicketService.findById(id);
		if(entity.getState() == MemberTicketStateEnum.noUse.getId()){
			entity.setState(MemberTicketStateEnum.use.getId());
		}
		memberTicketService.update(entity);
		return sendSuccessMessage();
	}
	
	/**
	 * 添加或修改数据
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody MemberTicketEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			memberTicketService.add(entity);
		}else{
			entity.setModifyDate(date);
			memberTicketService.update(entity);
		}
		return sendSuccessMessage();
	}
	
	/**
	 * 获取数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	@ResponseBody
	public Object getId(String id,HttpServletRequest request) throws Exception{
		MemberTicketEntity entity  = memberTicketService.findById(id);
		if(entity  == null){
			return sendFailureMessage("没有找到对应的记录!");
		}
		return entity;
	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String[] id,HttpServletRequest request) throws Exception{
		memberTicketService.delete(id);
		return sendSuccessMessage();
	}

}
