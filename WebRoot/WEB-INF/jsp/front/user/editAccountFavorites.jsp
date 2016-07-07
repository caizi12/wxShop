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
      // --------查询出的总记录数----------
      int length = 0;
      if(request.getAttribute("count") != null){
          length = Integer.parseInt(request.getAttribute("count").toString());
      }
      // --------每页显示数目----------
      int rows = Integer.parseInt(UserConstant.ROW_NUM);
      if(request.getAttribute("rows") != null){
          rows = Integer.parseInt(request.getAttribute("rows").toString());
      }
      // -------显示页数索引数目---------------
      int maxIndexPages = 0;
      maxIndexPages = (int) Math.ceil(Double.parseDouble(String.valueOf(length))
                       /Double.parseDouble(String.valueOf(rows)));
      
      int all_page = maxIndexPages;
      
      if(maxIndexPages > 10){
          maxIndexPages = 10;
      }
      
      String price = "积分";
      String mobileBrand = OrderConstant.G_MOBILE_BEAND;
      SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
      if (SNAUtil.isUserLogin(sessionInfoValue)) {
  	      if(sessionInfoValue.getMobileBrand()!=null&&!sessionInfoValue.getMobileBrand().equals("")){
  	          mobileBrand = sessionInfoValue.getMobileBrand();
  	      }
  	      if(mobileBrand.equals(OrderConstant.M_MOBILE_BEAND)){
  	          price = "积分";
  	      }
  	  }else{
  		response.sendRedirect(path + OrderConstant.WEB_LOGIN_PAGE);
	    return;
  	  }
      IQBOWareInfoPortalInfoValue[] wareInfos = null;
      if(request.getAttribute("wareInfos") != null){
          wareInfos = (IQBOWareInfoPortalInfoValue[])request.getAttribute("wareInfos");
      }
      
      String pageAction = path + "/portal/user/web/UserAccountAction";
      String SHOW_USER_SHOP_ACTION = path + "/portal/order/web/ShoppingCartAction?action=showUserShopInfo";
      String accountAction = path + "/portal/user/web/UserAccountAction?action=";
      String msg = (String)request.getAttribute("msg");
      String checkCurUserLoginAction = path + "/portal/ngves.asiainfo.portal.order.web.ShoppingCartAction?action=";

%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的收藏-编辑</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/jquery.js"></script>
<link href="<%=request.getContextPath() %>/styles/default/myCollect.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="pageOrder" style="background:#f5f5f5">
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="我的收藏" name="name" />
	<jsp:param value="5" name="type" />
</jsp:include>
<section class="myCollect" style="background:#f5f5f5">
	<form action="" id="form" name="form"  method="post">
		<input type="hidden" name="wareId" id="ware_Ids" value=""/>
	 </form>
    <ul class="ligCon clearfix"></ul>
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
    <div style="margin-bottom: 40px;"></div>
    <%if(wareInfos!=null){ %>
    	<div class="delete"><div><a href="javascript:deleteByCheckBox();">删除</a></div></div>
   	<%} %>
</section>
</div>
<%@include file="/common/commonDialog.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/listcommon.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/myFavorites.js"></script>
<script type="text/javascript" >
var path = "<%=request.getContextPath()%>";
var p ="<%=request.getParameter("cur_page_no") %>";
var WARE_SHOW_IMG_PX_110 ="<%=WareParamConstant.WARE_SHOW_IMG_PX_110%>";
var TUAN_EXCHANGE_MODE ="<%=CoreConstant.WARE_DESC_TUAN_EXCHANGE_MODE%>";
var TUANBUY_URL_PREFIX ="<%=PortalConstant.TUANBUY_URL_PREFIX%>";
var WARE_URL_PREFIX ="<%=PortalConstant.WARE_URL_PREFIX%>";
var checkCurUserLoginAction = "<%=checkCurUserLoginAction%>";
var accountAction = '<%=accountAction %>';
$(document).ready(function(){
	var wareInfos = '<%=wareInfos%>';
	pageNo=0;
	viewMore_edit(pageNo);
	var pageNo=''; 
    var loading = false;//是否在加载中
    if(pageNo=="undefined"||pageNo==''||pageNo=='null'){
    	pageNo=1;
    }  
   
	$("#menuHead").css({"display":"none"});
	//$(".new_nav span a").attr("href",path+'/mobile/user/myAccount.html');
	if(wareInfos!="null"){
		$("#operationDIY").css({"display":""});
		$("#operationDIY").text("完成");
		$("#operationDIY").bind("click",function(){finishEdit();});
	}else{
		$("#operationDIY").text('');
	}

	$(window).scroll(function(){                    
        maxnum = $("#maxIndexPages").val(); //设置加载最多次数
        pageNo=$("#pageNo").val();
        var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
       if(bottomHeight<=10){
           if(!loading&&parseInt(pageNo) < parseInt(maxnum)){               	             	
        	   viewMore_edit(pageNo);  
           }                
       }
    });	
  
    $('.ligCon li').live('click',function(){
        var attrValue = $(this).find("input").attr("checked");
        if(attrValue=="checked"){
        	$(this).find("font").removeClass('active').find('input:checkbox').prop('checked',false);
        }else{
	        $(this).find("font").addClass('active').find('input:checkbox').prop('checked',true);
        }
    });
});

</script>
</body>
</html>