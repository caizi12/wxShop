//------加入礼品车--------
function addShoppingCart(path,wareId,wareName,wareImg,gValue,mValue,eValue,payType,curCash,curIntegral,wareAmount){
	//$.messageInfo('','正在提交数据,请稍候...',5);
	var msg_btn = '';
	var show_message = '很抱歉，本礼品暂不支持您的手机品牌，您无法兑换';
	
	var shopCartAction = "/portal/order/web/ShoppingCartAction?action=showUserShopInfo";
    //初始化数据
    wareAmount = wareAmount || 1;
	 $.ajax({
		    type:"POST",
		    url:path + "/portal/nb.lf.portal.ware.web.WareDetailAction?is_test=N&action=addShoppingCart&t=" + (new Date().getTime().toString(36)),
		    dataType:"json",
		    data:"ware_id="+wareId+"&ware_name="+wareName+"&ware_img="+wareImg+"&g_value="+gValue+"&m_value="+mValue+"&e_value="+eValue+"&payType="+payType+"&curCash="+curCash+"&curIntegral="+curIntegral+"&ware_amount="+wareAmount,
		    success:function(data){
				if(data['code']=='210010'){
					show_message = '该礼品已经下线';
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='210011'){
					show_message = "礼品：<strong>"+ data['name'] +"</strong> 已经放入礼品车，若要修改礼品数量请进入礼品车页面。";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='14'){
					show_message = "该礼品不允许放入礼品车，要兑换该礼品，请直接定制该礼品";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='15'){
					show_message = "该礼品不允许放入礼品车，要兑换该礼品，请查看专题页";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='10008'){
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				//礼品车种类数量超出限制
				if(data['code']=='10009'){
					show_message = data['msg'];
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}
				if(data['code']=='10004'){
					show_message = "一次最多能兑换10个礼品，您输入的数量有误，请重新输入";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='1215'){
					show_message = "该礼品不允许放入礼品车，要兑换该礼品，请直接兑换";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

				if(data['code']=='1216'){
					show_message = "该礼品不允许放入礼品车，要兑换该礼品，请直接兑换";
	       			setDialogMessage(msg_btn, show_message);
					return false;
				}

			    var ware_count = data['msg'].length;
			    var g_integral_value = 0;
			    var m_integral_value = 0;
			    var e_integral_value = 0;
			    var oriIntegral = 0;
			    var cash = 0;
			    var payIntegral = 0;
			    var combineBrand = 0;
				var msg = '';
				var amount_ware = 0;
				// JHC提示信息要改
				//及时更新页头文件中礼品车的数量
				$('#shop_count').text(parseInt(data['msg'].length)<0?0:parseInt(data['msg'].length));
				//及时更新详情页中“礼品车图标”的数量
				$('#cartNum').text(parseInt(data['msg'].length)<0?0:parseInt(data['msg'].length));

				  for(var i=0;i<ware_count;i++){
					if(data['msg'][i].shopPayType =="01" ){
				    	g_integral_value += data['msg'][i].g_integral_value*data['msg'][i].amount;
				    	m_integral_value += data['msg'][i].m_integral_value*data['msg'][i].amount;
				        e_integral_value += data['msg'][i].e_integral_value*data['msg'][i].amount; 
				        var curIntegral = data['msg'][i].curIntegral*data['msg'][i].amount; 
				        //如果现值存在 ，取现值
				        if(curIntegral>0){
				        	oriIntegral += data['msg'][i].curIntegral*data['msg'][i].amount;
				        }else{
				        	oriIntegral += data['msg'][i].oriIntegral*data['msg'][i].amount; 
				        }
					}else{
						payIntegral += data['msg'][i].curPayIntegral * data['msg'][i].amount; 
						cash +=  accMul((data['msg'][i].curPayCash * data['msg'][i].amount),0.01); 
					}
				  }

				  if(ware_count>=1){
					 // if(Number(g_integral_value) >=Number(m_integral_value) && Number(g_integral_value) >=Number(e_integral_value) ){
					 //	  combineBrand = g_integral_value;
					 // }else if(m_integral_value >=g_integral_value && m_integral_value >=e_integral_value){
					 //	  combineBrand = m_integral_value;
					 // }else{
					 //	  combineBrand = e_integral_value;
					 // }
					 combineBrand = oriIntegral;
				  }
				  // 四舍五入				 
				  cash = Number(Number(cash).toFixed(2));
				  combineBrand =combineBrand+payIntegral;
				  show_message = '礼品已经放入礼品车，当前共  <strong class="important" style="padding: 0px;" >';
                  // 提示信息保持和对应的头文件礼品车的数量相同
				  // msg += amount_ware + '</strong> 件礼品，';
				  show_message += ware_count + '</strong> 款礼品，';
				  show_message += '积分共：<strong class="important" style="padding: 0px;">' +  combineBrand + '</strong>';
				  if(cash !=0){
					  show_message += '，现金共：<strong class="important">' + cash + '元</strong>。';
				  }
				  
				  msg_btn = '<a class="btnBuy" onclick="goShoppingCart();">去购物车</a>';
				  msg_btn += '<a class="btnCar" onclick="DialogClose(\'.detailDialog\');">继续购物</a>';
	       		  setDialogMessage(msg_btn, show_message);
				}
		  });
}

//加入收藏夹
function collectWare(path,wareId,wareBrand,flag){
	//$.messageInfo('','正在提交数据,请稍候...',5);
    if(flag == null ) {
    	flag = '00';
    }
	var show_message = '很抱歉，本礼品暂不支持您的手机品牌，您无法收藏';

	var userAccountAction = path + "/portal/user/web/UserAccountAction?action=";
	var msg_btn = '';
	$.ajax({
		type:"post",
		dataType:"json",
		url:userAccountAction + "addFavourite",
		data:"wareIds=" + wareId + "&wareBrand=" + wareBrand,
		success:function(data){
			if(data.msg == "success"){
				msg_btn = '<a class="btnBuy" onclick="window.location=\''+userAccountAction+'showUserFavoriteWare\'">进入收藏夹</a>';
		        show_message = "成功放入收藏夹,您的收藏夹现在有<strong class=\"important\">"+ data.amount + "</strong>款礼品";
		        $("#collectHeart").addClass("click");
       			setDialogMessage(msg_btn, show_message);
			}else if(data.msg == "login"){
				var url =path + '/login/login.jsp?target='+path+'/ware/'+wareId+'.html';
				msg_btn = '<a class="btnBuy" onclick="window.location=\''+url+'\'");">登录</a>';
				show_message = "您好，要收藏此礼品，请先登录！";
	       		setDialogMessage(msg_btn, show_message);
			}else if(data.msg == "INCONSISTENT_BRAND"){
	       		setDialogMessage(msg_btn, show_message);
			}else{
				msg_btn = '<a class="btnBuy" onclick="window.location=\''+userAccountAction+'showUserFavoriteWare\'">进入收藏夹</a>';
				setDialogMessage(msg_btn, data.content);
			}
		}
	});
}

//取消收藏礼品
function deleteFavor(path,collectWareId){
	var show_message = '很抱歉，取消收藏失败';
	var msg_btn = '';
	$.ajax({
	    type:"POST",
        dataType:"json",
        url:path+"/portal/user/web/UserAccountAction?action=delUserCollectWare",
        data:"wareId="+collectWareId,
        success:function(data){
			if(data.msg == "success"){
		        show_message = "取消收藏成功！";
		        $("#collectHeart").removeClass("click");
	   			setDialogMessage(msg_btn, show_message);
			}else if(data.msg == "login"){
				var url =path + '/login/login.jsp?target='+path+'/ware/'+collectWareId+'.html';
				msg_btn = '<a class="btnBuy" onclick="window.location=\''+url+'\'");">登录</a>';
				show_message = "您好，您还未登录，请先登录！";
	       		setDialogMessage(msg_btn, show_message);
			}else if(data.msg == "failure"){
	       		setDialogMessage(msg_btn, show_message);
			}
		}
	});

}

//查询当前礼品车数量
function initCartNum(path){
	$.ajax({
	    type:"POST",
        dataType:"json",
        url:path+"/portal/ware/web/WareDetailAction?action=showUserShopNum",
        data:"",
        success:function(data){
			if(data.msg == "success"){
				$("#cartNum").text(parseInt(data.wareCount));
			}else{
				$("#cartNum").text(0);
			}
		}
	});
}

function goLogin(path,wareId,wareBrand){
	window.location = path + "/login/login.jsp?detail_id="+wareId+"&wareBrand="+wareBrand;
}
function goPLogin(path){
	window.location = path + "/login/login.jsp";
}
//-------继续提醒--------

function updateUserBoolDetileInfo(path,bookdetailId,wareId,wareBrand){
	var msg_btn = '';
	msg_btn += '<a class="btnBuy" onclick="updateUserBoolDetileInfoAjax(\''+ path +'\',\''+ bookdetailId +'\',\''+ wareId +'\',\''+ wareBrand +'\');">确定</a>';
	setDialogMessage(msg_btn, '确定要继续提醒该礼品吗？');
}

function updateUserBoolDetileInfoAjax(path,bookdetailId,wareId,wareBrand){

	var UserBookAction = path+"/portal/information/web/UserBookAction?action=";
	var show_message = '很抱歉，本礼品暂不支持您的手机品牌，您无法继续提醒 ';
	
	var msg_btn = '';
	 $.ajax({
		    type:"POST",
		    url:path + "/portal/information/web/UserBookAction?action=updateUserBoolDetileInfo",
		    dataType:"json",
		    data:"bookdetailId=" +bookdetailId+ "&wareIds=" + wareId + "&wareBrand=" + wareBrand,
		    success:function(data){
				if(data.msg =='same'){
					show_message = "您好,您定制的到货提醒礼品已经存在";
		       		setDialogMessage(msg_btn, show_message);
				}else if(data.msg =='success'){
					msg_btn = '<a class="btnCar" onclick="window.location=\''+UserBookAction+'getUserBookRemind\'">关闭</a>';
					show_message = "您定制的继续提醒成功";
		       		setDialogMessage(msg_btn, show_message);
				}else if(data.msg == "login"){
					var url =path + '/login/login.jsp';
					msg_btn = '<a class="btnBuy" onclick="window.location=\''+url+'\'">登录</a>';
					show_message = "您好，要继续定制该提醒，请先登录！";
		       		setDialogMessage(msg_btn, show_message);
				}else if(data.msg == "INCONSISTENT_BRAND"){
					setDialogMessage(msg_btn, show_message);
				}else{
					setDialogMessage(msg_btn, data.content);
					
				}
	 		}
	 });
}
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try { m += s1.split(".")[1].length } catch (e) { }
    try { m += s2.split(".")[1].length } catch (e) { }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}