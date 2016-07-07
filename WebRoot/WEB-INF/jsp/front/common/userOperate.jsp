<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 

<%
    String path = request.getContextPath();
    String UserOrderAction = path + "/portal/order/web/UserOrderAction?action=";
    String UserAccountAction = path + "/portal/user/web/UserAccountAction?action=";
    String ShoppingCartAction = "/portal/order/web/ShoppingCartAction?action=showUserShopInfo";
    String WareDetailAction = path + "/portal/ware/web/WareDetailAction?action=";
    String loginAction = path + "/portal/user/web/UserLoginAction?action=";
 
%>
<ngves:version src="/scripts/operate.js" type="text/javascript"/>
<script src="<%=path%>/scripts/operate.js" type="text/javascript"></script>
<script src="<%=path%>/scripts/jquery.bgiframe.js" type="text/javascript"></script>
<script type="text/javascript">

/**
 * src 需要的被操作的数值 例如： 111.111111111
 * pos 为保留几位数值   保留 2位
 * 结果为  111.11（四舍五入）
 */
function fomatFloat(src,pos){
	var f = parseFloat(src);
	if (isNaN(f)) {   
        return false;               
	}
	f = Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);
	var s = f.toString();               
    var rs = s.indexOf('.');               
    if (rs < 0) {   
    	rs = s.length;                   
		s += '.';   
    }               

    while (s.length <= rs + pos) {   
         s += '0';               
    }              
    return s;   
} 
 
/**
 * 显示缺货信息div
 */
function showStorage(divid) {
    document.getElementById(divid).style.display = "block";
}

function showStorage_new(divid, wareid, province) {//鼠标滑过的时候去得到相应的缺货信息
    if ($.trim($('#' + divid).html()).length == 0)
        lessStorage(divid, wareid, province);
    $('#' + divid).css({"display":"block"});

}

/**
 * 隐藏缺货信息div
 */
function hiddenStorage(divid) {
    document.getElementById(divid).style.display = "none";
}


/**
 * 收藏礼品信息
 * @param wareId  搜藏的礼品的id
 * @return
 */
function doCollectWare(wareId, wareBrand) {
	// 事件追踪码
    collectWare('<%=path%>', wareId, wareBrand);
}

function arrivalDoCollectWare(wareId, wareBrand) {
    collectWare('<%=path%>', wareId, wareBrand, '11');
}

/**
 * 放入购物车
 * @param ware_id
 * @param ware_name
 * @param ware_img
 * @param g_value
 * @param m_value
 * @param e_value
 * @param ware_brand
 * @param payType 支付方式
 * @param isOnlinePay 是否支付线上支付
 * @param isOffLinePay 是否支持线下支付
 * @param curPayCash 现现金+积分---现金值
 * @param curPayIntegral 现现金+积分---积分值
 * @param ware_amount
 * @return
 * modify add by shenfl 添加购物车礼品时候，进行二次属性信息验证和配送提示信息提醒
 * 加入购物车、今日推荐、我的收藏
 */
function doAddShoppingCart(ware_id, ware_name, ware_img, g_value, m_value, e_value, payType, curCash, curIntegral, ware_amount) {
	// 事件追踪码
	ware_amount = ware_amount || 1;
    var path = '<%=path%>';
    $.ajax({
            type:"post",
            dataType:"json",
            url:"<%=WareDetailAction%>getWareDescValue",
            data:"wareIds=" + ware_id,
            success:function(data) {
            	var show_message = '';
            	var msg_btn = '';
                if ((data['isExistDesc'] == 'true' || data['isShowDeContent'] == '1')) {
                	//show_message+="<div class=\"bothTips\">";
					//配送内容二次确认
                    if(data['isExistDesc'] == 'true') {
                        
                    	 if (data['reconfirmContent'] != undefined) {
                    		 var msg = data['reconfirmContent'].replace(/ /g,"&nbsp;");
                             show_message +="<strong>兑换提示：</strong><br/>";
                             show_message += "<div class=\"tipInfo\">";
                             show_message += "<strong class='important'>" + msg + "</strong><br /><br/>";
                             show_message += "</div>";
                         }
                    }
					//是否显示配送内容
                    if(data['isShowDeContent'] == '1') {                           
                    	 if (data['deliverContent'] != undefined) {
                    			var msg = data['deliverContent'].replace(/ /g,"&nbsp;");
                            	show_message += "<strong>配送提示：</strong></br>";
                            	show_message += "<div class=\"tipInfo\">";
                                show_message += "<strong class='important'>" + msg + "</strong><br />";	
                                show_message += "</div>";
                    	 }
                    }
                    msg_btn = '<a class="btnBuy" onclick="addShoppingCart(\'' + path+ '\',\'' + ware_id + '\',\'' + ware_name +  '\',\'' + ware_img +  '\',\'' + g_value +  '\',\'' + m_value +  '\',\'' + e_value +  '\',\'' +payType+ '\' ,\'' +curCash+ '\' ,\'' +curIntegral+ '\' ,\'' + ware_amount +  '\');">确定兑换</a>';
        			setDialogMessage(msg_btn, show_message);
                }else{
	               	addShoppingCart('<%=path%>', ware_id, ware_name, ware_img, g_value, m_value, e_value, payType, curCash, curIntegral, ware_amount);
                }
                
            }
	}); 
	 
}

