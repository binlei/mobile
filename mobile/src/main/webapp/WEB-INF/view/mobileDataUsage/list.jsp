<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/mobileCommon.jsp"></jsp:include>

<script type="text/javascript">
	var srchForm ;
	$(function() {
		//$('body').layout('collapse','north');
		srchForm = $("#srchForm");		
		sy.createDatagrid($("#mobileDataUsage"),srchForm);
		sy.pageButtons($("#mobileDataUsage"));
	});
	//获取所选记录ID
	function getSelections() {
		return sy.getSelectionsIds($("#mobileDataUsage"));
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;"
	onkeydown="javascript:keyPressImpl(event,'mobileDataUsage');" onkeyup="javascript:keyReleaseImpl(event,'mobileDataUsage');">
  	<!-- 查询表单 -->
		<div id="srchDiv" class="easyui-dialog" closed="true" title="查找" style="width:450px;height:350px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="mobileDataUsage">
				<input type="hidden" name="method" value="page">
				<table class="tableForm"  align="center" style="">
					<tr>
						<th>设备IMEI</th>
						<td><input name="imei"/></td>
					</tr>
					<tr>
						<th>网络运营商</th>
						<td><input name="simOperator"/></td>
					</tr>
					<tr>
						<th>上传日期</th>
						<td>
							<input name="uploadTime_from" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>至
							<input  name="uploadTime_to" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>
						</td>
					</tr>
					<tr>
						<th>统计日期</th>
						<td>
							<input name="statisticalTime_from" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>至
							<input  name="statisticalTime_to" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>
						</td>
					</tr>
					<tr>
						<th>系统版本号</th>
						<td><input name="extendProp2"/></td>
					</tr>
					<tr>
						<th>渠道</th>
						<td><input id="extendProp4" name="extendProp4"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('mobileDataUsage')">查询</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="sy.cleanSearch()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
			
	<div id="limitDialog" class="easyui-dialog" closed="true" title="导出" style="width: 350px; height: 200px;">
		<iframe scrolling="auto" frameborder="0" src="limitRecords" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<!-- 数据表格 -->
		<div region="center" style="width:100%;height:100%;border:0;">
			<table id="mobileDataUsage" style="text-align:center;">
				<thead>   
			       <tr>  	
			       	   <th data-options="field:'id',width:120,sortable : true">ID</th>		        
			           <th data-options="field:'imei',width:120,sortable : true">设备IMEI</th> 
			           <th data-options="field:'extendProp5',width:120,sortable : true">渠道</th> 
			           <th data-options="field:'simOperator',width:150,sortable : true">网络运营商</th>
			           <th data-options="field:'g23Time',width:150,sortable : true">2g/3g流量使用时长</th>
			           <th data-options="field:'g23Usage',width:150,sortable : true">2g/3g流量使用大小</th>
			           <th data-options="field:'wifiTime',width:150,sortable : true">wifi流量使用时长</th>
			           <th data-options="field:'wifiUsage',width:150,sortable : true">wifi流量使用大小</th>
			           <th data-options="field:'statisticalTime',width:150,sortable : true">统计日期</th>
			           <th data-options="field:'uploadTime',width:150,sortable : true">上传日期</th>
			           <th data-options="field:'extendProp1',width:200,sortable : true">IP地址</th>
			           <th data-options="field:'extendProp2',width:80,sortable : true">系统版本号</th>
			       </tr>   
			   </thead>
			</table>
		</div>

	<!--右键菜单div-->
		<div id="menu" class="easyui-menu" style="width: 100px;">
			<div data-options="name:'search'" onclick="simpleSearch();">查找</div>
			<div data-options="name:'add'" onclick="openlimitDialog()">导出Excel</div>
		<div>
</body>
</html>
