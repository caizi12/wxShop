<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的账户</title>
<%@include file="/jsp/common/frontCommon.jsp" %>  
<link href="<%=path %>/styles/default/account.css" rel="stylesheet" type="text/css">
<style type="text/css">
.commonHead{max-width:640px;min-width:320px;margin:0 auto;}
</style>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
		<jsp:param value="我的账户" name="name" />
		<jsp:param value="4" name="type" />
	</jsp:include>
<section class="myAccount clearfix">
    <div class="user clearfix">
        <div class="person clearfix" style="display:">
            <div class="Img fl">
                <img src="<%=path%>/styles/default/images/person.png" />
                <img class="die" src="<%=path%>/styles/default/images/head.png" />
            </div>
            <div class="fl">
                <div class="name"></div>
                <div class="tel clearfix"><i class="fl">${memberSessionInfo.mobileNo}</i> <cite class="fl"></cite> 
                <span class="fl star${memberStarLevel}"></span></div>
                <div class="price">可用积分：<i>${memberSessionInfo.canPoint}</i></div>
            </div>
        </div>
        <div class="nologin clearfix" style="display:none">
        	<div class="Img">
        	<img src="<%=path%>/styles/default/images/nologin.png" />
            </div>
            <div class="msg">登陆享受商城更多优惠</div>
        </div>
        <ul class="attr" style="display:none">
            <li>
                <a href="javascript:;">
                <div class="wait"><img src="<%=path%>/styles/default/images/colicon9.png" /></div>待付款
                </a>
            </li>
            <li>
                <a href="javascript:;">
                <div class="goods"><img src="<%=path%>/styles/default/images/colicon10.png" /></div>未完结
                </a>
            </li>
            <li>
                <a href="javascript:;">
                <div class="end"><img src="<%=path%>/styles/default/images/colicon11.png" /></div>已完成
                </a>
            </li>
        </ul>
    </div>
    <div class="column-list">
        <ul>
            <li class="order">
            	<a href="javascript:;">
	            	<div><img src="<%=path%>/styles/default/images/colicon1.png" /></div>
	            	<span>我的订单</span>
            	</a>
            </li>
            <li class="shop">
                <a href="javascript:;">
                    <div><img src="<%=path%>/styles/default/images/colicon2.png" /></div>
                    <span>购物车</span>
                </a>
            </li>
            <li class="addr">
            	<a href="javascript:;">
	            	<div><img src="<%=path%>/styles/default/images/colicon4.png" /></div>
	            	<span>收货地址</span>
            	</a>
            </li>
            <li class="record">
            	<a href="javascript:;">
	            	<div><img src="<%=path%>/styles/default/images/colicon5.png" /></div>
	            	<span>我的浏览</span>
            	</a>
            </li>
            <li class="native" style="">
                <a href="javascript:;">
                    <div><img src="<%=path%>/styles/default/images/colicon12.png" /></div>
                    <span>我的积分</span>
                </a>
            </li>
        </ul>
    </div>
</section>
   <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
</body>

<script>
var isLogin = false;

init();

function init(){
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/portal/user/web/UserAccountAction?action=queryUserInfo&channel=9&time=" + (new Date().getTime().toString(36)),
		dataType:"json",
		success:function(data){
			if(data.isLogin == "FAIL"){
				$(".user .person").css("display","none");
				$(".user .nologin").css("display","block");
				isLogin = false;
			}else{
				$(".user .person").css("display","block");
				$(".user .nologin").css("display","none");
				$(".tel i").text(data.userMobile);
				$(".tel cite").text(data.mobileProvinceName);
				if(undefined != data.userStarLevel && data.userStarLevel!="undefined" && data.userStarLevel!=""){
					$(".tel span").addClass("star"+data.userStarLevel);
				}
				$(".price i ").text(data.userScore);
				isLogin = true; 
			}
		}
	});
}

window.onload = function(){
	var toLogin = function (){
		window.location="/m/login/login.jsp?target=/m/mobile/user/myAccount.html"; 
	}
	
	//$(".new_nav span a").attr("href","<%=request.getContextPath()%>"+"/index.html");
	
	$(".nologin img").click(function(){
		window.location="/m/login/login.jsp?target=/m/mobile/user/myAccount.html";
	});
	
	$(".wait").click(function(){
		//if(isLogin){
			window.location="/m/portal/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&dingwei=0";
		//}else{
		//	toLogin();
		//}
		
	});

	$(".goods").click(function(){
		//if(isLogin){
			window.location="/m/portal/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&dingwei=1";
		//}else{
		//	toLogin();
		//}
	});

	$(".end").click(function(){
		//if(isLogin){
			window.location="/m/portal/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&dingwei=2";
		//}else{
		//	toLogin();
		//}
	});

	$(".order").click(function(){
		//if(isLogin){
			window.location=path+"/order/myOrder.do";
		//}else{
		//	toLogin();
		//}
	});
	
	$(".collect").click(function(){
		//if(isLogin){
			window.location="/m/portal/user/web/UserAccountAction?action=showUserFavoriteWare";
		//}else{
		//	toLogin();
		//}
	});

	$(".record").bind("click",function(){
		//if(isLogin){
			window.location="/m/mobile/user/browsHistory.jsp";
		//}else{
		//	toLogin();
		//}
	});

	$(".shop").bind("click",function(){
		//if(isLogin){
			window.location="/m/portal/order/web/ShoppingCartAction?action=showUserShopInfo";
		//}else{
		//	toLogin();
		//}
	});
	$(".addr").bind("click",function(){
		//if(isLogin){
			window.location=path+"/member/address/list.do";
		//}else{
		//	toLogin();
		//}
	});
	$(".native").bind("click",function(){
		//if(isLogin){
			window.location="/m/ware/wareCommonList.jsp?action=searchLocalWareInfo";
		//}else{
		//	toLogin();
		//}
	});
};
</script>
</html>