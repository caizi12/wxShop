<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@ page import="ngves.asiainfo.portal.m.MobileConstant"%>
<%@ page import="ngves.asiainfo.portal.order.OrderConstant" %>
<%@ page import="ngves.asiainfo.portal.order.model.NoPayOrderBean" %>
<%@ page import="ngves.asiainfo.portal.order.model.NormalOrderBean" %>
<%@ page import="ngves.asiainfo.portal.order.model.PayInfoBean" %>
<%@ page import="ngves.asiainfo.portal.order.model.ItemPayInfo" %>
<%@ page import="ngves.asiainfo.portal.order.model.PackageListInfo" %>
<%@ page import="ngves.asiainfo.portal.order.model.StackPackageBean" %>
<%@ page import="ngves.asiainfo.portal.order.model.DelivInfo" %>
<%@ page import="ngves.asiainfo.portal.order.model.WareInfo" %>
<%@ page import="ngves.asiainfo.util.StringUtil" %>
<%@ page import="ngves.asiainfo.portal.rushbuy.web.RushWareDetailFunc" %>
<%@ page import="ngves.asiainfo.portal.PortalConstant" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="ngves.asiainfo.portal.common.util.*" %>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant" %>
<%@ page import="ngves.asiainfo.portal.ware.bo.WareInfoPortalBean" %>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves" %>
<%@ page import="ngves.asiainfo.core.CoreConstant" %>
<%@ page import="ngves.asiainfo.portal.PortalCodeConstant"%>

<!DOCTYPE html>
<%
	String path = request.getContextPath();
	SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
	if(!SNAUtil.isUserLogin(sessionInfoValue)) {
		//--处理未登陆
	    response.sendRedirect(request.getContextPath() + MobileConstant.M_LOGIN_PAGE);
	    return;
	}


	NoPayOrderBean detail = null;
	NormalOrderBean normalOrder = null;
	PayInfoBean payInfo = null;
	DelivInfo delivInfoBean = null;
	List<PackageListInfo> packageListInfos = null;
	WareInfo[] wareInfoList = null;
	ItemPayInfo itemPayInfo = null;
	StackPackageBean stackPackageBean = null;
	int sumPoint = 0;
	int index = 1;
	
	if (null != request.getAttribute("noPayOrderDetail")) {
	    detail = (NoPayOrderBean) request.getAttribute("noPayOrderDetail");
	    delivInfoBean = (DelivInfo)request.getAttribute("delivInfoBean");
	    normalOrder = detail.getNormalOrderBean();
	    payInfo = normalOrder.getPayInfo();
	}
%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>订单详情_中国移动积分商城</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/pay.css" />
	<ngves:version src="/scripts/jquery-1.8.0.min.js" type="text/javascript"/>
