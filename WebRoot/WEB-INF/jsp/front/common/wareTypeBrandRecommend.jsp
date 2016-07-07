<%@ page language="java" pageEncoding="UTF-8"  %>
<%@ page import="ngves.asiainfo.portal.ware.web.WareTypeShowRecommendAction"%>
<%@ page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@ page import="ngves.asiainfo.core.common.ivalues.IRecommCategoryInfoValue"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IWareInfoPortalValue"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%
	//全球通主推礼品
	IRecommCategoryInfoValue fgRecommCategory = WareTypeShowRecommendAction.getRecommCategroyInfoByType(WareParamConstant.BRAND_GOTONE);
	if(fgRecommCategory == null ){
		return;
	}
	IWareInfoPortalValue[] wareInfos = WareTypeShowRecommendAction.getWareTypeShowInfosByCategory(fgRecommCategory);
	int wareImgLenFG=0;
	if(null != wareInfos && wareInfos.length > 0){
	 	wareImgLenFG = wareInfos.length >5 ? 3 : wareInfos.length;   
	}
	long maxValue=0;
%>
 <div class="newRecom">
            <div class="titleTxt clearfix">
                <h2 class="fl">最新推荐</h2>
                <span class="fr"><a href="<%=path%>/gotone.html">更多</a></span>
            </div>
            <div class="marT10 clearfix">
                <%if(wareInfos != null && wareInfos.length > 0){     
		      		maxValue = Math.max(Math.max(wareInfos[0].getGCurValue(),wareInfos[0].getMCurValue()),wareInfos[0].getECurValue()); 
					%>    	       
                <div class="traitR fl"  name="<%=wareInfos[0].getWareId()%>">
                    <div><a href="<%=path%>/ware/<%=wareInfos[0].getWareId()%>.html" target="_self">
		                       <%=WareShowUtil.subForMobile(wareInfos[0].getWareName(),wareInfos[0].getAlias(),60) %>
		                    </a></div>
                    <div>积分:<%=maxValue %></div>
                    <a href="<%=path%>/ware/<%=wareInfos[0].getWareId()%>.html" target="_self">                   	       					 
					<ngves:image src="<%= WareShowUtil.changImgName(wareInfos[0].getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" 
                  	type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfos[0].getWareName() %>" 
                  	title="<%=wareInfos[0].getWareName() %>"  clazz="img" />
                  	</a>                 
                 </div> 
                <%}%>                        
                <div class="traitL fl">  
                <% 
                for(int i=1;i<wareImgLenFG;i++){ 	
		      		// 显示对应的积分/M数值
		      		maxValue = Math.max(Math.max(wareInfos[i].getGCurValue(),wareInfos[i].getMCurValue()),wareInfos[i].getECurValue());
				 %>
                    <div class="traitLcon clearfix" <%if(i==2){%>style="border-bottom:0;"<%}%>>
                       <a href="<%=path%>/ware/<%=wareInfos[i].getWareId()%>.html" target="_self">
		                  <ngves:image src="<%= WareShowUtil.changImgName(wareInfos[i].getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>"  
                  	          type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfos[i].getWareName() %>" 
                  	          title="<%=wareInfos[0].getWareName()%>"  clazz="img" />
                  	   </a>
                        <div><a href="<%=path%>/ware/<%=wareInfos[i].getWareId()%>.html" target="_self">
		     		       <%=WareShowUtil.subForMobile(wareInfos[i].getWareName(),wareInfos[i].getAlias(),48) %>
		                  </a></div>
                        <div>积分：<%=maxValue %></div>
                    </div>
                   <%}%>
                </div>               
            </div>
        </div>
