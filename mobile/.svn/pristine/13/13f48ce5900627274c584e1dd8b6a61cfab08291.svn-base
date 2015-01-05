<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appPackageTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appInfoUtil.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<title>Insert title here</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="post" >
	<fieldset> <legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项</legend>
		<table width="100%" class="table_border">
					<tr>
						<td class="title" width="100" style="font-size: 13px;"> <font color="red">*&nbsp;</font>包名称
						</td>
						<td>
							<input type="hidden" id="appPackageId" name="id" value="${appPackageInfo.id }" />
							<input name="name" id="appPackageTypeName"  maxlength="100" value="${appPackageInfo.name }" required />
							<span id="promptName" style="color: red;font-size: 13px;"></span>
						</td>
					<td class="title" width="100"><font color="red">*&nbsp;</font>渠道
					</td>
					<td><input type="hidden" value="${appPackageInfo.organization.id }" id="organizationId" />
						<select id="getOrgName" name="organization.id" required="true"></select>
					</td>
				</tr>
					<tr>
						<td class="title" width="100" style="font-size: 13px;">数量（Number）</td>
						<td><input disabled="disabled" value="${appPackageInfo.quantity }"/></td>
						<td class="title" width="100" style="font-size: 13px;">总大小（M）</td>
						<td><input disabled="disabled" value="${appPackageInfo.size }"/></td>
					</tr>
					<tr>
						<td class="title" width="100" style="font-size: 13px;"><font color="red">*&nbsp;</font>包类型
							<input type="hidden" id="appPkgTypeId" value="${appPackageInfo.appPackageType.id}"/>
						</td>
						<td><select  name="appPackageType.id" id="packageTypeName" required></select><span id="promptName" style="color: red;font-size: 13px;"></span></td>
						<td class="title" width="100" style="font-size: 13px;">状态</td>
						<td>
							<input type="radio" name="status" <c:if test="${appPackageInfo.status eq 'ENABLED' }">checked</c:if>  value="ENABLED"  />有效
							<input type="radio" name="status" <c:if test="${appPackageInfo.status eq 'DISABLED' }">checked</c:if>  value="DISABLED" />无效
						</td>
					</tr>
					<tr>
						<td class="title" width="100" style="font-size: 13px;">描述</td>
						<td><textarea id="description" name="description" >${appPackageInfo.description}</textarea></td>
					</tr>
					<tr>
						<td align="center" valign="middle" colspan="4">
							<input type="submit" value="提交" class="submit">
							<input type="button" value="取消" onclick="parent.closeDialog('showDialog');">
							<input type="button" value="生成包信息文件" onclick="createPackageInfo();">
						</td>
					</tr>
				</table>
	</fieldset>
</form> 
</body>
</html>