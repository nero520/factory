package com.msds.km.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.FactoryCarEntity;
import com.msds.km.entity.FactoryCardEntity;
import com.msds.km.entity.FactoryEntity;
import com.msds.km.message.FactoryCarResponseEnum;
import com.msds.km.service.FactoryCarService;
import com.msds.util.DateUtils;
import com.msds.util.RedisUtil;
 
/**
 * 
 * <br>
 * <b>功能：</b>FactoryCarController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-12-28 16:34:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/factoryCar") 
public class FactoryCarController extends BaseController{
	
	@Autowired
	private FactoryCarService factoryCarService; 
	
	
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
	public Object save(FactoryCarEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		FactoryEntity factoryEntity = super.getFactoryInfo(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			String cardNo = entity.getCardNo();
			FactoryCarEntity car = new FactoryCarEntity();
			car.setCardNo(cardNo);
			car.setFactoryId(factoryEntity.getId());
			car.setState(1);
			Boolean isExits = factoryCarService.exists(entity);
			if(!isExits){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			entity.setFactoryId(factoryEntity.getId());
			entity.setFactoryName(factoryEntity.getFactoryName());
			entity.setState(1);//接车
			factoryCarService.add(entity);
			delCardNo(cardNo,request);
			}else{
			 return super.retEnumResponse(FactoryCarResponseEnum.code_1001);
			}
		}else{
			entity.setModifyDate(date);
			entity.setState(2);//交车
			factoryCarService.update(entity);
		}
		return SUCCESSFUL;
	}

	private void delCardNo(String cardNo,HttpServletRequest request) {
		String key = DateUtils.getDate(new Date());
		Integer id = super.getFactoryId(request);
		key = key + id;
		List<FactoryCardEntity> list = RedisUtil.getValue(key);
		if(list != null && list.size()>0){
			for (FactoryCardEntity factoryCardEntity : list) {
				if(factoryCardEntity.getCardNo().equals(cardNo)){
					list.remove(factoryCardEntity);
					break;
				}
			}
		}
		RedisUtil.setValue(key, list);
	}
	
	/**
	 * 获取当前卡信息
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	@ResponseBody
	public Object getId(String id,HttpServletRequest request) throws Exception{
		FactoryCarEntity entity  = factoryCarService.findById(id);
		return  returnSuccessResponse(entity);
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
	public Object datalist(HttpServletRequest request) throws Exception{
		FactoryCarEntity entity = new FactoryCarEntity();
		entity.setState(1);
		entity.setFactoryId(super.getFactoryId(request));
		List<FactoryCarEntity> dataList = factoryCarService.findListByCondition(entity);
		return  returnSuccessResponse(dataList);
	}


}
