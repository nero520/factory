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
				<td style="width:120px;text-align:right;">活动名称：</td>
	            <td>
	            	<input name="activityName" class="mini-textbox" style="width:150px;" />
	            </td>  
				<td style="width:120px;text-align:right;">优惠形式：</td>
				<td><input id="type" name="type"
					class="mini-combobox" style="width: 125px;" value=""
					data="activityNewTypeSelect" /></td>
				<td style="width:120px;text-align:right;">活动状态：</td>
				<td><input id="state" name="state"
					class="mini-combobox" style="width: 125px;" value=""
					data="[{'id':'','text':'全部'},{'id':'-1','text':'未开始'},{'id':'3','text':'暂停'},{'id':'1','text':'进行中'},{'id':'2','text':'已结束'}]" /></td>
			</tr>
			<tr>
				<td style="width:120px;text-align:right;">活动编号：</td>
	            <td>
	            	<input name="activitySn" class="mini-textbox" style="width:150px;" />
	            </td>  
				<td style="text-align:right;">活动时间：</td>
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
		<div id="datagrid_activityNew" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/activityNew/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="asc"
			allowCellWrap="true" allowHeaderWrap="false" multiSelect="true">
			<div property="columns">
				<div type="checkcolumn"></div>
				<div field="activitySn" headerAlign="center" allowSort="true">活动编号</div>
				<div field="activityName" headerAlign="center" allowSort="true">活动名称</div>
				<div field="typeName" headerAlign="center" allowSort="true">活动类型</div>
				<div field="startDate" dateFormat="yyyy-MM-dd"  headerAlign="center" allowSort="true">开始日期</div>
				<div field="endDate" dateFormat="yyyy-MM-dd"  headerAlign="center" allowSort="true">结束日期</div>
				<div field="description" headerAlign="center" allowSort="true">活动说明</div>
				<div field="stateName" headerAlign="center" allowSort="true" cellStyle="color: red;">活动状态</div>
				<div name="action" headerAlign="center">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/activityNew/activityNew_list.js"></script>
</html>