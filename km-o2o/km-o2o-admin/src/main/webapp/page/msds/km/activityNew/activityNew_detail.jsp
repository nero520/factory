<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit">
		<div id="editform" class="divClass">
			<input class="mini-hidden" name="id" value="${activity.id }"/>
			<input class="mini-hidden" name="activitySn" value="${activity.activitySn }" />
			<input class="mini-hidden" name="couponSns" id="couponSns" value="${activity.couponSns }" />
			<h3>活动内容</h3>
			<table style="width:50%;">
				<tr>
					<td align="right">每人限量：</td>
					<td><input name="personLimit" value="${activity.personLimit }"
						required="true" allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写每人限量" /></td>
				</tr>
				<tr>
					<td align="right">活动商品数量：</td>
					<td>
						<input name="activityLimitState" id="activityLimitState" required="true" value="${activity.activityLimitState }" 
						class="mini-combobox" style="width: 50px;" data="activityLimitState" />
						<input name="activityLimitNum" required="true" value="${activity.activityLimitNum }" 
						allowLimitValue="false" style="width: 106px;"  class="mini-spinner" emptyText="请填写活动限量数量" />
					</td>
				</tr>
				<tr>
					<td align="right">优惠形式：</td>
					<td><input id="type" name="type" value="${activity.type }"
						class="mini-combobox" style="width: 160px;"
						required="true" data="activityNewType" onvaluechanged="queryCoupon()"/></td>
				</tr>
			</table>
			<h3>选择商品</h3>
			<div id="datagrid_coupon" class="mini-datagrid"
				style="width:100%;height:200px;" borderStyle="border:0;"
				url="${ctx}/coupon/dataList.action" idField="id"
				allowAlternating="true" sortField="id" sortOrder="desc"
				onrowdblclick="rowdblclick" multiSelect="true" showPager="false">
				<div property="columns">
					<div type="checkcolumn"></div>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/activityNew/activityNew_detail.js"></script>
</html>