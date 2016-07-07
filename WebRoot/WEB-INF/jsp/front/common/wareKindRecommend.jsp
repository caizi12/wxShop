<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="ngves.asiainfo.core.common.ivalues.IRecommCategoryInfoValue"%>
<%@page import="ngves.asiainfo.core.common.ivalues.IQBORecommCategoryWareInfoValue"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>
<%@page import="ngves.asiainfo.portal.PortalConstant"%>
<%@page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareKindParentValue"%>
<%@page import="ngves.asiainfo.portal.ware.model.RecommCategoryBean"%>
<%@page import="ngves.asiainfo.portal.common.util.WareKindUtil"%>
<%@page import="ngves.asiainfo.portal.common.util.UrlUtil"%>
<%@page import="java.util.*"%>
<%@page import="ngves.asiainfo.portal.util.TuanView"%>
<%@taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String contextPath = request.getContextPath();
RecommCategoryBean[] recommCategoryBeanList = WareKindUtil.getRecommCategoryBeanList();
String[] classNameList = new String[]{"selfProduct","cooperationProduct","objectProduct"};
String[] classIcon = new String[]{"t01","t02","t03"};
int classId = 0 ;
String kindResizeIds = "";
String resizeId = "";
IQBORecommCategoryWareInfoValue wareInfoValue = null;
RecommCategoryBean recommCategoryBean = null;
if(null != recommCategoryBeanList){
for(int index = 0 ; index < recommCategoryBeanList.length ; index ++) {

 recommCategoryBean = recommCategoryBeanList[index];

if(null != recommCategoryBean && ! StringUtils.isBlank(recommCategoryBean.getCategoryName())
		&& null != recommCategoryBean.getRecommWareInfo() && 1 <= recommCategoryBean.getRecommWareInfo().length ) {

String className = classNameList[classId ++ % classNameList.length] ;
IQBOWareKindParentValue[] recommInfo = recommCategoryBean.getRecommInfo();
IQBORecommCategoryWareInfoValue[] recommWareInfo = recommCategoryBean.getRecommWareInfo();
		resizeId = "recommend" + index;
		kindResizeIds += "\"" + resizeId;
		kindResizeIds += "\"" + CoreConstant.STRING_SPLIT_COMMA;
%>

<%@page import="ngves.asiainfo.core.CoreConstant"%>

<%@page import="ngves.asiainfo.portal.common.domain.WareVO"%>
<%@page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<div id="<%=className %>" class="optimiz">
	<div class="titleTxt clearfix">
	<%if(classIcon.length>index){%>
		<%if("t01".equals(classIcon[index])) {%>
			<h2 class="fl">和·优选</h2>
			<span class="fr"><a href="<%=contextPath%>/wareKindRecommend/0.html">更多</a></span>
		<%}else if("t02".equals(classIcon[index])) { %>	
			<h2 class="fl">
			<%=recommCategoryBean.getCategoryName()%>
			</h2>
			<span class="fr"><a href="<%=contextPath%>/wareKindRecommend/1.html">更多</a></span>
		<%}else if("t03".equals(classIcon[index])){  %>	
		<h2 class="fl">
			<%=recommCategoryBean.getCategoryName()%>
			</h2>
			<span class="fr"><a href="<%=contextPath%>/wareKindRecommend/2.html">更多</a></span>
		<%}%>	
	<%}else{ %>	
		<h2 class="fl">
		<%=recommCategoryBean.getCategoryName()%>
		</h2>
	<%}%>	
	</div>
	<div class="classRecommend">
	<%
	if(null != recommInfo) {
	 IQBOWareKindParentValue value = null;
	for(int i = 0 ; i < recommInfo.length ; i ++) { 
	 value = recommInfo[i] ;
		if(null != value && ! StringUtils.isBlank(value.getBigKindName())){ 
	%>
	<a href="<%=UrlUtil.bigKindUrl(contextPath, value.getWareKindParentId())%>"><%=value.getBigKindName() %></a>
	<%if(i < recommInfo.length - 1){ %> | <%}; %>
	<%}}} %>
	</div>
	<div class="marT10 clearfix">
	<%if(null != recommWareInfo) {
		for(int i = 0 ; i < recommWareInfo.length && i < 12 ; i ++ ) {
		wareInfoValue = recommWareInfo[i];
		long aCurValue = Math.max(Math.max(wareInfoValue.getGCurValue(),wareInfoValue.getMCurValue()),wareInfoValue.getECurValue());
		WareVO wareVoView = WareViewUtil.getWareVO(wareInfoValue.getWareIntegralValue(),aCurValue,wareInfoValue.getOriPayCash(),wareInfoValue.getOriPayIntegral(),wareInfoValue.getCurPayCash(),wareInfoValue.getCurPayIntegral());
		String warePath = "";
		//modify by shenfl at 2012-11-15合并团购和普通礼品跳转信息
		warePath = TuanView.skipPath(contextPath,wareInfoValue.getExchangeMode(), wareInfoValue.getExchangeId(),wareInfoValue.getWareId());
	%>
	<%if(classIcon.length>index&&index%2==0) {
		%>
		<%if(i == 0){%><div class="optimizL fl"><div class="optimizLcon clearfix">
		<%}else if(i == 1){%><div class="optimizLcon clearfix"  style="border-bottom:0;">
		<%}else{%><div class="optimizR fl" <%if(i >= 3 ) {%> style="display:none;"<%} %>><%}%>
			<%if(i < 2){%>
			<a href="<%=warePath%>">  
			<ngves:image clazz="img" src="<%=WareShowUtil.changImgName(wareInfoValue.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" />
			</a>
			<ngves:TagWareVO wareVo="<%=wareVoView %>"/>  
			<div><a title="<%=WareShowUtil.join(wareInfoValue.getWareName(),wareInfoValue.getAlias())%>" href="<%=warePath%>">
			   <%=WareShowUtil.subForMobile(wareInfoValue.getWareName(),wareInfoValue.getAlias(),48) %></a></div>
			<div>
				积分：<%=aCurValue %>
			</div>
			<%}else{%>
			<div><a title="<%=WareShowUtil.join(wareInfoValue.getWareName(),wareInfoValue.getAlias())%>" href="<%=warePath%>">
			     <%=WareShowUtil.subForMobile(wareInfoValue.getWareName(),wareInfoValue.getAlias(),48) %></a></div>
			<div>
				积分：<%=aCurValue %>
			</div>
			<a href="<%=warePath%>">  
			<ngves:image clazz="img" src="<%=WareShowUtil.changImgName(wareInfoValue.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" />
			</a>
			<ngves:TagWareVO wareVo="<%=wareVoView %>"/>  
			<%}%>
		</div>
		<%if(i==0&&i==recommWareInfo.length-1){%><div class="optimizLcon clearfix" style="border-bottom:0;"></div></div><%}%>
		<%if(i==1){%></div><%}%>
	<%}else{%>
	<%if(i == 1){%><div class="traitL fl"><div class="traitLcon clearfix">
	<%}else if(i == 2){%><div class="traitLcon clearfix"  style="border-bottom:0;">
	<%}else{%><div class="traitR fl" <%if(i >= 3 ) {%> style="display:none;"<%} %>><%}%>
		<%if(i == 1 || i == 2){%>
		<a href="<%=warePath%>">  
		<ngves:image clazz="img" src="<%=WareShowUtil.changImgName(wareInfoValue.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" />
		</a>
		<ngves:TagWareVO wareVo="<%=wareVoView %>"/>  
		<div><a title="<%=WareShowUtil.join(wareInfoValue.getWareName(),wareInfoValue.getAlias())%>" href="<%=warePath%>">
		<%=WareShowUtil.subForMobile(wareInfoValue.getWareName(),wareInfoValue.getAlias(),48) %></a></div>
		<div>
			积分：<%=aCurValue %>
		</div>
		<%}else{%>
		<div><a title="<%=WareShowUtil.join(wareInfoValue.getWareName(),wareInfoValue.getAlias())%>" href="<%=warePath%>">
		<%=WareShowUtil.subForMobile(wareInfoValue.getWareName(),wareInfoValue.getAlias(),48) %></a></div>
		<div>
			积分：<%=aCurValue %>
		</div>
		<a href="<%=warePath%>">  
		<ngves:image clazz="img" src="<%=WareShowUtil.changImgName(wareInfoValue.getMainPicFile(),WareParamConstant.WARE_SHOW_IMG_PX_110)%>" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" />
		</a>
		<ngves:TagWareVO wareVo="<%=wareVoView %>"/>  
		<%}%>
	</div>
	<%if(i==1&&i==recommWareInfo.length-1){%><div class="traitLcon clearfix" style="border-bottom:0;"></div></div><%}%>
	<%if(i == 2){%></div><%}%>
	<%}wareInfoValue = null;}}%>
	</div>
	</div>
	<%}%>
	<%}}
	if(kindResizeIds.endsWith(CoreConstant.STRING_SPLIT_COMMA)) {
		kindResizeIds = kindResizeIds.substring(0,kindResizeIds.length()-1);
	}
	kindResizeIds = "[" + kindResizeIds + "]";
%>
<script type="text/javascript"> 
  var kindResizeIds = <%=kindResizeIds%>;
</script>