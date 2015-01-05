/**
 * description: 创建图表
 * 
 * @param container
 *            图表容器 div id
 * @param title
 *            图表标题 String
 * @param subtitle
 *            副标题 String
 * @param yTitle
 *            Y轴标题 String
 * @param dataLabels
 *            是否显示数据标签 Boolean
 * @param defaultSeriesType
 *            图表类型 (line, spline, area, areaspline, column, bar, pie , scatter)
 * @param categories
 *            X轴序列 []
 * @param series
 *            数据 [{name:"",data:[]},{}]
 * @author: jing.huang
 * @date: 2014年4月23日
 */
function createChart(chartContainer,title, subtitle, yTitle, dataLabels, defaultSeriesType,
		categories, series) { 
	var chart = new Highcharts.Chart({
		chart : {
			renderTo : chartContainer,
			defaultSeriesType : defaultSeriesType,
			marginRight : 130,
			marginBottom : 50
			//margin: [0,0,0,0]
		},
		title : {
			text : title,
			x : -20
		},
		subtitle : {
			text : subtitle,
			x : -20
		},
		xAxis : {
			categories : categories
		},
		yAxis : {
			title : {
				text : yTitle
			},
			plotLines : [ {
				value : 0,
				width : 1,
				color : '#808080'
			} ]
		},
		tooltip : {
			formatter : function() {
				return '<b>' + this.series.name + '</b><br/>' + this.x + ': '
						+ this.y+'个';
			}
		},
		legend : {
			layout : 'vertical',
			align : 'right',
			verticalAlign : 'top',
			x : -10,
			y : 100,
			borderWidth : 0
		},
		series : series,
		credits : {
			href : 'http://www.jshuabo.com',
			text : 'jshuabo.com'
		},
		plotOptions : {
			enable : true,
			allowPointSelect : true,
			column : {
				dataLabels : {
					enabled : dataLabels
				// 是否显示数据标签
				}
			}
		}
	});
}

/**
 * description: 
 * 			  创建图表对应的表格
 * @param containerName
 *            表格容器id名
 * @param width
 *            表格宽度
 * @param thead
 *            表头行数组：["","","",...]
 * @param tbody
 *            表格主体数据数组: [{name:"",data:["","",...]},{},...]
 * @author: jing.huang
 * @date: 2014年4月25日
 */
function createTable(containerName,width, thead, tbody) {
	// 创建一个表格对象
	var mytable = document.createElement("table");
	mytable.cellSpacing = "1px";
	// 创建一个表头对象
	var mythead = document.createElement("thead");
	for (var a = 0; a < 1; a++) {
		var myrow = document.createElement("tr");
		for (var b = 0; b < thead.length + 1; b++) {
			var mytd = document.createElement("td");
			if (b == 0) {
				mytd.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
			} else {
				mytd.innerHTML = thead[b - 1];
			}
			mytd.style.cssText = "text-align:center;";
			myrow.appendChild(mytd);
		}
		mythead.appendChild(myrow);
	}
	// 创建一个表体对象
	var mytbody = document.createElement("tbody");
	for (var i = 0; i < tbody.length; i++) {
		var myrow = document.createElement("tr");
		for (var j = 0; j < thead.length + 1; j++) {
			var mytd;
			if (j == 0) {
				mytd = document.createElement("td");
				mytd.innerHTML = tbody[i].name;
				mytd.style.cssText = "text-align:center;background-color:#F3F3F3;font-weight:bold;";
			} else {
				mytd = document.createElement("td");
				mytd.innerHTML = tbody[i].data[j - 1];
				mytd.style.cssText = "text-align:center;background-color:#fff;";
				var aa = ""+tbody[i].data[j - 1];
				if(aa.substr(aa.length-1,1) == '%') {
					var num = parseFloat(aa);
					if(num >= 1) {
						mytd.style.cssText = "text-align:center;color:red;background-color:#fff;";
					}
				}
			}
			myrow.appendChild(mytd);
		}
		mytbody.appendChild(myrow);
	}
	// 创建一个表脚对象
	var mytfoot = document.createElement("tfoot");
	for (var c = 0; c < 1; c++) {
		var myrow = document.createElement("tr");
		for (var d = 0; d < 1; d++) {
			var mytd = document.createElement("td");
			mytd.innerHTML = "脚" + (d + 1);
			mytd.style.cssText = "text-align:center;";
			mytd.colSpan = "10";
			myrow.appendChild(mytd);
		}
		mytfoot.appendChild(myrow);
	}
	// 将表头追加到表格
	mytable.appendChild(mythead);
	// 将表体追加到表格
	mytable.appendChild(mytbody);
	// 将表脚追加到表格
	// mytable.appendChild(mytfoot);
	// 追加对象样式
	mythead.style.cssText = "background-color:#F3F3F3;font-size:14px; font-weight:600; width:"
			+ width + "px;";
	mytable.style.cssText = "background-color:#999; border:0px; width:" + width
			+ "px;";
	mytfoot.style.cssText = "background-color:#003; color:#FFF; font-size:14px; font-weight:600; width:"
			+ width + "px;";
	document.getElementById(containerName).appendChild(mytable);
}