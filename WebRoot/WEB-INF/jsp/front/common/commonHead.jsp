<%@ page language="java" pageEncoding="UTF-8"  %>
<%	//题头名称
	String headName = request.getParameter("name");
	//0：无     1 ：首页   2：搜索    3：购物车    4：我的
	String type = request.getParameter("type");
%>
<script >
var contextPath = '<%=request.getContextPath()%>';
</script>
<script src="<%=request.getContextPath() %>/scripts/commonHead.js" type="text/javascript"></script>
<div class="commonHead">
<div class="new_nav clearfix">
        <h2 class="clearfix">
        <span><a href="javascript:window.history.go(-1);"><img class="img" src="<%=request.getContextPath()%>/styles/default/images/back_white.png" /></a></span>
        <font id='headName'><%=headName %></font>
     <p class="navRicon clearfix">
        <a id="menuHead" href="javascript:openMenu();"><img class="img" src="<%=request.getContextPath()%>/styles/default/images/menu_bar.png" /></a>
        <a id="operationDIY" class="fr" href="#" style="display:none;width:50px;display:inline-block;color:#fff;font-weight:100;font-size:12px;"></a>
     </p>
     </h2>        
 </div>
<ul class="navList clearfix" style="display: none;">
    <li>
    	<%if("1".equals(type)){ %>
        <p><a href="javascript:goIndex();"><img src="<%=request.getContextPath()%>/styles/default/images/homepage_blue.png" /></a></p>
        <%}else{  %>
        <p><a href="javascript:goIndex();"><img src="<%=request.getContextPath()%>/styles/default/images/homepage_grey.png" /></a></p>
        <%} %>
        <p><a href="javascript:goIndex();">首页</a></p>
    </li>
    <li>
    	<%if("2".equals(type)){ %>
    	<p><a href="javascript:goAllClass();"><img src="<%=request.getContextPath()%>/styles/default/images/search_blue.png" /></a></p>
        <%}else{ %>
        <p><a href="javascript:goAllClass();"><img src="<%=request.getContextPath()%>/styles/default/images/search_grey.png" /></a></p>
         <%} %>
        <p><a href="javascript:goAllClass();">搜索</a></p>
    </li>
    <li>
    	<%if("3".equals(type)){ %>
    	<p><a href="javascript:goShoppingCart();"><img src="<%=request.getContextPath()%>/styles/default/images/addcart_blue.png" /></a></p>
        <%}else{ %>
        <p><a href="javascript:goShoppingCart();"><img src="<%=request.getContextPath()%>/styles/default/images/addcart_grey.png" /></a></p>
        <%} %>
        <p><a href="javascript:goShoppingCart();">购物车</a></p>
    </li>
    <li>
    	<%if("4".equals(type)){ %>
         <p><a href="javascript:goUserAccount();"><img src="<%=request.getContextPath()%>/styles/default/images/blue_head.png" /></a></p>
         <%}else{ %>
         <p><a href="javascript:goUserAccount();"><img src="<%=request.getContextPath()%>/styles/default/images/grey_head.png" /></a></p>
         <%} %>
        <p><a href="javascript:goUserAccount();">我的</a></p>
    </li>
</ul>
</div>
