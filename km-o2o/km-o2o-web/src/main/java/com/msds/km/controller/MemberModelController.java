package com.msds.km.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ModelEntity;
import com.msds.km.message.MemberModelResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.ModelService;
import com.msds.util.CheckUtils;

/**
 * 
 * ClassName: MemberModelController
 * 
 * @Description: 我的爱车相关信息
 * @author xiaoxiong
 * @date 2015-4-30
 */
@Controller
@RequestMapping("/membermodel")
public class MemberModelController extends BaseController {

	@Autowired
	private MemberModelService memberModelService;

	@Autowired
	private ModelService modelService;

	/**
	 * 我的爱车列表
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public BaseResponse list(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {
		Integer memberId = super.getMemberId(request);

		memberModelEntity.setMemberId(memberId);
		// memberModelEntity.setSortField("create_date desc");
		memberModelEntity.setSortField("default_flag desc ,create_date desc");

		try {
			List<MemberModelEntity> lists = memberModelService
					.queryByList(memberModelEntity);
			if (lists != null && lists.size() > 0) {
				for (MemberModelEntity model : lists) {
					String logo = modelService.findLogoById(model.getModelId());
					model.setLogo(logo);
				}
			}
			return super.returnResponse("0000", lists);
		} catch (Exception e) {
			logger.error("类方法：list,查询我的爱车异常{}", e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * 添加我的爱车
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BaseResponse add(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {

		Integer memberId = super.getMemberId(request);

		// 1.校验前台信息
		// 1.1校验车型并且校验后台是否存在该车型;
		if (memberModelEntity.getModelId() == null) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1100);
		}
		ModelEntity entity = new ModelEntity();
		entity.setId(memberModelEntity.getModelId());
		entity.setLevel(3);
		try {
			if (!modelService.exists(entity)) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1100);
			}
			// 1.1.1校验区域
			if (StringUtils.isBlank(memberModelEntity.getRegion())) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1106);
			}
			// 1.2校验车牌号并且校验后台是否唯一存在;
			if (StringUtils.isBlank(memberModelEntity.getLicense())) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1102);
			}
			MemberModelEntity license = new MemberModelEntity();
			license.setLicense(memberModelEntity.getLicense());
			license.setMemberId(memberId);
			license.setRegion(memberModelEntity.getRegion());
			// 除了本人以外能有重复牌照
			if (memberModelService.isExists(license)) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1101);
			}

			// 1.2.1里程数必填
			if (memberModelEntity.getMileage() != null
					&& (memberModelEntity.getMileage() < 1 || memberModelEntity
							.getMileage() > 99999999)) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1107);
			}
			// 1.3校验车架号码（必须17位）;
			if (memberModelEntity.getVin() != null) {
				if (!(memberModelEntity.getVin().matches("^([a-zA-Z0-9]){17}$"))) {
					return super
							.retEnumResponse(MemberModelResponseEnum.code_1103);
				}
			}

			memberModelEntity.setMemberId(memberId);
			memberModelService.saveMemberModel(memberModelEntity);
			return SUCCESSFUL;
		} catch (Exception e) {
			logger.error("类方法：add,添加我的爱车异常{}", e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * 
	 * 查询单个爱车信息
	 * 
	 * @param memberModelEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)
	public BaseResponse queryById(MemberModelEntity memberModelEntity)
			throws Exception {

		MemberModelEntity result = memberModelService
				.findById(memberModelEntity.getId());
		return super.returnResponse("0000", result);
	}

	/**
	 * 编辑我的爱车
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public BaseResponse update(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {

		Integer memberId = super.getMemberId(request);
		// 1.校验前台信息
		// 1.1校验车型并且校验后台是否存在该车型;
		// if (memberModelEntity.getModelId() == null) {
		// return super.retEnumResponse(MemberModelResponseEnum.code_1100);
		// }
		// ModelEntity entity = new ModelEntity();
		// entity.setId(memberModelEntity.getModelId());
		// entity.setLevel(3);
		try {
			// if (!modelService.exists(entity)) {
			// return super.retEnumResponse(MemberModelResponseEnum.code_1100);
			// }
			// 1.1.1校验区域
			if (StringUtils.isBlank(memberModelEntity.getRegion())) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1106);
			}
			// 1.2校验车牌号并且校验后台是否唯一存在;
			if (StringUtils.isBlank(memberModelEntity.getLicense())) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1102);
			}
			// 除了本人以外能有重复牌照
//			MemberModelEntity license = new MemberModelEntity();
//			license.setId(memberModelEntity.getId());
//			license.setLicense(memberModelEntity.getLicense());
//			license.setMemberId(memberId);
//			license.setRegion(memberModelEntity.getRegion());
//			if (memberModelService.isExists(license)) {
//				return super.retEnumResponse(MemberModelResponseEnum.code_1101);
//			}
			// 1.2.1里程数必填
			if (memberModelEntity.getMileage() != null
					&& (memberModelEntity.getMileage() < 1 || memberModelEntity
							.getMileage() > 99999999)) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1107);
			}
			// 1.3校验车架号码（必须17位）;
			if (memberModelEntity.getVin() != null) {
				if (!(memberModelEntity.getVin().matches("^([a-zA-Z0-9]){17}$"))) {
					return super
							.retEnumResponse(MemberModelResponseEnum.code_1103);
				}
			} else {
				memberModelEntity.setVin("");
			}
			if (memberModelEntity.getId() == null) {
				return super.retEnumResponse(MemberModelResponseEnum.code_1104);
			}

			memberModelEntity.setMemberId(memberId);
			memberModelService.update(memberModelEntity);
			return SUCCESSFUL;
		} catch (Exception e) {
			logger.error("类方法：update,编辑我的爱车异常{}", e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * 默认我的爱车
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateFlag", method = RequestMethod.POST)
	public BaseResponse updateFlag(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {

		if (memberModelEntity.getId() == null) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1104);
		}
		Integer memberId = super.getMemberId(request);
		try {

			memberModelEntity.setMemberId(memberId);
			memberModelService.updateFlag(memberModelEntity);
			return SUCCESSFUL;
		} catch (Exception e) {
			logger.error("类方法：updateFlag,默认我的爱车异常{}", e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * 删除我的爱车
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public BaseResponse del(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {
		if (!(memberModelEntity != null && memberModelEntity.getId() != null)) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1104);
		}
		Integer memberId = super.getMemberId(request);
		memberModelEntity.setMemberId(memberId);
		try {

			memberModelService.delMemberModel(memberModelEntity);
			return SUCCESSFUL;
		} catch (Exception e) {
			logger.error("类方法：del,删除我的爱车异常{}", e.getMessage());
			return FAILURE;
		}
	}

	/**
	 * 确认行驶证
	 * 
	 * @param memberModelEntity
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public BaseResponse confirm(MemberModelEntity memberModelEntity,
			HttpServletRequest request) {

		// 校验车牌号
		if (StringUtils.isBlank(memberModelEntity.getLicense())
				|| !CheckUtils.checkLicense(memberModelEntity.getLicense())) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1102);
		} else {
			memberModelEntity.setRegion(memberModelEntity.getLicense()
					.substring(0, 1));
			memberModelEntity.setLicense(memberModelEntity.getLicense()
					.substring(1));
		}

		// // 校验区域
		// if (memberModelEntity.getRegion() == null) {
		// return super.retEnumResponse(MemberModelResponseEnum.code_1106);
		// }
		// // 校验车牌号;
		// if (memberModelEntity.getLicense() == null) {
		// return super.retEnumResponse(MemberModelResponseEnum.code_1102);
		// }

		// 里程数
		if (memberModelEntity.getMileage() != null
				&& (memberModelEntity.getMileage() < 1 || memberModelEntity
						.getMileage() > 99999999)) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1107);
		}
		// 校验品牌型号
		if (StringUtils.isBlank(memberModelEntity.getModel())) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1108);
		}
		// 校验车架号码（必须17位）;
		if (StringUtils.isBlank(memberModelEntity.getVin())
				|| !(memberModelEntity.getVin().matches("^([a-zA-Z0-9]){17}$"))) {
			return super.retEnumResponse(MemberModelResponseEnum.code_1103);
		}

		Integer memberId = super.getMemberId(request);
		memberModelEntity.setMemberId(memberId);

		memberModelEntity.setModelId(0);// TODO 临时方案,扫描的没法对应车型
		memberModelEntity.setModelGroupName(memberModelEntity.getModel());

		try {
			memberModelService.saveMemberModel(memberModelEntity);
			return SUCCESSFUL;
		} catch (Exception e) {
			logger.error("类方法：confirm,确认行驶证异常{}", e.getMessage());
			return FAILURE;
		}
	}

}
