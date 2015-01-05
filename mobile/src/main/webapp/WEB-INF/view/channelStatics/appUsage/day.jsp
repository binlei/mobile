<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="appUsageCommon.jsp"></jsp:include>

<script type="text/javascript"> 
var curr_time = new Date();
$(function() { 
	//显示当前时间
	$("#uploadTime_to").datebox("setValue", curr_time.format("yyyy-MM-dd"));
	curr_time.setDate(curr_time.getDate()-14);
	$("#uploadTime_from").datebox("setValue", curr_time.format("yyyy-MM-dd"));
	//渠道下拉框
	//getLegalChannel($("#extendProp3"));
	setTime('day');
	//默认加载数据
	loadData('dataChart','日度数据','dayUsage','dataTable');
	rigntClick();
});

</script>
</head>

<body class="easyui-layout" style="width:100%;height:100%;">
  	<!-- 查询表单 -->
		<div class="Search-box" region="north" title="查询条件" style="height:185px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off' method="post">
				<input type="hidden" id="startTime" name="startTime" value="">
				<input type="hidden" id="endTime" name="endTime" value="">
				<table class="tableForm"  align="center" style="width:1100px;">
					<tr>
						<th>渠道</th>
						<td><input id="extendProp4" name="extendProp4"/></td>
						<th>APP名称</th>
						<td><input id="appName" name="appName"/></td>
						<th>安装包名</th>
						<td><input id="packageName" name="packageName"/></td>
					</tr> 
					<tr>
						<th>APP版本</th>
						<td><input id="versionName" name="versionName"/></td>
						<th>查询时间</th>
						<td>
							<input id="uploadTime_from" name="uploadTime_from" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>至
							<input id="uploadTime_to" name="uploadTime_to" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>
						</td>
					</tr> 
					<tr>
						<td colspan="6" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_search('dataChart','日度数据','dayUsage','dataTable','day')">查询数据</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="historyMax('topNChart','日到达TOP N','dayUsageTop','topNTable')">历史最高</a>&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</form>
			
		</div>
	
	<!-- 数据 -->
		<div region="center" style="width:100%;height:100%;border:0;">
			<div id="content">
				<div id="dataChart" class="dataSeries" style="width: 95%; height: 350px; margin: 0 auto;"></div>
				<div id="topNChart" class="topN" style="width: 95%; height: 350px; margin: 0 auto;display: none;"></div>
				<div id="dataTable" class="dataSeries" style="width: 95%;height：120px;margin:20px auto;"></div>
				<div id="topNTable" class="topN" style="width: 95%;height：120px;margin:20px auto;display: none;"></div>
			</div>
		</div>
	
	<!--右键菜单div-->
		<div id="menu" class="easyui-menu" style="width: 100px;">
			<div onclick="exp2excel('appUsage')">导出Excel</div>
		</div>
			
	<!--进度条-->	
		<img id="progressImgage" class="progress" style="display:none" alt="" src="${pageContext.request.contextPath}/images/chart_processbar.gif"/> 
		<div id="maskOfProgressImage" class="mask" style="display:none"></div>
</body>
</html>
