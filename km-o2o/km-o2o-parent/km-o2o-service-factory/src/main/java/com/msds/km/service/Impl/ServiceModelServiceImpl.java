package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.ServiceModelEntity;
import com.msds.km.mapper.ServiceMapper;
import com.msds.km.mapper.ServiceModelDetailMapper;
import com.msds.km.mapper.ServiceModelMapper;
import com.msds.km.service.ServiceModelService;
import com.msds.km.vo.ServiceMode;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("serviceModelService")
public class ServiceModelServiceImpl extends
		BaseServiceImpl<ServiceModelEntity> implements ServiceModelService {

	@Autowired
	private ServiceModelMapper serviceModelMapper;
	@Autowired
	private ServiceMapper serviceMapper;
	@Autowired
	private ServiceModelDetailMapper serviceModelDetailMapper;

	public ServiceModelMapper baseMapper() {
		return serviceModelMapper;
	}

	@Override
	public ServiceMode findDetailed(String serviceCode, Integer modeId) {
//		// 服务车型
//		ServiceModelEntity serviceModelEntity = serviceModelMapper
//				.findByCodeMId(serviceCode, modeId);
//		if (serviceModelEntity != null) {
//			// 服务
//			ServiceEntity serviceEntity = serviceMapper.findByCode(serviceCode);
//			if (serviceEntity != null) {
//				// 车型
//				ModelDetailEntity modelDetailEntity = modelDetailMapper
//						.findById(modeId);
//				// 商品
//				List<Product> productList = serviceModelDetailMapper
//						.findProductListByServiceModelId(serviceModelEntity
//								.getId());
//				// TODO 价格、数量暂时不显示
//				// BigDecimal productPrice = new BigDecimal(0);
//				// for (Product product : productList) {
//				// productPrice = productPrice.add(product.getKMPrice());
//				// }
//				// String productsJson = JsonUtils.toJson(productList);
//				// 工时
//				List<Laborcost> laborcostlist = JsonUtils.toObject(
//						serviceModelEntity.getLaborcostJson(),
//						new TypeReference<List<Laborcost>>() {
//						});
//				// TODO 价格、数量暂时不显示
//				// BigDecimal laborcostPrice = new BigDecimal(0);
//				if (laborcostlist != null && laborcostlist.size() > 0) {
//					for (Laborcost laborcost : laborcostlist) {
//						LaborcostEntity laborcostEntity = laborcostMapper
//								.findById(laborcost.getId());
//						laborcost.setItemName(laborcostEntity.getItemName());
//						laborcost.setPrice(laborcostEntity.getPrice());
//						// laborcostPrice =
//						// laborcostPrice.add(laborcost.getPrice());
//					}
//				}
//				// String laborcostsJson = JsonUtils.toJson(laborcostlist);
//				// 封装
//				ServiceMode serviceMode = new ServiceMode();
//				serviceMode.setServiceModelEntity(serviceModelEntity);
//				serviceMode.setServiceEntity(serviceEntity);
//				serviceMode.setModelDetailEntity(modelDetailEntity);
//
//				// serviceMode.setProductsJson(productsJson);
//				// serviceMode.setLaborcostsJson(laborcostsJson);
//				serviceMode.setProductList(productList);
//				serviceMode.setLaborcostlist(laborcostlist);
//				// serviceMode.setLaborcostsPrice(laborcostPrice);
//				// serviceMode.setProductsPrice(productPrice);
//				return serviceMode;
//			}
//		}
		return null;
	}

	@Override
	public List<com.msds.km.vo.Service> findServiceLists(Integer mmodelId,Integer cityId) {

		return serviceMapper.findServiceLists(mmodelId,cityId);
	}

}
