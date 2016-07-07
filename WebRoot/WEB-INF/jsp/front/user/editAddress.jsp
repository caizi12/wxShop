<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>

 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>编辑收货地址</title>
<link href="<%=request.getContextPath() %>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/styles/default/layout.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/scripts/jquery-1.8.0.min.js"></script>
</head>
 
<body>
<div class="pageOrder">
<div id="BgDiv"></div>
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="编辑收货地址" name="name" />
	<jsp:param value="5" name="type" />
</jsp:include>
<section class="editAdress">
	<form id="addressForm" action="">
	    <div class="editMain" >
	        <ul>
	        	<li class="clearfix">
	        		<p>收货人姓名：</p>
	        		<input type="text" name="receiverName" onblur="receiverNameBlur(this)"/>
	        	</li>
	        	<li>
	        		<p>联系电话：</p>
	            	<input type="text" name="receiverTel" onblur="receiverTelBlur(this)"/>
	            </li>
	            <li>
	            	<p class="chose">选择省：</p>
	            	<span class="fa-sele-box">
			            <select id="proviceArea" name="provinceName" onchange="updateProvince(this)">
	        				<input id="selProVal" name="sendProvinceCode" type="hidden"/>
	        			</select>
	        			<i id="pShow"></i>
			        </span>
           	 	</li>
           	 	<li>
	            	<p class="chose">选择市：</p>
	            	<span class="fa-sele-box">
			            <select id="cityArea" name="cityName" onchange="updateDistrict(this.value)">
	        				<input id="selCityVal" name="sendCityCode"  type="hidden"/>
	        			</select>
	        			<i id="citytip"></i>
			        </span>
	            </li>
	            <li>
	            	<p class="chose">选择区：</p>
	            	<span class="fa-sele-box">
			           <select id="countryArea" name="districtName" onchange="updateResult(this.value)">
	        				<input id="selCountryVal" name="countryCode" type="hidden"/>
	        			</select>
	        			<i id="countrytip"></i>
			        </span>
	            </li>
	            <li>
	            	<p>详细地址：</p>
	            	<textarea  id="receiverAdd" name="receiverAdd"  onblur="receiverAddrBlur(this)"></textarea>
	            </li>
	            <li>
	            	<p>邮编：</p>
	            	<input type="text"  name="receiverPostCode" onblur="receiverPostCodeBlur(this)"/>
	            </li>
	            <li class="right clearfix">
	                <input id="isDefault" name="isDefault" class="check fl" type="checkbox" /> 
	                <label class="fl" for="isDefault">设为默认地址</label>
	            </li>
	        </ul>
	    </div>
    	<div class="Addelete"><div><a href="javascript:saveAddress('<%=request.getParameter("from") %>');">保存</a></div></div>
	    <form id="orderConfirmForm" method="post" action="<%=request.getContextPath()%>/portal/order/web/UserOrderAction?action=orderDeliverInfo">
			<input type="hidden" id="wareIds" name="wareIds" />
			<input type="hidden" id="shopIds" name="shopIds" />
			<input type="hidden" id="payTypes" name="payTypes"/>
			<input type="hidden" name="userSelectAddrId" id="userSelectAddrId" />
			<input type="hidden" name="exgType" id="exgType" />
	    </form>	
	</form>
</section>
</div>
<%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/user/myAddress.js"></script>
<script type="text/javascript">
var addId = '<%=request.getParameter("addId") %>';
var path='<%=request.getContextPath() %>';
var addrCount = "";
var from = '<%=request.getParameter("from") %>';
$(document).ready(function(){
	$("#orderConfirmForm input[id='wareIds']").val('<%=request.getParameter("wareIds")%>');
	$("#orderConfirmForm input[id='shopIds']").val('<%=request.getParameter("shopIds")%>');
	$("#orderConfirmForm input[id='payTypes']").val('<%=request.getParameter("payTypes")%>');
	$("#orderConfirmForm input[id='exgType']").val('<%=request.getParameter("exgType")%>');
	$("#orderConfirmForm input[id='userSelectAddrId']").val('<%=request.getParameter("userSelectAddrId")%>');
	$(".jf-prop").css({"display":"none"});
	loadProvCity();	
	initEditMyAddress();
});
</script>
</html>