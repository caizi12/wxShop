<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="cn.frame.platform.common.constant.OrderConstant;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>商城订单管理</title>
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
				<form id="orderInfoForm">
					<table height="450px" class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
							<th width="10%" align="right">
								订单编号：
							</th>
							<td width="17%">
								<input class="formText width1" value="" type="text"  id="orderId" name="orderId" />
							</td>
							<th width="10%" align="right">
								订单金额：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="orderCash" name="orderCash" />
							</td>
							<th width="10%" align="right">
								联系人：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="linkman" name="linkman" />
							</td>
						</tr>
						<tr>
							<th align="right">
								订单状态：
							</th>
							<td >
								<input  value="" type="text" id="selectOrderStatus" name="selectOrderStatus" />
								<input type="hidden" id="orderStatus" name="orderStatus" />
							</td>
							<th align="right">
								支付方式：
							</th>
							<td colspan="1">
								<input  value="" type="text" id="selectPayType" name="selectPayType" />
								<input type="hidden" id="payType" name="payType" />
							</td>
							<th align="right">
								支付状态：
							</th>
							<td colspan="1">
								<input  value="" type="text" id="selectPayStatus" name="selectPayStatus" />
								<input type="hidden" id="payStatus" name="payStatus" />
							</td>
						</tr>
						<tr>
							<td colspan="5" align="center">
								<input id="viewOrderInfo" class="btn" type="button" value="查看订单详情" />
								<input id="changeOrderCash" class="btn" type="button" value="修改订单金额" />
								<input id="updateOrderStatus" class="btn" type="button" value="修改订单状态" />
								<input id="queryOrderInfo" class="btn" type="button" value="查 询" />
								<input id="resetForm" class="btn" type="reset" value="重 置" />
							</td>
							<td>or
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
		<div id="productInfoWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false"
			collapsible="false" resizable="false" style="margin: 0px; padding: 0px; overflow: auto;"></div>
			
		<div id="changeOrderCashDialg" style="width:300px;height:136px;padding:6px 12px;display:none;"> 
		 <form id="changeOrderCashForm" method="post" class="inputForm" novalidate> 
		  <input name="orderId" id="cashFormOrderId" type="hidden">
		  <div><label>原订单金额：</label><span id="oldOrderCash">￥123123</span></div> <div>
		  <label>新订单金额：</label> 
		   <input id="orderCash" name="orderCash" type="text" title="请正确填写订单金额，必须为正整数或者小数" validType="length[1,20]" class="formText  easyui-validatebox" required="true"></div>
		    <div> <label>更改订单金额说明：</label> 
		    <textarea name="orderCashChangeRemark" id="orderCashChangeRemark" rows="3" class="easyui-validatebox" validType="length[1,250]" cols="40"></textarea>
		    </div></form> </div>	
	       
		<div id="changeOrderStatusDialg" style="width:300px;height:50px;padding:6px 12px;display:none;"> 
		 <form id="changeOrderStatusForm" method="post" class="" novalidate> 
		  <input name="orderId" id="statusFormOrderId" type="hidden">
		  <div>
		  <label>选择订单状态：</label> 
		   	<input  value="" type="text" id="statusDialogOrderStatus" name="statusDialogOrderStatus" />
					<input type="hidden" id="changeOrderStatus" name="changeOrderStatus" /></div>
		    </form> 
		  </div>	
			
	</body>
