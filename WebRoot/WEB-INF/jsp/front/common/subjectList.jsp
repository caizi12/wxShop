<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant" %>
<%@ page import="ngves.asiainfo.core.common.ivalues.IWareKindInfoValue" %>
<%@ page import="ngves.asiainfo.core.common.ivalues.IWareFirstKindRltValue" %>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareKindParentValue"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareKindValue"%>
<%@ page import="ngves.asiainfo.portal.ware.web.WareGuideAction" %>
<%@ page import="ngves.asiainfo.core.common.ivalues.IQBOWareKindParentRltValue"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="ngves.asiainfo.portal.common.util.WareKindUtil"%>
<%@ taglib uri="/WEB-INF/portal-taglib.tld" prefix="portal" %>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves" %>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%
		String path = request.getContextPath();	
		String bigKind = request.getParameter("bigKind");
		if(StringUtils.isBlank(bigKind)){
		   response.sendRedirect("/common/mEorror.jsp");
		}	
		String bigKindName="";
	  	IWareKindInfoValue[] selfChildKindInfos = WareGuideAction.getChildKindInfo(WareGuideAction.KIND_ID_SELF);
	  	IWareKindInfoValue[] coopChildKindInfos = WareGuideAction.getChildKindInfo(WareGuideAction.KIND_ID_COOPERATION);
	  	IWareKindInfoValue[] objChildKindInfos = WareGuideAction.getChildKindInfo(WareGuideAction.KIND_ID_OBJECT);
		IWareKindInfoValue[] thirdChildKindInfos = WareGuideAction.getChildKindInfo(WareGuideAction.KIND_ID_THIRD);
		//三个分组中包含的大类列表
	  	IWareKindInfoValue[][] all = new IWareKindInfoValue[][]{selfChildKindInfos ,thirdChildKindInfos, coopChildKindInfos , objChildKindInfos};
	  	for(IWareKindInfoValue[] bigChinlKindInfos : all){
		  	if(null != bigChinlKindInfos && bigChinlKindInfos.length > 0){ 
		  		//循环大类
		        for(IWareKindInfoValue bidKindInfo : bigChinlKindInfos){
		        	if(bidKindInfo.getKindId()==Long.parseLong(bigKind)){
		        		bigKindName=bidKindInfo.getKindName();
		        		break;
		        	}
		        }
		  	}
	  	}
	  	//用来记录中类包含的小类列表
		List<IQBOWareKindValue> sGuideAll = new ArrayList<IQBOWareKindValue>();		        	
       	//此大类是否至少包含一个小类
       	boolean bigShow = false ;
       	String initsKind=request.getParameter("sKind");
       	Long sKind=0l;
       	if(StringUtils.isNotBlank(initsKind)){
			sKind=Long.parseLong(initsKind);
		} 			
   		IQBOWareKindParentRltValue[] parentKindInfos = WareGuideAction.getParentKindInfo(Long.parseLong(bigKind));
   		
   		int currentSelectedValueIndex = 0;
   		if(null != parentKindInfos && parentKindInfos.length >0){
   			//循环大类下的中类
   			for	(IQBOWareKindParentRltValue parentKind : parentKindInfos){
   				//查询出中类包含的小类 
   				IQBOWareKindValue[] wareKindValues = WareKindUtil.getWareKind(parentKind.getWareKindParentId());
   				//至少包含一个小类
   				if(null != wareKindValues && wareKindValues.length >= 1) {
   					if(0l==sKind){
   					   sKind=wareKindValues[0].getWareKindId();
   					}  					
   					for(IQBOWareKindValue  wareKindValue:wareKindValues){
   						if(sKind==wareKindValue.getWareKindId()){
   							currentSelectedValueIndex = sGuideAll.size();
   						}
   						sGuideAll.add(wareKindValue);
   					}                  
   				}
   			}
   		}
   		
   	    //用来记录中类包含的小类列表
		List<IQBOWareKindValue> sGuide = new ArrayList<IQBOWareKindValue>();
   		List<IQBOWareKindValue> sGuideDisplay = new ArrayList<IQBOWareKindValue>();	
   		if(sGuideAll.size()<=3){
   			//若类目总数量<3则直接展示
   			sGuideDisplay = sGuideAll;
   		} else if(currentSelectedValueIndex<3){
   			//当前选择的小类排在前三名 直接显示前三名
   			sGuideDisplay.add(sGuideAll.get(0));
   			sGuideDisplay.add(sGuideAll.get(1));
   			sGuideDisplay.add(sGuideAll.get(2));
   			for(int i=3;i<sGuideAll.size();i++){
   				sGuide.add(sGuideAll.get(i));
   			}
   		} else if(sGuideAll.size()-(currentSelectedValueIndex+1)<3){
   			//当前选择的小类排在后三名 直接显示后三名
   			sGuideDisplay.add(sGuideAll.get(sGuideAll.size()-3));
   			sGuideDisplay.add(sGuideAll.get(sGuideAll.size()-2));
   			sGuideDisplay.add(sGuideAll.get(sGuideAll.size()-1));
   			for(int i=0;i<sGuideAll.size()-3;i++){
   				sGuide.add(sGuideAll.get(i));
   			}
   		} else {
   			//3个类别一行
   			int num = currentSelectedValueIndex+1;
   			int showColumn = num%3==0?num/3:num/3+1;
   			int startIndex = (showColumn-1)*3;
			sGuideDisplay.add(sGuideAll.get(startIndex));
			sGuideDisplay.add(sGuideAll.get(startIndex+1));
			sGuideDisplay.add(sGuideAll.get(startIndex+2));
			for(int i=0;i<startIndex;i++){
   				sGuide.add(sGuideAll.get(i));
   			}
			for(int i=startIndex+3;i<sGuideAll.size();i++){
   				sGuide.add(sGuideAll.get(i));
   			}
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
<title>大类列表页_中国移动积分商城</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/public.css" />
</head>
<body>
 <div class="ligeList">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="<%=bigKindName %>"  name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
    <section class="ligeListMain">       
     <div class="ligeListNav">
         <%if(sGuideDisplay.size()>0){ %>
        	 <div class="conN clearfix">
        	  <ul class="main clearfix">
  	    	 <%IQBOWareKindValue kindInfo=null;
        	   for(int i=0;i<sGuideDisplay.size();i++){
                 kindInfo=sGuideDisplay.get(i);
            	 if(kindInfo.getWareKindId()==sKind){%>   
            		<li class="active">
			        <a href="<%=path%>/subject/<%=bigKind%>_<%=kindInfo.getWareKindId()%>.html"><%=kindInfo.getKindName()%></a>
  	    	        </li>
    	       <%} else {%>   
    		        <li>
    		        <a href="<%=path%>/subject/<%=bigKind%>_<%=kindInfo.getWareKindId()%>.html"><%=kindInfo.getKindName()%></a>
    		        </li>
	           <%}
               } %>
    	       </ul>
        	 <%if(sGuide.size()>0){ %>
       	       <div class="point fr"><a href="javascript:showMore();"><img src="<%=path%>/styles/default/images/point.png"></a></div>
        	   <div class="conHide"  style="display: none;">
        	   <ul>
        	   <% 
        	     for(int i=0;i<sGuide.size();i++){ 
        	    	 kindInfo=sGuide.get(i);
        		     if(null!=kindInfo){%>
	                    <li><a href="<%=path%>/subject/<%=bigKind%>_<%=kindInfo.getWareKindId()%>.html"><%=kindInfo.getKindName()%></a></li>
	                 <%}
        		 } %>
	            </ul>
	            </div> 
             <%} } %>	        
         </div>    	
         <ul class="ligeCon clearfix">
         <div id="nothingFoundDiv" style="display:none;margin: 0 auto;padding: 0;">
         <section class="orderFailureMain">
	    	<div class="Img">
	            <img src="<%=path%>/styles/default/images/defaultError.png" />
	        </div>
	        <div class="Txt">很抱歉，没有找到相关的礼品</div>
    	 </section>
    	 </div>
         </ul>            
	            <div id="loading" class="list-state">                
	                <p  class="list-loading" style="display: none;">
	                    <img src="<%=path%>/styles/default/images/loading.jpg" class="loadimg" style="width:38px;float:left;"/>              
	                    <span>加载中,请稍候</span>
	                  </p>
	            </div>
	            <%@include file="/common/mCommonFoot.jsp" %>   
        </div>
    </section>
</div>
<form id="foot_form_search" method="post"> 
	<input type="hidden" id="sKind" name="sKind"  value="<%=sKind %>"/>
	<input type="hidden" id="pageNo" name="pageNo" value="<%=pageNo %>"/>
	<input type="hidden"  id="maxIndexPages"  name="maxIndexPages"/>
</form>
</body>
<!--获取页面高度通用js-->
<script src="<%=path%>/scripts/listcommon.js" type="text/javascript"></script>
<script>
	  contextPath='<%=path%>',
	  rows='<%=WareParamConstant.ROW_NUM_MOBILE_SUBJECT%>';
	
</script>
<ngves:version src="/scripts/subjectList.js" type="text/javascript"/>
</html>
