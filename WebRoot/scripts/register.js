$(function(){
        var mySwiper = new Swiper('.swiper-container',{
            pagination: '.pagination',
            loop:true,
            grabCursor: true,
            paginationClickable: true
        })
    });
var mobileNo,pwdMsg,rePwdMsg,validCode,errorMsg,isSend;
window.sending=false;
$(function(){
   mobileNo=$("#mobileNo");
   pwdMsg=$("#pwdMsg");
   rePwdMsg=$("#rePwdMsg");
   validCode=$("#validCode");
	
	mobileNo.val("请输入您的手机号");
	pwdMsg.val("请输入您的登录密码");
	rePwdMsg.val("请再次输入您的登录密码");
	validCode.val("请输入手机验证码");
	
	errorMsg=$("#errorMsg");

	mobileNo.focus(function(){	
		var mobile = $(this).val();
		if(mobile == "请输入您的手机号"){
			$(this).val("");
		}
	});
	
 
	pwdMsg.focus(function(){
		pwdMsg.hide(); 
	    $("#password").show().focus(); 	
	});
 
  
	rePwdMsg.focus(function(){
		 rePwdMsg.hide(); 
	     $("#rePassword").show().focus(); 		
	});
	
	validCode.focus(function(){	
		var code = $(this).val();
		if(code == "请输入手机验证码"){
			$(this).val("");
		}
	});
	mobileNo.blur(function(){	
		validPhoneNo();		 
	});

	$("#valid_image").click(function(){
		image_init();
	});

	$("a[name='image_again']").click(function(){
		image_init();
	});

	$(".submit a").click(function(){
		var mobile = $("#mobileNo").val();
		var validcode = $("#validCode").val();
		var pwd = $("#password").val();
		var rePwd = $("#rePassword").val();
		$("#errorMsg").text('');
 

		//验证手机号码空或者长度不正确
		if(!validPhoneNo()){return false;}
 
		if(null == pwd || "" == pwd || pwd.length<6){
			errorMsg.text("密码不能为空,密码长度应在6-20！");
			errorMsg.show();
			return false;
		}
		
		if(rePwd!=pwd){
		     errorMsg.text("两次输入的密码不一致，请确保一致！");
		 	errorMsg.show();
			return false;
		}
		
		if(!isSend){
			errorMsg.text("请先获取手机短信验证码！");
			errorMsg.show();
			return false;
		}
		
		if(validcode=='请输入手机验证码' || $.trim(validcode) == "" || validcode.lenght<4 ){
			errorMsg.text("请输入手机验证码！");
			errorMsg.show();
			return false;
		}
 

		$.ajax({
			type: "POST",
			url:path+"/member/memberRegister.do",
			data:$("#registerForm").serializeArray(),
			success:function(data){
				
			   if(data=="true"){
			        alert("恭喜您，您已成功注册为商城会员,商城开业在即,新注册用户赠送500积分,请您登录商城查看！");
					window.location = path+"/member/loginPage.do";
				}else if(data=="validError"){
				   errorMsg.text("您输入的验证码错误，请重新输入手机验证码！");
			   }else if(data=="false"){  
				   errorMsg.text('您填写的手机号已注册为商城会员，请尝试使用其它手机号注册或直接使用该手机登录！');
			   }else{
				   errorMsg.text("系统忙，请稍候重试！");
			   }
			     errorMsg.show();
			}
		});
	});
	

	$("#sendSmsBtn").attr("onClick","sendSmsCode()");
});

//发送短信验证码
function sendSmsCode(){
   //避免重复点
   if(window.sending==true){return false;}
    window.sending=true;
    
   if(!validPhoneNo()){
      window.sending=false;
      return false;
   }
   
	var result;
	$.ajax({url:path+"/member/sendSmsCode.do",
             type:"POST",
             data:"mobileNo="+mobileNo.val(),
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

function validPhoneNo(){
	var reg_config = /[1]{1}[2-9]{1}\d{9}/;
	if(!reg_config.test(mobileNo.val())){ 
	    errorMsg.show();
		errorMsg.text("请输入正确的手机号");
		return false;
	}else{
	  errorMsg.hide();
	  return true;
	}
}

var secs = 60 * 3 ;
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
