<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="ngves.asiainfo.portal.user.UserConstant"%>
<%@page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@page import="ngves.asiainfo.portal.common.util.SNAUtil" %>
<%@page import="ngves.asiainfo.portal.common.PortalCmmnConstant"%>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg"%>
<%@taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@page import="ngves.asiainfo.portal.order.OrderConstant"%>
<%@page import="ngves.asiainfo.portal.PortalConstant"%>
<%@page import="ngves.asiainfo.portal.common.domain.WareVO"%>
<%@page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<%@page import="ngves.asiainfo.portal.common.util.UrlUtil"%>
<%@page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%@page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@page import="ngves.asiainfo.portal.util.TuanView"%>
<%@page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareInfoPortalInfoValue"%>
<%@page import="ngves.asiainfo.portal.common.util.PropertyReader"%>
<%@page import="ngves.asiainfo.util.StringUtil"%>
<%@page import="ngves.asiainfo.core.common.util.WareTypeCodeEnum"%>
<%@page import="ngves.asiainfo.portal.PortalCodeConstant"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="ngves.asiainfo.core.CoreConstant"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
      String path = request.getContextPath();

	  int cur_page_no = 0;
      
      
      String pageAction = path + "/portal/user/web/UserAccountAction";
      String SHOW_USER_SHOP_ACTION = path + "/portal/order/web/ShoppingCartAction?action=showUserShopInfo";
      String accountAction = path + "/portal/user/web/UserAccountAction?action=";
      String msg = (String)request.getAttribute("msg");
      String checkCurUserLoginAction = path + "/portal/ngves.asiainfo.portal.order.web.ShoppingCartAction?action=";

%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的收藏</title>
<ngves:version src="/scripts/jquery.js" type="text/javascript"/>
<link href="<%=request.getContextPath() %>/styles/default/myCollect.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="pageOrder" style="background:#f5f5f5">
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="我的收藏" name="name" />
	<jsp:param value="5" name="type" />
</jsp:include>
<section class="myCollect" style="background:#f5f5f5">
	<div>
    <ul class="ligCon clearfix"></ul>
    </div>
    <div id="loading" class="list-state">                
       <p  class="list-loading" style="display: none;">
           <img src="<%=path%>/styles/default/images/loading.jpg"  style="width:38px;float:left;"/>              
           <span>加载中,请稍候</span>
         </p>
	</div>
	<form id="foot_form_search" method="post">
	  <input type="hidden" id="pageNo" name="pageNo" value="0"/>
	  <input type="hidden" id="maxIndexPages"  name="maxIndexPages" value="0"/>   
	</form>
</section>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/listcommon.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/myFavorites.js"></script>
<script type="text/javascript" >
var path="<%=request.getContextPath()%>";
var p ="<%=request.getParameter("cur_page_no") %>";
var WARE_SHOW_IMG_PX_110 ="<%=WareParamConstant.WARE_SHOW_IMG_PX_110%>";
var TUAN_EXCHANGE_MODE ="<%=CoreConstant.WARE_DESC_TUAN_EXCHANGE_MODE%>";
var TUANBUY_URL_PREFIX ="<%=PortalConstant.TUANBUY_URL_PREFIX%>";
var WARE_URL_PREFIX ="<%=PortalConstant.WARE_URL_PREFIX%>";

$(document).ready(function(){
	var pageNo=0; 
    var loading = false;//是否在加载中
	viewMore(pageNo);
	$("#menuHead").css({"display":"none"});
	$("#operationDIY").css({"display":""});
	$("#operationDIY").bind("click",function(){goAccountFavorites();});

 	$(window).scroll(function(){                    
        maxnum = $("#maxIndexPages").val(); //设置加载最多次数
        pageNo=$("#pageNo").val();
        var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();
       if(bottomHeight<10){
           if(!loading&&parseInt(pageNo) < parseInt(maxnum)){               	             	
           	viewMore(pageNo);                	
           }                
       }
    });	
});
</script>
</body>
</html>