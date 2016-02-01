var form = new mini.Form("#editform");

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



function updateRow() {
    form.validate();
    if (form.isValid() == false){
    	return;
    }
    
    //设置遮罩
	 mini.mask({ el: document.body, cls: 'mini-mask-loading', html: '加载中,请稍后...'});
	    setTimeout(function () {
	    mini.unmask(document.body);
	    }, 5000);
    var o = form.getData();
    var json = mini.encode(o);
    
    var bespeakDate = mini.formatDate(mini.getbyName("bespeakDate").getValue(), "yyyy-MM-dd");
   
    $.ajax({
        url: ctx + "/bespeak/saveOrUpdateBespeak.action",
        type: "post",
        data: {
            id: mini.getbyName("id").getValue(),
            problem: mini.getbyName("problem").getValue(),
            answer: mini.getbyName("answer").getValue(),
            totalPrice: mini.getbyName("totalPrice").getValue(),
            bespeakDate: bespeakDate,
            companyId: company.getValue(),
            isAm: isam.getValue(),
            memberId: mini.getbyName("memberId").getValue(),
            memberModelId: mini.getbyName("memberModelId").getValue(),
            serviceContent: mini.getbyName("serviceContent").getValue(),
            bespeakSn: mini.getbyName("bespeakSn").getValue()
        },
        success: function (text) {
            CloseWindow("success");
        },
        error: function (text, textStatus, errorThrown) {
        	mini.alert("操作失败，请重试");
//            CloseWindow(text.responseText);
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
