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
import com.msds.km.entity.CouponEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.enums.CouponStateEnum;
import com.msds.km.enums.CouponTypeEnum;
import com.msds.km.service.CouponService;
import com.msds.util.DateUtils;
 
/**
 * 
 * <br>
 * <b>功能：</b>CouponController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-21 15:45:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/coupon") 
public class CouponController extends BaseController{
	
	private final static Logger log= Logger.getLogger(CouponController.class);
	
	@Autowired
	private CouponService couponService;
	
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
		return forword("/km/coupon/coupon_list",null); 
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
	public Object datalist(CouponEntity entity,HttpServletRequest request) throws Exception{
		Date afterDate = entity.getAfterDate();
		if(afterDate != null){
			entity.setAfterDate(DateUtils.getDayEnd(afterDate));
		}
		Date beforeDate = entity.getBeforeDate();
		if(beforeDate != null){
			entity.setBeforeDate(DateUtils.getDayStart(beforeDate));
		}

		List<CouponEntity> dataList = couponService.queryByList(entity);
		for (CouponEntity coupon : dataList) {
			String typeName = CouponTypeEnum.getEnumById(coupon.getType()).getName();
			coupon.setTypeName(typeName);
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
	@RequestMapping("/addCoupon")
	public ModelAndView addCoupon(CouponEntity entity,HttpServletRequest request) throws Exception {
		return forword("/km/coupon/coupon_edit", null);
	}
	
	/**
	 * 修改红包或优惠券信息
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editCoupon")
	public ModelAndView editCoupon(CouponEntity entity, HttpServletRequest request) throws Exception {
		List<CouponEntity>  list = couponService.findListByCondition(entity);
		if(null != list && list.size() > 0){
			CouponEntity coupon = list.get(0);
			request.setAttribute("coupon", coupon);
		}
		return forword("/km/coupon/coupon_edit", null);
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public Object updateState(String id,HttpServletRequest request) throws Exception{
		CouponEntity entity = couponService.findById(id);
		if(entity.getState() == CouponStateEnum.start.getId()){
			entity.setState(CouponStateEnum.stop.getId());
		}else{
			entity.setState(CouponStateEnum.start.getId());
		}
		couponService.update(entity);
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
	public Object save(@RequestBody CouponEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		AuthUser user = new UserInfo().getUser();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			String sn = codeGenerator.getCode(CodeTypeEnum.coupon_code.getPrefix(), "", CodeTypeEnum.coupon_code.getId());
			entity.setCouponSn(sn);
			entity.setState(CouponStateEnum.start.getId());
			entity.setOperator(user.getId());
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			couponService.add(entity);
		}else{
			entity.setOperator(user.getId());
			entity.setModifyDate(date);
			couponService.update(entity);
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
		CouponEntity entity  = couponService.findById(id);
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
		couponService.delete(id);
		return sendSuccessMessage();
	}

}
