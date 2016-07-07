<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<title>我的订单_我的账户</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/pay.css" />
		<%@include file="/jsp/common/frontCommon.jsp"%>
	</head>
	<body>
		<div class="pageOrder" style="background: #f5f5f5">
			<jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp">
				<jsp:param value="我的订单" name="name" />
				<jsp:param value="4" name="type" />
			</jsp:include>
			<section class="myOrders">
			<div id="myOred" class="myOred">
				<ul class="UL1">
					<li class="active">
						<span>待付款</span>
					</li>
					<li >
						<span>待收货</span>
					</li>
					<li>
						<span>已完成</span>
					</li>
					<li>
						<span class="line">已取消</span>
					</li>
				</ul>
				<div class="myOredCon clearfix">
					<div id="myOred_main" class="myOred_main fl">
							
						 <c:forEach var="order" items="${dataMap.orderInfoMap}"  varStatus="orderStatus">
							<div class="myOred_list" <c:if test="${orderStatus.index>0}">style="display:none"</c:if>>
							   <c:forEach var="orderInfo" items="${order}">
								<div class="myOredAll">
									<h3 class="clearfix">
										<span class="fl">订单编号：<i>${orderInfo.orderId }</i>
										</span>
										<c:if test="${orderStatus.index eq 0}">
										  <b class="fr">待付款</b>
										 </c:if>
									</h3>
									<c:forEach var="orderInfoList" items="${dataMap.orderInfoListMap[orderInfo.orderId] }">
								     <a href="<%=path %>/order/detail/${orderInfo.orderId }.do">
										<div class="mainAll clearfix">
											<img  width="90" height="90" src="<%=path%>/${orderInfoList.productImg}" />
											<div class="txt">
												<div class="top clearfix">
													<span class="fl">${orderInfoList.productName }</span>
													<span class="fr"><i>&yen;${orderInfoList.productPrice } x ${orderInfoList.productNum }</i></span>
												</div>
											</div>
										</div> 
								    </a>
							        </c:forEach>
									<div class="payTy clearfix">
										<span class="fl">总计：<i>&yen;${orderInfo.orderCash }</i>
										</span>
										<p class="fr"> 
											<c:choose>
												<c:when test="${orderStatus.index eq 0}">
												   	<a class="payBtn" href="javascript:pay('${orderInfo.orderId }')">付款</a>
												     <a class="payBtn" href="<%=path %>/order/detail/${orderInfo.orderId }.do">订单详情</a>
												</c:when>
												<c:when test="${orderStatus.index eq 1}">
												   <a class="payBtn" href="javascript:payMenoy(<%=1264564%>);">确认收货</a>
												</c:when>
												<c:when test="${orderStatus.index eq 2}">
												   <a class="payBtn" href="<%=path %>/order/detail/${orderInfo.orderId }.do">订单详情</a>
												</c:when>
											    <c:otherwise>
											     <a class="payBtn" href="<%=path %>/order/detail/${orderInfo.orderId }.do">订单详情</a>
												</c:otherwise>
											</c:choose>
										</p>
									</div>
								</div>
								</c:forEach>	     
							    <c:if test="${fn:length(order)==0}">
								  <section id="orderNoMain1">
									<img id="Img1" src="<%=path%>/styles/default/images/noorder.png" />
									<br />
									<a id="Txt1">暂无相关订单</a>
									<a id="NoBtn1" href="<%=path %>/index.do">再去逛逛</a>
						         </section>
						       </c:if>
							 </div>
						    </c:forEach>
				
					</div>
				</div>
			</div>
			</section>
			<%--  弹出层 --%>
			<%-- 公共页尾 --%>
			<div class="pageOrder_bottom">
				<%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp"%>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	var path = "<%=path%>";
	var position = "<%=100%>";
	var dingwei = "<%=12%>";
	var countor = "<%=12%>";
	$(document).ready(function() {
		//选项卡重用
		clickFun("myOred","active","myOred_main");
  
	});
	function clickFun(nav,navStyle,content){
        $("#"+nav).find("li").click(function(){
        	$("#exitPayMenoyReason").css({"display":"none"});
            $("#"+nav).find("li").removeClass(navStyle);
            $(this).addClass(navStyle);
            var index = $(this).index();
            $("#"+content).children().hide();
            $("#"+content).children("div").eq(index).show();
        });
            
    } 
    
    function pay(orderId){
      var oauth='${dataMap.oauthUrl}';
      window.location.href=oauth.replace("PARAM_STATE",orderId);
    }
 
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/accountOrder.js"></script>