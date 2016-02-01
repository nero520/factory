package com.msds.km.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.km.base.BaseController;
import com.msds.km.entity.CheckBillEntity;
import com.msds.km.entity.CheckBillNumEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.service.CheckBillService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.RepairListService;
import com.msds.km.vo.CheckBillVo;

/**
 * 
 * <br>
 * 活动 <b>功能：</b>ActivityController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/checkBill")
public class CheckBillController extends BaseController {

	@Resource
	private CheckBillService billService;
	@Resource
	private MemberModelService memberModelService;
	@Resource
	private RepairListService repairListService;

	/**
	 * 全车检测列表
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 */

	@RequestMapping("/list")
	@ResponseBody
	public Object datalist(CheckBillEntity entity, HttpServletRequest request)
			throws Exception {

		MemberModelEntity memberModel = memberModelService
				.queryDefaultById(super.getMemberId(request));
		// 判断用户是否添加了车型
		if (memberModel != null) {
			// 判断用户是否有vin
			String vin = memberModel.getVin();
			if (StringUtils.isNotBlank(vin)) {
				// 判断用户是否在门店消费过
				Integer exists = repairListService.existsByMemberPhoneOrvin(
						getMemberInfo(request).getPhone(), vin);
				if (exists != null && exists > 0) {
					// 判断用户是否做过全车检测
					entity.setTelphone(getMemberInfo(request).getPhone());
					List<CheckBillEntity> billEntities = billService
							.queryByList(entity);
					CheckBillVo billVo = new CheckBillVo();
					billVo.setModelEntity(memberModel);

					List<CheckBillNumEntity> checkBillEntities = new ArrayList<CheckBillNumEntity>();
					for (int i = 0; i < billEntities.size(); i++) {
						checkBillEntities.add(score(billEntities.get(i)));
					}
					billVo.setBillEntities(checkBillEntities);
					billVo.setBillCount(entity.getPager().getRowCount());
					return returnSuccessResponse(billVo);
				}
			}
		}
		return returnResponse("2000", "不满足条件");
	}

	/**
	 * 全车检测详情
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 */

	@RequestMapping("/checkBillInfo")
	@ResponseBody
	public Object checkBillInfo(String billSn, HttpServletRequest request)
			throws Exception {
		CheckBillEntity t = new CheckBillEntity();
		t.setBillSn(billSn);
		List<CheckBillEntity> billEntities = billService.findListByCondition(t);
		if (billEntities == null || billEntities.size() == 0
				|| billEntities.size() > 1) {
			return FAILURE;
		}
		CheckBillEntity billEntitie = billEntities.get(0);
		CheckBillNumEntity checkBillNumEntity = score(billEntitie);
		return returnSuccessResponse(checkBillNumEntity);
	}

	public CheckBillNumEntity score(CheckBillEntity billEntitie) {
		CheckBillNumEntity billNumEntity = new CheckBillNumEntity();
		billNumEntity.setBillEntity(billEntitie);
		// 总分
		int count = 0;

		// 行驶系统
		int travelingSystemC1 = 0;
		int travelingSystemC2 = 0;
		if (billEntitie.getZqltw1() == 3) {
			travelingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getZqltw1() == 2) {
			travelingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getYqltw1() == 3) {
			travelingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getYqltw1() == 2) {
			travelingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getZhltw2() == 3) {
			travelingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getZhltw2() == 2) {
			travelingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getYhltw2() == 3) {
			travelingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getYhltw2() == 2) {
			travelingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getZqlty3() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getYqlty4() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getZhlty5() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getYhlty6() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		// 轮胎已复位去掉
		/*
		 * if(billEntitie.getTyfw7()==0){ travelingSystemC1+=1; count+=0; }else{
		 * count+=10; }
		 */
		if (billEntitie.getJqm8() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getLtlsnj9() == 0) {
			travelingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (travelingSystemC1 > 0) {
			billNumEntity.setTravelingSystemC1(travelingSystemC1);
		} else if (travelingSystemC2 > 0) {
			billNumEntity.setTravelingSystemC2(travelingSystemC2);
		}

		// 制动系统
		int brakingSystemC1 = 0;
		int brakingSystemC2 = 0;
		if (billEntitie.getZqscp10() == 3) {
			brakingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getZqscp10() == 2) {
			brakingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getYqscp11() == 3) {
			brakingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getYqscp11() == 2) {
			brakingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getZhscp12() == 3) {
			brakingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getZhscp12() == 2) {
			brakingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getYhscp13() == 3) {
			brakingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getYhscp13() == 2) {
			brakingSystemC2 += 1;
			count += 5;
		} else {
			count += 10;
		}
		if (billEntitie.getZqscpa14() == 0) {
			brakingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getYqscpa15() == 0) {
			brakingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getZhscpa16() == 0) {
			brakingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getYhscpa17() == 0) {
			brakingSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		/*
		 * if(billEntitie.getZqscpa14()==0){ brakingSystemC1+=1; count+=0;
		 * }else{ count+=10; }
		 */
		if (billEntitie.getZdlhsl18() == 3) {
			brakingSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getZdlhsl18() == 2) {
			brakingSystemC2 += 1;
			count += 10;
		} else {
			count += 20;
		}
		if (brakingSystemC1 > 0) {
			billNumEntity.setBrakingSystemC1(brakingSystemC1);
		} else if (brakingSystemC2 > 0) {
			billNumEntity.setBrakingSystemC2(brakingSystemC2);
		}
		// 电气系统
		int electricSystemC1 = 0;
		if (billEntitie.getKtyw19() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 5;
		}
		if (billEntitie.getKtzl20() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getKtwd21() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 5;
		}
		if (billEntitie.getKtlx22() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getQclb24() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getQcyx25() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 5;
		}
		if (billEntitie.getAqd26() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getZks27() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getZdcc28() == 0) {
			electricSystemC1 += 1;
			count += 0;
		} else {
			count += 5;
		}
		if (brakingSystemC1 > 0) {
			billNumEntity.setElectricSystemC(electricSystemC1);
		}
		// **动力系统**//*
		int powerSystemC1 = 0;
		int powerSystemC2 = 0;
		if (billEntitie.getXdcxn29() == 3) {
			powerSystemC1 += 1;
			count += 0;
		} else if (billEntitie.getXdcxn29() == 2) {
			powerSystemC2 += 1;
			count += 10;
		} else {
			count += 20;
		}
		if (billEntitie.getFdyyw30() == 0) {
			powerSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getHhsfsd31() == 0) {
			powerSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getFdjyw32() == 0) {
			powerSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getZxyywgl33() == 0) {
			powerSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getFdjpdgl34() == 0) {
			powerSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (powerSystemC1 > 0) {
			billNumEntity.setPowerSystemC1(powerSystemC1);
		} else if (powerSystemC2 > 0) {
			billNumEntity.setPowerSystemC2(powerSystemC2);
		}

		// 底盘系统
		int chassisSystemC1 = 0;
		if (billEntitie.getJzq35() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getZtzc36() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getDpj37() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 10;
		}
		if (billEntitie.getCdzfct38() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getWxjaqt39() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (billEntitie.getBsxzj40() == 0) {
			chassisSystemC1 += 1;
			count += 0;
		} else {
			count += 20;
		}
		if (chassisSystemC1 > 0) {
			billNumEntity.setChassisSystemC(chassisSystemC1);
		}
		// 灯光系统
		int lightingStstemC1 = 0;
		if (billEntitie.getCndg41() == 0) {
			lightingStstemC1 += 1;
			count += 0;
		} else {
			count += 30;
		}
		if (billEntitie.getCwdg42() == 0) {
			lightingStstemC1 += 1;
			count += 0;
		} else {
			count += 30;
		}
		if (billEntitie.getYbpgzd43() == 0) {
			lightingStstemC1 += 1;
			count += 0;
		} else {
			count += 40;
		}
		if (lightingStstemC1 > 0) {
			billNumEntity.setLightingStstemC(lightingStstemC1);
		}
		billNumEntity.setCount(count / 6);
		return billNumEntity;
	}
}
