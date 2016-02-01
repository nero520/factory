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
			<input class="mini-hidden" name="vin" id="vin" value="${aintenance.vin }"/>
			<div style="background-color: #ffffff;font-size: 18; height: 30px">基本信息</div>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="text-align:right;" width="20%">VIN码：</td>
					<td width="30%">${aintenance.vin }</td>
					<td style="text-align:right;" width="20%">报告时间：</td>
					<td width="30%"><fmt:formatDate value="${aintenance.reportTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td style="text-align:right;">品牌：</td>
					<td>${aintenance.brand }</td>
					<td style="text-align:right;">车型：</td>
					<td>${aintenance.model }</td>
				</tr>
				<tr>
					<td style="text-align:right;">生产商：</td>
					<td>${aintenance.producer }</td>
					<td style="text-align:right;">变速器：</td>
					<td>${aintenance.transmission }</td>
				</tr>
				<tr>
					<td style="text-align:right;">排气量：</td>
					<td>${aintenance.displacement }</td>
					<td style="text-align:right;"></td>
					<td></td>
				</tr>
			</table>
			<div style="background-color: #ffffff;font-size: 18;height: 30px">报告概要</div>
			<table style="width:100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="text-align:right;" width="20%">结构部件：</td>
					<td width="30%">${aintenance.structure }</td>
					<td style="text-align:right;" width="20%">维修次数：</td>
					<td width="30%">${aintenance.maintenanceTimes }&nbsp;次</td>
				</tr>
				<tr>
					<td style="text-align:right;">安全气囊：</td>
					<td>${aintenance.srs }</td>
					<td style="text-align:right;">维保周期：</td>
					<td>${aintenance.maintenancePeriod }&nbsp;次/年</td>
				</tr>
				<tr>
					<td style="text-align:right;">召回记录：</td>
					<td>${aintenance.recallRecord }</td>
					<td style="text-align:right;">最大量程数：</td>
					<td>${aintenance.maxRange }&nbsp;公里</td>
				</tr>
			</table>
		</div>
		<div style="background-color: #ffffff;font-size: 18;height: 30px">详细报告</div>
		<div class="mini-fit">
			<div id="datagrid_maintenanceHistory_detail" class="mini-datagrid"
				style="width:100%;height:100%;" borderStyle="border:0;"
				url="${ctx}/maintenanceHistory/detailDataList.action" idField="id"
				allowAlternating="true" sortField="id" sortOrder="asc"
				allowCellWrap="true" allowHeaderWrap="false" multiSelect="true">
				<div property="columns">
					<div field="maintenanceDate" headerAlign="center" align="center" dateFormat="yyyy-MM-dd">日期</div>
					<div field="mileage" headerAlign="center" align="center">公里数</div>
					<div field="type" headerAlign="center" align="center">类型</div>
					<div field="maintenanceContent" headerAlign="center" align="center">维修内容</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/maintenanceHistory/maintenanceHistory_view.js"></script>
</html>