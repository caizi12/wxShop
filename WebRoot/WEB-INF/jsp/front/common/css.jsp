<%@page import="ngves.asiainfo.portal.PortalConstant"%>
<%@page import="ngves.asiainfo.CommnConstant"%><%
out.println("<script type=\"text/javascript\">");
out.println("var onloadStartTime = new Date();");
out.println("</script>");
if( CommnConstant.VALID_FLAG_ENBALE.equals(request.getAttribute(PortalConstant.INDEX_SET_GRAY)) ) { 
	out.print("<link href=\"" + request.getContextPath() + "/styles/gray/default.css\" rel=\"stylesheet\" type=\"text/css\" />");
} else {
	out.println("<link href=\""+ request.getContextPath() +"/common/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
} 
%>