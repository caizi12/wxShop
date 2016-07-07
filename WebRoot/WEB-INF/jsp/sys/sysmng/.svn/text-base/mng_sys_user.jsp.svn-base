<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<script>
	 
  $(function(){
			var lastIndex;
			$('#userTable').datagrid({
				url:'<%=basePath%>/sys/querySysUser.do',
				fitColumns:true,
				pagination:true,
				singleSelect:false,
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				toolbar:[{
					text:'查看',
					iconCls:'icon-search',
					handler:function(){
					   var rows = $('#userTable').datagrid('getSelections');
					   if(rows.length!=1){
						  $.messager.alert('提示','请选择一条数据！','info');
						  return;
						}
					   viewSysUser(rows[0]);
					}
				},'-',{
					text:'添加',
					iconCls:'icon-add',
					handler:function(){ 
					showWindow();
					}
				  },'-',{
					text:'编辑',
					iconCls:'icon-edit',
					handler:function(){
						editSysUser();
					}
				},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						 batchDelSysUser();
					}
				}],
				onDblClickRow:function(rowIndex,row){
				  viewSysUser(row);
				}
			});
		  }
		);
		
 function viewSysUser(row){
   $("#sysUserWindow").window({
  			title:'查看用户信息',
  			href:'<%=basePath%>/sys/viewSysUser_page.do?type=view',
  			width:600,
  			height:400,
  			onLoad: function(){
  				$('#userAddForm').form('load',row);
  				disableForm("userAddForm",true);
  				$('#saveUser_btn').css("display","none");
  			}}
  	);
 }		
 		
 function editSysUser(){
   var rows = $('#userTable').datagrid('getSelections');
   if(rows.length!=1){
	  $.messager.alert('提示','请选择一条数据！','info');
	  return;
	}
	
   $("#sysUserWindow").window({
  			title:'编辑用户信息',
  			href:'<%=basePath%>/sys/viewSysUser_page.do?type=update',
  			width:600,
  			height:400,
  			onLoad: function(){
  				$('#userAddForm').form('load',rows[0]);
  				disableForm("userAddForm",false);
  			}}
  	);
 }		
 

 function batchDelSysUser(){
    var rows = $('#userTable').datagrid('getSelections');
	if(rows.length<=0){
	  $.messager.alert('提示','请选择要删除的数据！','info');
	  return;
	}
	$.messager.confirm('提示', '确定删除吗?', function(r){
		if (r){
		 	var ids = "";
		    $.each(rows,function(i,r){
		      		if(i==0) 
		      			ids += "?userId="+r.userId;
		      		else
		      			ids += "&userId="+r.userId;
		     });
		     $.post('<%=basePath%>/sys/batchDelSysUser.do'+ids,function(data){
		        $('#userTable').datagrid('reload'); 
			    $.messager.alert('提示',data.msg,'info');
		     });
		 }
		});
   }

 function showWindow(){
      $("#sysUserWindow").window({
  			title:'添加用户',
  			href:'<%=basePath%>/sys/addSysUser_page.do',
  			width:600,
  			height:300,
  			onLoad: function(){
  				$('#userForm').form('clear');
  			}
  		   }
  	  );
  }

	   var status = [
		    {statusid:0,name:'正常'},
		    {statusid:1,name:'停用'},
		    {statusid:2,name:'锁定'}
		];
		  function statusFormatter(value){
			for(var i=0; i<status.length; i++){
				if (status[i].statusid == value) return status[i].name;
			}
			return value;
		}
	</script>
	</head>
	<body>
		<div class="page_title">
			用户管理
		</div>
		<table id="userTable" style="width: auto; height: auto;" title="用户列表"
			iconCls="icon-edit">

			<thead>
				<tr>
					<th field="userId" width="10%">
						编号
					</th>
					<th field="userName" width="10%">
						登录名称
					</th>
					<th field="realName" width="15%" align="center">
						真实姓名
					</th>
					<th field="email" width="15%" align="center">
						邮箱
					</th>
					<th field="lastLogin" width="15%" align="center">
						最近登录时间
					</th>
					<th field="lastIp" width="10%" align="center">
						最近使用IP
					</th>
					<th field="status" width="6%" align="center"
						formatter="statusFormatter"
						editor="{type:'combobox',options:{valueField:'statusid',textField:'name',data:status,required:true,editable:false,panelHeight:60}}">
						状态
					</th>
				</tr>
			</thead>
		</table>

		<div id="sysUserWindow" modal="true" shadow="false" minimizable="false"
			cache="false" maximizable="false" collapsible="false"
			resizable="false" style="margin: 0px; padding: 0px; overflow: auto;"></div>

	</body>
</html>