<script type="text/javascript">
//微信支付，且已支付
 var payType_wx='<%=OrderConstant.ORDER_PAY_TYPE_WEIXIN%>';
 var payType_offline='<%=OrderConstant.ORDER_PAY_TYPE_OFFLINE%>';
 var payStatus_yes='<%=OrderConstant.ORDER_PAY_STATUS_YES%>';
 var payStatus_no='<%=OrderConstant.ORDER_PAY_STATUS_NO%>';
 
  $(function(){
			 f_initGrid();
			 $("#changeOrderCash").bind("click",openChangeOrderCash);
			 $("#updateOrderStatus").bind("click",openOrderStatus);
			 $("#viewOrderInfo").bind("click",viewOrderInfo);
			 $("#queryOrderInfo").bind("click",queryOrderInfo);
    });
		
 var orderInfoGrid;		
 function queryOrderInfo(){
     var param=$("#orderInfoForm").serialize();
     orderInfoGrid.loadServerData(param,null);
  }		
 
  function addOrderInfo(){
       var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getOrderInfo.do?viewType=add',title:'添加商品', width:900,height:500 });
  }
  
 
 function viewOrderInfo(){
     var rows = orderInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return;  return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/viewOrderInfo.do?viewType=view&orderId='+rows[0].orderId,title:'查看订单信息', width:900,height:470
	 });
 }		
 		
 function editOrderInfo(){
     var rows = orderInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getOrderInfo.do?viewType=update&orderId='+rows[0].orderId+"&payType="+rows[0].payType,title:'修改商品信息',showMin: true, width:900,height:500
	 });
	 
 }		
 
function getSelectData(){
    var rows = orderInfoGrid.getSelectedRows();
    if (!rows ||!(rows.length==1)) { $.ligerDialog.warn('请先选择一个订单！'); return false; }
    return rows;
}
 
 //更改订单金额
function openChangeOrderCash(){
	 	    $('#changeOrderCashForm').form('clear');
	 	    var rows=getSelectData();
	 	    if(rows!=false){
	 	      if(rows[0].payType==payType_wx && payStatus_no==rows[0].payStatus){
	 	        $("#cashFormOrderId").val(rows[0].orderId);
	 	        $("#oldOrderCash").text(rows[0].orderCash);
	 	        $("#orderCashChangeRemark").val(rows[0].orderCashChangeRemark);
	 	      }else{
	 	        $.ligerDialog.warn("只有选择微信支付，且未付款才可修改订单金额！");
	 	        return;
	 	      }
	 	    }else{
	 	      return;
	 	    }
	 	    
	 	    var win=$.ligerDialog.open({target:$("#changeOrderCashDialg"),title:'更改订单金额',width:350,
		 	    buttons:
		 	     [
		            {text:'确定',onclick:function(){changeOrderCash(win)}},
		            {text:'取消',onclick:function(){win.hide();}}
	             ]
	       		 });
}

function changeOrderCash(win){
	   if(!$('#changeOrderCashForm').form('validate')) {
			return false;
	   }   
	  $.post("${ctx}/sys/updateOrderCash.do",$("#changeOrderCashForm").serializeArray(),function(data){
				$.ligerDialog.warn(data.msg);
				if(data.result=='true'){
				  queryOrderInfo();
				  win.hide();
				}
	  });
  }

 
 //更改订单状态
function openOrderStatus(){
	    $('#changeOrderStatusForm').form('clear');
	    var rows=getSelectData();
	    if(rows!=false){
	      $("#statusFormOrderId").val(rows[0].orderId);
	    }else{
	      return;
	    }
	    var statusWin=$.ligerDialog.open({target:$("#changeOrderStatusDialg"),title:'更改订单状态',width:350,
 	    buttons:
 	     [
           {text:'确定',onclick:function(){changeOrderStatus(statusWin)}},
           {text:'取消',onclick:function(){statusWin.hide();}}
           ]
    	  });
}

