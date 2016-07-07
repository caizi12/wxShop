<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.user.ivalues.IQBOUserAddrValue"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@ page import="ngves.asiainfo.portal.m.MobileConstant"%>

<%
	IQBOUserAddrValue[] userAddrInfo = (IQBOUserAddrValue[]) request.getAttribute("userAddrInfo");
	SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
	if(!SNAUtil.isUserLogin(sessionInfoValue)) {
		//--处理未登陆
        response.sendRedirect(request.getContextPath() + MobileConstant.M_LOGIN_PAGE);
        return;
	}
	String wareIds = "";
    if (null != request.getAttribute("wareIds")) {
        wareIds = String.valueOf(request.getAttribute("wareIds"));
    }
   
    String exgType = "";
    String shopIds = "";
	String payTypes = "";
    if (null != request.getAttribute("exgType")) {
    	exgType = String.valueOf(request.getAttribute("exgType"));
        if("cart".equals(exgType)){
       	     if (null != request.getAttribute("shopIds")) {
       	    	shopIds = String.valueOf(request.getAttribute("shopIds"));
       	     }
	       	 if (null != request.getAttribute("payTypes")) {
	       	    payTypes = String.valueOf(request.getAttribute("payTypes"));
	       	 }
        }
    }
    
    String magIds = (String) request.getAttribute("magIds");
    String amount = (String) request.getAttribute("amount");
    if (null == amount || amount.equals("")) {
        amount = "1";
    }
    String wareType = (String) request.getAttribute("wareType");
    String typeCode = "";
    if (!StringUtils.isBlank((String) request.getAttribute("typeCode"))) {
        typeCode = (String) request.getAttribute("typeCode");
    }
	String writeFp = "";
	if (!StringUtils.isBlank((String) request.getAttribute("writeFp"))) {
		writeFp = (String) request.getAttribute("writeFp");
    }
	String cusCost = (String) request.getAttribute("cusCost");
	String priceGrade = (String) request.getAttribute("priceGrade");
	String selectPayType = (String) request.getAttribute("selectPayType");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>收货地址_净水商城</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
