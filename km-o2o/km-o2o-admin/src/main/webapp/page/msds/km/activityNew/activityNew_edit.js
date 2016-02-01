var form = new mini.Form("#editform");
function SetData(data) {
	if (data.action == "edit") {
		data = mini.clone(data);
		$.ajax({
			url : ctx+"/activityNew/getId.action?id=" + data.id,
			cache : false,
			success : function(text) {
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
	if (form.isValid() == false)
		return;
	var o = form.getData();
	var json = mini.encode(o);
	$.ajax({
		url : ctx+"/activityNew/save.action",
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : json,
		success : function(data) {
//			CloseWindow("success");
			parent.addTabUrl(ctx+'/activityNew/addActivityNewDetail.action?id='+data.content,'设置活动内容');
		},
		error : function(text, textStatus, errorThrown) {
			CloseWindow(text.responseText);
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
function onCloseClick(e) {
    var obj = e.sender;
    obj.setText("");
    obj.setValue("-1");
}