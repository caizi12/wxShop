var showQue = "que1";
$(document).ready(function(){
	if(isGetExamNaire){
		$("#que1").css("display","block");
	}
});
var isChange = false;
$(function(){
	$('.btnNext a').bind('click',function(){
		$("#"+showQue).find("input").each(function(){
			if(this.checked){
				isChange = true;
				return false;
			}
		});
		if(isChange){
			isChange = false;
			$(".error").text("");
			if(showQue.indexOf("que1")!=-1&&showQue.indexOf("que10")==-1&&showQue.indexOf("que11")==-1&&showQue.indexOf("que12")==-1){
				$("#que1 input").each(function(){
					if(this.checked){
						if($(this).attr("id").indexOf("que1A")!=-1){
							$("#que1").css("display","none");
							$("#que2").css("display","block");
							showQue = "que2";
						}else{
							showQue = "que6";
							$("#que1").css("display","none");
							$("#que6").css("display","block");
						}
						return false;
					}
				});
			}else if(showQue.indexOf("que2")!=-1){
				$("#que2 input").each(function(){
					if(this.checked){
						if($(this).attr("id").indexOf("que2A")!=-1){
							$("#que2").css("display","none");
							$("#que4").css("display","block");
							showQue = "que4";
						}else{
							$("#que2").css("display","none");
							$("#que3").css("display","block");
							showQue = "que3";
						}
						return false;
					}
				});
			}else if(showQue.indexOf("que3")!=-1){
				$("#que3").css("display","none");
				$("#que6").css("display","block");
				showQue = "que6";
			}else{
				$("#"+showQue).css("display","none");
				var queIndex = parseInt(showQue.substring(3,showQue.length)) + 1;
				$("#que"+queIndex).css("display","block");
				showQue = "que"+queIndex;
				if(showQue == "que12"){
					$(".btnNext").css("display","none");
					$(".btnSubmit a").css("display","block");
				}
			}
		}else{
			$(".error").text("请选择相应选项！");
		}
	});

	$(".askCon .line").bind('click',function(){
		var names=$(this).parent().prev().attr("name");
		var index = 0;
		if(names.indexOf("que8")!=-1 || names.indexOf("que12")!=-1  ) {
			index = 0;
			$(this).parent().parent().parent().find("input").each(function(){
				if(this.checked){
					index++;
				}
			});
			if(index<2)
				$(this).parent().prev().attr('checked','checked');
			
		}else if(names.indexOf("que6")!=-1){
			index = 0;
			$(this).parent().parent().parent().find("dd").each(function(){
				$(this).find("input").each(function(){
					if(this.checked){
						index++;
						return false;
					}
				});
			});
			if(index<5) $(this).parent().prev().attr('checked','checked');
		}else{
			$(this).parent().prev().attr('checked','checked');
		}
	});

	$(".askCon li input").bind('click',function(){
		var names=$(this).attr("name");
		var index = 0;
		if(names.indexOf("que5")!=-1 ||names.indexOf("que8")!=-1 || names.indexOf("que12")!=-1){
			index = 0;
			$(this).parent().parent().find("input").each(function(){
				if(this.checked){
					index++;
				}
			});
			if(index>2) $(this).attr('checked',false);
		}else if(names.indexOf("que6")!=-1){
			index = 0;
			$(this).parent().parent().find("dd").each(function(){
				$(this).find("input").each(function(){
					if(this.checked){
						index++;
						return false;
					}
				});
			});
			if(index>5) $(this).attr('checked',false);
		}
	});

	var CheckData = /<|>|'|,|;|&|#|"|'|\*|\^|\{|\}|\[|\]|%|[\$]|@|!|\?|…|”|“/;

	$(".btnSubmit").bind('click',function(){
		var ansStr="";

		var ansStr1="", ansStr2="",ansStr3="",ansStr4="",ansStr5="",ansStr6="",ansStr7="",ansStr8="",ansStr9="",ansStr10="",ansStr11="",ansStr12="";

		$("input").each(function(){
			if(this.checked){
				if($(this).attr("id")=="que4G" || $(this).attr("id")=="que7G" || $(this).attr("id")=="que8F" || $(this).attr("id")=="que12H" ||
					$(this).attr("id")=="que6A3" || $(this).attr("id")=="que6B3" || $(this).attr("id")=="que6C6" || $(this).attr("id")=="que6D2" ||
					$(this).attr("id")=="que6J3" || $(this).attr("id")=="que6E5" || $(this).attr("id")=="que6F5" || $(this).attr("id")=="que6G3" ||
					$(this).attr("id")=="que6H3" || $(this).attr("id")=="que6I6" || $(this).attr("id")=="que6K4" || $(this).attr("id")=="que6L4" ||
					$(this).attr("id")=="que6M" 
				){
					if(!CheckData.test($(this).next().find("input").val())){
						if($(this).attr("id").indexOf("que4")!=-1){
							ansStr4+=$(this).attr("id")+"="+$(this).next().find("input").val()+",";
						}else if($(this).attr("id").indexOf("que6")!=-1){
							ansStr6+=$(this).attr("id")+"="+$(this).next().find("input").val()+",";
						}else if($(this).attr("id").indexOf("que7")!=-1){
							ansStr7+=$(this).attr("id")+"="+$(this).next().find("input").val()+",";
						}else if($(this).attr("id").indexOf("que8")!=-1){
							ansStr8+=$(this).attr("id")+"="+$(this).next().find("input").val()+",";
						}else if($(this).attr("id").indexOf("que12")!=-1){
							ansStr12+=$(this).attr("id")+"="+$(this).next().find("input").val()+",";
						}
					}
				}else{
					if($(this).attr("id").indexOf("que1A")!=-1||$(this).attr("id").indexOf("que1B")!=-1){
						ansStr1+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que2")!=-1){
						ansStr2+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que3")!=-1){
						ansStr3+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que4")!=-1){
						ansStr4+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que5")!=-1){
						ansStr5+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que6")!=-1){
						ansStr6+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que7")!=-1){
						ansStr7+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que8")!=-1){
						ansStr8+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que9")!=-1){
						ansStr9+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que10")!=-1){
						ansStr10+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que11")!=-1){
						ansStr11+=$(this).attr("id")+",";
					}else if($(this).attr("id").indexOf("que12")!=-1){
						ansStr12+=$(this).attr("id")+",";
					}
				}
			}
		});

		if(ansStr1!=""){
			ansStr1 = ansStr1.substring(0,ansStr1.length-1);
		}
		if(ansStr2!=""){
			ansStr2 = ansStr2.substring(0,ansStr2.length-1);
		}
		if(ansStr3!=""){
			ansStr3 = ansStr3.substring(0,ansStr3.length-1);
		}
		if(ansStr4!=""){
			ansStr4 = ansStr4.substring(0,ansStr4.length-1);
		}
		if(ansStr5!=""){
			ansStr5 = ansStr5.substring(0,ansStr5.length-1);
		}
		if(ansStr6!=""){
			ansStr6 = ansStr6.substring(0,ansStr6.length-1);
		}
		if(ansStr7!=""){
			ansStr7 = ansStr7.substring(0,ansStr7.length-1);
		}
		if(ansStr8!=""){
			ansStr8 = ansStr8.substring(0,ansStr8.length-1);
		}
		if(ansStr9!=""){
			ansStr9 = ansStr9.substring(0,ansStr9.length-1);
		}
		if(ansStr10!=""){
			ansStr10 = ansStr10.substring(0,ansStr10.length-1);
		}
		if(ansStr11!=""){
			ansStr11 = ansStr11.substring(0,ansStr11.length-1);
		}
		if(ansStr12!=""){
			ansStr12 = ansStr12.substring(0,ansStr12.length-1);
		}
		
		ansStr = ansStr1+";"+ansStr2+";"+ansStr3+";"+ansStr4+";"+ansStr5+";"+ansStr6+";"+ansStr7+";"+ansStr8+";"+ansStr9+";"+ansStr10+";"+ansStr11+";"+ansStr12;
		
		
		$.ajax({
			type:"post",
			url:contextPath+"/portal/order/web/IntegralReturnAction?action=saveIntegralReturnGifts",
			dataType:"json",
			data:"ansStr="+ansStr,
			success:function(data){
				if(data.errorType == "noLogin"){
					var sendurl = contextPath+"/exam/examNaire.html";
					var msg_btn = '<button class="popbtn" onclick="window.location=\''+contextPath+'/login/login.jsp?target='+sendurl+'\'">登录</button>';
					msg_btn += '<button class="popbtn" onclick="dialogClose();">取消</button>';
					$.dialog.show({
						type:$.dialog.type.MESSAGE_TYPE_INFO,
						title:"提示",
						msg:data.errorMsg,
						button:msg_btn
					});
					return false;
				}else if(data.errorType == "error"){
					$(".error").text(data.errorMsg);
				}else if(data.errorType == "success"){
					$(".right").text("调研结果已成功提交，感谢您的参与！");
				}else{
					
				}
			}
		});
	});

	
});