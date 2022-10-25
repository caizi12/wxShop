
function updateWareCount(index, count){
	//采用正则表达式取掉两端的空格
	var currentCount = $("#wareCount"+index).val().replace(/(^\s*)|(\s*$)/g, "");
	
	var attrArrys = $("#wareData"+index).attr("value").split(",");
    var wareId = attrArrys[0];
    var warPayType = attrArrys[1];
    var deliverType = attrArrys[9];
    var oldCount = $("#wareAmountOld"+index).val();
    
	if(parseInt(count)==0){
		var msg_btn = '';
		var msg = '';
	    // 输入的礼品数量为空
	    if(currentCount ==""){
	    	msg_btn= '';
	    	msg = '';
	    	Dialog('.detailDialog');
	    	msg = '您的输入数量不能为空';
	        msg_btn += '<a class="btnBuy" onclick="DialogClose(\'.detailDialog\');">确定</a>';
	    	$("#showMessage").html(msg);
	    	$("#btnShow").html(msg_btn);
	    	$("#wareCount"+index).val(oldCount);
			return;
	    }
	} else {
		//点击增加减少按钮
		oldCount = currentCount;
		var result = parseInt(oldCount)+parseInt(count);
		currentCount = result;
		if(result<1){
		  //数量不能小于1
		  $("#wareCount"+index).val(1);	
		} else {
		  $("#wareCount"+index).val(result);
		}
	}

	if(!g_IsInt(currentCount) ||(deliverType!='10'&&deliverType!='11'&&deliverType!='01'&&deliverType!='02'&&parseInt(currentCount) > 10)
    	    ||parseInt(currentCount)>999 ){
		msg_btn= '';
    	msg = '';
    	Dialog('.detailDialog');
    	//  非法字符提示
		msg = "您的输入数量只能是数字";
        if(deliverType!='11'&&deliverType!='01'&&deliverType!='02'&&parseInt(currentCount) > 10){
        	msg = "您的礼品数量不能大于10";
        }else if(parseInt(currentCount)>999){
        	msg = "您的礼品数量不能大于999";
        }else if(parseInt(currentCount)<1){
        	msg = "您的礼品数量不能小于1";
		}
    	Dialog('.detailDialog');
    	//显示弹出层
        msg_btn += '<a class="btnBuy" onclick="DialogClose(\'.detailDialog\');">确定</a>';
    	$("#showMessage").html(msg);
    	$("#btnShow").html(msg_btn);
        // 还原原始数量
    	$("#wareCount"+index).val(oldCount);
		return;
	}
	

    var checkBox = $("#wareIdNum"+index); 
	if(oldCount != currentCount){
		$.ajax({
			type:"post",
			dataType:"json",
			url:shopCartAction+"modifyShopInfoAmount",
			data:"wareId=" + wareId + "&newAmount=" + currentCount+"&payTypes="+warPayType,
			success:function(data){
				if(data.msg == "success"){
		    		if(!checkBox.checked){
		    			$("#wareFont"+index).addClass('active');
		    	    	$("#wareIdNum"+index).attr("checked",true);
		    	    	refreshSelectAll(); 
		            }
		    		updateShopCount();
		    		$("#wareAmountOld"+index).val(currentCount);
				}else{
	                msg_btn= '';
	            	msg = '';
	            	Dialog('.detailDialog');
	            	//显示弹出层
	            	msg = data.content;
	            	msg_btn += '<button class="popbtn" onclick="dialogClose();">确定</button>';
	            	$("#showMessage").html(msg);
	            	$("#btnShow").html(msg_btn);
	            	$("#wareCount"+index).val(oldCount);	
	        		return;
				}
			}
		});
	}
}

/**
* 删除不支持支付方式的礼品
*
*/
function deleteWare(){
	var shopInfo = $(".shopCarslist :checked[name=wareIdNum]");
	if(shopInfo.length<1){
	  var msg_btn = '';
	  var msg = '';
	  		
	  msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
	  msg = '请选择要删除的礼品';
	      
	  $("#showMessage").html(msg);
	  $("#btnShow").html(msg_btn);
	  Dialog('.detailDialog');
	  return;
	}
	var wareIds = "";
	var payTypes = "";
	for(var i = 0;i<shopInfo.length;i++) {
	  var wareIdNum = shopInfo[i].id.substr("wareIdNum".length);
	  var wareId = shopInfo[i].value;
	  var attrArrys = $("#wareData"+wareIdNum).attr("value").split(",");
	  var payType = attrArrys[1];
	
	  wareIds=wareIds+wareId+",";
	  payTypes = payTypes+payType+",";
	}
	wareIds = wareIds.substr(0, wareIds.length-1);
	payTypes = payTypes.substr(0, payTypes.length-1);

	var msg_btn = '';
	var msg = '';
	//显示弹出层
	msg = '确定要删除该礼品吗？';
	msg_btn += '<a class="btnBuy" onclick="clearFromCookieOfNoType(\'' + wareIds+ '\',\''+payTypes+'\');">确定</a>';
	$("#showMessage").html(msg);
	$("#btnShow").html(msg_btn);
	Dialog('.detailDialog');
}

