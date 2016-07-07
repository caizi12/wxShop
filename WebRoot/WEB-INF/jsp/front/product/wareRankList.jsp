<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant" %>
<%@ page import="ngves.asiainfo.portal.common.util.UrlUtil" %>
<%@ page import="ngves.asiainfo.portal.PortalConstant" %>
<%@ taglib uri="/WEB-INF/portal-taglib.tld" prefix="portal" %>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves" %>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%
		String path = request.getContextPath();
		
		String topType = request.getParameter("topType");
		if (topType == null || "null".equals(topType) || "".equals(topType)){
		    topType = WareParamConstant.TOP_TYPE_HIS;
		}
		String parent_kind_id=request.getParameter("parent_kind_id");
		if(StringUtils.isBlank(parent_kind_id)){
			parent_kind_id="";
		}		
		String kind_id=request.getParameter("kind_id");
		if(StringUtils.isBlank(kind_id)){
			kind_id="";
		}
		String pageNo=request.getParameter("pageNo");
		if(StringUtils.isBlank(pageNo)){
			pageNo="";
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>兑换排行榜_中国移动积分商城</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
<style>
ul.order_listCon li.clearfix .topNum { position:absolute; float:left; padding:0 0px; color:#999;}
ul.order_listCon li.clearfix .topNum span{ font-size:12px;}
.productCtrlButton { width:100px;float:right;overflow:hidden;}
.productCtrlButton button.delete,.productCtrlButton button.favorites { background-position:0 -720px; height:19px; line-height:19px; }
.productCtrlButton button.favorites { background-position:0 -750px; }
button { border:0; cursor:pointer; font-size:12px; padding:0; }
button,button.favorites,button.delete { background:url(<%=path%>/styles/default/images/icon.gif) no-repeat 0 -390px; height:27px; width:100px;line-height:27px; }
button.dis { background-position:0 -980px;cursor:default; height:28px; line-height:28px;}
</style>
</head>
<body>
 <div class="shopCart">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="兑换排行榜" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
    <div id="rank" class="rank">
        <ul class="UL1">
              <li <%if (topType.equals(WareParamConstant.TOP_TYPE_MONTH)) {%> class="active"<%}%>>
                 <a  href="<%=UrlUtil.rankUrl(path,WareParamConstant.TOP_TYPE_MONTH,"0","0","0")%>">月排行</a></li>
              <li <%if (topType.equals(WareParamConstant.TOP_TYPE_YEAR)) {%> class="active"<%}%>>
                   <a href="<%=UrlUtil.rankUrl(path,WareParamConstant.TOP_TYPE_YEAR,"0","0","0")%>"
                     >年排行</a></li>
              <li <%if (topType.equals(WareParamConstant.TOP_TYPE_HIS)) {%> class="active"<%}%>><a
                     href="<%=UrlUtil.rankUrl(path,WareParamConstant.TOP_TYPE_HIS,"0","0","0")%>"
                     >历史排行</a></li>
              <li <%if (topType.equals(WareParamConstant.TOP_TYPE_NEW)){%> class="active"<%}%>>
                     <a  href="<%=UrlUtil.rankUrl(path,WareParamConstant.TOP_TYPE_NEW,"0","0","0")%>">
                                                       新上架排行
                    </a></li>                              
        </ul>
        <div id="rank_main" class="rank_main clearfix">
            <div class="rank_list show">
                <ul class="order_listCon clearfix"></ul>
            </div> 
         </div> 
         <div id="loading" class="list-state">                
	                <p  class="list-loading" style="display: none;">
	                    <img src="<%=path%>/styles/default/images/loading.jpg"  style="width:38px;float:left;"/>              
	                    <span>加载中,请稍候</span>
	                  </p>
	     </div>
       </div>   
    <%@include file="/common/mCommonFoot.jsp" %>   
</div>
</body>
<!--获取页面高度通用js-->
<script src="<%=path%>/scripts/listcommon.js" type="text/javascript"></script>
<script>		
    var columnHigth="";
    var contextPath="<%=path%>";
	var topType="<%=topType%>";
	var parent_kind_id="<%=parent_kind_id%>";
	var kind_id="<%=kind_id%>";
	var pageNo=1;
	var maxNo=0;
	var loading = false;//是否在加载中
	var pageAction = contextPath + "/portal/ware/web/WareRankAction?action=wareRankDispatch";
    var param="topType="+topType+"&parent_kind_id="+parent_kind_id+"&kind_id="+kind_id;
    
   
</script>
<script src="../scripts/ware/wareRankList.js" type="text/javascript"></script>
</html>
