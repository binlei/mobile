<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script type="text/javascript" src="http://api.map.baidu.com/api?key=TIfZksg475Gz8v1SmNQZEyQN&v=1.2&services=true"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/mapUtils.js"></script>
<script type="text/javascript">
	//创建地图函数：
	function initMap() {
		var curr_time = new Date();
		$("#locationTime").datebox("setValue", curr_time.format("yyyy-MM-dd hh:mm:ss")); 
		   
		var map = new BMap.Map("dituContent"); //在百度地图容器中创建一个地图
		var centerPoint = new BMap.Point(114.114129, 37.850339); //定义一个中心点坐标
		map.centerAndZoom(centerPoint, 5); //设定地图的中心点和坐标并将地图显示在地图容器中,5是地图缩放级别
		window.map = map; //将map变量存储在全局

		//添加消息
		var msg = "<b>江苏华博实业集团有限公司</b></br></br>地址：江苏省南京市雨花台区花神大道19号</br>坐标：118.781351，31.98055</br>电话：暂无";
		var marker = mapfn.createMark(118.781351, 31.98055, msg);
		map.addOverlay(marker);
		marker.openInfoWindow(new BMap.InfoWindow(msg));
		
		mapfn.setMapEvent(); //设置地图事件
		mapfn.addMapControl(); //向地图添加控件
	}

	//绘制近期路径
	function tj_query() {
		var imei = $("#imei").val();
		if(!imei) {
			alert("请先输入设备IMEI...");
		} else {
			$.ajax({
				url:'${pageContext.request.contextPath}'+'/mobileLocation/queryLocations',
				async : false,
				type : 'POST',
				contentType: "application/json; charset=utf-8",
				data:JSON.stringify(sy.serialieObject($("#srchForm"))),
				dataType:'JSON',
				error : function() {
					alert("error loading...");
				},
				success:function(result) {
					var nums = result.nums;
					if(nums>0) {
						map.clearOverlays();//清除地图上的标注
						var pointArr = [];
						for(var i=0;i<nums;i++) {
							pointArr[i] = new BMap.Point(result.rows[i].longitude,result.rows[i].latitude);//位置点
						}
						var driving = new BMap.DrivingRoute(map);//创建路线实例
						
						for(var i=0;i<nums-1;i++) {
							driving.search(pointArr[i], pointArr[i+1]);//两点的路线搜索
						}
						
						driving.setSearchCompleteCallback(function(){  
				            var pts = driving.getResults().getPlan(0).getRoute(0).getPath();//通过路线实例，获得一系列点的数组  
				      
				            var polyline = new BMap.Polyline(pts);       
				            map.addOverlay(polyline);  
				            
				            var markerArr = [];
				            for(var i=0;i<nums;i++) {
				            	//mapfn.location2address(pointArr[i]);
				            	var msg = "时间："+result.rows[i].locationTime+"</br>地址："+result.rows[i].address+"</br>坐标："+result.rows[i].longitude+","+result.rows[i].latitude;
				            	markerArr[i] = mapfn.createMark(result.rows[i].longitude,result.rows[i].latitude,msg);//创建marker
				            	map.addOverlay(markerArr[i]);
				            }
				            
				            //添加label
				            if(nums == 1) {
				            	var lab1 = new BMap.Label("唯一点",{position:pointArr[0]});
				            	map.addOverlay(lab1);
				            } else if(nums>1) {
				            	var lab1 = new BMap.Label("最晚点",{position:pointArr[0]});
				            	var lab2 = new BMap.Label("最近点",{position:pointArr[nums-1]});
				            	map.addOverlay(lab1);
				            	map.addOverlay(lab2);
				            }
				            				              
				            setTimeout(function(){  
				                map.setViewport(pointArr);//调整到最佳视野  
				            },500);	              
				        });
					} else {
						alert("没有符合要求的位置信息...");
					}
				}
			});
		}
	}
	
	//重置并返回初始状态
	function reset() {
		$(".timeInput").parent().children(".combo").children(".combo-value").val('');
		document.getElementById("srchForm").reset();
		$("#locationTime").datebox("setValue", new Date().format("yyyy-MM-dd hh:mm:ss"));
	}
	
</script>

</head>
<body class="easyui-layout" style="width: 100%; height: 100%;"
	onload="initMap();">
	<!-- 查询表单 -->
	<div class="Search-box" region="north" title="查询条件"
		style="height: 160px;">
		<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
			<table class="tableForm" align="center"
				style="width: 825px;">
				<tr>
					<th>设备IMEI</th>
					<td><input id="imei" name="imei" style="width: 150px;" /></td>
					<th>截止时间点</th>
					<td><input id="locationTime" name="locationTime" editable="false"
						class="timeInput easyui-datetimebox" style="width: 150px;" /></td>
					<th>位置数量</th>
					<td><select name="locationNums"
						style="width: 100px; padding-left: 15px;">
							<option value="5">5</option>
							<option value="10" selected="selected">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
							<option value="50">50</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="6" align="center"><a href="javascript:void(0)"
						class="easyui-linkbutton" onclick="tj_query()">查询</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="reset()">重置</a></td>
				</tr>
			</table>
			<input type="hidden" id="address" value=""/>
		</form>
	</div>
	<!--百度地图容器-->
	<div id="dituContent" region="center"
		style="width: 100%; height: 100%; border: #ccc solid 0;"></div>
</body>
</html>