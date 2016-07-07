<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>商城商品管理</title>
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
				<form id="productInfoForm">
					<table height="450px" class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
							<th width="10%" align="right">
								商品编号：
							</th>
							<td width="17%">
								<input class="formText width1" value="" type="text"  id="productCode" name="productCode" />
							</td>
							<th width="10%" align="right">
								商品名称：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="productName" name="productName" />
							</td>
							<th width="10%" align="right">
								商品品牌：
							</th>
							<td width="17%">
								<input class="formText  width1" value="" type="text" id="productBrand" name="productBrand" />
							</td>
						</tr>
						<tr>
							<th align="right">
								商品状态：
							</th>
							<td >
								<input  value="" type="text" id="selectStatus" name="selectStatus" />
								<input type="hidden" id="status" name="status" />
							</td>
							<th align="right">
								是否推荐到首页：
							</th>
							<td colspan="3">
								<input  value="" type="text" id="selectIsRecomend" name="selectIsRecomend" />
								<input type="hidden" id="isRecomend" name="isRecomend" />
							</td>
						</tr>
						<tr>
							<td colspan="5" align="center">
								<input id="viewProductInfo" class="btn" type="button" value="查 看" />
								<input id="addProductInfo" class="btn" type="button" value="新 增" />
								<input id="editProductInfo" class="btn" type="button" value="修 改" />
								<input id="delProductInfo" class="btn" type="button" value="删 除" />
								<input id="queryProductInfo" class="btn" type="button" value="查 询" />
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
		<div id="productInfoWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false"
			collapsible="false" resizable="false" style="margin: 0px; padding: 0px; overflow: auto;"></div>
	</body>
	<script type="text/javascript">
  $(function(){
			 f_initGrid();
			 $("#addProductInfo").bind("click",addProductInfo);
			 $("#editProductInfo").bind("click",editProductInfo);
			 $("#delProductInfo").bind("click",batchDelProductInfo);
			 $("#viewProductInfo").bind("click",viewProductInfo);
			 $("#queryProductInfo").bind("click",queryProductInfo);
			 $("#resetLoginPass").bind("click",resetLoginPass);
    });
		
 var productInfoGrid;		
 function queryProductInfo(){
     var param=$("#productInfoForm").serialize();
     productInfoGrid.loadServerData(param,null);
  }		
 
  function addProductInfo(){
       var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getProductInfo.do?viewType=add',title:'添加商品', width:900,height:500 });
  }
  
 
 function viewProductInfo(){
     var rows = productInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return;  return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getProductInfo.do?viewType=view&productId='+rows[0].productId,title:'查看商品信息', width:900,height:700
	 });
 }		
 		
 function editProductInfo(){
     var rows = productInfoGrid.getSelectedRows();
     if (!rows || rows.length!=1) {  $.ligerDialog.warn('请选择一条信息'); return; }
     var winPassword=$.ligerDialog.open({url:'${ctx}/sys/getProductInfo.do?viewType=update&productId='+rows[0].productId+"&productKind="+rows[0].productKind,title:'修改商品信息',showMin: true, width:900,height:700
	 });
	 
 }		
 
function  resetLoginPass(){
    var rows = productInfoGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择要重置密码的用户！'); return; }
	$.ligerDialog.confirm('重置后用户的登录密码与用户账号一致，确定要重置吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids += "?productId="+this.productId;
		      		else
		      			ids += "&productId="+this.productId;
		     });
		     
		 }
		});
}
 
 function batchDelProductInfo(){
    var rows = productInfoGrid.getSelectedRows();
    if (!rows || rows.length<=0) { $.ligerDialog.warn('请选择数据再删除！'); return; }
	$.ligerDialog.confirm('确定删除吗?', function(yes){
		if (yes){
		 	var ids = "";
		    $.each(rows,function(i){
		      		if(i==0) 
		      			ids += "?productId="+this.productId;
		      		else
		      			ids += "&productId="+this.productId;
		     });
		     $.post('${ctx}/sys/batchDelProductInfo.do'+ids,function(data){
		        if(data.result="true"){
		             $.ligerDialog.success('删除成功！');
		               queryProductInfo(); 
		        }else{
		            $.ligerDialog.error('删除成功！');
		        }
		     });
		 }
		});
   }
   
  $("#resetForm").bind("click",function(){
  	$("#productInfoForm").form('clear');
  	 productInfoGrid.cancelEdit();
  });   

 
 var productStatus =[];
 <c:forEach items="${dictMap.status}" var="status" >
   productStatus=productStatus.concat({"dictValue": "<c:out value="${status.dictValue}"/>","dictName":"<c:out value="${status.dictName}"/>"});
 </c:forEach>	
 
  var productBrand =[];
 <c:forEach items="${dictMap.productBrand}" var="dict" >
   productBrand=productBrand.concat({"dictValue": "<c:out value="${dict.dictValue}"/>","dictName":"<c:out value="${dict.dictName}"/>"});
 </c:forEach>	
 
  var productKind =[];
 <c:forEach items="${dictMap.productKind}" var="dict" >
   productKind=productKind.concat({"dictValue": "<c:out value="${dict.dictValue}"/>","dictName":"<c:out value="${dict.dictName}"/>"});
 </c:forEach>	
 
 var isRecomend =[];
 <c:forEach items="${dictMap.isRecomend}" var="dict" >
   isRecomend=isRecomend.concat({"dictValue": "<c:out value="${dict.dictValue}"/>","dictName":"<c:out value="${dict.dictName}"/>"});
 </c:forEach>	
 	 
  var statusBox= $("#selectStatus").ligerComboBox({
           width : 100,
           valueFieldID:"status",
           data:productStatus,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });
  
 var isRecomendBox= $("#selectIsRecomend").ligerComboBox({
           width : 100,
           valueFieldID:"isRecomend",
           data:isRecomend,
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
  });
  

 function f_initGrid()
 { 
         productInfoGrid = $("#maingrid").ligerGrid({
         columns: [
         { display: '产品id', name: 'productId', width:'0%', type: 'int',frozen:true,hide:"none" },
         { display: '产品编号', name: 'productCode', width:'6%', type: 'int',frozen:true },
         { display: '产品名称', name: 'productName',width:'22%'},
         { display: '产品品牌', name: 'productBrand',width:'12%', render: function (item)
             {    
                for(var i=0;i<productBrand.length;i++){
                 if (productBrand[i].dictValue==item.productBrand)
                    return productBrand[i].dictName;
                 }
             }},
         { display: '商品类型', name: 'productKind', width: '12%', type: 'int', render: function (item)
             {    
                for(var i=0;i<productKind.length;i++){
                 if (productKind[i].dictValue==item.productKind)
                    return productKind[i].dictName;
                 }
             }},
         { display: '添加日期', width: '12%', name: 'createTime'},
         { display: '修改日期', width: '12%', name: 'updateTime'},
         { display: '状态', name: 'status', width: '6%', render: function (item)
             {    
                for(var i=0;i<productStatus.length;i++){
                 if (productStatus[i].dictValue==item.status)
                    return productStatus[i].dictName;
                 }
             } }
         
         ],
         onSelectRow: function (rowdata, rowindex)
         {
             $("#txtrowindex").val(rowindex);
         },
         enabledEdit: true, 
         clickToEdit: true, isScroll: false,  
         url:'${ctx}/sys/queryProductInfo.do',
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