<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
</head>
<body>
	<div class="mini-fit">
		<div id="editform" class="divClass">
			<input class="mini-hidden" name="id" />
			<table style="width:50%;">
				<tr>
					<td align="right">优惠券编号：</td>
					<td><input name="couponSn" value="${coupon.couponSn }"
						style="width: 200px;" class="mini-textbox" emptyText="编号自动生成" readOnly/></td>
				</tr>
				<tr>
					<td align="right">优惠名称：</td>
					<td><input name="couponName" value="${coupon.couponName }"
						required="true" vtype="rangeLength:1,10" style="width: 200px;"  class="mini-textbox" emptyText="请填写优惠名称" /></td>
				</tr>
				<tr>
					<td align="right">优惠类型：</td>
					<td>
						<input name="type" class="mini-combobox" style="width: 200px;" value="1" data="couponType" /></td>
				</tr>
				<tr>
					<td align="right">开始日期：</td>
					<td><input id="startDate" name="startDate" value="${coupon.startDate }" maxDate="mini.get('endDate').getValue()"
						required="true" format="yyyy-MM-dd" showTime="true" style="width: 200px;"  class="mini-datepicker" emptyText="请填写开始日期" /></td>
				</tr>
				<tr>
					<td align="right">结束日期：</td>
					<td><input id="endDate" name="endDate" value="${coupon.endDate }" minDate="mini.get('startDate').getValue()"
						required="true" format="yyyy-MM-dd" showTime="true" style="width: 200px;"  class="mini-datepicker" emptyText="请填写结束日期" /></td>
				</tr>
				<tr>
					<td align="right">使用说明：</td>
					<td><input name="instructions" value="${coupon.instructions }"
						vtype="rangeLength:1,500" style="height:100; width: 300px;" class="mini-textArea" emptyText="请填写使用说明,最多500字" /></td>
				</tr>
				<tr>
					<td style="text-align:center;padding-top:5px;"colspan="3">
						<a class="mini-button" onclick="updateRow()">保存</a> 
						<a class="mini-button" onclick="cancelRow()">取消</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/coupon/coupon_edit.js"></script>
</html>