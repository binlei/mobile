<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="appPgkInfo" value="appPackageInfo"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<link href="${pageContext.request.contextPath}/css/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html/list.css">

<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appPackageTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/showDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript">
	var srchForm;
	$(function() {
		$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appPackageInfo"), srchForm);
		getLegalChannel($("#getOrgName"),"install");
	});
	function closeDialog(name) { // 关闭窗口
		$('#'+name).dialog('close');
		refreshSelf();
	}
	// 刷新
	function refreshSelf(){
		$("#appPackageInfo").datagrid("load");
	}
</script>

</head>
<body class="easyui-layout" style="width: 100%; height: 100%;" onkeydown="javascript:keyPressImpl(event,'${appPgkInfo}');"
	onkeyup="javascript:keyReleaseImpl(event,'${appPgkInfo}');">

	<div class="Search-box" region="north" title="应用包信息"
		style="height: 200px;">
		<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
			<input type="hidden" name="bean" value="appPackageInfo"> 
			<input type="hidden" name="method" value="page">
			<table class="tableForm" style="width: 900px" align="center">
				<tr >
					<th>应用包名</th>
					<td><input name="name" /></td>
					<th>应用包类型</th>
					<td><select name="packageTypeName" id="packageTypeName"></select></td>
					<th>渠道</th>
					<td><input id="getOrgName" name="organizationId"/></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="tj_query('${appPgkInfo}')">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="sy.cleanSearch()">重置</a></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="main-data" region="center">
		<table id="appPackageInfo">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'name',width:150,sortable : true">名称</th>
					<th data-options="field:'quantity',width:80,sortable : true">应用数量</th>
					<th data-options="field:'organization',width:100,sortable : true,formatter:format_org" >渠道</th>
					<th data-options="field:'appPackageType',width:100,sortable : true,formatter:format_appPackageType" >应用包类型</th>
					<th data-options="field:'createTime',width:120,sortable : true, formatter:format_createTime">创建时间</th>
					<th data-options="field:'status',width:80,sortable:true,formatter:format_status" >状态</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<div id="showDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" iconCls="icon-edit" title=" " style="width: 600px; height: 350px;">
		<iframe scrolling="auto" id='openReceiveFeedBack' name="openReceiveFeedBack" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<div id="addPackageDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" title=" " iconCls="icon-add"  style="width: 600px; height: 350px;">
		<iframe scrolling="auto" id='openAddPackage' name="openAddPackage" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<div id="menu" class="easyui-menu" style="width: 150px;">
		<div data-options="name:'add'" onclick="addPackage('${appPgkInfo}');">新增</div>
		<div data-options="name:'edit'" onclick="editPackage('${appPgkInfo}')">编辑包信息</div> 
		<div data-options="name:'edit'" onclick="addPackageDetail('${appPgkInfo}')">查看包应用</div> 
		<div data-options="name:'delete'" onclick="createPackageInfo('${appPgkInfo}');">生成该渠道包信息文件</div>
		<div data-options="name:'delete'" onclick="del('${appPgkInfo}');">移除</div>
	</div>
	<script type="text/javascript">
    // 创建 createPackageInfo
	function createPackageInfo(name) {
		var selectRow = $("#"+name).datagrid('getSelected');
		var orgId = selectRow.organization.id;
		$.ajax({
			url : postPath + "/appInfo/"+orgId+"/createPackageInfoFile",
			type:"post",
			success : function(data) {
				if(data=="successed"){
					$.messager.alert("提示", "文件生成成功！", "info");
				}else if(data=="TIMEOUT"){
					$.messager.alert("提示", "登入超时！请重新登入...", "warn",function(){
						window.location.href =postPath+"/user/logout";
					});
				}else{
					$.messager.alert("提示", "Error！请联系管理员...", "error");
				}
			}
		},"JSON");
	}
		function addPackage(){
			$('#openAddPackage')[0].src = 'add';
			$('#addPackageDialog').dialog('open');
			$("#addPackageDialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-400) * 0.5});
		}
		
		function addPackageDetail(name){
			var selectRow = $("#"+name).datagrid('getSelected');
			if (selectRow != null) {
				var pkgId = selectRow.id;
				var orgId = selectRow.organization.id;
				window.location.href = orgId +"/"+pkgId+"/queryAppInfo";
			} else {
				$.messager.alert('Warning', '请勾选一行记录', 'warning');
			}
		}
		
		function editPackage(name){
		var selectRow = $("#"+name).datagrid('getSelections');
		if (selectRow.length != 0) {
				$('#openReceiveFeedBack')[0].src = 'edit/' + selectRow[0].id;
				$('#showDialog').dialog('open');
				$("#showDialog").panel(
						"move",
						{
							top : $(document).scrollTop()
									+ ($(window).height() - 400) * 0.5
						});
			} else {
				$.messager.alert('Warning', '请勾选一行记录', 'warning');
			}
		}
	</script>
</body>
</html>