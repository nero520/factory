package com.msds.km.reparifacoty.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msds.km.base.BaseController;
import com.msds.km.common.MapiConstants;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.model.BespeakDetailModel;
import com.msds.km.model.BespeakModel;
import com.msds.km.model.ListModel;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.BespeakService;

/**
 * 修理厂前台 预约单Controller
 * @author hebiao
 *
 */
@Controller("RfBespeakController")
@RequestMapping("/rf/bespeak")
public class BespeakController extends BaseController{

	@Resource
	private BespeakService bespeakService;
	
	/**
	 * 预约单列表
	 * @param state 0 查询待预约, 1 全部预约单
	 * @param offset
	 * @param size
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public BaseResponse list(Integer state,Integer offset, Integer size, HttpServletRequest request) throws Exception {
		Integer companyId = this.getCompanyId(request);
		if(companyId == null){
			return FAILURE;
		}
		ListModel<BespeakModel> bespeakModels = null;
		try {
			BespeakEntity bespeakEntity = new BespeakEntity();
			bespeakEntity.setCompanyId(companyId);
			//0 查询待预约,即是预约时间大于当前时间
			if(state != null && state == 0){
				bespeakEntity.setNowDate(new Date());
			}
			bespeakEntity.getPager().setPageOffset(offset == null ? 0 : offset);
			bespeakEntity.setPageSize(size == null ? MapiConstants.DEFAULT_PAGESIZE : size);
			bespeakEntity.setSortField("g_bespeak.bespeak_date desc");//预约时间倒序
			bespeakModels = bespeakService.getBespeakModelList(bespeakEntity);
			
		} catch (Exception e) {
			logger.error("修理厂前台查询预约单列表异常", e);
			return FAILURE;
		}
		
		return returnResponse(SUCCESS_CODE, bespeakModels);
	}
	
	/**
	 * 预约单详细信息
	 * @param orderSn
	 * @return
	 * @throws Exception 
	 * BaseResponse
	 */
	@RequestMapping(value = "/detail")
	public BaseResponse detail(String bespeakSn, HttpServletRequest request) throws Exception {
		BespeakDetailModel bespeakDetail = new BespeakDetailModel();
		Integer companyId = super.getCompanyId(request);
		if (StringUtils.isBlank(bespeakSn) || companyId == null) {
			return returnResponse("9999", "");
		}
		try {
			bespeakDetail = bespeakService.findDetailedBySnAndCompanyId(bespeakSn, companyId);
			if(bespeakDetail == null){
				return returnResponse("9999", "预约单不存在");
			}
		} catch (Exception e) {
			logger.error("修理厂前台查询{}预约单明细异常{}", bespeakSn,e);
			e.printStackTrace();
			return FAILURE;
		}
		return returnResponse(SUCCESS_CODE, bespeakDetail);
	}

}
