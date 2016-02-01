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
import com.msds.km.entity.FactoryCardEntity;
import com.msds.km.service.FactoryCardService;
import com.msds.util.DateUtils;
import com.msds.util.RedisUtil;
 
/**
 * 
 * <br>
 * <b>功能：</b>FactoryCardController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/factoryCard") 
public class FactoryCardController extends BaseController{
	
	@Autowired
	private FactoryCardService factoryCardService; 
	
	
	
	/**
	 * 获取有效编码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCardNo")
	@ResponseBody
	public Object findCardNo(HttpServletRequest request) throws Exception{
		String key = DateUtils.getDate(new Date());
		Integer id = super.getFactoryId(request);
		key = key + id;
		List<FactoryCardEntity> list = RedisUtil.getValue(key);
		FactoryCardEntity entity = null;
		if(list != null && list.size() > 0){
			entity = list.get(0);
		}else{
		
		List<FactoryCardEntity> lists  = factoryCardService.findByFactoryCard(id);
		RedisUtil.setValue(key, lists);
		if(lists != null && lists.size() > 0){
			entity = lists.get(0);
		}
		}
		return  returnSuccessResponse(entity);
	}
	
	

}
