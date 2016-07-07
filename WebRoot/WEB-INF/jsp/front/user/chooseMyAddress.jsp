<%@ page  contentType="text/html; charset=utf-8"%>
 <%@ include file="/jsp/common/basePath.jsp"%>

<%
	String productIds = "";
	if (null != request.getAttribute("productIds")) {
		productIds = String.valueOf(request.getAttribute("productIds"));
	}

	String shopIds = "";
	String payType = "";

	if (null != request.getAttribute("shopIds")) {
		shopIds = String.valueOf(request.getAttribute("shopIds"));
	}
	if (null != request.getAttribute("payType")) {
		payType = String.valueOf(request.getAttribute("payType"));
	}

	String amounts = (String) request.getAttribute("amounts");
	if (null == amounts || amounts.equals("")) {
		amounts = "1";
	}

	String selectPayType = (String) request.getAttribute("selectPayType");
	String userSelectAddrId = (String) request.getAttribute("userSelectAddrId");
	productIds = (String) request.getAttribute("productIds");
	shopIds = (String) request.getAttribute("shopIds");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>选择收货地址</title>
<link href="<%=request.getContextPath()%>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
 <%@include file="/jsp/common/frontCommon.jsp" %>  
</head>
<body>
<div class="pageOrder">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="我的地址" name="name" />
	<jsp:param value="6" name="type" />
</jsp:include>
<section class="chmyAdress">
 <div id="addrList">
     <c:forEach items="${dataMap.addressList}" var="address">
		
		<div class="chmyAdressMain">
		<div class="radio">
			<font  class="<c:if test="${ address.isDefault eq '1' }"> active</c:if>" >
			<input name="addressId" type="radio" value="${address.addressId}" <c:if test="${ address.isDefault eq '1' }"> checked</c:if>>
			</font>
		</div>
		<div class="info">
			<ul><li class="name"><span>${address.linkman }</span></i>
			 <i>${address.mobileNo }</i>&nbsp;&nbsp;<c:if test="${ address.isDefault eq '1' }"><cite>默认</cite></c:if></li>
			<li>${dataMap.provinceMap[address.provinceCode] } ${dataMap.cityMap[address.cityCode] } ${dataMap.countryMap[address.districtCode] } ${address.addressDetail } &nbsp;${address.postCode }</li>
			</ul>
		</div>
		<a href="">
		<div class="edit">
		<img src="<%=path%>/styles/default/images/edit1.png" /></div>
		</a>
        </div>
    </c:forEach>
    <c:if test="${fn:length(dataMap.addressList) <=0 }" >	<div class="chmyAdressMain">您还没有收获地址，点击下面的按扭添加一个吧！ </div></c:if>
 </div>
    <div style="margin-bottom: 60px"></div>
    <div class="Addelete"><div><a href="javascript:void(0)" onclick="addNewAddr()">+ 新增地址</a></div></div>
</section>

<form id="directExchangeForm" action="<%=request.getContextPath()%>/order/exchange.do" method="post">
 	<input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
	<input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
	<input type="hidden" name="payType" id="payType" value="<%=selectPayType%>"/>
	<input type="hidden" name="selectAddressId" id="selectAddressId" value=""/>
	<input type="hidden" name="proCode" id="threeCityProCode" />
	<input type="hidden" name="cityCode" id="threeCityCityCode" />
	<input type="hidden" name="disCode" id="threeCityDisCode"/>
	<input type="hidden" name="userSelectAddrId" id="userSelectAddrId"/>
</form>

<form id="addAddrForm" action="<%=request.getContextPath()%>/portal/user/web/UserAddressAction?action=selectAddrInfo" method="post">
	 <input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
	<input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
	<input type="hidden" name="payType" id="payType" value="<%=selectPayType%>"/>
	<input type="hidden" name="userSelectAddrId" id="userSelectAddrId"/>
	<input type="hidden" id="shopIds" name="shopIds" value="<%=shopIds%>"/>
</form>

<form id="orderConfirmForm" method="post" action="<%=request.getContextPath()%>/portal/order/web/UserOrderAction?action=orderDeliverInfo">
 	 <input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
	<input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
	<input type="hidden" id="shopIds" name="shopIds" value=""/>
	<input type="hidden" id="payType" name="payType" value=""/>
 
</form>
<%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/myAddress.js"></script>
<script type="text/javascript">
var path='<%=request.getContextPath()%>';
var exgType='<%="directExchange"%>';
$(document).ready(function(){
	$("#menuHead").css({"display":"none"});
	$("#operationDIY").css({"display":""});
	$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){$("#orderConfirmForm").submit();});
    
	$('.radio font').live('click',function(){ 
		var checked =$(this).find("input").attr("checked"); 
		$('.radio font').removeClass('active').find('input:radio').removeAttr('checked');
        $(this).addClass('active').find('input:radio').attr("checked",true);
        var temp =$(this).find("input").val(); 
        changeDefaultStatus(temp.split("_")[3],1);
        goOrderConfirm(temp);
        return false;
    }); 
	var goOrderConfirm = (function(temp){
		var codes = temp.split("_");
	    if("cart" == exgType){
		    $("#deliverForm input[id='threeCityProCode']").val($.trim(codes[1]));
		    $("#deliverForm input[id='threeCityCityCode']").val($.trim(codes[2]));
		    $("#deliverForm input[id='threeCityDisCode']").val($.trim(codes[3]));
	    	$("#deliverForm input[id='userSelectAddrId']").val($.trim(codes[4]));
	    	$("#deliverForm").submit();
		}else if("directExchange" == exgType){
			$("#directExchangeForm input[id='threeCityProCode']").val($.trim(codes[1]));
			$("#directExchangeForm input[id='threeCityCityCode']").val($.trim(codes[2]));
			$("#directExchangeForm input[id='threeCityDisCode']").val($.trim(codes[3]));
			$("#directExchangeForm input[id='userSelectAddrId']").val($.trim(codes[4]));
			$("#selectAddressId").val($("input[name='addressId']:checked").val());  
		    $("#directExchangeForm").submit();
		}
	});
}); 
function addNewAddr(){
	var data = $("#orderConfirmForm").serialize(); 
	window.location.href="<%=request.getContextPath()%>/member/address/addPage.do?"+data+"&from=choosePage";
}
</script>
</html>

