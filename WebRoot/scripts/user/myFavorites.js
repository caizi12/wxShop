function viewMore(pageNo){
	loading = true; 
	$('p.list-loading').show(); 
	pageNo=parseInt(pageNo)+1;
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=showUserFavoriteWareByAjax",
		data:"pageNo="+pageNo,
		dataType:"json",
		success:function(data){
			var htmlString="";
			if(data.wareInfos!=undefined && data.wareInfos.length>0){		 
				for(var i=0;i<data.wareInfos.length;i++){
					var maxValue = data.wareInfos[i].m_back.WARE_INTEGRAL_VALUE;
					var payType = data.wareInfos[i].m_back.PAY_TYPE;
					var oriIntegral = data.wareInfos[i].m_back.ORI_PAY_INTEGRAL;
			    	var oriPayCash = data.wareInfos[i].m_back.ORI_PAY_CASH;
			    	var curIntegral = data.wareInfos[i].m_back.CUR_INTEGRAL;
			    	var curPayIntegral = data.wareInfos[i].m_back.CUR_PAY_INTEGRAL;
			    	var curPayCash = data.wareInfos[i].m_back.CUR_PAY_CASH;
					htmlString+='<li><a href="'+getWarePath(data.wareInfos[i].m_back.EXCHANGE_MODE, data.wareInfos[i].m_back.EXCHANGE_ID,data.wareInfos[i].m_back.WARE_ID)+'"><img src="'+imagePathTool(data.wareInfos[i].m_back.MAIN_PIC_FILE,WARE_SHOW_IMG_PX_110)+'"/></a><div>'+data.wareInfos[i].m_back.WARE_NAME+'</div>';
					if(maxValue==0){
						if(payType.indexOf("01")>-1){
							htmlString+="<div class='clearfix'>积分:&nbsp;<span>"+maxValue+"</span></div>";
						}
						if(payType.indexOf("02")>-1){
							htmlString+="<div class='clearfix'>积分:&nbsp;";
							if(oriPayCash!=curPayCash || oriIntegral!=curPayIntegral){
								htmlString+="<p class='fl'><span><del>&yen;"+(parseFloat(oriPayCash)/100).toFixed(2)+"+"+oriIntegral+"</del></span></p></div>";
							}
							htmlString+="<p class='fl'><span><del>&yen;"+(parseFloat(curPayCash)/100).toFixed(2)+"+"+curPayIntegral+"</del></span></p></div>";
							
						}
						htmlString+="</li>";
					}else{
						if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								htmlString+="<div class='clearfix'><p class='fl'>积分: <span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+maxValue+"</del></p><i class='fr'>现金+</i></div>";
							}else{
								htmlString+="<div class='clearfix'><p class='fl'>积分: <span>"+maxValue+"</span></p><i class='fr'>现金+</i></div>";
							}
						}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								htmlString+="<div class='clearfix'>积分:&nbsp;<p class='fl'>&nbsp;<span>&yen;"+(parseFloat(curPayCash)/100).toFixed(2)+"+"+curIntegral+"</span></p><p class='fr'>&nbsp;<span><del>&yen;"+oriPayCash+"+"+oriIntegral+"</del></span></p></div>";
							}else{
								htmlString+="<div class='clearfix'>积分:&nbsp;<p class='fl'>&nbsp;<span>&yen;"+(parseFloat(oriPayCash)/100).toFixed(2)+"+"+oriIntegral+"</span></p></div>";
							}
						}else{
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								//htmlString+="<div>积分:&nbsp;<span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+oriIntegral+"</del></div>";
								htmlString+="<div>积分:&nbsp;<span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+maxValue+"</del></div>";
							}else{
								htmlString+="<div>积分:&nbsp;<span>"+maxValue+"</span></div>";
							}
							
							
						}
					}
					htmlString+="</li>";
				}
				if(data.wareInfos!='null'){
					$("#operationDIY").text("编辑");
				}else{
					$("#operationDIY").text('');
				}
				$(".ligCon").last("li").append(htmlString);
				$("#pageNo").val(data.pageNo);		
				$("#maxIndexPages").val(Math.ceil(data.count/8));
				loading = false;
				$('#loading').hide();	
			}else{
				window.location.href=path+"/user/nomyCollect.jsp";	 
			}
		},
		error:function(msg){
		}
	});
}
function viewMore_edit(pageNo){
	loading = true; 
	$('p.list-loading').show(); 
	pageNo=(parseInt(pageNo)+1);
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=showUserFavoriteWareByAjax",
		data:"pageNo="+pageNo,
		dataType:"json",
		success:function(data){
			var htmlString="";
			if(data.wareInfos!=undefined && data.wareInfos.length>0){		 
				for(var i=0;i<data.wareInfos.length;i++){
					var maxValue = data.wareInfos[i].m_back.WARE_INTEGRAL_VALUE;
					var payType = data.wareInfos[i].m_back.PAY_TYPE;
					var oriIntegral = data.wareInfos[i].m_back.ORI_PAY_INTEGRAL;
			    	var oriPayCash = data.wareInfos[i].m_back.ORI_PAY_CASH;
			    	var curIntegral = data.wareInfos[i].m_back.CUR_INTEGRAL;
			    	var curPayIntegral = data.wareInfos[i].m_back.CUR_PAY_INTEGRAL;
			    	var curPayCash = data.wareInfos[i].m_back.CUR_PAY_CASH;
					htmlString+='<li><a href="javascript:void(0)"><img src="'+imagePathTool(data.wareInfos[i].m_back.MAIN_PIC_FILE,WARE_SHOW_IMG_PX_110)+'"/></a><div>'+data.wareInfos[i].m_back.WARE_NAME+'</div>';
					if(maxValue==0){
						if(payType.indexOf("01")>-1){
							htmlString+="<div class='clearfix'>积分:&nbsp;<span>"+maxValue+"</span></div>";
						}
						if(payType.indexOf("02")>-1){
							htmlString+="<div class='clearfix'>积分:&nbsp;";
							if(oriPayCash!=curPayCash || oriIntegral!=curPayIntegral){
								htmlString+="<p class='fl'><span><del>&yen;"+(parseFloat(oriPayCash)/100).toFixed(2)+"+"+oriIntegral+"</del></span></p></div>";
							}
							htmlString+="<p class='fl'><span><del>&yen;"+(parseFloat(curPayCash)/100).toFixed(2)+"+"+curPayIntegral+"</del></span></p></div>";
							
						}
						htmlString+="</li>";
					}else{
						if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								htmlString+="<div class='clearfix'><p class='fl'>积分: <span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+maxValue+"</del></p><i class='fr'>现金+</i></div>";
							}else{
								htmlString+="<div class='clearfix'><p class='fl'>积分: <span>"+maxValue+"</span></p><i class='fr'>现金+</i></div>";
							}
						}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								htmlString+="<div class='clearfix'>积分:&nbsp;<p class='fl'>&nbsp;<span>&yen;"+(parseFloat(curPayCash)/100).toFixed(2)+"+"+curIntegral+"</span></p><p class='fr'>&nbsp;<span><del>&yen;"+oriPayCash+"+"+oriIntegral+"</del></span></p></div>";
							}else{
								htmlString+="<div class='clearfix'>积分:&nbsp;<p class='fl'>&nbsp;<span>&yen;"+(parseFloat(oriPayCash)/100).toFixed(2)+"+"+oriIntegral+"</span></p></div>";
							}
						}else{
							if(oriPayCash>curPayCash || oriIntegral>curPayIntegral){
								//htmlString+="<div>积分:&nbsp;<span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+oriIntegral+"</del></div>";
								htmlString+="<div>积分:&nbsp;<span>"+curIntegral+"</span>&nbsp;&nbsp;<del>"+maxValue+"</del></div>";
							}else{
								htmlString+="<div>积分:&nbsp;<span>"+maxValue+"</span></div>";
							}
							
							
						}
					}
					htmlString+='<div class="radio"><font style="margin-right: 0px;"><input type="checkbox" name="ware_id" id="ware_id" value="'+data.wareInfos[i].m_back.WARE_ID+'"></font></div>'
					htmlString+="</li>";
				}
				$(".ligCon").last("li").append(htmlString);
				$("#pageNo").val(data.pageNo);		
		    	$("#maxIndexPages").val(Math.ceil(data.count/8));
				loading = false;
				$('#loading').hide();	
				
			}else{
				window.location.href=path+"/user/nomyCollect.jsp";	 
			}
		},
		error:function(msg){
		}
	});
}
function getWarePath(exchangeMode, exchangeId,wareId){
	if (exchangeMode == TUAN_EXCHANGE_MODE && exchangeId != 0) {
		 return path+"/"+TUANBUY_URL_PREFIX+"/"+exchangeId+".html";
	}else{
		return path+"/"+WARE_URL_PREFIX+"/"+wareId+".html";
	}
	
}
function imagePathTool(name,imgpx){
	return srcPath=path+"/pic/ware/"+name.split(".")[0] + imgpx + name.split(".")[1];
}
function goAccountFavorites(){
	window.location.href=path+"/portal/user/web/UserAccountAction?action=showUserFavoriteWare&flag=edit";
}
function finishEdit(){
	window.location.href=path+"/portal/user/web/UserAccountAction?action=showUserFavoriteWare";
}
/**
*    是否显示复选框
* @param obj    当前对象
* @param all    checkall
 */
