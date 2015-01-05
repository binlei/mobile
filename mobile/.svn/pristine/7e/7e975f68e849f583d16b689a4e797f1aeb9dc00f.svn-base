<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="../common/mobileCommon.jsp"></jsp:include>

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
Number.prototype.toPercent = function(n){n = n || 2;return ( Math.round( this * Math.pow( 10, n + 2 ) ) / Math.pow( 10, n ) ).toFixed( n ) + '%';}
var title = "APP装机异常统计";
var yTitle = "数量（单位：个）";
var dataLabels = true;
var defaultSeriesType = 'column';//line, spline, area, areaspline, column, bar, pie , scatter

//加载数据
function loadData(chartContainer,subtitle,uri,tableContainer) {
	$.ajax({
		url : postPath+'/appInstallLog/'+uri,
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
			if(result.installTotal.length>0) {
				var xAxis = result.installTime;
				var series = []; 
				
				var installTotalObject = {};
				var imeiNullObject = {};
				var installFailObject = {};
				var imeiNullRateObject = {};
				var installFailRateObject = {};
				
				var installTotalData = result.installTotal;
				var imeiNullData = result.imeiNull;
				var installFailData = result.installFail;
				var imeiNullRateData = [];
				var installFailRateData = [];
				for(var i=0;i<result.installTotal.length;i++) {
					if(imeiNullData[i] == '0') {
						imeiNullRateData[i] = 0;
					} else {
						imeiNullRateData[i] = (imeiNullData[i]/installTotalData[i]).toPercent(4);
					}
					if(installFailData[i] == '0') {
						installFailRateData[i] = 0;
					} else {
						installFailRateData[i] = (installFailData[i]/installTotalData[i]).toPercent(4);
					}
				}
				
				imeiNullObject.name = "未取到IMEI次数";
				imeiNullObject.data = imeiNullData;
				
				installFailObject.name = "安装失败次数";
				installFailObject.data = installFailData;
				
				installTotalObject.name = "安装总次数";
				installTotalObject.data = installTotalData;
				
				imeiNullRateObject.name = "未取到IMEI比例";
				imeiNullRateObject.data = imeiNullRateData;
				
				installFailRateObject.name = "安装失败比例";
				installFailRateObject.data = installFailRateData;
				
				series.push(imeiNullObject);
				series.push(installFailObject);
				series.push(installTotalObject);
				
				createChart(chartContainer,title,subtitle,yTitle,dataLabels,defaultSeriesType,xAxis,series);
				$("#"+tableContainer).children().remove();//删除原来表格
				
				series.push(imeiNullRateObject);
				series.push(installFailRateObject);
				
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