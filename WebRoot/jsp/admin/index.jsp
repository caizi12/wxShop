<%@ page language="java"   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理</title>
</head>
<frameset rows="76,*"  framespacing="0">
  <frame src="top.jsp" name="topFrame" frameborder="no" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset name="mainFrame" cols="200,*" frameborder="1" border="0" framespacing="0">
    <frame src="left.jsp" name="leftFrame" frameborder="0" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="main.jsp" name="rightFrame" frameborder="0" scrolling="auto" noresize="noresize" id="midFrame" title="midFrame" />
  </frameset>
</frameset>
</html>
