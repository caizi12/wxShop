<%@ page  contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>

<%
     
     //--------兑换礼品编号----------
     String productIds = "";
     if (null != request.getAttribute("productIds")) {
         productIds = String.valueOf(request.getAttribute("productIds"));
     }
     //--------兑换数量----------
     String amounts = (String) request.getAttribute("amounts");
     if (null == amounts || amounts.equals("")) {
         amounts = "1";
     }
  
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>订单详情_净水商城</title>
<link href="<%=path%>/styles/default/pay.css" rel="stylesheet" type="text/css">
<%@include file="/jsp/common/frontCommon.jsp" %>   
</head>
<body>
<div class="pageOrder">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
		<jsp:param value="确认订单" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
	<section id="confirmOrderSection" >
	<div id="errorDiv" class="code clearfix" style="display:none;" >
        	<p id="errorMsg"></p>
    </div>
 
    <div class="addAddress">
        <a id="addressLink" href='javascript:gotoAddrInfo();'>
		 <c:if test="${dataMap.memberAddress == null || fn:length(dataMap.memberAddress)==0}">
            <h3>请选择或编辑收货地址！</h3>
         </c:if>
       <c:forEach items="${dataMap.memberAddress}" begin="0" end="0" var="address">
            <div class="address" addressId="${address.addressId}">
               <h2><span id="receiverName_span">${address.linkman}</span>&nbsp;&nbsp;
               <span class="phone-num" style="margin-left:5px;" id="receiverTel_span">${address.mobileNo}</h2>
               <p><span id="proCityCountry_span">${dataMap.provinceMap[address.provinceCode]}&nbsp;${dataMap.cityMap[address.cityCode]}&nbsp;${dataMap.countryMap[address.districtCode]}</span>&nbsp;
               <span id="receiverAdd_span">${address.addressDetail}</span>，
               <span id="receiverPostCode_span">${address.postCode}</span></p>
            </div>
            <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
       </c:forEach>          
        </a>
    </div>
    <div class="confirmInfo clearfix">
        <a href="javascript:selectDeliverTimeInfoPage();">
	        <h2 class="fl">收货时间</h2>
	        <p class="fr" id="deliverTimeShow">不限时间</p>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
 
     <div class="confirmInfo clearfix">
        <a href="javascript:selectPayTypeInfoPage();">
	        <h2 class="fl">支付方式</h2>
	        <p class="fr" id="selectPayTypeShow">微信支付</p>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
        
    </div>
    <div class="confirmInfo clearfix" style="display:none">
        <a href="javascript:selectInvoiceInfoPage();">
	        <h2 class="fl">发票信息</h2>
	        <p class="fr" id="showInvoiceInfo">不开发票</p>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
    <div class="countAll clearfix">
        <a href="javascript:directToWareListPage();">
	        <ul>
	        <c:forEach items="${dataMap.orderList}" var="order">
		      <li>
 			    <img src="<%=path %>/${order.productImg }" title="${order.productName }" border="0" />
              </li>
   	         </c:forEach>
           
           	</ul>
	        <p class="price fr">共 <i>${fn:length(dataMap.orderList) }</i> 件</p>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
    
    <div class="totalAll">
    <div class="total">合计：
    
    	<i>${dataMap.orderTotalPrice }￥</i>
 
        </div>
        <div id='submitOrderDiv' class="verify"><a id="submitOrder" href="javascript:submitOrder('<%=path%>');">确认</a></div>
    </div>

    <input id="modifyProvinceCode" type="hidden"/>
    <input id="modifyCityCode" type="hidden"/>
    <input id="countryCode" type="hidden"/>
    <input id="receiverAdd" type="hidden"/>
    <input id="receiverPostCode" type="hidden"/>
    <input id="receiverName" type="hidden"/>
    <input id="receiverTel" type="hidden"/>
 
     <div class="authCode">
    	<div class="inpt">
     	<input name="orderSmsCode" class="text" id="orderSmsCode" maxlength="4" type="text" value="请输入验证码" 
     		onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
     		</div>
     	 <div class="inpt"><input class="sendBtn" type="button" value="获取短信验证码" id="sendSmsBtn" /></div>
    	</div>
     </div>
   
  	<form id="createOrderForm" name="createOrderForm" method="post" action="<%=path%>/order/create.do">
		<input type="hidden" name="linkman" id="linkman" />
		<input type="hidden" name="address" id="address"/>
		<input type="hidden" name="postCode" id="postCode"/>
		<input type="hidden" name="phone" id="phone"/>
		<input type="hidden" name="sendTime" id="sendTime"/>
		<input type="hidden" name="confirmCode" id="confirmCode"/>
		<input type="hidden" id="mDirKey" name="mDirKey" value=""/>
		<input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
		<input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
		<input type="hidden" name="addrId" id="addrId" value=""/>
	    <input type="hidden" name="payType" id="payType"/>
        <input type="hidden" name="invoiceType" id="invoiceType"/>
		<input type="hidden" name="invoiceTitle" id="invoiceTitle"/>
	</form>
	
	<form id="queryAddrForm" action="<%=path %>/member/address/choose.do" method="post">
		<input type="hidden" name="productIds" id="productIds" value="${dataMap.productIds }"/>
		<input type="hidden" name="amounts" id="amounts"  value="${dataMap.amounts }"/>
		<input type="hidden" name="payType" id="payType" value=""/>
		<input type="hidden" name="userSelectAddrId" id="userSelectAddrId" value=""/>
		<input type="hidden" name="proCode" id="proCode" value="<%=request.getParameter("proCode")%>"/>
		<input type="hidden" name="cityCode" id="cityCode" value="<%=request.getParameter("cityCode")%>"/>
		<input type="hidden" name="disCode" id=disCode value="<%=request.getParameter("disCode")%>"/>
	</form>
    </section>	
	<section id="selectDeliverTimeSection" class="invoiceInfo" style="display:none">
    <div class="invoice">
        <ul>
            <li class="clearfix">
	            <div class="radio fl">
		            <font id="0DeliverTime" onclick="selectDeliverTime(0)" class="active"><input name='deliverTime' type="radio" value="03" checked></font>
		        </div>
	            不限时间
            </li>
            <li id="1deliverTimeLi" class="clearfix">
	            <div class="radio fl">
		            <font id="1DeliverTime" onclick="selectDeliverTime(1)"><input name='deliverTime' type="radio" value="01"></font>
		        </div>
	            周一到周五
            </li>
            <li id="2deliverTimeLi" class="clearfix">
	            <div class="radio fl">
		            <font id="2DeliverTime" onclick="selectDeliverTime(2)"><input name='deliverTime' type="radio" value="02"></font>
		        </div>
	            周六日及公共假期
            </li>
        </ul>
    </div>
    <div class="btn"><a href="javascript:confirmDeliverTimeInfo();">确认</a></div>
