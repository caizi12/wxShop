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
					<li>
						<span>待付款</span>
					</li>
					<li class="active">
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
							<!--	未支付的显示	-->
							<div class="myOred_list" >
							   <c:forEach var="noPay" items="${dataMap.noPay}">
								<div class="myOredAll">
									<h3 class="clearfix">
										<span class="fl">订单编号：<i>${noPay.orderId }</i>
										</span>
										<b class="fr">待付款</b>
									</h3>
									<c:forEach var="orderInfo" items="${dataMap.orderInfoListMap[noPay.orderId] }">
								     <a href="<%=path %>/order/detail/${noPay.orderId }.do">
										<div class="mainAll clearfix">
											<img  width="90" height="90" src="<%=path%>/${orderInfo.productImg}" />
											<div class="txt">
												<div class="top clearfix">
													<span class="fl">${orderInfo.productName }</span>
													<span class="fr"><i>&yen;${orderInfo.productPrice } x ${orderInfo.productNum }</span>
												</div>
											</div>
										</div> 
								    </a>
							        </c:forEach>
									<div class="payTy clearfix">
										<span class="fl">总计：<i>￥${noPay.orderCash }</i>
										</span>
										<p class="fr">
											<a class="cancel" href="javascript:exitPayMenoy();">取消订单</a>
											<a class="payBtn" href="javascript:payMenoy(<%=1264564%>);">付款</a>
										</p>
									</div>
								</div>
								</c:forEach>
							</div>
							
						    <div class="myOred_list" >
							   <c:forEach var="noPay" items="${dataMap.waitReceive}">
								<div class="myOredAll">
									<h3 class="clearfix">
										<span class="fl">订单编号：<i>${noPay.orderId }</i>
										</span>
										<b class="fr">待付款</b>
									</h3>
									<c:forEach var="orderInfo" items="${dataMap.orderInfoListMap[noPay.orderId] }">
									<a href="<%=path %>/order/detail/${noPay.orderId }.do">
										<div class="mainAll clearfix">
											<img alt="<%=123%>" width="90" height="90" src="<%=path%>/${orderInfo.productImg}" />
											<div class="txt">
												<div class="top clearfix">
													<span class="fl">${orderInfo.productName}</span>
													<span class="fr"><i>&yen;${orderInfo.productPrice } x ${orderInfo.productNum }</span>
												</div>
											</div>
										</div> 
								    </a>
							        </c:forEach>
									<div class="payTy clearfix">
										<span class="fl">总计：<i>￥${noPay.orderCash }</i>
										</span>
										<p class="fr">
											<a class="cancel" href="javascript:exitPayMenoy();">取消订单</a>
											<a class="payBtn" href="javascript:payMenoy(<%=1264564%>);">付款</a>
										</p>
									</div>
								</div>
								</c:forEach>
							</div>
							
					      <section id="orderNoMain1">
									<img id="Img1" src="<%=path%>/styles/default/images/noorder.png" />
									<br />
									<a id="Txt1">您目前还没有<%="未完结订单"%></a>
									<a id="NoBtn1" href="javascript:goShopping();">再去逛逛</a>
						   </section>
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
 
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/accountOrder.js"></script>