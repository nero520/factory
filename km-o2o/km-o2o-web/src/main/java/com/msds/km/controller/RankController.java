package com.msds.km.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.FactoryEntity;
import com.msds.km.service.FactoryCarService;
import com.msds.km.service.FactoryService;
import com.msds.km.vo.DateRankList;
import com.msds.km.vo.DateRankVo;
import com.msds.km.vo.RankListVo;
import com.msds.km.vo.RankVo;
 

@Controller
@RequestMapping("/rank") 
public class RankController extends BaseController{
	
	@Autowired
	private FactoryCarService factoryCarService; 
	
	@Autowired
	private FactoryService factoryService; 
	
	
	@RequestMapping("/list")
	@ResponseBody
	public Object findRankList(HttpServletRequest request) throws Exception{
		
		List<RankVo> dayList  = factoryCarService.findRankList(1);
		List<RankVo> monthList  = factoryCarService.findRankList(2);
		RankListVo list = new RankListVo();
		list.setDayList(dayList);
		list.setMonthList(monthList);
		return  returnSuccessResponse(list);
	}
	
	@RequestMapping("/findrlist")
	@ResponseBody
	public Object findDayRankListById(HttpServletRequest request,Integer id) throws Exception{
		FactoryEntity entity = factoryService.findById(id);
		List<DateRankVo> list = factoryCarService.findDayRankListById(id);
		DateRankList datalist = new DateRankList();
		datalist.setDatalist(list);
		datalist.setFactoryName(entity.getFactoryName());
		datalist.setUrl(entity.getUrl());
		return  returnSuccessResponse(datalist);
	}
	
	

	

}
