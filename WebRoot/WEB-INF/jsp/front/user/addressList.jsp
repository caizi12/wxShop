<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的地址</title>
<link href="<%=request.getContextPath() %>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/styles/default/layout.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/scripts/jquery-1.8.0.min.js"></script>
</head>
<body>
<div class="pageOrder">
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="我的地址" name="name" />
	<jsp:param value="6" name="type" />
</jsp:include>
<section class="myAdress">
    <div id="addrList"></div>
    <div style="margin-bottom: 60px"></div>
    <div class="Addelete"><div><a href="<%=request.getContextPath() %>/user/editMyAddress.jsp">+ 新增地址</a></div></div>
</section>
<%@include file="/common/commonDialog.jsp" %>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/user/myAddress.js"></script>
<script type="text/javascript">
var path='<%=request.getContextPath() %>';
$(document).ready(function(){
	$("#menuHead").css({"display":"none"});
	$("#operationDIY").css({"display":""});
	$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){window.location.href=path+'/mobile/user/myAccount.html';});
    loadAddressInfo(); 
	$('.radio font').live('click',function(){ 
		$('.radio font').removeClass('active').find('input:radio').removeAttr('checked');
        $(this).addClass('active').find('input:radio').prop('checked',true);
        var temp =$(this).find("input").val();
        changeDefaultStatusConfirm(temp,0);
        return false;
    });   	
});
</script>
</html>












