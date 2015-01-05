<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript">
	var srchForm;
	$(function() {
		$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appPackageType"), srchForm);
	});
	function refreshSelf(){
		$("#appPackageType").datagrid("reload");
	}
</script>
</head>
<body class="easyui-layout" style="width: 100%; height: 100%;" onkeydown="javascript:keyPressImpl(event,'appPackageType');" onkeyup="javascript:keyReleaseImpl(event,'appPackageType');">

	<div class="Search-box" region="north" title="相关查询" style="height: 200px;">
		<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
			<input type="hidden" name="bean" value="appPackageType"> 
			<input type="hidden" name="method" value="page">
			<table class="tableForm" style="width: 700px"  align="center">
				<tr>
					<th>应用包名</th>
					<td><input name="name" /></td>
					<td  colspan="3" align="center"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="tj_query('appPackageType')">查询</a>&nbsp;&nbsp;&nbsp; 
					<a href="javascript:void(0)" class="easyui-linkbutton"	onclick="sy.cleanSearch()">重置</a></td>
				</tr>
					
			</table>
		</form>
	</div>
	
	<div id="showDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" iconCls="icon-edit" title=" " style="width: 500px; height: 320px;">
		<iframe scrolling="auto" id='openReceiveFeedBack' name="openReceiveFeedBack" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	<div id="addPackageTypeDialog" class="easyui-dialog" shadow="false" closed="true" buttons="#dlg-buttons" iconCls="icon-add" title=" " style="width: 500px; height: 280px;">
		<iframe scrolling="auto" id='openAddPackageType' name="openAddPackageType" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
	</div>
	<div class="main-data" region="center">
		<table id="appPackageType">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'code',width:80,sortable : true" >编码</th>
					<th data-options="field:'name',width:150,sortable : true">名称</th>
					<th data-options="field:'status',width:80,sortable : true,formatter:format_status">状态</th>
					<th data-options="field:'description',width:100,sortable : true">描述</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="menu" class="easyui-menu" style="width: 80px;">
		<div data-options="name:'add'" onclick="add('appPackageType');">新增</div>
		<div data-options="name:'edit'" onclick="edit('appPackageType');">编辑</div>
		<div data-options="name:'delete'" onclick="del('appPackageType');">移除</div>
	</div>
	<script type="text/javascript">
		function addPackage(){
			$('#openAddPackageType')[0].src = 'add';
			$('#addPackageTypeDialog').dialog('open');
			$("#addPackageTypeDialog").panel("move",{top:$(document).scrollTop() + ($(window).height()-500) * 0.5});
		}
	</script>
</body>
</html>