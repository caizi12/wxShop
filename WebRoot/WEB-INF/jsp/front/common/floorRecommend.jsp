<%@ page language="java" pageEncoding="UTF-8"  %>
<%@ page import="java.util.List" %>

<div id="hotArea">
 
	<section class="hot">
		<div class="titleTxt clearfix">
		    <h2 id="floorName" class="fl">品牌推荐</h2>
		</div>
       <!-- 2 -->
		<div class="clearfix">
	    	<div class="hotTwo">
		   		<a href="<%=path %>/product/list_page?productBrand=01">
		   			<img src="<%=path%>/upload/logo/bsy.png">
		   		</a>
	   		</div>
	   		<div class="hotTwo">
		   		<a href="<%=path %>/product/list_page?productBrand=02">
		   				<img src="<%=path%>/upload/logo/blb.png">
		   		</a>
	   		</div>
   		</div>
       </section>
       
       <section class="hot">
		<div class="titleTxt clearfix">
		    <h2 id="floorName" class="fl">分类推荐</h2>
		</div>
      
		<div class="clearfix">
	    	<div class="hotFore">
		   		<a href="<%=path %>/product/list_page.do?productKind=0001">
		   			净水设备
		   		</a>
	   		</div>
	   		<div class="hotFore">
		   		 <a href="<%=path %>/product/list_page.do?productKind=0002">
		   			空  调
		   		</a>
	   		</div>
	   		<div class="hotFore">
		   		<a href="<%=path %>/product/list_page.do?productKind=0003">
		   			液晶电视
		   		</a>
	   		</div>
	   		<div class="hotFore">
		   		<a href="<%=path %>/product/list_page.do?productKind=0004">
		   			茶   叶
		   		</a>
	   		</div>
			<div class="hotFore">
		   		<a href="<%=path %>/product/list_page.do?productKind=0005">
		   			红  酒
		   		</a>
	   		</div>
	   	   <div class="hotFore">
		   		<a href="<%=path %>/product/list_page.do?productKind=0006">
		   			冰  箱
		   		</a>
	   		</div>
   		</div>
       </section>
       
   		<section class="hot">
   		<div class="titleTxt clearfix">
		    <h2 id="floorName" class="fl">精品推荐</h2>
		</div>
        <!-- 4 -->
		<div class="clearfix">
		  <c:forEach items="${paraMap.recomendProduct }" var="product" varStatus="productStatus">
		        <div class="hotTwo">
		    		<a href="<%=path%>/product/detail/${product.productId }.do">
		    			<img src="<%=path%>${product.productImg }">
		    		</a>
		    		<span class="title"><a href="<%=path%>/product/detail/${product.productId }.do">${product.productName }</a></span>
		    		<span class="title red">￥${product.price }</span>
		    		<span class="borB"></span>
		        </div>
		  </c:forEach>
    	</div>
 
	</section>
 
</div>


<script>
	
	function gotoRecommendPage(recommendType, recommendId){
		if("001" == recommendType){
			window.location.href = "<%=path%>"+"/subject/"+recommendId+"_0.html";
		}else if("002" == recommendType){
			window.location.href = "<%=path%>"+"/topics/"+recommendId+".html";
		}else{
			
		}
	}
	
</script>
