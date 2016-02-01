package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CheckBillEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-11-05 16:54:47 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CheckBillEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**修理厂id*/
	private java.lang.Integer companyId;
	/**表单sn*/
	private java.lang.String billSn;
	/**顾客名称*/
	private java.lang.String customerName;
	/**客户电话*/
	private java.lang.String telphone;
	/**车牌号*/
	private java.lang.String license;
	/**工单号*/
	private java.lang.String serviceCode;
	/**车型3级id*/
	private java.lang.Integer modelId3;
	/**车型二级ID*/
	private java.lang.Integer modelId2;
	/**车型1级ID*/
	private java.lang.Integer modelId;
	/**车型全称*/
	private java.lang.String fullModelName;
	/**左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防*/
	private java.lang.Integer zqltw1;
	/**左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防*/
	private java.lang.Integer yqltw1;
	/**左后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防*/
	private java.lang.Integer zhltw2;
	/**右后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防*/
	private java.lang.Integer yhltw2;
	/**左前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中*/
	private java.lang.Integer zqlty3;
	/**右前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中*/
	private java.lang.Integer yqlty4;
	/**左后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中*/
	private java.lang.Integer zhlty5;
	/**右后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中*/
	private java.lang.Integer yhlty6;
	/**左右前后轮胎压异常描述*/
	private java.lang.String exZyqhltty34567;
	/**左右前后轮胎压解决方案*/
	private java.lang.String dealZyqhltty34567;
	/**节气门是否清洁：1.正常 0.异常*/
	private java.lang.Integer jqm8;
	/**节气门是否清洁异常描述*/
	private java.lang.String exJqm8;
	/**轮胎螺栓扭矩：1.正常 0.异常*/
	private java.lang.Integer ltlsnj9;
	/**轮胎螺栓扭矩异常描述*/
	private java.lang.String exLtlsnj9;
	/**节气门是否清洁 轮胎螺栓扭矩解决方案*/
	private java.lang.String dealLtlsnj89;
	/**左前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防*/
	private java.lang.Integer zqscp10;
	/**右前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防*/
	private java.lang.Integer yqscp11;
	/**左后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防*/
	private java.lang.Integer zhscp12;
	/**右后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防*/
	private java.lang.Integer yhscp13;
	/**左前刹车盘：1.正常 0.破损*/
	private java.lang.Integer zqscpa14;
	/**右前刹车盘：1.正常 0.破损*/
	private java.lang.Integer yqscpa15;
	/**左后刹车盘：1.正常 0.破损*/
	private java.lang.Integer zhscpa16;
	/**右后刹车盘：1.正常 0.破损*/
	private java.lang.Integer yhscpa17;
	/**前后左右刹车盘解决方案*/
	private java.lang.String dealQhzysppa14151617;
	/**制动液含水量：1.正常 ＜1.5% 2.建议更换 1＜x＜2.5% 3.必须更换 ＞2.5%*/
	private java.lang.Integer zdlhsl18;
	/**制动液含水量解决方案*/
	private java.lang.String dealZdlhsl18;
	/**空调是否有异味：1.正常 0.异常*/
	private java.lang.Integer ktyw19;
	/**空调是否有异味异常描述*/
	private java.lang.String exKtyw19;
	/**空调是否制冷／制热：1.正常 0.异常*/
	private java.lang.Integer ktzl20;
	/**空调是否制冷／制热异常描述*/
	private java.lang.String exKtzl20;
	/**空调风口温度：1.正常 0.异常*/
	private java.lang.Integer ktwd21;
	/**空调风口温度异常描述*/
	private java.lang.String exKtwd21;
	/**空调滤芯是否清洁：1.是 0.否*/
	private java.lang.Integer ktlx22;
	/**空调滤芯是否清洁异常描述*/
	private java.lang.String exKtlx22;
	/**空调跟踪预防 1.跟踪 0.不跟踪*/
	private java.lang.Integer ktgzyf23;
	/**空调解决方案*/
	private java.lang.String dealKt19202122;
	/**汽车喇叭：1.正常 0.异常*/
	private java.lang.Integer qclb24;
	/**汽车喇叭异常*/
	private java.lang.String exQclb24;
	/**汽车音响：1.正常 0.异常*/
	private java.lang.Integer qcyx25;
	/**汽车音响异常描述*/
	private java.lang.String exQcyx25;
	/**安全带：1.正常 0.异常*/
	private java.lang.Integer aqd26;
	/**安全带异常描述*/
	private java.lang.String exAqd26;
	/**中控锁：1.正常 0.异常*/
	private java.lang.Integer zks27;
	/**中控锁异常描述*/
	private java.lang.String exZks27;
	/**自动车窗：1.正常 0.异常*/
	private java.lang.Integer zdcc28;
	/**自动车窗异常描述*/
	private java.lang.String exZdcc28;
	/**汽车喇叭 汽车音响 安全带 中控锁 自动车窗解决方案*/
	private java.lang.String dealQclyazz2425262728;
	/**蓄电池性能:1.正常；2.亏电；3.更换*/
	private java.lang.Integer xdcxn29;
	/**防冻液液位：1.正常（-40°<x<-25°）0.异常 x＜-40°，x＞-25°*/
	private java.lang.Integer fdyyw30;
	/**火花塞腐蚀度：1.正常 0.异常*/
	private java.lang.Integer hhsfsd31;
	/**火花塞腐蚀度描述*/
	private java.lang.String exHhsfsd31;
	/**发动机油位：1.正常 0.异常*/
	private java.lang.Integer fdjyw32;
	/**发动机油位异常描述*/
	private java.lang.String exFdjyw32;
	/**蓄电池性能  防冻液液位 火花塞腐蚀度 发动机油位解决方案*/
	private java.lang.String dealXfhf29303132;
	/**转向油油位：1.正常；0.异常*/
	private java.lang.Integer zxyywgl33;
	/**转向油油位异常描述*/
	private java.lang.String exZxyywgl33;
	/**发动机皮带:1.正常；0.异常*/
	private java.lang.Integer fdjpdgl34;
	/**发动机皮带异常*/
	private java.lang.String exFdjpdgl34;
	/**转向油油位 发动机皮带解决方案*/
	private java.lang.String dealZxypd3334;
	/**减震器：1.正常 0.异常*/
	private java.lang.Integer jzq35;
	/**减震器异常描述*/
	private java.lang.String exJzq35;
	/**止推轴承：1.正常 0.异常*/
	private java.lang.Integer ztzc36;
	/**止推轴承异常描述*/
	private java.lang.String exZtzc36;
	/**底盘件：1.正常 0.异常*/
	private java.lang.Integer dpj37;
	/**底盘件异常描述*/
	private java.lang.String exDpj37;
	/**传动轴防尘套：1.正常 0.异常*/
	private java.lang.Integer cdzfct38;
	/**传动轴防尘套异常描述*/
	private java.lang.String exCdzfct38;
	/**万向节安全套：1.正常 0.异常*/
	private java.lang.Integer wxjaqt39;
	/**万向节安全套*/
	private java.lang.String exWxjaqt39;
	/**变速箱支脚：1.正常 0.异常*/
	private java.lang.Integer bsxzj40;
	/**变速箱支脚异常描述*/
	private java.lang.String exBsxzj40;
	/**减震器 止推轴承  底盘件 传动轴防尘套 万向节安全套 变速箱支脚解决方案*/
	private java.lang.String dealJzdcwb353637383940;
	/**车内灯光：1.正常 0.异常*/
	private java.lang.Integer cndg41;
	/**车内灯光异常描述*/
	private java.lang.String exCndg41;
	/**车外灯光：1.正常 0.异常*/
	private java.lang.Integer cwdg42;
	/**车外灯光异常描述*/
	private java.lang.String exCwdg42;
	/**仪表盘故障灯：1.正常 0.异常*/
	private java.lang.Integer ybpgzd43;
	/**仪表盘故障灯异常描述*/
	private java.lang.String exYbpgzd43;
	/**车内灯光 车外灯光 仪表盘故障灯解决方案描述*/
	private java.lang.String dealCnwybp414243;
	/**玻璃清洗液：1.正常 0.异常*/
	private java.lang.Integer blqxy44;
	/**复检结果*/
	private java.lang.String recheck;
	/**建议维修项目*/
	private java.lang.String suggest;

		/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	public java.lang.Integer getId(){
		return this.id;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  修理厂id
	 */
	public java.lang.Integer getCompanyId(){
		return this.companyId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修理厂id
	 */
	public void setCompanyId(java.lang.Integer companyId){
		this.companyId = companyId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单sn
	 */
	public java.lang.String getBillSn(){
		return this.billSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单sn
	 */
	public void setBillSn(java.lang.String billSn){
		this.billSn = billSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顾客名称
	 */
	public java.lang.String getCustomerName(){
		return this.customerName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顾客名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户电话
	 */
	public java.lang.String getTelphone(){
		return this.telphone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户电话
	 */
	public void setTelphone(java.lang.String telphone){
		this.telphone = telphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */
	public java.lang.String getLicense(){
		return this.license;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setLicense(java.lang.String license){
		this.license = license;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工单号
	 */
	public java.lang.String getServiceCode(){
		return this.serviceCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工单号
	 */
	public void setServiceCode(java.lang.String serviceCode){
		this.serviceCode = serviceCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车型3级id
	 */
	public java.lang.Integer getModelId3(){
		return this.modelId3;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车型3级id
	 */
	public void setModelId3(java.lang.Integer modelId3){
		this.modelId3 = modelId3;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车型二级ID
	 */
	public java.lang.Integer getModelId2(){
		return this.modelId2;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车型二级ID
	 */
	public void setModelId2(java.lang.Integer modelId2){
		this.modelId2 = modelId2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车型1级ID
	 */
	public java.lang.Integer getModelId(){
		return this.modelId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车型1级ID
	 */
	public void setModelId(java.lang.Integer modelId){
		this.modelId = modelId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型全称
	 */
	public java.lang.String getFullModelName(){
		return this.fullModelName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型全称
	 */
	public void setFullModelName(java.lang.String fullModelName){
		this.fullModelName = fullModelName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public java.lang.Integer getZqltw1(){
		return this.zqltw1;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public void setZqltw1(java.lang.Integer zqltw1){
		this.zqltw1 = zqltw1;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public java.lang.Integer getYqltw1(){
		return this.yqltw1;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左前轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public void setYqltw1(java.lang.Integer yqltw1){
		this.yqltw1 = yqltw1;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public java.lang.Integer getZhltw2(){
		return this.zhltw2;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public void setZhltw2(java.lang.Integer zhltw2){
		this.zhltw2 = zhltw2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public java.lang.Integer getYhltw2(){
		return this.yhltw2;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右后轮胎纹：1.正常 10～16mm 2.建议更换 2～5mm  3.必须更换 1.6～2mm 4.跟踪预防
	 */
	public void setYhltw2(java.lang.Integer yhltw2){
		this.yhltw2 = yhltw2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public java.lang.Integer getZqlty3(){
		return this.zqlty3;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public void setZqlty3(java.lang.Integer zqlty3){
		this.zqlty3 = zqlty3;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public java.lang.Integer getYqlty4(){
		return this.yqlty4;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右前轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public void setYqlty4(java.lang.Integer yqlty4){
		this.yqlty4 = yqlty4;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public java.lang.Integer getZhlty5(){
		return this.zhlty5;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public void setZhlty5(java.lang.Integer zhlty5){
		this.zhlty5 = zhlty5;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public java.lang.Integer getYhlty6(){
		return this.yhlty6;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右后轮胎压 正常 1.9～2.4bar 1.选中；0.未选中
	 */
	public void setYhlty6(java.lang.Integer yhlty6){
		this.yhlty6 = yhlty6;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  左右前后轮胎压异常描述
	 */
	public java.lang.String getExZyqhltty34567(){
		return this.exZyqhltty34567;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  左右前后轮胎压异常描述
	 */
	public void setExZyqhltty34567(java.lang.String exZyqhltty34567){
		this.exZyqhltty34567 = exZyqhltty34567;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  左右前后轮胎压解决方案
	 */
	public java.lang.String getDealZyqhltty34567(){
		return this.dealZyqhltty34567;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  左右前后轮胎压解决方案
	 */
	public void setDealZyqhltty34567(java.lang.String dealZyqhltty34567){
		this.dealZyqhltty34567 = dealZyqhltty34567;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  节气门是否清洁：1.正常 0.异常
	 */
	public java.lang.Integer getJqm8(){
		return this.jqm8;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  节气门是否清洁：1.正常 0.异常
	 */
	public void setJqm8(java.lang.Integer jqm8){
		this.jqm8 = jqm8;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  节气门是否清洁异常描述
	 */
	public java.lang.String getExJqm8(){
		return this.exJqm8;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  节气门是否清洁异常描述
	 */
	public void setExJqm8(java.lang.String exJqm8){
		this.exJqm8 = exJqm8;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  轮胎螺栓扭矩：1.正常 0.异常
	 */
	public java.lang.Integer getLtlsnj9(){
		return this.ltlsnj9;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  轮胎螺栓扭矩：1.正常 0.异常
	 */
	public void setLtlsnj9(java.lang.Integer ltlsnj9){
		this.ltlsnj9 = ltlsnj9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  轮胎螺栓扭矩异常描述
	 */
	public java.lang.String getExLtlsnj9(){
		return this.exLtlsnj9;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  轮胎螺栓扭矩异常描述
	 */
	public void setExLtlsnj9(java.lang.String exLtlsnj9){
		this.exLtlsnj9 = exLtlsnj9;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  节气门是否清洁 轮胎螺栓扭矩解决方案
	 */
	public java.lang.String getDealLtlsnj89(){
		return this.dealLtlsnj89;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  节气门是否清洁 轮胎螺栓扭矩解决方案
	 */
	public void setDealLtlsnj89(java.lang.String dealLtlsnj89){
		this.dealLtlsnj89 = dealLtlsnj89;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防
	 */
	public java.lang.Integer getZqscp10(){
		return this.zqscp10;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防
	 */
	public void setZqscp10(java.lang.Integer zqscp10){
		this.zqscp10 = zqscp10;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防
	 */
	public java.lang.Integer getYqscp11(){
		return this.yqscp11;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右前刹车片：1.正常 13mm~14mm 2.建议更换 11mm~12mm 3.必须更换 ≤11mm 4.跟踪预防
	 */
	public void setYqscp11(java.lang.Integer yqscp11){
		this.yqscp11 = yqscp11;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防
	 */
	public java.lang.Integer getZhscp12(){
		return this.zhscp12;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防
	 */
	public void setZhscp12(java.lang.Integer zhscp12){
		this.zhscp12 = zhscp12;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防
	 */
	public java.lang.Integer getYhscp13(){
		return this.yhscp13;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右后刹车片：1.正常 12mm~13mm 2.建议更换 8mm~9mm 3.必须更换 ≤8mm 4.跟踪预防
	 */
	public void setYhscp13(java.lang.Integer yhscp13){
		this.yhscp13 = yhscp13;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左前刹车盘：1.正常 0.破损
	 */
	public java.lang.Integer getZqscpa14(){
		return this.zqscpa14;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左前刹车盘：1.正常 0.破损
	 */
	public void setZqscpa14(java.lang.Integer zqscpa14){
		this.zqscpa14 = zqscpa14;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右前刹车盘：1.正常 0.破损
	 */
	public java.lang.Integer getYqscpa15(){
		return this.yqscpa15;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右前刹车盘：1.正常 0.破损
	 */
	public void setYqscpa15(java.lang.Integer yqscpa15){
		this.yqscpa15 = yqscpa15;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  左后刹车盘：1.正常 0.破损
	 */
	public java.lang.Integer getZhscpa16(){
		return this.zhscpa16;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  左后刹车盘：1.正常 0.破损
	 */
	public void setZhscpa16(java.lang.Integer zhscpa16){
		this.zhscpa16 = zhscpa16;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  右后刹车盘：1.正常 0.破损
	 */
	public java.lang.Integer getYhscpa17(){
		return this.yhscpa17;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  右后刹车盘：1.正常 0.破损
	 */
	public void setYhscpa17(java.lang.Integer yhscpa17){
		this.yhscpa17 = yhscpa17;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  前后左右刹车盘解决方案
	 */
	public java.lang.String getDealQhzysppa14151617(){
		return this.dealQhzysppa14151617;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  前后左右刹车盘解决方案
	 */
	public void setDealQhzysppa14151617(java.lang.String dealQhzysppa14151617){
		this.dealQhzysppa14151617 = dealQhzysppa14151617;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  制动液含水量：1.正常 ＜1.5% 2.建议更换 1＜x＜2.5% 3.必须更换 ＞2.5%
	 */
	public java.lang.Integer getZdlhsl18(){
		return this.zdlhsl18;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  制动液含水量：1.正常 ＜1.5% 2.建议更换 1＜x＜2.5% 3.必须更换 ＞2.5%
	 */
	public void setZdlhsl18(java.lang.Integer zdlhsl18){
		this.zdlhsl18 = zdlhsl18;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制动液含水量解决方案
	 */
	public java.lang.String getDealZdlhsl18(){
		return this.dealZdlhsl18;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制动液含水量解决方案
	 */
	public void setDealZdlhsl18(java.lang.String dealZdlhsl18){
		this.dealZdlhsl18 = dealZdlhsl18;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空调是否有异味：1.正常 0.异常
	 */
	public java.lang.Integer getKtyw19(){
		return this.ktyw19;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空调是否有异味：1.正常 0.异常
	 */
	public void setKtyw19(java.lang.Integer ktyw19){
		this.ktyw19 = ktyw19;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空调是否有异味异常描述
	 */
	public java.lang.String getExKtyw19(){
		return this.exKtyw19;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空调是否有异味异常描述
	 */
	public void setExKtyw19(java.lang.String exKtyw19){
		this.exKtyw19 = exKtyw19;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空调是否制冷／制热：1.正常 0.异常
	 */
	public java.lang.Integer getKtzl20(){
		return this.ktzl20;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空调是否制冷／制热：1.正常 0.异常
	 */
	public void setKtzl20(java.lang.Integer ktzl20){
		this.ktzl20 = ktzl20;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空调是否制冷／制热异常描述
	 */
	public java.lang.String getExKtzl20(){
		return this.exKtzl20;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空调是否制冷／制热异常描述
	 */
	public void setExKtzl20(java.lang.String exKtzl20){
		this.exKtzl20 = exKtzl20;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空调风口温度：1.正常 0.异常
	 */
	public java.lang.Integer getKtwd21(){
		return this.ktwd21;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空调风口温度：1.正常 0.异常
	 */
	public void setKtwd21(java.lang.Integer ktwd21){
		this.ktwd21 = ktwd21;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空调风口温度异常描述
	 */
	public java.lang.String getExKtwd21(){
		return this.exKtwd21;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空调风口温度异常描述
	 */
	public void setExKtwd21(java.lang.String exKtwd21){
		this.exKtwd21 = exKtwd21;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空调滤芯是否清洁：1.是 0.否
	 */
	public java.lang.Integer getKtlx22(){
		return this.ktlx22;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空调滤芯是否清洁：1.是 0.否
	 */
	public void setKtlx22(java.lang.Integer ktlx22){
		this.ktlx22 = ktlx22;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空调滤芯是否清洁异常描述
	 */
	public java.lang.String getExKtlx22(){
		return this.exKtlx22;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空调滤芯是否清洁异常描述
	 */
	public void setExKtlx22(java.lang.String exKtlx22){
		this.exKtlx22 = exKtlx22;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空调跟踪预防 1.跟踪 0.不跟踪
	 */
	public java.lang.Integer getKtgzyf23(){
		return this.ktgzyf23;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空调跟踪预防 1.跟踪 0.不跟踪
	 */
	public void setKtgzyf23(java.lang.Integer ktgzyf23){
		this.ktgzyf23 = ktgzyf23;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  空调解决方案
	 */
	public java.lang.String getDealKt19202122(){
		return this.dealKt19202122;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  空调解决方案
	 */
	public void setDealKt19202122(java.lang.String dealKt19202122){
		this.dealKt19202122 = dealKt19202122;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  汽车喇叭：1.正常 0.异常
	 */
	public java.lang.Integer getQclb24(){
		return this.qclb24;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  汽车喇叭：1.正常 0.异常
	 */
	public void setQclb24(java.lang.Integer qclb24){
		this.qclb24 = qclb24;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汽车喇叭异常
	 */
	public java.lang.String getExQclb24(){
		return this.exQclb24;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汽车喇叭异常
	 */
	public void setExQclb24(java.lang.String exQclb24){
		this.exQclb24 = exQclb24;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  汽车音响：1.正常 0.异常
	 */
	public java.lang.Integer getQcyx25(){
		return this.qcyx25;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  汽车音响：1.正常 0.异常
	 */
	public void setQcyx25(java.lang.Integer qcyx25){
		this.qcyx25 = qcyx25;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汽车音响异常描述
	 */
	public java.lang.String getExQcyx25(){
		return this.exQcyx25;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汽车音响异常描述
	 */
	public void setExQcyx25(java.lang.String exQcyx25){
		this.exQcyx25 = exQcyx25;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  安全带：1.正常 0.异常
	 */
	public java.lang.Integer getAqd26(){
		return this.aqd26;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  安全带：1.正常 0.异常
	 */
	public void setAqd26(java.lang.Integer aqd26){
		this.aqd26 = aqd26;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安全带异常描述
	 */
	public java.lang.String getExAqd26(){
		return this.exAqd26;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安全带异常描述
	 */
	public void setExAqd26(java.lang.String exAqd26){
		this.exAqd26 = exAqd26;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  中控锁：1.正常 0.异常
	 */
	public java.lang.Integer getZks27(){
		return this.zks27;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  中控锁：1.正常 0.异常
	 */
	public void setZks27(java.lang.Integer zks27){
		this.zks27 = zks27;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中控锁异常描述
	 */
	public java.lang.String getExZks27(){
		return this.exZks27;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中控锁异常描述
	 */
	public void setExZks27(java.lang.String exZks27){
		this.exZks27 = exZks27;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  自动车窗：1.正常 0.异常
	 */
	public java.lang.Integer getZdcc28(){
		return this.zdcc28;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  自动车窗：1.正常 0.异常
	 */
	public void setZdcc28(java.lang.Integer zdcc28){
		this.zdcc28 = zdcc28;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自动车窗异常描述
	 */
	public java.lang.String getExZdcc28(){
		return this.exZdcc28;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自动车窗异常描述
	 */
	public void setExZdcc28(java.lang.String exZdcc28){
		this.exZdcc28 = exZdcc28;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汽车喇叭 汽车音响 安全带 中控锁 自动车窗解决方案
	 */
	public java.lang.String getDealQclyazz2425262728(){
		return this.dealQclyazz2425262728;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汽车喇叭 汽车音响 安全带 中控锁 自动车窗解决方案
	 */
	public void setDealQclyazz2425262728(java.lang.String dealQclyazz2425262728){
		this.dealQclyazz2425262728 = dealQclyazz2425262728;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  蓄电池性能:1.正常；2.亏电；3.更换
	 */
	public java.lang.Integer getXdcxn29(){
		return this.xdcxn29;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  蓄电池性能:1.正常；2.亏电；3.更换
	 */
	public void setXdcxn29(java.lang.Integer xdcxn29){
		this.xdcxn29 = xdcxn29;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  防冻液液位：1.正常（-40°<x<-25°）0.异常 x＜-40°，x＞-25°
	 */
	public java.lang.Integer getFdyyw30(){
		return this.fdyyw30;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  防冻液液位：1.正常（-40°<x<-25°）0.异常 x＜-40°，x＞-25°
	 */
	public void setFdyyw30(java.lang.Integer fdyyw30){
		this.fdyyw30 = fdyyw30;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  火花塞腐蚀度：1.正常 0.异常
	 */
	public java.lang.Integer getHhsfsd31(){
		return this.hhsfsd31;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  火花塞腐蚀度：1.正常 0.异常
	 */
	public void setHhsfsd31(java.lang.Integer hhsfsd31){
		this.hhsfsd31 = hhsfsd31;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  火花塞腐蚀度描述
	 */
	public java.lang.String getExHhsfsd31(){
		return this.exHhsfsd31;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  火花塞腐蚀度描述
	 */
	public void setExHhsfsd31(java.lang.String exHhsfsd31){
		this.exHhsfsd31 = exHhsfsd31;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发动机油位：1.正常 0.异常
	 */
	public java.lang.Integer getFdjyw32(){
		return this.fdjyw32;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发动机油位：1.正常 0.异常
	 */
	public void setFdjyw32(java.lang.Integer fdjyw32){
		this.fdjyw32 = fdjyw32;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发动机油位异常描述
	 */
	public java.lang.String getExFdjyw32(){
		return this.exFdjyw32;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发动机油位异常描述
	 */
	public void setExFdjyw32(java.lang.String exFdjyw32){
		this.exFdjyw32 = exFdjyw32;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  蓄电池性能  防冻液液位 火花塞腐蚀度 发动机油位解决方案
	 */
	public java.lang.String getDealXfhf29303132(){
		return this.dealXfhf29303132;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  蓄电池性能  防冻液液位 火花塞腐蚀度 发动机油位解决方案
	 */
	public void setDealXfhf29303132(java.lang.String dealXfhf29303132){
		this.dealXfhf29303132 = dealXfhf29303132;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  转向油油位：1.正常；0.异常
	 */
	public java.lang.Integer getZxyywgl33(){
		return this.zxyywgl33;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  转向油油位：1.正常；0.异常
	 */
	public void setZxyywgl33(java.lang.Integer zxyywgl33){
		this.zxyywgl33 = zxyywgl33;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转向油油位异常描述
	 */
	public java.lang.String getExZxyywgl33(){
		return this.exZxyywgl33;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转向油油位异常描述
	 */
	public void setExZxyywgl33(java.lang.String exZxyywgl33){
		this.exZxyywgl33 = exZxyywgl33;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发动机皮带:1.正常；0.异常
	 */
	public java.lang.Integer getFdjpdgl34(){
		return this.fdjpdgl34;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发动机皮带:1.正常；0.异常
	 */
	public void setFdjpdgl34(java.lang.Integer fdjpdgl34){
		this.fdjpdgl34 = fdjpdgl34;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发动机皮带异常
	 */
	public java.lang.String getExFdjpdgl34(){
		return this.exFdjpdgl34;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发动机皮带异常
	 */
	public void setExFdjpdgl34(java.lang.String exFdjpdgl34){
		this.exFdjpdgl34 = exFdjpdgl34;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转向油油位 发动机皮带解决方案
	 */
	public java.lang.String getDealZxypd3334(){
		return this.dealZxypd3334;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转向油油位 发动机皮带解决方案
	 */
	public void setDealZxypd3334(java.lang.String dealZxypd3334){
		this.dealZxypd3334 = dealZxypd3334;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  减震器：1.正常 0.异常
	 */
	public java.lang.Integer getJzq35(){
		return this.jzq35;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  减震器：1.正常 0.异常
	 */
	public void setJzq35(java.lang.Integer jzq35){
		this.jzq35 = jzq35;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  减震器异常描述
	 */
	public java.lang.String getExJzq35(){
		return this.exJzq35;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  减震器异常描述
	 */
	public void setExJzq35(java.lang.String exJzq35){
		this.exJzq35 = exJzq35;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  止推轴承：1.正常 0.异常
	 */
	public java.lang.Integer getZtzc36(){
		return this.ztzc36;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  止推轴承：1.正常 0.异常
	 */
	public void setZtzc36(java.lang.Integer ztzc36){
		this.ztzc36 = ztzc36;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  止推轴承异常描述
	 */
	public java.lang.String getExZtzc36(){
		return this.exZtzc36;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  止推轴承异常描述
	 */
	public void setExZtzc36(java.lang.String exZtzc36){
		this.exZtzc36 = exZtzc36;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  底盘件：1.正常 0.异常
	 */
	public java.lang.Integer getDpj37(){
		return this.dpj37;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  底盘件：1.正常 0.异常
	 */
	public void setDpj37(java.lang.Integer dpj37){
		this.dpj37 = dpj37;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  底盘件异常描述
	 */
	public java.lang.String getExDpj37(){
		return this.exDpj37;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  底盘件异常描述
	 */
	public void setExDpj37(java.lang.String exDpj37){
		this.exDpj37 = exDpj37;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  传动轴防尘套：1.正常 0.异常
	 */
	public java.lang.Integer getCdzfct38(){
		return this.cdzfct38;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  传动轴防尘套：1.正常 0.异常
	 */
	public void setCdzfct38(java.lang.Integer cdzfct38){
		this.cdzfct38 = cdzfct38;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传动轴防尘套异常描述
	 */
	public java.lang.String getExCdzfct38(){
		return this.exCdzfct38;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传动轴防尘套异常描述
	 */
	public void setExCdzfct38(java.lang.String exCdzfct38){
		this.exCdzfct38 = exCdzfct38;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  万向节安全套：1.正常 0.异常
	 */
	public java.lang.Integer getWxjaqt39(){
		return this.wxjaqt39;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  万向节安全套：1.正常 0.异常
	 */
	public void setWxjaqt39(java.lang.Integer wxjaqt39){
		this.wxjaqt39 = wxjaqt39;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  万向节安全套
	 */
	public java.lang.String getExWxjaqt39(){
		return this.exWxjaqt39;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  万向节安全套
	 */
	public void setExWxjaqt39(java.lang.String exWxjaqt39){
		this.exWxjaqt39 = exWxjaqt39;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  变速箱支脚：1.正常 0.异常
	 */
	public java.lang.Integer getBsxzj40(){
		return this.bsxzj40;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  变速箱支脚：1.正常 0.异常
	 */
	public void setBsxzj40(java.lang.Integer bsxzj40){
		this.bsxzj40 = bsxzj40;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  变速箱支脚异常描述
	 */
	public java.lang.String getExBsxzj40(){
		return this.exBsxzj40;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  变速箱支脚异常描述
	 */
	public void setExBsxzj40(java.lang.String exBsxzj40){
		this.exBsxzj40 = exBsxzj40;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  减震器 止推轴承  底盘件 传动轴防尘套 万向节安全套 变速箱支脚解决方案
	 */
	public java.lang.String getDealJzdcwb353637383940(){
		return this.dealJzdcwb353637383940;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  减震器 止推轴承  底盘件 传动轴防尘套 万向节安全套 变速箱支脚解决方案
	 */
	public void setDealJzdcwb353637383940(java.lang.String dealJzdcwb353637383940){
		this.dealJzdcwb353637383940 = dealJzdcwb353637383940;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车内灯光：1.正常 0.异常
	 */
	public java.lang.Integer getCndg41(){
		return this.cndg41;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车内灯光：1.正常 0.异常
	 */
	public void setCndg41(java.lang.Integer cndg41){
		this.cndg41 = cndg41;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车内灯光异常描述
	 */
	public java.lang.String getExCndg41(){
		return this.exCndg41;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车内灯光异常描述
	 */
	public void setExCndg41(java.lang.String exCndg41){
		this.exCndg41 = exCndg41;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车外灯光：1.正常 0.异常
	 */
	public java.lang.Integer getCwdg42(){
		return this.cwdg42;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车外灯光：1.正常 0.异常
	 */
	public void setCwdg42(java.lang.Integer cwdg42){
		this.cwdg42 = cwdg42;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车外灯光异常描述
	 */
	public java.lang.String getExCwdg42(){
		return this.exCwdg42;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车外灯光异常描述
	 */
	public void setExCwdg42(java.lang.String exCwdg42){
		this.exCwdg42 = exCwdg42;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  仪表盘故障灯：1.正常 0.异常
	 */
	public java.lang.Integer getYbpgzd43(){
		return this.ybpgzd43;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  仪表盘故障灯：1.正常 0.异常
	 */
	public void setYbpgzd43(java.lang.Integer ybpgzd43){
		this.ybpgzd43 = ybpgzd43;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仪表盘故障灯异常描述
	 */
	public java.lang.String getExYbpgzd43(){
		return this.exYbpgzd43;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仪表盘故障灯异常描述
	 */
	public void setExYbpgzd43(java.lang.String exYbpgzd43){
		this.exYbpgzd43 = exYbpgzd43;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车内灯光 车外灯光 仪表盘故障灯解决方案描述
	 */
	public java.lang.String getDealCnwybp414243(){
		return this.dealCnwybp414243;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车内灯光 车外灯光 仪表盘故障灯解决方案描述
	 */
	public void setDealCnwybp414243(java.lang.String dealCnwybp414243){
		this.dealCnwybp414243 = dealCnwybp414243;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  玻璃清洗液：1.正常 0.异常
	 */
	public java.lang.Integer getBlqxy44(){
		return this.blqxy44;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  玻璃清洗液：1.正常 0.异常
	 */
	public void setBlqxy44(java.lang.Integer blqxy44){
		this.blqxy44 = blqxy44;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复检结果
	 */
	public java.lang.String getRecheck(){
		return this.recheck;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复检结果
	 */
	public void setRecheck(java.lang.String recheck){
		this.recheck = recheck;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  建议维修项目
	 */
	public java.lang.String getSuggest(){
		return this.suggest;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  建议维修项目
	 */
	public void setSuggest(java.lang.String suggest){
		this.suggest = suggest;
	}
}

