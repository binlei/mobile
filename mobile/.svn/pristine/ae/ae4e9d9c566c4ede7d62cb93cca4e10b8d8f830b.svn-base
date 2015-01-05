<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/mobileCommon.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html/add.css">

<script type="text/javascript">
	var srchForm ;
	$(function() {
		//$('body').layout('collapse','north');
		srchForm = $("#srchForm");		
		sy.createDatagrid($("#mobilePushMessageImei"),srchForm);
		sy.pageButtons($("#mobilePushMessageImei"));
		//$("#mobilePushMessageImei").datagrid('hideColumn','mobileLocationId');
	});
	//获取所选记录ID
	function getSelections() {
		return sy.getSelectionsIds($("#mobilePushMessageImei"));
	}
	//格式化推送状态
	function format_status(value,row,index) {
		if (value == 'SUCCESS'){
            return "成功";
       	}
	    else if (value == 'READY') {
	                 return "等待";
		}
	}
	//添加
	function addFun() {
		$('#editDialog').dialog({    
		    title: '推送消息',    
		    width: 470,    
		    height: 190,
		    maximizable:true,
		    closed: true,
		    cache: false,    
		    href: '${pageContext.request.contextPath}/mobilePushMessageImei/preAdd',    
		    modal: true,
		    onClose: function() {
		    	tj_query('mobilePushMessageImei');
		    }
		});
		$('#editDialog').dialog('open');
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;"
	onkeydown="javascript:keyPressImpl(event,'mobilePushMessageImei');" onkeyup="javascript:keyReleaseImpl(event,'mobilePushMessageImei');">
  	<!-- 查询表单 -->
		<div id="srchDiv" class="easyui-dialog" closed="true" title="查找" style="width:450px;height:350px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="mobilePushMessageImei">
				<input type="hidden" name="method" value="page">
				<table class="tableForm"  align="center" style="">
					<tr>
						<th>消息ID</th>
						<td><input name="pushMessageId"/></td>
					</tr>
					<tr>
						<th>设备IMEI</th>
						<td><input name="imei"/></td>
					</tr>
					<tr>
						<th>位置信息ID</th>
						<td><input name="mobileLocationId"/></td>
					</tr>					
					<tr>
						<th>推送时间</th>
						<td>
							<input name="pushTime_from" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>至
							<input  name="pushTime_to" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>
						</td>						
					</tr>
					<tr>
						<th>系统版本号</th>
						<td><input name="extendProp2"/></td>
					</tr>	
					<tr>
						<th>推送状态</th>
						<td>
							<select name="status">
			                	<option value="">-请选择-</option>
			                	<option value="SUCCESS">成功</option>
			                	<option value="READY">等待</option>
			                </select>
						</td>
					</tr>				
					<tr>
						<td colspan="2" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('mobilePushMessageImei')">查询</a>&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="sy.cleanSearch()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
			
	<div id="limitDialog" class="easyui-dialog" closed="true" title="导出" style="width: 350px; height: 200px;">
		<iframe scrolling="auto" frameborder="0" src="limitRecords" style="width: 100%; height: 98%;"></iframe>
	</div>
	
	<div id="editDialog">
	</div>
	
	<!-- 数据表格 -->
		<div region="center" style="width:100%;height:100%;border:0;">
			<table id="mobilePushMessageImei" style="text-align:center;">
				<thead>   
			       <tr>  
			       	   <th data-options="field:'id',width:120,sortable : true">ID</th>	        
					   <th data-options="field:'pushMessageId',width:80,sortable : true">消息ID</th>
			           <th data-options="field:'imei',width:120,sortable : true">设备IMEI</th>   
			           <th data-options="field:'mobileLocationId',width:80,sortable : true">位置信息ID</th>
			           <th data-options="field:'pushTime',width:150,sortable : true">推送时间</th>
			           <th data-options="field:'pushedCount',width:80,sortable : true">已推送次数</th>
			           <th data-options="field:'status',width:80,sortable : true" formatter = 'format_status'>推送状态</th>
			           <th data-options="field:'extendProp1',width:200,sortable : true">IP地址</th>
			           <th data-options="field:'extendProp2',width:80,sortable : true">系统版本号</th>
			       </tr>   
			   </thead>
			</table>
		</div>

	<!--右键菜单div-->
		<div id="menu" class="easyui-menu" style="width: 100px;">
			<div data-options="name:'search'" onclick="simpleSearch();">查找</div>
			<div onclick="addFun();">推送消息</div>
			<div data-options="name:'add'" onclick="openlimitDialog()">导出Excel</div>
		<div>
</body>
</html>
