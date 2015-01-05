<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
<!--
var idExist;
var imeiExist;
//消息ID combogrid
$('#pushMessageId').combogrid({    
    panelWidth:500,
    mode: 'remote', 
    method: 'post',
    url: '${pageContext.request.contextPath}/process',  
    queryParams: {
    	bean: 'mobilePushMessage',
    	method: 'page'
    },
    pagination:true,
    pageSize : 5,		
	pageList : [5,10,15],
	required:true,
    idField: 'id',    
    textField: 'id',    
    columns: [[ 
        {field:'id',title:'消息ID',width:247,sortable:true},    
        {field:'notiTitle',title:'通知标题',width:248,sortable:true}    
    ]],
    onBeforeLoad: function(param) {
    	idExist = true;
    	return idExist;
    },
    onLoadSuccess : function(data) {
    	if(data.total == 0) {
    		idExist = false;
    	}
    }
});
//IMEI combogrid
$('#imei').combogrid({    
    panelWidth:520,
    mode: 'remote', 
    method: 'post',
    url: '${pageContext.request.contextPath}/process',  
    queryParams: {
    	bean: 'mobileArrival',
    	method: 'page'
    },
    pagination:true,
    pageSize : 5,		
	pageList : [5,10,15],
	required:true,
    idField: 'imei',    
    textField: 'imei',    
    columns: [[ 
        {field:'imei',title:'IMEI',width:257,sortable:true},    
        {field:'simOperator',title:'网络运营商',width:258,sortable:true}    
    ]],
    onBeforeLoad: function(param) {
    	imeiExist = true;
    	return imeiExist;
    },
    onLoadSuccess : function(data) {
    	if(data.total == 0) {
    		imeiExist = false;
    	}
    }
});
//重置表单
	function resetForm() {
		$('#commentForm').form('reset');
	}
//保存
	function saveMessagee() {
		var vldate = $('#commentForm').form('validate');
		if(vldate && idExist && imeiExist) {
			$.ajax({
				url:'add',
				method:'post',
				data:$("#commentForm").serialize(),
				dataType : 'text',
				success : function(data){
					if(data == "successed"){
						$(".msg").html("<b style='padding-left:10px;color:blue;'>操作成功!</b>");
					}else if(data == "defeated") {
						$(".msg").html("<b style='padding-left:10px;color:red;'>系统错误！请联系管理员。</b>");
					}
				}
			});
		} else if(!vldate) {
			$.messager.alert("提示", "表单信息填写不完整，带<font color='red'>*</font>为必填项！","info");
		} else if(vldate && !idExist) {
			$(".msg").html("<b style='padding-left:10px;color:red;'>操作失败!消息ID不存在。</b>");
		} else if(vldate && idExist && !imeiExist) {
			$(".msg").html("<b style='padding-left:10px;color:red;'>操作失败!设备IMEI不存在。</b>");
		}
	}
//-->
</script>
<form class="cmxform" id="commentForm">
		<table class="table_border" border="1" width="450px" height="120px">
					<tr>
						<td class="title" ><font color="red">*&nbsp;</font>消息ID
						</td>
						<td>
							<input name="pushMessageId" id="pushMessageId" style="width:350px;"/>
						</td>
					</tr>
					<tr>
						<td class="title" ><font color="red">*&nbsp;</font>设备IMEI
						</td>
						<td>
							<input name="imei" id="imei" style="width:350px;"/>
						</td>
					</tr>
					<tr>
						<td align="center" valign="middle" colspan="2">
						<a href="javascript:void(0)" class="easyui-linkbutton"onclick="saveMessagee();">保存</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton"onclick="resetForm();">重置</a>
						</td>
					</tr>
				</table>
</form>
<div class="msg" style="width:100%;height:20px;position:absolute;bottom:0;background-color:#E9F4F7;">
</div>