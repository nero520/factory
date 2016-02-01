<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.util.Random"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/js/uploadify3.1/uploadify.css">
<script type="text/javascript" src="${ctx}/js/uploadify3.1/jquery.uploadify.min.js?ver=<%=new Random().nextDouble() %>>"></script>
</head>
<body>
	<div class="mini-toolbar"
		style="padding:2px;border-top:0;border-left:0;border-right:0;">
		<form id="form" class="divClass">
		<table style="width:100%;">
			<tr>		
    			<td style="text-align:right;">车牌号：</td>
				<td><input id="license" name="license" class="mini-textbox"></td>
				<td style="text-align:right;">结算日期：</td>
				<td>
					<input id="beforeDate" name="beforeDate" class="mini-datepicker" >－
					<input id="afterDate" name="afterDate" class="mini-datepicker" >
				</td>
			</tr>
			<tr>		
    			<td style="text-align:right;">结算方式：</td>
				<td><input id="settleType"  class="mini-combobox" style="width:70px;"  
                        data="[{ id: '', text: '全部' },{ id: '刷卡', text: '刷卡' }, { id: '现金', text: '现金'}, { id: '挂账', text: '挂账'}, { id: '汇款', text: '汇款'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" /></td>
				<td style="text-align:right;">维修方式：</td>
				<td>
					<input id="repairType"  class="mini-combobox" style="width:70px;"          
                        data="[{ id: '', text: '全部' },{ id: '事故', text: '事故' }, { id: '保养', text: '保养'}, { id: '美容', text: '美容'}, 
                        { id: '维修', text: '维修'}, { id: '大修', text: '大修'}, { id: '小修', text: '小修'}, { id: '钣喷', text: '钣喷'}, 
                        { id: '洗车', text: '洗车'}, { id: '装潢', text: '装潢'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" />
				</td>
			</tr>
			<tr>		
    			<td style="text-align:right;">会员卡号：</td>
				<td>
					<input id="cardNo" name="cardNo" class="mini-textbox">
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
		 <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">
	         	<table style="width:100%;" class="divClass">
	                <tr>
	                   <td  style="width:170px;" >
							<input name="file_path" id="file_path" class="mini-hidden"  />
							<input name="upload_file" id="upload_file" type="file" style="white-space:nowrap;"   />
							 
						</td>
						<td  >
							
							<a class="mini-button" id="importButton" onclick="importData()" style="width:60px"   > 导 入</a>
							 
						</td>
	                </tr>
	            </table>   
        </div>
	</div>
	
	<div class="mini-fit">
		<div id="datagrid_repair_list" class="mini-datagrid"
			style="width:100%;height:100%;" borderStyle="border:0;"
			url="${ctx}/repairList/dataList.action" idField="id"
			allowAlternating="true" sortField="id" sortOrder="desc"
			allowCellWrap="false" allowHeaderWrap="false"  multiSelect="true">
			<div property="columns">
				<div field="repairNo" headerAlign="center" allowSort="true" width="60">维修单号</div>
				<div field="repairType"  headerAlign="center" width="30">维修方式</div>
				<div field="memberName" headerAlign="center" renderer="onTypeRenderer"  width="30">送修人</div>
				<div field="memberPhone" headerAlign="center" renderer="onGenderRenderer" width="40">送修人电话</div>
				<div field="settleDate" headerAlign="center" dateFormat="yyyy-MM-dd"  width="30">结算日期</div>
				<div field="settleType" headerAlign="center"  width="30">结算方式</div>
				<div field="settleAmount" headerAlign="center" width="30">消费金额</div>
				<div field="vin" headerAlign="center" width="60">VIN</div>
				<div field="mileage" headerAlign="center" width="35">行驶里程(KM)</div>
				<div field="cardNo" headerAlign="center" width="35">会员卡号</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=ctx%>/page/msds/km/repair/repair_list.js"></script>
</html>