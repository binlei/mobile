<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<style type="text/css">
	td {
		text-align:left;
	}
	.no {
		text-align:center;
	}
</style>
</head>

<body>
	<div id="mobileBasicInfo">
			<fieldset style="width: 1100px; margin: 0 auto;">
				<legend><strong><font color="blue"> 手机基本信息  </font></strong></legend>
				<table cellpadding="0" cellspacing="0" border="1" class="table_border"
					align="center" style="width: 1100px;">
					<tr>
						<th>IMEI</th>
						<td>${mobileBasicInfo.imei}</td>
						<th>设备MAC</th>
						<td>${mobileBasicInfo.mac}</td>
						<th>设备品牌</th>
						<td>${mobileBasicInfo.productionId}</td>
						<th>设备内核</th>
						<td>${mobileBasicInfo.kernel}</td>
					</tr>
					<tr>
						<th>设备型号</th>
						<td>${mobileBasicInfo.model}</td>
						<th>版本号</th>
						<td>${mobileBasicInfo.release}</td>
						<th>Android版本号</th>
						<td>${mobileBasicInfo.sdk}</td>
						<th>设备ROM大小</th>
						<td>${mobileBasicInfo.rom}</td>
					</tr>
				</table>
			</fieldset>
	</div>
	<div id="mobileActivatedInfo">
		<fieldset style="width: 1100px; margin: 0 auto;">
			<legend><strong> <font color="blue">APP激活流水 </font></strong></legend>
			<table cellpadding="0" cellspacing="0" border="1" style="width: 1100px; margin: 0 auto;">
				<thead>
					<tr>
						<th>序号</th>
						<th>APP名称</th>
						<th>激活包包名</th>
						<th>激活时间</th>
					</tr>
				</thead>
				<tbody>
					<%int i=1; %>
					<c:forEach items="${listMobileActivatedInfo}"
						var="mobileActivatedInfo">
						<tr>
							<td class="no"><%=i++ %></td>
							<td>${mobileActivatedInfo.appName }</td>
							<td>${mobileActivatedInfo.packageName }</td>
							<td><fmt:formatDate
									value="${mobileActivatedInfo.activatedTime }" type="both" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
	<%-- <div id="mobilePushMessage">
		<fieldset style="width: 1100px; margin: 0 auto;">
			<legend><strong> <font color="blue"> 推送消息流水</font></strong></legend>
			<table cellpadding="0" cellspacing="0" border="1" style="width: 1100px; margin: 0 auto;">
				<thead>
					<tr>
						<th>APP名称</th>
						<th>激活包包名</th>
						<th>激活时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listMobileActivatedInfo}"
						var="mobileActivatedInfo">
						<tr>
							<td>${mobileActivatedInfo.appName }</td>
							<td>${mobileActivatedInfo.packageName }</td>
							<td><fmt:formatDate
									value="${mobileActivatedInfo.activatedTime }" type="both" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div> --%>
</body>

</html>