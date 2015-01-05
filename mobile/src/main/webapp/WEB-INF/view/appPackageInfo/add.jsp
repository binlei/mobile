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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appPackageTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form class="cmxform" id="commentForm" method="post" >
		<fieldset>
			<legend>带<font color="red">&nbsp;*&nbsp;</font>为必填项
			</legend>
			<table width="100%" class="table_border">
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>包名称
					</td>
					<td><input name="name" id="typeName" maxlength="100" required /></td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>渠道
					</td>
					<td> 
						<select id="getOrgName" name="organization.id" style="width: 155px" required></select><span id="promptOrg" style="color: red;font-size: 13px;"></span>
					</td>
				</tr>
				<tr>
					<td class="title" width="100"><font color="red">*&nbsp;</font>应用包类型</td>
					<td><select name="appPackageType.id" id="packageTypeName" style="width: 155px" required></select><span id="promptType" style="color: red;font-size: 13px;"></span></td>
				</tr>
				<tr>
					<td class="title" width="100" >数量（Number）</td>
					<td><input disabled="disabled" /></td>
				</tr>
				<tr>
					<td class="title" width="100">总大小（M）</td>
					<td><input disabled="disabled" /></td>
				</tr>
				<tr>
					<td class="title" width="100" style="font-size: 13px;">状态</td>
					<td>
						<input type="radio" name="status"  checked="checked"  value="ENABLED"  />有效
						<input type="radio" name="status" value="DISABLED" />无效
					</td>
				</tr>
				<tr>
					<td class="title" width="100">描述</td>
					<td><textarea name="description" name="description"></textarea></td>
				</tr>
				<tr>
					<td align="center" valign="middle" colspan="3">
						<input type="submit" value="提交" class="submit"> 
						<input type="button" value="取消" class="blue_mod_btn"	onclick="parent.closeDialog('addPackageDialog');" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>