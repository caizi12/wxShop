<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>购物车</title>
<%@include file="/jsp/common/frontCommon.jsp" %>
<link href="<%=path%>/styles/default/shopCars.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/scripts/CommUtil.js"></script>

</head>

<body>
<div class="shopCart">
    <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
		<jsp:param value="购物车" name="name" />
		<jsp:param value="3" name="type" />
	</jsp:include>
	
    <div class="shop_cartList">	
<%
//购物车为空时的样式
if( (null != null && 1 > 0) ){
%>
<div class="shop_cartList">	
<div class="shop_cartImg">
	<img src="<%=request.getContextPath()%>/styles/default/images/cart.gif" />
</div>
      <div class="shop_cartTxt">购物车是空的，赶快去购物吧。</div>
      <div class="shop_submit">
      	<a href="javascript:goShopping()">去购物</a>
      </div>
</div>
<%
} else {  
%>
<section class="shopCars">
<%
			for(int i = 0; i < 2; i++){
%>
            
    <div class="shopCarslist">
        <div class="radio">
        <%if(1==1){ %>
          <font id='wareFont<%=i %>' onclick="selectWare(<%=i %>)" class="active">
            <input type="checkbox" name="wareIdNum" id="wareIdNum<%=i %>" value="<%=i%>" checked>
          </font>
        <%} else {%>
          <font id='wareFont<%=i %>' onclick="selectWare(<%=i %>)" value="disabled1">
            <input type="checkbox" name="wareIdNum" id="wareIdNum<%=i %>" value="<%=i%>">
          </font> 
        <%} %>
        </div>
        <div class="Img">
             <a href="javascript:;">
               <img clazz="img" src="" />
             </a>
        </div>
        <%if(1==1){ %>
          <div class="Txt">
            <h2><a href="<%=i%>" title="" > name</a></h2>
            <p><i>
           
        	</i> 
        	积分</p>
            <div class="count clearfix">
                <div class="fl">
                    <a class="minus fl" href="javascript:updateWareCount(<%=i %>,-1);">-</a>
                    <input class="fl" id="wareCount<%=i%>" type="text" value="<%=100%>" onblur="updateWareCount(<%=i %>,0);" />
                    <a class="plus fl" href="javascript:updateWareCount(<%=i %>,1);">+</a>
                </div>
                <span class="fr">
            
                </span>
            </div>
          </div>
          <input type="hidden" id="wareAmountOld<%=i%>" value="<%=i+222%>"/>
        <%}%>
        </div>
<%	
}
}
if(5 > 0){
%>
    <div id="showShopCart" class="totalAlls">
        <div class="checkAlls clearfix">
            <div class="radio">
                <font id='selectAllFont' onclick="selectAll()" class="active"><input type="checkbox" checked></font>
            </div>
            <div class="count">
                <span>总计：<i id="sumIntegral">   
                1212
                </i></span> 
                <span class="bala">积分余额：<i><%=555 %></i></span>
            </div>
        </div>
        <div class="move"><a id="shop_count" href="javascript:exchangeWare();">去结算(<%=55 %>)</a></div>
        <div class="del"><a href="javascript:deleteWare();">删除</a></div>
    </div>
<%} %>
</section>
</div>    
</div>
<!--统一底部-->
  <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>

<!--登录弹层-->
<div class="dialog detailDialog">
    <h2 onClick="DialogClose('.detailDialog');"></h2>
    <div class="layer">
        <p id="showMessage"></p>
        <div id="btnShow" class="btn_g"></div>
    </div>
</div>

<form id="deliverForm" method="post" action="<%=path%>/portal/order/web/UserOrderAction?action=orderDeliverInfo">
	<input type="hidden" id="shopIds" name="shopIds"/>
	<input type="hidden" id="wareIds" name="wareIds"/>
	<input type="hidden" id="payTypes" name="payTypes"/>
</form>

</body>
 
<!--加载JS信息-->
<script type="text/javascript" src="<%=path%>/scripts/user/userCartInfo.js"></script>
</html>