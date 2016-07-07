<%@ page  contentType="text/html; charset=utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>我的地址</title>
<link href="<%=path%>/styles/default/myAdress.css" rel="stylesheet" type="text/css">
<%@include file="/jsp/common/frontCommon.jsp" %>  
</head>
<body>
<div class="pageOrder">
 <jsp:include page="/WEB-INF/jsp/front/common/commonHead.jsp"> 
	<jsp:param value="我的地址" name="name" />
	<jsp:param value="6" name="type" />
</jsp:include>
<section class="myAdress"> 
  <div id="addrList">
    <c:forEach items="${dataMap.addressList}" var="address">
	<div class="myAdressMain">
		<ul>
			<li class="name">
				<span>${address.linkman }</span>
				<i>${address.mobileNo }</i>
			</li>
			<li>
				${dataMap.provinceMap[address.provinceCode]} ${dataMap.cityMap[address.cityCode]} ${dataMap.countryMap[address.districtCode]} ${address.addressDetail }   &nbsp;${address.postCode }
			</li>
		</ul>
		<div class="default clearfix">
			<div class="fl">
				<div class="radio fl">
					<font	class="<c:if test="${address.isDefault eq '1' }">active</c:if>"><input type="checkbox" value="${address.addressId}" id="${address.addressId}">
					</font>
					 <span>&nbsp;&nbsp;&nbsp;<label for="${address.addressId}">
						 <c:if test="${address.isDefault eq '1' }">
						    默认地址
						 </c:if>
						  <c:if test="${address.isDefault ne '1' }">
						  设为默认地址
						 </c:if>
						</label>
					</span>
				</div>
			</div>
			<div class="fr">
				<a href="<%=path%>/member/address/edit/${address.addressId}.do"><span class="edit"><i><img
								src="<%=path%>/styles/default/images/edit.png">
					</i>编辑</span>
				</a><a href="#" onclick="deleteAddrComfirm('${address.addressId}');"><span class="del"><i><img
								src="<%=path%>/styles/default/images/del.png">
					</i>删除</span>
				</a>
			</div>
		</div>
	</div>
   </c:forEach>
	<div style="margin-bottom: 60px"></div>
	<div class="Addelete clearfix">
		<div>
			<a href="<%=request.getContextPath()%>/member//address/addPage.do"><span>+</span> <i>新增地址</i>
			</a>
		</div>
	</div>
</section>
<%@include file="/WEB-INF/jsp/front/common/commonDialog.jsp" %>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/myAddress.js"></script>
<script type="text/javascript">
var path='<%=path%>';
//var addrCountForAdd;
$(document).ready(function(){
	$("#menuHead").css({"display":"none"}); 
	$("#operationDIY").css({"display":""});
	$("#operationDIY").text("");
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){window.location.href=path+'/member/myAccount.do';});
   // loadAddressInfo(); 
	$('.radio font').live('click',function(){ 
        var classAttr =$(this).find("input").parent("font").attr("class");
        var temp =$(this).find("input").val();
        changeDefaultStatusConfirm(temp,0,classAttr);
		$('.radio font').removeClass('active').find('input:radio').removeAttr('checked');
        $(this).addClass('active').find('input:radio').prop('checked',true);
        return false;
    });   	
});
</script>
</html>
