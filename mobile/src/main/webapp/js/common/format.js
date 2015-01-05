//格式化创建人员  @author: jing.huang
function format_creator(value,row,index) {
	if (row.info != null && row.info.creator != null) {
		return row.info.creator;
	} else {
		return "-";
	}
}
//格式化创建时间 @author: jing.huang
function format_createdTime(value,row,index) {
	if (row.info != null && row.info.createdTime != null) {
		return row.info.createdTime;
	} else {
		return "-";
	}
}
//格式化最后操作人员 @author: jing.huang
function format_lastOperator(value,row,index) {
	if (row.info != null && row.info.lastOperator != null) {
		return row.info.lastOperator;
	} else {
		return "-";
	}
}
//格式化最后操作时间 @author: jing.huang
function format_lastOperatedTime(value,row,index) {
	if (row.info != null && row.info.lastOperatedTime != null) {
		return row.info.lastOperatedTime;
	} else {
		return "-";
	}
}


/**
 * @param 格式话显示上级组织名称
 * @returns
 */
function format_parentOrg_name(value, row, index) {
	if (row != null && row.parentOrg != null) {
		return row.parentOrg.name;
	} else {
		return "-";
	}
}

/**
 * @param 组织类型
 * @returns
 */
function format_org(value, row, index) {
	if (row.organization != null) {
		return row.organization.name;
	} else {
		return "-";
	}
}
/**
 * @param user list 组织名称
 * @returns
 */
function format_orgName(value, row, index) {
	if (row != null && row.organization != null) {
		return row.organization.name;
	} else {
		return "-";
	}
}

/**
 * @param 组织
 * @returns
 */
function format_orgType(value, row, index) {
	if (row.type != null) {
		return row.type.name;
	} else {
		return "-";
	}
}



/**
 * @param 格式话管理者联系方式
 * @returns
 */
function format_managerContact_tel(value, row, index) {
	if (row != null && row.managerContact != null) {
		return row.managerContact.tel;
	} else {
		return "-";
	}
}

/**
 * @param value 文件大小
 * @param row
 * @param index
 * @returns {String}
 */
function format_unit(value, row, index){
  return value+"  MB";
}

/**
 * @param app应用类型
 * @returns
 */
function format_appType(value, row, index) {
	if (row != null && row.appType != null) {
		return row.appType.name;
	} else {
		return "-";
	}
}

/**
 * @param app应用包类型
 * @returns
 */
function format_appPackageType(value, row, index) {
	if (row != null && row.appPackageType != null) {
		return row.appPackageType.name;
	} else {
		return "-";
	}
}

function format_appPackageTypeOrg(value, row, index) {
	if (row != null && row.appPackageType != null) {
		return row.appPackageType.organization.name;
	} else {
		return "-";
	}
}

/**
 * @param 状态
 * @returns {String}
 */
function format_enabled(value, row, index) {
	if (value) {
		return "有效";
	} else {
		return "<span style='color:red;'>无效</span>";
	}
}

/**
 * @param value
 * @param row 状态
 * @param index
 * @returns {String}
 */
function format_installStatus(value,row,index){
	if(value>0){
		return "成功";
	}else{
		return "<span style='color:red;'>失败</span>";
	}
}
function format_installLog(value,row,index){
	return "成功";
}

/**
 * @param  状态
 * @returns {String}
 */
function format_status(value, row, index) {
	if (row.status == 'ENABLED') {
		return "有效";
	} else {
		return "<span style='color:red;'>无效</span>";
	}
}

/** 
 * @param 显示图片
 * @param {} row
 * @param {} index
 */
function format_img(value, row, index){
	var imgName = "<span style='margin-top: 330px;height:auto;'>"+row.name+"</span>";
/*	return "<img src='D:/home/yuanlianghe/storage/mobile_apks"+ row.icoPath +"' />"+row.name;*/
	return "<img src='"+row.icoPath+"' width='20px' height='20px' />"+imgName;
}

/**
 * @param 操作
 * @returns {String}
 */
