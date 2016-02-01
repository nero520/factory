package com.msds.km.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.base.BaseController;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.km.enums.BespeakTypeEnum;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.enums.SourceEnum;
import com.msds.km.message.OrderResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.BespeakService;
import com.msds.km.vo.Bespeak;
import com.msds.util.DateUtils;

/**
 * 预约单
 * 
 * @ClassName OrderController
 * @Description TODO
 * @author hebiao
 * @date 2015年4月27日 下午14:21:29
 * 
 */
@Controller
@RequestMapping("/bespeak")
public class BespeakController extends BaseController {

	@Resource(name = "bespeakService")
	private BespeakService bespeakService;
	@Autowired
	private CodeGenerator codeGenerator;

	/**
	 * 预约单列表
	 * 
	 * @Description TODO
	 * @param bespeakEntity
	 *            预约单条件数据
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseResponse list(BespeakEntity bespeakEntity,
			HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);
		if (memberId == null) {
			return FAILURE;
		}

		bespeakEntity.setMemberId(memberId);
		bespeakEntity.setSortField("g_bespeak.id");
		bespeakEntity.setSortOrder("desc");
		List<Bespeak> bespeakList = new ArrayList<Bespeak>();
		Bespeak bespeak = null;
		try {
			List<BespeakEntity> bespeaks = bespeakService
					.getMemberBespeakList(bespeakEntity);
			if (bespeakList != null) {
				for (BespeakEntity bp : bespeaks) {
					bespeak = new Bespeak();
					bespeak.setAnswer(bp.getAnswer());
					bespeak.setBespeakType(bp.getBespeakType());
					bespeak.setServiceName(bp.getServiceContent());
					bespeak.setTotalPrice(bp.getTotalPrice());
					bespeak.setBespeakSn(bp.getBespeakSn());
					bespeak.setBespeakDate(DateUtils.DateToString(bp
							.getBespeakDate()));
					bespeak.setCreateDate(DateUtils.DateToString(
							bp.getCreateDate(), "yyyy-MM-dd HH:mm"));
					bespeak.setCompanyName(bp.getCompanyName());
					bespeak.setState(bp.getState());
					bespeakList.add(bespeak);
				}
			}
			return returnResponse(SUCCESS_CODE, bespeakList);
		} catch (Exception e) {
			logger.error("", e);
			return FAILURE;
		}
	}

	/**
	 * 查看预约单
	 * 
	 * @Description TODO
	 * @param bespeakSn
	 *            订单号
	 * @param request
	 * @return
	 * @return BaseResponse(order)
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public BaseResponse view(String bespeakSn, HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);
		if (StringUtils.isEmpty(bespeakSn)) {
			return FAILURE;
		}
		try {
			BespeakEntity bespeak = bespeakService.findBySnAndMemberId(
					bespeakSn, memberId);
			return returnResponse(SUCCESS_CODE, bespeak);
		} catch (Exception e) {
			logger.error("预约单号:{},查询预约单详情异常:{}", bespeakSn, e);
			return FAILURE;
		}
	}

	/**
	 * 创建预约订单
	 * 
	 * @Description TODO
	 * @param memberModelId
	 *            会员车型Id
	 * @param serviceCode
	 *            服务时间
	 * @param companyId
	 *            服务code
	 * @param serviceTime
	 *            服务时间
	 * @param paymentMethod
	 *            支付方式
	 * @param remark
	 *            服务区间
	 * @param request
	 * @return
	 * @return BaseResponse(sn)
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public BaseResponse create(Integer memberModelId, String serviceCode,
			Integer companyId, Date serviceTime, String remark, Integer os,
			HttpServletRequest request) {
		// 检验信息
		if (StringUtils.isBlank(serviceCode) || null == companyId
				|| memberModelId == null) {
			return retEnumResponse(OrderResponseEnum.code_1301);
		}
		Date startDay = DateUtils.addDay(DateUtils.getDayStart(new Date()), 1);
		Date endDay = DateUtils.addDay(startDay, 14);
		if (serviceTime == null
				|| serviceTime.compareTo(DateUtils.getDayStart(startDay)) < 0
				|| serviceTime.compareTo(endDay) > 0) {
			return retEnumResponse(OrderResponseEnum.code_1302);
		}
		SourceEnum sourceEnum = null;
		if (os == null || (sourceEnum = SourceEnum.getEnumById(os)) == null) {
			return retEnumResponse(OrderResponseEnum.code_1305);
		}
		MemberEntity memberEntity = super.getMemberInfo(request);
		BespeakEntity bespeak;
		try {
			String sn = codeGenerator.getCode(CodeType.BESPEAK_ID_PREFIX, "",
					CodeTypeEnum.bespeak_code.getId());

			if (sn != null) {
				bespeak = bespeakService.create(sn, memberEntity,
						memberModelId, serviceCode, companyId, serviceTime,
						remark, BespeakTypeEnum.online,
						BespeakStateEnum.toConfirmation, sourceEnum);
				if (bespeak == null) {
					return retEnumResponse(OrderResponseEnum.code_1300);
				}
			} else {
				return retEnumResponse(OrderResponseEnum.code_1300);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return retEnumResponse(OrderResponseEnum.code_1300);
		}
		logger.info("订单提交预约,SN:{}", bespeak.getBespeakSn());
		return returnResponse(SUCCESS_CODE, bespeak);
	}
}
