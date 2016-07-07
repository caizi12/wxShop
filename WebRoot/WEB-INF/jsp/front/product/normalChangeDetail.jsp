<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%@page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="ngves.asiainfo.portal.common.util.UrlUtil"%>

<!DOCTYPE html>
<%

	String path = request.getContextPath();
	String detailAction = path + "/portal/ware/web/WareDetailAction?";

	String wareId  = request.getParameter("wareId");
	String wareCode = request.getParameter("wareCode");
	String wareName = request.getParameter("wareName");
	String warePic = request.getParameter("warePic");
	String wareImg = request.getParameter("wareImg");
	
	String payType = request.getParameter("payType");
	String cIntegral = request.getParameter("cIntegral");
	String cPayIntegral = request.getParameter("cPayIntegral");
	String cPayCash = request.getParameter("cPayCash");
	
	String proCode = request.getParameter("proCode");
	String cityCode = request.getParameter("cityCode");
	String disCode = request.getParameter("disCode");
	
	String isShowOrderQuantity = request.getParameter("isShowOrderQuantity");
	String aMagName = request.getParameter("aMagName");
	String magAmount = request.getParameter("magCount");
	String isMagWare = request.getParameter("isMagWare");
	
	String isShowNum = request.getParameter("isShowNum");
	String wareDeliverType = request.getParameter("wareDeliverType");
	String addType = request.getParameter("addType");
	String warePath = UrlUtil.wareUrl(path, wareId); 
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>礼品详情页</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/idangerous.swiper.css" >
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/m_ware_detail_Rotate.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/newDetail.css"/>
</head>
<body>

<section class="addExchange">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="立即兑换" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
	
    <div class="addExtop clearfix">
        <a href="<%=warePath %>"><ngves:image src="<%=WareShowUtil.changImgName(warePic,WareParamConstant.WARE_SHOW_IMG_PX_110)%>" 
		         						type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" /></a>
        <h2><a href="<%=warePath %>" id="wareName"></a></h2>
        <p id="wareCode">商品编号：</p>
    </div>
    <div class="payment">
        <ul>
            <li>
		        <h2>支付方式</h2>
		        <div style="display: none" id="allIntgelArea"><a href="javascript:void(0)" onclick="changeType('01')" class="white click">积分 <i id="allIntgel"></i></a></div>
		        <div style="display: none" id="payIntgelArea"><a href="javascript:void(0)" onclick="changeType('02')" class="white">现金+ <i id="payIntgel"></i></a></div>
            </li>
        </ul>
		<div id="numAre" style="display: none">
	        <h2>数量</h2>
	        <div class="count clearfix">
	            <a href="javascript:deductAmount();"><span class="fl">-</span></a>
	            <input id="shopInventory" class="fl" size="3" value="1" maxlength="3" onblur="updateMount(<%=wareDeliverType %>);"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
	            <a href="javascript:addAmount(<%=wareDeliverType %>)"><span class="fl">+</span></a>
	        </div>
	        <p id="errorMsg" style="color:red;font-size:10px;"></p>
        </div>
    </div>
    <a class="confirm" href="javascript:thisDirectExchange();" id="exchangeId">确认</a>
</section>	


<div style="height:60px;"></div>
<jsp:include page="/common/userOperate.jsp"></jsp:include> 

<%@include file="/common/commonDialog.jsp" %>

</body>
<ngves:version src="/scripts/tab.js" type="text/javascript"/>
<ngves:version src="/scripts/CommUtil.js" type="text/javascript"/>
<ngves:version src="/scripts/idangerous.swiper.min.js" type="text/javascript"/>
<ngves:version src="/scripts/public.js" type="text/javascript"/>

<script type="text/javascript">
var path='<%=path%>';
var wareId = '<%=wareId%>';
var wareCode = '<%=wareCode%>';
var wareName = '<%=wareName%>';
var wareImg = '<%=wareImg%>';

