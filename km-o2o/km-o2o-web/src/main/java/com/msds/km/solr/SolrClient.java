package com.msds.km.solr;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.msds.km.solr.form.ProductSeoForm;

/**
 * sorlj客户端代码
 * 
 * @author zengxd
 * 
 */
@Component("solrClient")
public class SolrClient {

	private static HttpSolrServer server;
	
	@Value("${solr.server.url}")
	private String solrUrl;

	private SolrClient() {
	}

	/**
	 * 项目启动时初始化
	 * 
	 * @param solrUrl
	 */
	@PostConstruct
	public void initServer() {
		if (null == server) {
			server = new HttpSolrServer(solrUrl);
		}
	}

	// /**
	// * 搜索通用类：根据传入参数不同，获取不同结果
	// *
	// * @param keyword
	// * @param productCategoryId
	// * @param brandId
	// * @param startPrice
	// * @param endPrice
	// * @param orderType
	// * @param pageNumber
	// * @param pageSize
	// * @param attributeValue
	// * @param searchType
	// * @param total
	// * @return
	// */
	// public static Map<String, Object> searchByCategory(String keyword,
	// Long productCategoryId, Long brandId, BigDecimal startPrice,
	// BigDecimal endPrice, Integer supplierId, OrderType orderType,
	// Integer pageNumber, Integer pageSize,
	// Map<Attribute, String> attributeValue, String searchType,
	// Integer total, Integer categoryLevel) {
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// StringBuffer qsb = new StringBuffer();
	// StringBuffer fqPrice = new StringBuffer();
	// StringBuffer fqBrand = new StringBuffer();
	// StringBuffer fqAttr = new StringBuffer();
	// StringBuffer fqSupplier = new StringBuffer();
	//
	// // 根据treePath模糊查询商品
	// if (null != keyword) {
	// qsb.append("text:").append(keyword);
	// }
	// // } else {
	// // if (null == supplierId || supplierId <1) { // add by pijunling
	// // 可以只根据supplierid搜索
	// // qsb.append("product_category_path:*,")
	// // .append(productCategoryId).append(",*");
	// // }
	// if (null != productCategoryId && productCategoryId > 0) {
	// if (qsb.length() < 1) {
	// qsb.append("product_category_path:*,")
	// .append(productCategoryId).append(",*");//
	// .append(",* AND text:").append(keyword);
	// } else {
	// qsb.append(" AND product_category_path:*,")
	// .append(productCategoryId).append(",*");
	// }
	// }
	// // }
	//
	// // 根据supplierid搜索 add by pijunling
	// if (supplierId != null && supplierId > 0) {
	// // fqSupplier.append("supplierid:").append(supplierId);
	// if (qsb.length() < 1) {
	// qsb.append("supplierid:").append(supplierId);
	// } else {
	// qsb.append(" AND supplierid:").append(supplierId);
	// }
	//
	// }
	//
	// // 品牌条件
	// if (null != brandId) {
	// fqBrand.append("product_brand_id:").append(brandId);
	// }
	// // 参数条件
	// if (null != attributeValue) {
	//
	// Set<Map.Entry<Attribute, String>> set = attributeValue.entrySet();
	// for (Iterator<Map.Entry<Attribute, String>> it = set.iterator(); it
	// .hasNext();) {
	// Map.Entry<Attribute, String> entry = (Map.Entry<Attribute, String>) it
	// .next();
	// if (fqAttr.length() == 0) {
	// fqAttr.append("attribute_value:").append(entry.getValue());
	// } else {
	// fqAttr.append(" AND attribute_value:").append(
	// entry.getValue());
	// }
	// }
	// }
	// // 价格区间
	// if (null == startPrice || null == endPrice) {
	// if (null == startPrice) {
	// startPrice = new BigDecimal(0);
	// }
	// if (null == endPrice) {
	// endPrice = new BigDecimal(9999999);
	// }
	// }
	//
	// if (null != startPrice && null != endPrice) {
	// fqPrice.append("product_price:[").append(startPrice).append(" TO ")
	// .append(endPrice).append("]");
	// }
	//
	// SolrQuery query = new SolrQuery(qsb.toString());
	// query.addFilterQuery(fqPrice.toString());
	// query.addFilterQuery(fqBrand.toString());
	// query.addFilterQuery(fqAttr.toString());
	// // query.addFilterQuery(fqSupplier.toString());
	//
	// if (searchType.equals("attribute")) {
	// map = SolrClient.searchAttribute(query, total, categoryLevel);
	// } else if (searchType.equals("product")) {
	// // 设置排序
	// if (String.valueOf(orderType).equals("priceAsc")) {
	// query.addSortField("product_price", ORDER.asc);
	// } else if (String.valueOf(orderType).equals("priceDesc")) {
	// query.addSortField("product_price", ORDER.desc);
	// } else if (String.valueOf(orderType).equals("salesDesc")) {
	// query.addSortField("product_sales", ORDER.desc);
	// } else if (String.valueOf(orderType).equals("salesAsc")) {
	// query.addSortField("product_sales", ORDER.asc);
	// } else if (String.valueOf(orderType).equals("dateDesc")) {
	// query.addSortField("product_create_time", ORDER.desc);
	// }
	// map = SolrClient.searchProduct(query, pageNumber, pageSize);
	// } else if (searchType.equals("total")) {
	// map = SolrClient.getTotal(query);
	// }
	//
	// return map;
	//
	// }
	//
	// /**
	// * 商品列表
	// *
	// * @param query
	// * @param pageNumber
	// * @param pageSize
	// * @return
	// */
	// public static Map<String, Object> searchProduct(SolrQuery query,
	// Integer pageNumber, Integer pageSize) {
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	//
	// List<ProductSeoForm> list = new ArrayList<ProductSeoForm>();
	// // 分页返回结果
	// if (null != pageNumber && pageSize != null) {
	// query.setStart((pageNumber - 1) * pageSize);
	// query.setRows(pageSize);
	// } else {
	// query.setStart(0);
	// query.setRows(60);
	// }
	//
	// try {
	//
	// QueryResponse response = server.query(query);
	// SolrDocumentList docs = response.getResults();
	// // 总数
	// map.put("total", new Double(docs.getNumFound()).intValue());
	// for (SolrDocument doc : docs) {
	//
	// ProductSeoForm product = new ProductSeoForm();
	// if (null != doc.getFieldValue("product_name")) {
	// product.setName(String.valueOf(doc
	// .getFieldValue("product_name")));
	// }
	//
	// if (null != doc.getFieldValue("product_id")) {
	// product.setId(new Double(doc.getFieldValue("product_id")
	// .toString()).longValue());
	// }
	// if (null != doc.getFieldValue("product_image")) {
	// product.setThumbnail(doc.getFieldValue("product_image")
	// .toString());
	// }
	// if (null != doc.getFieldValue("product_price")) {
	// product.setPrice(new BigDecimal(doc.getFieldValue(
	// "product_price").toString()));
	// }
	// if (null != doc.getFieldValue("suppliername")) {
	// product.setSupplierName(doc.getFieldValue("suppliername")
	// .toString());
	// }
	// list.add(product);
	// }
	// map.put("list", list);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return map;
	// }
	//
	// /**
	// * 获取当前条件下所有的品牌、属性
	// *
	// * @param query
	// * @param total
	// * @return
	// */
	// public static Map<String, Object> searchAttribute(SolrQuery query,
	// Integer total, Integer categoryLevel) {
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// Map<String, String> categoryMap = new HashMap<String, String>();
	// Map<String, String> priceRangeMap = new TreeMap<String, String>();
	// Map<String, String> brandMap = new HashMap<String, String>();
	// Map<String, String> arrMap = new HashMap<String, String>();
	//
	// // 分页返回结果
	// query.setStart(0);
	// query.setRows(total);
	// try {
	// QueryResponse response = server.query(query);
	// SolrDocumentList docs = response.getResults();
	//
	// for (SolrDocument doc : docs) {
	// if (null != doc.getFieldValue("product_brand_id")) {
	// brandMap.put(doc.getFieldValue("product_brand_id")
	// .toString(), doc.getFieldValue("product_brand")
	// .toString());
	// }
	// if (null != doc.getFieldValue("attribute_value")) {
	// // [收腰型, 常规袖, 不带帽, 混色, 简约]
	// String arr = doc.getFieldValue("attribute_value")
	// .toString();
	// arr = arr.replace("[", "");
	// arr = arr.replace("]", "");
	// String arrs[] = arr.split(",");
	// if (null != arrs && arrs.length > 0) {
	// for (int i = 0; i < arrs.length; i++) {
	// arrMap.put(arrs[i].trim(), arrs[i].trim());
	// }
	// }
	// }
	//
	// // 分类
	// if (null != doc.getFieldValue("product_category_path")) {
	//
	// String categoryId = String.valueOf(SolrClient
	// .getCategoryId(
	// doc.getFieldValue("product_category_path")
	// .toString(), categoryLevel));
	// if (!categoryId.equals("0")) {
	// categoryMap
	// .put(categoryId,
	// doc.getFieldValue(
	// "product_category_name"
	// + categoryLevel)
	// .toString());
	// }
	//
	// }
	//
	// if (null != doc.getFieldValue("product_price")) {
	// ProductSeoForm product = new ProductSeoForm();
	// product.setPrice(new BigDecimal(doc.getFieldValue(
	// "product_price").toString()));
	//
	// if (product.getPrice().intValue() <= 300) {
	// priceRangeMap.put("1", "300以下");
	// } else if (product.getPrice().intValue() >= 300
	// && product.getPrice().intValue() <= 500) {
	// priceRangeMap.put("2", "300-500");
	// } else if (product.getPrice().intValue() >= 500
	// && product.getPrice().intValue() <= 800) {
	// priceRangeMap.put("3", "500-800");
	// } else if (product.getPrice().intValue() >= 800
	// && product.getPrice().intValue() <= 1000) {
	// priceRangeMap.put("4", "800-1000");
	// } else if (product.getPrice().intValue() >= 1000
	// && product.getPrice().intValue() <= 2000) {
	// priceRangeMap.put("5", "1000-2000");
	// } else if (product.getPrice().intValue() >= 2000) {
	// priceRangeMap.put("6", "2000以上");
	// }
	//
	// }
	// }
	//
	// // 品牌
	// Set<Brand> brandSet = new HashSet<Brand>();
	// if (null != brandMap) {
	// Set<Map.Entry<String, String>> set = brandMap.entrySet();
	// for (Iterator<Map.Entry<String, String>> it = set.iterator(); it
	// .hasNext();) {
	// Map.Entry<String, String> entry = (Map.Entry<String, String>) it
	// .next();
	// Brand brand = new Brand();
	// brand.setId(new Long(entry.getKey()));
	// brand.setName(entry.getValue());
	// brandSet.add(brand);
	// }
	// }
	//
	// map.put("brandSet", brandSet);
	// map.put("attrMap", arrMap);
	// map.put("categoryMap", categoryMap);
	// map.put("priceRangeMap", priceRangeMap);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return map;
	// }
	//
	// /**
	// * 获取查询总数
	// *
	// * @param query
	// * @return
	// */
	// public static Map<String, Object> getTotal(SolrQuery query) {
	// Map<String, Object> map = new HashMap<String, Object>();
	//
	// try {
	//
	// QueryResponse response = server.query(query);
	// SolrDocumentList docs = response.getResults();
	// map.put("total", new Double(docs.getNumFound()).intValue());
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return map;
	// }
	//
	// /**
	// * 导航搜索
	// *
	// * @param productCategoryId
	// * @param brandId
	// * @param startPrice
	// * @param endPrice
	// * @param orderType
	// * @param pageNumber
	// * @param pageSize
	// * @param attributeValue
	// * @return
	// */
	// public static Map<String, Object> searchByKeyword(String keyword,
	// BigDecimal startPrice, BigDecimal endPrice, OrderType orderType,
	// Integer pageNumber, Integer pageSize) {
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// StringBuffer qsb = new StringBuffer();
	// StringBuffer fqPrice = new StringBuffer();
	//
	// // 查询条件：名称、分类、品牌
	// if (null != keyword) {
	// qsb.append("text:").append(keyword);
	// } else {
	// qsb.append("*:*");
	// }
	//
	// // 查询条件-价格区间
	// if (null != startPrice && null != endPrice) {
	// fqPrice.append("product_price:[").append(startPrice).append(" TO ")
	// .append(endPrice).append("]");
	// }
	//
	// SolrQuery query = new SolrQuery(qsb.toString());
	// query.addFilterQuery(fqPrice.toString());
	//
	// // 设置排序
	// if (String.valueOf(orderType).equals("priceAsc")) {
	// query.addSortField("product_price", ORDER.asc);
	// } else if (String.valueOf(orderType).equals("priceDesc")) {
	// query.addSortField("product_price", ORDER.desc);
	// } else if (String.valueOf(orderType).equals("salesDesc")) {
	// query.addSortField("product_sales", ORDER.desc);
	// } else if (String.valueOf(orderType).equals("salesAsc")) {
	// query.addSortField("product_sales", ORDER.asc);
	// } else if (String.valueOf(orderType).equals("dateDesc")) {
	// query.addSortField("product_create_time", ORDER.desc);
	// }
	//
	// // 分页返回结果
	// if (null != pageNumber && pageSize != null) {
	// query.setStart((pageNumber - 1) * pageSize);
	// query.setRows(pageSize);
	// } else {
	// query.setStart(0);
	// query.setRows(60);
	// }
	//
	// // 设置高亮
	// // query.setHighlight(true); // 开启高亮组件
	// // query.addHighlightField("product_name");// 高亮字段
	// // query.setHighlightSimplePre("<font color='red'>");// 标记，高亮关键字前缀
	// // query.setHighlightSimplePost("</font>");// 后缀
	// // query.setHighlightSnippets(2);// 结果分片数，默认为1
	// // query.setHighlightFragsize(1000);// 每个分片的最大长度，默认为100
	// List<ProductSeoForm> list = new ArrayList<ProductSeoForm>();
	//
	// try {
	//
	// QueryResponse response = server.query(query);
	// // Map<String,Map<String,List<String>>>
	// // highlightMap=response.getHighlighting();
	// SolrDocumentList docs = response.getResults();
	// // 总数
	// map.put("total", new Double(docs.getNumFound()).intValue());
	// for (SolrDocument doc : docs) {
	// ProductSeoForm product = new ProductSeoForm();
	// // 获取高亮字段
	// // List<String>
	// //
	// titleList=highlightMap.get(doc.getFieldValue("product_id")).get("product_name");
	//
	// try {
	// // if(titleList!=null && titleList.size()>0){
	// // product.setName(titleList.get(0));
	// // }else{
	// if (null != doc.getFieldValue("product_name")) {
	// product.setName(String.valueOf(doc
	// .getFieldValue("product_name")));
	// }
	// // }
	//
	// if (null != doc.getFieldValue("product_price")) {
	// product.setPrice(new BigDecimal(doc.getFieldValue(
	// "product_price").toString()));
	// }
	// if (null != doc.getFieldValue("product_id")) {
	// product.setId(new Double(doc
	// .getFieldValue("product_id").toString())
	// .longValue());
	// }
	// if (null != doc.getFieldValue("product_image")) {
	// product.setThumbnail(doc.getFieldValue("product_image")
	// .toString());
	// }
	// list.add(product);
	// } catch (Exception e) {
	// continue;
	// }
	// }
	//
	// map.put("list", list);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return map;
	// }
	//
	// public static int getCategoryId(String categoryPath, int level) {
	// // ,1,7,1292,1297,
	// String[] ids = categoryPath.split(",");
	// int categoryId = 0;
	//
	// if (null != ids && ids.length > 0) {
	// for (int i = 0; i < ids.length; i++) {
	// if (i == level) {
	// categoryId = new Double(ids[i]).intValue();
	// }
	// }
	// }
	//
	// return categoryId;
	// }

}
