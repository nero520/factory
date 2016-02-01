mini.parse();
var form = new mini.Form("#editform");
var grid = mini.get("datagrid_maintenanceHistory_detail");
loadDetail();
function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		$.ajax({
			url : ctx+"/maintenanceHistory/getDetailId.action?id=" + data.id,
			cache : false,
			success : function(text) {
				form.setData(text);
				form.setChanged(false);
			}
		});
	}
}
function showEdit(action,id,vin){
	mini.open({
		url : ctx+"/page/msds/km/maintenanceHistory/maintenanceHistoryDetail_edit.jsp",
		title : "维修历史明细",
		width : 400,
		height : 300,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : action, id : id, vin : vin};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
}
function add() {
	var aintenanceId = mini.get("id").getValue();
	if(aintenanceId==null || aintenanceId==""){
		showMsg("请先保存基本信息");
		return false;
	}
	var vin = mini.get("vin").getValue();
	showEdit("new",null,vin);
}
function edit(){
	var row = grid.getSelected();
    if (row) {
    	if(row.length>1){
    		mini.alert("只能选择一条记录");
    	} else {
        	showEdit("edit",row.id);
    	}
    } else {
        mini.alert("请选择一条记录");
    }
}
function rowdblclick(e) {
	showEdit("edit",e.row.id);
}
function remove() {
	var rows = grid.getSelecteds();
	if (rows.length > 0) {
		mini.confirm("确定删除选中记录？", "提示", function callback(msg) {
			if (msg == 'ok') {
				var ids = [];
				for ( var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.id);
				}
				var id = ids.join(',');
				grid.loading("操作中，请稍后......");
				$.ajax({
					url : ctx+"/maintenanceHistory/deleteDetail.action?id=" + id,
					success : function(text) {
						showMsg("操作成功", 'success');
						grid.reload();
					},
					error : function(text) {
						showMsg("操作失败：" + text.responseText, 'danger');
						grid.unmask();
					}
				});
			}
		});
	} else {
		showMsg("请选中一条记录", 'danger');
	}
}
function cancelRow() {
	CloseWindow("close");
}
function updateRow() {
	form.validate();
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/maintenanceHistory/save.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(text) {
			if(text.type==false){
				showMsg(text.content);
			}else if(text.type==true){
				mini.get("id").setValue(text.content);
				showMsg("操作成功");
			}
		},
		error : function(text, textStatus, errorThrown) {
			showMsg(text.responseText);
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
function ondestroy(action) {
	if (action == "success") {
		loadDetail();
		showMsg("操作成功", 'success');
	} else if (action != "close") {
		showMsg("操作失败：" + action, 'danger');
	}
}
function loadDetail(){
	var vin = mini.get("vin").getValue();
	var json = {};
	json.vin = vin;
	grid.load(json);
}
grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.align="center";
	if(field == "type"){
		for(var i=0; i<maintenanceHistoryDetailType.length; i++){
			if(maintenanceHistoryDetailType[i].id==value){
				e.cellHtml = maintenanceHistoryDetailType[i].text;
			}
		}
	}
});