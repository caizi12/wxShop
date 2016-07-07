<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>::Error Page ::</title>
</head>
<H2>Catch a exception:</H2>
 
<BR>
系统出现异常,请与系统项目组联系！
<P>
 
		<%
try {
	// The Servlet spec guarantees this attribute will be available
	Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

	if (exception != null) {
		if (exception instanceof ServletException) {
			// It's a ServletException: we should extract the root cause
			ServletException sex = (ServletException) exception;
			Throwable rootCause = sex.getRootCause();
			if (rootCause == null)
				rootCause = sex;

			out.println("** Root cause is: "+ rootCause.getMessage());
			rootCause.printStackTrace(new java.io.PrintWriter(out));
		}
		else {
			// It's not a ServletException, so we'll just show it
			exception.printStackTrace(new java.io.PrintWriter(out));
		}
	}
	else  {
    	out.println("No error information available");
	}
} catch (Exception ex) {
	ex.printStackTrace(new java.io.PrintWriter(out));
}
%>




