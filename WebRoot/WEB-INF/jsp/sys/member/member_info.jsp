<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>添加人员</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<%@ include file="/jsp/easyui-validate.jsp"%>
			<link rel="stylesheet" href="${ctx}/jsp/admin/css/base.css" type="text/css" />
	</head>
	<body>
	
		<form id="dataForm" method="post" novalidate>
			<input type="hidden" name="memberId" value="${dataMap.memberInfo.memberId}"  />
			<table class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
				<tr>
					<th width="17%">
						登录手册号：
					</th>
					<td width="33%">
					    <input type="text" name="mobileNo" invalidMessage="请输入正确的11位的手机号" id="mobileNo" class="formText easyui-numberbox" readonly validType="mobile"  maxlength="11" value="${dataMap.memberInfo.mobileNo}" required="true" />
						<label class="requireField">
							*
						</label>
					</td>
					<th width="20%">
						登录用户名：
					</th>
					<td width="30%">
						<input type="text" name="userName" title="登录用户名不能重复，&#13可使用公司或个人名称全拼" class="formText  easyui-validatebox" validType="length[6,20]"	value="${dataMap.memberInfo.userName}" required="true" />
						<label class="requireField">
							*
						</label>
					</td>
				</tr>
				<tr>
					<th width="17%">
						登录密码：
					</th>
					<td width="33%">
					    <input type="password" name="password" id="password" readonly  class="formText easyui-validatebox" title="后台新增的用户默认密码为666888" value="${dataMap.memberInfo.password}"  />
					</td>
					<th width="20%">
						公司/个人名称：
					</th>
					<td width="30%">
						<input type="text" name="realName" class="formText  easyui-validatebox" required="true" validType="length[2,20]"	value="${dataMap.memberInfo.realName}"  />
						<label class="requireField">
							*
						</label>
					</td>
				</tr>
				<tr>
					<th width="17%">
						会员类型：
					</th>
					<td width="33%">
					    <input type="text" name="memberTypeSelect" id="memberTypeSelect" readonly value="${dataMap.memberInfo.memberType}"  />
					</td>
					<th width="20%">
						可用积分：
					</th>
					<td width="30%">
					<c:if test="${dataMap.viewType == 'add'}">
					<input type="text" name="canPoint" class="formText" title="新用户送500积分" readonly	value="500"  />
					</c:if>
					
					<c:if test="${dataMap.viewType != 'add'}">
					  <input type="text" name="canPoint" class="formText"  readonly	value="${dataMap.memberInfo.canPoint}"  />
					</c:if>
					</td>
				</tr>
				<tr>
					<th>
						出生日期：
					</th>
					<td>
						<input id="birthday" name="birthday"   editable="false" 	value="${dataMap.memberInfo.birthday }" />
					</td>
					<th>
						性别：
					</th>
					<td>
						<input value="${dataMap.memberInfo.sex}" type="text" id="sexSelect" name="sexSelect" />
					</td>
				</tr>
				<tr>
					<th>
						推广人会员编号：
					</th>
					<td>
						<input id="recomendId" name="recomendId"  maxLength="10"  class="formText easyui-validatebox" validType="number" editable="false"
							value="${dataMap.memberInfo.recomendId}"  />
					</td>
					<th>
						用户状态：
					</th>
					<td>
						<input value="${dataMap.memberInfo.status}" type="text" id="statusSelect" name="statusSelect" />
						 <input  type="hidden" id="status" value="${dataMap.memberInfo.status}" name="status" />	<label class="requireField">
							*
						</label>
					</td>
				</tr>
				<tr>
					<th>
						邮箱：
					</th>
					<td>
						<input type="text" name="email" class="formText easyui-validatebox" value="${dataMap.memberInfo.email }" 
							validType="email" />
						<label class="requireField">
							*
						</label>
					</td>
				 <th>
						其它联系电话：
					</th>
					<td>
						<input type="text" name="phoneNo" class="formText" value="${dataMap.memberInfo.phoneNo }" />
					</td>
				</tr>
				<tr>
					<th>
						地址：
					</th>
					<td>
						<input type="text" name="address" class="formText" value="${dataMap.memberInfo.address }" 
							 address />
						 
					</td>
				 <th>
						邮编：
					</th>
					<td>
						<input type="text" name="postCode"  maxLength="6"  class="formText " value="${dataMap.memberInfo.postCode }" />
					</td>
				</tr>
				<tr>
					<th>
						注册日期：
					</th>
					<td>
						<input type="text" name="createTime" class="formText" value="<fmt:formatDate value="${dataMap.memberInfo.createTime }" pattern="yyyy-MM-dd"/>"  />
					</td>
					
				</tr>
				 
				<!--
				<tr>
					<th>
						最后登录时间：
					</th>
					<td>
						<input type="text" disabled name="lastLogin" readonly class="formText"
							value="" />
					</td>
					<th>
						解锁时间：
					</th>
					<td>
						<input type="text" name="unlockTime" class="formText" value="" />
					</td>
				</tr>
				 
				  -->
				<tr>
					<th>
						备注：
					</th>
					<td colspan="4">
						<textarea name="remark"  rows="3" class="easyui-validatebox" validType="length[0,250]" cols="40">${dataMap.memberInfo.remark }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<center> 
						   	<button class="liger-button l-button" id="saveBtn" type="button" onclick="updateMemberInfo()">
								保存
							</button>
							<button class="liger-button l-button"  id="closeBtn" type="button" onclick="closeWin()">
								关闭
							</button>
						</center>
					</td>
				</tr>
			</table>
		
		</form>

		<script type="text/javascript">
  $(function(){
  	 
  	 var statusSelect= $("#statusSelect").ligerComboBox({
            width : 100,
            valueFieldID:"status",
            url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=userStatus',
            cancelable: true,
            valueField : 'dictValue',
            textField: 'dictName'
		 });
	 statusSelect.setValue('${dataMap.memberInfo.status}');
	 
 	 var sexSelect= $("#sexSelect").ligerComboBox({
           width : 100,
           valueFieldID:"sex",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=sex',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
	 });	 
  	  sexSelect.setValue('${dataMap.memberInfo.sex}');
  	  
  	 var memberTypeSelect= $("#memberTypeSelect").ligerComboBox({
           width : 100,
           valueFieldID:"memberType",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=memberType',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
	 });	 
  	  memberTypeSelect.setValue('${dataMap.memberInfo.memberType}');
  	  
    $("#birthday").ligerDateEditor({format: "yyyy-MM-dd",initValue: '${dataMap.memberInfo.birthday }'});
    
     if("${dataMap.viewType}"=="view"){
    	disableForm("dataForm",'disable');
        $("#saveBtn").remove();
   	 }else if("${dataMap.viewType}"=="add"){
  	   $("#userName").removeAttr("readonly");
  	   	$('#mobileNo').removeAttr("readonly");
   	 	$('#mobileNo').validatebox({
	 	   		required:true,
	    		validType:"remote['${ctx}/sys/checkMemberMobileNo.do','mobileNo']",
	 	   		invalidMessage:'该手机号已存在！'
    	});
  	}
  });
  


  function updateMemberInfo(){
        var r = $("#dataForm").form('validate');
  
        if( $("#birthday").ligerGetDateEditorManager().getValue().length<10){
          $.ligerDialog.warn("请输入正确的密码失效日期");return;
        }
		if(!r) {
			return false;
	     }   
	   
   	   $.post("${ctx}/sys/updateMemberInfo.do?viewType=${dataMap.viewType}",$("#dataForm").serializeArray(),function(data){
   	   			if(data.result=="true"){
   	   				$.ligerDialog.success(data.msg,function(){
   	   				   closeWin();
   	   				});
   	   			 }else{
   	   			   $.ligerDialog.error(data.msg);
   	   			 }
	  });
   }

function closeWin(){
	window.parent.$.ligerDialog.hide(); 
	window.parent.queryMemberInfo();  
}
 
   
</script>
	</body>
</html>