<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	//如果调用此jsp必须调用public.css
	String path = request.getContextPath();	
	String prompt = request.getParameter("prompt");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="orderFailure_part1">
    	 <section class="orderFailureMain">
		    	<div class="Img">
		            <img src="<%=path%>/styles/default/images/defaultError.png" />
		        </div>
		        <div class="Txt"><%=prompt%></div>
		 </section>
   	</div>
</body>
</html>