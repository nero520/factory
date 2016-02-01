package com.msds.km.reparifacoty.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.msds.km.base.BaseController;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.message.DrivingLicenseResponseEnum;
import com.msds.km.model.DrivingLicense;
import com.msds.km.response.BaseResponse;
import com.msds.km.service.DrivingLicenseRecognitionServcie;
import com.msds.km.service.MemberModelService;
import com.msds.open.api.RecognitionException;

@Controller("rfDrivingLicenseController")
@RequestMapping("/rf/drivingLicense")
public class DrivingLicenseController extends BaseController{
	
	@Autowired
	private DrivingLicenseRecognitionServcie drivingLicenseRecognitionServcie;
	@Autowired
	private MemberModelService memberModelService;

	/**
	 * 行驶证信息识别
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/recongnize", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse recongnize(HttpServletRequest request)
			throws RecognitionException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest  
                .getFile("file"); 
		if (file != null && !file.isEmpty()) {
			
			try{
				DrivingLicense drivingLicense = drivingLicenseRecognitionServcie
						.recognition(saveFile(file, request));
				if(drivingLicense!=null){
//					return new Result(businessCode, Result.RESULT_OK, drivingLicense);
					return returnResponse(SUCCESS_CODE, drivingLicense);
				}
				else{
					logger.info("can not recongnize the driving license");
				//	return new Result(businessCode, Result.RESULT_SYS_ERROR, "未识别出行驶证信息");
					return retEnumResponse(DrivingLicenseResponseEnum.code_1300);
				}
			}
			catch(RecognitionException e){
				logger.error("driving license recongnize error", e);
			//	return new Result(businessCode, Result.RESULT_SYS_ERROR, "行驶证识别失败，系统内容错误");
				return retEnumResponse(DrivingLicenseResponseEnum.code_1301);
			}
					
		} else {
		//	return new Result(businessCode, Result.RESULT_PARAMETER_INVALID,"必须上传要识别的行驶证图片文件");
			return retEnumResponse(DrivingLicenseResponseEnum.code_1302);
		}
	}
	
	
	/**
	 * 保存行驶证信息
	 * @param drivingLicense
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse save(DrivingLicense drivingLicense, HttpServletRequest request)
			throws Exception {
		
		if(StringUtils.isEmpty(drivingLicense.getCardno())){
			return returnResponse(FAILURE_CODE,"车牌号码不能为空");
		}
		String region= drivingLicense.getCardno().substring(0, 1);
		String license= drivingLicense.getCardno().substring(1);
		
		MemberModelEntity t = new MemberModelEntity();
		t.setRegion(region);
		t.setLicense(license);
		List<MemberModelEntity> memberModelEntityList = this.memberModelService.findListByCondition(t);
		
		if(memberModelEntityList == null || memberModelEntityList.size() <= 0){
			return returnResponse(FAILURE_CODE,"通过车牌号码没有匹配到订单，请核查，谢谢！");
		}
		
		MemberModelEntity memberModel = memberModelEntityList.get(0);
		if(StringUtils.isNotEmpty(drivingLicense.getVin())){
			memberModel.setVin(drivingLicense.getVin());
		}
		memberModel.setName(drivingLicense.getName());
		memberModel.setAddress(drivingLicense.getAddress());
		memberModel.setRegisterDate(drivingLicense.getRegisterDate());
		memberModel.setIssueDate(drivingLicense.getIssueDate());
		memberModel.setVehicleType(drivingLicense.getVehicleType());
		memberModel.setUseCharacte(drivingLicense.getUseCharacte());
		memberModel.setModel(drivingLicense.getModel());
		memberModel.setEngineNo(drivingLicense.getEngineNO());
		try {
			this.memberModelService.update(memberModel);
		} catch (Exception e) {
			logger.error("保存行驶证信息异常", e);
			return returnResponse(FAILURE_CODE,"其他异常");
		}
		
		return SUCCESSFUL;

	}

	protected File saveFile(CommonsMultipartFile file, HttpServletRequest request) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		/** 构建图片保存的目录 **/
		String logoPathDir = "/files" + dateformat.format(new Date());
		String contextPath=request.getSession().getServletContext().getRealPath("/");
		/** 得到图片保存目录的真实路径 **/
//		String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
		String sep = System.getProperty("file.separator");
		if(contextPath.endsWith(sep)){
			contextPath = contextPath.substring(0,contextPath.length()-1);
		}
		String logoRealPathDir = contextPath.substring(0, contextPath.lastIndexOf(sep)) + logoPathDir;
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(logoRealPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		/** 获取文件的后缀 **/
		String suffix = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称 **/
		String logImageName = UUID.randomUUID().toString() + suffix;
		/** 拼成完整的文件保存路径加文件 **/
		String fileName = logoRealPathDir + File.separator + logImageName;
		File savedFile = new File(fileName);
		try {
			file.transferTo(savedFile);
			return savedFile;
		} catch (IllegalStateException e) {
			throw new RecognitionException(e);
		} catch (IOException e) {
			throw new RecognitionException(e);
		}
	}


}
