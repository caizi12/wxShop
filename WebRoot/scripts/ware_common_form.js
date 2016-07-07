
var proviceArea = $("#proviceArea");
var cityInfo_select = $("#cityArea");
var districtInfo_select = $("#countryArea");
var resultPayType="01";
var maxCurIntegeral = 0;
var aPayCash=0;
var aPayIntegral=0;
//标识是否是第一次初始化信息，true 是  false 否
var isIintInfo = true;


window.onresize = function(){
    resetPage();
}

var mySwiper;
window.onload = function(){
    resetPage();
    mySwiper = new Swiper('.swiper-container',{
        pagination: '.pagination',
        loop:true,
        grabCursor: true,
        paginationClickable: true,
        calculateHeight:true
    });

    $(".swiper-wrapper div").each(function(){
		$(this).css("display","block");
	});
    
}

function resetPage() {
	var deviceWidth = document.documentElement.clientWidth,
        scale = deviceWidth/320;
    $("#solid_data #richDesc").find("*").removeAttr("width");
    $("#solid_data #richDesc").find("*").removeAttr("height");
}



$(document).ready(function(){
	initClick();
 
	//页面初始化完后就不是初始了
	isIintInfo = false;
	//初始化当前礼品车数量展示
});

 


function changeType(obj){
	if('02'==obj){
		$('#allIntgelArea a').removeClass('click');
		$('#payIntgelArea a').addClass('click');
		resultPayType ="02";
	}else{
		$('#allIntgelArea a').addClass('click');
		$('#payIntgelArea a').removeClass('click');
		resultPayType ="01";
	}
}

function goChangeFrom(addType){
	if("1" == addType){
		$("#headName").html("立即兑换");
		$("#changeWare").attr('href',"javascript:thisDirectExchange();");
	}else if("2" == addType){
		$("#headName").html("加入购物车");
		$("#changeWare").attr('href',"javascript:thisAddShopCart();");
	}else if("3" == addType){
		$("#headName").html("选择样式");
		$("#changeWare").attr('href',"javascript:backChangFrom();");
	}

	$('.addExchange').show();
	$('.fathDetail').hide();

	$("#menuHead").hide();
	$(".commonHead .new_nav span a").attr("href","javascript:backChangFrom();");
}

function backChangFrom(){
	$("#headName").html("商品详情");
	$('.addExchange').hide();
	$('.fathDetail').show();
	
	$("#menuHead").show();
	$(".commonHead .new_nav span a").attr("href","javascript:window.history.go(-1);");
	//礼品重新选中时都需要再次判断礼品是否被收藏
	showCollect();
}

function collect(){
	var cWareId = $("#ware_id").val();
	if(cWareId){
		if($("#collectHeart").hasClass("click")){
			//已收藏的礼品再次点击则进行取消收藏操作
			deleteFavor(path,cWareId);
		}else{
			//未收藏的礼品再次点击则进行收藏操作
			collectWare(path, cWareId, wareBrand);
		}
	}else{
		msg = "礼品属性未选择完整，无法收藏，请重新选择。";
		setDialogMessage('', msg);
		return;
	}
}

function showCollect(){
	var cWareId = $("#ware_id").val();
	if(cWareId){
		$.ajax({
		    type:"POST",
	        dataType:"json",
	        url:path+"/portal/user/web/UserAccountAction?action=showCollectMark",
	        data:"wareId="+cWareId,
	        success:function(data){
	        	if($.trim(data['status']) == 'Y'){
		        	$("#collectHeart").addClass("click");
	        	}else{
	        		$("#collectHeart").removeClass("click");
		        }
	        }
		});
	}

}

 

function doLoginBeforeDonation(ware_id){
	window.location.href = path+"/login/login.jsp?target="+path+"/ware/"+ware_id+".html";
}
/**
* 当点击礼品属性值时，触发初始化，使得非jf-out-of-stock的<li>加上getDescValue()方法
*/
function initClick(){
	$("#detail a").click(function(){
		if(!$(this).hasClass("gray"))
			getDescValue(this);
	});
}

