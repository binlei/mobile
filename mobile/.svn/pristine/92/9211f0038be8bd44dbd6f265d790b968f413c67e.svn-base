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
		sy.createDatagrid($("#mobileImeiUser"),srchForm);
		sy.pageButtons($("#mobileImeiUser"));
	});
	//获取所选记录ID
	function getSelections() {
		return sy.getSelectionsIds($("#mobileImeiUser"));
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;"
	onkeydown="javascript:keyPressImpl(event,'mobileImeiUser');" onkeyup="javascript:keyReleaseImpl(event,'mobileImeiUser');">
  	<!-- 查询表单 -->
		<div id="srchDiv" class="easyui-dialog" closed="true" title="查找" style="width:450px;height:200px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="mobileImeiUser">
				<input type="hidden" name="method" value="page">
				<table class="tableForm"  align="center">
					<tr>
						<th>设备IMEI</th>
						<td><input name="imei"/></td>
					</tr>
					<tr>
						<th>用户名</th>
						<td><input name="userName"/></td>
					</tr>	
					<tr>
						<th>系统版本号</th>
						<td><input name="extendProp2"/></td>						
					</tr>				
					<tr>
						<td colspan="2" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('mobileImeiUser')">查询</a>&nbsp;&nbsp;&nbsp;
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
			<table id="mobileImeiUser" style="text-align:center;">
				<thead>   
			       <tr> 
			       	   <th data-options="field:'id',width:120,sortable : true">ID</th> 			        
			           <th data-options="field:'imei',width:120,sortable : true">设备IMEI</th>   
			           <th data-options="field:'userName',width:150,sortable : true">用户别名</th>
			           <th data-options="field:'status',width:100,sortable : true">状态</th>
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
