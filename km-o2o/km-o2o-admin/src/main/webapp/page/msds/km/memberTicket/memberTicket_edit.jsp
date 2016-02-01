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
					<td>优惠码：</td>
					<td><input name="promotionCode" 
						required="true" vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写优惠码" /></td>
				</tr>
				<tr>
					<td>优惠券名称：</td>
					<td><input name="couponName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写优惠券名称" /></td>
				</tr>
				<tr>
					<td>优惠券编号：</td>
					<td><input name="couponSn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写优惠券编号" /></td>
				</tr>
				<tr>
					<td>活动的SN：</td>
					<td><input name="activitySn" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写活动的SN" /></td>
				</tr>
				<tr>
					<td>活动名称：</td>
					<td><input name="activityName" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写活动名称" /></td>
				</tr>
				<tr>
					<td>活动类型：</td>
					<td><input name="privilegeType" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写活动类型" /></td>
				</tr>
				<tr>
					<td>过期时间：</td>
					<td><input name="expirationTime" 
						 format="yyyy-MM-dd HH:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写过期时间" /></td>
				</tr>
				<tr>
					<td>0：未使用1：使用：</td>
					<td><input name="state" 
						 allowLimitValue="false" style="width: 160px;"  class="mini-spinner" emptyText="请填写0：未使用1：使用" /></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input name="phone" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写手机号" /></td>
				</tr>
				<tr>
					<td>车牌号：</td>
					<td><input name="license" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车牌号" /></td>
				</tr>
				<tr>
					<td>车型：</td>
					<td><input name="carType" 
						 vtype="rangeLength:1,50" style="width: 160px;"  class="mini-textbox" emptyText="请填写车型" /></td>
				</tr>
				<tr>
					<td>创建优惠信息的时间：</td>
					<td><input name="createTime" 
						required="true" format="yyyy-MM-dd HH:mm:ss" timeFormat="H:mm:ss" showTime="true" style="width: 160px;"  class="mini-datepicker" emptyText="请填写创建优惠信息的时间" /></td>
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
<script type="text/javascript" src="<%=ctx%>/page/msds/km/memberTicket/memberTicket_edit.js"></script>
</html>