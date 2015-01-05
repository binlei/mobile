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
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/showDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/exporting.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/dataStatistics.js"></script>

<script type="text/javascript">
	var srchForm;
	function queryLog(){
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInstallLog"), srchForm);
		tj_query('appInstallLog');
		$("#showDatasId").css("display","block");
	};
	
	function installInfo() {
		srchForm = $("#srchForm");
		sy.createDatagrid($("#appInstallLog"), srchForm);
		$('.datagrid .panel-body').css('display', 'block');
		$('#container').css('display', 'none');
		$("#showApp").hide();
	}
	
/* 	function exportToExcel()
	{
		//var parentParms = sy.serialieObject($("#srchForm"));
		window.location.href = postPath + "/appInstallLog/appDataExportToExcel?param="+JSON.stringify(sy.serialieObject($("#srchForm")));
	} */

	function exportToExcel() {
		//序列化表单元素，返回json数据
       // var params = $("#srchForm").serializeArray();  // $("#srchForm")
		//$.post("exportExcel",params,function(){});
		//window.location.replace("http://www.baidu.com");
		$("#srchForm").submit();
	}
	
	/*鼠标右键插件*/
	(function($) {
		$.fn.extend({
			//定义鼠标右键方法，接收一个函数参数 
			"rightClick" : function(fn) {
				//调用这个方法后将禁止系统的右键菜单 
				$("#container").bind('contextmenu', function(e) {
					return false;
				});
				//为这个对象绑定鼠标按下事件 
				$(this).mousedown(function(e) {
					//如果按下的是右键，则执行函数 
					if (3 == e.which) {
						fn();
					}
				});
			}
		});

	})(jQuery);

	$(document).ready(function(e) {
		$("body").rightClick(function() {
			$("#container").bind('contextmenu', function(e) {
				$('body').bind("contextmenu", function(e) {
					return true;
				});
				//显示快捷菜单
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});

				return false;
			});
		});
		getLegalChannel($("#getOrgName"), "install");
	});

	//展示APP
	function showAppInfo(name) {
		var selectRow = $("#" + name).datagrid('getSelected');
		if (selectRow) {
			if (selectRow.imei.length > 0) {
				$.ajax({
					url : postPath + '/appInstallLog/showAppListByImei',
					type : 'POST',
					data : "imei=" + selectRow.imei,
					success : function(data) {
						//alert(data.imei);
						// status listApp imei 
						//$.messager.alert("提示", data,"SUCCESS");
						$.messager.alert("该设备安装的应用", data.listApp, data.imei);
					}
				});
			}
		} else {
			$.messager.alert('Warning', '请选择一行', 'warning');
		}
	}
</script>
</head>
<body class="easyui-layout" style="width: 100%; height: 100%;"
	onkeydown="javascript:keyPressImpl(event,'appInstallLog');"
	onkeyup="javascript:keyReleaseImpl(event,'appInstallLog');">

	<div class="Search-box" region="north" title="装机明细" style="height: 150px;">
		<form id="srchForm" class="frmSearch" action="exportExcel" method="post" autocomplete='off'>
			<input type="hidden" name="bean" value="appInstallLog"> 
			<input type="hidden" name="method" value="page" id="formMethod">
			<table class="tableForm" style="width: 1000px">
				<tr>
					<th>IMEI</th>
					<td><input name="imei" id="imei" /></td>
					<th>安装包</th>
					<td><input name="appPackageName" id="appPackageName" /></td>
					<th>应用名</th>
					<td><input name="appName" id="appName" /></td>
				</tr>
				<tr>
					<th>操作员</th>
					<td><input name="userName" id="userName" /></td>
					<th>设备型号</th>
					<td><input name="model" id="model" /></td>
					<th>设备品牌</th>
					<td><input name="bland" id="bland" /></td>
				</tr>
				<tr>
					<th>安装时间</th>
					<td><input id="installStartTime" name="installStartTime"
						editable="false" class="easyui-datebox" style="width:120px;" />至 <input
						id="installEndTime" name="installEndTime" editable="false"
						class="easyui-datebox" style="width:120px;" /></td>
					<th>装机结果</th>
					<td><select id="installStatus" name="installStatus">
							<option value="">--请选择--</option>
							<option value="1">成功</option>
							<option value="0">失败</option>
					</select></td>
					<th>渠道</th>
					<td><input id="getOrgName" name="organizationId" /></td>
					<td colspan="3" align="center">
						<a href="javascript:void(0)" class="easyui-linkbutton" id="queryId" onclick="queryLog();">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="sy.cleanSearch()">重置</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="showDatasId" class="main-data" region="center" style="overflow: auto;display:none;">
		<table id="appInstallLog">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,sortable : true">ID</th>
					<th data-options="field:'imei',width:100,sortable : true">IMEI</th>
					<th data-options="field:'bland',width:100,sortable : true">品牌</th>
					<th data-options="field:'model',width:100,sortable : true">型号</th>
					<th data-options="field:'orgName',width:100,sortable : true">渠道</th>
					<th data-options="field:'userName',width:80,sortable : true">操作员工号</th>
					<th data-options="field:'appPackageInfoName',width:100,sortable : true">安装包名称</th>
					<th data-options="field:'appName',width:100,sortable : true">应用名称</th>
					<th data-options="field:'installTime',width:120,sortable : true">装机时间</th>
					<th data-options="field:'ip',width:100,sortable : true">IP</th>
					<th data-options="field:'installStatus',width:80,sortable : true,formatter:format_installStatus">装机结果</th>
				</tr>
			</thead>
		</table>
		<div id="container"
			style="min-width: 400px; height: 400px; margin: 0 auto;display:none;"></div>
		<div id="showApp" style="width:100%;margin-left:3%;"></div>
		<input type="hidden" name="listValue" value="" id="listValue" />
	</div>
	<div id="showResult"></div>
	<div id="menu" class="easyui-menu" style="width: 160px;">
		<div data-options="name:'add'" onclick="javascript:installInfo();">装机明细</div>
		<div data-options="name:'edit'" onclick="javascript:appStatistics();">应用装机量统计(图)</div>
		<div data-options="name:'export',iconCls:'icon-save'" onclick="exportToExcel();">导出 Excel</div>
		<!-- <div data-options="name:'showAppInfo'" onclick="javascript:showAppInfo('appInstallLog');">安装的app</div> -->
	</div>
</body>
</html>