<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form class="cmxform" id="commentForm" method="post" >
	<fieldset>
		<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table width="100%" class="table_border">
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>编号
					</td>
					<td><input name="code" id="code" maxlength="100" value="${appType.code}" readonly="readonly" required /></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>类型名称
					</td>
					<td>
						<input type="hidden" name="id" value="${appType.id }" /> 
						<input name="name" id="name" maxlength="100" value="${appType.name}" required />
					</td>
				</tr>
				<tr>
					<td class="title" width="100" style="font-size: 13px;">状态</td>
					<td>
						<input type="radio" name="status" <c:if test="${appType.status eq 'ENABLED' }">checked</c:if> value="ENABLED" />有效
						<input type="radio" name="status" <c:if test="${appType.status eq 'DISABLED' }">checked</c:if> value="DISABLED" />无效</td>
				</tr>
				<tr>
					<td class="title" width="100">应用描述</td>
					<td><textarea name="description" id="description" maxlength="100" required>${appType.code}</textarea></td>
				</tr>
				<tr>
					<td align="center" valign="middle" colspan="3"><input type="submit" value="提交" class="submit" /> 
						<input type="button" value="取消" class="blue_mod_btn" onclick="parent.closeDialog('showDialog');" /></td>
				</tr>
			</table>
	</fieldset>
</form>
</body>
</html>