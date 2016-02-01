<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="form">
			<input class="mini-hidden" name="id" />
			<table style="width:100%;">
				<tr>
					<td>vin：</td>
					<td><input name="vin" id="vin" readonly="readonly"
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写vin" /></td>
				</tr>
				<tr>
					<td>日期：</td>
					<td><input name="maintenanceDate" 
						required="true" format="yyyy-MM-dd" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写日期" /></td>
				</tr>
				<tr>
					<td>公里数：</td>
					<td><input name="mileage" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写公里数" /></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input name="type"
						class="mini-combobox" style="width: 160px;" value=""
						required="true" data="maintenanceHistoryDetailType" /></td>
				</tr>
				<tr>
					<td>维修内容：</td>
					<td><input name="maintenanceContent" 
						required="true" vtype="rangeLength:1,800" style="height:100; width: 300px;" class="mini-textArea" emptyText="请填写维修内容,最多800字" /></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-top:5px;padding-right:20px;"
						colspan="3"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/maintenanceHistory/maintenanceHistoryDetail_edit.js"></script>
</html>