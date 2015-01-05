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

<script type="text/javascript">

var srchForm ;
	$(function() {
		//$('body').layout('collapse','north');
		srchForm = $("#srchForm");		
		sy.createDatagrid($("#appInfo"),srchForm);
	});
	function keyPressImpl(event) {
		sy.keyPress(event, $("#appInfo"));
	}
	function keyReleaseImpl(event) {
		sy.keyRelease(event, $("#appInfo"));
	}
	function tj_query(){
		$("#appInfo").datagrid('load',sy.serialieObject(srchForm));  
	}	
</script>

</head>
<body class="easyui-layout" style="width:100%;height:101%;" 
	onkeydown="javascript:keyPressImpl(event);" onkeyup="javascript:keyReleaseImpl(event);">
		
		<div class="Search-box" region="north" title="安装包统计列表" style="height:200px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="appInfo">
				<input type="hidden" name="method" value="page">
				<table class="tableForm datagrid-toolbar"  align="center">
					<tr>
					<th>手机型号：</th>
					<td><input name="model" /></td>
					<th>安装包：</th>
					<td><input name="appPackageName" /></td>
				</tr>
				<tr>
					<th>应用名：</th>
					<td><input name="appName" /></td>
					<th>渠道：</th>
					<td><select id="orgType" name="orgId"></select></td>
				</tr>
					<tr>
						<td colspan="3" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query()">查询</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="sy.cleanSearch()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
  	
		<div class="main-data" region="center">
			<table id="appInfo">
				<thead>   
			       <tr>  			        
					   <th data-options="checkbox:'true',field:'id'"></th>
					   <th data-options="field:'status',width:100,sortable : true" >渠道</th>
						<th data-options="field:'status',width:100,sortable : true" >手机型号</th>
						<th data-options="field:'status',width:100,sortable : true" >安装包</th>
						<th data-options="field:'status',width:100,sortable : true" >应用</th>
			       </tr>   
			   </thead>
			</table>
		</div>	
		
	<div id="menu" class="easyui-menu" style="width: 80px;">
		<div data-options="name:'add',iconCls:'icon-add'" >增加</div>
		<div data-options="name:'edit',iconCls:'icon-edit'">编辑</div>
		<div data-options="name:'delete',iconCls:'icon-remove'">移除</div>
	</div>
</body>
</html>