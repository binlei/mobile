<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<link href="${ctx}/css/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/html/list.css">

<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>

<link href="${ctx}/js/plugins/progressBar/progressBar.css" rel="stylesheet" type="text/css">
<script src="${ctx}/js/plugins/progressBar/progressBar.js"></script>
<script src="${ctx }/js/additional-methods.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/common/appTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, { //验证中文  
		fieldvalid : {
			validator : function(value) {
				return /^.*?\.(apk)$/.test(value);
			},
			message : "只能上传apk格式文件"
		}
	});
	function showSuccessMsg() { // 提示信息
		$('#showDialog').dialog('close');
		$.messager.show({
			title:'提示',
			msg:'<h1>操作成功!</h1>',
			timeout:3000,
			showType:'slide',
			width:350,
			height:200
		});
	}
	function resetFrom(){
		document.getElementById("commentForm").reset();
	}
/* 	$(function(){
		window.parent.jQuery("reload", $("#appInfo"));
	}) */
</script>
<title>应用添加</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table id="appPackageType" width="100%"  class="formTable"  >
				<tr>
					<td  class="title" width="100" height="30"><span style="color: red;">*&nbsp;</span>应用名</td>
					<td><input type="text" name="name" id="appName"  maxlength="100" required/></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>渠道
					</td>
					<td><select id="getOrgName" name="organization.id" style="width: 140px" required></select></td>
				</tr>
				<tr>
					<td class="title" width="100" height="30"><span style="color: red;">*&nbsp;</span>应用类型</td>
					<td><select id="appType" name="appType.id" style="width: 140px" required></select> <span id="promptType" style="color: red;font-size: 13px;"></span></td>
				</tr>
				<tr>
					<td class="title" width="100" height="30"><span style="color: red;">*&nbsp;</span>应用文件</td>
					<td><input type="file" id="file" name="file" class="easyui-validatebox" validType="fieldvalid"  required="true" /></td>
				</tr>
				<tr>
					<td  class="title" width="100" height="30">显示快捷图标</td>
					<td>
						<input type="radio" value="true"  name="showShorCut" checked="checked"/>是
						<input type="radio" value="false"  name="showShorCut" />否
					</td>
				</tr>
				<tr>
					<td  class="title" width="100" height="30">应用描述</td>
					<td><textarea id="description"  name="description"  maxlength="100" ></textarea></td>
				</tr>
				<tr>
					<td align="center" valign="middle" colspan="3">
						<input type="submit" value="提交" class="submit" >
						<input type="button" value="取消"  onclick="parent.closeDialog('addDialog');">
					</td>
				</tr>
			</table>
	</fieldset>
</form>
<!-- 	<script>
		var progressBar = new ProgressBar('${ctx}', "文件上传中...");
		function formSubmit(){
			$("#commentForm").submit(function(){
				progressBar.show();
				//progressBar.close();
			});
		}
	</script> -->
</body>
</html>