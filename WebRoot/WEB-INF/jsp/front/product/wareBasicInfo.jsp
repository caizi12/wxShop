<%@ page  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!--detail开始-->
<section class="fathDetail">
 
    <!--动效-->
    <div class="choose_tasks">
      <a href="<%=path %>/product/desc/${dataMap.productBaseInfo.productId}.do" >
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <c:forEach  var="img" items="${dataMap.productImg}">
	                <div class="swiper-slide swiper-slide1">
					 	<img id="big_img" data="0" src="<%=path%>/${img.imgUrl}"  alt="" />
					</div>
                </c:forEach >
            </div>
			<div class="pagination"></div>
        </div>
        <div id="collectHeart" class="heart" onclick="collect()"><i></i></div>
        </a>
    </div>
    <!--动效 end-->
    <div class="sonInfo clearfix">
        <a href="<%=path %>/product/desc/${dataMap.productBaseInfo.productId}.do" >
	        <h2 class="fl">${dataMap.productBaseInfo.productName}</h2>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
    <div class="sonCont">
        <div class="integral clearfix">
	        <span class="name fl short">单价:</span>
	        <i id="payIntgel" class="set fl">
	        <c:if test="${dataMap.productBaseInfo.discountPrice < dataMap.productBaseInfo.price}">
	             ￥<span id="payCash">${dataMap.productBaseInfo.discountPrice}</span>&nbsp;
	             <del>￥${dataMap.productBaseInfo.price}</del>
	        </c:if>
	        <c:if test="${dataMap.productBaseInfo.price <= dataMap.productBaseInfo.discountPrice  }">
	             ￥<span id="payCash">${dataMap.productBaseInfo.price}</span>&nbsp;
	        </c:if>
	         </i>
	          &nbsp;&nbsp;&nbsp;
        </div>
        <div class="integral clearfix" id="sendAddr">
	        <span class="names fl short">送至:</span>
	        <div class="jf-prop">
                <span class="fa-sele-box">
	               <select id="proviceArea" onchange="updateCity();">
	                </select>
                     <i id="provinceShow" style="font-style:normal;"></i>
                </span>
             	<span class="fa-sele-box">
             		<i id="cityShow" style="font-style:normal;"></i>
                	<select id="cityArea" onchange="updateDistrict()"> 
                	</select>
                </span>
                <span class="fa-sele-box">
                	<i id="countryShow" style="font-style:normal;"></i>
                	<select id ="countryArea" onchange="updateResult()"> 
                	</select>
                </span>
       
                <p id="hasProductNum" class="have" style="line-height:34px; color:#ff0000;">
                 <c:if test="${dataMap.productBaseInfo.productNum >0 }" > 有货 </c:if>  
                 <c:if test="${dataMap.productBaseInfo.productNum <1 || dataMap.productBaseInfo.productNum ==null }" > 暂无货 </c:if> 
               </p>
                <input id="selProVal" type="hidden"></input>
				<input id="selCityVal" type="hidden"></input>
				<input id="selCountryVal" type="hidden"></input>
	        </div>
        </div>
    </div>
    <div class="sonCont">
        <div class="integral clearfix">
	        <span class="name fl">品牌：</span>
	        <b class="set fl">${dataMap.productBaseInfo.productBrand}</b>
        </div>
        <div class="integral clearfix">
	        <span class="name fl lang">销售数量:</span>
	        <span class="set">
		        <i class=""></i>
		        <cite>${dataMap.productBaseInfo.exchangeNum}</cite>
	        </span>
        </div>

	 <div id="changeDiv" class="detailD">
		<section class="addExchange" style="display:inline-block;width:100%;">
			    <div class="payment">
					 <div class="integral clearfix">
				        <span class="name fl lang">购买数量: </span>
				        <span class="count clearfix">
				            <a href="javascript:deductAmount();"><span class="fl">-</span></a>
				            <input id="productNum" class="fl" size="3" value="1" maxlength="3" onblur="updateMount();"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
				            <a href="javascript:addAmount()"><span class="fl">+</span></a>
				        </span>
				       </div>
				        <p id="errorMsg" style="color:red;font-size:10px;"></p>
			    </div>
		</section>	
	</div>

</div>
    
    
	<%if(1==2){%>
		<div id="noWare" class="important">很抱歉，此礼品暂不支持兑换</div>
	<%}%>  
    <div class="hint">
    
        <p class="import strong">重要提示：${dataMap.productBaseInfo.title }</p>
   
		<p class="import strong" id="PayNote">支持的支付方式：微信支付，货到付款</p>
		 
    </div>
    
    <div class="totalAlls">
 
		        <div class="total">
			        <a href="javascript:goShoppingCart();"><img src="<%=path%>/styles/default/images/che.jpg" />
			        <span><cite id="cartNum">0</cite></span></a>
		        </div>
		        <div id="shopcarDiv" class="add" style="display:none;"><a id="shopcarId" href="javascript:goChangeFrom('2');">加入购物车</a></div>
		        <div id="exchangeDiv" class="mast"><a id="exchangeId" href="javascript:doExchange();" >立即购买</a></div>
 
    </div>
 
	<input type="hidden" name = "magName" id="magName" value="" />
	<input type="hidden" name = "magAmount" id="magAmount" value=""/>
	
</section>	
  <!--detail结束-->
  
  
<form id="orderForm" action="<%=path %>/order/exchange.do" method="post">
    <input type="hidden" name="productIds" id="productIds" value="${dataMap.productBaseInfo.productId}"/>
    <input type="hidden" name="amounts" id="amounts"/>
    <input type="hidden" name="selectPayType" id="_selectPayType"/>
    <input type="hidden" name="proCode" id="proCode"/>
    <input type="hidden" name="cityCode" id="cityCode"/>
    <input type="hidden" name="disCode" id="disCode"/>
</form>

<script type="text/javascript">
 $(function(){

   	var mySwiper = new Swiper('.swiper-container',{
        pagination: '.pagination',
        loop:true,
        grabCursor: true,
        paginationClickable: true,
        calculateHeight:true
	 });
	 
	 $(".swiper-wrapper div").each(function(){
			$(this).css("display","block");
	 });
});
 
</script>
<!--加载JS信息-->

 