/**
* 2013-09-28 add by yeqh
* 属性区域切换，校验各属性显示区域，如没有“s码，红色”这样的商品，那么点红色时，s码就应该置灰
* 原理：当用户点击任意一个属性值时，获取这个属性值，通过该值找到包含该属性值礼品，并获取礼品id（即获得礼品属性信息）进而用于标记礼品属性是否置灰不可点
*       当属性全部选中，那么重新获取对应的分值，获取礼品ID用于下单
*/
//礼品原分值
var wareIntegralValue = '';
function getDescValue(selectValue){
   //切换属性区域，获取当前鼠标所点击区域的对象（标签）
   var selectedObj = $(selectValue);
   selectedObj.siblings().removeClass("click"); //去除兄弟节点中的click
   selectedObj.toggleClass("click"); //为当前点击对象的标签添加click

   var selectedName=[];//保存属性区域中被选中的属性名称
   var selectedValues=[];//保存属性区域中被选中的属性值

   //遍历属性区域，获取被选中的属性名称和属性值及   初始化属性区域中的class属性
   $("#detail a").each(function(){
          $(this).removeClass("gray");
          $(this).removeClass("flag");
		   if($(this).hasClass("click")){
              var descValue = $(this).attr("title");
              if(descValue){
                   selectedValues.push(descValue);
                   var descName = $(this).attr("name");
                   selectedName.push(descName);
              }
		   }
   });

   var wareDescList = eval(allWareDescInfosJson); //解析json形式的礼品信息

   var index = 0;
	//选出满足选中属性值的子礼品
   $("#detail a").each(function(){
		 var descName = $(this).attr("name");
		 for(var i=0; i<wareDescList.length; ++i){
			 var seq=0;
			 var num=0;
			 for(var k=0; k<selectedName.length; ++k){
				 if(selectedName[k] != descName){
					 for(var j=0; j<wareDescList[i].descInfo.length; ++j){
						 if(($.trim(wareDescList[i].descInfo[j].name) == $.trim(selectedName[k])) 
			             		   && ($.trim(wareDescList[i].descInfo[j].values) == $.trim(selectedValues[k]))){
							 for(var z=0; z<wareDescList[i].descInfo.length; ++z){
								 if(($.trim(descName) == $.trim(wareDescList[i].descInfo[z].name))
										 && ($.trim($(this).attr("title"))==$.trim(wareDescList[i].descInfo[z].values))){
									 seq++;
									 break;
								 }
							 }
						 }
					 }
				 }
				 if(selectedName.length == descCount){
					 for(var j=0; j<wareDescList[i].descInfo.length; ++j){
						 if(($.trim(wareDescList[i].descInfo[j].name) == $.trim(selectedName[k])) 
			             		   && ($.trim(wareDescList[i].descInfo[j].values) == $.trim(selectedValues[k]))){
							 if((++num)==descCount){
								 index=i;
							 }
							 break;
						 }
					 }
				 }
				 
			 }

			 if(selectedName.length==1){
				 if(descName != selectedName[0]){
					 if(seq<selectedName.length){
						 if(!($(this).hasClass("flag"))){//当不满足条件时，只要是之前没被标记为不置灰的，都可以将其标记置灰，不可点
							 $(this).addClass("gray");
						 }
					 }else{
						 if($(this).hasClass("gray"))
		             		 $(this).removeClass("gray");
		             	 $(this).addClass("flag");
					 }
				 }
			 }else if(selectedName.length>=2){
				 var flag=false;
				 for(var k=0; k<selectedName.length; ++k){
					 if(selectedName[k]==descName){
						 flag=true;
						 break;
					 }
				 }
				 if(flag){
					 if(seq<selectedName.length-1){
						 if(!($(this).hasClass("flag"))){//当不满足条件时，只要是之前没被标记为不置灰的，都可以将其标记置灰，不可点
							 $(this).addClass("gray");
						 }
					 }else{
						 if($(this).hasClass("gray"))
		             		 $(this).removeClass("gray");
		             	 $(this).addClass("flag");
					 }
				 }else{
					 if(seq<selectedName.length){
						 if(!($(this).hasClass("flag"))){//当不满足条件时，只要是之前没被标记为不置灰的，都可以将其标记置灰，不可点
							 $(this).addClass("gray");
						 }
					 }else{
						 if($(this).hasClass("gray"))
		             		 $(this).removeClass("gray");
		             	 $(this).addClass("flag");
					 }
				 }
			 }
		
		 }
   });
   
   //获取礼品数量
   var shopInventory = parseInt($("#shopInventory").val());
	//初始化基础数据为空
	wareName = '';
	maxCurIntegeral = 0;

	//alert("descCount=="+descCount+" selectedName.length=="+selectedName.length);
	//如果属性全部选中，那么重新获取对应的分值（由于将属性选择完全之后能唯一确定一个子礼品，因此wareIdList的数据只有一条）
   if(selectedName.length == descCount){
		wareId = wareDescList[index].wareId;
		wareName = wareDescList[index].wareName;
		wareCode = wareDescList[index].wareCode;
		wareIntegralValue = wareDescList[index].wareIntegralValue; //礼品原分值
		maxCurIntegeral = wareDescList[index].wareIntegralValue;
		$("#ware_id").val(wareId); //能不能直接兑换就看#ware_id是否为空，若属性被选全则#ware_id有值，否则为空
		$(".productId").text("商品编号："+wareCode);
		$("#ware_name").val(wareName);
		$("#allIntgel del").text("");
		$("#allIntgel strong").text("");

    	$.ajax({
    	    type:"POST",
    	    dataType:"json",
    	    async:false,
    	    url: path+"/portal/ware/web/WareDetailAction?action=getUserStartIntegral",
    	    data:{wareId:wareId,pWare:"2"},
	        success:function(data){
    	        // 当登录或初始化时需要重新赋值
        		var aUserLevel = data['aUserLevel'];
        		var aOriIntegral = data['aOriIntegral'];
        		var aCurIntegral = data['aCurIntegral'];
        		
        		var aOriPayCash = data['aOriPayCash'];
        		var aOriPayIntegral = data['aOriPayIntegral'];
        		var aCurPayCash = data['aCurPayCash'];
        		var aCurPayIntegral = data['aCurPayIntegral'];

        		//全局变量，重新赋值
        		wareIntegralValue = aOriIntegral; 
        		maxCurIntegeral = aCurIntegral;
        		aPayCash = aCurPayCash;
        		aPayIntegral = aCurPayIntegral;
				
        		//全积分设置
        		if($.trim(aCurIntegral) != 0 && "undefined" != $.trim(aCurIntegral)){ 
        			//积分有折扣值
        			if(aOriIntegral != aCurIntegral){
        				$("#allIntgel").html(aCurIntegral+"&nbsp;&nbsp;<del>"+aOriIntegral+"</del></strong>");
        				$("#allIntgela").html(aCurIntegral+"&nbsp;&nbsp;<del>"+aOriIntegral+"</del></strong>");
        			}else{
        				$("#allIntgel").html(aOriIntegral);
        				$("#allIntgela").html(aOriIntegral);
        			}
        		}
        		//现金+
	        	if(aOriPayIntegral && 0!=aOriPayIntegral){
	        		var paySrt ="";
	        		paySrt+="<span style='font-family:Arial;'>&yen;</span><span id='payCash'>"+aCurPayCash+"</span> + <span id='payInt'>"+aCurPayIntegral+"</span>&nbsp;&nbsp;";
	        		if((aOriPayIntegral != aCurPayIntegral) || (aOriPayCash != aCurPayCash)){
	        			isHui = true;
	        			paySrt+="<del id='delPaycash'><span style='font-family:Arial;'>&yen;</span>"+aOriPayCash+"+ "+ aOriPayIntegral+"</del>";
		        	}
        			$("#payIntgel").html(paySrt);
        			$("#payIntgela").html(paySrt);
        			
		        }
        		
        		
	        	if($.trim(data['status']) == 'NN'){
	        		//礼品不支持用户品牌，立即兑换按钮隐藏
	        		$("#exchangeDiv").hide();
	        		$("#shopcarDiv").hide();
	        	}
	        	if($.trim(data['status']) == 'Y' || $.trim(data['status']) == 'NN'){
    				//不管用户是什么品牌,登录之后隐藏星级优惠框，
    				$("#tdVIPShow").hide();
    			}
	        }
		});
		//---不是第一次初始化页面时需要重新给子礼品图片赋值  
		if(!isIintInfo){
			changeImage(isIintInfo);
		}
		//显示短信兑换码
		getSmsCodeByWareCode(wareCode);
		if(wareName.indexOf("立即生效")!= -1){
			$("#donateMsg").show();
			$("#donateMsg").html("成功兑换该产品后，立即生效。");
		}else if(wareName.indexOf("次月生效")!= -1){
			$("#donateMsg").show();
			$("#donateMsg").html("成功兑换该产品后，于次月的首日生效；如果您为动态账期客户，则于下一个账期的首日生效。");
		}else{
			$("#donateMsg").hide();
			$("#donateMsg").html("");
		}		
		
   } else {
   	//属性没被选全时将不展示礼品积分值
		$("#ware_id").val("");
		$("#ware_name").val("");
		$("#allIntgel del").text("");
		$("#allIntgel strong").text("");
		$("#donateMsg").hide();
		$("#donateMsg").html("");
   }
    //设置默认兑换数量
	$("#shopInventory").val(1);

}
function changeImage(isIintInfo){
	isIintInfo = false;
	$.ajax({
	    type:"POST",
	    dataType:"json",
	    async:false,
	    url: path+"/portal/ware/web/WareDetailAction?action=getChildWareImages",
	    data:{c_ware_id:wareId,p_ware_id:p_ware_id},
	    success:function(data){
			if(data!='[]'){	
			        mySwiper.removeAllSlides();			
					var imgConHtml="";
					var sWareImgSrc="";	
					var newSlide = "";
					$.each(data,function(i){	
						imgConHtml="";									
						sWareImgSrc =path+"/pic/ware/"+data[i].fileName.replace(".","_480.");
						imgConHtml+="<div class='swiper-slide'>";
						imgConHtml+="<img id='big_img'  data='0' src='"+sWareImgSrc+"'/>";
						imgConHtml+="</div>";	
						newSlide = mySwiper.createSlide(imgConHtml);
						mySwiper.appendSlide(newSlide);				
					});								         					           		                										
			}
	    }
	});			
}
/**
 * 是否初始化查询
 * 0：表示非初始化； 1：表示初始化
 */
