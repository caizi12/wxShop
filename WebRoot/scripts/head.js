
var checkUserLogin = path + "/portal/order/web/UserOrderAction?action=checkUserInfo";
var searchAction = path+'/ware/wareCommonList.jsp?action=searchWareInfo';
var searchMyExchangeWareInfo = path+'/portal/ware/web/SearchWareAction?action=searchMyExchangeWareInfo';

$(function(){
	    $('.newInpt').click(function(){
	       $(this).parent().find('.new_Icon').show();
	    });
	    $('.new_Icon').click(function(){
	       $('.newInpt').val('');
	    });
	});

function gotoUrl(url,linkName) {
	   	if(checkedCurrentUser && currentUser ) {
	   		window.location = url;
	   	}else{
	   		$.post(
				checkUserLogin,
				function(data){
					if($.trim(data)=="Y"){
						window.location = url;
					}else{
						//未进行登陆
		        		Dialog('.detailDialog');
						msg_btn = '<a class="btnBuy"  onclick="window.location=\''+path+'/login/login.jsp?target='+url+'\'");">登录</a>';
						msg = '您好，要访问' + linkName + '，请先登录！';
						
						$("#showMessage").html(msg);
	        	        $("#btnShow").html(msg_btn);
	   				}
		   		});
	   	}	
}

 
function goUserInfo(url,isCheckUserLogin){
	   window.location.href = path+url;	
}

 

$(document).ready(function(){
	 
});

	