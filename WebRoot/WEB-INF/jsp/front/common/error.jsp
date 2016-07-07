<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>

<%	
	String path = request.getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>页面错误_净水商城</title>
    <%@include file="/jsp/common/frontCommon.jsp" %>  
</head>
<body>
	<div class="orderFailure">
		<div class="orderFailure_part1">
		    <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
				<jsp:param value="操作失败" name="name" />
				<jsp:param value="0" name="type" />
			</jsp:include>
		    <section class="orderFailureMain">
		    	<div class="Img">
		            <img src="<%=path%>/styles/default/images/defaultError.png" />
		        </div>
		        <div class="Txt">${message }</div>
		    	<a class="failureBtn" href="javascript:history.back();" >返回</a>
		    </section>
		</div>
		<div class="orderFailure_part2">
		</div>
	</div>
</body>

<script type="text/javascript">
	function returnPage(url){
		window.location = url;
	}
</script>
</html>


