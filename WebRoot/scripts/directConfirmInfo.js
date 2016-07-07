//立即购买按扭
function doExchange(){

	if(!$("#productNum").val()>0){
	 	alert("请输入购买商品数量！");
	 	return false;
	}
   $.ajax({url:path+"/member/isLogin.do",
            type:"post",
            dataType:"json",
            async:false,
            success:function(data){
                if($.trim(data) == 'true') {
                     $("#amounts").val($("#productNum").val()); 
				     $("#orderForm").submit();
                }else{
                 	 doLogin($("#productIds").val(), $("#productNum").val());                       
                }
            }
        });
}

function addShoping(){
    $.ajax({url:path+"/member/isLogin.do",
            type:"post",
            dataType:"json",
            async:false,
            success:function(data){
                if($.trim(data) == true) {
                     $("#amounts").val($("#productNum").val()); 
				     $("#orderForm").submit();
                }else{
                 	 doLogin($("#productIds").val(), $("#productNum").val());                       
                }
            }
        });
}

function doLogin(productId,amount) {
    window.location.href = path+"/member/loginPage.do?target=/order/exchange.do?productIds=" + productId + "&amounts=" + amount ;
}

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
		$("#orderSmsCode").val("请输入验证码");
		$("#orderSmsCode").focus(function(){	
			var confirmCode = $(this).val();
			if(confirmCode == "请输入验证码"){
				$(this).val("");
			}
		});

        $("#sendSmsBtn").attr("onClick","sendSmsCode()");
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



    //提交订单
	function submitOrder(){
 
		
		var orderSmsCode=$("#orderSmsCode").val();
	    if(orderSmsCode.length<4||"请输入验证码"==orderSmsCode){
	     	alert("请输入短信验证码！");
	 	    return false;
	    }
	    var linkman=$.trim($("#receiverName_span").text());
	    var phone=$.trim($("#receiverTel_span").text());
	    var proCityCountry_span=$.trim($("#proCityCountry_span").text());
	    var receiverAdd_span=$.trim($("#receiverAdd_span").text());
	    if(linkman.length==0||phone.length==0||proCityCountry_span.lenth==0||receiverAdd_span.length==0){
	        alert("请正确设置您的收获地址！");
	 	    return false;
	    }
	    
	   //验证码通过后提交订单按钮变灰
		$("#submitOrder").attr('disabled','disabled');
		$("#submitOrder").removeAttr('href');
 
	 
		$("#confirmCode").val($("#orderSmsCode").val());
		$("#linkman").val(linkman);
		$("#phone").val(phone);
		var send_address=proCityCountry_span+" "+receiverAdd_span;
		$("#address").val(send_address);
		var post_code=$.trim($("#receiverPostCode_span").text());
	    $("#postCode").val(post_code);
 
 		//收货时间
		$("#sendTime").val($("input[name='deliverTime']:checked").val());
		
		var payType=$("input[name='selectOnOffLinePayType']:checked").val();
		$("#payType").val(payType);

		$("#confirmCode").val($("#orderSmsCode").val());

		$("#createOrderForm").submit();
	}

	
sending=false;
//发送短信验证码
function sendSmsCode(){
   //避免重复点
   if(window.sending==true){return false;}
    window.sending=true;
    
	var result;
	$.ajax({url:path+"/order/sendSmsCode.do",
             type:"POST",
             data:"",
	         async:false,
	   success:function(data){
			if(data!=''){
				if(data=='true'){
				    isSend=true;
				    result=data;
					errorMsg.text("尊敬的客户您好，短信确认码已经发送到您的手机上，请查收!");
				}else if(data=='error'){
					errorMsg.text("手机号码格式不正确，请重新输入！");
					  window.sending=false;
				}else if(data=='exits'){
					errorMsg.text("您填写的手机号已注册为商城会员，请尝试使用其它手机号注册或直接使用该手机登录！");
					  window.sending=false;
				}else{
					errorMsg.text("系统忙，请稍候重试！");
					  window.sending=false;
				}
			} else {
				errorMsg.text("系统忙，请稍候重试！");
				 window.sending=false;
			}
			errorMsg.show();
		}
	});
	
	if(result=="true"){
		for(var i=1;i<=(wait/1000);i++) {
			 window.setTimeout("doUpdateTime(" + i + ")", i * 1000);
		 }
		 window.setTimeout("Timer()", wait);
	}else{
	     window.sending=false;
	     $("#sendSmsBtn").attr("onClick","sendSmsCode()");
	}
	
	$("#validCode").focus();
}

var secs = 60 * 5 ;
var wait = secs * 1000;//一分钟
function doUpdateTime(num) {
  var sendSmsBtn= $("#sendSmsBtn")
  if(num==1)  sendSmsBtn.addClass('disabled');
  if(num == (wait/1000)) {
   	   sendSmsBtn.attr("onClick","sendSmsCode()");
   	   sendSmsBtn.removeClass('disabled');
   	   sending=false;
  }else {
      wut = (wait/1000)-num;
      sendSmsBtn.val(wut+'s后重新获取验证码');
  }
}

function Timer() {
	$("#sendSmsBtn").val('获取验证码');
}