<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>商城用户管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<%@ include file="/jsp/easyui-validate.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
	</head>
	<body>
		<div id="layout_query">
			<div position="left" title="查询">
				<form id="memberInfoForm">
					<table height="450px" class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
							<th width="10%" align="right">
								用户编号：
							</th>
							<td width="17%">
								<input class="formText width1" value="" type="text"  id="memberId" name="memberId" />
							</td>
							<th width="10%" align="right">
								登录手机号：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="mobileNo" name="mobileNo" />

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
								<input id="viewMemberInfo" class="btn" type="button" value="查 看" />
								<input id="addMemberInfo" style="" class="btn" type="button" value="新 增" />
								<input id="editMemberInfo" class="btn" type="button" value="修 改" />
								<input id="delMemberInfo" class="btn" type="button" value="删 除" />
								<input id="queryMemberInfo" class="btn" type="button" value="查 询" />
								<input id="resetForm" class="btn" type="reset" value="重 置" />
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
		<div id="memberInfoWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false"
			collapsible="false" resizable="false" style="margin: 0px; padding: 0px; overflow: auto;"></div>
	</body>
	<script type="text/javascript">
  $(function(){
			 f_initGrid();
			 $("#addMemberInfo").bind("click",addMemberInfo);
			 $("#editMemberInfo").bind("click",editMemberInfo);
			 $("#delMemberInfo").bind("click",batchDelMemberInfo);
			 $("#viewMemberInfo").bind("click",viewMemberInfo);
			 $("#queryMemberInfo").bind("click",queryMemberInfo);
			 $("#resetLoginPass").bind("click",resetLoginPass);
			 
    });
		
 var memberInfoGrid;		
 function queryMemberInfo(){
     var param=$("#memberInfoForm").serialize();
     memberInfoGrid.loadServerData(param,null);
  }		
 
  function addMemberInfo(){
       var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getMemberInfo.do?viewType=add',title:'添加管理用户', width:650,height:440 });
  }
  
 
 function viewMemberInfo(){
     var rows = memberInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return;   }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getMemberInfo.do?viewType=view&memberId='+rows[0].memberId,title:'查看用户信息', width:600,height:440
	 });
 }		
 		
 function editMemberInfo(){
     var rows = memberInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getMemberInfo.do?viewType=update&memberId='+rows[0].memberId,title:'修改用户信息',showMin: true, width:650,height:440
	 });
	 
 }		
 
 function dowloadQrCodeImg(){
     var rows = memberInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return;  }
      $.post('${ctx}/sys/downloadQrCodeImg.do?memberId='+rows[0].memberId,function(data){
		        if(data="true"){
		             $.ligerDialog.success('重置成功！');
		               queryMemberInfo(); 
		        }else{
		            $.ligerDialog.error('重置失败！');
		        }
		     });
 }
 
function  resetLoginPass(){
    var rows = memberInfoGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择要重置密码的用户！'); return; }
	$.ligerDialog.confirm('重置后用户的登录密码与用户账号一致，确定要重置吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids +=this.memberId;
		      		else
		      			ids +=","+this.memberId;
		     });
		     
		     $.post('${ctx}/sys/resetPassword.do?memberIds='+ids,function(data){
		        if(data.result="true"){
		             $.ligerDialog.success('重置成功！');
		               queryMemberInfo(); 
		        }else{
		            $.ligerDialog.error('重置失败！');
		        }
		     });
		     
		 }
		});
}
 
 function batchDelMemberInfo(){
    var rows = memberInfoGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择数据再删除！'); return; }
	$.ligerDialog.confirm('确定删除吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids += "?memberId="+this.memberId;
		      		else
		      			ids += "&memberId="+this.memberId;
		     });
		     $.post('${ctx}/sys/updateMemberToDelStatus.do'+ids,function(data){
		        if(data.result="true"){
		             $.ligerDialog.success('删除成功！');
		               queryMemberInfo(); 
		        }else{
		            $.ligerDialog.error('删除成功！');
		        }
		     });
		 }
		});
   }
   
  $("#resetForm").bind("click",function(){
  	$("#memberInfoForm").form('clear');
  	 memberInfoGrid.cancelEdit();
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

 var memberTypeDict =[];
 <c:forEach items="${dictMap.memberType}" var="memberType" >
   memberTypeDict=memberTypeDict.concat({"dictValue": "<c:out value="${memberType.dictValue}"/>","dictName":"<c:out value="${memberType.dictName}"/>"});
 </c:forEach>	

 function f_initGrid()
 { 
         memberInfoGrid = $("#maingrid").ligerGrid({
         columns: [
         { display: '会员编号', name: 'memberId', width:'6%', type: 'int',frozen:true },
         { display: '登录手机号', name: 'mobileNo',width:'12%'},
         { display: '会员类型', name: 'memberType',width:'6%',render: function (item)
             {    
                for(var i=0;i<memberTypeDict.length;i++){
                 if (memberTypeDict[i].dictValue==item.memberType)
                    return memberTypeDict[i].dictName;
                 }
             } 
          },
         { display: '个人/企业名称', name: 'realName',width:'12%'},
         { display: '邮箱', name: 'email', width: '12%', type: 'int'},
         { display: '二维码', width: '9%', name: 'qrCodeImg',
           render: function (item)
             {
                 var html = '<a href="${ctx}/sys/downloadQrCodeImg.do?memberId=' + item.memberId + '">下载</a>';
                 return html;
             }
         },
         { display: '其它联系电话', name: 'phoneNo', width: '10%'},
         { display: '可用积分', width: '9%', name: 'canPoint'},
         { display: '注册日期', width: '9%', name: 'createTime'},
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
         url:'${ctx}/sys/queryMemberInfo.do',
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