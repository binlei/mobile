
$(function(){
	// 获取应包用类型
	$.post(postPath+'/appPackageType/getAppPackageType', function(datas) {
		if (datas != null) {
			var option = "<option></option>";
			$.each(datas, function(i) {
				if($("#appPkgTypeId").val()==datas[i].id){
					option += "<option value='"+datas[i].id+"' selected >"+datas[i].name+"</option>";
				}else{
					option += "<option value='"+datas[i].id+"'>"+datas[i].name+"</option>";
				}
			});
			$("#packageTypeName").html(option);  
		}
	}, 'json');
	
	//查询是否有效
	$("#packageTypeName").change(function(){
		$.get(postPath + "/appPackageType/searchPackageTypeNameIsPass", {
			packageTypeName : $('#packageTypeName').val()
		}, function(data) {
			if (data == "DISABLED") {
				$("#promptType").html(" 该包已经失效,请选择其它安装包！");
				$('#packageTypeName').val("");
			} else{
				$("#promptType").text("");
			}
		});
	});

	$("#packageName").blur(function(){
		if($("#packageName").val() != null){
			$.get(postPath + "/appInfo/searchPackageByName", {
				packageName : $('#packageName').val()
			}, function(data) {
				if (data == "exist") {
					$("#promptName").html(" 该名称已经存在！");
					$("#packageName").focus();
				} else {
					$("#promptName").text("");
				}
			});
		}
	});
});

