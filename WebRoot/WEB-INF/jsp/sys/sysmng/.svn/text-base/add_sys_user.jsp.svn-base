<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加人员</title>
		<%@ include file="/jsp/common/common.jsp"%>
	</head>
	<body>
		<link rel="stylesheet" href="<%=basePath%>/jsp/admin/css/base.css"	type="text/css" />
		<form id="userAddForm" method="post" novalidate  >
		
			<table class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
				
				<tr>
					<th width="13%">
						登录名称：
					</th>
					<td width="35%">
						<input type="text" name="userName" id="userName" validType="loginName[5,20,'<%=basePath%>/sys/checkUserName.do','userName']"
							class="formText easyui-validatebox" value="" required="true" />
						<label class="requireField">
							*
						</label>
					</td>
					<th width="20%">
						真实姓名：
					</th>
					<td width="32%">
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
						密码：
					</th>
					<td>
						<input type="text" required="true" name="password"
							class="formText easyui-validatebox" validType="length[6,20]"
							value="123456" title="默认：123456" />
						<label class="requireField">
							*
						</label>
					</td>
					<th>
						用户状态：
					</th>
					<td>
						<select id="status" name="status" panelHeight="80"
							class="easyui-combobox" required="true" style="width: 100px;">
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
							class="formText width1 easyui-numberbox" required="true"
							value="5" title="最小值为5,最大值为20" />
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
						<input type="text" name="mobilelNo" class="formText" value="" />
					</td>
					<th>
						联系电话：
					</th>
					<td>
						<input type="text" name="phoneNo" id="phoneNo" class="formText" value="" />
					</td>
				</tr>
				<tr>
					<th>
						所属机构：
					</th>
					<td>
						<input type="text" name="orgId" id="orgId" class="formText" value="" />
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
						<textarea name="remark" rows="2" class="easyui-validatebox"
							validType="length[0,250]" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<center>
							<a href="#" class="easyui-linkbutton" onclick="saveUser()">保存</a>
							<a href="#" class="easyui-linkbutton" onclick="closeWindow()">关闭</a>
						</center>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
   function closeWindow(){
     $('#sysUserWindow').window('close');
   }
   
   
   function err(_d){
	var _e=$(_d);

	var tip=$("<div class=\"validatebox-tip\">"+"<span class=\"validatebox-tip-content\">"+"</span>"+"<span class=\"validatebox-tip-pointer\">"+"</span>"+"</div>").appendTo("body");
	//$.data(_d,"validatebox").tip=tip;
	 
	tip.find(".validatebox-tip-content").html("测试是否正常");
	tip.css({display:"block",left:_e.offset().left+_e.outerWidth(),top:_e.offset().top});
	alert(1);
	
	var tip=$.data(_d,"validatebox").tip;
	tip.remove();
    $.data(_d,"validatebox").tip=null;
};
   
   function saveUser(){
   
   		$('#userName').validatebox({
		   		required:true,
		   		validType:"length[5,20]",invalidMessage:'长度'
   		});
   		
   		$('#userName').validatebox({
		   		required:true,
		   		validType:"remote['<%=basePath%>/sys/checkUserName.do','userName']",
		   		invalidMessage:'该用户名已存在！'
   		});
   		
   		
   		
       var r = $('#userAddForm').form('validate');
			if(!r) {
				return false;
		     }   
      
   	   $.post("<%=basePath%>/sys/addSysUser.do",$("#userAddForm").serializeArray(),function(data){
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