function doupdateUserBoolDetileInfo(book_detail_id, ware_id, ware_brand) {
    updateUserBoolDetileInfo('<%=path%>', book_detail_id, ware_id, ware_brand);
}

/**
 * modify add by shenfl at 2012-6-8增加二次配送内容显示操作
 */
function getWareDesc(ware_id, ware_name, mags, ware_amount, typeCode, payType, proCode, cityCode, disCode) {
    $.ajax({
            type:"post",
            dataType:"json",
            url:"<%=WareDetailAction%>getWareDescValue",
            data:"wareIds=" + ware_id,
            success:function(data) {
            	var show_message = '';
            	var msg_btn = '';
                if (data['isExistDesc'] == 'true' || data['isShowDeContent'] == '1') {
					//配送内容二次确认
                    if(data['isExistDesc'] == 'true') {
                    	  var msg = data['reconfirmContent'].replace(/ /g,"&nbsp;");
                          show_message +="<strong>兑换提示：</strong><br/>";
                          show_message += "<div class=\"tipInfo\">";
                          show_message += "<strong class='important'>" + msg + "</strong><br /><br/>";
                          show_message += "</div>";
                    }
					//是否显示配送内容
                    if(data['isShowDeContent'] == '1') {
                    	var msg = data['deliverContent'].replace(/ /g,"&nbsp;");
                       	show_message += "<strong>配送提示：</strong></br>";
                       	show_message += "<div class=\"tipInfo\">";
                        show_message += "<strong class='important'>" + msg + "</strong><br />";
                        show_message += "</div>";
                    }
					mags = "'" + mags + "'";
                    if(typeCode==""){
                     	typeCode = "'" + typeCode + "'";
                    }
                    payType = "'" + payType + "'";
                    proCode = "'" + proCode + "'";
                    cityCode = "'" + cityCode + "'";
                    disCode = "'" + disCode + "'";
                    msg_btn += '<a class="btnBuy" onclick="doDirectExchange(' + ware_id + ','  + mags + ',' + ware_amount + ',' + typeCode + ',' + payType + ',' + proCode + ',' + cityCode + ',' + disCode + ');">确定兑换</a>';
        			setDialogMessage(msg_btn, show_message);
                } else {
                    doDirectExchange(ware_id, mags, ware_amount, typeCode ,payType,proCode,cityCode,disCode);
                }
            }
	});
}



/**
 * 列表页面，点击抢购按钮跳转到团购活动页面
 * add by shenfl 2012-11-15
 */
function skipTuan(exchangeId){
	window.location.href = "<%=request.getContextPath()%>/tuan/"+exchangeId+".html";
}

/**
* 转赠兑换方法
*
*/
function getConfirmWareDesc(ware_id, ware_name, mags, ware_amount, payType) {
	var nullGe =", ,";
	doDirectExchange(ware_id, mags, ware_amount, nullGe, payType);
}

/**
* 网购礼品中自有业务类转赠兑换方法
*
*/
function doConfirmWareDesc(ware_id, ware_name, mags, ware_amount,payType,proCode,cityCode,disCode) {
	var nullGe =", ,";
	doDirectExchange(ware_id, mags, ware_amount,nullGe,payType,proCode,cityCode,disCode);
}

/**
 * 直接兑换
 */
function doDirectExchange(ware_id, mags, ware_amount, typeCode, payType, proCode, cityCode, disCode) {
 
	
	// 在礼品详细页面如果隐藏礼品数量的时候ware_amount为undifined所以默认值设置为1
	if(ware_amount == undefined || !g_IsNumber(ware_amount) || ware_amount < 0){
		ware_amount = 1;
	}
    $.ajax({
           url:"<%=UserOrderAction%>checkUserInfo",
           type:"post",
           dataType:"json",
           async:false,
           success:function(data) {
               var msg = '';
               //取得大剧院库存
               //取得大剧院唯一标识
               var inventory = "";
               var wareType ="";
               if ($.trim(data['status']) == 'Y') {
                   inventory = parseInt($.trim(data['inventory'])) || 0;
                   wareType = parseInt($.trim(data['wareType'])) || 0;

                   $("#_wareIds").val(ware_id);
                   $("#_magIds").val(mags);
                   $("#_amount").val(ware_amount);
                   $("#_typeCode").val(typeCode);
                   $("#_selectPayType").val(payType);
                   $("#proCode").val(proCode);
                   $("#cityCode").val(cityCode);
                   $("#disCode").val(disCode);
                   
                   $("#errorMsg").text("正在提交数据,请稍候...");
                    
                   $("#direct_form").submit();
               } else {
            	   var msg_btn = '';
                   if(mags){
                   	   msg_btn = '<a class="btnBuy" onclick="doLogin(\'' + ware_id + '\',\'Y\',\'' + ware_amount + '\',\''+payType+'\',\''+proCode+'\',\''+cityCode+'\',\''+disCode+'\');">登录</a>';
                   }else{
                       msg_btn = '<a class="btnBuy" onclick="doLogin(\'' + ware_id + '\',\'\',\'' + ware_amount + '\',\'' + typeCode + '\',\''+payType+'\',\''+proCode+'\',\''+cityCode+'\',\''+disCode+'\');">登录</a>';
                   }
                   msg = "您好，要直接兑换礼品，请先登录！";
       			   setDialogMessage(msg_btn, msg);
               }
           }

       });
}

