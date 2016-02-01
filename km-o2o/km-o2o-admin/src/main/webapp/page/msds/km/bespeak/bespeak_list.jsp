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
    			<td style="text-align:right;">预约单号：</td>
				<td><input id="bespeakSn" name="bespeakSn" class="mini-textbox"></td>
				<td style="text-align:right;">预约时间：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" maxDate="mini.get('afterDate').getValue()">－
					<input id="afterDate" name="afterDate" class="mini-datepicker" minDate="mini.get('beforeDate').getValue()">
				</td>
			</tr>
			<tr>		
    			<td style="text-align:right;">服务项目：</td>
				<td><input id="serviceContent" name="serviceContent" class="mini-textbox"></td>
				<td style="text-align:right;">预约方式：</td>
				<td>
					<input id="bespeakType"  class="mini-combobox" style="width:70px;"  
                        data="[{ id: '', text: '全部' },{ id: '1', text: '顾问咨询' }, { id: '2', text: '在线预约'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" />
				</td>
			</tr>
			<tr>		
    			<td style="text-align:right;">预约状态：</td>
				<td>
					<input id="state"  class="mini-combobox" style="width:70px;"  
                        data="[{ id: '', text: '全部' },{ id: '1', text: '待确认' }, { id: '2', text: '已确认'}, { id: '3', text: '已取消'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" />
                </td>
				<td ></td>
				<td></td>
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
	<div class="mini-fit">
		<div id="datagrid_bespeak" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/bespeak/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			allowCellWrap="false" allowHeaderWrap="false"  multiSelect="true">
			<div property="columns">
				<div field="bespeakSn" headerAlign="center" allowSort="true" width="55">预约单号</div>
				<div field="bespeakDate" dateFormat="yyyy-MM-dd" headerAlign="center" width="60">预约时间</div>
				<div field="bespeakType" headerAlign="center" renderer="onTypeRenderer"  width="30">预约方式</div>
				<div field="state" headerAlign="center" renderer="onGenderRenderer" width="30">状态</div>
				<div field="serviceContent" headerAlign="center"  width="30">服务项目</div>
				<div field="totalPrice" headerAlign="center" dataType="currency" width="40">总价</div>
				<div field="mileage" headerAlign="center" width="40">行驶里程(KM)</div>
				<div field="phone" headerAlign="center" width="40">车主手机号</div>
				<div field="action"  headerAlign="center">操作</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/bespeak/bespeak_list.js"></script>
</html>