function updateCity(isInit){

	if(isInit==1){
		if("00"==wareProvinceCode || ""==wareProvinceCode){
			selProvinceCode = userProvinceCode;
			selProvinceName = userProvinceName;
		}
	}else{
		selProvinceCode = $("#proviceArea option:selected").val(); 
		selProvinceName = $("#proviceArea option:selected").text();
	}
	$("#pShow").text(selProvinceName);
	
	$("#selProVal").val(selProvinceCode);
	
	var cityInfo = jsonCityInfo[selProvinceCode];
	if(cityInfo!=null){
		var option = '';
		for(var i=0;i<cityInfo.length;i++){
			var cityCode = cityInfo[i]['code'];
			var cityName = cityInfo[i]['name'];
			if(i==0){
				updateDistrict(cityCode);
			}
			option += '<option value="'+cityCode+'">'+cityName+'</option>';
		} 
		cityInfo_select.html(option);
	}
	//计算是否有货
	initStorageInfo(selProvinceName);
	$("#citytip").text($("#cityArea option:selected").text());
}

//加载县区列表1.2
function updateDistrict(cityCode){
	var selcityCode = cityCode;
	$("#selCityVal").val(selcityCode);
	
	var districtInfo = jsonDistrictInfo[selcityCode];
	if(districtInfo!=null){
		var option = "";
		for(var i=0;i<districtInfo.length;i++){
			var countryCode = districtInfo[i]['code'];
			var countryName = districtInfo[i]['name'];
			if(i==0){
				updateResult(countryCode);
				$("#countrytip").text(countryName);
			}
			option += '<option value="'+countryCode+'">'+countryName+'</option>';
		}
		districtInfo_select.html(option);
	}	
	$("#citytip").text($("#cityArea option:selected").text());
}




