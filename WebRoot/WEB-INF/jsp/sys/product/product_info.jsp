<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>产品维护</title> 
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

		<div id="productTab" style="width: 920px; overflow: hidden; border: 1px solid #A3C0E8;">
			<div tabid="tab1" title="商品基本信息" lselected="true" style="height: 330px">
				<form id="dataForm" method="post" novalidate>
					<input type="hidden" name="productId" value="${dataMap.productInfo.productId}" required="true" />
					<table class="inputTable" cellpadding="0" cellspacing="1" border="0" align="center">
						<tr>
						   <th width="15%">
								商品名称：
							</th>
							<td width="35%">
								<input type="text" name="productName" class="formText width2 easyui-validatebox" validType="length[1,50]"
									value="${dataMap.productInfo.productName}" required="true" />
								<label class="requireField">
									*
								</label>
							</td>
							<th width="15%">
								商品code：
							</th>
							<td width="33%">
								<input type="text" name="productCode" id="productCode" readonly maxlength="6" title="无须输入后台自动生成" class="formText"
									value="${dataMap.productInfo.productCode}"  />
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
						<tr>
							<th>
								商品副标题：
							</th>
							<td>
								<input id="title" class="formText width2 easyui-validatebox"   validType="length[1,50]"  name="title"    value="${dataMap.productInfo.title }" />
							</td> 
							<th>
								商品类别：
							</th>
							<td>
								<input value="${dataMap.productInfo.productKind}" type="text" id="productKindSelect" name="productKindSelect" />
								<input type="hidden" name="productKind" id="productKind" class="formText " value="${dataMap.productInfo.productKind }"
									/>
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
						<tr>
							<th>
								商品品牌：
							</th>
							<td>
								<input id="productBrand" name="productBrand" type="hidden" 	value="${dataMap.productInfo.productBrand}" />
								<input value="${dataMap.productInfo.productBrand}" type="text" id="brandSelect" name="brandSelect" />
								<label class="requireField">
									*
								</label>
							</td>
							<th>
								商品状态：
							</th>
							<td>
								<input value="${dataMap.productInfo.status}" type="text" id="statusSelect" name="statusSelect" />
								<input type="hidden" id="status" value="${dataMap.productInfo.status}" name="status" />
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
					   <tr>
							<th>
								商品价格：
							</th>
							<td>
							<input id="price" name="price" class="formText  easyui-numberbox" required="true"  validType="length[2,50]"		value="${dataMap.productInfo.price}" />
								<label class="requireField">
									*
								</label>
							</td>
							<th>
								优惠价格：
							</th>
							<td>
								<input value="${dataMap.productInfo.discountPrice}" type="text" id="discountPrice"  class="formText easyui-numberbox" name="discountPrice" />
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
						 <tr>
							<th>
								是否推荐到首页：
							</th>
							<td>
								<input id="isRecomendSelect" name="isRecomendSelect" require="true" 
									value="${dataMap.productInfo.isRecomend}" />
									
								<input id="isRecomend" name="isRecomend" require="true" type="hidden"
									value="${dataMap.productInfo.isRecomend}" />
									
									
								<label class="requireField">
									*
								</label>
							</td>
							<th>
								商品库存数量：
							</th>
							<td>
								<input value="${dataMap.productInfo.productNum}" type="text" required="true"   class="formText easyui-numberbox" validType="length[1,50]"  id="productNum" name="productNum" />
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
					    <tr>
							<th>
								兑换数量：
							</th>
							<td>
								<input id="exchangeNum" name="exchangeNum" require="true" validType="length[2,20]" 
									value="${dataMap.productInfo.exchangeNum}" />
								<label class="requireField">
									*
								</label>
							</td>
							<th>
								配送方式：
							</th>
							<td>
								<input value="${dataMap.productInfo.deliverType}" type="text" id="deliverType" name="deliverType" />
								<label class="requireField">
									*
								</label>
							</td>
						</tr>
						<tr>
							<th>
								运费：
							</th>
							<td>
								<input id="deliverPrice" name="deliverPrice" require="true"  class="formText easyui-numberbox" validType="length[1,20]"  value="${dataMap.productInfo.deliverPrice}" />
							 
							</td>
							<td style="background:#F9FBFD;"><input name="uploadProductImg" class="" type="file" id="uploadProductImg"  />
							</td>
							<td>
								<input id="productImg" name="productImg" require="true"  class="width2" required="true"
									value="${dataMap.productInfo.productImg}" />
									<span id="uploadFileQueue"></span>
							</td>
						 
						</tr>
						<tr>
							<th>
								添加日期：
							</th>
							<td>
								<input type="text" name="createTime" class="formText" readonly="true"
									value="<fmt:formatDate value="${dataMap.productInfo.createTime }" pattern="yyyy-MM-dd"/>" />
							</td>
							<th>
								修改日期：
							</th>
							<td>
								<input type="text" readonly="true" name="updateTime" class="formText"
									value="<fmt:formatDate value="${dataMap.productInfo.updateTime }" pattern="yyyy-MM-dd"/>" />
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<center>
									<button class="liger-button l-button"  style="width:120px" id="saveBtn" type="button" onclick="saveBaseProductInfo()">
										保存商品基本信息
									</button>
									<button class="liger-button l-button" id="closeBtn" type="button" onclick="closeWin()">
										关闭
									</button>
								</center>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div title="商品详情" showClose="true">
				<textarea rows="4" cols="40" style="width: 800px; height: 370px; visibility: hidden;" name="productDetail"
					id="productDetail">${dataMap.productInfo.productDetail }</textarea>
				
				<center>
				<button class="liger-button l-button" id="saveBtn"  style="width:120px"  type="button" onclick="saveProductDetail()">
					保存商品详情
				</button>
				<button class="liger-button l-button" id="saveBtn" type="button" onclick="closeWin()">
					关闭
				</button>
			</center>
			</div>
			<div title="商品属性" showClose="true">
			<form id="attrInfoForm">
			 	<table class="inputTable"  id="attrInfoTab" cellpadding="0" cellspacing="1" border="0" align="center">
			    </table>
			    </form>
			    <center>
			    <button class="liger-button l-button" id="saveBtn" style="width:120px" type="button" onclick="saveProductAttrInfo()">
					保存商品属性信息
				</button>
				<button class="liger-button l-button" id="saveBtn" type="button" onclick="closeWin()">
					关闭
				</button>
			    </center>
			</div>
			<div title="商品图片" showClose="true">				  
				 <table   cellpadding="0" cellspacing="1" border="0"  id="imgTable"  align="center">
						 
				</table>
				<center>
				 <button class="liger-button l-button" id="saveBtn" style="width:100px" type="button" onclick="addProductImg()">
					添加一张
				</button>  
			    <button class="liger-button l-button" id="saveBtn" style="width:120px" type="button" onclick="saveProductImg()">
					保存商品图片
				</button>
				<button class="liger-button l-button" id="saveBtn" type="button" onclick="closeWin()">
					关闭
				</button>
			    </center>
			</div>
		</div>


