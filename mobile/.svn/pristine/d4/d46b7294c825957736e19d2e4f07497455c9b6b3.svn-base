<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="appPgkInfo" value="appPackageInfo"></c:set>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appPackageTypeUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/organizationUtil.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/appInfoUtil.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/format.js"></script>
<script type="text/javascript">
    function queryPkg(){
    	$('#ais').datagrid({
        	url:'${pageContext.request.contextPath}/appPackageInfo/${appPkgId }/queryAppInfo',
        	method:'post',
    		fit:true,
    		autoRowHeight:true,
    		striped: true,
    		fitColumns:true,
    		singleSelect:true,
    		rownumbers: true,//显示行数 1，2，3，4...			  
    		pagination : true,//显示最下端的分页工具栏	
        	pageSize:50,
        	pageList:[35,50,80,100],
        	columns:[[
					{field:'id',title:'ID',width:40,hidden:true},
					{field:'name',sortable:true,title:'应用名称',width:100,formatter:format_img},
					{field:'fileSize',title:'文件大小(MB)',width:100,sortable:true,formatter:format_showM},
					{field:'status',title:'文件状态',width:100,sortable:true,formatter:format_audited}]],
			toolbar:[{
            	text:'返回',
            	iconCls:'icon-undo',
            	handler:function(){
            		window.location.href=postPath+"/appPackageInfo/listView";
            	}
            }]
        });    // get the pager of datagrid
    }
</script>
</head>
<body onload="queryPkg();">
	<input type="hidden" value="${appPkgId }" id="appPkgId">
	<div id="ais" style="height: auto;"></div>
</body>
</html>