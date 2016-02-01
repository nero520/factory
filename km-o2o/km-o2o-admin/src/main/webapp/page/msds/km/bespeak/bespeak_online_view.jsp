<%@page import="com.msds.km.entity.BespeakEntity"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body>
	<div class="mini-fit" >
		<div id="editform" class="form">
			<input name="id" class="mini-hidden" value="${bespeak.id }"/>
			<input name="memberId" class="mini-hidden" value="${bespeak.memberId }"/>
			<input name="memberModelId" class="mini-hidden" value="${bespeak.memberModelId }"/>
			<input name="bespeakSn" class="mini-hidden" value="${bespeak.bespeakSn }"/>
			<table>
				<tr>
					<td style="width:300px;"><h5>预约单号：${bespeak.bespeakSn }</h5></td>
					<td><h5>创建时间：<fmt:formatDate value="${bespeak.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/> </h5></td>
				</tr>
				<tr>
					<td style="width:300px;"><h5>预约状态：<%= EnumUtil.getEnumName(Integer.valueOf(((BespeakEntity)request.getAttribute("bespeak")).getState()),"BespeakStateEnum") %></h5></td>
					<td><h5>预约方式：<c:choose>  
	                        <c:when test="${bespeak.bespeakType == 1 }">  
	                          顾问咨询
	                        </c:when>  
	                        <c:when test="${bespeak.bespeakType == 2 }">  
	                          在线预约
	                        </c:when>  
	                    </c:choose> </h5></td>
				</tr>
			</table>
	        <h3 class="dotBorderTop">服务信息</h3>
	        <div class="divClass">
	            <table style="width:100%" border="0" cellpadding="1" cellspacing="2">
	                
	                <c:choose>  
	                        <c:when test="${bespeak.bespeakType == 1 }">  
	                         <tr>
			                    <td style="text-align:right;width:150px;">车主问题描述：</td>
			                    <td colspan="3">${bespeak.problem }</td>  
			                </tr>
			                <tr>
			                	<td style="text-align:right;">初步方案：</td>
			                    <td colspan="3">${bespeak.answer }</td>  
			                </tr>
	                        </c:when>  
	                    </c:choose>
	                
	                 <tr>
	                	<td style="text-align:right;">服务项目：</td>
	                    <td colspan="3">${bespeak.serviceContent }</td>  
	                </tr>
	                <tr>
						<td style="text-align:right;width:150px;">总价(￥)：</td>
						<td>${bespeak.totalPrice }</td>
					</tr> 
	            </table>
	        </div>
	        <h3 class="dotBorderTop">预约信息</h3>
	        <div class="divClass">
	            <table style="width:100%" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td style="text-align:right;width:150px;">预约时间：</td>
						<td style="text-align:left;width:750px;"><input id="date2"  name="bespeakDate" class="mini-datepicker"  style="width:150px;"
					format="yyyy-MM-dd" minDate="${bespeak.startDate }"  required="true" showTodayButton="false"
					showOkButton = "true"
					value="${bespeak.bespeakDate }"/>
					 <input id="isAm"  class="mini-combobox" style="width:70px;"  required="true"
                        data="[{ id: '1', text: '上午' }, { id: '0', text: '下午'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" value="${bespeak.isAm }"/></td>
                        <td></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align:right;width:150px;">修理厂：</td>
						<td colspan="3"><input id="companyId" class="mini-combobox" style="width:150px;" textField="name" valueField="id"  value="${bespeak.companyId }"
					 url="${ctx}/bespeak/getCompanyList.action"  required="true" onvaluechanged="companyChange"
				        showNullItem="true"
				         /> &nbsp;&nbsp;&nbsp;&nbsp;<span id="companyMes">${bespeak.companyAddress }，联系电话:${bespeak.companyTel }</span> 
					</td>
					
					</tr>
					<tr>
						<td style="text-align:right;width:150px;">备注：</td>
						<td colspan="3">${bespeak.remark }</td>
					</tr>
	            </table>
	        </div>
	        <h3 class="dotBorderTop">用户信息</h3>
	        <div class="divClass">
	            <table style="width:100%" border="0" cellpadding="1" cellspacing="2">
					<tr>
						<td style="text-align:right;width:150px;">手机号码：</td>
						<td style="width:150px;">${bespeak.phone }</td>
						<td style="text-align:right;width:150px;">姓名（称呼）：</td>
						<td>${bespeak.name }</td>
					</tr>
					<tr>
						<td style="text-align:right;width:150px;">用户地址：</td>
						<td style="width:150px;">${bespeak.fullAddress }</td>
						<td style="text-align:right;width:150px;"></td>
						<td></td>
					</tr>
	            </table>
	        </div>
	        <h3 class="dotBorderTop">车辆信息</h3>
	        <div class="divClass">
	            <table style="width:100%" border="0" cellpadding="1" cellspacing="2">
	            
	            	<tr>
						<td style="text-align:right;width:150px;">车辆性别：</td>
						<td style="width:150px;"><%= EnumUtil.getEnumName(((BespeakEntity)request.getAttribute("bespeak")).getCarSex(),"CarSexEnum") %></td>
						<td style="text-align:right;width:150px;">车辆性格：</td>
						<td><%= EnumUtil.getEnumName(((BespeakEntity)request.getAttribute("bespeak")).getCarRole(),"CarRoleEnum") %></td>
					</tr>
	            	
					<tr>
						
						<td style="text-align:right;width:150px;">车型：</td>
						<td>${bespeak.modelGroupName }</td>
						<td style="text-align:right;width:150px;">购车日期：</td>
						<td><fmt:formatDate value="${bespeak.buyDate }" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td style="text-align:right;width:150px;">行驶里程(KM)：</td>
						<td style="width:150px;">${bespeak.mileage }</td>
						<td style="text-align:right;width:150px;">上次保养日期：</td>
						<td><fmt:formatDate value="${bespeak.lastServiceDate }" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td style="text-align:right;width:150px;">车牌号码：</td>
						<td style="width:150px;">${bespeak.license }</td>
						<td style="text-align:right;width:150px;"></td>
						<td></td>
					</tr>
					<tr> 
						<td colspan="3" style="text-align:right;">
							<a class="mini-button" onclick="updateBespeak()">保存</a>
						</td>
	                </tr> 
	            </table>
	        </div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/bespeak/bespeak_view.js"></script>
</html>