function clearFromCookieOfNoType(wareIds,payTypes)   {
    var delAllFlag = "1";
    $.ajax({
        type:"POST",
        dataType:"json",
        url:path+"/portal/nb.lf.portal.order.web.ShoppingCartAction?action=deleteFromCookie",
        data:"ware_ids="+wareIds+"&delAllFlag="+delAllFlag+"&payTypes="+payTypes,
        success:function(data){
            if(data.msg == "success"){
                addEventCode(delSucc);
                window.location.reload();
            }else{
                addEventCode(delFail);
                }
        }
    });
}

function selectWare(index) {
    if($("#wareFont"+index).attr("class")=='active'){
    	$("#wareFont"+index).removeClass('active');
    	$("#wareIdNum"+index).attr("checked",false); 
    } else {
    	$("#wareFont"+index).addClass('active');
    	$("#wareIdNum"+index).attr("checked",true); 
    }
	updateShopCount();
	refreshSelectAll();
}

function refreshSelectAll(){
	//改变全选状态
	var checkedShopInfos = $(".shopCarslist :checked[name=wareIdNum]");
	var allShopInfos = $(".shopCarslist :input[name=wareIdNum]");
	if(checkedShopInfos.length==allShopInfos.length) {
		$("#selectAllFont").addClass('active');
	} else {
		$("#selectAllFont").removeClass('active');
	}
}

function selectAll() {
	var selectAll = true;
    if($("#selectAllFont").attr("class")=='active'){
		selectAll = false;
	}
	if(selectAll){
    	$("#selectAllFont").addClass('active');
	}else{
		$("#selectAllFont").removeClass('active');
	}
    //勾选礼品列表
	$(".shopCarslist input[name='wareIdNum']").each(  
		function(){
			if(selectAll){
				$(this).attr("checked", true);
				$(this).parent().addClass('active');
			} else {
				$(this).attr("checked", false);
				$(this).parent().removeClass('active');
			}		    
		}
	)
	 
	updateShopCount();
}

/**
*   更新礼品车数量和更新礼品对应的积分数值和M数值
*
*/
function updateShopCount(){
   var sumCash = 0;
   var sumIntegral = 0;

   var shopInfo = $(".shopCarslist :checked[name=wareIdNum]");
   var shopInfoArray = shopInfo.map(function(){return this.id}).get();

   var totalWareCount = 0;
   for(var i = 0;i<shopInfoArray.length;i++) {
	 var wareIdNum = shopInfoArray[i].substr("wareIdNum".length);

	 //支付方式不支持
	 if($("#wareFont"+wareIdNum).attr("value")=="disabled1"){
		 continue;
	 }
	 
     var amount = $("#wareCount"+wareIdNum).val();; // 取得数量
     
     var attrArrys = $("#wareData"+wareIdNum).attr("value").split(",");
     var payType = attrArrys[1];

     var integral  = 0;
     var cash  = 0;
     // 支付方式为全积分
     if(payType == "01" && amount != 0){
    	 integral = parseInt(attrArrys[3]);// 现全积分
     }else if(payType == "02" && amount != 0){
         cash = Number(attrArrys[4]); 
         integral = Number(attrArrys[5]);
     }
     sumCash = Number(sumCash) +  Number(cash * amount); // 现金值
     sumIntegral = Number(sumIntegral) + Number(integral * amount);// 积分值

     totalWareCount = Number(totalWareCount)+Number(amount);
   }   
   $('#shop_count').html("去结算(" + totalWareCount + ")");
   sumCash = Number(sumCash).toFixed(2);
   if(Number(sumCash)==0){
	   $("#sumIntegral").html(sumIntegral);
   } else {
	   $("#sumIntegral").html("&yen;" + sumCash + "+" + sumIntegral);
   }
}

function goShopping(){
	window.location.href = path+'/index.html';
}

