/**
 * 
 */

// 获取应用类型
$(function(){
	$.post(postPath+'/appType/getAppType', function(datas) {
		if (datas != null) {
			var option = "<option></option>";
			$.each(datas, function(i) {
				if($("#appTypeId").val()==datas[i].id){
					option += "<option value='"+datas[i].id+"' selected >"+datas[i].name+"</option>";
				}else{
					option += "<option value='"+datas[i].id+"'>"+datas[i].name+"</option>";
				}
			});
			$("#appType").html(option);
		}
	}, 'json');
	
	// 查询APK应用是否有效
	$("#appType").change(function(){
		$.get(postPath + "/appType/searchAppTypeIsPass", {
			appTypeId : $('#appType').val()
		}, function(data) {
			if (data == "DISABLED") {
				$("#promptType").html(" 该包已经失效,请选择其它安装包！");
				$('#appType').val("");
			} else{
				$("#promptType").text("");
			}
		});
	});
	
	//  该名称已经存在
/*	$("#appName").blur(function(){
		if($("#appName").val() != null){
			$.get(postPath + "/appInfo/searchAppByName", {
				appName : $('#appName').val()
			}, function(data) {
				if (data == "exist") {
					$("#promptName").html("该名称已经存在！");
					$("#appName").focus();
				} else {
					$("#promptName").text("");
				}
			});
		}
	});*/
	
	

});

