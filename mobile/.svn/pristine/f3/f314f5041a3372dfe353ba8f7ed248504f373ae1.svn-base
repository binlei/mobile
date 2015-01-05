<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<link
	href="${pageContext.request.contextPath}/css/themes/gray/easyui.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/html/list.css">

<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/showDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script type="text/javascript">
	var srchForm;
	$(function() {
		$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appType"), srchForm);
	});
	// 刷新
	function refreshSelf(){
		$("#appType").datagrid("reload");
	}
</script>

</head>
<body class="easyui-layout" style="width: 100%; height: 100%;" onkeydown="javascript:keyPressImpl(event,'appType');" 
	onkeyup="javascript:keyReleaseImpl(event,'appType');">

	<div class="Search-box" region="north" title="应用类型管理" style="height: 200px;">
		<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
			<input type="hidden" name="bean" value="appType"> 
			<input type="hidden" name="method" value="page">
			<table class="tableForm " align="center" >
				<tr>
					<th>应用类型</th>
					<td><input name="name" /></td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="tj_query('appType')">查询</a>&nbsp;&nbsp;&nbsp; 
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="sy.cleanSearch()">重置</a></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="showDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" title=" " iconCls="icon-edit" style="width: 500px; height: 320px;">
		<iframe scrolling="auto" id='openReceiveFeedBack' name="openReceiveFeedBack" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<div id="addApkTypeDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" title=" " iconCls="icon-add" style="width: 500px; height: 250px;">
		<iframe scrolling="auto" id='openAddApkType' name="openAddApkType" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>

	<div class="main-data" region="center">
		<table id="appType">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'code',width:80,sortable : true">编码</th>
					<th data-options="field:'name',width:150,sortable : true">名称</th>
					<th data-options="field:'status',width:80,sortable : true,formatter:format_status" >状态</th>
					<th data-options="field:'description',width:100,sortable : true">描述</th>
				</tr>
			</thead>
		</table>
	</div>
<!-- 
	<div id="menu" class="easyui-menu" style="width: 80px;">
		<div data-options="name:'add'" onclick="add('appType');">增加</div>
		<div data-options="name:'edit'" onclick="edit('appType');">编辑</div>
		<div data-options="name:'delete'" onclick="del('appType');">移除</div>
	</div> -->

</body>