//DIY礼品订购
function doDiyShopping(wareCode, amount, g_value, m_value,e_value, ware_id) {
	// 事件追踪码
    $.ajax({
                type:"post",
                url:"<%=UserOrderAction%>checkDiyUserInfo",
                dataType:"json",
                data:"wareId=" + ware_id + "&diyWare=" + true + "&wareCode" + wareCode,
                success:function(data) {
                    var msg_btn = '';
                    if (data.status == "Y") {
                        var user_info = data.userInfo;
                        var errorMsg = '';
                        if(user_info.state == "IS_OFFLINE_WARE") {
                            msg = "您要兑换的礼品已经下线，请重新选择礼品兑换！";
                			setDialogMessage(msg_btn, msg);
							return false;
                        }
                        
                        if(user_info.state == "BRAND_INCONSISTENT") {
                            msg = "很抱歉，该礼品暂不支持您的手机品牌，您无法兑换";
                			setDialogMessage(msg_btn, msg);
                            return false;
                        }    
                        
                        if(user_info.state == "POINT_IS_NOT_ENOUGH") {
                            msg = "您的积分不足，暂不能定制该礼品";
                			setDialogMessage(msg_btn, msg);
                            return false;
                        }  
                        
                        var cur_value = "";    
                        if (user_info.mobileBrand == "0") {
                        	cur_value = "积分:" + g_value;
                        } else if(user_info.mobileBrand == "2"){
                        	cur_value = "M值:" + m_value;
                        } else if (user_info.mobileBrand == "1") {
                        	cur_value = "积分:" + e_value;
                        }
                        
                        //优化diy定制的代码
                        $("#g_code").val(wareCode);
                        $("#g_qtymax").val(amount);
                        $("#g_tel").val(user_info.mobileNumber);
                        $("#g_int").val(user_info.userCurrentIntegral);
                        $("#g_usertype").val(user_info.mobileBrand);
                        $("#g_jf").val(cur_value);
                        $("#g_vestcode").val(user_info.provCode);
                        $("#g_return").val(location.href);
                        
                        $("#diy_form").submit();
                    } else {
                        doDiyLogin(ware_id);
                    }
                }
            });
}

function doLogin(ware_id, magIds, amount, typeCode, payType, proCode, cityCode, disCode) {
    if (magIds != null && magIds != '') {
        window.location.href = "<%=request.getContextPath()%>/login/login.jsp?target=<%=path%>/ware/"+ware_id+".html&wareIds=" + ware_id + "&magIds=" + magIds+"&selectPayType="+payType;
    } else {
        window.location.href = "<%=request.getContextPath()%>/login/login.jsp?target=<%=UserOrderAction%>directExchangeWare&wareIds=" + ware_id + "&amount=" + amount +"&typeCode=" + typeCode+"&selectPayType="+payType+"&proCode="+proCode+"&cityCode="+cityCode+"&disCode="+disCode;
    }
}

//在线选做和跳转类流程
function doDiyLogin(ware_id) {
    window.location.href = "<%=path%>/login/login.jsp?detail_id=" + ware_id;
}


</script>
<form id="direct_form" action="<%=UserOrderAction%>directExchangeWare" method="post">
    <input type="hidden" name="wareIds" id="_wareIds"/>
    <input type="hidden" name="magIds" id="_magIds"/>
    <input type="hidden" name="amount" id="_amount"/>
    <input type="hidden" name="BMobile" id="_BMobile"/>
    <input type="hidden" name="typeCode" id="_typeCode"/>
    <input type="hidden" name="selectPayType" id="_selectPayType"/>
    <input type="hidden" name="proCode" id="proCode"/>
    <input type="hidden" name="cityCode" id="cityCode"/>
    <input type="hidden" name="disCode" id="disCode"/>
</form>
<form id="diy_form" action="" method="post">
    <input type="hidden" name="g_code" id="g_code"/>
    <input type="hidden" name="g_qtymax" id="g_qtymax"/>
    <input type="hidden" name="g_tel" id="g_tel"/>
    <input type="hidden" name="g_int" id="g_int"/>
    <input type="hidden" name="g_usertype" id="g_usertype"/>
    <input type="hidden" name="g_cartcount" id="g_cartcount"/>
    <input type="hidden" name="g_jf" id="g_jf"/>
    <input type="hidden" name="g_vestcode" id="g_vestcode"/>
    <input type="hidden" name="g_return" id="g_return"/>
</form>

