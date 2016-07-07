<%@ page  contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>	${dataMap.productBaseInfo.productName}_商品详细信息</title>
<%@include file="/jsp/common/frontCommon.jsp" %>  
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/idangerous.swiper.css" >
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/m_ware_detail_Rotate.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/newDetail.css"/>
</head>
<body>
<section class="seeGift">
    <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
		<jsp:param value="查看商品" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
 

    <div id="solid_data" class="wareinfo4">
        
        <ul>
	            <li class="active">商品介绍</li>
	            <li>规格参数</li>
	            <li>包装清单</li>
	            <li><a href="javascript:;">售后保障</a></li>
        </ul>
		<div id="wareInfoShowArea">
		        <div class="show" id="richDesc">
		          		${dataMap.productBaseInfo.productDetail}
				</div>
		     	<div class="show">
			        <table class="normal" width="93%" cellspacing="0" cellpadding="0" >
		               <c:forEach  var="attr" items="${dataMap.productAttrInfo}">
		               <tr>
		                 <th>${attr.attrName }</th>
		                 <td id="${attr.attrId}">${attr.attrVal}</td>
		               </tr>
		               </c:forEach>
			        </table>
				 </div>
                <div id="packageList">注：该装箱清单为该产品的一个参考配置，随着产品更新，可能会与实际安装需求不同，请以实际为准。</div>
                
                <div id="afterSale"> 自收到商品之日起，如您所购买家电商品出现质量问题，请先联系厂家进行检测 ,180天内产品出现质量问题可换货，超过180天按国家三包规定享受服务。 售后服务电话：400-020-0051 品牌官方网站：http://www.originwater.com
			    </div>
            </div>
        </div>
    </div>
</section>	

<div style="height:60px;"></div>
<div class="wrapper_bottom">
   <%@include file="/WEB-INF/jsp/front/common/mCommonFoot.jsp" %>
	</div>
</body>
<script src="<%=path%>/scripts/CommUtil.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/idangerous.swiper.min.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/public.js" type="text/javascript"></script>
 
<script type="text/javascript">
 $(function(){
   //设置包装清单 售后服务
   $("#packageList").html($("#1000000030").html());
   $("#afterSale").html($("#1000000031").html());
  
});
</script>

</html>