<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>订单详情_净水商城</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/pay.css" />
<%@include file="/jsp/common/frontCommon.jsp"%>
</head>
<body>
<div class="pageOrder">
  <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp">
		<jsp:param value="订单详情" name="name" />
		<jsp:param value="0" name="type" />
</jsp:include>
<section class="orderDetail">
    <div class="orderInfo">
        <ul class="act">
            <li class="gray">订单编号：<i>${dataMap.orderInfo.orderId}</i></li>
            <li>订单时间：<i>    <fmt:formatDate value="${dataMap.orderInfo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></i></li>
            <li class="price">总计：
            <i> &yen; ${dataMap.orderInfo.orderCash}</i> &nbsp;</li>
			<li>发票信息：无</li>
        </ul>
	    <div class="receiveInfo">
	        <ul>
	   			 <li >收货人：<span> ${dataMap.orderInfo.linkman}&nbsp;&nbsp; ${dataMap.orderInfo.phone}</span></li>
	             <li><span>收获地址：${dataMap.orderInfo.address}&nbsp;&nbsp;${dataMap.orderInfo.postCode}</span></li>
	             <li><span>收获时间：${dataMap.orderInfo.sendTime}&nbsp;&nbsp;</span></li>
	             <li><span>送货方式：快递物流配送&nbsp;&nbsp;</span></li>
	        </ul>
	    </div>
	   
    </div>
    <div class="wrapAll">
 
        <div class="wrap">
            <h2>
                <b>订单</b> 
                <span style="display:none;">总计： <i>&yen;100000</i> <i>&nbsp;&nbsp;</i></span>
            </h2>
           <c:forEach var="orderInfoList" items="${dataMap.orderInfoList}">
            <h3 class="clearfix">
                <span class="fl">子订单编号：${orderInfoList.orderListId}</span>
                <b class="fr" >分拣、包装</b>
            </h3>
            <div class="mainAll clearfix">
            
                <img alt="${orderInfoList.productName }" class="img" src="<%=path%>/${orderInfoList.productImg }"/>
                <div class="txt">
                    <div class="top">
                        <span>${orderInfoList.productName }</span>
                        <span>               
                        	<i>&yen;${orderInfoList.productPrice }</i>&nbsp;×${orderInfoList.productNum }
                        </span>
                    </div>
					<!--   支付状态对于混合支付线下支付的订单，需要在子订单展示线下支付描述属性 ,线下支付的是描述-->
                    <p> 
                       <c:if test="${dataMap.orderInfo eq '1'}">
                  	   微信支付
                  	  </c:if>
                  	  <c:if test="${dataMap.orderInfo eq '1'}">
                  	   货到付款
                  	  </c:if>
                  	</p>
                    <div class="bottom clearfix">
<!--                        <span class="fl">×1</span>-->
                        <div class="fr">
                        <c:if test="${dataMap.orderInfo.payStatus eq 0}">
                           <a href="javascript:;" id="sendButton_">已支付</a>
                        </c:if>
                        <c:if test="${dataMap.orderInfo.payStatus eq 1}">
                           <a href="javascript:pay('${dataMap.orderInfo.orderId}');" id="sendButton_">立即支付</a>
                        </c:if>
                    	   <a style="display:none;" href="<%=path%>/">配送信息</a>
                        </div>
                    </div>
                </div>
            </div>
           </c:forEach>
        </div>
 </div>
</section>
 
<script type="text/javascript" src="<%=path %>/scripts/user/orderDetail.js"></script>
<%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp"%>
</div>
</body>
<script type="text/javascript">
var position = ''; // 记录此订单是从哪个选项卡中进来的
 
$(document).ready(function(){
	//$("#menuHead").css({"display":"none"});
	//$("#operationDIY").css({"display":""});
	//$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
 
});

    function pay(orderId){
      var oauth='${dataMap.oauthUrl}';
      window.location.href=oauth.replace("PARAM_STATE",orderId);
    }
</script>
</html>

