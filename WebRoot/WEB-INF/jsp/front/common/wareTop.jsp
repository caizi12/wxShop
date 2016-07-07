<%@ page language="java" contentType="text/html; charset=UTF-8" %>   
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@ page import="ngves.asiainfo.portal.ware.web.WareTopAction"%>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@ page import="ngves.asiainfo.portal.common.util.UrlUtil"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IWareInfoPortalValue"%>
<%@ page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%
    String path=request.getContextPath();
    String topType = request.getParameter("topType");
    String showLocal = "false";
    String[] provinceCodes = new String[1];
    showLocal = request.getParameter("showLocal");
    if("false".equals(showLocal)){
        provinceCodes[0] = WareParamConstant.GLOBAL_WARE;
    }else{
        SessionInfoValue userInfo = SNAUtil.getLoginUserInfo(request);
        if(SNAUtil.isUserLogin(userInfo)){
            provinceCodes[0] = userInfo.getProvCode();
        }else{
            provinceCodes[0] = WareParamConstant.GLOBAL_WARE;
        }
    }
    int topNum = WareParamConstant.TOP_LIST_NUM_MOBILE;
    if(request.getParameter("topNum") != null){
        topNum = Integer.parseInt(request.getParameter("topNum"));
    }
    IWareInfoPortalValue[] wareInfos = WareTopAction.getWareTimeTop(topType, topNum, provinceCodes);
    long maxValue=0;
    long wareIntegralValue=0;
%>

<div class="optimiz">
            <div class="titleTxt clearfix">
                <h2 class="fl">兑换排行榜</h2>
                <span class="fr"><a href="<%=UrlUtil.rankUrl(path,WareParamConstant.TOP_TYPE_HIS,"0","0","0")%>">更多</a></span>
            </div>
            <div class="marT10 clearfix">
                <div class="optimizL fl">
                    <div class="optimizLcon clearfix">
                    <% if(wareInfos != null && wareInfos.length > 0){	       
		      		// 显示对应的积分/M数值
		      		maxValue = Math.max(Math.max(wareInfos[0].getGCurValue(),wareInfos[0].getMCurValue()),wareInfos[0].getECurValue());
					wareIntegralValue = wareInfos[0].getWareIntegralValue(); 
					 %>
					<a href="<%=path%>/ware/<%=wareInfos[0].getWareId()%>.html" target="_self">
					<ngves:image src="<%= WareShowUtil.changImgName(wareInfos[0].getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" 
                  	type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfos[0].getWareName() %>" 
                  	title="<%=wareInfos[0].getWareName() %>"  clazz="img" />
                  	</a>
	                    <div>
	                       <a href="<%=path%>/ware/<%=wareInfos[0].getWareId()%>.html" target="_self">
	                           <%=WareShowUtil.subForMobile(wareInfos[0].getWareName(),wareInfos[0].getAlias(),60) %>
	                       </a>
	                     </div>
	                    <div>积分：<%=maxValue %></div>	                
                   <%}%>
                    </div>
                    <div class="optimizLcon clearfix" style="border-bottom:0;">
                    <% if(wareInfos != null && wareInfos.length > 1){	       
		      		  maxValue = Math.max(Math.max(wareInfos[1].getGCurValue(),wareInfos[1].getMCurValue()),wareInfos[1].getECurValue());
					  wareIntegralValue = wareInfos[1].getWareIntegralValue(); 
					 %>
					<a href="<%=path%>/ware/<%=wareInfos[1].getWareId()%>.html" target="_self">
					<ngves:image src="<%= WareShowUtil.changImgName(wareInfos[1].getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" 
                  	type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfos[1].getWareName() %>" 
                  	title="<%=wareInfos[1].getWareName() %>"  clazz="img" />
                  	</a>
	                    <div>
	                       <a href="<%=path%>/ware/<%=wareInfos[1].getWareId()%>.html" target="_self">
	                          <%=WareShowUtil.subForMobile(wareInfos[1].getWareName(),wareInfos[1].getAlias(),60) %>
	                       </a>
	                    </div>
	                    <div>积分：<%=maxValue %></div>	                
                   <%}%>
                    </div>
                </div>
                <div class="optimizR fl">
                    <% if(wareInfos != null && wareInfos.length > 2){	       
		      		  maxValue = Math.max(Math.max(wareInfos[2].getGCurValue(),wareInfos[2].getMCurValue()),wareInfos[2].getECurValue());
					  wareIntegralValue = wareInfos[2].getWareIntegralValue(); 
					 %>					 
                    <div>
	                       <a href="<%=path%>/ware/<%=wareInfos[2].getWareId()%>.html" target="_self">
	                           <%=WareShowUtil.subForMobile(wareInfos[2].getWareName(),wareInfos[2].getAlias(),46) %>
	                       </a>
	                </div>
                    <div>积分：<%=maxValue %></div>
	                <a href="<%=path%>/ware/<%=wareInfos[2].getWareId()%>.html" target="_self">
					<ngves:image src="<%= WareShowUtil.changImgName(wareInfos[2].getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" 
                  	type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfos[2].getWareName() %>" 
                  	title="<%=wareInfos[2].getWareName() %>"  clazz="img" />
                  	</a>	                
                   <%}%>
                </div>
            </div>
 </div>