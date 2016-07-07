<%@ page language="java" pageEncoding="UTF-8"  %>
 <div class="indexLogo clearfix">
     <div class="wid200">
  		<a class="logoYd" href="index.do" >
  			<img src="<%=path%>/styles/default/images/logo.jpg" />
  		</a>
  		<a class="logohjf" href="javascript:;">
  			 净水商城
  		</a>
     </div>
 </div>
 
 <!-- 搜索栏  -->
 <div style="background:#fff;padding:10px 55px;">
 <div class="search clearfix">
      <form id="searchProductForm" action="<%=path %>/product/list_page.do" method="post"">
     <input class='newInpt' type='text'  id="searchProductName"  name="productName" value="" />
     </form>
     <a class="new_Icon" href="#"></a>
     <span>
       <a href='javascript:doSearch();'>
           <img src="<%=path%>/styles/default/images/search_btn.png">
        </a>
      </span>
 </div>
 </div>
 <!-- 积分展示区域 -->
 <div id="Integral" class="Integral">
 	
 </div>
 
 <!-- 功能区域 -->
 <nav class="SortBtn">
	 <ul class="clearfix">
	      
	     <li>
	         <div onclick="javascript:goUserInfo('/member/myAccount.do',true);"> 
	         	<span class="my">
	         		<img src="<%=path%>/styles/default/images/my.png" />
	         	</span>
	         </div>
	         <p><a href="javascript:goUserInfo('/member/myAccount.do',true);">我的信息</a></p>
	     </li>
	     
	     <li>
	         <div onclick="javascript:goUserInfo('/member/shop/list.do',true);">
	         	<span class="shopping">
	         		<img src="<%=path%>/styles/default/images/shopping.png" />
	         	</span>
	         </div>
	         <p><a href="javascript:goUserInfo('/member/shop/list.do');">我的购物车</a></p>
	     </li>
	       <li>
	         <div onclick="javascript:goUserInfo('/order/myOrder.do',true);"> 
	         	<span class="my">
	         		<img src="<%=path%>/styles/default/images/canexchange.png" />
	         	</span>
	         </div>
	         <p><a href="javascript:goUserInfo('/order/myOrder.do');">我的订单</a></p>
	     </li>
	     
	      <li>
	          <div onclick="javascript:goUserInfo('/product/list_page.do',true);">  
	             <span class="sort">                                     
	                <img src="<%=path%>/styles/default/images/sort.png" />                   
	             </span>   
	          </div>
	         <p><a href="<%=path%>/product/list_page.do">商品类目</a></p>
	     </li> 
	     
	     <li style="">
	         <div > 
	             <span class="convertList">
	             	<img src="<%=path%>/styles/default/images/exchangetop.png" />
	             </span>
	          </div>
	         <p>
	           <a href="<%=path%>/member/memberRegisterPage.do">新用户注册</a>
	         </p>
	     </li>
	     
	    
	     
	 </ul>
 </nav>

<script type="text/javascript" src="<%=path%>/scripts/head.js"></script>
        