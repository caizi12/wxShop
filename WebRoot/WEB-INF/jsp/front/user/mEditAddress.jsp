<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@ page import="ngves.asiainfo.portal.m.MobileConstant"%>
<%@ page import="ngves.asiainfo.portal.user.model.RegionBean"%>
<%@ page import="ngves.asiainfo.portal.common.util.RegionInfoUtil"%>
<%@ page import="ngves.asiainfo.portal.common.util.PropertyReader"%>
<%@ page import="ngves.asiainfo.util.StringUtil"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="ngves.asiainfo.portal.user.ivalues.IUserAddrValue" %>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<%
	SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
	if(!SNAUtil.isUserLogin(sessionInfoValue)) {
		//--处理未登陆
	    response.sendRedirect(request.getContextPath() + MobileConstant.M_LOGIN_PAGE);
	    return;
	}
	
	RegionBean[] provinceInfo = null;
	try {
		provinceInfo = RegionInfoUtil.getProvinceList();
	} catch (Exception e) {
		provinceInfo = new RegionBean[0];
		provinceInfo[0].setCode("");
		provinceInfo[0].setName("--请选择--");
		e.printStackTrace();
	}
	
	//取得限制登录省份 
	String limitProvinceStr = PropertyReader.getProperty("limit_province_code");
	List<String> limitProv = null;
	if (!StringUtil.isBlank(limitProvinceStr)) {
		limitProv = Arrays.asList(limitProvinceStr.split(","));
	}
	Gson gson = new Gson();
	Map<String,RegionBean[]> cityList = RegionInfoUtil.getCityShortList();
	Map<String,RegionBean[]> districtList = RegionInfoUtil.getDistrictShortList();
	
	String strCityInfo = gson.toJson(cityList);
	String strDistrictInfo = gson.toJson(districtList);
	
	IUserAddrValue userAddrInfo = (IUserAddrValue) request.getAttribute("userAddrInfo");
	
	String wareIds = "";
	if (null != request.getAttribute("wareIds")) {
	    wareIds = String.valueOf(request.getAttribute("wareIds"));
	}
	String exgType = "";
    String shopIds = "";
	String payTypes = "";
    if(null != request.getAttribute("exgType")) {
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
	
	String userSelectAddrId = "";
	if (!StringUtils.isBlank((String) request.getAttribute("userSelectAddrId"))) {
		userSelectAddrId = (String) request.getAttribute("userSelectAddrId");
	}
	
%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>地址编辑_净水商城</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
	<ngves:version src="/scripts/jquery-1.8.0.min.js" type="text/javascript"/>
	<ngves:version src="/scripts/CommUtil.js" type="text/javascript"/>
</head>
<body>
<div class="pageOrder">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="编辑收货人信息" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
    <h2 class="title">收货人信息</h2>
    <ul class="conUl clearfix" style="border-bottom:0;"> 
    	<li>
    		<p class="color">姓名 ：</p>
    		<input type="text" value="" name="receiverName" id="receiverName"/>
    	</li>
    	<li id="Ename" style="display: none;">
    		<span style="color:red" ></span>
    	</li>
    	
    	<li>
    		<p class="color">电话 ：</p>
    		<input type="text"  value="" name="receiverTel" id="receiverTel" maxlength="11"/>
    	</li>
    	<li id="Etel" style="display: none;">
    		<p style="color:red" ></p>
    	</li>
    	
    	<li>
    		<p class="color">邮编 ：</p>
    		<input type="text" value="" name="receiverPostCode" id="receiverPostCode" maxlength="6"/>
    	</li>
    	<li id="Epostcode" style="display: none;">
    		<p style="color:red" ></p>
    	</li>
    	
    	<li id="liCity" class="clearfix">
        	<p class="color">省份 ：</p>
        	<span class="fa-sele-box">
        	<select name="modifyProvinceCode"  id="modifyProvinceCode" onchange="initCity(this.value);" style="background-color:white;">
              	<option value="">--请选择--</option>
			<%
		    if (provinceInfo != null && provinceInfo.length > 0) {
		        for (int i = 0; i < provinceInfo.length; i++) {
		        	if(null != limitProv && limitProv.contains(provinceInfo[i].getCode()))
		        		continue;
			%>
				<option value="<%=provinceInfo[i].getCode()%>"><%=provinceInfo[i].getName()%></option>
			<%
		    	}
		    }
			%>
        	</select>
        	<i id="pShow"style="font-style:normal;"></i>
            </span>
        </li>
        
        <li class="clearfix">
        	<p class="color">城市 ：</p>
        	<span class="fa-sele-box">
	        	<select id="modifyCityCode" onchange="initDistrict(this.value);" style="background-color:white;">
	              	<option value="">--请选择--</option>
	        	</select>
	        	<i id="citytip" style="font-style:normal;"></i>
            </span>
        </li>
        
        <li class="clearfix">
        	<p class="color">区县 ：</p>
        	<span class="fa-sele-box">
	        	<select id="countryCode" onchange="updateDistrict(this.value);" style="background-color:white;">
	             	<option value="">--请选择--</option>
	       		</select>
	       		<i id="countrytip" style="font-style:normal;"></i>
            </span>
        </li>
        
        <li> 
        	<p class="important">&nbsp;注：燕郊属于河北省廊坊市三河市。</p> 
        </li>
		<li id="ECity" style="display: none;">
			<p style="color:red" ></p>
		</li>
		        
        <li style="border-bottom:0px;">
        	<p class="color">地址 ：</p>
        </li>
        <li id="Eaddress"> 
        	<textarea rows="2" style="height:auto;width:100%;" type="text" class="new-input" name="receiverAdd" id="receiverAdd"></textarea>
        </li>
        
        
    	
    	<li id="errorMsg" style="display: none;"><span style="color:red" ></span></li>
    </ul>
    <div class="submit">
    	<a >提 交</a>
    </div>
    <div class="addressPageOrder_bottom">
    <%@include file="/common/mCommonFoot.jsp" %>  
    </div>
</div>
     
    

	<form id="queryAddrForm" action="<%=request.getContextPath() %>/portal/user/web/UserAddressAction?action=queryAddrInfos" method="post">
		<input type="hidden" name="wareIds" id="wareIds" value="<%=wareIds%>"/>
		<input type="hidden" name="magIds" id="magIds" value="<%=magIds%>" />
		<input type="hidden" name="amount" id="amount" value="<%=amount%>" />
		<input type="hidden" name="wareType" id="wareType" value="<%=wareType%>"/>
		<input type="hidden" name="typeCode" id="typeCode" value="<%=typeCode%>"/>
		<input type="hidden" name="writeFp" id="writeFp" value="<%=writeFp%>"/>
		<input type="hidden" name="cusCost" id="cusCost" value="<%=cusCost%>"/>
		<input type="hidden" name="priceGrade" id="priceGrade" value="<%=priceGrade%>"/>
		<input type="hidden" name="selectPayType" id="selectPayType" value="<%=selectPayType%>"/>
		<input type="hidden" name="userSelectAddrId" id="userSelectAddrId" />
		<input type="hidden" name="exgType" id="exgType" value="<%=exgType%>"/>
		<input type="hidden" id="shopIds" name="shopIds" value="<%=shopIds%>"/>
		<input type="hidden" id="payTypes" name="payTypes" value="<%=payTypes%>"/>
	</form>
	
</body>
<script>

$(document).ready(function() {
	 <%if(userAddrInfo!=null&&userAddrInfo.getCustName()!=null&&userAddrInfo.getAddressInfo()!=null){ %>
		$("#modifyProvinceCode").val('<%=userAddrInfo.getProvinceCode()%>'); 
	 	initCity('<%=userAddrInfo.getProvinceCode()%>');
	 	$("#modifyCityCode").val('<%=userAddrInfo.getCityCode()%>');
	 	initDistrict('<%=userAddrInfo.getCityCode() %>'); 
	 	$("#countryCode").val('<%=userAddrInfo.getCountyCode()%>'); 
	 	$("#countrytip").text($("#countryCode option[value='"+'<%=userAddrInfo.getCountyCode()%>'+"']").text());
	 	
		$("#receiverName").val('<%=userAddrInfo.getCustName()==null?"":userAddrInfo.getCustName()%>');
		$("#receiverTel").val('<%=StringUtils.trimToEmpty(userAddrInfo.getCustTel())%>');
		$("#receiverAdd").val('<%=userAddrInfo.getAddressInfo()==null?"":userAddrInfo.getAddressInfo()%>');
		$("#receiverPostCode").val('<%=StringUtils.trimToEmpty(userAddrInfo.getPostCode())%>');
	 <%} %>
});
var strCityInfo= '<%=strCityInfo%>';
var strDistrictInfo = '<%=strDistrictInfo%>';
var userSelectAddrId = '<%=userSelectAddrId%>';
var getContextPath = '<%=request.getContextPath()%>';

</script>
<ngves:version src="/scripts/user/mEditAddress.js"></ngves:version>
</html>