function format_oper(value,row, index) {
//	var download = "<img src='../../images/download.png' alt='下载' onclick='downloadFile("+ row.filePath +")' /> ";
	var download = "<a href='"+postPath+"/appInfo/downloadFile?fileName="+row.fileName+"&filePath="+row.filePath+"'><img src='"+postPath+"/images/download.png' alt='下载' /> </a>";
	var del = " <img src='"+postPath+"/images/cross.png' alt='移除' onclick='rem("+row.id+");' />";
	return del + download;
}

/**
 * @param 操作
 * @returns {String}
 */
function format_yesOrNo(value,rowData, index) {
	var aisData = $("#ais").datagrid("getData");
	var appId = rowData.id;
	for (var i = 0; i < aisData.total; i++) {
		if(aisData.rows[i].id == appId){
			return "<input type='button' style='background:#00ff00' disabled='disabled' value='已添加' />";
		}else{
			if(rowData.status == 'DISABLED'){
				return "<input type='button' style='background:#D10B0B' disabled='disabled' value='未审核' />";
			}
		}
	}
	return "<input type='button' value='未添加' onclick='addApkInPkg(this,"+appId+")' />";
}

/**
 * 下载文件
 * @param sourceFile
 * @param targetFileNm
 */
function downloadFile(downloadFile){
	downloadFile =encodeURI(encodeURI(downloadFile));
	window.open(postPath+"/appInfo/downloadFile/"+downloadFile);
}


function format_showM(value, rec, index) {
	return "<span>" + value + "(MB)</span>";
}

/**
 * @param  组织父
 * @returns
 */
function parentPermissionId(value, row, index) {
	if (row != null && row.parentPermission != null) {
		return row.parentPermission.name;
	}
	return "-";
}

/**
 * @param 格式化显示最后一次密码
 * @returns
 */
function format_lastPwd(value, row) {
	if (row != null) {
		return row.info.lastPwd;
	} else {
		return "-";
	}
}

/**
 * @param 最后一次修改密码时间
 * @returns
 */
function format_lastPwdTime(value, row) {
	if (row != null) {
		return row.info.lastMdPwdTime;
	} else {
		return "-";
	}
}

/**
 * @param 格式化创建时间
 * @returns
 */
function format_createTime(value, row) {
	if (row != null) {
		return row.info.createdTime;
	} else {
		return "-";
	}
}

function format_showShorCut(value, row, index) {
	if (row.showShorCut) {
		return "显示";
	} else {
		return "不显示";
	}
}

/**
 * @param 格式话显示邮箱
 * @returns
 */
function format_email(value, row, index) {
	if (row != null && row.contact != null) {
		return row.contact.email;
	} else {
		return "-";
	}
}

/**
 * @param 电话
 * @returns
 */
function format_tel(value, row, index) {
	if (row != null && row.contact != null) {
		return row.contact.tel;
	} else {
		return "-";
	}
}

/**
 * @param 手机
 * @returns
 */
function format_mobile(value, row, index) {
	if (row != null && row.contact != null) {
		return row.contact.mobile;
	} else {
		return "-";
	}
}

/**
 * description:格式化QQ
 * @param 
 * @returns
 */
function format_qq(value, row, index) {
	if (row != null && row.contact != null) {
		return row.contact.qq;
	} else {
		return "-";
	}
}

/**
 * @param 性别
 * @returns {String}
 */
function format_sex(value, row, index) {
	if (row != null && row.contact != null) {
		if (row.contact.sex == 1) {
			return "男";
		} else {
			return "女";
		}
	} else {
		return "-";
	}
}

/**
 * @param 审核
 * @returns {String}
 */
function format_audited(value, row, index){
	if (row.status == 'ENABLED') {
		return "审核通过";
	} else {
		return "<span style='color:red;'>未审核</span>";
	}
}

/**
 * @param appId
 * @param packageId
 * @param 根据 id 移除
 */
function rem(apkId){  //删除操作  
    $.messager.confirm('确认','确认移除?',function(row){  
        if(row){  
            $.ajax({  
                url:postPath+"/appPackageInfo/"+$("#appPkgId").val()+"/"+apkId+"/deleteDetail",    
                type:"post",
                success:function(data){
                	if(data=="successed"){
                		$("#ais").datagrid("reload");
                	}else{
                		$.messager.alert("提示！", "操作失败！");
                	}
                }  
            });  
        }  
    });
  }  
