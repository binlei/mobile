<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<link href="${pageContext.request.contextPath}/css/themes/gray/easyui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html/list.css">

<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/taglibs.jsp"></jsp:include>
<jsp:include page="../common/listUtil.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
</head>
<title>编辑信息</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="post"  enctype="multipart/form-data">
	<fieldset>
		<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table id="appPackageType" width="100%"  class="formTable" >
				<tr>
					<td  class="title" width="100"><span style="color: red;">*&nbsp;</span>应用名</td>
					<td>
					<input type="hidden" name="id" value="${appInfo.id }"/>
					<input type="text" name="name" id="name"  maxlength="100" value="${appInfo.name}" required /></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>渠道
					</td>
					<td><input type="hidden" value="${appInfo.organization.id }" id="organizationId" /> 
						<select id="getOrgName" name="organization.id" required></select></td>
				</tr>
				<tr>
					<td class="title" width="100"><span style="color: red;">*&nbsp;</span>应用类型</td>
					<td>
						<input type="hidden" id="appTypeId" value="${appInfo.appType.id}" /> 
						<select id="appType" name="appType.id" required></select></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>应用文件 </td>
                    <td>
                    	<input type="file" name="file" id="file" required/>
                    	<input type="hidden" id="filePath" value="${appInfo.fileName }" />
                    </td>
				</tr>
				<tr>
					<td  class="title" width="100" height="30">显示快捷图标</td>
					<td>
						<input type="radio" value="true"  name="showShorCut" <c:if test="${appInfo.showShorCut eq true}">checked</c:if> />是
						<input type="radio" value="false"  name="showShorCut"<c:if test="${appInfo.showShorCut eq false}">checked</c:if> />否
					</td>
				</tr>
				<tr>
						<td class="title" width="100" style="font-size: 13px;">应用版本</td>
						<td><input  name="appVersion" value="${appInfo.appVersion }"/></td>
				</tr>
				<tr>
					<td  class="title" width="100" height="30">状态</td>
					<td>
						<input type="radio" value="ENABLED"  name="status" <c:if test="${appInfo.status eq 'ENABLED'}">checked</c:if> />有效
						<input type="radio" value="DISABLED"  name="status"<c:if test="${appInfo.status eq 'DISABLED'}">checked</c:if> />失效
					</td>
				</tr>
				<tr>
					<td  class="title" width="100">应用描述</td>
					<td><textarea name="description" id="desc"  maxlength="100" >${appInfo.description}</textarea></td>
				</tr>
				<tr>
						<td align="center" valign="middle" colspan="3">
							<input type="submit" value="提交" class="submit" id="save">
							<input type="button" value="取消" class="blue_mod_btn" onclick="parent.closeDialog('showDialog');">
						</td>
					</tr>
			</table>
	</fieldset>
</form>
</body>
</html>