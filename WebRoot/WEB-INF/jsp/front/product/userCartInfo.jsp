<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="ngves.asiainfo.portal.order.ivalues.IQBOUserShopInfoValue"%>
<%@page import="ngves.asiainfo.portal.order.OrderConstant"%>
<%@page import="ngves.asiainfo.portal.ware.web.WareTypeShowRecommendAction"%>
<%@page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@page import="ngves.asiainfo.portal.common.util.UrlUtil" %>
<%@page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@page import="ngves.asiainfo.portal.util.TuanView"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="ngves.asiainfo.CommnConstant"%>
<%@page import="ngves.asiainfo.portal.common.util.WareShowUtil" %>
<%@taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ taglib prefix="portal" uri="www.asiainfo.cmcc.portal.com" %>
<%@page import="ngves.asiainfo.portal.common.domain.WareVO"%>
<%@page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<%@page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="ngves.asiainfo.util.StringUtil" %>
<%@ page import="ngves.asiainfo.portal.util.VOSearchWareConverter" %>
<%@ page import="ngves.asiainfo.portal.util.JspViewUtil" %>
<%@page import="ngves.asiainfo.portal.PortalCodeConstant"%>

<%@page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<%@page import="ngves.asiainfo.portal.ware.ivalues.IWareInfoPortalValue"%>
<%
//未登录 购物车
String path = request.getContextPath();
IQBOUserShopInfoValue[] shopInfoValues = null;
String mobileBrand = OrderConstant.G_MOBILE_BEAND;
long shopId = 0;
String clearShopIds = "";
if(null != request.getAttribute("shopInfoValues")){
	shopInfoValues = (IQBOUserShopInfoValue[]) request.getAttribute("shopInfoValues");	      	    
     for(int i = 0;i < shopInfoValues.length; i++){
 	   shopId = shopInfoValues[i].getWareId();
     }
}
//计算总积分、现金 用于页面初次加载
long sumIntegral = 0L;
String sumCash = null;
long sumCashL = 0L;
long sumAmount =0L;

String shopCartAction = path + "/portal/ngves.asiainfo.portal.order.web.ShoppingCartAction?action=";
String accountAction = path + "/portal/user/web/UserAccountAction?action=";
// 记录促销类礼品的条数
int index = 0;

