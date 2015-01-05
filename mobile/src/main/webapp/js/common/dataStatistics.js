//数据统计图片柱状图，主js
function container(Xdata, seriesList) {

	$('#container')
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : '华博装机量数据统计'
						},
						subtitle : {
							text : ' '
						},
						xAxis : {
							categories : Xdata
						},
						yAxis : {
							min : 0,
							title : {
								text : '单位(台)'
							}
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px;" class="todayTime" >{point.key}</span><table>',
							pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
									+ '<td style="padding:0"><b>{point.y:.1f} 台</b></td></tr>'
									+ '<tr><td> </td><td style="padding-top:5px;float:right"><a href="javascript:dateDataInfo();" style="color:{series.color};">今日明细</a></td></tr>',
							footerFormat : '</table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							column : {
								pointPadding : 0.2,
								borderWidth : 0
							}
						},
						series : seriesList
					});

}

//应用装机量统计
function appStatistics() {

	$('.datagrid .panel-body').css('display', 'none');
	$('#container').css('display', 'block');

	// Y轴每人每天的统计量
	var Ydata = new Array();
	//alert(JSON.stringify(sy.serialieObject($("#srchForm"))));

	$.ajax({
		url : postPath + '/appInstallLog/appStatistics',
		async : false,
		type : 'POST',
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(sy.serialieObject($("#srchForm"))),
		dataType : 'JSON',
		timeout : 60000,
		error : function() {
			//alert(1);
		},
		success : function(datas) {
			if (datas == null) {
				alert("none");
			} else {
				for (var i = 0; i < datas.name.length; i++) {
					var MyObj = {};
					MyObj.name = datas.name[i][0];
					MyObj.data = datas.name[i][1];
					Ydata.push(MyObj);
				}

				//调用主函数展示图表
				container(datas.xName, Ydata);
			}
		}
	});

}

// 查询当日的装机明细
function dateDataInfo() {
	//alert($('.todayTime').text());
	var tt = $('.todayTime').text();
	if (null == tt || '' == tt || 'UNDEFINED' == tt) {
		$.messager.alert("提示", "查询当日装机明细失败,请刷新当前页面,重试!");
	} else {
		$.ajax({
			url : postPath + '/appInstallLog/queryDateData',
			type : 'POST',
			data : "dayNum=" + tt + "&param="
					+ JSON.stringify(sy.serialieObject($("#srchForm"))),
			success : function(data) {
				// alert(data[0].count+"@"+data.length);
				if ("SUCCESS" == data[0]) {
					$("#showApp").show();
					createTable(data);
				} else {
					$.messager.alert("提示", "查询当日装机明细失败,请刷新当前页面,重试!");
				}
			}
		});
	}

}

//创建页面数据表格
function createTable(list) {
	var hidden="";
	var data = new Array();
	data
			.push("<table width='90%' border='1' cellspacing='0' cellpadding='0'  style='text-align:center;font-size:15px;'> ");
	data.push("<tr style='font-size:20px;'><td colspan='4'>" + list[1] + "<input type='button' name='listValue' value='导出Excel' onclick='dateDataExport();' style='float:right;' /></td></tr>");
	hidden=hidden + list[1]+"|";
	hidden=hidden + list[2]+"|";
	hidden=hidden + list[3]+"|";
	for (var i = 4; i < list.length; i++) {
		data.push('<tr>');
		for (var j = 0; j < list[i].length; j++) {
			data.push('<td>' + list[i][j] + '</td>');
		}
		hidden=hidden + list[i]+"|";
		data.push('</tr>');
	}
	data.push("<tr ><td colspan='3' rowspan='2'>" + "合计" + "</br>" + "本月合计"
			+ "</td><td style='text-align:center;'>" + list[2] + "</td></tr>");
	data.push("<tr><td>" + list[3] + "</td></tr>");
	data.push('</tbody><table>');
	document.getElementById('listValue').value = hidden;
	document.getElementById('showApp').innerHTML = data.join('');
}

function dateDataExport()
{
	//var parentParms = sy.serialieObject($("#srchForm"));
	var param = document.getElementById('listValue').value;
	if (param.length > 0) {
		window.location.href = postPath
				+ "/appInstallLog/dateDataExportToExcel?param=" + param;
	} else {
		$.messager.alert("提示", "导出数据失败,请刷新当前页面,重试!");
	}
}