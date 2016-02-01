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
				<td style="width:120px;text-align:right;">车辆识别码：</td>
	            <td>
	            	<input name="vin" class="mini-textbox" style="width:150px;" />
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
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<table style="width:100%;">
			<tr>
				<td style="width:100%;">
					<a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
					<a class="mini-button" iconCls="icon-edit" onclick="edit()">修改</a>
					<a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
				</td>
			</tr>
		</table>
	</div>
	<div class="mini-fit">
		<div id="datagrid_maintenanceHistory" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/maintenanceHistory/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="asc"
			allowCellWrap="true" allowHeaderWrap="false" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
				<div field="vin" headerAlign="center" allowSort="true">VIN码</div>
				<div field="brand" headerAlign="center" allowSort="true">品牌</div>
				<div field="model" headerAlign="center" allowSort="true">车型</div>
				<div field="reportTime" dateFormat="yyyy-MM-dd HH:mm:ss"  headerAlign="center" allowSort="true">报告时间</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/maintenanceHistory/maintenanceHistory_list.js"></script>
</html>