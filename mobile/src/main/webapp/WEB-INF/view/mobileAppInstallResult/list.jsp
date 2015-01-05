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
		sy.createDatagrid($("#mobileAppInstallResult"),srchForm);
		searchButtons();
	});
	function searchButtons() {
		var pager = $("#mobileAppInstallResult").datagrid('getPager');    // 得到datagrid的pager对象
		 pager.pagination({  
		     buttons:[
		     {  
		    	 text:'查找',
		         iconCls:'icon-search',  
		         handler:function() {
		        	 simpleSearch();
		         }
		     },
		     ]
		 }); 
	}
	//获取所选记录ID
	function getSelections() {
		return sy.getSelectionsIds($("#mobileAppInstallResult"));
	}
	//格式化安装状态
	function format_installStatus(value,row,index) {
		if (value == -1){
            return "解析数据失败";
       	}
	    else if (value == 0) {
            return "未下载";
		}
	    else if (value == 1) {
          	return "已下载但未安装";
		}
	    else if (value == 2) {
            return "已安装";
		}
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;"
	onkeydown="javascript:keyPressImpl(event,'mobileAppInstallResult');" onkeyup="javascript:keyReleaseImpl(event,'mobileAppInstallResult');">
  	<!-- 查询表单 -->
		<div id="srchDiv" class="easyui-dialog" closed="true" title="查找" style="width:450px;height:350px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="mobileAppInstallResult">
				<input type="hidden" name="method" value="page">
				<table class="tableForm"  align="center" style="">
					<tr>
						<th>设备IMEI</th>
						<td><input name="imei"/></td>
					</tr>
					<tr>
						<th>APP名称</th>
						<td><input name="appName"/></td>
					</tr>
					<tr>
						<th>安装包包名</th>
						<td><input name="packageName"/></td>
					</tr>
					<tr>
						<th>安装时间</th>
						<td>
							<input name="installTime_from" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>至
							<input  name="installTime_to" editable="false" class="timeInput easyui-datebox" style="width:120px;"/>
						</td>
					</tr>
					<tr>
						<th>安装状态</th>
						<td>
							<select name="installStatus">
								<option value="" selected="selected"></option>
								<option value="-1">解析数据失败</option>
								<option value="0">未下载</option>
								<option value="1">已下载但未安装</option>
								<option value="2">已安装</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>装机渠道名称</th>
						<td><input id="extendProp4" name="extendProp4"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('mobileAppInstallResult')">查询</a>&nbsp;&nbsp;&nbsp;
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
			<table id="mobileAppInstallResult" style="text-align:center;">
				<thead>   
			       <tr>  
			       	   <th data-options="field:'id',width:120,sortable : true">ID</th>			        
			           <th data-options="field:'imei',width:120,sortable : true">设备IMEI</th>   
			           <th data-options="field:'installTime',width:130,sortable : true">安装时间</th>
			           <th data-options="field:'installStatus',width:150,sortable : true" formatter="format_installStatus">安装状态</th>
			           <th data-options="field:'appName',width:100,sortable : true">应用程序名称</th>
			           <th data-options="field:'packageName',width:80,sortable : true">安装包包名</th>
			           <th data-options="field:'extendProp1',width:120,sortable : true">远程IP</th>
			           <th data-options="field:'extendProp2',width:150,sortable : true">远程版本</th>
			           <th data-options="field:'extendProp3',width:200,sortable : true">远程渠道</th>
			           <th data-options="field:'extendProp4',width:150,sortable : true">装机渠道编码</th>
			           <th data-options="field:'extendProp5',width:200,sortable : true">装机渠道名称</th>
			       </tr>   
			   </thead>
			</table>
		</div>

	<!--右键菜单div-->
		<div id="menu" class="easyui-menu" style="width: 100px;">
			<div data-options="name:'search'" onclick="simpleSearch();">查找</div>
			<!-- <div data-options="name:'add'" onclick="openlimitDialog()">导出Excel</div> -->
		<div>
</body>
</html>