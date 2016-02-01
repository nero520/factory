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
			<h3>活动信息</h3>
			<table style="width:50%;">
				<tr>
					<td align="right" width="150">活动编号：</td>
					<td><input name="activitySn" value="${activity.activitySn }"
						vtype="rangeLength:1,50" style="width: 200px;"  class="mini-textbox" emptyText="活动编号自动生成" readonly="readonly"/></td>
				</tr>
				<tr>
					<td align="right">活动名称：</td>
					<td><input name="activityName" value="${activity.activityName }"
						required="true" vtype="rangeLength:1,50" style="width: 200px;"  class="mini-textbox" emptyText="请填写活动名称" /></td>
				</tr>
				<tr>
					<td align="right">开始日期：</td>
					<td><input name="startDate" value="${activity.startDate }" maxDate="mini.get('endDate').getValue()"
						required="true" format="yyyy-MM-dd" showTime="true" style="width: 200px;"  class="mini-datepicker" emptyText="请填写开始日期" /></td>
				</tr>
				<tr>
					<td align="right">结束日期：</td>
					<td><input name="endDate" value="${activity.endDate }" minDate="mini.get('startDate').getValue()"
						required="true" format="yyyy-MM-dd" showTime="true" style="width: 200px;"  class="mini-datepicker" emptyText="请填写结束日期" /></td>
				</tr>
				<tr>
					<td align="right">活动说明：</td>
					<td><input name="description" value="${activity.description }"
						vtype="rangeLength:1,200" style="height:100; width: 300px;" class="mini-textArea" emptyText="请填写活动说明,最多200字" /></td>
				</tr>
			</table>
			<h3>活动范围</h3>
			<table style="width:50%;">
				<tr>
					<td align="right" width="150">参与门店：</td>
					<td>
						<div id="activityScope" name="activityScope"  class="mini-combobox" style="width:200px;"  popupWidth="160" textField="name" valueField="id" 
					    url="<%=ctx%>/company/dataList.action" value="${activity.activityScope }" multiSelect="true"  showClose="true" oncloseclick="onCloseClick" emptyText="全部" >     
						    <div property="columns">
						        <div header="全部" field="name"></div>
						    </div>
						</div>
					</td>
				</tr>
				<tr>
					<td style="text-align:center;padding-top:30px;padding-right:20px;"colspan="3">
					<a class="mini-button" onclick="updateRow()">下一步，设置活动内容</a> 
					<a class="mini-button" onclick="cancelRow()">取消</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/activityNew/activityNew_edit.js"></script>
</html>