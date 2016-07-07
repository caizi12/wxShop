<%@ page language="java" pageEncoding="UTF-8"  %>
 <%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>商品分类</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/default/layout.css" />
<style>
.WareKindType{
  border-top:1px #8ec31f solid;
}
.sortList{margin:0px 7px 10px;border:1px #ccc solid;border-bottom:0px;}
.sortListTit{height:35px;border-bottom:1px #ccc solid;color:#666;font-size:14px;line-height: 35px;}
.sortListTit b{width:8px;height:8px;background: #0085d0;margin:14px 10px;display: inline-block;border-radius: 50px;}
.downsortListTit{width:16px;height:6px;background:url(images/grey_boult.png) no-repeat;background-size:16px 6px;margin:15px 10px;cursor:pointer;}
.upsortListTit{width:16px;height:6px;background:url(images/up_grey_bout.png) no-repeat;background-size:16px 6px;margin:15px 10px;cursor:pointer;}
.sortListTxt{padding:0 1%;display: none}
.sortListTxt li{float:left;border-bottom:1px #ccc solid;margin-top:11px;padding-bottom:11px;height:15px;width:33%;text-align: center;font-size:12px;display:inline-block;}
.sortListTxt li span{display:block;border-right:1px #ccc solid;overflow:hidden;height:15px;}
.sortListTxt li span.borR{border-right:0;}
.borT{border-top:1px #8ec31f solid;}
.sortMain{position:relative;}
.borB{border-bottom:0;}
</style>
 
</head>
<body>
<div class="shopCart">
  <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
		<jsp:param value="商品分类" name="name" />
		<jsp:param value="2" name="type" />
	</jsp:include>
    <div class="sortSearch clearfix">
        <div class="new_navIpt fl">
           <input class='newInpt' type='text'  id="wareName"  name ="wareName" value="${wareName}" />
           <a class="new_Icon" href="#"></a>
           <span><a class="new_btn fl"  href='javascript:doSearch();'></a></span>
        </div>
       
    </div>
    <div class="sortList clearfix">
        <div class="sortMain">
 
            <div class="sortListTit clearfix">
                <b class="fl"></b><span class="fl">品牌1</span><i class="downsortListTit fr"></i>
            </div>
            <ul class="sortListTxt clearfix">
          
					<li><span class="borR"><a href="<%=path%>/subkind/.html">k品牌1子</a></span></li>
	 
				   <li><span class="borR">&nbsp;</span></li>	
         	</ul>
        </div>
    </div>
	    <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
</div>
 
<script src="<%=path%>/scripts/ware/common.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/ware/allClass.js" type="text/javascript"></script>
</body>
</html>