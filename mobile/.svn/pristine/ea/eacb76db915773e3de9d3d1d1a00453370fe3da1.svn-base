<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../common/header.jsp" %>
<link rel="shortcut icon" href="ico/favicon.ico">
<link href="${pageContext.request.contextPath}/css/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html/list.css">
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
 <title>相关查询</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="post" >
	<fieldset>
		<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table width="100%" class="table_border">
					<tr>
						<td class="title" width="100"> <font color="red">*&nbsp;</font>编码 </td>
						<td> <input name="code" id="code"  maxlength="100" readonly="readonly" value="${appPackageType.code }" required /> </td>
					</tr>
					<tr>
						<td class="title" width="100">
							<font color="red">*&nbsp;</font>应用包名
						</td>
						<td>
							<input name="name" id="packageName"  maxlength="100" value="${appPackageType.name }" required />
							<span id="promptName" style="color: red;font-size: 13px;"></span>
						</td>
					</tr>
					<tr>
						<td class="title" width="100"> 状态
						</td>
						<td>
							<input type="radio" name="status" <c:if test="${appPackageType.status eq 'ENABLED' }">checked</c:if>  value="ENABLED"  />有效
							<input type="radio" name="status" <c:if test="${appPackageType.status eq 'DISABLED' }">checked</c:if>  value="DISABLED" />无效
						</td>
					</tr>
					<tr>
						<td class="title" width="100"> 应用包描述	</td>
						<td>
							<textarea  name="description" id="description"  maxlength="100" >${appPackageType.description}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center" valign="middle" colspan="3">
							<input type="submit" value="提交" class="submit">
							<input type="button" value="取消" class="blue_mod_btn" onclick="parent.closeDialog('showDialog');">
						</td>
					</tr>
				</table>
	</fieldset>
</form>
</body>
</html>