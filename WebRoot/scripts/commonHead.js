
function openMenu(){
	if($(".navList").css("display")=="none"){
		$('.navList').show();
	}else{
		$('.navList').hide();
	}
}
function goAllClass(){
	window.location.href = contextPath+'/product/list_page.do';
}

function goUserOrder(){
	window.location.href = contextPath+'/asynorder/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&queryType=0&queryOrderType=1&actionId=';
}

function goIndex(){
	window.location.href = contextPath+'/index.do';
}

function goShoppingCart(){
	window.location.href = contextPath+'/portal/order/web/ShoppingCartAction?action=showUserShopInfo';
}

function goUserAccount(){
	   window.location.href = contextPath+'/member/myAccount.do';	
}
