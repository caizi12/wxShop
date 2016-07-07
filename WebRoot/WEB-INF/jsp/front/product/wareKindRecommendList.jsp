<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="ngves.asiainfo.core.common.ivalues.IQBORecommCategoryWareInfoValue"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%@ page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareKindParentValue"%>
<%@ page import="ngves.asiainfo.portal.ware.model.RecommCategoryBean"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareKindUtil"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.core.CoreConstant"%>
<%
	String path = request.getContextPath();
    String kindType=request.getParameter("kindType");
    int type=0;
    String menuName="";
    if(StringUtils.isNotBlank(kindType)){
    	type=Integer.parseInt(kindType);
    }
	RecommCategoryBean[] recommCategoryBeanList = WareKindUtil.getRecommCategoryBeanList();
	int classId = 0 ;
	IQBORecommCategoryWareInfoValue wareInfoValue = null;
	RecommCategoryBean recommCategoryBean=null;
	IQBORecommCategoryWareInfoValue[] recommWareInfo=null;
	if(null != recommCategoryBeanList){
	   recommCategoryBean = recommCategoryBeanList[type];
	}
	if(null != recommCategoryBean && ! StringUtils.isBlank(recommCategoryBean.getCategoryName())
			&& null != recommCategoryBean.getRecommWareInfo() && 1 <= recommCategoryBean.getRecommWareInfo().length ) {	
	IQBOWareKindParentValue[] recommInfo = recommCategoryBean.getRecommInfo();
	recommWareInfo = recommCategoryBean.getRecommWareInfo();	
	if(type==0){
		 menuName="和·优选";
     }else{
    	 menuName=recommCategoryBean.getCategoryName();
     }
  }
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<title>"<%=menuName%>"_中国移动积分商城</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
</head>
<body>
 <div class="shopCart">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="<%=menuName%>"  name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
    <div id="rank" class="rank">
        <div id="rank_main" class="rank_main clearfix">
            <div class="rank_list show">
                <ul class="order_listCon clearfix">
		          <% 
      		if(null != recommWareInfo) {
      			int wareLength=1;
      			wareLength=recommWareInfo.length>10?10:recommWareInfo.length;
      		   for(int i = 0 ; i < wareLength ; i ++ ) {
		      		wareInfoValue = recommWareInfo[i];
		      		long aCurValue = wareInfoValue.getWareIntegralValue();  
		      		long wareIntegralValue=wareInfoValue.getWareIntegralValue();
                 %>
		          <li class="clearfix"  name="<%=wareInfoValue.getWareId()%>"  <%if(i==wareLength-1){%>style="border:0;"<%}%>>
		              <a href="<%=path%>/ware/<%=wareInfoValue.getWareId()%>.html" target="_self">
			          <ngves:image src="<%= WareShowUtil.changImgName(wareInfoValue.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110) %>" id="" 
			                  	type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" alt="<%=wareInfoValue.getWareName()%>" 
			                  	title="<%=wareInfoValue.getWareName() %>" clazz="img" />
		             </a>
			          <h2 class="comList"><a href="<%=path%>/ware/<%=wareInfoValue.getWareId()%>.html" target="_self" 
			               title="<%=WareShowUtil.subWareNameTitle(wareInfoValue.getWareName()) %>
			               <%=wareInfoValue.getAlias()==null?"":wareInfoValue.getAlias() %>" > 
			               <%=WareShowUtil.subForMobile(wareInfoValue.getWareName(),wareInfoValue.getAlias(),WareParamConstant.WARENAME_SHOW_LENGTH_MOBILE) %>
			                </a> </h2>
		            <p>积分<b><%=aCurValue %></b><%if(wareIntegralValue>aCurValue){%><del><%=wareIntegralValue%></del><%}%></p>
		           </li>
			        <%}}else{ %>
			        <li class="clearfix" style="border:0;">
			          <h3>很抱歉，没有找到相关的礼品。</h3>
			        </li>
		        <%} %>                
                </ul>
            </div>       
         </div> 
       </div>   
    <%@include file="/common/mCommonFoot.jsp" %>   
</div>
</body>
<script>
        $(".liarea").click(function(){
            window.location="<%=path%>/ware/"+$(this).attr('name')+".html";
    	});
</script>
</html>
