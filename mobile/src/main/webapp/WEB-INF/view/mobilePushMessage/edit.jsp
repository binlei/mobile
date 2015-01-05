<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
<!--
//重置表单
	function resetForm() {
		$('#commentForm').form('reset');
	}
//保存
	function saveMessagee() {
		var vldate = $('#commentForm').form('validate');
		if(vldate) {
			$.ajax({
				url:'edit',
				method:'post',
				data:$("#commentForm").serialize(),
				dataType : 'text',
				success : function(data){
					if(data == "successed"){
						$(".msg").html("<b style='padding-left:10px;color:blue;'>操作成功!</b>");
					}else if(data == "defeated") {
						$(".msg").html("<b style='padding-left:10px;color:red;'>系统错误！请联系管理员。</b>");
					}
				}
			});
		} else {
			$.messager.alert("提示", "表单信息填写不完整，带<font color='red'>*</font>为必填项！","info");
		}
	}
//-->
</script>
<form class="cmxform" id="commentForm">
		<input type="hidden" name="id" value="${mobilePushMessage.id }"/>
		<table class="table_border" border="1" width="600px" height="300px">
					<tr>
						<td class="title" >消息主题
						</td>
						<td>
							<input name="extendProp2" id="extendProp2" value="${mobilePushMessage.extendProp2 }"/>
						</td>
						<td class="title" ><font color="red">*&nbsp;</font>处理类型
						</td>
						<td>
							<select name="dealType" class="easyui-validatebox" data-options="required:true" missingMessage="该项为必填项"> 
								<option value=""></option>  
							    <option value="1" <c:if test='${mobilePushMessage.dealType == 1}'>selected='selected'</c:if>>文件下载或打开网页</option>   
							    <option value="2" <c:if test='${mobilePushMessage.dealType == 2}'>selected='selected'</c:if>>广告处理</option>   							      
							    <option value="3" <c:if test='${mobilePushMessage.dealType == 3}'>selected='selected'</c:if>>应用激活</option>   							      
							    <option value="4" <c:if test='${mobilePushMessage.dealType == 4}'>selected='selected'</c:if>>通知并隐式激活</option>   							      
							</select>
						</td>
					</tr>
					<tr>
						<td class="title" >通知标题
						</td>
						<td>
							<input name="notiTitle" id="notiTitle" value="${mobilePushMessage.notiTitle }"/>
						</td>
						<td class="title" >通知内容
						</td>
						<td>
							<input name="notiContent" id="notiContent" value="${mobilePushMessage.notiContent }"/>
						</td>
					</tr>
					<tr>
						<td class="title" >通知图片
						</td>
						<td>
							<input name="notiImgUrl" id="notiImgUrl" value="${mobilePushMessage.notiImgUrl }"/>
						</td>
						<td class="title" ><font color="red">*&nbsp;</font>打开网页类型
						</td>
						<td>
							<select name="openType" class="easyui-validatebox" data-options="required:true" missingMessage="该项为必填项"> 
								<option value=""></option>  
							    <option value="1" <c:if test="${mobilePushMessage.openType == 1}">selected='selected'</c:if> >浏览器打开</option>   
							    <option value="2" <c:if test="${mobilePushMessage.openType == 2}">selected='selected'</c:if> >微信打开</option>   							      
							</select>
						</td>
					</tr>
					<tr>
						<td class="title" >网络地址
						</td>
						<td>
							<input name="netUrl" id="netUrl" value="${mobilePushMessage.netUrl }"/>
						</td>
						<td class="title" >文件下载地址
						</td>
						<td>
							<input name="notiFileUrl" id="notiFileUrl" value="${mobilePushMessage.notiFileUrl }"/>
						</td>
					</tr>
					<tr>
						<td class="title" >激活包包名
						</td>
						<td>
							<input name="packageName" id="packageName" value="${mobilePushMessage.packageName }"/>
						</td>
						<td class="title" >APP名称
						</td>
						<td>
							<input name="extendProp1" id="extendProp1" value="${mobilePushMessage.extendProp1 }"/>
						</td>
					</tr>
					<tr>
						<td class="title" >上报周期调整
						</td>
						<td>
							<input name="extendsData1" id="extendsData1" value="${mobilePushMessage.extendsData1 }"/>
						</td>
						<td class="title" >应用激活次数
						</td>
						<td>
							<input name="extendsData2" id="extendsData2" value="${mobilePushMessage.extendsData2 }"/>
						</td>
					</tr>
					<tr>
						<td align="center" valign="middle" colspan="4">
						<a href="javascript:void(0)" class="easyui-linkbutton"onclick="saveMessagee();">保存</a>
						<!-- &nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"onclick="resetForm();">重置</a> -->
						</td>
					</tr>
				</table>
</form>
<div class="msg" style="width:100%;height:20px;position:absolute;bottom:0;background-color:#E9F4F7;">
</div>