var innerAllow = '';
//是否展示到货提醒
var showRemindFlag;

//初始化归属省是否有货信息
function initStorageInfo(selectProName){
	if(wareStorageType != wareProvinceHouse){
		$.post(detailAction+"action=getLessStorage",
			"ware_id="+wareId,
			function(data){
				var limitProvince = data[0];
				var lessProvince = data[1];
				var exchangeProvince = data[2];
				var flag = false;
				innerAllow = '';
				if(limitProvince != '00' && limitProvince != null && limitProvince.length > 0){
					for(var i=0;i<limitProvince.length;i++){
						if(limitProvince[i]==selectProName) {
							innerAllow = '暂不提供兑换';
							flag = true;
							showRemindFlag=false;
							break;
						};
					}
				}
				if(!flag){//如果暂不提供兑换，就不判断缺货，还是有货
					if(lessProvince.length > 0){
						for(var j=0;j<lessProvince.length;j++){
							if(lessProvince[j]==selectProName) {
								innerAllow = '缺货';
								showRemindFlag=true;
								break;
							};
						}
					} 
	
					//如果为省网礼品，本省有货则不显示到货提醒
					if(wareProvinceCode != globalWare){
					   var provinceName=lessProvince.toString(); 
					   if(provinceName.indexOf(wareProvinceName)>-1)	{
						   showRemindFlag=true;
					    }else{
					       showRemindFlag=false;
					   }
					 }
					
					if(exchangeProvince.length > 0){
						for(var j=0;j<exchangeProvince.length;j++){
							if(exchangeProvince[j]==selectProName) {
								innerAllow = '有货';
								showRemindFlag=false;
								break;
							};
						}
					}
				}
				if(flag || showRemindFlag){
					$("#exchangeId").attr('href',"javascript:void(0);");
					$("#exchangeDiv").addClass("gray");

					$("#shopcarId").attr('href',"javascript:void(0);");
					$("#shopcarDiv").addClass("gray");
				}else{
					$("#exchangeId").attr('href',"javascript:goChangeFrom('1');");
					$("#exchangeDiv").removeClass("gray");

					$("#shopcarId").attr('href',"javascript:goChangeFrom('2');");
					$("#shopcarDiv").removeClass("gray");
				}
				//alert("wareId="+wareId+"  初始化innerAllow"+innerAllow);
				if(LimitFor == true){			
					innerAllow = '暂不提供兑换';
					$("#exchangeId").attr('href',"javascript:void(0);");
					$("#exchangeDiv").addClass("gray");
					$("#shopcarId").attr('href',"javascript:void(0);");
					$("#shopcarDiv").addClass("gray");
				}
				$("#hasGoods").html(innerAllow);
			},
			"json"
		);
	}else{
		$("#sendAddr").hide();
	}
}