var payType = '<%=payType%>';
var cIntegral = '<%=cIntegral%>';
var cPayIntegral = '<%=cPayIntegral%>';
var cPayCash = '<%=cPayCash%>';
var proCode = "<%=proCode%>";
var cityCode = "<%=cityCode%>";
var disCode = "<%=disCode%>";

var isShowOrderQuantity ="<%=isShowOrderQuantity%>";
var magName = "<%=aMagName%>";
var magAmount = "<%=magAmount%>";
var isMagWare = "<%=isMagWare%>";
var resultPayType="01";
var msg='';
var msg_btn='';
var messageTitle='';
//是否暂不提供兑换(期刊杂志判断所用)
var isLessWare=false;

var isShowNum = '<%=isShowNum%>';
var addType = '<%=addType%>';

$(function(){

	$("#wareName").text(wareName);
	$("#wareCode").text("商品编号："+wareCode);

	if(payType.indexOf('01') != -1){
		//期刊杂志 
		if(isMagWare == "true"){
			  var baseGsaleTotalPrice =  Number(cIntegral*parseInt(magAmount));
			  $("#allIntgel").html(baseGsaleTotalPrice);
		}else{
			$("#allIntgel").html(cIntegral);
		}
		
		$("#allIntgelArea").show();
	}
	if(payType.indexOf('02') != -1){
		if(isMagWare == "true"){
			var resultOPayCash = fomatFloat(cPayCash*parseInt(magAmount),2);
			resultOPayCash = Number(resultOPayCash).toFixed(2);
			var totalOPayIntegral =  Number(cPayIntegral*parseInt(magAmount));
			$("#payIntgel").html("￥"+resultOPayCash+" + "+totalOPayIntegral);
		}else{
			$("#payIntgel").html("￥"+cPayCash+" + "+cPayIntegral);
		}
		
		$("#payIntgelArea").show();
	}
	 //showVIPCard();
	//默认选中全积分支付方式
	if(-1!=payType.indexOf('01') && 0<=payType.indexOf('01')){
		changeType('01');
	}else{
		changeType('02');
	}
	//alert(isShowNum+">>"+isShowOrderQuantity);
	if("Y" == isShowNum && "true" ==isShowOrderQuantity){
		$("#numAre").show();
	}

	if(addType == "2"){
		$("#headName").html("加入购物车");
		$("#exchangeId").attr('href',"javascript:thisAddShopCart();");
	}
});

function thisAddShopCart() {
	var amount = $("#shopInventory").val();

	if(!isShowOrderQuantity || (g_IsNumber(amount) && amount >= 1)) {
		addShopCart();
	}else {
		msg = "请输入正确的订购数量！";
    	setDialogMessage(msg_btn, msg);
	}
}

function addShopCart(){
	var ware_amount = $("#shopInventory").val();
	//加入购物车中的现金+ 现金和积分都应是整数，所以现金扩大100
	var resultPayCash  =accMul(Number(cPayCash),100);
	doAddShoppingCart(wareId,wareName,wareImg,cIntegral,cIntegral,cIntegral,resultPayType,resultPayCash,cPayIntegral,ware_amount);
}


function changeType(obj){
	if('02'==obj){
		$('#allIntgelArea a').removeClass('click');
		$('#payIntgelArea a').addClass('click');
		resultPayType ="02";
	}else{
		$('#allIntgelArea a').addClass('click');
		$('#payIntgelArea a').removeClass('click');
		resultPayType ="01";
	}
}
function thisDirectExchange() {
	var amount = $("#shopInventory").val();
	if(!isShowOrderQuantity || (g_IsNumber(amount) && amount >= 1)) {
		directExchange();
	}else {
		show_message = '请输入正确的订购数量';
		setDialogMessage(msg_btn, show_message);
	}
}

