var form = new mini.Form("#editform");
mini.parse();
var company = mini.get("companyId");
var isam = mini.get("isAm");
function SetData(data) {
    if (data.action == "edit") {
        data = mini.clone(data);
        $.ajax({
            url: ctx + "/orderLog/getId.action?id=" + data.id,
            cache: false,
            success: function (text) {
                form.setData(text);
                form.setChanged(false);
            }
        });
    }
}
function cancelRow() {
    CloseWindow("close");
}

function updateBespeak(){
	form.validate();
    if (form.isValid() == false){
    	return;
    }
	
	if (confirm("是否修改改预约单？")) {
		var bespeakDate = mini.formatDate(mini.getbyName("bespeakDate").getValue(), "yyyy-MM-dd");
		$.ajax({
	        url: ctx + "/bespeak/saveOrUpdateBespeak.action",
	        type: "post",
	        data: {
	            id: mini.getbyName("id").getValue(),
	            
	            bespeakDate: bespeakDate,
	            isAm: isam.getValue(),
	            companyId: company.getValue()
	            
	        },
	        success: function (text) {
	            CloseWindow("success");
	        },
	        error: function (text, textStatus, errorThrown) {
	        	mini.alert("操作失败，请重试");
//	            CloseWindow(text.responseText);
	        }
	    });
	}
	
	
}

function companyChange(e) {
	$.ajax({
        url: ctx + "/company/getId.action",
        type: "post",
        data: {
            id: company.getValue()
        },
        success: function (text) {
        	$("#companyMes").html(text.fullAddress+'，联系电话:'+text.telephone);
        },
        error: function (text, textStatus, errorThrown) {
        
        }
    });
}


function CloseWindow(action) {
    if (action == "close" && form.isChanged()) {
        if (confirm("数据被修改了，是否先保存？")) {
            return false;
        }
    }
    if (window.CloseOwnerWindow) {
        return window.CloseOwnerWindow(action);
    } else {
        window.close();
    }
}