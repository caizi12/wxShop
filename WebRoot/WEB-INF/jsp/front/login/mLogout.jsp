<%@page import="nb.lf.portal.common.util.SNAUtil"%>
<%@page import="nb.lf.portal.common.util.CookieUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="nb.lf.portal.PortalConstant"%>
<%@page import="nb.lf.portal.order.OrderConstant"%>
<%
	Cookie uid_cookie = new Cookie(CookieUtil.COOKIE_UID, null);
	uid_cookie.setMaxAge(0);
	uid_cookie.setPath("/");
	SNAUtil.setCookie(request, response, uid_cookie);
	SNAUtil.invalidateUserInfo(request);
	System.out.print(request.getContextPath() + "/login/login.jsp");
	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>