</head>
<body>
<div class="address">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="收货地址" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
    <div style="min-height:300px;background-color:#fff">
    <div class="addr-add">
        <a href='javascript:updateAddr();' class="btn-addr">+添加收货地址</a>
    </div>
	<% 
	if(null != userAddrInfo){
		for(int i = 0;i < userAddrInfo.length; i++){
	%>
		<div class="addr-info" id="addrItem_<%=userAddrInfo[i].getAddid() %>">
			<div class="addr-border">
				<div class="pd-tb10">
					<p style="padding:2px 0px 5px 5px;"><%=userAddrInfo[i].getReceivername()%><span>&nbsp; <%=StringUtils.trimToEmpty(userAddrInfo[i].getReceivertel())%></span></p>
					<p class="text-f14-c6" style="padding:2px 0px 5px 5px;"><%=userAddrInfo[i].getProvincename()%>&nbsp;<%=userAddrInfo[i].getCityname()%>&nbsp;<%=userAddrInfo[i].getCountyName()%></p>
					<p class="text-f14-c6" style="padding:2px 0px 5px 5px;"><%=StringUtils.trimToEmpty(userAddrInfo[i].getRecerveradd())%>，<span><%=userAddrInfo[i].getReceiverpostcode()%></span></p>
				</div>
				<div class="bg-border3"></div>
				<div class="addr-btn">
					<span class="tbl-type">
						
					<%if("1".equals(userAddrInfo[i].getMainFlag())){ %>
						<span class="tbl-cell" >
							<!-- 被选中状态时加 on -->
							<a href="javascript:void(0)" class="btn-chk on" name="selSpan_<%=userAddrInfo[i].getProvincecode() %>_<%=userAddrInfo[i].getCitycode() %>_<%=userAddrInfo[i].getCountyCode() %>_<%=userAddrInfo[i].getAddid() %>"  style="width:100%"><span></span>送到这里去</a>
						</span>
						<span class="text-right">
							<a href='javascript:void(0)'name="<%=userAddrInfo[i].getAddid() %>" class="btn-update"><span></span>修改</a>
						</span>
					<%}else{ %>
						<span class="tbl-cell" >
							<!-- 被选中状态时加 on -->
							<a href="javascript:void(0)" name="selSpan_<%=userAddrInfo[i].getProvincecode() %>_<%=userAddrInfo[i].getCitycode() %>_<%=userAddrInfo[i].getCountyCode() %>_<%=userAddrInfo[i].getAddid() %>"  class="btn-chk" style="width:100%"><span></span>送到这里去</a>
						</span>
						<span class="text-right">
							<a href='javascript:void(0)' name="<%=userAddrInfo[i].getAddid() %>" class="btn-update"><span></span>修改</a>
							<a href='javascript:void(0)' name="<%=userAddrInfo[i].getAddid() %>" class="btn-del"><span></span>删除</a>
						</span>
						
						<span  class="text-right" style="color:red;display: none;" id="errorMsg"></span>
					<%} %>
					</span>
				</div>
			</div>
		</div>
	<%}}%>
	</div>
	
	<form id="directExchangeForm" action="<%=request.getContextPath()%>/portal/order/web/UserOrderAction?action=directExchangeWare" method="post">
		<input type="hidden" name="wareIds" id="wareIds" value="<%=wareIds%>"/>
		<input type="hidden" name="magIds" id="magIds" value="<%=magIds%>" />
		<input type="hidden" name="amount" id="amount" value="<%=amount%>" />
		<input type="hidden" name="wareType" id="wareType" value="<%=wareType%>"/>
		<input type="hidden" name="typeCode" id="typeCode" value="<%=typeCode%>"/>
		<input type="hidden" name="writeFp" id="writeFp" value="<%=writeFp%>"/>
		<input type="hidden" name="cusCost" id="cusCost" value="<%=cusCost%>"/>
		<input type="hidden" name="priceGrade" id="priceGrade" value="<%=priceGrade%>"/>
		<input type="hidden" name="selectPayType" id="selectPayType" value="<%=selectPayType%>"/>
		<input type="hidden" name="proCode" id="threeCityProCode" />
		<input type="hidden" name="cityCode" id="threeCityCityCode" />
		<input type="hidden" name="disCode" id="threeCityDisCode"/>
		<input type="hidden" name="userSelectAddrId" id="userSelectAddrId"/>
	</form>
	
	<form id="addAddrForm" action="<%=request.getContextPath()%>/portal/user/web/UserAddressAction?action=selectAddrInfo" method="post">
		<input type="hidden" name="wareIds" id="wareIds" value="<%=wareIds%>"/>
		<input type="hidden" name="magIds" id="magIds" value="<%=magIds%>" />
		<input type="hidden" name="amount" id="amount" value="<%=amount%>" />
		<input type="hidden" name="wareType" id="wareType" value="<%=wareType%>"/>
		<input type="hidden" name="typeCode" id="typeCode" value="<%=typeCode%>"/>
		<input type="hidden" name="writeFp" id="writeFp" value="<%=writeFp%>"/>
		<input type="hidden" name="cusCost" id="cusCost" value="<%=cusCost%>"/>
		<input type="hidden" name="priceGrade" id="priceGrade" value="<%=priceGrade%>"/>
		<input type="hidden" name="selectPayType" id="selectPayType" value="<%=selectPayType%>"/>
		<input type="hidden" name="userSelectAddrId" id="userSelectAddrId"/>
		<input type="hidden" name="exgType" id="exgType" value="<%=exgType%>"/>
		<input type="hidden" id="shopIds" name="shopIds" value="<%=shopIds%>"/>
		<input type="hidden" id="payTypes" name="payTypes" value="<%=payTypes%>"/>
	</form>
	
	
	<form id="deliverForm" method="post" action="<%=request.getContextPath()%>/portal/order/web/UserOrderAction?action=orderDeliverInfo">
		<input type="hidden" id="shopIds" name="shopIds" value="<%=shopIds%>"/>
		<input type="hidden" id="wareIds" name="wareIds" value="<%=wareIds%>"/>
		<input type="hidden" id="payTypes" name="payTypes" value="<%=payTypes%>"/>
		<input type="hidden" name="proCode" id="threeCityProCode" />
		<input type="hidden" name="cityCode" id="threeCityCityCode" />
		<input type="hidden" name="disCode" id="threeCityDisCode"/>
		<input type="hidden" name="userSelectAddrId" id="userSelectAddrId"/>
	</form>

    <%@include file="/common/mCommonFoot.jsp" %>
</div>
<%@include file="/common/commonDialog.jsp" %>
</body>
<script>
var exgType = '<%=exgType%>';
var contextPath = '<%=request.getContextPath()%>';

</script>
<ngves:version src="/scripts/user/mSelectAddress.js" type="text/javascript"></ngves:version>
</html>



