<%@ page contentType="text/html; charset=utf-8"%>
 
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/idangerous.swiper.css" />
<style type="text/css">
 /*轮播*/
.swiper-container { width:100%;max-width:640px;min-width:300px;margin:0 auto;background:#fff;}
.pagination { position: absolute; left: 0; text-align: center; bottom:5px; width: 100%; }
.swiper-pagination-switch { display: inline-block; width: 8px; height: 8px; border-radius: 10px; background: #8a8f95;opacity:0.4; filter:alpha(opacity=40); margin: 0 0 0 8px; cursor: pointer; }
.swiper-active-switch { background: #8fc31f;opacity:0.4; filter:alpha(opacity=40); }
.swiper-slide { position: relative; text-align:center;}
.swiper-slide img {width:auto;max-width:640px; min-width: 300px;margin:0 auto;margin:0 auto; }
.swiper-slide a { display: block; position: absolute;width:100%;max-width:640px;min-width:300;}
.swiper-slide1 a { left: 65px; top: 170px;width:100%;max-width:640px;min-width:300;}
.swiper-slide2 a { left: 90px; top: 195px;width:100%;max-width:640px;min-width:300;}
.swiper-slide3 a { left: 90px; top: 195px;width:100%;max-width:640px;min-width:300;} 
</style>
<marquee class="homeMarquee" direction=’left’  scrollamount=30 scrolldelay=300 >
广顺净水商城开业在即！关注公众号，好礼享不停！净水商城 ，衷于精品， 价格实惠，服务顺心。敬请期待！
 
</marquee>
 <!--动效-->
    <div class="choose_tasks" style="display:block;">
        <div class="swiper-container">
            <div class="swiper-wrapper">               
                 	<div class="swiper-slide swiper-slide1" style=" height: 214px;" >
	                   <span onclick="openTopic('<%=path%>/product/detail/1000000063.do')">
	                   		<img src="upload/ad/1.jpg"/>
	                   		<a href="<%=path%>/product/detail/1000000063.do"></a>
	                   </span>
	                 </div>
                 	<div class="swiper-slide swiper-slide1" style="display: none;height: 214px;" >
	                   <span onclick="openTopic('<%=path%>/product/detail/1000000032.do')">
	                   		<img src="upload/ad/2.jpg" />
	                   		<a href="<%=path%>/product/detail/1000000032.do"></a>
	                   </span>
	                 </div>
					 <div class="swiper-slide swiper-slide1" style="display: none;height: 214px;" >
	                   <span onclick="openTopic('<%=path%>/product/detail/1000000067.do')">
	                   		<img src="upload/ad/3.jpg" />
	                   		<a href="<%=path%>/product/detail/1000000067.do"></a>
	                   </span>
	                 </div>
            </div>
            <div class="pagination"></div>
        </div>
    </div>
    
    <!--动效 end--> 


<script type="text/javascript" src="<%=path%>/scripts/idangerous.swiper.min.js"></script>
<script type="text/javascript">
    //swiper轮播插件初始化
    $(document).ready(function(){
    	var mySwiper = new Swiper('.swiper-container',{
            pagination: '.pagination',
            loop:true,
            grabCursor: true,
            paginationClickable: true,
            autoplay:4500,
            autoplayDisableOnInteraction:false,
            calculateHeight:true
            
        });
        
        $(".swiper-wrapper div").each(function(){
				$(this).css("display","block");
        });

      });
    //广告图上的链接
    function openTopic(url){
        window.location.href=url;
    }
</script>


