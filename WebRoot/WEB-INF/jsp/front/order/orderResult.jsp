<%@ page contentType="text/html; charset=utf-8" %>
 <%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<%	
    String payPath="common";	
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>订单结果_净水商城</title>
	<%@include file="/jsp/common/frontCommon.jsp" %>  
	<link href="<%=path%>/styles/default/pay.css" rel="stylesheet" type="text/css">
 
</head>
<body>
	<div class="pageOrder">
	    <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp">
			<jsp:param value="购买成功" name="name" />
			<jsp:param value="0" name="type" />
		</jsp:include>
		<section class="exSucce">
         <div class="orderEx clearfix"><img class="fl" src="<%=request.getContextPath()%>/styles/default/images/colicon6.png" />订单提交成功</div>
         <div class="exTxt clearfix">
          <p>订单号：${dataMap.orderId }</p>
        
          <p class="price">请您尽快支付<i class="yuan">${dataMap.orderCash }</i>元，以方便工作人员第一时间给您送货！</p>
         </div>
         <div class="btn">
         <c:if test="${dataMap.payType eq '1'}">
            <a class="look" href="${dataMap.oauthUrl }">马上支付</a>
         </c:if>
         <a class="back" href="<%=path %>/order/detail/${dataMap.orderId }.do">查看订单</a>
         </div>
	     <br>
	     <br>
	     <br>
        </section>
   <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
	</div>
</body>
<script>
var isDisplayPayBtn =true
$(document).ready(function() {
		//第一次访问时系统时间取自于订单返回的时间，若用户点倒退由于浏览器缓存原因需要重新取服务器时间，不然倒计时会重新计时
		var isFirst=getCookie("isFirstRequest");
	 
});

function queryOrder(){
	window.location.href = '<%=request.getContextPath()%>'+'/asynorder/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&queryType=0&queryOrderType=1&actionId=';
}
function returnToIndexPage(){
	window.location.href = '<%=request.getContextPath()%>/order/myOrder.do';
}
//线上支付则显示
function orderPay(){
    window.location.href = "<%=request.getContextPath()%>/portal/pay/web/PaymentAction?action=skipPayPlatform&otherOrderId=&payPaymentId=01&orderType="+'<%=payPath %>';
}
</script>
</html>

