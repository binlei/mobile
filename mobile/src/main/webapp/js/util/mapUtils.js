var mapfn = $.extend({}, mapfn);/* 定义全局对象 */
// 地图事件设置函数：
mapfn.setMapEvent = function() {
	map.enableDragging(); // 启用地图拖拽事件，默认启用(可不写)
	map.enableScrollWheelZoom(); // 启用地图滚轮放大缩小
	map.enableDoubleClickZoom(); // 启用鼠标双击放大，默认启用(可不写)
	map.enableKeyboard(); // 启用键盘上下左右键移动地图
};

// 地图控件添加函数：
mapfn.addMapControl = function() {
	var opts = {offset: new BMap.Size(15, 150)};//控件位移
	map.addControl(new BMap.NavigationControl(opts));// 添加平移缩放控件
	map.addControl(new BMap.ScaleControl());// 添加比例尺控件
	map.addControl(new BMap.OverviewMapControl());// 添加缩略地图控件
	map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]}));     //2D图，卫星图
	map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT}));    //左上角，默认地图控件
	map.setCurrentCity("南京");   //由于有3D图，需要设置城市
};

// 创建带标注的marker闭包
mapfn.createMark = function(lng, lat, info_html) {// lng:经度；lat:纬度；info_html:消息内容
	var opts = {
		width : 100, // 信息窗口宽度
		height : 60, // 信息窗口高度
	};
	var _marker = new BMap.Marker(new BMap.Point(lng, lat));
	_marker.addEventListener("click", function(e) {
		this.openInfoWindow(new BMap.InfoWindow(info_html,opts));
	});
	_marker.addEventListener("mouseover", function(e) {
		this.openInfoWindow(new BMap.InfoWindow(info_html,opts));
	});
	return _marker;
};

//反地址解析：将经纬度转为标准地址格式
mapfn.location2address = function(point) {//point：位置点
	var myGeo = new BMap.Geocoder();
	myGeo.getLocation(point, function(result ){
        var addComp = rs.addressComponents;
        document.getElementById("address").innerHTML = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
    });
};
