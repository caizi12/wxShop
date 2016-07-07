<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="styles.css">
 
  </head>
  <% out.print(basePath); %>
  
  <body>ohome 
     <form action="test/info.do" method="post"> 
    	姓名：<input name="name"><br/>
    	密码：<input type="password" name="password"><br/> 
    	 
    	<input type="submit" value="登陆"><br/> 
    </form>
    order:${message.orderId}<br/> 
    password:  ${message.password}<br/> 
   
     删除数据条数:  ${message.delSize}<br/> 
     更新数据条数:  ${message.updateSize}<br/> 
   <img src="resources/jquery-easyui/themes/icons/back.png"/>
   <a href="">dd</a>
  </body>
</html>
