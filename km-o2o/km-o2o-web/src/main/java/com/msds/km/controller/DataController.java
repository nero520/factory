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
 

@Controller
@RequestMapping("/data") 
public class DataController extends BaseController{
	
	@Autowired
	private FactoryCardService factoryCardService; 
	
	
	
	
	@RequestMapping("/data")
	public void dataInit(){   
		try {
			 Date date = new Date();
			 String m = "00";	 
			 for(int k=1;k<=11;k++){
			 for(int i=1;i<=100;i++){
			 FactoryCardEntity entity = new FactoryCardEntity();
			 m = ""+i;
			 entity.setCardNo(m);
			 entity.setFactoryId(k);
		     entity.setCreateDate(date);
			 entity.setModifyDate(date);
			 factoryCardService.add(entity);
			 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