function directExchange(){
	var amount = "";
	//---用于保存期刊杂志---
	var mags = "";
	if(isMagWare == "true"){
	   mags = magName;
	   amount = magAmount;
	} else {
	   // 不是期刊
	   amount = $("#shopInventory").val();
	}
	//alert(wareId+">>"+wareName+">>"+amount+">>"+resultPayType+">>"+proCode+cityCode+disCode+">>"+mags);
	getWareDesc(wareId,wareName,mags,amount,'',resultPayType,proCode,cityCode,disCode);
}

function updateMount(deliverType){	
	var wareNum =$("#shopInventory").val();
	if(wareNum == '' || !g_IsNumber(wareNum) || wareNum <= 0 ||(deliverType!='10'&& deliverType!='11'&&deliverType!='01'&&deliverType!='02'&&parseInt(wareNum) > 10)||wareNum.substring(0,1)=='0'){
		msg = "请输入正确的订购数量！非实物类礼品不能超过10件！";
		setDialogMessage(msg_btn, msg);
		$("#shopInventory").val("1");
	}
}
function addAmount(deliver_type){
	   var value='';
	   if($("#shopInventory").val()<10 ) {
		   value=parseInt($("#shopInventory").val())+1;
		   $("#shopInventory").val(value);
	   }else if((deliver_type=='10'||deliver_type=='11'||deliver_type=='01'||deliver_type=='02')&&($("#shopInventory").val()<999)){//全网物流配送礼品、本省物流配送礼品、本省营业厅取货礼品 可以超过10件
		   value=parseInt($("#shopInventory").val())+1;
	  	   $("#shopInventory").val(value);
	   }
}
function deductAmount() {
	if($("#shopInventory").val()>1) {
		$("#shopInventory").val(parseInt($("#shopInventory").val())-1);
	}
}


//当是VIP礼品时用户登录后需要展示对应的VIP分
function showVIPCard(){
	
	$.ajax({
	    type:"POST",
        dataType:"json",
        url:path+"/portal/ware/web/WareDetailAction?action=getUserStartIntegral",
        data:"wareId="+wareId,
        success:function(data){
        	if($.trim(data['status']) == 'Y'){
        		var aUserLevel = data['aUserLevel'];
        		var aOriIntegral = data['aOriIntegral'];
        		var aCurIntegral = data['aCurIntegral'];
        		
        		var aOriPayCash = data['aOriPayCash'];
        		var aOriPayIntegral = data['aOriPayIntegral'];
        		var aCurPayCash = data['aCurPayCash'];
        		var aCurPayIntegral = data['aCurPayIntegral'];
				//alert(aOriIntegral+">>"+aCurIntegral);
				//全积分
        		if(aOriIntegral && 0!=aOriIntegral){
        			if(aOriIntegral != aCurIntegral){
        				$("#allIntgel").html(aCurIntegral+"&nbsp;&nbsp;<del>"+aOriIntegral+"</del>");
        			}else{
        				$("#allIntgel").html(aOriIntegral);
        			}
        		}
        		//现金+
        		if(aOriPayIntegral && 0!=aOriPayIntegral){
		        	if((aOriPayIntegral != aCurPayIntegral) || (aOriPayCash != aCurPayCash)){
        				$("#payIntgel").html("￥"+aCurPayCash+" + "+aCurPayIntegral+"&nbsp;&nbsp;<del>￥"+aOriPayCash+" + "+aOriPayIntegral+"</del>");
        			}else{
        				$("#payIntgel").html("￥"+aOriPayCash+" + "+aOriPayIntegral);
        			}
        		}
        		
        		
	        	//不管用户是什么品牌,登录之后隐藏VIP优惠框，
	        	$("#tdVIPShow").hide();
        	}else if($.trim(data['status']) == 'NN'){
        		//礼品不支持用户品牌，立即兑换按钮隐藏
        		$("#exchangeId").hide();
        		
        	}else{
        		$("#tdVIPShow").show();
	        }
        }
	});
}

</script>
</html>