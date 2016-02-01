package com.msds.km.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.baseinfo.common.UserInfo;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.base.BaseController;
import com.msds.km.entity.AreaEntity;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ModelEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.entity.RepairListEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.service.AreaService;
import com.msds.km.service.BespeakService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.MemberService;
import com.msds.km.service.ModelService;
import com.msds.km.service.RepairListService;
import com.msds.km.util.ExcelUtil;
import com.msds.shiro.filter.Constants;
import com.msds.util.AppConstants;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;
import com.msds.util.SmsUtil;
 
/**
 * 
 * <br>
 * <b>功能：</b>BespeakController<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-08-03 16:54:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 */ 
@Controller
@RequestMapping("/repairList") 
public class RepairListController extends BaseController{
	
	@Autowired
	private RepairListService repairListService; 
	
	
	@Autowired
	private AppConstants appConstants;

	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/repair/repair_list",null); 
	}
	
	
	/**
	 * 车主预约单列表
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public Object getDataList(RepairListEntity entity,HttpServletRequest request) throws Exception{
		
		List<RepairListEntity>  list = repairListService.getRepairList(entity);
		if(null == list || list.size() == 0){
			return sendFailureMessage("没有找到对应的记录!");
		}
		int total = repairListService.getRepairListCount(entity);
		return returnDataGrid(total, list);
	}
	
	
	/**
	 * 车主预约单列表
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/importData")
	@ResponseBody
	public Object importData(RepairListEntity entity,HttpServletRequest request) throws Exception{
		

		
		String contextPath = request.getSession().getServletContext().getRealPath("/");

		
		String fullPath = contextPath + entity.getFilePath();
		try {
        	 ExcelUtil excelReader = new ExcelUtil();
        	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream(fullPath);
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            List<RepairListEntity> list = new ArrayList<RepairListEntity>();
            
            for (int i = 1; i <= map.size(); i++) {
            	
            	String [] arrs = String.valueOf(map.get(i)).split("@@@");
            	RepairListEntity repair = new RepairListEntity();
                	
            	repair.setRepairNo(arrs[0]);
            	repair.setMemberName(arrs[1]);
            	repair.setMemberPhone(arrs[2]);
            	repair.setLicense(arrs[3]);
            	repair.setModelGroupName(arrs[4]);
            	repair.setRepairType(arrs[5]);
            	repair.setSettleDate(sdf.parse(arrs[8]));
            	repair.setSettleType(arrs[16]);
            	repair.setSettleAmount(arrs[17]);
            	repair.setVin(arrs[32]);
            	repair.setMileage(arrs[33]);
            	repair.setCardNo(arrs[59]);
            	list.add(repair);

            }
            
            int size = 500;
            int count = list.size() / size;
            
            for(int i = 0; i <= count; i++){
            	List<RepairListEntity> sublist = new ArrayList<RepairListEntity>();
            	
            	if((i+1)*size > list.size()){
            		sublist = list.subList(i*size, list.size());
            	}else{
            		sublist = list.subList(i*size, (i+1)*size);
            	}
            	repairListService.importData(sublist);
            	
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
        
        return sendSuccessMessage();
	}
	
	
	
}
