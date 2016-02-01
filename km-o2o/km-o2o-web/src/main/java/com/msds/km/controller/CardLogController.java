package com.msds.km.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.CardLogEntity;
import com.msds.km.message.CardLogResponseEnum;
import com.msds.km.service.CardLogService;
 
/**
 * 
 * <br>
 * <b>功能：</b>CardLogController<br>
 * <b>作者：</b>xiaoxiong<br>
 * <b>日期：</b> 2015-12-24 11:04:46 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/cardLog") 
public class CardLogController extends BaseController{
	
	@Autowired
	private CardLogService cardLogService; 
	
	
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
	public Object save(String cardNo,String state, HttpServletRequest request) throws Exception{
		Date date = new Date();
		CardLogEntity entity = new CardLogEntity();
		entity.setCardNo(cardNo);
		entity.setCreateDate(date);
		entity.setModifyDate(date);
		entity.setState(state);
		entity.setOpeartor(super.getAdminInfo(request).getName());
		try{
		cardLogService.add(entity);
		}catch (Exception e) {
			e.printStackTrace();
			return super.retEnumResponse(CardLogResponseEnum.code_1001);
		}				
				
		return SUCCESSFUL;
	}
	
	

}
