<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>

<%@page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@page import="ngves.asiainfo.portal.common.util.SNAUtil"%><html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的地址</title>
<link href="<%=request.getContextPath() %>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/scripts/jquery-1.8.0.min.js"></script>
</head>
<%
SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
sessionInfoValue.setAttribute("addrCount",0);
%>
<body>
<div class="pageOrder">
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="我的地址" name="name" />
	<jsp:param value="6" name="type" />
</jsp:include>
<section class="NomyAdress">
    <div class="NoMain">
        <div class="Img"><img src="<%=request.getContextPath() %>/styles/default/images/noAd.png" /></div>
        <div class="Txt">
            <p>您当前没有收货地址,马上新增一个吧~！</p>
        </div>
    </div>
    <form id="orderConfirmForm" method="post" action="<%=request.getContextPath()%>/portal/order/web/UserOrderAction?action=orderDeliverInfo">
	<input type="hidden" id="wareIds" name="wareIds" value="<%=request.getParameter("wareIds")%>"/>
	<input type="hidden" id="shopIds" name="shopIds" value="<%=request.getParameter("shopIds")%>"/>
	<input type="hidden" id="payTypes" name="payTypes" value="<%=request.getParameter("payTypes")%>"/>
	<input type="hidden" name="userSelectAddrId" id="userSelectAddrId" value="<%=request.getParameter("userSelectAddrId")%>"/>
	<input type="hidden" name="exgType" id="exgType" value="<%=request.getParameter("exgType")%>"/>
</form>
    <div class="Addelete"><div><a href="#" onclick="addNewAddr()">+ 新增地址</a></div></div>
</section>
</div>
</body>
<script type="text/javascript">
var path='<%=request.getContextPath() %>';
var param = "<%=request.getParameter("flag")%>";
var from = "<%=request.getAttribute("from")%>";

$(document).ready(function(){
	$("#menuHead").css({"display":"none"});
	$("#operationDIY").css({"display":""});
	$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){
		if(from=="choosePage"){
		 	$("#orderConfirmForm").submit();
		}else{
			window.location.href=path+'/mobile/user/myAccount.html';
		}
	});
});
function addNewAddr(){
	if(from=="choosePage"){
		var data = $("#orderConfirmForm").serialize(); 
		window.location.href="<%=request.getContextPath() %>/user/editMyAddress.jsp?"+data+"&from=choosePage";
	}else{
		window.location.href="<%=request.getContextPath() %>/user/editMyAddress.jsp";
	}
}
</script>
</html>