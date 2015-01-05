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
		sy.createDatagrid($("#mobilePushMessage"),srchForm);
		sy.pageButtons($("#mobilePushMessage"));
	});
	//获取所选记录ID
	function getSelections() {
		return sy.getSelectionsIds($("#mobilePushMessage"));
	}
	//格式化处理类型
	function format_dealType(value,row,index){
        if (value=='1'){
             return "文件下载或打开网页";
        }
	    else if (value=='2') {
	         return "广告处理";
		}
	    else if (value=='3') {
	         return "应用激活";
		}
	    else if (value=='4') {
	         return "通知并隐式激活";
		}
	}
	//格式化打开网址类型
	function format_openType(value,row,index){
        if (value=='1'){
             return "浏览器打开";
        }
	    else if (value=='2') {
	         return "微信打开";
		}
	}
	
	function addFun() {
		$('#editDialog').dialog({    
		    title: '新建消息',    
		    width: 620,    
		    height: 380,
		    maximizable:true,
		    closed: true,
		    cache: false,    
		    href: '${pageContext.request.contextPath}/mobilePushMessage/preAdd',    
		    modal: true,
		    onClose: function() {
		    	tj_query('mobilePushMessage');
		    }
		});
		$('#editDialog').dialog('open');
	}
	function editFun(){
		var selections = $("#mobilePushMessage").datagrid('getSelections');
		if(selections.length != 1) {
			$.messager.alert('提示','请勾选一行记录!','warning');
		}else {
		$('#editDialog').dialog({    
		    title: '编辑消息',    
		    width: 620,    
		    height: 380,
		    maximizable:true,
		    closed: true,
		    cache: false,    
		    href: '${pageContext.request.contextPath}/mobilePushMessage/preEdit?id='+selections[0].id,    
		    modal: true,
		    onClose: function() {
		    	tj_query('mobilePushMessage');
		    }
		});
		$('#editDialog').dialog('open');
		}
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;"
	onkeydown="javascript:keyPressImpl(event,'mobilePushMessage');" onkeyup="javascript:keyReleaseImpl(event,'mobilePushMessage');">
  	<!-- 查询表单 -->
		<div id="srchDiv" class="easyui-dialog" closed="true" title="查找" style="width:450px;height:200px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<input type="hidden" name="bean" value="mobilePushMessage">
				<input type="hidden" name="method" value="page">
				<table class="tableForm"  align="center" style="">
					<tr>
						<th>消息主题</th>
						<td><input name="extendProp2"/></td>
					</tr>
					<tr>							
						<th>通知标题</th> 
						<td><input name="notiTitle"/></td>					
					</tr>
					<tr>
						<th>处理类型</th>
						<td>
							<select name="dealType" style="width:100px;padding-left:15px;"> 
								<option value="" selected="selected"></option>  
							    <option value="1">文件下载或打开网页</option>   
							    <option value="2">广告处理</option>   							      
							    <option value="3">应用激活</option>   							      
							    <option value="4">通知并隐式激活</option>   							      
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="tj_query('mobilePushMessage')">查询</a>&nbsp;&nbsp;&nbsp;
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
			<table id="mobilePushMessage" style="text-align:center;">
				<thead>    
			       <tr>  	
			       	   <th data-options="field:'id',width:120,sortable : true">ID</th>		        
			           <th data-options="field:'extendProp2',width:150,sortable : true">消息主题</th>
					   <th data-options="field:'dealType',width:150,sortable : true" formatter = 'format_dealType'>处理类型</th>
			           <th data-options="field:'notiTitle',width:150,sortable : true">通知标题</th>   
			           <th data-options="field:'notiContent',width:250,sortable : true">通知内容</th>
			           <th data-options="field:'notiImgUrl',width:200,sortable : true">通知图片</th>
			           <th data-options="field:'openType',width:120,sortable : true" formatter = 'format_openType'>打开网页类型</th>
			           <th data-options="field:'netUrl',width:250,sortable : true">网络地址</th>
			           <th data-options="field:'notiFileUrl',width:250,sortable : true">文件下载地址</th>
			           <th data-options="field:'packageName',width:150,sortable : true">激活包包名</th>
			           <th data-options="field:'extendProp1',width:200,sortable : true">APP名称</th>
			           <th data-options="field:'extendsData1',width:200,sortable : true">上报周期调整</th>
			           <th data-options="field:'extendsData2',width:200,sortable : true">应用激活次数</th>
			           <th data-options="field:'creator',width:120,sortable : true" formatter = 'format_creator'>创建人员</th>
			           <th data-options="field:'createdTime',width:120,sortable : true" formatter = 'format_createdTime'>创建时间</th>
			           <th data-options="field:'lastOperator',width:120,sortable : true" formatter = 'format_lastOperator'>最后修改人员</th>
			           <th data-options="field:'lastOperatedTime',width:120,sortable : true" formatter = 'format_lastOperatedTime'>最后修改时间</th>
			       </tr>   
			   </thead>
			</table>
		</div>

	<!--右键菜单div-->
		<div id="menu" class="easyui-menu" style="width: 100px;">
			<div onclick="simpleSearch();">查找</div>
			<div onclick="addFun();">新建</div>
			<div onclick="editFun();">编辑</div>
			<div onclick="openlimitDialog()">导出Excel</div>
		<div>
</body>
</html>
