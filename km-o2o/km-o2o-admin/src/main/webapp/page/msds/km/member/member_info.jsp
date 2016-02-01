<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
<%@page import="com.msds.km.entity.MemberEntity"%>
</head>
<body style="background-color: #FCFCFC">
	<div  style="width:100%;height:80px;" class="mini-fit">
	<div id="editform" class="form" >
		<input name="id" class="mini-hidden" value="${member.id }"/>
        <input name="memberModelId" class="mini-hidden" value="${member.memberModelId }"/>
		<h3>基础信息</h3>
        <div class="divClass">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;" >手机号码：</td>
                    <td colspan="3" >
                        ${member.phone }
                    </td>  
                </tr>
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;">姓名(称呼)：</td>
                    <td colspan="3" >
                    ${member.name }${empty member.sex ? '先生' : '女士'}
                    </td>  
                </tr>
                
                <tr>
                	<td class="form-label" style="width:120px;text-align:right;">用户地址：</td>
                    <td colspan="3" >
                      ${member.fullAddress}
                    </td>  
                </tr>
                
            </table>
        </div>
    
        <h3 class="dotBorderTop">车辆信息</h3>
        <div class="divClass">
            <table class="form-table" border="0" cellpadding="0" cellspacing="2">
               
               
      			<tr>
                    <td class="form-label" style="text-align:right;font-size:12px; " >车辆性别：</td>
                   <td class="form-label" style="width:600px;" >
                    <%= EnumUtil.getEnumName(((MemberEntity)request.getAttribute("member")).getCarSex(),"CarSexEnum") %> 
					 </td>
                   
                </tr>
                <tr>
                   
                    <td class="form-label" style="text-align:right;font-size:12px; " >车辆性格：</td>
                    <td class="form-label" style="width:600px;" >
                    <%= EnumUtil.getEnumName(((MemberEntity)request.getAttribute("member")).getCarRole(),"CarRoleEnum") %>   
					 </td>
                </tr>
                <tr>
                    <td class="form-label" style="width:120px;text-align:right;font-size:12px; ">车型：</td>
                    <td colspan="2">
                     ${member.modelGroupName }
                    </td>
                  
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; " >购车日期：</td>
                    <td class="form-label" style="width:150px;">
                      <input id="lastServiceDate"  name="lastServiceDate" class="mini-datepicker" format="yyyy-MM-dd" maxDate="${now }" value= "${member.buyDate }" enabled="false"/>
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">当前里程数：</td>
                    <td >
                   ${member.mileage }
                    </td>
                </tr>
                
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">上次保养时间：</td>
                    <td >
                      <input id="lastServiceDate"  name="lastServiceDate" class="mini-datepicker" format="yyyy-MM-dd" maxDate="${now }" value= "${member.lastServiceDate }" enabled="false"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align:right;font-size:12px; ">VIN码：</td>
                    <td >
                      ${member.vin }
                    </td>
                </tr>
                
            </table>
        </div>
    
    	<h3 class="dotBorderTop" >历史保养记录</h3>
			<div id="datagrid_member" class="mini-datagrid"
				width="100%" height="40%" borderStyle="border:0;"
				url="${ctx}/maintenanceHistory/detailDataList.action?vin=${member.vin}" idField="id"
				allowAlternating="true" sortField="id" sortOrder="desc" multiSelect="true" >
				<div property="columns">
						<div field="maintenanceDate" dateFormat="yyyy-MM-dd"  headerAlign="center" allowSort="true">报告日期</div>
						<div field="mileage" headerAlign="center" allowSort="true">公里数</div>
						<div field="type" headerAlign="center" allowSort="true">类型</div>
						<div field="maintenanceContent" allowSort="true">内容</div>
				</div>
			</div>
	</div>
	</div>
</div>

<style>
.dotBorderTop{
border-top:1px dotted #000;
}
</style>


</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/member/member_edit.js"></script>
<script type="text/javascript">
	mini.parse();
	var grid_item = mini.get("datagrid_member");
	var params = {"id":"${member.id}"};
	grid_item.load(params);
	
	
	
</script>
</html>