/**
 * 扣减礼品数量
 * 用户兑换礼品数量范围（1~999）
 */
function deductAmount() {
	$("#errorMsg").text("");
	if($("#productNum").val()>1) {
		$("#productNum").val(parseInt($("#productNum").val())-1);
	}else{
		  $("#productNum").val("1");
		  return;
	}
}

/**
* 增加礼品数量
* 用户兑换礼品数量范围（1~999）
*/
function addAmount(){
	$("#errorMsg").text("");
	//取得数量 
	if($("#productNum").val() == null || $("#productNum").val() == '' || $("#productNum").val()==0){
		$("#productNum").val("1");
		return;
	}
	if($("#productNum").val()< 999) {
		$("#productNum").val(parseInt($("#productNum").val())+1);
	}else{
		return;
	}
}
/**
* 校验礼品更新兑换数量是否满足条件，在可兑范围内则调用updateIntegral()
* 用户兑换礼品数量范围（1~999）
*/
function updateMount(){
	$("#errorMsg").text("");
	tmpMount = $('#productNum').val();
	if(!g_IsInt(tmpMount)){
		$('#productNum').val("1");
		return;
	}
	if(tmpMount<1 || tmpMount>999){
		$('#productNum').val("1");
		return;
	}else{
		mount = tmpMount;
	}
	$('#productNum').val(mount);
}

