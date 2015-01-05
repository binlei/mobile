<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="../../common/mobileCommon.jsp"></jsp:include>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/exporting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/chartUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/datePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/dateCount.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/staticUtils.js"></script>

<style type="text/css">
	.progress{z-index: 2000} 
	.mask{position: fixed;top: 0;right: 0;bottom: 0;left: 0; z-index: 1000; background-color: #2F2F2F} 
</style>

<script type="text/javascript">
var title = "手机到达";
var yTitle = "数量（单位：个）";
var dataLabels = true;
var defaultSeriesType = 'column';//line, spline, area, areaspline, column, bar, pie , scatter

//加载数据
function loadData(chartContainer,subtitle,uri,tableContainer) {
	$.ajax({
		url : postPath+'/mobileArrival/'+uri,
		async : true,
		type : 'POST',
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(sy.serialieObject($("#srchForm"))),
		dataType : 'JSON',
		timeout : 60000,
		beforeSend:function(xhr){ 
			$("#progressImgage").show().css({ 
			"position": "fixed", 
			"top": "40%", 
			"left": "45%", 
			"margin-top": function () { return -1 * $("#progressImgage").height() / 2; }, 
			"margin-left": function () { return -1 * $("#progressImgage").width() / 2; } 
			}); 
			$("#maskOfProgressImage").show().css("opacity", "0.1"); 
			}, 
		error : function() {
			$.messager.show({
				title : '失败',
				msg : '请求错误，请重试！'
			});
		},
		success : function(result) {
			if(result.length>0) {
				var xAxis = [];
				var series = []; 
				var yObject = {};
				var yData = [];
				for(var i=0;i<result.length;i++) {
					xAxis[i] = result[i].xAxis;
					yData[i] = result[i].yData;
				}
				yObject.name = "到达数量";
				yObject.data = yData;
				
				series.push(yObject);
				createChart(chartContainer,title,subtitle,yTitle,dataLabels,defaultSeriesType,xAxis,series);
				$("#"+tableContainer).children().remove();//删除原来表格
				createTable(tableContainer,1100,xAxis,series);
			} else {
				$("#"+chartContainer).hide();
				$("#"+tableContainer).hide();
				$.messager.show({
					title : '提示',
					msg : '该时间段无数据！'
				});
			}
		},
		complete:function(xhr){ 
			$("#progressImgage").hide(); 
			$("#maskOfProgressImage").hide(); 

		} 
	}); 
}

</script> 
</head>
<body>

</body>
</html>