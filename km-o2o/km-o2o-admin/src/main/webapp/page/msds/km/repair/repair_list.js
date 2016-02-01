mini.parse();
var grid = mini.get("datagrid_repair_list");
grid.load();


var repairType = mini.get("repairType");
var settleType = mini.get("settleType");
function search() {
	var cardNo = mini.get("cardNo").getValue();
	var license = mini.get("license").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var beforeDate = mini.get("beforeDate").getValue();
	var repairtype = repairType.getValue();
	var settletype = settleType.getValue();
	
	afterDate = mini.formatDate(afterDate, "yyyy-MM-dd");
	beforeDate = mini.formatDate(beforeDate, "yyyy-MM-dd");
	grid.load({
		cardNo:cardNo,
		license:license,
		afterDate:afterDate,
		beforeDate:beforeDate,
		repairType:repairtype,
		settleType:settletype
	});
}
function onKeyEnter(e) {
	search();
}
function ondestroy(action) {
	if (action == "success") {
		grid.reload();
		showMsg("操作成功", 'success');
	} else if (action != "close") {
		showMsg("操作失败：" + action, 'danger');
	}
}


function importData(){
	
	var files = mini.getbyName("file_path").getValue();
	if(files == ''){
		mini.alert("请选择文件");
		return;
	}
    //设置遮罩
	var myMask = mini.mask({ el: document.body, cls: 'mini-mask-loading', html: '数据导入中...'});
	    setTimeout(function () {
	    mini.unmask(document.body);
	    }, 10000);
	 
        
	$.ajax({
        url: ctx + "/repairList/importData.action",
        type: "post",
        data: {
            filePath: mini.getbyName("file_path").getValue()
        },
        success: function (text) {
        	
        	grid.load();
        },
        error: function (text, textStatus, errorThrown) {
        	mini.alert("数据导入失败，请检查源文件。");
//            CloseWindow(text.responseText);
        }
    });
}

var filectrl=$("#upload_file");
filectrl.uploadify({
	    'buttonText' : '选择文件',
	    'multi': false,//是否能选择多个文件
	    'height' : 20,//上传按钮的高
	    'width' : 100,//上传按钮的宽
	    'swf' : ctx+'/js/uploadify3.1/uploadify.swf',//[必须设置]swf的路径
	    'uploader' : ctx+'/uploads/uploadFile.action',//[必须设置]上传文件触发的url
	    'auto': true,
	    'fileObjName'   : 'file',
	    'method'   : 'get',
	    'fileTypeExts'  : '*.xls;*.xlsx',//可选格式
	    'formData'      : {'dirName':'model'},  
	    'onUploadSuccess' : function(file, data, response) {
	    	$("#upload_file").parent().removeClass('mini-error');;
	    	$("#upload_file").append("");
	    	if(response==true){//如果服务器返回200表示成功
	    		
	    		var data = data.substr(1,data.length-2);
	    		
    			mini.get("file_path").setValue(data);
    			showMsg("附件上传成功，请开始导入数据。", 'success');
    		}else{
    			showMsg("上传失败","danger");
    		}
    }
});




