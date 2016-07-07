<!DOCTYPE html>
<%@ page  contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>

<%
request.setAttribute("dataMap",request.getAttribute("dataMap"));
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<meta name="keywords" content="" />
<meta name="format-detection" content="telephone=no"/>  
<%@include file="/jsp/common/frontCommon.jsp" %>  
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/idangerous.swiper.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/m_ware_detail_Rotate.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/detail.css"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/newDetail.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
<title>商品详情</title>
</head>
<body>
<section class="seeGift">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="商品详情" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
</section>
<div id="wrapper">
<%-- 首页公共头内容区域 --%>
<div id="content">
    	<div id="conWrapper">
      		<div id="mainContent" class="top">
				<div id="mainContentInfo">				
					<!--礼品基本信息-->		
		 
						 <%@include file="/WEB-INF/jsp/front/product/wareBasicInfo.jsp" %> 
					
    				<div class="clear"></div>
   				</div><!--mainContentInfo结束-->
  			</div><!--mainContent结束-->
	  	</div><!--conWrapper结束-->
		<div class="clearFix"></div>
	</div> <!--content结束-->
	<div class="clear"></div>
	<!--统一底部-->
	<div class="wrapper_bottom">
   <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
	</div>
	<div style="height:60px;"></div>
 
	 
</div><!--wrapper结束-->
<script src="<%=path%>/scripts/city_district.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/directConfirmInfo.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/ware_common_form.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/tabPanels.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/jcookie.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/jquery.bxSlider.min.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/jquery.jqzoom1.0.1.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/ZeroClipboard.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/idangerous.swiper.min.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/tab.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/CommUtil.js" type="text/javascript"></script>

 
<script type="text/javascript">
var path="<%=path%>";
initProvince();
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
  if($("#proviceArea option:selected").val()=='bj'){
     $("#hasProductNum").text("有货");
  }else{
    $("#hasProductNum").text("无货");
  }
  
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
	updateDistrict();
}

//加载县区列表1.2
function updateDistrict(){
	$("#cityShow").text($("#cityArea option:selected").text());
	
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
	$("#countryShow").text($("#countryArea option:selected").text());
}


function updateResult(){
	$("#countryShow").text($("#countryArea option:selected").text());
}
</script>
</body>
</html>