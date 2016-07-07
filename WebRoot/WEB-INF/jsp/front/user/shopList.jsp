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
<div class="shop_cartList">	
<div class="shop_cartImg">
	<img src="<%=path%>/styles/default/images/cart.gif" />
</div>
      <div class="shop_cartTxt">购物车是空的，赶快去购物吧。</div>
      <div class="shop_submit">
      	<a href="javascript:goShopping()">去购物</a>
      </div>
</div>
 
<section class="shopCars">
 
    <div class="shopCarslist">
        <div class="radio">
          <font id='wareFont<%=1%>' onclick="selectWare(<%=1 %>)" value="disabled1">
            <input type="checkbox" name="wareIdNum" id="wareIdNum<%=1 %>" value="111111111">
          </font> 
        </div>
        <div class="Img">
             <a href="javascript:;">
               <img src="">
             </a>
        </div>
          <div class="Txt">
            <h2><a href="sadf" title="test" >test123</a></h2>
    		<p>现金+<i><%=540000%>
        	</i>
        	</p>
            <div class="count clearfix">
                <div class="fl">
                    <a class="minus fl" href="javascript:updateWareCount(<%=1 %>,-1);">-</a>
                    <input class="fl" id="wareCount<%=1%>" type="text" value="1" onblur="updateWareCount(<%=1 %>,0);" />
                    <a class="plus fl" href="javascript:updateWareCount(<%=1 %>,1);">+</a>
                </div>
                <span class="fr">
                     在线支付
                </span>
            </div>
          </div>
          <input type="hidden" id="wareAmountOld<%=1%>" value="<%=1%>"/>
          <input type="hidden" id="wareData<%=1%>" 
            value="productId,payTYpe,shopId ,1"/>
        </div>
 
    <div id="showShopCart" class="totalAlls">
        <div class="checkAlls clearfix">
            <div class="radio">
            <%
              //若当前验证有错误 怎默认全选不为选中状态
              if(1==1) {%>
                <font id='selectAllFont' onclick="selectAll()"><input type="checkbox" ></font>
            <%} else {%>
            	<font id='selectAllFont' onclick="selectAll()" class="active"><input type="checkbox" checked></font>
            <%}%>
            </div>
            <div class="count">
                <span>总计：<i id="sumIntegral">   
	    		123123
                </i></span> 
                <span class="bala">积分余额：<i><%=123123 %></i></span>
            </div>
        </div>
        <div class="move"><a id="shop_count" href="javascript:exchangeWare();">去结算(<%=1000 %>)</a></div>
        <div class="del"><a href="javascript:deleteWare();">删除</a></div>
    </div>
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
<script type="text/javascript">
var userSumPoint = '';
var shopCartAction = '';
var sumCash = 0;
var sumIntegral = 0;
 
var msg ='';


</script>
<!--加载JS信息-->
<script src="<%=path %>/scripts/user/userCartInfo.js" type="text/javascript"></script>

</html>