function exchangeWare(){
	var msg = "";
	var shopIds="";  
	var wareIds="";  
	var msg_btn = ""; 
    var online = 0; // 线上
    var offline = 0;  // 线下
    var integral = 0;//全积分
    var payTypes = "";
    var isOk = true;
    var sumWare = 0;
    // 存放加入的礼品
    var map = {}; 
    var key = "";  
    var value = ""; 
    // 是否有重复礼品
    var isRepeat = false;
    var shopInfo = $(".shopCarslist :checked[name=wareIdNum]");
    var shopInfoArray = shopInfo.map(function(){return this.id}).get();// 返回一个数组存放的是id
    for(var i = 0;i<shopInfoArray.length;i++) {
    	 var wareIdNum = shopInfo[i].id.substr("wareIdNum".length);

    	 if($("#wareFont"+wareIdNum).attr("value")=="disabled1"){
		   //支付方式不匹配  不能下单
		   Dialog('.detailDialog');
	  		
	       msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
	       msg = '所选礼品中有不能兑换的礼品，请重新选择';
	        
	       $("#showMessage").html(msg);
	       $("#btnShow").html(msg_btn);
		   return;
    	 }
    	 
    	 var attrArrys = $("#wareData"+wareIdNum).attr("value").split(",");
         wareIds += attrArrys[0]+",";
         shopIds += attrArrys[2]+",";
         var payType = attrArrys[1];
         payTypes += payType+",";
         // wareID+_+payType
         key = attrArrys[0]+"_"+attrArrys[1];
         value = $("#"+shopInfoArray[i]).val()+"";
         if(key in map){
        	 isRepeat = true;
         }else{
        	 map[key] = value; 
         }
        
         var isOn = attrArrys[6];
         var isOff = attrArrys[7];
         if("01"==payType){
             integral++;
         }
         if("02"==payType){
            // 如果支持线上
            if("1" == isOn && "1" != isOff ){
              online++;
            }
            //如果支持线下
            if("1" == isOff && "1" != isOn){
                offline++;
            }
           }
         sumWare = sumWare+1;
    }
    shopIds = shopIds.substring(0,shopIds.length-1);
  	wareIds = wareIds.substring(0,wareIds.length-1);
  	payTypes = payTypes.substring(0,payTypes.length-1);
  	if(wareIds.length==0){
  		Dialog('.detailDialog');
  		
        msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
        msg = '请选择要兑换的礼品';
        
        $("#showMessage").html(msg);
        $("#btnShow").html(msg_btn);
		return;
	}
 	// 校验线上线下支付
  	if(Number(sumWare) >0){
  	   if(online > 0 && offline >0){
  		  isOk = false; 
  	   }	 
  	}
$("#shopIds").val(shopIds);
$("#wareIds").val(wareIds);
$("#payTypes").val(payTypes);
   
if(isRepeat){
   	Dialog('.detailDialog');
   	msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
   	msg = '您好，您兑换的礼品中存在重复礼品，不能同时提交！';
   	$("#showMessage").html(msg);
       $("#btnShow").html(msg_btn);
          return false;
}
   // 校验线上线下支付
   if(!isOk){
   	Dialog('.detailDialog');
   	msg_btn = '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">确定</a>';
   	msg = '您好，仅支持在线支付和仅支持线下支付的礼品需分开提交。请修改所选礼品重新提交！';
   	$("#showMessage").html(msg);
       $("#btnShow").html(msg_btn);
          return false;
}
$("#deliverForm").submit();
}

function doLogin(wareIds,shopIds,payTypes) {
    window.location.href = path+"/login/login.jsp?target="+path+"/portal/order/web/UserOrderAction?action=orderDeliverInfo&wareIds=" + wareIds +"&shopIds=" + shopIds+"&payTypes=" + payTypes;
}

//弹出层-对话框
function Dialog(dom){
    $(dom).find('.dialog_cont').height($(window).height()-250);
    var _domW =$(dom).width()/2;
    var _domH = $(dom).height()/2;
    if(!$('body').find('.mask').length){
        $('body').append('<div class=mask></div>'); 
    }
    $('.mask').height($(document).height()).show();
    $(dom).css({'margin-left':-_domW,'margin-top':-_domH}).fadeIn();
    if('undefined' == typeof(document.body.style.maxHeight)){
         $("body").append('<iframe frameborder="0" class="ie6_iframe"></iframe>');
         $('.ie6_iframe').height($(document).height());
    }
    $(window).resize(function(){
        $(dom).find('.dialog_cont').height($(window).height()-250);
        var _domW =$(dom).width()/2;
        var _domH = $(dom).height()/2;
        $(dom).css({'margin-left':-_domW,'margin-top':-_domH});
    });
};
//弹出层-关闭对话框
function DialogClose(dom){
    $(dom).fadeOut();
    $(window).unbind('resize');
    $('.mask').fadeOut(function(){
        $('.mask').remove();
        $(".ie6_iframe").remove();      
    });
    updateShopCount();
    return false;
};