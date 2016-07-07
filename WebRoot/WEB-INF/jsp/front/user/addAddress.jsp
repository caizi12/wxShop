<%@ page   contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>新增收货地址</title>
<link href="<%=request.getContextPath() %>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
 <%@include file="/jsp/common/frontCommon.jsp" %>  
</head>
 
<body>
<div class="pageOrder">
<div id="BgDiv"></div>
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="编辑收货地址" name="name" />
	<jsp:param value="5" name="type" />
</jsp:include>
<section class="editAdress">
	<form id="addressForm" action="">
	    <div class="editMain" >
	        <ul>
	        	<li class="clearfix">
	        		<p>收货人姓名：</p>
	        		<input type="text" name="linkman" onblur="receiverNameBlur(this)"/>
	        	</li>
	        	<li>
	        		<p>联系电话：</p>
	            	<input type="text" name="mobileNo" onblur="receiverTelBlur(this)"/>
	            </li>
	            <li>
	            	<p class="chose">选择省：</p>
	            	<span class="fa-sele-box">
	            	<input id="provinceCode" name="provinceCode" type="hidden"/>
			            <select id="proviceArea" name="provinceName" onchange="updateCity()">
	        			</select>
	        			<i id="provinceShow"></i>
			        </span>
           	 	</li>
           	 	<li>
	            	<p class="chose">选择市：</p>
	            	<span class="fa-sele-box">
	            	     <input id="cityCode" name="cityCode"  type="hidden"/>
			            <select id="cityArea" name="cityName" onchange="updateDistrict()">
	        			</select>
	        			<i id="cityShow"></i>
			        </span>
	            </li>
	            <li>
	            	<p class="chose">选择区：</p>
	            	<span class="fa-sele-box">
			           <select id="countryArea" name="countryArea" onchange="updateResult()">
	        			</select>
	        			<input id="districtCode" name="districtCode" type="hidden"/>
	        			<i id="countryShow"></i>
			        </span>
	            </li>
	            <li>
	            	<p>详细地址：</p>
	            	<textarea  id="addressDetail" name="addressDetail"  onblur="receiverAddrBlur(this)"></textarea>
	            </li>
	            <li>
	            	<p>邮编：</p>
	            	<input type="text"  name="postCode" onblur="receiverPostCodeBlur(this)"/>
	            </li>
	            <li class="right clearfix">
	                <input id="isDefault" name="isDefault" class="check fl" value="1" type="checkbox" style="width:14px"/> 
	                <label class="fl" for="isDefault">设为默认地址</label>
	            </li>
	        </ul>
	    </div>
    	<div class="Addelete"><div><a href="javascript:saveAddress();">保存</a></div></div>
	</form>
	  <form id="orderConfirmForm" method="post" name="orderConfirmForm" action="<%=request.getContextPath()%>/order/exchange.do">
			  <input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
		     <input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
		     
			<input type="hidden" id="shopIds" name="shopIds" value="<%=request.getParameter("shopIds")%>"/>
			<input type="hidden" id="payType" name="payType" value="<%=request.getParameter("payType")%>"/>
			<input type="hidden" name="amount" id="amounts" value="<%=request.getParameter("amounts")%>" />
			
			<input type="hidden" name="proCode" id="threeCityProCode"  value="<%=request.getParameter("proCode")%>"/>
			<input type="hidden" name="cityCode" id="threeCityCityCode"  value="<%=request.getParameter("cityCode")%>"/>
			<input type="hidden" name="disCode" id="threeCityDisCode"  value="<%=request.getParameter("disCode")%>"/>
	    </form>	
</section>
</div>
</body>
<%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
<script src="<%=path%>/scripts/city_district.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/user/myAddress.js"></script>
<script type="text/javascript">
var addId = '<%=request.getParameter("addId") %>';
var path='<%=request.getContextPath() %>';
var addrCount = "1";
var from = '<%=request.getParameter("from") %>';
var exgType = '<%=request.getParameter("exgType")%>'; 
$(document).ready(function(){			
	initProvince();
	//initEditMyAddress();
});
 
 

function initProvince(){
	var proviceSelect;
	if (jsonProvinceInfo!=null){
		var provinceCode="";
		var provinceName="";
		var option="";
		for(var i=0;i<jsonProvinceInfo.length;i++){
			 provinceCode = jsonProvinceInfo[i]['code'];
			 provinceName = jsonProvinceInfo[i]['name'];
			 option += '<option value="'+provinceCode+'">'+provinceName+'</option>';
		} 
		
	 	$("#proviceArea").append(option);
	    $("#proviceArea option[value='bj']").attr("selected","true");
	    
	    $("#provinceShow").text($("#proviceArea option[value='bj']").text());
	    
	 }
	 updateCity();
}
 
function updateCity(){
  
  $("#provinceShow").text($("#proviceArea option:selected").text());
  $("#provinceCode").val($("#proviceArea option:selected").val());
  
  var selProvinceCode = $("#proviceArea").val();
  var cityInfo_select=$("#cityArea");
	
	var cityInfo = jsonCityInfo[selProvinceCode];
	if(cityInfo!=null){
		var option = '';
		for(var i=0;i<cityInfo.length;i++){
			var cityCode = cityInfo[i]['code'];
			var cityName = cityInfo[i]['name'];
			option += '<option value="'+cityCode+'">'+cityName+'</option>';
		} 
		cityInfo_select.html(option);
	}
 
	$("#cityShow").text($("#cityArea option:selected").text());
	 $("#cityCode").val($("#cityArea option:selected").val());
	updateDistrict();
}

//加载县区列表
function updateDistrict(){
	$("#cityShow").text($("#cityArea option:selected").text());
	 $("#cityCode").val($("#cityArea option:selected").val());
	
    var selectCityCode = $("#cityArea").val();
	var districtInfo_select=$("#countryArea");
	var districtInfo = jsonDistrictInfo[selectCityCode];
	if(districtInfo!=null){
		var option = "";
		for(var i=0;i<districtInfo.length;i++){
			var countryCode = districtInfo[i]['code'];
			var countryName = districtInfo[i]['name'];
			 if(i==0){
			  option += '<option value="'+countryCode+'" selected>'+countryName+'</option>';
			 }else{
			  option += '<option value="'+countryCode+'">'+countryName+'</option>';
			 }
			
		}
		districtInfo_select.html(option);
	}	
   $("#districtCode").val($("#countryArea option:selected").val());
	$("#countryShow").text($("#countryArea option:selected").text());
}


function updateResult(){
    $("#districtCode").val($("#countryArea option:selected").val());
	$("#countryShow").text($("#countryArea option:selected").text());
}

</script>
</html>