package com.msds.km.reparifacoty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.MapiConstants;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.SettleAccountEntity;
import com.msds.km.message.CompanyResponseEnum;
import com.msds.km.message.LoginResponseEnum;
import com.msds.km.model.CompanyMemberPrincipal;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.BespeakService;
import com.msds.km.service.CompanyService;
import com.msds.util.AppConstants;
import com.msds.util.DesUtil;
import com.msds.util.RedisUtil;

/**
 * 
 * ClassName: LoginController 
 * @Description: 登录相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/rf")
public class LoginController extends BaseController {
	

	@Autowired
	private AppConstants appConstants;
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private BespeakService bespeakService;
	/**
	 * 登录授权
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResponse  login(String userName, String password, HttpServletRequest request) {

		if (StringUtils.isEmpty(userName)) {
			return this.retEnumResponse(CompanyResponseEnum.companyRespnseEnum_1400);
		}
		if (StringUtils.isEmpty(password)) {
			return this.retEnumResponse(CompanyResponseEnum.companyRespnseEnum_1401);
		}
		String minPassword = DesUtil.decrypt(password);
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setUsername(userName);
		List<CompanyEntity> list = new ArrayList<CompanyEntity>();
		try {
			list = companyService.findListByCondition(companyEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return this.retEnumResponse(LoginResponseEnum.code_1006);
		}
		if (list == null || list.isEmpty()) {
			return this.retEnumResponse(CompanyResponseEnum.companyRespnseEnum_1402);
		}
		CompanyEntity ce = list.get(0);
		
		if(ce.getLockState() !=null && ce.getLockState() == 1){
			return this.retEnumResponse(CompanyResponseEnum.companyRespnseEnum_1404);
		}
		// 32位md5，之后进行比较
		if (!DigestUtils.md5Hex(minPassword).equals(ce.getPassword())) {
			return this.retEnumResponse(CompanyResponseEnum.companyRespnseEnum_1403);
		}
		
		String token = getToken(request);
		if(StringUtils.isEmpty(token)){
			token = UUID.randomUUID().toString();
		}

		
		CompanyMemberPrincipal companyMemberPrincipal = new CompanyMemberPrincipal();
		companyMemberPrincipal.setId(ce.getId());
		companyMemberPrincipal.setToken(token);
		companyMemberPrincipal.setUserName(userName);
		companyMemberPrincipal.setDirectShopId(ce.getDirectShopId());
		companyMemberPrincipal.setPhone(ce.getTelephone());
		
		// 暂时注释(可以多个设备登录)
//		this.delOldToken(String.valueOf(memberEntity.getId()));
		
		//将token - member对应关系存储到redis
		RedisUtil.setValue(MapiConstants.TOKEN_PREFFIX+token,companyMemberPrincipal, MapiConstants.EXPIRE_DATE, TimeUnit.DAYS);
		//将member-token(List)关系存储redis
		RedisUtil.lremove(MapiConstants.TOKEN_PREFFIX+String.valueOf(ce.getId()), token);//存在的删除
		RedisUtil.rpush(MapiConstants.TOKEN_PREFFIX+String.valueOf(ce.getId()), token);
		RedisUtil.expire(MapiConstants.TOKEN_PREFFIX+String.valueOf(ce.getId()),MapiConstants.EXPIRE_DATE, TimeUnit.DAYS);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("token", token);
		map.put("userName", userName);
		map.put("name", ce.getName());
		map.put("companyId", companyMemberPrincipal.getId());
		this.setStatusCount(map, companyMemberPrincipal.getId());
		
		return this.returnResponse(SUCCESS_CODE, map);
	}
	
	private void setStatusCount(Map<String, Object> resultMap,final Integer companyId){

		//待服务预约单数
		try {
			resultMap.put("waitBespeakAccount", bespeakService.queryBespeakCount(new BespeakEntity(){{
				setCompanyId(companyId);
				setNowDate(new Date());
				
			}}));
		} catch (Exception e) {
			logger.error("获取待服务预约单数,e  :{} ",e);
		}
	}

	
}
