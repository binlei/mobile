<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="ico/favicon.ico">
<link href="${pageContext.request.contextPath}/css/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html/list.css">
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="post" action="add">
	<fieldset>
		<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table width="100%" class="table_border">
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>编码</td>
					<td><input name="code" id="code" maxlength="100" required /></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>类型名称</td>
					<td><input name="name" id="name" maxlength="100" required /><span id="promptName" style="color: red; font-size: 13px;"></span></td>
				</tr>
				<tr>
					<td class="title" width="100" style="font-size: 13px;">状态</td>
					<td><input type="radio" name="status" checked="checked" value="ENABLED" />有效 
					<input type="radio" name="status" value="DISABLED" />无效</td>
				</tr>
				<tr>
					<td class="title" width="100">应用描述</td>
					<td><textarea name="description" id="description" maxlength="100"></textarea></td>
				</tr>
				<tr>
					<td align="center" valign="middle" colspan="3">
						<input type="submit" value="提交" class="submit" id="save"> 
						<input type="button" value="取消" class="blue_mod_btn" onclick="parent.closeDialog('addApkTypeDialog');"></td>
				</tr>
			</table>
	</fieldset>
</form>
</body>
</html>