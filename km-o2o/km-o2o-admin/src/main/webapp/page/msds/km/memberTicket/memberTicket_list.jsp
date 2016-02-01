<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form" class="divClass">
		<table style="width:100%;">
			<tr>
				<td style="width:120px;text-align:right;">优惠码：</td>
	            <td>
	            	<input name="promotionCode" class="mini-textbox" style="width:150px;" />
	            </td>  
				<td style="width:120px;text-align:right;">类型：</td>
				<td><input name="privilegeType"
					class="mini-combobox" style="width: 125px;" value=""
					data="couponTypeSelect" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align:right;">活动名称：</td>
	            <td>
	            	<input name="activityName" class="mini-textbox" style="width:150px;" />
	            </td>  
				<td style="text-align:right;">有效期：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" maxDate="mini.get('afterDate').getValue()">－
					<input id="afterDate" name="afterDate" class="mini-datepicker" minDate="mini.get('beforeDate').getValue()">
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center;padding-top: 15px;">
				<a class="mini-button" onclick="resetSearch('#form')" style="width:60px">重 置</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="mini-button" onclick="search()" style="width:60px">查 询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>	
	<div class="mini-fit">
		<div id="datagrid_memberTicket" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/memberTicket/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="asc"
			allowCellWrap="true" allowHeaderWrap="false" multiSelect="true">
			<div property="columns">
				<div field="promotionCode" headerAlign="center" allowSort="true">优惠码</div>
				<div field="couponName" headerAlign="center" allowSort="true">优惠券名称</div>
				<div field="activityName" headerAlign="center" allowSort="true">活动名称</div>
				<div field="privilegeTypeName" headerAlign="center" allowSort="true" width="50">活动类型</div>
				<div field="createDate" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true" width="70">领用日期</div>
				<div field="expirationTime" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true" width="70">过期日期</div>
				<div field="stateName" headerAlign="center" allowSort="true" width="50">状态</div>
				<div field="phone" headerAlign="center" allowSort="true" width="70">手机号</div>
				<div field="license" headerAlign="center" allowSort="true" width="70">车牌号</div>
				<div field="carType" headerAlign="center" allowSort="true">车型</div>
				<div name="action" headerAlign="center" width="50">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/memberTicket/memberTicket_list.js"></script>
</html>