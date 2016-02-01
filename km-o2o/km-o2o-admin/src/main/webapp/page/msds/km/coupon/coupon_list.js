mini.parse();
var grid = mini.get("datagrid_coupon");
var form = new mini.Form("#form");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/coupon/coupon_edit.jsp",
		title : "优惠红包表",
		width : 600,
		height : 300,
		onload : function() {
			var iframe = this.getIFrameEl();
			var data = {action : action, id : id};
			iframe.contentWindow.SetData(data);
		},
		ondestroy : function(action) {
			ondestroy(action);
		}
	});
}
function add() {
	parent.addTabUrl(ctx+'/coupon/addCoupon.action','新增红包及优惠券');
}
function edit(){
	var row = grid.getSelected();
    if (row) {
    	if(row.length>1){
    		mini.alert("只能选择一条记录");
    	} else {
    		var url = ctx+'/coupon/editCoupon.action?id='+row.id;
        	var title = '编辑红包及优惠券信息';
        	parent.addTabUrl(url,title);
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
					url : ctx+"/coupon/delete.action?id=" + id,
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
function search() {
	var o = form.getData(true);
	grid.load(o);
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
function updateState(id){
	$.ajax({
		url : ctx+"/coupon/updateState.action?id=" + id,
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
grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.align="center";
	//action列，超连接操作按钮
	if (column.name == "action") {
		var text = "暂停";
		if(record.state == 0){
			text = "开始";
		}
		e.cellHtml ='<a href="javascript:updateState(\'' + record.id + '\')">'+text+'</a>&nbsp; ';
	};
});