function gotoAddrInfo(){
	$("#queryAddrForm").submit();
}

/*
* 点击选择支付 进入选择支付类型界面
*/
function selectPayTypeInfoPage(){
	$("#headName").html("选择支付信息");
	$("#confirmOrderSection").hide();
	$("#selectPayTypeSection").show();

	$(".commonHead .new_nav span a").attr("href","javascript:confirmPayTypeInfo();");
}
/*
* 确认支付类型点击确认返回订单界面
*/
function confirmPayTypeInfo(){
	$("#headName").html("确认订单");
	$("#selectPayTypeSection").hide();
	$("#confirmOrderSection").show();
	var selectOnOffLinePayType = $("input[name='selectOnOffLinePayType']:checked").val();
	var selectPayTypeShow = '微信支付';
	 if(selectOnOffLinePayType=='02'){
		 selectPayTypeShow = '货到付款';
	 }
	 $("#selectPayTypeShow").text(selectPayTypeShow);
	 $(".commonHead .new_nav span a").attr("href","javascript:window.history.go(-1);");
}

/*
* 选择支付类型选项 点击事件
*/
function selectOnOffLinePayType(payType){
	if(1==payType){
		$("#offlinePayType").removeClass('active');
		$("#onlinePayType").addClass('active');

		$("input[name='selectOnOffLinePayType'][value='01']").attr("checked",true); 
		$("input[name='selectOnOffLinePayType'][value='02']").attr("checked",false); 
	} else {
		$("#offlinePayType").addClass('active');
		$("#onlinePayType").removeClass('active');
		
		$("input[name='selectOnOffLinePayType'][value='01']").attr("checked",false); 
		$("input[name='selectOnOffLinePayType'][value='02']").attr("checked",true); 
	}
}

/*
* 选择送货时间选项 点击事件
*/
function selectDeliverTime(type){
	$("#0DeliverTime").removeClass('active');
	$("#1DeliverTime").removeClass('active');
	$("#2DeliverTime").removeClass('active');
	$("input[name='deliverTime'][value='03']").attr("checked",false); 
	$("input[name='deliverTime'][value='01']").attr("checked",false); 
	$("input[name='deliverTime'][value='02']").attr("checked",false); 
	if(0==type){
		$("#0DeliverTime").addClass('active');
		$("input[name='deliverTime'][value='03']").attr("checked",true); 
	} else if(1==type) {
		$("#1DeliverTime").addClass('active');
		$("input[name='deliverTime'][value='01']").attr("checked",true); 
	} else {
		$("#2DeliverTime").addClass('active');
		$("input[name='deliverTime'][value='02']").attr("checked",true); 
	}
}

/*
* 点击配送时间 进入选择配送时间界面
*/
function selectDeliverTimeInfoPage(){
	$("#headName").html("选择收货时间");
	$("#confirmOrderSection").hide();
	$("#selectDeliverTimeSection").show();

	$(".commonHead .new_nav span a").attr("href","javascript:confirmDeliverTimeInfo();");
}
/*
* 确认配送时间 返回订单界面
*/
function confirmDeliverTimeInfo(){
	$("#headName").html("确认订单");
	$("#selectDeliverTimeSection").hide();
	$("#confirmOrderSection").show();
	var deliverTime = $("input[name='deliverTime']:checked").val();
	var showDeliverTime = '不限时间';
	 if(deliverTime=='01'){
		 showDeliverTime = '周一至周五';
	 }else if(deliverTime=='02'){
		 showDeliverTime = '周六日及公共假期';
	 }
	 $("#deliverTimeShow").text(showDeliverTime);
	 $(".commonHead .new_nav span a").attr("href","javascript:window.history.go(-1);");
}

/*
* 选择发票类型选项 点击事件
*/
function selectInvoiceInfo(type){
	$("#0InvoiceInfo").removeClass('active');
	$("#1InvoiceInfo").removeClass('active');
	$("#2InvoiceInfo").removeClass('active');
	$("input[name='invoiceInfo'][value='0']").attr("checked",false); 
	$("input[name='invoiceInfo'][value='1']").attr("checked",false); 
	$("input[name='invoiceInfo'][value='2']").attr("checked",false); 
	if(0==type){
		$("#0InvoiceInfo").addClass('active');
		$("input[name='invoiceInfo'][value='0']").attr("checked",true); 
	} else if(1==type) {
		$("#1InvoiceInfo").addClass('active');
		$("input[name='invoiceInfo'][value='1']").attr("checked",true); 
	} else {
		$("#2InvoiceInfo").addClass('active');
		$("input[name='invoiceInfo'][value='2']").attr("checked",true); 
	}
}

/*
* 点击发票信息 进入选择发票抬头界面
*/
function selectInvoiceInfoPage(){
	$("#headName").html("填写发票信息");
	$("#confirmOrderSection").hide();
	$("#invoiceInfoSection").show();

	$(".commonHead .new_nav span a").attr("href","javascript:confirmInvoiceInfo();");
}
/*
* 确认发票抬头 返回订单界面
*/
function confirmInvoiceInfo(){
	var invoiceInfoType = $("input[name='invoiceInfo']:checked").val();
	var showInvoiceInfo = '不开发票';
	 if(invoiceInfoType=='1'){
		 showInvoiceInfo = '个人';
	 }else if(invoiceInfoType=='2'){
		 var invoiceInfoTitle = $("#invoiceInfoTitle").val();
		 if(invoiceInfoTitle==""){
			Dialog('.detailDialog');
		  		
	        msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
	        msg = '请填写单位名称.';
	        
	        $("#showMessage").html(msg);
	        $("#btnShow").html(msg_btn);
	        return;
		 }
		 showInvoiceInfo = '单位: ';
		 showInvoiceInfo = showInvoiceInfo+invoiceInfoTitle;
	 }
	 $("#showInvoiceInfo").text(showInvoiceInfo);

	 //显示确认订单页
	 $("#headName").html("确认订单");
    $("#invoiceInfoSection").hide();
	 $("#confirmOrderSection").show();

	 $(".commonHead .new_nav span a").attr("href","javascript:window.history.go(-1);");
}