//选择县区时重新赋值计算运费积分
function updateResult(selCountryCode){
	$("#selCountryVal").val(selCountryCode);
	var proCode = $("#selProVal").val();
	var cityCode = $("#selCityVal").val();
	var disCode = $("#selCountryVal").val();

	updateFreight(proCode,cityCode,disCode);
	$("#countrytip").text($("#countryArea option:selected").text());
}

//计算参考运费积分（于星级计划需求去掉y计算运费积分部分）
function updateFreight(proCode,cityCode,disCode){
	//是否有货赋值
	$("#hasGoods").html(innerAllow);
}




/**
 * 直接兑换
 * 思路：由于getDescValue()方法中会校验用户所选礼品属性，当属性选择完全时可以唯一的确定一个子礼品信息（包括id，名称，积分值），并将其隐藏放在页面中
 *       所以当$("#ware_id").val()的值为空时，说明属性未选择完全。给出提示，补充完整之后允许下单
 */
function thisDirectExchange(){
	var ware_id =$.trim($("#ware_id").val());
	if(ware_id=='' || ware_id==null){
		msg = "礼品属性未选择完整，无法直接兑换！";
		setDialogMessage('', msg);
		return;
	}
	var ware_name = $.trim($("#ware_name").val());
	var amount = $("#shopInventory").val();
	//alert(resultPayType);
	
	var proCode=$("#selProVal").val();
    var cityCode=$("#selCityVal").val();
    var disCode=$("#selCountryVal").val();
	getWareDesc(ware_id, ware_name,'',amount, typeCode, resultPayType,proCode,cityCode,disCode);
	
}

function getWareDesc(ware_id, ware_name, mags, ware_amount, typeCode,payType,proCode,cityCode,disCode) {
	 doDirectExchange(ware_id, mags, ware_amount, typeCode ,payType,proCode,cityCode,disCode);
}
 
 
/**
 * 通过子礼品code获取短信兑换码
 * @param wareCode
 * @return
 */ 
function getSmsCodeByWareCode(wareCode){
	//获取当前子礼品对应礼品ID
	$.ajax({
		type:"POST",
	dataType:"json",
	url:path+"/portal/order/web/UserOrderAction?action=getSmsCodeByWareCode",
	data:"ware_code="+wareCode,
	success:function(data){
		 	var smsCodeStatus = data["smsCodeStatus"];	
		 	var result = data["result"];
//		 	smsCodeStatus = 'Y';
//		 	result = "<strong>短信兑换：编辑短信内容 </strong>发送礼品号 <strong>DH"+wareCode+"</strong> 到 10658999，可短信兑换此礼品(发送及接收短信免费)";
		 	if(smsCodeStatus == 'Y') {
		 		$("#smsCode").show();
				$("#smsCode").html(result);
		 	}else {
		 		$("#smsCode").hide();
		 		$("#smsCode").html(result);
		 	}
		 	isExchangePermission = data["isExchangePermission"];
		}
	});
	
}

function thisAddShopCart() {
	var amount = $("#shopInventory").val();

	if(!isShowOrderQuantity || (g_IsNumber(amount) && amount >= 1)) {
		addShopCart();
	}else {
		msg = "请输入正确的订购数量！";
    	setDialogMessage(msg_btn, msg);
	}
}

function addShopCart(){
	var ware_id = $("#ware_id").val();
	var ware_amount = $("#shopInventory").val();
	//加入购物车中的现金+ 现金和积分都应是整数，所以现金扩大100
	var resultPayCash  =accMul(Number(aPayCash),100);
	doAddShoppingCart(ware_id,shop_ware_name,ware_img,maxCurIntegeral,maxCurIntegeral,maxCurIntegeral,resultPayType,resultPayCash,aPayIntegral,ware_amount);
}

