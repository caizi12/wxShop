$(function(){
        var mySwiper = new Swiper('.swiper-container',{
            pagination: '.pagination',
            loop:true,
            grabCursor: true,
            paginationClickable: true
        })
    });

 

$(function(){
	var image_init = (function (){
		$("#valid_image").attr("src",path+"/jsp/common/image.jsp?t=" + (new Date().getTime().toString(36)));
	});
	
	image_init();
	
	$("#mobileNo").val("请输入用户名");
	$(".code input").val("请输入验证码");

	$("#mobileNo").focus(function(){	
		var mobile = $(this).val();
		if(mobile == "请输入用户名"){
			$(this).val("");
		}
	});
	
	$("#password").focus(function(){	
		var password = $(this).val();
		if(password == "请输入密码"){
			$(this).val("");
		}
	});
 
	$(".code input").focus(function(){	
		var code = $(this).val();
		if(code == "请输入验证码"){
			$(this).val("");
		}
	});
	$("#mobileNo").blur(function(){	
		var mobile = $(this).val();
		if(mobile.length == 11){
			var reg_config = /\d{11}/;
			if(!reg_config.test(mobile)){
				$("#errorMsg").text("请输入正确的手机号");
				return false;
			}

		}
	});

	$("#valid_image").click(function(){
		image_init();
	});

	$("a[name='image_again']").click(function(){
		image_init();
	});

	$(".submit a").click(function(){
		var mobile = $("#mobileNo").val();
		var validcode = $(".code input").val();
		var pwd = $("#password").val();
		$("#errorMsg").text('');
 

		//验证手机号码空或者长度不正确
		if(mobile.length!=11){
			$("#errorMsg").text("请输入正确的登录名");
			return false;
		}

		var reg = /^\d{11}$/;
		if(!reg.test(mobile)){
			$("#errorMsg").text("请输入正确的手机号");
			return false;
		}

	 
 
		if(null == pwd || "" == pwd||pwd.length<6){
			$("#errorMsg").text("密码不能为空,且不低于6位！");
			return false;
		}
		
		if(validcode == ""){
			$("#errorMsg").text("请输入验证码");
			return false;
		}
 

		$.ajax({
			type: "POST",
			dataType: "json",
			url:path+"/member/login.do",
			data:$("#loginForm").serializeArray(),
			success:function(data){
				
				if(data["logingFlag"]=="true"){
				    if(targetUrl.indexOf("/memberRegisterPage.do")>-1||targetUrl.indexOf("/registerPage.do")>-1){
				       targetUrl=path+"/product/list_page.do";
				    } 
					 window.location = targetUrl;
				}else{
					$(".password input[name='pwd']").attr("value","");
					image_init();
			        if(data["msg"]){
						$("#errorMsg").text(data["msg"]);
					}else {
						$("#errorMsg").text('对不起，系统忙，请您稍候再试！');
					}
				}
			}
		});
	});
	
});
