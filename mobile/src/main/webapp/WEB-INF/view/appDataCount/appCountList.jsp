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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/getComboBox.js"></script>
<script type="text/javascript">
	var srchForm;
	$(function() {
		//$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInstallLog"), srchForm);
	});
</script>

</head>
<body class="easyui-layout" style="width: 100%; height: 101%;" onkeydown="javascript:keyPressImpl(event,'appInstallLog');" onkeyup="javascript:keyReleaseImpl(event,'appInstallLog');">
	<div class="Search-box" region="north" title="应用统计列表" style="height: 200px;">
		<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
			<input type="hidden" name="bean" value="appInstallLog"> <input type="hidden" name="method" value="page">
			<table class="tableForm datagrid-toolbar" align="center">
				<tr>
					<th>手机型号：</th>
					<td><input name="model" /></td>
					<th>操作员：</th>
					<td><input name="userId" /></td>
				</tr>
				<tr>
					<th>安装包：</th>
					<td><input name="appPackageName" /></td>
					<th>应用名：</th>
					<td><input name="appName" /></td>
					<th>渠道：</th>
					<td><select id="orgType" name="orgId"></select></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="tj_query()">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="sy.cleanSearch()">重置</a></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="main-data" region="center">
			<table id="appInstallLog">
				<thead>   
			       <tr>  			        
			       		<th data-options="field:'id',width:120,sortable : true">ID</th>
					   <th data-options="field:'status',width:100,sortable : true" >操作员</th>
						<th data-options="field:'status',width:100,sortable : true" >手机型号</th>
						<th data-options="field:'status',width:100,sortable : true" >安装包</th>
						<th data-options="field:'status',width:100,sortable : true" >应用</th>
						<th data-options="field:'status',width:100,sortable : true" >渠道</th>
					
			       </tr>   
			   </thead>
			</table>
		</div>	
		
</body>
</html>