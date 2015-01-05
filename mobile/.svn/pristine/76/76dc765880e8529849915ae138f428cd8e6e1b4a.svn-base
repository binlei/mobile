/**
 * 获取权限name
 */

$(function() {
	// 检索 app 是否存在
	$('#appId').change(function() {
		$("#prompt").html(" ");
		if($('#appId').val() != ""){
			$.get(postPath + "/appPackageInfoDetail/searchRepAppInfo", {
					appInfoId : $('#appId').val(),
					appPackageId : '${appPkgId}'
				}, function(data) {
					if (data == "DISABLED") {
						$("#prompt").html(" APK 未通过审核！");
						$("#tableAis").attr("disabled","disabled");
					}else if(data == "ENABLED"){
						$("#prompt").html(" APK 已存在！");
						$("#tableAis").attr("disabled","disabled");
					}else{
						$("#tableAis").removeAttr("disabled");
					}
			});
		}else{
			$("#tableAis").attr("disabled","disabled");
		}
	});

	// 添加apk 至 应用包
	$("#tableAis").click(function() {
		$.post(postPath + "/appPackageInfo/addDetail", {
			appInfoId : $('#appId').val(),
			appPackageId : $('#appPackageId').val()
		}, function(data) {
			if(data=="successed"){
				$("#ais").datagrid("reload");
				$("#win").window("close");
			}else{
				$.messager.alert("提示", "操作失败！","error");
			}
		});
	});
});