function changeOrderStatus(statusWin){
	   if(!$('#changeOrderStatusForm').form('validate')) {
			return false;
	   }   
	  $.post("${ctx}/sys/updateOrderStatus.do",{"orderId":$("#statusFormOrderId").val(),"orderStatus":$("#changeOrderStatus").val()},function(data){
				$.ligerDialog.warn(data.msg);
				if(data.result=='true'){
				  queryOrderInfo();
				  statusWin.hide();
				}	
	  });
  }

 
 function batchDelOrderInfo(){
    var rows = orderInfoGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择数据再删除！'); return; }
	$.ligerDialog.confirm('确定删除吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids += "?orderId="+this.orderId;
		      		else
		      			ids += "&orderId="+this.orderId;
		     });
		     $.post('${ctx}/sys/batchDelOrderInfo.do'+ids,function(data){
		        if(data.result="true"){
		             $.ligerDialog.success('删除成功！');
		               queryOrderInfo(); 
		        }else{
		            $.ligerDialog.error('删除成功！');
		        }
		     });
		 }
		});
   }
   
  $("#resetForm").bind("click",function(){
  	$("#orderInfoForm").form('clear');
  	 orderInfoGrid.cancelEdit();
  });   

 
 var orderStatus =[];
 <c:forEach items="${dictMap.orderStatus}" var="status" >
   orderStatus=orderStatus.concat({"dictValue": "<c:out value="${status.dictValue}"/>","dictName":"<c:out value="${status.dictName}"/>"});
 </c:forEach>	
 
 
  var payType =[];
 <c:forEach items="${dictMap.payType}" var="dict" >
   payType=payType.concat({"dictValue": "<c:out value="${dict.dictValue}"/>","dictName":"<c:out value="${dict.dictName}"/>"});
 </c:forEach>	
 
 var payStatus =[];
 <c:forEach items="${dictMap.payStatus}" var="dict" >
   payStatus=payStatus.concat({"dictValue": "<c:out value="${dict.dictValue}"/>","dictName":"<c:out value="${dict.dictName}"/>"});
 </c:forEach>	
 	 
  var statusBox= $("#selectOrderStatus").ligerComboBox({
           width : 100,
           valueFieldID:"orderStatus",
           data:orderStatus,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });
  
 var payStatusBox= $("#selectPayStatus").ligerComboBox({
           width : 100,
           valueFieldID:"payStatus",
           data:payStatus,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });
  
   var payTypeBox= $("#selectPayType").ligerComboBox({
           width : 100,
           valueFieldID:"payType",
           data:payType,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });

  var statusDialogOrderStatusBox= $("#statusDialogOrderStatus").ligerComboBox({
           width : 100,
           valueFieldID:"changeOrderStatus",
           data:orderStatus,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });

 function f_initGrid()
 { 
         orderInfoGrid = $("#maingrid").ligerGrid({
         columns: [
         { display: '订单编号', name: 'orderId', width:'13%', type: 'int',frozen:true },
         { display: '会员编号', name: 'memberId', width:'9%', type: 'int',frozen:true },
         { display: '订单金额', name: 'orderCash', width:'6%', type: 'int',frozen:true },
         { display: '支付方式', name: 'payType',width:'9%', render: function (item)
             {    
                for(var i=0;i<payType.length;i++){
                 if (payType[i].dictValue==item.payType)
                    return payType[i].dictName;
                 }
           }},
         { display: '支付状态', name: 'payStatus',width:'9%', render: function (item)
             {    
                for(var i=0;i<payStatus.length;i++){
                 if (payStatus[i].dictValue==item.payStatus)
                    return payStatus[i].dictName;
                 }
             }},
         { display: '订单状态', name: 'orderStatus', width: '12%', type: 'int', render: function (item)
             {    
                for(var i=0;i<orderStatus.length;i++){
                 if (orderStatus[i].dictValue==item.orderStatus)
                    return orderStatus[i].dictName;
                 }
             }},
        { display: '收货人', name: 'linkman',width:'12%'},
        { display: '联系电话', name: 'phone',width:'12%'},
         { display: '购买日期', width: '12%', name: 'createTime'}
         
         ],
         onSelectRow: function (rowdata, rowindex)
         {
             $("#txtrowindex").val(rowindex);
         },
         enabledEdit: true, 
         clickToEdit: true, isScroll: false,  
         url:'${ctx}/sys/queryOrderInfo.do',
         width: '100%',
         delayLoad:false,
         height:'100%',
         pageSize:10,
         checkbox:true,
         allowAdjustColWidth:false
     });   
 }	  

</script>

</html>