<script type="text/javascript">
 var editor;
 var productTab;
  	
  $(function(){
  	 var statusSelect= $("#statusSelect").ligerComboBox({
            width : 100,
            valueFieldID:"status",
            url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=productStatus',
            cancelable: true,
            valueField : 'dictValue',
            textField: 'dictName'
		 });
	 
 	 var productBrand= $("#brandSelect").ligerComboBox({
           width : 100,
           valueFieldID:"productBrand",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=productBrand',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
	 });	 
  	  
  	  var productKind= $("#productKindSelect").ligerComboBox({
           width : 100,
           valueFieldID:"productKind",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=productKind',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName',
           onSelected:productKindChange
	 });
	 
	 function productKindChange(){
	   if("${dataMap.viewType}"=="add"){
		  $.post("${ctx}/sys/getProductAttrInfo.do",{"attrKind":productKind.getValue()},function(data){
	   	   			if(data){
	   	   			    initAttrInfo(data);
	   	   			 }else{
	   	   			   $.ligerDialog.error(data.msg);
	   	   			 }
		  });
		}
	 }
  	  
  	 var isRecomend= $("#isRecomendSelect").ligerComboBox({
           width : 100,
           valueFieldID:"isRecomend",
           url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=isYesOrNo',
           cancelable: true,
           valueField : 'dictValue',
           textField: 'dictName'
	 });
  	 
    
     if("${dataMap.viewType}"=="update"||"${dataMap.viewType}"=="view"){
    	 statusSelect.setValue('${dataMap.productInfo.status}');
    	 productBrand.setValue('${dataMap.productInfo.productBrand}');
    	 isRecomend.setValue("${dataMap.productInfo.isRecomend}");
    	 productKind.setDisabled(true);
      
   	 }else if("${dataMap.viewType}"=="add"){
  	   productKind.setValue("0001");
  	   statusSelect.setValue("1");
  	   productBrand.setValue("01");
  	   isRecomend.setValue("0");
  	}
  	
     $("#productTab").ligerTab(); 
     productTab=$("#productTab").ligerGetTabManager(); 
          
	 KindEditor.ready(function(K) {
		editor = K.create('textarea[name="productDetail"]', {
			allowFileManager : true,
			uploadJson : '${ctx}/resources/jquery/kindeditor-4.1.7/jsp/upload_json.jsp',
		    fileManagerJson : '${ctx}/resources/jquery/kindeditor-4.1.7/jsp/file_manager_json.jsp',
		});
		
		
	 });
	 
	 initAttrInfo(${dataMap.productAttrInfo});
	 initProductImg();
	 initProductMainImgUpload();
  });
  
  var productId="${dataMap.productInfo.productId}";
  function saveBaseProductInfo(){
        var r = $("#dataForm").form('validate');
		if(!r) {
			return false;
	     }   
	   
   	   $.post("${ctx}/sys/saveBaseProductInfo.do?viewType=${dataMap.viewType}",$("#dataForm").serializeArray(),function(data){
   	   			if(data.result=="true"){
   	   			    productId=data.productId;
   	   				$.ligerDialog.success(data.msg+"，接下来设置商品详细信息！",function(){
   	   				   moveToNextTab(1);
   	   				});
   	   			 }else{
   	   			   $.ligerDialog.error(data.msg);
   	   			 }
	  });
   }
   
 function saveProductDetail(){
     if(checkIsUpdateProduct()){return false;}
     var productDetail=editor.html();
     $.post("${ctx}/sys/saveProductDetail.do",{"productId":productId,"productDetail":productDetail},function(data){
  			if(data.result=="true"){
  				$.ligerDialog.success(data.msg+"，接下来设置商品属性信息！",function(){
  				 moveToNextTab(2);
  				});
  			 }else{
  			   $.ligerDialog.error(data.msg);
  			 }
	  });
   }
  //初始化商品属性信息 
  function initAttrInfo(attrInfoList){
   var obj;
   var trHtm="";
   var attrInfoTab=$("#attrInfoTab");
     attrInfoTab.html("");
   for(var i=0;i<attrInfoList.length;i++){
      obj=attrInfoList[i];
      i++;
      trHtm+="<tr><th >"+obj.attrName+"</th><td><input class='attrText' type='text' name='attrInfo' id='"+obj.attrId+"' value='"+(obj.attrVal?obj.attrVal:"")+"' /></td>";
      obj=attrInfoList[i];
      if(obj){
      	trHtm+="<th>"+obj.attrName+"</th><td><input class='attrText' type='text' name='attrInfo' id='"+obj.attrId+"' value='"+(obj.attrVal?obj.attrVal:"")+"' /></td></tr>";
      }else{
       trHtm+="</tr>";
      }
   }
   attrInfoTab.append(trHtm);
  } 
   
   //保存商品属性信息
  function saveProductAttrInfo(){
     if(checkIsUpdateProduct()){return false;}
     var attrInfoForm=$("input[name='attrInfo']");
     var attrInfoJson="[";
     $.each(attrInfoForm,function(){
     	attrInfoJson+='{"attrId":'+this.id+',"attrVal":"'+this.value+'"},';
     })
     attrInfoJson=attrInfoJson.substring(0,attrInfoJson.length-1);
     attrInfoJson+="]";
     $.post("${ctx}/sys/saveProductAttrInfo.do",{"productId":productId,"attrInfoJson":attrInfoJson},function(data){
  			if(data.result=="true"){
  				$.ligerDialog.success(data.msg,function(){
  				 moveToNextTab(3);
  				});
  			 }else{
  			   $.ligerDialog.error(data.msg);
  			 }
	  });
   }  
   
   
   var productImgIndex=0;
   //初始化图片信息
   function initProductImg(){
    var attrImgList=${dataMap.productImg};
    for(var i=0;i<attrImgList.length;i++){
       addProductImg(attrImgList[i]);
    }
    
   }
   
    
   //添加商品图片
   function addProductImg(imgObj){
     $("#imgTable").append(getProductImgHtml(productImgIndex,imgObj));
     initUpload(productImgIndex);
     productImgIndex++;
   }
   
   //获取图片html
   function getProductImgHtml(indexNo,imgObj){
    var imgUrl="";
    var display="none";
    if(imgObj&&imgObj.imgUrl&&imgObj.imgUrl.length>0){
      imgUrl=imgObj.imgUrl;
      display="block";
    }
    return '<tr id="imgTr_'+indexNo+'"><th width="260" valign="middle" align="left"> <input id="fileImg_'+indexNo+'"   name="file_upload"  type="file" multiple="true"></th>'+ 	 
      '<td width="200" height="120" ><img border="0" id="imgUrl_'+indexNo+'" style="display:'+display+'" src="${ctx}'+imgUrl+'" width="100" height="100" />'+ 
      ' <input id="batchProductImg'+indexNo+'" name="batchProductImg" type="hidden" value="'+imgUrl+'"/></td>'+  
      ' <td width="400"><input type="button" value="删 除" onclick="delProductImg(\'imgTr_'+indexNo+'\')"  class="liger-button l-button" ></td> </tr>';
   }
   
   //单个删除商品
   function delProductImg(trId){
     $("#"+trId).remove();
   }
   
   //保存商品图片信息
   function saveProductImg(){
     if(checkIsUpdateProduct()){return false;}
     var productImgList=$("input[name='batchProductImg']");
     if(productImgList.length==0){ $.ligerDialog.warn("请先上传商品图片再保存！");return false;}
     
     var productImgJson="[";
     $.each(productImgList,function(){
     	productImgJson+='{"imgUrl":"'+this.value+'"},';
     })
     productImgJson=productImgJson.substring(0,productImgJson.length-1);
     productImgJson+="]";
     $.post("${ctx}/sys/saveProductImg.do",{"productId":productId,"productImgJson":productImgJson},function(data){
  			if(data.result=="true"){
  				$.ligerDialog.success(data.msg,function(){
  				closeWin();
  				});
  			 }else{
  			   $.ligerDialog.error(data.msg);
  			 }
	  });
   }
   
