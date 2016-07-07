
<%@page import="ngves.asiainfo.portal.tag.TagImage"%><%  response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/css");
	IPagestyleInfoValue style = FetchStyleAction.fetchCurrentStyle();
	String stylePath = request.getContextPath();
	/*如果当前取得的样式为空，则指向默认样式*/
	if(style != null){
		stylePath += style.getPath();
	}
	else{
		stylePath += StyleConstant.DEFAULT_PAGE_STYLE_PATH;
	}
	out.println("@charset \"utf-8\";");
	out.println("@import url(\"" + TagImage.getImgDomain("account_help_topic_login") + stylePath + "/account_help_topic_login" + VersionTag.VERSION_SUFFIX + ".css\");");
	out.println("@import url(\"" + TagImage.getImgDomain("base_bg") + stylePath + "/base_bg" + VersionTag.VERSION_SUFFIX + ".css\");");
	out.println("@import url(\"" + TagImage.getImgDomain("detail_list_space_lantern_img") + stylePath + "/detail_list_space_lantern_img" + VersionTag.VERSION_SUFFIX + ".css\");");
	out.println("@import url(\"" + TagImage.getImgDomain("compare_window") + stylePath + "/compare_window" + VersionTag.VERSION_SUFFIX + ".css\");");
	
	out.println("/* xxx_check_page_state_flag_xxx */");
%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="ngves.asiainfo.portal.order.web.FetchStyleAction"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="ngves.asiainfo.portal.styles.StyleConstant"%>
<%@ page import="ngves.asiainfo.portal.styles.ivalues.IPagestyleInfoValue"%>
<%@ page import="ngves.asiainfo.portal.tag.VersionTag"%>
