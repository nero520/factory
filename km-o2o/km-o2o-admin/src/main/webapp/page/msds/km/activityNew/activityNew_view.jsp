<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit">
		<div id="viewform" class="divClass">
			<input class="mini-hidden" name="id" value="${activity.id }"/>
			<input class="mini-hidden" id="activitySn" name="activitySn" value="${activity.activitySn }" />
			<div style="margin-left: 100px"><h3>活动编号：${activity.activitySn }</h3></div>
			<h3>活动内容</h3>
			<table style="width:50%;">
				<tr>
					<td align="right" width="150">活动名称：</td>
					<td>${activity.activityName }</td>
				</tr>
				<tr>
					<td align="right">开始日期：</td>
					<td><fmt:formatDate value="${activity.startDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right">结束日期：</td>
					<td><fmt:formatDate value="${activity.endDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td align="right">活动说明：</td>
					<td>${activity.description }</td>
				</tr>
			</table>
			<h3>活动范围</h3>
			<div>参与门店：${activity.scopeName }</div>
			<h3>活动内容</h3>
			<table style="width:50%;">
				<tr>
					<td align="right" width="150">每人限量：</td>
					<td>${activity.personLimit }张</td>
				</tr>
				<tr>
					<td align="right">活动商品数量：</td>
					<td>
						${activity.limitStateName }
						&nbsp;
						${activity.activityLimitNum }张
					</td>
				</tr>
				<tr>
					<td align="right">优惠形式：</td>
					<td>${activity.typeName }</td>
				</tr>
			</table>
			<div id="datagrid_detail" class="mini-datagrid"
				style="width:100%;height:200px;" borderStyle="border:0;"
				url="${ctx}/activityNew/detailDataList.action" idField="id"
				allowAlternating="true" sortField="id" sortOrder="desc"
				onrowdblclick="rowdblclick" multiSelect="true" showPager="false">
				<div property="columns">
					<div field="couponSn" headerAlign="center" allowSort="true" align="center">优惠券编号</div>
					<div field="couponName" headerAlign="center" allowSort="true" align="center">优惠名称</div>
					<div field="typeName" headerAlign="center" allowSort="true" align="center">优惠类型</div>
					<div field="startDate" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true" align="center">开始日期</div>
					<div field="endDate" dateFormat="yyyy-MM-dd" headerAlign="center" allowSort="true" align="center">结束日期</div>
					<div field="instructions" headerAlign="center" allowSort="true" align="center">使用说明</div>
				</div>
			</div>
			<div style="text-align:center;">
				<a class="mini-button" onclick="updateRow()">创建活动</a> 
				<a class="mini-button" onclick="cancelRow()">取消</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/activityNew/activityNew_view.js"></script>
</html>