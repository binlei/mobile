<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/showDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript">
	var srchForm;
	$(function() {
		$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInfo"), srchForm);
		getLegalChannel($("#getOrgName"),"install");
	});
	
	function closeDialog(name) { // 关闭窗口
		$('#'+name).dialog('close');
		// 刷新
		$('#'+name).datagrid('reload');
	}
	
	function showSuccessMsg() { // 提示信息
		$('#showDialog').dialog('close');
		$.messager.show({
			title:'提示',
			msg:'<h2>操作成功!</h2>',
			timeout:3000,
			showType:'slide',
			width:350,
			height:200
		});
	}
	// 刷新自己
	function refreshSelf(){
		$("#appInfo").datagrid("reload");
	}
</script>

</head>
<body class="easyui-layout" style="width: 100%; height: 100%;" onkeydown="javascript:keyPressImpl(event,'appInfo');" onkeyup="javascript:keyReleaseImpl(event,'appInfo');">
 	<div class="Search-box" region="north" title="应用列表" style="height: 200px;">
		<form id="srchForm" class="frmSearch"  autocomplete='off'>
			<input type="hidden" name="orgId" value="${orgCode }"> 
			<input type="hidden" name="bean" value="appInfo"> 
			<input type="hidden" name="method" value="page">
			<table class="tableForm" style="width: 700px" align="center">
				<tr>
					<th>应用名</th>
					<td><input name="name" id="name" /></td>
					<th>类型</th>
					<td><select id="appType" name="appTypeId"></select></td>
					<th>渠道</th>
					<td><input id="getOrgName" name="organizationId"/></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="tj_query('appInfo')">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="sy.cleanSearch()">重置</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="showDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" iconCls="icon-edit" title=" " style="width: 500px; height: 370px;">
		<iframe scrolling="auto" id='openReceiveFeedBack' name="openReceiveFeedBack" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<div id="addDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" title=" " iconCls="icon-add" style="width: 500px; height: 300px;">
		<iframe scrolling="auto" id='openAddApk' name="openAddApk" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	<div id="datagrids" class="main-data" region="center">
		<table id="appInfo">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'name',width:150,sortable : true,formatter:format_img" >名称</th>
					<th data-options="field:'showShortCut',width:80,sortable : true,formatter:format_showShorCut">显示快捷图标</th>
					<th data-options="field:'appVersion',width:100,sortable : true" >版本号</th>
					<th data-options="field:'organization',width:100,sortable : true,formatter:format_org" >渠道</th>
					<th data-options="field:'appType',width:100,sortable : true,formatter:format_appType" >类型</th>
					<th data-options="field:'fileSize',width:80,sortable : true,formatter:format_unit" >文件大小(M)</th>
					<th data-options="field:'status',width:80,sortable : true,formatter:format_audited" >文件状态</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="menu" class="easyui-menu" style="width: 160px;">
		<div data-options="name:'add'" onclick="addApk();">上传应用</div>
		<div data-options="name:'edit'" onclick="edit('appInfo');">编辑应用</div>
		<c:if test="${orgCode eq 'Hb_grounp'}">
			<div data-options="name:'audited'" onclick="audited('appInfo');" id="audited">审核通过(可多选)</div>
		</c:if>
		<div data-options="name:'delete'" onclick="del('appInfo');">移除</div>
		
	</div>
	<script type="text/javascript">
			function addApk(){
				$('#openAddApk')[0].src = 'add';
				$('#addDialog').dialog('open');
				$("#addDialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-350) * 0.5});
			}
	</script>
</body>
</html>