</head>
<body>
<div class="pageOrder">
   <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="订单详情" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
	
	<section class="orderDetail">
    <div class="orderInfo">
        <ul class="act">
            <li class="gray">订单编号：<i><%=detail.getOrderID() %></i></li>
            <li>订单时间：<i><%=detail.getOrdOprTime() %></i></li>
            <li class="price">总计：
            	<%
            	long orderSumCash = detail.getNormalOrderBean().getPayInfo().getOrderSumCash();%>
          		<i>&yen;<%=StringUtil.priceFormatTo2D(orderSumCash) %>+<%=detail.getNormalOrderBean().getOrderSumPoint() %></i> &nbsp;积分</li>
            <li>支付方式：<%="01".equals(detail.getNormalOrderBean().getPayInfo().getOrderPayType())?"线上支付":"线下支付" %></li>
            <li>支付状态：<b><%=SysDataUtil.getSysParaData("900000000000005",detail.getOrderPayStatus()).getParaName() %></b></li>
            <%if(detail.getNormalOrderBean().getPayInfo().getInvoiceTitle()!=null && !"".equals(detail.getNormalOrderBean().getPayInfo().getInvoiceTitle())){ %>
            	 <li>发票信息：<%=detail.getNormalOrderBean().getPayInfo().getInvoiceTitle() %></li>
            <%} %>
        </ul>
        <%if (delivInfoBean!=null && !StringUtil.isBlank(delivInfoBean.getCusAdd())) {%>
	    <div class="receiveInfo">
	        <ul>
	        	 <li>收货人：<span><%=delivInfoBean.getCusName() %>&nbsp;&nbsp;<%=StringUtils.trimToEmpty(delivInfoBean.getCusTel()) %></span></li>
                <li><span><%=delivInfoBean.getCusAdd() %>&nbsp;&nbsp;<%=StringUtils.trimToEmpty(delivInfoBean.getCusAddCode()) %></span></li>
	        </ul>
	    </div>
	    <%} %>
    </div>
    
    <div class="wrapAll">
    <%
		sumPoint = 0;
		DelivInfo[] delivInfoList = normalOrder.getDelivInfo();
		stackPackageBean = normalOrder.getStackPackage();
		if(null != stackPackageBean){
			packageListInfos  = stackPackageBean.getPackageList() ;
				for(PackageListInfo packageListInfo : packageListInfos){
				//index用来标识包裹的序号
				++index;
				int sumPackagePoints = Integer.parseInt(packageListInfo.getPagDeliverFee())+Integer.parseInt(packageListInfo.getPagProductFee());
	        	String pagSumCash = "0.00";
	        	if(!StringUtil.isBlank(packageListInfo.getPagSumCash())){
	        		pagSumCash = packageListInfo.getPagSumCash();
	        	}
    %>
    	
    	<div class="wrap">
            <h2>
                <b>包裹<%=index-1 %></b> 
                <span>总计：<i>&yen;<%=StringUtil.stringFormatTo2D(packageListInfo.getPagSumCash()) %></i>+<i><%=sumPackagePoints %>&nbsp;积分&nbsp;&nbsp;</i> 
                </span>
            </h2>
		  <%
       		wareInfoList = packageListInfo.getItemInfo();
       		if(null!=wareInfoList && wareInfoList.length>0){
        		for(int j=0; j<wareInfoList.length; ++j){
                	//取得礼品信息，支持链接到礼品详情页
                    WareInfoPortalBean wareInfoPortalBean = OrderUtil.getWareIdAndImage(wareInfoList[j].getItemID());
                    itemPayInfo = wareInfoList[j].getItemPayInfo();
                    //用于标识是否是混合支付
                    WareInfo bean = wareInfoList[j];
                    //用于标识是否是混合支付
                    boolean flag = false;
                    if(null!=itemPayInfo){
                    	flag = true;
                    }
            %>
            <div class="mainAll clearfix">
                <%if (!"".equals(OrderUtil.getImageFileName(bean.getItemID()))) {%>
                <ngves:image id=""
                             src="<%=WareShowUtil.changImgName(wareInfoPortalBean.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>"
                             type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>"
                             title="<%=bean.getWareName() %>" clazz="img"/>
                <%} else {%>
                <img alt="<%=bean.getWareName() %>" class="img" src="<%=path%>/styles/elements/noImg.gif"/>
                <%}%>
                <div class="txt">
                    <div class="top">
                        <span><%=bean.getWareName() %></span>
                        <span>               
                        <%if(flag){%>
                        	<i>&yen;<%=StringUtil.priceFormatTo2D(itemPayInfo.getItemPayCash() +"") %></i>+<i><%=wareInfoList[j].getItemPayPoint()%></i>&nbsp;积分&nbsp;×<%=bean.getItemCount()>0?bean.getItemCount():"1" %>
                        <%}else{ %>
	                        <i><%=wareInfoList[j].getItemPayPoint() %></i>积分&nbsp;×<%=bean.getItemCount()>0?bean.getItemCount():"1" %>
                        <%} %>
                       </span>
                    </div>
                </div>
            </div>
            <%}%>
            </div>
        		<%}}} %>
</div>
</section>
<%@include file="/common/mCommonFoot.jsp" %>
</div>
</body>
<script type="text/javascript">
var position = '<%=request.getParameter("queryType")%>'; // 记录此订单是从哪个选项卡中进来的
var path = '<%=request.getContextPath()%>';
$(document).ready(function(){
	//$("#menuHead").css({"display":"none"});
	//$("#operationDIY").css({"display":""});
	//$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){
		window.location.href=path+'/portal/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&position='+position;
	});
});
</script>
</html>