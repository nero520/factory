<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit" style="background: url('<%=ctx%>/js/miniui/themes/blue/images/toolbar/toolbar.gif') repeat-x scroll 0 0 #f0f0f0;border: 1px solid #99bce8">
		<div id="editform" class="tableClass">
			<input class="mini-hidden" name="id" id="id" value="${aintenance.id }"/>
			<div style="background-color: #ffffff;font-size: 18; height: 30px">基本信息</div>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="text-align:right;" width="20%">VIN码：</td>
					<td width="30%"><input name="vin" id="vin" value="${aintenance.vin }" 
						required="true" vtype="rangeLength:1,17" style="width: 160px;"  class="mini-textbox" emptyText="请填写VIN码" /></td>
					<td style="text-align:right;" width="20%">报告时间：</td>
					<td width="30%"><input name="reportTime" value="${aintenance.reportTime }" 
						 format="yyyy-MM-dd HH:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写报告时间" /></td>
				</tr>
				<tr>
					<td style="text-align:right;">品牌：</td>
					<td><input name="brand" value="${aintenance.brand }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写品牌" /></td>
					<td style="text-align:right;">车型：</td>
					<td><input name="model" value="${aintenance.model }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车型" /></td>
				</tr>
				<tr>
					<td style="text-align:right;">生产商：</td>
					<td><input name="producer" value="${aintenance.producer }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写生产商" /></td>
					<td style="text-align:right;">变速器：</td>
					<td><input name="transmission" value="${aintenance.transmission }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写变速器" /></td>
				</tr>
				<tr>
					<td style="text-align:right;">排气量：</td>
					<td><input name="displacement" value="${aintenance.displacement }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写排气量" /></td>
					<td style="text-align:right;"></td>
					<td></td>
				</tr>
			</table>
			<div style="background-color: #ffffff;font-size: 18;height: 30px">报告概要</div>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="text-align:right;" width="20%">结构部件：</td>
					<td width="30%"><input name="structure" value="${aintenance.structure }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写结构部件" /></td>
					<td style="text-align:right;" width="20%">维修次数：</td>
					<td width="30%"><input name="maintenanceTimes" value="${aintenance.maintenanceTimes }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写维修次数" />次</td>
				</tr>
				<tr>
					<td style="text-align:right;">安全气囊：</td>
					<td><input name="srs" value="${aintenance.srs }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写安全气囊" /></td>
					<td style="text-align:right;">维保周期：</td>
					<td><input name="maintenancePeriod" value="${aintenance.maintenancePeriod }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写维保周期" />次/年</td>
				</tr>
				<tr>
					<td style="text-align:right;">召回记录：</td>
					<td><input name="recallRecord" value="${aintenance.recallRecord }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写召回记录" /></td>
					<td style="text-align:right;">最大量程数：</td>
					<td><input name="maxRange" value="${aintenance.maxRange }" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写最大量程数" />公里</td>
				</tr>
				<tr>
					<td style="text-align:center;padding-top:5px;padding-right:20px;"
						colspan="4"><a class="mini-button"
						onclick="updateRow()">保存</a> <a class="mini-button"
						onclick="cancelRow()">取消</a></td>
				</tr>
			</table>
		</div>
		<div style="background-color: #ffffff;font-size: 18;height: 30px">详细报告</div>
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
			<div id="datagrid_maintenanceHistory_detail" class="mini-datagrid"
				style="width:100%;height:100%;" borderStyle="border:0;"
				url="${ctx}/maintenanceHistory/detailDataList.action" idField="id"
				allowAlternating="true" sortField="id" sortOrder="asc"
				allowCellWrap="true" allowHeaderWrap="false" multiSelect="true">
				<div property="columns">
					<div type="checkcolumn"></div>
					<div field="maintenanceDate" headerAlign="center" align="center" dateFormat="yyyy-MM-dd">日期</div>
					<div field="mileage" headerAlign="center" align="center">公里数</div>
					<div field="type" headerAlign="center" align="center">类型</div>
					<div field="maintenanceContent" headerAlign="center" align="center">维修内容</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/maintenanceHistory/maintenanceHistory_edit.js"></script>
</html>