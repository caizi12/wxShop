<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>新用户注册_净水商城联盟</title>
<%@include file="/jsp/common/frontCommon.jsp" %>   
<link href="<%=path %>/styles/default/account.css" rel="stylesheet" type="text/css">
</head>
<body>
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="新用户注册" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
<div class="pageBox">
 
   <form id="registerForm" action="">
    <div class="content" id="">
        <ul class="clearfix">
        	<li><p id="errorMsg" style="color:red;font-size:10px;"></p><br></li>
            <li>
	            <div class="phone"><b class="ico01"></b>
		            <input type="text" value="请输入您的手机号" id="mobileNo" name="mobileNo" maxlength="11" />
	            </div>
            </li>
            <li>
	            <div class="password"><b class="ico02"></b>
	            	<input type="text" name="pwdMsg" id="pwdMsg" value="请输入您的登录密码" maxlength="20" />
	            	<input type="password" id="password" name="password"  value="" maxlength="20" style=" display:none;" />
	            </div>
            </li>
             <li>
	            <div class="password"><b class="ico02"></b>
	            	<input type="text" name="rePwdMsg" id="rePwdMsg" value="请再次输入您的登录密码" maxlength="20" />
	            	<input type="password" id="rePassword" name="rePassword"  value="" maxlength="20" style=" display:none;" />
	            </div>
            </li>
            <li id="random_code_li">
            <div class="code" id="abcd">
            <input type="text" value="请输入手机验证码"  name="validCode" id="validCode" maxlength="8" />
            </div>            
              <input class="sms" type="button" value="获取短信验证码" id="sendSmsBtn" />
            </li>
            <c:if test="${recomendMember != null}">
             <li>
	           <div class="recomend">推广企业: <font>${recomendMember.realName }</font></div>
	            <input type="hidden" value="${recomendMember.memberId}" name="recomendId" id="recomendId" />
            </li>
            </c:if>
        </ul>
    </div>
    </form>
    <div class="submit">
    	<a type="submit" />注册</a>
    </div>
 <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
 <%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
</div>
</body>
<script type="text/javascript">
var targetUrl="${dataMap.targetUrl}";
var path="<%=path%>"
</script>
<script type="text/javascript" src="<%=path%>/scripts/register.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/idangerous.swiper.min.js"></script>
</html>

