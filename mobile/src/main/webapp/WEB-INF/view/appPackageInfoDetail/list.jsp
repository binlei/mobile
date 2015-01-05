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
		$('body').layout('collapse','north');
		srchForm = $("#srchForm");		
		sy.createDatagrid($("#appPackageInfo"),srchForm);
	});
</script>

</head>
<body class="easyui-layout" style="width:100%;height:101%;" 
	onkeydown="javascript:keyPressImpl(event,'appPackageInfo');" onkeyup="javascript:keyReleaseImpl(event,'appPackageInfo');">

		<div class="Search-box" region="north" title="相关查询" style="height:200px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="appPackageInfo">
				<input type="hidden" name="method" value="page">
				<table class="tableForm datagrid-toolbar"  align="center">
					<tr>
						<th>相关查询</th>
						<td><input name="name"/></td>
						<th>相关查询</th>
						<td><input name="appType"/></td>
  					</tr>
					<tr>
						<td colspan="3" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('appPackageInfo')">查询</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="sy.cleanSearch()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
  	
		<div class="main-data" region="center">
			<table id="appPackageInfo">
				<thead>   
			       <tr>  			        
			       		<th data-options="field:'id',width:120,sortable : true">ID</th>
			           <th data-options="field:'name',width:100,sortable : true">装机时间</th>   
			           <th data-options="field:'appType.name',width:100,sortable : true" formatter="format_orgType">渠道</th>
			           <th data-options="field:'fileSize',width:100,sortable : true">操作员工号</th>
			           <th data-options="field:'appVersion',width:100,sortable : true">安装包名称</th>
			           <th data-options="field:'status',width:100,sortable : true">应用名称</th>
			           <th data-options="field:'mobileModel',width:100,sortable : true">手机型号</th>
			           <th data-options="field:'imei',width:100,sortable : true">IMEI</th>
			       </tr>   
			   </thead>
			</table>
		</div>	
		<div id="menu" class="easyui-menu" style="width: 80px;">
			<div data-options="name:'add'" onclick="add();">新增</div>
			<div  data-options="name:'edit'" onclick="edit('appPackageInfo');">编辑</div>
			<div data-options="name:'delete'" onclick="del('appPackageInfo');">删除</div>
		</div>
</body>
</html>