<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加人员</title>
		<%@ include file="/jsp/common/common.jsp"%>
	</head>
	<body>
	<link rel="stylesheet" href="<%=basePath%>/jsp/admin/css/base.css"	type="text/css" />
		<form id="userAddForm" method="post" novalidate >
			<input type="hidden" name="userId" value="" required="true" />
			<table class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
				<tr>
					<th width="18%">
						登录名称：
					</th>
					<td width="32%">
						<input type="text" name="userName" readonly validType="length[5,20]"
							class="formText easyui-validatebox" value="" required="true" />
						<label class="requireField">
							*
						</label>
					</td>
					<th width="20%">
						真实姓名：
					</th>
					<td width="30%">
						<input type="text" name="realName"
							class="formText width1 easyui-validatebox"
							validType="length[2,20]" value="" required="true" />
						<label class="requireField">
							*
						</label>
					</td>
				</tr>
				<tr>
					<th>
						密码失效日期：
					</th>
					<td>
						<input  id="invalidDate" name="invalidDate" require="true" editable="false" 
							value="" />
						<label class="requireField">
							*
						</label>
					</td>
					<th>
						用户状态：
					</th>
					<td>
						<select id="status" name="status" panelHeight="80"  required="true" style="width: 100px;">
							<option value="0">正常</option>
							<option value="1">停用</option>
							<option value="2">锁定</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						邮箱：
					</th>
					<td>
						<input type="text" name="email"
							class="formText easyui-validatebox" value="" required="true"
							validType="email" />
						<label class="requireField">
							*
						</label>
					</td>
					<th>
						允许登录错误次数：
					</th>
					<td>
						<input type="text" name="maxLoginCount" min="5" max="20"
							class="formText width1 easyui-numberbox" required="true" value=""
							title="最小值为5,最大值为20" />
						<label class="requireField">
							*
						</label>
					</td>
				</tr>
				<tr>
					<th>
						手机号码：
					</th>
					<td>
						<input type="text" name="mobileNo" class="formText" value="" />
					</td>
					<th>
						联系电话：
					</th>
					<td>
						<input type="text" name="phoneNo" class="formText" value="" />
					</td>
				</tr>
				<tr>
					<th>
						错误登录次数：
					</th>
					<td>
						<input type="text" readonly name="errLoginCount" class="formText" value="" />
					</td>
					<th>
						最后登录ip：
					</th>
					<td>
						<input type="text" readonly name="lastIp" class="formText" value="" />
					</td>
				</tr>

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
				<tr>
					<th>
						所属机构：
					</th>
					<td>
						<input type="text" name="orgId" class="formText" value="" />
					</td>
					<th>
						所属部门：
					</th>
					<td>
						<input type="text" name="deptId" class="formText" value="" />
					</td>
				</tr>
				<tr>
					<th>
						备注：
					</th>
					<td colspan="4">
						<textarea name="remark" rows="3" class="easyui-validatebox"
							validType="length[0,250]" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<center> 
							<a href="#" id="saveUser_btn" class="easyui-linkbutton" onclick="saveUser()">保存</a>
							<a href="#" class="easyui-linkbutton" onclick="closeWindow()">关闭</a>
						</center>
					</td>
				</tr>
			</table>
		</form>
		
<script type="text/javascript">

 $('#invalidDate').datebox({   
  });  

   function closeWindow(){
         $('#sysUserWindow').window('close');
   }
   function saveUser(){
        var r = $("#userAddForm").form('validate');
			if(!r) {
				return false;
		     }   
	
   	   $.post("<%=basePath%>/sys/updateSysUser.do",$("#userAddForm").serializeArray(),function(data){
				$('#sysUserWindow').window('close');
				$('#userTable').datagrid('reload');  
				$.messager.alert('提示',data.msg,'info');
	  });
   }
   
   $("#status").combobox({
	    editable:false,
	   	valueField:'id',
	   	textField:'text'
   });
   
</script>
	</body>
</html>