</section>	
<section id="selectPayTypeSection" class="invoiceInfo" style="display:none">
    <div class="invoice">
        <ul>
            <li id="onlinePayLi" class="clearfix">
	            <div class="radio fl">
		            <font id="onlinePayType" onclick="selectOnOffLinePayType(1);" class="active">
		            <input name="selectOnOffLinePayType" value="1" type="radio" checked></input>
		            </font>
		        </div>
	            微信支付
            </li>
            <li id="offlinePayLi" class="clearfix">
	            <div class="radio fl">
		            <font id="offlinePayType" onclick="selectOnOffLinePayType(2);">
		            <input name="selectOnOffLinePayType" value="0" type="radio"></input>
		            </font>
		        </div>
	            货到付款
            </li>
        </ul>
    </div>
    <div class="btn"><a href="javascript:confirmPayTypeInfo();">确认</a></div>
</section>	
<section id="invoiceInfoSection" class="invoiceInfo" style="display:none">
    <div><span class="invoicePrompt">（话费类发票提供给接受话费的客户，请至当地营业厅获取现金部分的发票（充值发票或月结消费票），发票抬头与营业厅提供为准。）</span></div>
    <div class="invoice">
        <ul>
            <li class="clearfix">
	            <div class="radio fl">
		            <font id="0InvoiceInfo" onclick="selectInvoiceInfo(0);" class="active"><input name='invoiceInfo' value="0" type="radio" checked></font>
		        </div>
	            不开发票
            </li>
            <li class="clearfix">
	            <div class="radio fl">
		            <font id="1InvoiceInfo" onclick="selectInvoiceInfo(1);"><input name='invoiceInfo' value="1" type="radio"></font>
		        </div>
	            个人
            </li>
            <li id="2InvoiceInfoLi" class="clearfix">
	            <div class="radio fl">
		            <font id="2InvoiceInfo" onclick="selectInvoiceInfo(2);"><input name='invoiceInfo' value="2" type="radio"></font>
		        </div>
	            单位
	            <input id='invoiceInfoTitle' class="txt" size="30" maxlength="30" type="text" value="" />
            </li>
        </ul>
    </div>
    <div class="btn"><a href="javascript:confirmInvoiceInfo();">确认</a></div>
</section>	
<section id="orderWareListSection" class="goodsList" style="display:none">
    <div class="goodsAll">
        <ul>
             <c:forEach items="${dataMap.orderList}" var="order">
		      <li class="clearfix">
            	<img src="<%=path %>/${order.productImg }">
            	<h2> ${order.productName }</h2>
            	<p class="price">
	    	        <i>${order.price }</i>
	                &nbsp;积分&nbsp;×${order.amount }
            	</p>
		        <span>-&nbsp;物流配送</span>
            </li>
   	       </c:forEach>
        </ul>
    </div>
</section>	
</div>
   <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
   <%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
<ngves:version src="/scripts/CommUtil.js" type="text/javascript"/>

<script type="text/javascript">
var selectPayType ='';

var secs = 60;
var wait = secs * 1000;//一分钟
var totalCount = ${fn:length(dataMap.orderList) };
var productIds = "<%=productIds%>";
var mobileNo = '';
var path='<%=path%>';

var confirmCodeUrl=path+"/portal/ngves.asiainfo.portal.order.web.UserOrderAction?action=sendConfirmCode";

$(document).ready(function() {
	$("#confirmButton").attr('disabled',false);
	$("#submit_order").attr('disabled',false);
	$("#confirmButton").removeClass('noclick');
    $("#submit_order").attr('href',"");

    
    //设置省市区下拉选
    <%if(null!=null){ %>
	 	$("#modifyProvinceCode").val('bj'); 
	 	$("#modifyCityCode").val('100'); 
	 	$("#countryCode").val(''); 
	<%}%>

    $('.radio font:last-child').css('margin-right',0);
});

function rtnSubmitOrder(){
	$("#submitOrder").attr('disabled',false);
	$("#rtnSubmitOrder").attr('href',"javascript:submitOrder(path)");
	$("#rtnSubmitOrder").css("background","#e42121");
}
</script>

<script src="<%=path%>/scripts/directConfirmInfo.js"></script>
<script src="<%=path%>/scripts/confirmInfo.js"></script>
</body>
</html>