<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>登录_商城</title>
 
<%@include file="/jsp/common/frontCommon.jsp" %>   
</head>
<body>

<div class="pageBox">
  <div class="index">
	 <%@include file="/WEB-INF/jsp/front/common/head.jsp" %>   
   </div> 
   <form id="loginForm" action="">
    <div class="content" id="">
        <ul class="clearfix">
        	<li><p id="errorMsg" style="color:red;font-size:10px;"></p></li>
            <li>
            <div class="phone"><b class="ico01"></b>
	            <input type="text" value="请输入用户名" id="mobileNo" name="mobileNo" maxlength="11" />
            </div>
            </li>
            <li>
            <div class="password"><b class="ico02"></b>
            	<input type="password" id="password" name="password" value="" maxlength="20" />
            </div>
            </li>
            <li id="random_code_li">
            <div class="code">
            <input type="text" value="请输入验证码"  name="validCode" id="validCode" maxlength="5" />
            </div>            
            
          	<img id="valid_image" name="validCode" width="64" height="27" src="<%=path%>/jsp/common/image.jsp" title="验证码"  style="cursor: pointer" />
            <span>
            <a href="#" name="image_again">换一张</a>
            </span>
            </li>
        </ul>
    </div>
    </form>
    <div class="submit">
    	<a type="submit" />登录</a>
    </div>
 <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
</div>
</body>
<script type="text/javascript">
var targetUrl="${dataMap.targetUrl}";
</script>
<script type="text/javascript" src="<%=path%>/scripts/login.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/idangerous.swiper.min.js"></script>
</html>

