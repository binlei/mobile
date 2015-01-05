<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<script type="text/javascript">
	function query() {
		var imei = $.trim($("#imei").val());
		if(!imei) {
			alert("请先输入设备IMEI...");
		} else {
			$("#result")[0].src = '${pageContext.request.contextPath}'+'/baseMobile/mobileBasicInfo/'+imei;
			$("#main").show();
		}
	}
</script>

</head>
<body class="easyui-layout" style="width:100%;height:100%;">
  	<!-- 查询表单 -->
		<div class="Search-box" region="north" title="查询条件" style="height:100px;">
			<form id="srchForm" class="frmSearch" action="" autocomplete='off'>
				<table class="tableForm datagrid-toolbar"  align="center" style="width:500px;">
					<tr>
						<th>设备IMEI</th>
						<td><input id="imei" name="imei"/></td>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton"onclick="query()">查询</a>&nbsp;&nbsp;&nbsp;
							<!-- <a href="javascript:void(0)" class="easyui-linkbutton"onclick="sy.cleanSearch()">重置</a> -->
						</td>
					</tr>
				</table>
			</form>
		</div>

	<div  region="center" >
		<div id="main" style="display: none;width: 100%;height: 100%;">
			<iframe scrolling="auto" id='result' name="result" frameborder="0" src="" style="width: 100%; height: 98%;"></iframe>
		</div>
	</div>
</body>
</html>
