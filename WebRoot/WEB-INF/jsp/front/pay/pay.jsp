<!DOCTYPE html>
<%@ page  contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<meta name="keywords" content="" />
<meta name="format-detection" content="telephone=no"/>  
<%@include file="/jsp/common/frontCommon.jsp" %>  
<link href="<%=path%>/styles/default/pay.css" rel="stylesheet" type="text/css">
<title>微信安全支付</title>
</head>
<body>
<section class="seeGift">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="订单支付" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
</section>
<div id="wrapper">
	 <section class="exSucce">
	  <div class="btn">
         <a class="look" href="javascript:onBridgeReady();">重新支付</a>
         <a class="back" href="<%=path %>/order/detail/${dataMap.orderId}.do">查看订单</a>
     </div>
    </section>
	<div class="wrapper_bottom">
		</br></br></br>
		<%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp"%>
	</div>
</div>
<script type="text/javascript"> 
$(function(){
	if (typeof WeixinJSBridge == "undefined"){
	   if( document.addEventListener ){
	       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	   }else if (document.attachEvent){
	       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
	       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
	   }
	}else{
	   onBridgeReady();
	}
});
 
 function onBridgeReady(){
   WeixinJSBridge.invoke(
       'getBrandWCPayRequest', {
           "appId":"${dataMap.appId}",     
           "timeStamp":"${dataMap.timeStamp}",   
           "nonceStr":"${dataMap.nonceStr}",   
           "package":"prepay_id=${dataMap.prepay_id}",     
           "signType":"${dataMap.signType}", 
           "paySign":"${dataMap.paySign}" 
       },
       function(res){  
           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
             window.location.href="<%=path %>/order/detail/${dataMap.orderId}.do"
           }else if(res.err_msg == "get_brand_wcpay_request:fail" ) {
              alert('支付失败：'+res.err_desc);
           }
           //else if(res.err_msg == "get_brand_wcpay_request:cancel"){
          //    window.location.href="<%=path %>/order/detail/${dataMap.orderId}.do"
          // } 
       }
   ); 
}

</script>
</body>
</html>