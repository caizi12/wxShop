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
<title>支付详情</title>
</head>
<body>
<section class="seeGift">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="订单支付" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
</section>
<div id="wrapper">
<div id="content">
	<div class="clear">
	openId:${dataMap.openId }
	<input type="button" value="支付" onClick="onBridgeReady();return false;"/>
 
	</div>
	<div class="wrapper_bottom">
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
           if(res.err_msg == "get_brand_wcpay_request：ok" ) {
              alert('ok')
           }else{
               alert(res.err_desc)
           }    
       }
   ); 
}

</script>
</body>
</html>