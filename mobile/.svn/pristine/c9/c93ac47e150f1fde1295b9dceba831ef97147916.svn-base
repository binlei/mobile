<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="appActivatedCommon.jsp"></jsp:include>

<script type="text/javascript"> 
$(function() { 
	//显示当前时间
	var curr_time = new Date();
	var curr_year = curr_time.getFullYear();
	var curr_seasonValue = getSeasonValue();
	$("#sSeasonStart").val(curr_seasonValue);
	$("#sSeasonEnd").val(curr_seasonValue);
	$.ms_DatePicker({
	    YearSelector: "#sYearEnd"
	},curr_year);
	//curr_time.setDate(curr_time.getDate()-365);
	var start_year = curr_year-1;
	$.ms_DatePicker({
	    YearSelector: "#sYearStart"
	},start_year);
	//
	setTime('season');
	//渠道下拉框
	//getLegalChannel($("#extendProp3"));
	//默认加载数据
	loadData('dataChart','季度数据','seasonActivated','dataTable');
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
				<table class="tableForm"  align="center" style="width:900px;">
					<tr>
						<th>渠道</th>
						<td><input id="extendProp4" name="extendProp4"/></td>
						<th>APP名称</th>
						<td><input id="appName" name="appName"/></td>				
					</tr> 
					<tr>
						<th>安装包名</th>
						<td><input id="packageName" name="packageName"/></td>
						<th>查询时间</th>
						<td>
							<select id="sYearStart" name="sYearStart"  class="sel_year">
			                </select>年 
			                <select id="sSeasonStart" name="sSeasonStart" class="sel_month">
			                	<option value="1">第一季度</option>
			                	<option value="2">第二季度</option>
			                	<option value="3">第三季度</option>
			                	<option value="4">第四季度</option>
			                </select>-
			                <select id="sYearEnd" name="sYearEnd" class="sel_year">
			                </select>年 
			                <select id="sSeasonEnd" name="sSeasonEnd" class="sel_month">
			                	<option value="1">第一季度</option>
			                	<option value="2">第二季度</option>
			                	<option value="3">第三季度</option>
			                	<option value="4">第四季度</option>
			                </select>
						</td>					
					</tr> 
					<tr>
						<td colspan="4" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_search('dataChart','季度数据','seasonActivated','dataTable','season')">查询数据</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="historyMax('topNChart','季到达TOP N','seasonActivatedTop','topNTable')">历史最高</a>&nbsp;&nbsp;&nbsp;
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
			<div onclick="exp2excel('appActivated')">导出Excel</div>
		</div>
			
	<!--进度条-->	
		<img id="progressImgage" class="progress" style="display:none" alt="" src="${pageContext.request.contextPath}/images/chart_processbar.gif"/> 
		<div id="maskOfProgressImage" class="mask" style="display:none"></div>
</body>
</html>
