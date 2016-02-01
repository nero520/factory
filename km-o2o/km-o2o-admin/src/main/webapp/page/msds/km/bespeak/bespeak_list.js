mini.parse();
var grid = mini.get("datagrid_bespeak");
grid.load();
function showEdit(action,id){
	mini.open({
		url : ctx+"/page/msds/km/bespeak/bespeak_edit.jsp",
		title : "预约单",
		width : 600,
		height : 350,
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
	showEdit("new");
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
					url : ctx+"/bespeak/delete.action?id=" + id,
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

var type = mini.get("bespeakType");
var bespeakState = mini.get("state");
function search() {
	var bespeakSn = mini.get("bespeakSn").getValue();
	var serviceContent = mini.get("serviceContent").getValue();
	var afterDate = mini.get("afterDate").getValue();
	var beforeDate = mini.get("beforeDate").getValue();
	var bespeakType = type.getValue();
	var state = bespeakState.getValue();
	
	afterDate = mini.formatDate(afterDate, "yyyy-MM-dd");
	beforeDate = mini.formatDate(beforeDate, "yyyy-MM-dd");
	grid.load({
		bespeakSn:bespeakSn,
		serviceContent:serviceContent,
		afterDate:afterDate,
		beforeDate:beforeDate,
		bespeakType:bespeakType,
		state:state
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

/**
 * 跳转预约单明细
 */
function details(id){
	var params = "";
	params += "id="+id;
	parent.addTabUrl(ctx+"/bespeak/getDetail.action?"+params,"预约单详情");
}




grid.on("drawcell", function (e) {
	var record = e.record,
		column = e.column,
		field  = e.field,
		value  = e.value;
	 
	//设置列属性
	column.headerAlign="center";
	column.align="center";
	
	//settleSn列，超链接操作按钮
	if (field == "bespeakSn") {
		e.cellHtml = "<a href=javascript:details('"+record.id+"')>"+record.bespeakSn+"</a>";
	};
	
	if (field == "action") {
		
		 if(record.bespeakType==1 && (record.state == 1 || record.state == 2)){
			 e.cellStyle = "text-align:center";
			 e.cellHtml = '<a href="javascript:updateBespeakState(\'' + record.id +'\',\'3\')">取消</a>&nbsp; '+
		   	 '<a href="javascript:getBespeakInfo(\'true\',\'' + record.id + '\',\'编辑预约单\')">修改</a>&nbsp; ';
	     }else if(record.bespeakType==2 && record.state == 1){
	    	 e.cellStyle = "text-align:center";
	 	     e.cellHtml = '<a href="javascript:updateBespeakState(\'' + record.id +'\',\'3\')">取消</a>&nbsp; '+
	    	 '<a href="javascript:updateBespeakState(\'' + record.id + '\',\'2\',\''+record.phone+'\')">确认</a>&nbsp; '+
	    	 '<a href="javascript:getBespeakOnlineInfo(\'true\',\'' + record.id + '\',\'编辑预约单\')">修改</a>&nbsp; ';
	     }else if(record.bespeakType==2 && record.state == 2){
	    	 e.cellStyle = "text-align:center";
	 	     e.cellHtml = '<a href="javascript:updateBespeakState(\'' + record.id +'\',\'3\')">取消</a>&nbsp; '+
	    	 '<a href="javascript:getBespeakOnlineInfo(\'true\',\'' + record.id + '\',\'编辑预约单\')">修改</a>&nbsp; ';
	     }
	    
	}
});

/**
 * 根据ID查询预约单
 */
function getBespeakInfo(isEdit,recordId,title)   {          
	
	parent.addTabUrl(ctx+"/bespeak/getBespeak.action?isEdit="+isEdit+"&id="+recordId,title);
}

/**
 * 根据ID查询预在线约单
 */
function getBespeakOnlineInfo(isEdit,recordId,title)   {          
	
	parent.addTabUrl(ctx+"/bespeak/getDetail.action?isEdit="+isEdit+"&id="+recordId,title);
}


function updateBespeakState(id,state,phone) {
 
	
  if(state == 3){
	  if (confirm("是否取消该预约单？")) {
		  update(id,state,phone);
	  }
  }else{
	  if (confirm("是否确认该预约单？确认后，将为用户推送一条预约单信息。")) {
		  update(id,state,phone);
	  }
  }
  
   
}

function update(id,state,phone){
	 $.ajax({
	        url: ctx + "/bespeak/updateBespeakState.action",
	        type: "post",
	        data: {
	            id: id,
	            state: state,
	            phone: phone
	        },
	        success: function (text) {
	        	mini.alert("操作成功");
	        	grid.load();
	        },
	        error: function (text, textStatus, errorThrown) {
	        	mini.alert("操作失败，请重试");
	        }
	    });
}


var Genders = [{ id: 1, text: '待确认' }, { id: 2, text: '已确认'}, { id: 3, text: '已取消'}];
function onGenderRenderer(e) {
    for (var i = 0, l = Genders.length; i < l; i++) {
        var g = Genders[i];
        if (g.id == e.value) return g.text;
    }
    return "";
}

var bespeakType = [{ id: 1, text: '顾问咨询' }, { id: 2, text: '在线预约'}];
function onTypeRenderer(e) {
    for (var i = 0, l = bespeakType.length; i < l; i++) {
        var g = bespeakType[i];
        if (g.id == e.value) return g.text;
    }
    return "";
}