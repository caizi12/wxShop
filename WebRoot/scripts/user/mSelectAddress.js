var addrId = '';

$(function(){
	$(".tbl-cell a").click(function(){
		$(".on").removeClass("on");
		$(this).addClass("on");
		goOrderConfirm();
	});
	
	$(".new_nav a:first").click(function(){
		goOrderConfirm();
	});
	
	var goOrderConfirm = (function(){
		var codes = $(".on").attr("name").split("_");
	    if("cart" == exgType){
		    $("#deliverForm input[id='threeCityProCode']").val($.trim(codes[1]));
		    $("#deliverForm input[id='threeCityCityCode']").val($.trim(codes[2]));
		    $("#deliverForm input[id='threeCityDisCode']").val($.trim(codes[3]));
	    	$("#deliverForm input[id='userSelectAddrId']").val($.trim(codes[4]));
	    	$("#deliverForm").submit();
		}else if("directExchange" == exgType){
			$("#directExchangeForm input[id='threeCityProCode']").val($.trim(codes[1]));
			$("#directExchangeForm input[id='threeCityCityCode']").val($.trim(codes[2]));
			$("#directExchangeForm input[id='threeCityDisCode']").val($.trim(codes[3]));
			$("#directExchangeForm input[id='userSelectAddrId']").val($.trim(codes[4]));
		    $("#directExchangeForm").submit();
		}
	});

	$(".btn-update").click(function(){
		$("#addAddrForm input[id='userSelectAddrId']").val($.trim($(this).attr("name")));
	    $("#addAddrForm").submit();
	});

	$(".addr-add").click(function(){
		$("#addAddrForm input[id='userSelectAddrId']").val("");
	    $("#addAddrForm").submit();
	});

	$(".btn-del").click(function(){
		addrId = $.trim($(this).attr("name"));
		var msg_btn = '<a class="btnBuy" onclick="delAddress();">确定</a>';
		var msg = "您确定要删除该收获地址吗！";
		
    	setDialogMessage(msg_btn, msg);
	});

});

function delAddress(){
    //alert(addrId);
    $.ajax({
		   type: "POST",
		   dataType:"json",
		   url: contextPath+"/portal/user/web/UserAddressAction?action=deteleAddress",
		   data:"addrId=" + addrId,
		   success: function(data){
		   		if(data.msg == "success"){
		   			$("#addrItem_"+addrId).remove();
		   		}else{
					$("#errorMsg").text("删除收货地址失败");
		   		}
		   }
	});
    DialogClose(".detailDialog");
}