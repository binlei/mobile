var indexName; // 标记属于哪个页面


function add(name) { //  添加窗口
	indexName = name;
	$('#showDialog').dialog({
		modal : true,
		closed : true,
		title : "新增",
		width :400,
		height:380
	});
	$('#openReceiveFeedBack')[0].src = 'add';
	$('#showDialog').dialog('open');
}

// 绑定角色
function bindRole(name){
	var selectRow = $("#user").datagrid('getSelections');
	if(selectRow.length == 1){
		$('#showDialog').dialog({
			modal : true,
			closed : true,
			title : "绑定角色",
			width :500,
			height:450
		});
		$('#openReceiveFeedBack')[0].src = 'bindRole?id='+selectRow[0].id+"&name="+selectRow[0].name;
		$('#showDialog').dialog('open');
	}else{
		$.messager.alert('提示','请勾选一行记录!','warning');
	}
}

//绑定用户
function bindUser() {
	var selectRow = $("#role").datagrid('getSelections');
	if(selectRow.length == 1){
		$('#showDialog').dialog({
			modal : true,
			closed : true,
			title : "绑定用户",
			width :500,
			height:450
		});
		$('#openReceiveFeedBack')[0].src = 'bindUser?id='+selectRow[0].id+"&name="+selectRow[0].name;
		$('#showDialog').dialog('open');
	}else{
		$.messager.alert('提示','请勾选一行记录!','warning');
	}
}

//绑定权限
function bindPermission() {
	var selectRow = $("#role").datagrid('getSelections');
	if(selectRow.length == 1){
		$('#showDialog').dialog({
			modal : true,
			closed : true,
			title : "绑定权限",
			width :400,
			height:380
		});
		$('#openReceiveFeedBack')[0].src = 'bindPermission?id='+selectRow[0].id+"&name="+selectRow[0].name;
		$('#showDialog').dialog('open');
	}else{
		$.messager.alert('提示','请勾选一行记录!','warning');
	}
}

function edit(name) { // 编辑窗口
	// 获取选中的对象
	var selectRow = $("#"+name).datagrid('getSelections');
	indexName = name;
	if (selectRow.length == 1) {
		$('#showDialog').dialog({
			modal : true,
			closed : true,
			title : "编辑",
			width :400,
			height:380
		});
		$('#openReceiveFeedBack')[0].src = 'edit/' + selectRow[0].id;
		$('#showDialog').dialog('open');
	} else {
		$.messager.alert('Warning', '请勾选一行记录', 'warning');
	}
}

// 删除
function del(name) {
	var selectRow = $("#" + name).datagrid('getSelected');
	indexName = name;
	if (selectRow) {
		$.messager.confirm("操作", '确认要删除选中的数据吗？', function(result) {
			if (result) {
				$.ajax({
					type : "POST",
					url : selectRow.id + "/delete",
					/*contentType: "application/x-www-form-urlencoded; charset=utf-8",*/
					success : function(data) {
						if (data=="successed") {
							showSuccessMsg();
							$("#"+name).datagrid("reload");
						} else if (data == "exits") {
							$.messager.alert("提示", "不能删除该应用，因为其它包中包涵该应用，请将其移除在删除！","warning");
						} else if (data == "notEmpty") {
							$.messager.alert("提示", "不能删除，因为该数据关联其它应用，请将其清空在删除！","warning");
						} else {
							showFailedMsg();			// 失败显示
						}
					}
				});
			}
		});
	} else {
		$.messager.alert('Warning', '请选择一行', 'warning');
	}
}

/**
 * @param name datagrid Id  审核
 */
function audited(name){
	var ids=[];
	var rows = $("#"+name).datagrid("getSelections");
	for (var i = 0; i < rows.length; i++) {
		ids.push(rows[i].id);
	}
	if(rows != null){
		$.ajax({
			type:'post',
			url:'audited',
			data:{
				ides:ids.join(",")
			},
			success:function(data){
				if(data == "successed"){
					$("#"+name).datagrid("reload");
				}else{
					showFailedMsg();
				}
			}
		});
	}
}

function closeDialog(name) { // 关闭窗口
	$('#showDialog').dialog('close');
	$("#"+name).datagrid('uncheckAll');
	clearDialog();
	// 刷新
	$("#"+name).datagrid('load');
}

/*function ShowMsg() { // 提示信息
	$('#showDialog').dialog('close');
	$.messager.show({
		title:'提示',
		msg:'操作成功!',
		timeout:6000,
		showType:'slide'
	});
	clearDialog();
}*/

function saveFail(){//保存失败
	$.messager.alert("提示", "操作失败！","info");
	closeDialog(indexName);
}

function showSuccessMsg() { // 提示信息
	$('#showDialog').dialog('close');
	$.messager.show({
		title:'提示',
		msg:'<h3>操作成功!</h3>',
		timeout:3000,
		showType:'slide',
		width:300,
		height:150
	});
	clearDialog();
}

function showFailedMsg(){
	$('#showDialog').dialog('close');
	$.messager.alert('Error', '<font color="red">操作错误!</font>', 'error');
	clearDialog();
//	// 刷新
//	$("#"+name).datagrid('load');
}

function operateFail(){//保存失败
	$.messager.alert("提示", "<font color='red'>操作失败！编号不能重复！</font>","info");
}

function vaFormFail(){//验证表单失败
	$.messager.alert("提示", "请正确填写表单信息！","info");
}

function clearDialog(){//清空窗口内容
	$('#openReceiveFeedBack')[0].src = "";
}

function refresh(name,status){//页面刷新
	$("#showDialog").dialog('close');
	loadPage(name,status);
}

function loadPage(name,status){
	$("#"+name).datagrid('reload');
	if(status == "successed"){
		showSuccessMsg();
	}else{
		operateFail();
	}
}
