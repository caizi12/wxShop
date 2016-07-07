<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ngves.asiainfo.core.ware.util.PermissionWareViewUtil" %>
<%@ page import="ngves.asiainfo.portal.common.domain.WareVO"%>
<%@ page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant" %>
<%@ page import="ngves.asiainfo.portal.order.OrderConstant" %>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue" %>
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil" %>
<%@ page import="ngves.asiainfo.util.StringUtil"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%@ page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="java.util.List"%>
<%@page import="ngves.asiainfo.StarUtil"%>
<%@ page import="ngves.asiainfo.core.ware.model.PermissionWare"%>
<%@ page import="ngves.asiainfo.util.PropertyReader"%>
<%@ page import="ngves.asiainfo.core.CoreConstant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%
	String contextPath = request.getContextPath();
	String userMobileBrand = OrderConstant.G_MOBILE_BEAND;
	String mobileLevel = null;
	String userLocalProvince = "";
	String userStarLevel="";
	//获取成功提醒的信息
	List<PermissionWare>  permissionWareList = null;
	SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
	if (SNAUtil.isUserLogin(sessionInfoValue)) {
	    if(sessionInfoValue.getMobileBrand()!=null&&!sessionInfoValue.getMobileBrand().equals("")){
	        userMobileBrand = sessionInfoValue.getMobileBrand();
	    }
	    userStarLevel = sessionInfoValue.getUserStarLevel();
	    userLocalProvince = sessionInfoValue.getProvCode();
        //成功页面的兑换ID
		String wareIds = request.getParameter("wareIds");
		String yhFlag = "";
		if(request.getAttribute("yhFlag")!=null){
			yhFlag = (String)request.getAttribute("yhFlag");//0 或者1 
		} else {
			yhFlag = "0";//当前礼品不是有优惠礼品
		}
		//用户归属省分星级改造完成应传星级品牌
		if(StarUtil.isSupportStar(userLocalProvince)){
			permissionWareList = PermissionWareViewUtil.getPermissionHtml(wareIds,userStarLevel,userLocalProvince,WareParamConstant.IS_MOBILE_CHANNEL,yhFlag);
		}else{
			permissionWareList = PermissionWareViewUtil.getPermissionHtml(wareIds,userMobileBrand,userLocalProvince,WareParamConstant.IS_MOBILE_CHANNEL,yhFlag);
		}
		
	}else{
	    response.sendRedirect(request.getContextPath() + OrderConstant.LOGIN_PAGE);
	    return;
	}
%>
<% if (permissionWareList != null && permissionWareList.size() > 0) {  %>
<div class="permission">
	<h4 class="msg">您可用0积分直接兑换以下礼品</h4>
	<hr class="resultHr">
	<br />
	<%int parentKindIndex=0; %>
		<ul class="mainProductList clearfix">
			<%for (PermissionWare permissionWare : permissionWareList) { %>
				<% 
				String warePath = contextPath + "/ware/"+ permissionWare.getWareId() + ".html";
				String divContent = WareViewUtil.getContent(permissionWare.getIntegral(),permissionWare.getIntegral(),permissionWare.getIntegral(),permissionWare.getIntegral(),false,permissionWare.getPayType(),permissionWare.getPayCash(),permissionWare.getPayIntegral(),permissionWare.getPayCash(),permissionWare.getPayIntegral());
      			%>
				<li class="p3">
				   <div class="listItem">
						<div class="productImg">
					        <a href="<%=warePath%>">						
						        <ngves:image src="<%= WareShowUtil.changImgName(permissionWare.getPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=permissionWare.getWareName()%>" title="<%=permissionWare.getWareName()%>" />
						    </a>
						</div>
						  <h5><a title="<%=WareShowUtil.join(permissionWare.getWareName(),"")%>" href="<%=warePath%>"><%=WareShowUtil.sub(permissionWare.getWareName(),"",WareParamConstant.HOME_PAGE_WARE_SHOW_NAME_LEN_IMG) %></a></h5>
						<div class='price'>
							<%=divContent %>
						</div>
				 </div>
				</li>
				<%parentKindIndex++; %>
			<%} %>
		</ul>
</div>
<%}%>
