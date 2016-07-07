<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<%@ include file="/jsp/easyui-validate.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
		<script>
	 
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
		<div id="layout_query">
			<div position="left" title="查询">
				<form id="sysUserForm">
					<table height="450px" class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
							<th width="10%" align="right">
								用户编号：
							</th>
							<td width="17%">
								<input class="formText width1" value="" type="text" title="自动生成" id="userId" name="userId" />
							</td>
							<th width="10%" align="right">
								登录名称：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="userName" name="userName" />

							</td>
							<th width="10%" align="right">
								真实姓名：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="realName" name="realName" />
	
							</td>
						</tr>
						<tr>
							<th align="right">
								用户状态：
							</th>
							<td colspan="5">
								<input  value="" type="text" id="selectStatus" name="selectStatus" />
								<input type="hidden" id="status" name="status" />
							</td>
					
						</tr>
						<tr>
							<td colspan="5" align="center">
								<input id="viewSysUser" class="btn" type="button" value="查 看" />
								<input id="addSysUser" class="btn" type="button" value="新 增" />
								<input id="editSysUser" class="btn" type="button" value="修 改" />
								<input id="delSysUser" class="btn" type="button" value="删 除" />
								<input id="querySysUser" class="btn" type="button" value="查 询" />
								<input id="resetForm" class="btn" type="reset" value="重 置" />
							</td>
							<td>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="layout1">
			<div position="left" title="字典列表">
				<div id="maingrid"></div>
			</div>
		</div>
		<div id="sysUserWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false"
			collapsible="false" resizable="false" style="margin: 0px; padding: 0px; overflow: auto;"></div>
	</body>
	<script type="text/javascript">
  $(function(){
			 f_initGrid();
			 $("#addSysUser").bind("click",addSysUser);
			 $("#editSysUser").bind("click",editSysUser);
			 $("#delSysUser").bind("click",batchDelSysUser);
			 $("#viewSysUser").bind("click",viewSysUser);
			 $("#querySysUser").bind("click",querySysUser);
    });
		
 var sysUserGrid;		
 function querySysUser(){
     var param=$("#sysUserForm").serialize();
     sysUserGrid.loadServerData(param,null);
  }		
 
  function addSysUser(){
       var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getSysUser.do?viewType=add',title:'添加管理用户', width:600,height:350 });
  }
  
 
 function viewSysUser(){
     var rows = sysUserGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return;  return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getSysUser.do?viewType=view&userId='+rows[0].userId,title:'查看用户信息', width:600,height:350
	 });
 }		
 		
 function editSysUser(){
     var rows = sysUserGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getSysUser.do?viewType=update&userId='+rows[0].userId,title:'修改用户信息',showMin: true, width:600,height:350
	 });
	 
 }		
 
 
 function batchDelSysUser(){
    var rows = sysUserGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择数据再删除！'); return; }
	$.ligerDialog.confirm('确定删除吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids += "?userId="+this.userId;
		      		else
		      			ids += "&userId="+this.userId;
		     });
		     $.post('${ctx}/sys/batchDelSysUser.do'+ids,function(data){
		        if(data.result="true"){
		             $.ligerDialog.success('删除成功！');
		               querySysUser(); 
		        }else{
		            $.ligerDialog.error('删除成功！');
		        }
		     });
		 }
		});
   }
   
  $("#resetForm").bind("click",function(){
  	$("#sysUserForm").form('clear');
  	 sysUserGrid.cancelEdit();
  });   

 
 var userStatus =[];
 <c:forEach items="${dictMap.status}" var="status" >
   userStatus=userStatus.concat({"dictValue": "<c:out value="${status.dictValue}"/>","dictName":"<c:out value="${status.dictName}"/>"});
 </c:forEach>	
 	 
  var statusBox= $("#selectStatus").ligerComboBox({
           width : 100,
           valueFieldID:"status",
           data:userStatus,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });

 function f_initGrid()
 { 
         sysUserGrid = $("#maingrid").ligerGrid({
         columns: [
         { display: '编号ID', name: 'userId', width:'6%', type: 'int',frozen:true },
         { display: '登录名称', name: 'userName',width:'12%'},
         { display: '真实姓名', name: 'realName',width:'12%'},
         { display: '邮箱', name: 'email', width: '12%', type: 'int'},
         { display: '手机号码', width: '9%', name: 'mobileNo',type:'int'},
         { display: '其它联系电话', name: 'phoneNo', width: '10%'},
         { display: '状态', name: 'status', width: '6%', render: function (item)
             {    
                for(var i=0;i<userStatus.length;i++){
                 if (userStatus[i].dictValue==item.status)
                    return userStatus[i].dictName;
                 }
             } }
         
         ],
         onSelectRow: function (rowdata, rowindex)
         {
             $("#txtrowindex").val(rowindex);
         },
         enabledEdit: true, 
         clickToEdit: true, isScroll: false,  
         url:'${ctx}/sys/querySysUser.do',
         width: '100%',
         delayLoad:false,
         height:'100%',
         pageSize:10,
         checkbox:true,
         allowAdjustColWidth:true
     });   
 }	  

</script>

</html>