package com.msds.km.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msds.km.base.BaseController;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.MemberEntity;
import com.msds.km.message.FileUpdateResponseEnum;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.CardInfoService;
import com.msds.km.vo.CardInfo;
import com.msds.setting.SettingUtils;
import com.msds.util.Base64;

/**
 * 会员
 * 
 * @ClassName MemberController
 * @Description TODO
 * @author LiLong
 * @date 2015年4月27日 上午11:21:29
 * 
 */
@Controller
@RequestMapping("/card")
public class CardController extends BaseController {

	@Resource(name = "cardInfoService")
	private CardInfoService cardInfoService;

	/**
	 * 查看会员信息
	 * 
	 * @Description TODO
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public BaseResponse info(HttpServletRequest request) {
		MemberEntity memberEntity = super.getMemberInfo(request);

		CardInfo cardInfo = null;
		try {
			if (StringUtils.isNotBlank(memberEntity.getPhone())) {
				cardInfo = cardInfoService
						.findCardInfo(memberEntity.getPhone());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FAILURE;
		}
		return returnResponse(SUCCESS_CODE, cardInfo);
	}

	/**
	 * 查看招行卡信息
	 * 
	 * @Description TODO
	 * @param request
	 * @return
	 * @return BaseResponse
	 */
	@RequestMapping(value = "/cmbc/info", method = RequestMethod.GET)
	public BaseResponse cmbcInfo(HttpServletRequest request) {

		StringBuffer filePath = new StringBuffer(SettingUtils.get()
				.getCmbcFilePath());
		filePath.append(super.getMemberId(request));
		filePath.append(".jpg");
		File file = new File(filePath.toString());

		Map<String, String> map = new HashMap<>();
		map.put("msg", SettingUtils.get().getCmbcCouponInfo());
		if (file.exists()) {
			StringBuffer sb = new StringBuffer(SettingUtils.get()
					.getCmbcUrlPath());
			sb.append(super.getMemberId(request));
			sb.append(".jpg");
			map.put("url", sb.toString());
		}
		return returnResponse(SUCCESS_CODE, map);
	}

	/**
	 * 修改招行卡
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cmbc/update", method = RequestMethod.POST)
	public BaseResponse cardInfo(String file, HttpServletRequest request) {
		if (StringUtils.isBlank(file))
			return retEnumResponse(FileUpdateResponseEnum.code_1602);
		byte[] b = Base64.decode(file);
		if (b == null)
			return retEnumResponse(FileUpdateResponseEnum.code_1600);
		if (b.length > CommonAttributes.MAX_FILE_SIZE)
			return retEnumResponse(FileUpdateResponseEnum.code_1601);
		String path = SettingUtils.get().getCmbcFilePath();
		File locFile = new File(path);
		if (!locFile.exists())
			locFile.mkdirs();
		StringBuffer sb = new StringBuffer(path);
		sb.append(super.getMemberId(request));
		sb.append(".jpg");
		locFile = new File(sb.toString());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(locFile);
			fos.write(b);
			return SUCCESSFUL;
		} catch (IOException e) {
			e.printStackTrace();
			return FAILURE;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