function cancel(obj,all) {
	alert();
}

//-----根据复选框删除选中我的收藏中的礼品--------------
function deleteByCheckBox(){
    var temp = document.getElementsByName("ware_id");
    var wareIds="";

    for(var i=0;i<temp.length;i++){
        if(temp[i].checked){
        	wareIds+=temp[i].value + ",";
        }
    }
    if(wareIds.length==0){

    	Dialog('.detailDialog');
    	msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
    	msg = '请选择要删除的礼品';
    	$("#showMessage").html(msg);
        $("#btnShow").html(msg_btn);
    	
		return false;
	}
    wareIds=wareIds.substring(0,wareIds.length-1); 
	$.ajax({
	    type:"POST",
        dataType:"json",
        url:checkCurUserLoginAction+"checkCurUserLogin",
        success:function(data){
        	if(data.msg == "Y"){
                var msg_btn = '';
                msg_btn += '<a  class="btnBuy"  onclick="deleteFavor(\'' + wareIds + '\');">确定</a>';
                msg_btn += '<a  class="btnBuy"  onclick=DialogClose(".detailDialog")>取消</a>';

                Dialog('.detailDialog');
            	msg = '确定要删除的选中礼品吗？';
            	$("#showMessage").html(msg);
                $("#btnShow").html(msg_btn);
                
        	} else {
	        	var msg_btn='';
				//未进行登陆
				msg_btn += '<button class="popbtn" onclick="window.location=\'' + path + '/login/login.jsp' +'\'">确定</button>';
				msg_btn += '<button class="popbtn" onclick="dupClose();">取消</button>';
				$.dialog.show({
					type:$.dialog.type.MESSAGE_TYPE_FAILURE,
					title:'您还没有登录',
					msg:'您好，要删除选中礼品，请先登录！',
					button:msg_btn
				});
        	}
        }
});
	
}
//执行删除我的收藏
function deleteFavor(wareid){
	var submitAction=accountAction+"deleteUserFavoriteWare";
	document.getElementById("form").action = submitAction;
	document.getElementById("ware_Ids").value=wareid;
	document.getElementById("form").submit();
}