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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/dataStatistics.js"></script>

<script type="text/javascript">
	var srchForm;
	$(function() {
 		$('body').layout('collapse','north');
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInstallLog"), srchForm);
	});
	
	
	function installInfo(){
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInstallLog"), srchForm);
		$('.datagrid .panel-body').css('display','block');
		$('#container').css('display','none');
	}
	
	
</script>
</head>
<body class="easyui-layout" style="width: 100%; height: 100%;" onkeydown="javascript:keyPressImpl(event,'appInstallLog');" onkeyup="javascript:keyReleaseImpl(event,'appInstallLog');" >
	
	<div class="Search-box" region="north" title="装机明细" style="height: 250px;">
		<form id="srchForm" class="frmSearch" autocomplete='off'>
			<input type="hidden" name="bean" value="appDataStatistic">
			<input type="hidden" name="method" value="page" id="formMethod">
			<table class="tableForm" >
				<tr >
					<th>手机型号</th>
					<td><input name="model" id="model"/></td>
					<th>IMEI</th>
					<td><input name="imei" id="imei"/></td>
					<th>操作员</th>
					<td><input name="userName" id="userName"/></td>
				</tr>
				<tr  >
					<th>安装包</th>
					<td><input name="appPackageName"  id="appPackageName"/></td>
					<th>应用名</th>
					<td><input name="appName" id="appName"/></td>
					<th>渠道</th>
					<td><select id="getOrgName" name="organizationId"></select></td>
				</tr>
				<tr>
					<th>装机结果</th>
					<td><select id="installStatus" name="installStatus">
								<option value="1">成功</option>
								<option value="0">失败</option>
							</select>
					</td>
					<th>安装时间</th>
					<td>
						<input id="installStartTime"  name="installStartTime" editable="false" class="timeInput easyui-datetimebox" style="width:120px;"/>至
						<input id="installEndTime" name="installEndTime" editable="false" class="timeInput easyui-datetimebox" style="width:120px;"/>
					</td>
				</tr>
				<tr >
					<td colspan="4" align="center"><a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="tj_query('appInstallLog')">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="sy.cleanSearch()">重置</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="main-data" region="center">
		<div class="mt_10">
			<input type="button" value="装机明细" class="blue_mod_btn" onclick="javascript:installInfo()"/>
			<input type="button" value="应用装机量" class="blue_mod_btn" onclick="javascript:appStatistics()"/>
			<input type="button" value="导出Excel" class="blue_mod_btn"	onclick="javascript:exportToExcel()" style="float:right;"/>
		</div>
		<table id="appInstallLog">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'createdTime',width:100,sortable : true">装机时间</th>
					<th data-options="field:'orgName',width:100,sortable : true">渠道</th>
					<th data-options="field:'userId',width:100,sortable : true">操作员工号</th>
					<th data-options="field:'appPackageName',width:100,sortable : true">安装包名称</th>
					<th data-options="field:'appName',width:100,sortable : true">应用名称</th>
					<th data-options="field:'model',width:100,sortable : true">手机型号</th>
					<th data-options="field:'imei',width:100,sortable : true">IMEI</th>
					<th data-options="field:'installStatus',width:80,sortable : true">装机结果</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
		<div id="container" style="min-width: 400px; height: 400px; margin: 52px  auto;display:none;"></div>
</html>