//检查是否是进行修改以及新增时是否先设置了商品基本信息
function checkIsUpdateProduct(){
  if(productId==""||productId.length<1){
      $.ligerDialog.warn("请先设置商品基本信息在保存后再进行保存当前页面信息！");
  	 return true;
  }
}

function initUpload(indexNo){
  $('#fileImg_'+indexNo).uploadify({
				'formData'     : {
					'timestamp' : new Date()
				},
				'buttonClass':'liger-button l-button',
				'width':102,
				 'height':27,
				 'auto' : 'true',
				 'fileTypeDesc':'支持格式:jpg gif png',
				'fileTypeExts':'*.jpg;*.gif;*.png',
				'swf':'${ctx}/resources/jquery/uploadify/uploadify.swf',
				'uploader' : '${ctx}/sys/uploadProductImg.do',
				'buttonText': '上传商品图片',
				'onUploadSuccess' : function(file, data, response) {
				     $("#imgUrl_"+indexNo).attr("src",'${ctx}'+data);
				     $("#imgUrl_"+indexNo).show();
				     $("#batchProductImg"+indexNo).val(data);
				     if(response){
           			 $.ligerDialog.success("图片上传成功！");
           			}
                 }	
			});

}

function initProductMainImgUpload(){
  $('#uploadProductImg').uploadify({
				'formData'     : {
					'timestamp' : new Date()
				},
				'buttonClass':'liger-button l-button',
				'width':102,
				 'queueID':'',
				 'height':27,
				 'auto' : 'true',
				 'fileTypeDesc':'支持格式:jpg gif png',
				'fileTypeExts':'*.jpg;*.gif;*.png',
				'swf':'${ctx}/resources/jquery/uploadify/uploadify.swf',
				'uploader' : '${ctx}/sys/uploadProductImg.do',
				'buttonText': '上传商品图片',
				'onUploadSuccess' : function(file, data, response) {
				     $("#productImg").val(data);
				     if(response){
           			  $.ligerDialog.success("图片上传成功！");
           			}
                 }	
			});

}			

function moveToNextTab(tabId){
	productTab.selectTabItem("tabitem"+tabId);
}
function closeWin(){
	window.parent.$.ligerDialog.hide(); 
	window.parent.queryProductInfo();  
}
 
</script>
	</body>
</html>