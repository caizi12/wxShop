<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@ page import="ngves.asiainfo.portal.user.UserConstant"%>
<%@ page import="ngves.asiainfo.portal.user.model.DelivStatusInfo"%>
<%@ page import="ngves.asiainfo.portal.PortalCodeConstant"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.util.DateTimeUtil"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>物流详情_净水商城</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/public.css" />
</head>
<body>
<div class="shopCart">
<jsp:include page="/common/commonHead.jsp"> 
	<jsp:param value="订单轨迹" name="name" />
	<jsp:param value="0" name="type" />
</jsp:include>
<%
DelivStatusInfo[] delivStatusInfos = (DelivStatusInfo[])request.getAttribute("delivStatusInfos");
String path = request.getContextPath();	
if(null != delivStatusInfos && delivStatusInfos.length > 0){
	int i = 1;
%>
	<div>
		<div class="shopCart2">
			<div class="part1"> 
				<p>订单号&nbsp;:&nbsp;<%=request.getParameter("subOrderId") %></p>
			</div>
		</div>
		<div class="shopCart3">
		</div>
		<div class="shopCart4">
			<div class="part2">
			<ul class="part2_ul">
				<% for(DelivStatusInfo delivStatusInfo : delivStatusInfos){
					
				if (i == 1){%>
				<li class="part2_ul_li_blue">
					<span class="part2_ul_li_time_blue">
						<%=UserConstant.getShowTime(delivStatusInfo.getDelivTime())%>&nbsp;&nbsp;<%=delivStatusInfo.getDelivAddress()%>&nbsp;&nbsp;<%=delivStatusInfo.getOperator()%>
					</span>
					<span class="part2_ul_li_details_blue"> 
						<%=delivStatusInfo.getOperInfo()%>&nbsp;&nbsp;
					</span>
					
					<span class="part2_ul_li_details_blue">
						<%=delivStatusInfo.getComments()%>&nbsp;&nbsp;
					</span>
					<span class="part2_ul_li_blank_blue">
						<span class="part2_ul_li_square_blue">
								
						</span>
					</span>
				</li>
				<%}else{ %>
				<li class="part2_ul_li_blue">
					<span class="part2_ul_li_time_blue">
						<%=UserConstant.getShowTime(delivStatusInfo.getDelivTime())%>&nbsp;&nbsp;<%=delivStatusInfo.getDelivAddress()%>&nbsp;&nbsp;<%=delivStatusInfo.getOperator()%>
					</span>
					<span class="part2_ul_li_details_blue"> 
						<%=delivStatusInfo.getOperInfo()%>&nbsp;&nbsp;
					</span>
					
					<span class="part2_ul_li_details_blue">
						<%=delivStatusInfo.getComments()%>&nbsp;&nbsp;
					</span>
					<span class="part2_ul_li_blank_blue">
						<span class="part2_ul_li_square_blue">
								
						</span>
					</span>
				</li>
				<%} i++;}%>
			</ul>
			</div>
		</div>
	</div>
<%}else{ %>
			<section class="orderFailureMain">
		    	<div class="Img">
		            <img src="<%=path%>/styles/default/images/noorder.png" />
		        </div>
		        <div class="Txt">该订单暂无配送信息</div>
		    </section>
<%} %>

	
<%@include file="/common/mCommonFoot.jsp" %>
</div>
</body>
</html>
