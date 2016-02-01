package com.msds.km.api;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.msds.km.form.MaintenanceBylidForm;
import com.msds.km.returnModel.maintenance.MaintenanceModel;
import com.msds.util.JsonUtils;

/**
 * ERP接口服务
 * 
 * @ClassName ErpService
 * @Description 用于ErpAPI的数据交换，实现解耦
 * @author LiLong
 * @date 2014年12月10日 下午1:38:48
 * 
 */
@Service
public class ErpService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * 配件所有三级分类查询
	 * @return
	 */
	public MaintenanceModel getMaintenanceBylid(MaintenanceBylidForm form) throws Exception{
		MaintenanceModel maintenanceModel = null;
		String ret = ERPApi.getMaintenanceBylid(form);
		if (StringUtils.isNotBlank(ret)) {
			maintenanceModel = JsonUtils.toObject(ret,MaintenanceModel.class);
			if (maintenanceModel!=null && maintenanceModel.getDetail()!=null) {
				return maintenanceModel;
			}
		}
		return maintenanceModel;
	}
}
