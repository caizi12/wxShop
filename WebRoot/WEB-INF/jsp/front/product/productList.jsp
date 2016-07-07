<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>净水商城_列表页</title>
 <%@include file="/jsp/common/frontCommon.jsp" %>
 <link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/newDetail.css"/>
</head>
<body>
<section class="seeGift">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="商品列表" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
</section>

<div class="shopCart">
<div class="sortSearch clearfix">  
   <form id="searchProductForm" action="<%=path %>/product/list_page.do" method="post"">
     <div class="new_navIpt fl"> 
          <input class='newInpt' type='text'  id="searchProductName"  name="productName" value="${dataMap.productName }" />
       <a class="new_Icon" href="#"></a>
       <span><a class="new_btn fl"  href='javascript:doSearch();'></a></span>
    </div>    
   </form>
</div>
<div id="searchL" class="searchL">
  <ul class="UL1">
  	<li id="sortColumn0"  onclick="sortColumn('0')" >综合</li>
  	<li id="sortColumn1"  onclick="sortColumn('1')">价格</li>
    <li id="sortColumn2" onclick="sortColumn('2')">销量 
       <span class="scoreSortPic">
         <img src="<%=path%>/styles/default/images/order_asc.png" onclick='sortByScore("DESC")' />
      </span>
    </li>
  </ul>

  <div id="searchL_main" class="searchL_main clearfix">
        <div class="searchL_list  show" id="productList"  style="display:none;">
	        <ul  class="order_listCon clearfix">
	        </ul>
        </div>  
        <div id="noneProduct" class="searchL_list show" style="display:none;">
	    	<section class="orderFailureMain">
		 	  	<div class="Img">
		         	<img src="<%=path%>/styles/default/images/defaultError.png" />
		      	</div>
		      	<div class="Txt">很抱歉，没有找到相关的商品</div>
		 	</section>
       </div>
  </div>
    <div id="loading" class="list-state" style="display: none;">                
       <p  class="list-loading" >
           <img src="<%=path%>/styles/default/images/loading.jpg"  style="width:38px;float:left;"/>              
           <span>加载中,请稍候</span>
         </p>
	</div>
  </div>
  <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
  <script src="<%=path%>/scripts/listcommon.js" type="text/javascript"></script>
</div>
 
<form id="productQueryForm" action="<%=path %>/product/list_page.do"  method="post">
  <input type="hidden" id="sortFieldType" name="sortFieldType" value="${dataMap.sortFieldType }"/>
  <input type="hidden" id="sortOrder" name="sortOrder"  value="${dataMap.sortOrder }"/>
  <input type="hidden" id="sortColumn" name="sortColumn" value="${dataMap.sortColumn }"/>
  <input type="hidden" id="productName" name="productName" value="${dataMap.productName }" />
  <input type="hidden" id="productBrand" name="productBrand" value="${dataMap.productBrand }"  />
  <input type="hidden" id="productKind" name="productKind"  value="${dataMap.productKind }" />
  <input type="hidden" id="pageNo" name="pageNo"  value="1"/>
</form>
 

</body>
<script type="text/javascript">
var pageNo=1; 
var loading = false;//是否在加载中
$(document).ready(function(){
	 $("#sortColumn${dataMap.sortFieldType}").addClass("active");
	 
	 queryProduct();
	 
     $(window).scroll(function(){                    
           var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
           if(bottomHeight<10 && !loading){
                loading=true;              	             	
               	queryProduct();                	
           }
       });	
  });
  
  //查询商品
  function queryProduct(){
     $("#loading .list-loading").show();
     $.ajax({
			type: "POST",
			dataType: "json",
			url:path+"/product/listByPage.do",
			data:$("#productQueryForm").serializeArray(),
			success:function(productList){
			   //有数据的话，就展示
			   if(productList.length>0){
			       pageNo++;
			       $("#pageNo").val(pageNo);
			      
			       var productHtmls="";
				   for(var item in productList){
					   productHtmls+=getProductHtml(productList[item]);
				   }		 
			       $("#productList ul").append(productHtmls);
			      $("#productList").show();
			   }else if(pageNo==1){
			         $("#noneProduct").show(); 
			   }
			   
	
		       loading=false;
		       $("#loading .list-loading").hide();
			}
		});
  }
 
 function getProductHtml(data){
   return "	<li class='clearfix'>"+
          "<a href='"+path+"/product/detail/"+data.productId+".do' target='_self'>"+
          "<img class='img' src='"+path+data.productImg+"'></a>"+
          "<h2 class='comList'> <a href='"+path+"/product/detail/"+data.productId+".do' target='_self'>"+data.productName+" </a></h2>"+
          "<p>价格<b>￥&nbsp;"+data.price+"</b></p>"+
          "</li>";
 }
 
  function sortColumn(field){
        $("#sortFieldType").val(field);
        $("#sortOrder").val();
        $("#productQueryForm").submit();
	}
</script>
</html>

