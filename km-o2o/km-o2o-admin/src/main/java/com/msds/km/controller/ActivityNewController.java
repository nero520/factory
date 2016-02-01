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

import com.msds.baseinfo.common.UserInfo;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.km.CodeGenerator;
import com.msds.km.base.BaseController;
import com.msds.km.entity.ActivityNewDetailEntity;
import com.msds.km.entity.ActivityNewEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.CouponEntity;
import com.msds.km.enums.ActivityLimitStateEnum;
import com.msds.km.enums.ActivityNewStateEnum;
import com.msds.km.enums.ActivityNewTypeEnum;
import com.msds.km.enums.ActivityStateEnum;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.enums.CouponStateEnum;
import com.msds.km.enums.CouponTypeEnum;
import com.msds.km.service.ActivityNewDetailService;
import com.msds.km.service.ActivityNewService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.CouponService;
import com.msds.util.BeanUtil;
 
/**
 * 
 * <br>
 * <b>功能：</b>ActivityNewController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/activityNew") 
public class ActivityNewController extends BaseController{
	
	private final static Logger log= Logger.getLogger(ActivityNewController.class);
	
	@Autowired
	private ActivityNewService activityNewService; 
	
	@Autowired
	private ActivityNewDetailService activityNewDetailService;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CodeGenerator codeGenerator;
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/activityNew/activityNew_list",null); 
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
	public Object datalist(ActivityNewEntity entity,HttpServletRequest request) throws Exception{
		List<ActivityNewEntity> dataList = activityNewService.queryList(entity);
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
	public Object detailDataList(ActivityNewDetailEntity entity,HttpServletRequest request) throws Exception{
		List<ActivityNewDetailEntity> dataList = activityNewDetailService.queryByList(entity);
		for (ActivityNewDetailEntity detail : dataList) {
			String typeName = CouponTypeEnum.getEnumById(detail.getType()).getName();
			detail.setTypeName(typeName);
		}
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public Object updateState(String id,HttpServletRequest request) throws Exception{
		ActivityNewEntity entity = activityNewService.findById(id);
		if(entity.getState() == ActivityStateEnum.start.getId()){
			entity.setState(CouponStateEnum.stop.getId());
		}else{
			entity.setState(ActivityStateEnum.start.getId());
		}
		activityNewService.update(entity);
		return sendSuccessMessage();
	}
	
	/**
	 * 新增活动
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addActivityNew")
	public ModelAndView addActivityNew(ActivityNewEntity entity,HttpServletRequest request) throws Exception {
		return forword("/km/activityNew/activityNew_edit", null);
	}
	
	/**
	 * 个性活动
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editActivityNew")
	public ModelAndView editActivityNew(ActivityNewEntity entity,HttpServletRequest request) throws Exception {
		ActivityNewEntity activity = activityNewService.findById(entity.getId());
		request.setAttribute("activity", activity);
		return forword("/km/activityNew/activityNew_edit", null);
	}
	
	/**
	 * 创建红包与优惠券关联
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addActivityNewDetail")
	public ModelAndView addActivityNewDetail(ActivityNewEntity entity,HttpServletRequest request) throws Exception {
		if(entity.getId()!=null){
			ActivityNewEntity activity = activityNewService.findById(entity.getId());
			ActivityNewDetailEntity activityNewDetail = new ActivityNewDetailEntity();
			activityNewDetail.setActivitySn(activity.getActivitySn());
			List<ActivityNewDetailEntity> detialList = activityNewDetailService.findListByCondition(activityNewDetail);
			String couponSns = "";
			if(detialList!=null && detialList.size()>0){
				for (ActivityNewDetailEntity detail : detialList) {
					if(StringUtils.isEmpty(couponSns)){
						couponSns += detail.getCouponSn();
					}else{
						couponSns += ","+detail.getCouponSn();
					}
				}
			}
			activity.setCouponSns(couponSns);
			request.setAttribute("activity", activity);
		}
		return forword("/km/activityNew/activityNew_detail", null);
	}
	
	/**
	 * 查看明细
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetail")
	public ModelAndView showDetail(ActivityNewEntity entity,HttpServletRequest request) throws Exception {
		if(entity.getId()!=null){
			ActivityNewEntity activity = activityNewService.findById(entity.getId());
			String limitStateName = ActivityLimitStateEnum.getEnumById(activity.getActivityLimitState()).getName();
			activity.setLimitStateName(limitStateName);
			String typeName = ActivityNewTypeEnum.getEnumById(activity.getType()).getName();
			activity.setTypeName(typeName);
			String scopeName = "";
			if(StringUtils.isNotEmpty(activity.getActivityScope())){
				String[] companyIds = activity.getActivityScope().split(",");
				List<CompanyEntity> companyList = companyService.findInIds(companyIds);
				for (CompanyEntity company : companyList) {
					if(StringUtils.isEmpty(scopeName)){
						scopeName += company.getName();
					}else{
						scopeName += "、"+company.getName();
					}
				}
			}else{
				scopeName = "全部";
			}
			activity.setScopeName(scopeName);
			request.setAttribute("activity", activity);
		}
		return forword("/km/activityNew/activityNew_view", null);
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
	public Object save(@RequestBody ActivityNewEntity entity, HttpServletRequest request) throws Exception{
		doSave(entity);
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
		ActivityNewEntity entity  = activityNewService.findById(id);
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
			ActivityNewEntity activity =  activityNewService.findById(str);
			activityNewDetailService.deleteByActivitySn(activity.getActivitySn());
		}
		activityNewService.delete(id);
		return sendSuccessMessage();
	}
	
	/**
	 * 删除数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("/saveActivityNewDetail")
	@ResponseBody
	public Object saveActivityNewDetail(ActivityNewEntity entity,HttpServletRequest request) throws Exception{
		doSave(entity);
		return sendSuccessMessage();
	}
	
	/**
	 * 执行保存动作
	 * @param entity
	 * @throws Exception 
	 * void
	 */
	private void doSave(ActivityNewEntity entity) throws Exception{
		Date date = new Date();
		AuthUser user = new UserInfo().getUser();
		String couponIds = entity.getCouponIds();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			String sn = codeGenerator.getCode(CodeTypeEnum.activity_new_code.getPrefix(), "", CodeTypeEnum.activity_new_code.getId());
			entity.setActivitySn(sn);
			entity.setState(ActivityNewStateEnum.yes.getId());
			entity.setOperator(user.getId());
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			activityNewService.add(entity);
		}else{
			entity.setOperator(user.getId());
			entity.setModifyDate(date);
			activityNewService.update(entity);
		}
		//活动明细先删，后插
		if(StringUtils.isNotEmpty(couponIds)){
			String[] ids = couponIds.split(",");
			activityNewDetailService.deleteByActivitySn(entity.getActivitySn());
			List<CouponEntity> couopnList = couponService.findInIds(ids);
			for (CouponEntity couponEntity : couopnList) {
				ActivityNewDetailEntity activityDetail = new ActivityNewDetailEntity();
				BeanUtil.copyProperties(couponEntity, activityDetail, "id");
				activityDetail.setId(null);
				activityDetail.setOperator(user.getId());
				activityDetail.setCreateDate(date);
				activityDetail.setModifyDate(date);
				activityDetail.setActivitySn(entity.getActivitySn());
				activityNewDetailService.add(activityDetail);
			}
		}
	}

}
