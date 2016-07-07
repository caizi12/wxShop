<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html> 
	<head> 
		<title>生成二维码页面</title>
		<%@ include file="/jsp/common/common.jsp" %>
		<link rel="stylesheet" href="${ctx}/resources/sys/base.css" type="text/css" />
		<script type="text/javascript">
  		function createQrCode(){
  		 $.getJSON("${ctx}/weixin/qr/createQrCode.do",
  		     function(data){
			      $("#qrImg").attr("src","https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+data.ticket);
			  });
  		}
       </script>
	</head>
	<body style="height:100%">
	<input type="button" value="ok" onclick="createQrCode()"/>
	<img src="" id="qrImg">
	</body>
</html>
