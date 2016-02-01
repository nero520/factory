package com.msds.km.controller;

import java.util.ArrayList;
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

import com.msds.baseinfo.common.UserInfo;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.km.base.BaseController;
import com.msds.km.entity.MaintenanceHistoryDetailEntity;
import com.msds.km.entity.MaintenanceHistoryEntity;
import com.msds.km.service.MaintenanceHistoryDetailService;
import com.msds.km.service.MaintenanceHistoryService;
 
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceHistoryController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-30 13:45:55 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/maintenanceHistory") 
public class MaintenanceHistoryController extends BaseController{
	
	private final static Logger log= Logger.getLogger(MaintenanceHistoryController.class);
	
	@Autowired
	private MaintenanceHistoryService maintenanceHistoryService; 
	
	@Autowired
	private MaintenanceHistoryDetailService maintenanceHistoryDetailService;
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/maintenanceHistory/maintenanceHistory_list",null); 
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
	public Object datalist(MaintenanceHistoryEntity entity,HttpServletRequest request) throws Exception{
		List<MaintenanceHistoryEntity> dataList = maintenanceHistoryService.queryByList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detailDataList")
	@ResponseBody
	public Object detailDataList(MaintenanceHistoryDetailEntity entity,HttpServletRequest request) throws Exception{
		List<MaintenanceHistoryDetailEntity> dataList = new ArrayList<MaintenanceHistoryDetailEntity>();
		if(StringUtils.isNotEmpty(entity.getVin())){
			entity.setId(null);
			dataList = maintenanceHistoryDetailService.queryByList(entity);
		}
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 新增红包或优惠券
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addMaintenance")
	public ModelAndView addMaintenance(MaintenanceHistoryEntity entity,HttpServletRequest request) throws Exception {
		return forword("/km/maintenanceHistory/maintenanceHistory_edit", null);
	}
	
	/**
	 * 修改红包或优惠券信息
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editMaintenance")
	public ModelAndView editMaintenance(MaintenanceHistoryEntity entity, HttpServletRequest request) throws Exception {
		List<MaintenanceHistoryEntity>  list = maintenanceHistoryService.findListByCondition(entity);
		if(null != list && list.size() > 0){
			MaintenanceHistoryEntity aintenance = list.get(0);
			request.setAttribute("aintenance", aintenance);
		}else{
			request.setAttribute("aintenance", entity);
		}
		return forword("/km/maintenanceHistory/maintenanceHistory_edit", null);
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
	public Object save(@RequestBody MaintenanceHistoryEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		AuthUser user = new UserInfo().getUser();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			MaintenanceHistoryEntity maintenance = maintenanceHistoryService.findByVin(entity.getVin());
			if(maintenance != null){
				return sendFailureMessage("VIN已存在");
			}
			entity.setOperator(user.getId());
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			maintenanceHistoryService.add(entity);
		}else{
			entity.setModifyDate(date);
			maintenanceHistoryService.update(entity);
		}
		return sendSuccessMessage(String.valueOf(entity.getId()));
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
		MaintenanceHistoryEntity entity  = maintenanceHistoryService.findById(id);
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
		for (String str : id) {
			MaintenanceHistoryEntity maintenance =  maintenanceHistoryService.findById(str);
			maintenanceHistoryDetailService.deleteByVin(maintenance.getVin());
		}
		maintenanceHistoryService.delete(id);
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
	@RequestMapping(value = "/saveDetail", method = RequestMethod.POST)
	@ResponseBody
	public Object saveDetail(@RequestBody MaintenanceHistoryDetailEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		AuthUser user = new UserInfo().getUser();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setOperator(user.getId());
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			maintenanceHistoryDetailService.add(entity);
		}else{
			entity.setModifyDate(date);
			maintenanceHistoryDetailService.update(entity);
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
	@RequestMapping("/getDetailId")
	@ResponseBody
	public Object getDetailId(String id,HttpServletRequest request) throws Exception{
		MaintenanceHistoryDetailEntity entity  = maintenanceHistoryDetailService.findById(id);
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
	@RequestMapping("/deleteDetail")
	@ResponseBody
	public Object deleteDetail(String[] id,HttpServletRequest request) throws Exception{
		maintenanceHistoryDetailService.delete(id);
		return sendSuccessMessage();
	}
	
	/**
	 * 修改红包或优惠券信息
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetail")
	public ModelAndView showDetail(MaintenanceHistoryEntity entity, HttpServletRequest request) throws Exception {
		MaintenanceHistoryEntity aintenance = maintenanceHistoryService.findById(entity.getId());
		request.setAttribute("aintenance", aintenance);
		return forword("/km/maintenanceHistory/maintenanceHistory_view", null);
	}
}