/*
* 点击礼品 进入礼品列表界面
*/
function directToWareListPage(){
	$("#headName").html("商品清单");
	$("#confirmOrderSection").hide();
	$("#orderWareListSection").show();
	$("#operationDIY").html("共"+totalCount+"件");
	
	$("#menuHead").hide();
	$("#operationDIY").show();
	
	$(".commonHead .new_nav span a").attr("href","javascript:directToOrderConfirmPage();");
}
/*
* 返回订单界面
*/
function directToOrderConfirmPage(){
	 //显示确认订单页
	 $("#headName").html("确认订单");
    $("#orderWareListSection").hide();
	 $("#confirmOrderSection").show();
	 $("#menuHead").show();
	 $("#operationDIY").hide();

	 $(".commonHead .new_nav span a").attr("href","javascript:window.history.go(-1);");
}

 
 


	$(function(){
		$("#text_confirm_code").val("请输入验证码");
		$("#text_confirm_code").focus(function(){	
			var confirmCode = $(this).val();
			if(confirmCode == "请输入验证码"){
				$(this).val("");
			}
		});

		$("#confirmButton").click(function (){
				if($("#confirmButton").attr('disabled')=="disabled"){
					return;
				}
				var msg_btn = '';
				$("#confirmButton").attr('disabled',true);
				$("#confirmButton").addClass('noclick');
				for(var i=1;i<=(wait/1000);i++) {;
					 window.setTimeout("doUpdate(" + i + ")", i * 1000);
				}
				window.setTimeout("Timer()", wait);
				
				$.post(confirmCodeUrl,
					function(data){
						if(data=='SUCCESS'){
							$("#errorMsg").text("尊敬的客户您好，短信确认码已经发送到您的手机上，请查收");
						}else if(data=='SYS-BUSY'){
							$("#errorMsg").text("系统忙，请稍候重试！");
						}else if(data=='SESSION_IS_NULL'){
							$("#errorMsg").text("会话已经过期,请重新用手机号登录系统！");
						}else{
							$("#errorMsg").text("系统忙，请稍候重试！");
						}
					}
				);
				$("#text_confirm_code").focus();
		});
		
	});

 

	function g_StringTrim(str){
		  str = str.toString(10);
		  return str.replace(/(^\s*)|(\s*$)/g, "");
	}

	//校验订单提交页面是否需要校验配送、支付信息
	function validateOrderSendPayInfo(){
		if(validateSendPayInfo.length==0){return true;}
		if(validateSendPayInfo.indexOf("send")>-1){
			var cust_name=$.trim($("#receiverName").val());
			var send_address=$.trim($("#receiverAdd").val());
			var send_district=$.trim($("#countryCode").val());
			//配送市不做校验，因为北京、天津这些直辖市没有这个值
			//var send_city=$.trim($("#send_city").text());
			var send_province=$.trim($("#modifyProvinceCode").val());
			var post_code=$.trim($("#receiverPostCode").val());
			var cust_tel=$.trim($("#receiverTel").val());
		    //校验收货人信息
			if(!cust_name || cust_name.length==0 || !send_address || send_address.length==0 ||
				!send_district || send_district.length==0 || 
				!send_province || send_province.length==0 || !post_code || post_code.length==0 ||
				!cust_tel || cust_tel.length==0 
			  )
			 {
				$("#errorMsg").text("请填写您的收货人信息，例如收货人、收货地址、邮编、电话等！");
		    	return false;
			 }

			if($.trim($("#receiverName").val()) == ""){
				$("#errorMsg").text("收货者姓名不能为空！");
				return false;
			}
		    
			if(cust_name.length>16){
				$("#errorMsg").text("收货者姓名过长！");
				return false;
			}

			var CheckData = /<|>|'|;|&|#|"|'|\*|\^|\{|\}|\[|\]|%|[\$]|@|!|！|\?|￥|；|…|”|“|？|、/;
			if(CheckData.test($("#receiverName").val())){
				$("#errorMsg").text("您的姓名输入了非法字符！");
				return false;
			}

			if($("#receiverAdd").val() == ""){
				$("#errorMsg").text("收货地址不能为空！");
				return false;
			}
			
			if($("#receiverAdd").val().length>50){
				$("#errorMsg").text("收货地址过长！");
				return false;
			}
			if(CheckData.test($("#receiverAdd").val())){
				$("#errorMsg").text("您的收货地址输入了非法字符！");
				return false;
			}

			if($.trim($("#receiverPostCode").val())== ""){
				$("#errorMsg").text("邮政编码不能为空！");
				return false;
			}
			
			if(!g_IsPostalCode($("#receiverPostCode").val())){
				$("#errorMsg").text("邮政编码格式不正确!");
				return false;
			}
			
			if(!g_IsMobileNumber(cust_tel) && !g_IsTeleNumber(cust_tel)){
				$("#errorMsg").text("电话号码格式不正确！");
				return false;	
			}
		}
	  return true;
	}

