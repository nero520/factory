<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<head>
<%@include file="/page/msds/common/commonjs.jsp"%>
</head>
<body>
	
	<div class="mini-fit" >
		<div id="editform" class="form">
		<input name="id" class="mini-hidden" value="${bespeak.id }"/>
		<input name="memberId" class="mini-hidden" value="${bespeak.memberId }"/>
		<input name="memberModelId" class="mini-hidden" value="${bespeak.memberModelId }"/>
		<input name="bespeakSn" class="mini-hidden" value="${bespeak.bespeakSn }"/>
	<h4>预约单号：${bespeak.bespeakSn }</h4>
        <h3 class="dotBorderTop">问题记录</h3>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
                <tr>
                    <td class="form-label"  style="width:120px;text-align:right;font-size:12px;"><font style="color:Red;">*</font>车主问题描述：</td>
                    <td  >
                        <input name="problem" class="mini-textarea" style="width:643px;height:60px;" vtype="maxLength:1024" required="true" value="${bespeak.problem }" />
                    </td>  
                    
                </tr>
                <tr>
                	<td class="form-label"  style="width:120px;text-align:right;font-size:12px;"><font style="color:Red;">*</font>初步方案：</td>
                    <td  >
                        <input name="answer" class="mini-textarea" style="width:643px;height:60px;" vtype="maxLength:1024" required="true" value="${bespeak.answer }"/>
                    </td>  
                </tr>
                <tr>
                	<td class="form-label"  style="width:120px;text-align:right;font-size:12px;"><font style="color:Red;">*</font>服务项目：</td>
                    <td  >
                        <input name="serviceContent" class="mini-textarea" style="width:643px;height:60px;" vtype="maxLength:1024" required="true" value="${bespeak.serviceContent }"/>
                    </td>  
                </tr>
                <tr>
					
						
					<td s style="width:120px;text-align:right;font-size:12px;">总价：</td>
					<td ><input name="totalPrice" class="mini-textbox" vtype="range:0,999999"
						style="width: 20%;" value="${bespeak.totalPrice }" emptyText="元"/></td>
						
				</tr> 
            </table>
        </div>
   
        <h3 class="dotBorderTop">预约信息</h3>
        <div class="fieldset-body">
            <table class="form-table" border="0" cellpadding="1" cellspacing="2">
				
				<tr>
					<td style="width:120px;text-align:right;font-size:12px;"><font style="color:Red;">*</font>预约时间：</td>
					<td><input id="date2"  name="bespeakDate" class="mini-datepicker"  style="width:130px;"
					format="yyyy-MM-dd"  minDate="${bespeak.startDate }"  required="true" showTodayButton="false"
					showOkButton = "true"
					value="${bespeak.bespeakDate }"/> 
                        <input id="isAm"  class="mini-combobox" style="width:70px;"  required="true"
                        data="[{ id: '1', text: '上午' }, { id: '0', text: '下午'}]"  showNullItem="false"  
                        allowInput="false" textField="text" valueField="id" value="${bespeak.isAm }"/>
                        </td>
					<td style="width:120px;text-align:right;font-size:12px;"><font style="color:Red;">*</font>修理厂：</td>
					<td><input id="companyId" class="mini-combobox" style="width:150px;" textField="name" valueField="id"  value="${bespeak.companyId }"
					 url="${ctx}/bespeak/getCompanyList.action"  required="true"
				        showNullItem="true"
				         />   
					</td>
				</tr>
				<tr>
				<td style="text-align:right;padding-top:5px;padding-right:20px;"
						colspan="3">
						<c:choose>  
	                        <c:when test="${bespeak.isEdit == true }">  
	                            <a class="mini-button" onclick="updateRow()">提交预约订单</a>
	                        </c:when>  
	                    </c:choose> 
						
						</td>
                </tr>
            </table>
            
        </div>

	
	</div>
	</div>


    <script>
   		 mini.parse();
	    
	</script>
	
	<style>
	    .icr, .dcr {
	        display: inline-block;
	        font-size: 24px;
	        font-weight: bold;
	        padding: 5px;
	        margin: 5px;
	        cursor:pointer;
	    }
	    
	    .dotBorderTop{
		border-top:1px dotted #000;
		}
	</style>


</body>
<script type="text/javascript"
	src="<%=ctx%>/page/msds/km/bespeak/bespeak_edit.js"></script>
</html>