//未登录取得所有的要清空的礼品的唯一标识  modified by shenfl at 2011-05-23
if(shopInfoValues != null && 0 < shopInfoValues.length){
    for(IQBOUserShopInfoValue value : shopInfoValues){
       // 取得所有要清空的礼品ID JHC是否加支付方式
       clearShopIds = clearShopIds + value.getWareId() + ",";
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
<link href="<%=request.getContextPath()%>/styles/default/shopCars.css" rel="stylesheet" type="text/css">
<ngves:version src="/scripts/CommUtil.js" type="text/javascript"/>
<ngves:version src="/scripts/sdc_jf.js" type="text/javascript"/>
</head>
<body>
<div class="shopCart">
<jsp:include page="/common/commonHead.jsp"> 
 <jsp:param value="购物车" name="name" />
 <jsp:param value="3" name="type" />
</jsp:include>
<%
//购物车为空时的样式
if( !(shopInfoValues != null && shopInfoValues.length > 0) ){
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
long amount=0L;
for(int i = 0; i < shopInfoValues.length; i++){
  amount= shopInfoValues[i].getAmount();
  String classValue = "active";
  String payType = shopInfoValues[i].getShopPayType();
  long oriPayCashL = shopInfoValues[i].getOriPayCash();
  long oriPayIntegral = shopInfoValues[i].getOriPayIntegral();
  BigDecimal oriPayCash = BigDecimal.valueOf(oriPayCashL).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
  
  boolean support = true;
  if(shopInfoValues[i].getPayType() !=null &&  shopInfoValues[i].getShopPayType() !=null && shopInfoValues[i].getPayType().indexOf(shopInfoValues[i].getShopPayType()) == -1){
	// 对于不支持的支付方式 ，不参与总计,显示不支持
  	support = false;
  } else {
	sumAmount+=amount;
	if(CommnConstant.PAY_TYPE_INTEGRAL.equals(shopInfoValues[i].getShopPayType())){
	  sumIntegral += shopInfoValues[i].getOriIntegral() * amount;
	}else{
	  sumCashL += oriPayCashL * amount;
	  sumIntegral +=oriPayIntegral * amount;
	} 
  }
  
  //判断团购礼品还是普通礼品，让其跳转到对应的页面 2012/11/16
  String warePath = TuanView.skipPath(path,shopInfoValues[i].getExchangeMode(), shopInfoValues[i].getExchangeId(),shopInfoValues[i].getWareId());
%>
    <div class="shopCarslist">
        <div class="radio">
        <%if(support){ %>
          <font id='wareFont<%=i %>' onclick="selectWare(<%=i %>)" class="active">
            <input type="checkbox" name="wareIdNum" id="wareIdNum<%=i %>" value="<%=shopInfoValues[i].getWareId()%>" checked>
          </font>
        <%} else {%>
          <font id='wareFont<%=i %>' onclick="selectWare(<%=i %>)" value="disabled1">
            <input type="checkbox" name="wareIdNum" id="wareIdNum<%=i %>" value="<%=shopInfoValues[i].getWareId()%>">
          </font> 
        <%} %>
        </div>
        <div class="Img">
             <a href="javascript:;">
               <ngves:image clazz="img" src="<%=WareShowUtil.changImgName(shopInfoValues[i].getWarePictureName(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" title="<%=shopInfoValues[i].getWareName()%>" />
             </a>
        </div>
        <%if(support){ %>
          <div class="Txt">
            <h2><a href="<%=warePath%>" title="<%=shopInfoValues[i].getWareName()%>" > <%=shopInfoValues[i].getWareName()%></a></h2>
            <p><i>
            <%
            
    		if (CommnConstant.PAY_TYPE_INTEGRAL.equals(payType)) {
    		%>
    		<%=shopInfoValues[i].getOriIntegral()%>
    		<%
    		} else {
    		  String cashPay = "&yen;" + oriPayCash + "+" + oriPayIntegral;
    		%>
    		<%=cashPay%>
    		<%
    		}
        	%>
        	</i> 
        	积分</p>
            <div class="count clearfix">
                <div class="fl">
                    <a class="minus fl" href="javascript:updateWareCount(<%=i %>,-1);">-</a>
                    <input class="fl" id="wareCount<%=i%>" type="text" value="<%=shopInfoValues[i].getAmount()%>" onblur="updateWareCount(<%=i %>,0);" />
                    <a class="plus fl" href="javascript:updateWareCount(<%=i %>,1);">+</a>
                </div>
                <span class="fr">
                <% if(CommnConstant.PAY_TYPE_INTEGRAL_CASH.equals(shopInfoValues[i].getShopPayType())){//支付方式是现金+积分
                    if("1".equals(shopInfoValues[i].getIsOnlinePay()) && "0".equals(shopInfoValues[i].getIsOfflinePay())){%>
                                                       在线支付
                  <%  }else if("0".equals(shopInfoValues[i].getIsOnlinePay()) && "1".equals(shopInfoValues[i].getIsOfflinePay())){%>
                                                       线下支付
                   <% }} %>
                </span>
            </div>
          </div>
          <input type="hidden" id="wareAmountOld<%=i%>" value="<%=shopInfoValues[i].getAmount()%>"/>
          <input type="hidden" id="wareData<%=i%>" 
            value="<%=shopInfoValues[i].getWareId()%>,<%=shopInfoValues[i].getShopPayType() %>,<%=shopInfoValues[i].getShopId() %>,<%=shopInfoValues[i].getOriIntegral() %>,<%=oriPayCash %>,<%=oriPayIntegral %>,<%=shopInfoValues[i].getIsOnlinePay() %>,<%=shopInfoValues[i].getIsOfflinePay()%>,<%=i %>,<%=shopInfoValues[i].getDeliverType()%>"/>
        <%} else {%>
          <div class="Txt">
          <h2><a href="<%=warePath%>" title="<%=shopInfoValues[i].getWareName()%>" > <%=shopInfoValues[i].getWareName()%></a></h2>
         <strong class="important">本礼品已不支持您选中的支付方式</strong></div>
         <input type="hidden" id="wareData<%=i%>" 
            value="<%=shopInfoValues[i].getWareId()%>,<%=shopInfoValues[i].getShopPayType() %>,<%=shopInfoValues[i].getIsOnlinePay() %>,<%=shopInfoValues[i].getIsOfflinePay()%>, <%=i %>"/>
        <%} %>
        </div>
<%	
}
}
if(shopInfoValues != null && shopInfoValues.length > 0){
%>
    <div id="showShopCart" class="totalAlls">
        <div class="checkAlls clearfix" style="padding-top:10px;">
            <div class="radio">
                <font id='selectAllFont' onclick="selectAll()" class="active"><input type="checkbox" checked></font>
            </div>
            <div class="count">
                <span>总计：<i id="sumIntegral">   
                <%
	            if (sumCashL<=0) {
	    		%>
	    		<%=sumIntegral%>
	    		<%
	    		} else {
	    		  sumCash = String.valueOf(BigDecimal.valueOf(sumCashL).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
	    		  String cashPay = "&yen;" + sumCash + "+" + sumIntegral;
	    		%>
	    		<%=cashPay%>
	    		<%
	    		}
	        	%>
                </i></span> 
                <span class="bala" style="display:none" >积分余额：<i>5700</i></span>
            </div>
        </div>
        <div class="move"><a id="shop_count" href="javascript:exchangeWare();">去结算(<%=sumAmount %>)</a></div>
        <div class="del"><a href="javascript:deleteWare();">删除</a></div>
    </div>
<%} %>
</section>
</div>
<!--统一底部-->
<%@include file="/common/mCommonFoot.jsp" %>

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
var path = "<%=path%>";
var delSucc = "<%=PortalCodeConstant.JF_MY_LPC_XZ_Y%>";
var delFail = "<%=PortalCodeConstant.JF_MY_LPC_XZ_N%>";
var shopCartAction = "<%=shopCartAction%>";

</script>
<!--加载JS信息-->
<ngves:version src="/scripts/userCartInfo.js" type="text/javascript"/>

</html>