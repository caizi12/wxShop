<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>信息未找到...........</title>
		<meta >
	</head>
	<body style="margin:0">
		<div
			style="text-align: center; font-size: 12px; vertical-align: top; width: 100%; height: 100%; background: url('${ctx}/resources/img/common//404_bg.jpg');">
			<img src="${ctx}/resources/img/common/404.jpg" />
			<br></br>
			您请求的资源没找到,请检查输入地址是否正确，再进行重试！ 
			<br></br>
			返回到<a href="${ctx}/sys/admin_login.do">首页</a> <a href="javascript:window.close();">关闭当前页面 </a>
			
		</div>
	</body>
</html>
