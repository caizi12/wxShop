<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的收藏</title>
<link href="<%=request.getContextPath() %>/styles/default/myCollect.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="pageOrder" >
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="我的收藏" name="name" />
	<jsp:param value="5" name="type" />
</jsp:include>
<section class="NomyCollect">
    <div class="NoMain">
        <div class="Img"><img src="<%=request.getContextPath() %>/styles/default/images/noCo.png" /></div>
        <div class="Txt">
            <p>您目前还没有收藏礼品哦~</p>
            <p>马上去找喜欢的礼品吧！</p>
        </div>
        <div class="go"><a href="<%=request.getContextPath() %>/index.html">再去逛逛</a></div>
    </div>
</section>
<script type="text/javascript">
var path='<%=request.getContextPath() %>';
var param = "<%=request.getParameter("flag")%>";
$(document).ready(function(){
	$("#menuHead").css({"display":"none"});
	$("#operationDIY").css({"display":""});
	$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){
		window.location.href=path+'/mobile/user/myAccount.html'
	});
});
</script>
</div>
</body>
</html>














