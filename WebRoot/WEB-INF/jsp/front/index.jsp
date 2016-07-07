<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<title>首页_净水商城</title>
     <%@include file="/jsp/common/frontCommon.jsp" %>   
</head>
<body style="background:#f5f5f5">
	<div class="pageBox">
	  <%@include file="/WEB-INF/jsp/front/common/pageFlashAd.jsp" %>   
	    <div class="index">
	        <%@include file="/WEB-INF/jsp/front/common/head.jsp" %>      
	        <!-- 楼层推荐 -->
	        <%@include file="/WEB-INF/jsp/front/common/floorRecommend.jsp" %> 
	        <!-- 楼层推荐 -->
	        
	        <!-- 按分值浏览 -->
	        <div class="score" style="display:none;">
	            <div class="titleTxt clearfix">
	                <h2 class="fl">按分值浏览</h2>
	                <span class="fr"></span>
	            </div>
	            <div class="marT10">
	                <a class="number" href="&valueLevel=1">0-1000</a>
	                <a class="number" href="&valueLevel=2">1000-2000</a>
	                <a class="number" href="&valueLevel=3">2000-3000</a>
	                <a class="number" href="&valueLevel=4">3000-5000</a>
	                <a class="number" href="&valueLevel=5">5000-10000</a>
	                <a class="number" href="&valueLevel=6">10000以上</a>
	            </div>
	        </div>
	        <!-- 按分值浏览 -->
	    </div>
	    <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
	</div>
 
</body>
</html>

