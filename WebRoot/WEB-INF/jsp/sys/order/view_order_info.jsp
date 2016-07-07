<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>订单详情</title> 
		<%@ include file="/jsp/common/common.jsp"%>
		<%@ include file="/jsp/easyui-validate.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerTab.js" type="text/javascript"></script>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>

		<link rel="stylesheet" href="${ctx}/resources/jquery/kindeditor-4.1.7/themes/default/default.css" />
		<script charset="utf-8" src="${ctx}/resources/jquery/kindeditor-4.1.7/kindeditor-min.js"></script>
		<script charset="utf-8" src="${ctx}/resources/jquery/kindeditor-4.1.7/lang/zh_CN.js"></script>
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/jquery/uploadify/uploadify.css">
		<script charset="utf-8" src="${ctx}/resources/jquery/uploadify/jquery.uploadify.min.js"></script>
		<style type="text/css">
		 .attrText{width:200px;}
		</style>
	</head> 
	<body>

		<div id="orderTab" style="width: 920px; overflow: hidden; border: 1px solid #A3C0E8;">
			<div tabid="tab1" title="订单基本信息" lselected="true" style="height: 330px">
				<form id="dataForm" method="post" novalidate>
					<input type="hidden" name="orderId" value="${dataMap.orderInfo.orderId}" required="true" />
					<table class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
						   <th width="15%">
								订单编号：
							</th>
							<td width="35%">
								<input type="text" name="orderId"  readonly class="formText width2 easyui-validatebox" validType="length[1,50]"
									value="${dataMap.orderInfo.orderId}" required="true" />
								 
							</td>
							<th width="15%">
								会员编号：
							</th>
							<td width="33%">
								<input type="text" name="memberId" id="memberId" readonly  class="formText"
									value="${dataMap.orderInfo.memberId}"  />
							</td>
						</tr>
						<tr>
							<th>
								订单金额：
							</th>
							<td>
								<input id="title" class="formText width2 easyui-validatebox" readonly   validType="length[1,50]"  name="title"    value="${dataMap.orderInfo.orderCash }" />
							</td> 
							<th>
								修改订单金额备注：
							</th>
							<td>
								<input value="${dataMap.orderInfo.orderCashChangeRemark}" readonly type="text" id="orderCashChangeRemark" name="orderCashChangeRemark" />
							 
							</td>
						</tr>
						<tr>
						  	<th>
								订单状态：
							</th>
							<td>
								<input id="orderStatus" name="orderStatus" type="hidden" 	value="${dataMap.orderInfo.orderStatus}" />
								<input value="${dataMap.orderInfo.orderStatus}" type="text" id="orderStatusSelect" name="orderStatusSelect" />
							</td>
							<th>
								支付方式：
							</th>
							<td>
								<input id="payType" name="payType" type="hidden" 	value="${dataMap.orderInfo.payType}" />
								<input value="${dataMap.orderInfo.payType}" type="text" id="payTypeSelect" name="payTypeSelect" />
							</td>
						</tr>
					   <tr>
					   <th>
								支付状态：
							</th>
							<td>
							<input id="payStatus" name="payStatus" type="hidden" 	value="${dataMap.orderInfo.payStatus}" />
								<input value="${dataMap.orderInfo.payStatus}" type="text" id="payStatusSelect" name="payStatusSelect" />
							</td>
							<th>
								支付时间：
							</th>
							<td>
							<input id="price" name="price" class="formText  easyui-numberbox" required="true"  readonly validType="length[2,50]"		value="${dataMap.orderInfo.payTime}" />
							 
							</td>
						</tr>
						 <tr>
							<th>
								赠送积分：
							</th>
							<td>
								<input id="givePoint" name="givePoint" require="true" type="text" readonly
									value="${dataMap.orderInfo.givePoint}" />
								 
							</td>
							<th>
								配送费：
							</th>
							<td>
								<input value="${dataMap.orderInfo.sendPrice}" type="text" readonly id="discountPrice"  class="formText easyui-numberbox" name="discountPrice" />
						 
							</td>
						</tr>
					    <tr>
					       <th>
								联系人：
							</th>
							<td>
								<input value="${dataMap.orderInfo.linkman}" type="text" readonly  class="formText easyui-numberbox" validType="length[1,50]"  id="linkman" name="linkman" />
							</td> 
							<th>
								联系人电话：
							</th>
							<td>
								<input id="phone" name="phone" require="true" readonly
									value="${dataMap.orderInfo.phone}" />
							</td>
						</tr>
						<tr>
						   <th>
							收获地址：
							</th>
							<td colspan="3">
								<textarea  id="address" cols="80"  readonly rows="2" name="address" >
								${dataMap.orderInfo.address}
								</textarea>
								 
							</td>
						</tr>
						<tr>
							<th>
								邮编：
							</th>
							<td>
								<input id="deliverPrice" name="postCode" require="true" readonly  class="formText easyui-numberbox" validType="length[1,20]"  value="${dataMap.orderInfo.postCode}" />
							</td>
							<th>
								收货时间：
							</th>
							<td>
								<input value="${dataMap.orderInfo.sendTime}" type="text" id="sendTimeSelect" name="sendTimeSelect" />
								<input id="sendTime" name="sendTime"  type="hidden"  value="${dataMap.orderInfo.sendTime}" />
							</td>
						</tr>
						<tr>
						   <th style="background:#F9FBFD;">
							快递公司
							</th>
							<td>
								<input id="expressCompany" name="expressCompany" require="true" readonly  class="width2" required="true"
									value="${dataMap.orderInfo.expressCompany}" />
									<span id="uploadFileQueue"></span>
							</td>
							<th>
							快递号：
							</th>
							<td>
								<input type="text" name="expressId" class="expressId" readonly="true"
									value="${dataMap.orderInfo.expressId }"/>
							</td>
						</tr>
						<tr>
						  	<th>
								创建日期：
							</th>
							<td>
								<input type="text" readonly="true" name="createTime" class="formText"
									value="<fmt:formatDate value="${dataMap.orderInfo.createTime	 }" pattern="yyyy-MM-dd HH:mm:ss"/>" />
							</td>
							<th>
								修改日期：
							</th>
							<td>
								<input type="text" readonly="true" name="updateTime" class="formText"
									value="<fmt:formatDate value="${dataMap.orderInfo.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" />
							</td>
						</tr>
						<tr>
						   <td colspan="4">
						    <c:forEach var="${order}" items="${dataMap.orderInfoList}">
						    
						    
						    </c:forEach>
						   </td>
						</tr>
						<tr>
							<td colspan="4">
								<center>
									<button class="liger-button l-button" id="closeBtn" type="button" onclick="closeWin()">
										关闭
									</button>
								</center>
							</td>
						</tr>
					</table>
				</form>
			</div>
	 
		 
		</div>


<script type="text/javascript">
 var editor;
 var orderTab;
  	
  $(function(){
  	 var payStatusSelect= $("#payStatusSelect").ligerComboBox({
            width : 100,
            valueFieldID:"payStatus",
            url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=payStatus',
            cancelable: true,
            valueField : 'dictValue',
            textField: 'dictName',
            disabled:true
		 });
	 
 	 var orderStatus= $("#orderStatusSelect").ligerComboBox({
           width : 100,
           valueFieldID:"orderStatus",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=orderStatus',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName',
            disabled:true
	 });	 
  	  
  	  var payType= $("#payTypeSelect").ligerComboBox({
           width : 100,
           valueFieldID:"payType",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=payType',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName',
            disabled:true
	 });
	 
	 
  	 var sendTime= $("#sendTimeSelect").ligerComboBox({
           width : 130,
           valueFieldID:"sendTime",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=sendTime',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName',
            disabled:true
	 });
  	 
    
    	 payStatusSelect.setValue('${dataMap.orderInfo.payStatus}');
    	 orderStatus.setValue('${dataMap.orderInfo.orderStatus}');
    	 payType.setValue("${dataMap.orderInfo.payType}");
    	 sendTime.setValue("${dataMap.orderInfo.sendTime}");
 
  });
  
  
function closeWin(){
	window.parent.$.ligerDialog.hide(); 
	window.parent.queryOrderInfo();  
}
 
</script>
	</body>
</html>