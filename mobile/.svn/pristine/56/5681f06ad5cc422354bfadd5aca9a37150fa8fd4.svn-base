<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="ico/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/nav.css">
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/staticNav.js"></script>
<script type="text/javascript">
	//显示数据
	function showData(type) {
		navCss(type);
		$("#main").children().remove();
		var content = "<iframe frameborder='0' width='100%' height='700px' src='${pageContext.request.contextPath}/appUsage/"+type+"Popular'></iframe>";
		$("#main").html(content);
	}
</script>

</head>
<body style="overflow: auto">
	<div class="content">
		<div class="top"></div>
		<div class="navigation">
			<div class="nav_logo"></div>
			<div class="nav">
				<ul id="navMenu">
					<li><a href="javascript:showData('day');" target=""><strong class="dayText">日度数据</strong></a></li>
					<li><a href="javascript:showData('month');" target=""><strong class="monthText" style="color: red;">月度数据</strong></a></li>
					<li><a href="javascript:showData('season');" target=""><strong class="seasonText">季度数据</strong></a></li>
					<li><a href="javascript:showData('year');" target=""><strong class="yearText">年度数据</strong></a></li>
				</ul>
			</div>
		</div>
		<div id="main" class="main">
			<iframe frameborder="0" width="100%" height="700px" src="${pageContext.request.contextPath}/appUsage/monthPopular"></iframe>
		</div>
	</div>
</body>
</html>
