
var proviceArea = $("#proviceArea");
var cityInfo_select = $("#cityArea");
var districtInfo_select = $("#countryArea");
var resultPayType="01";
var msg='';
var msg_btn='';
var messageTitle='';
//是否暂不提供兑换(期刊杂志判断所用)
var isLessWare=false;


$(function(){

   	var mySwiper = new Swiper('.swiper-container',{
        pagination: '.pagination',
        loop:true,
        grabCursor: true,
        paginationClickable: true,
        calculateHeight:true
	 });
	 
	 $(".swiper-wrapper div").each(function(){
			$(this).css("display","block");
	 });
});
window.onresize = function(){
    resetPage();
}

window.onload = function(){
    resetPage();
}
function resetPage() {
    var deviceWidth = document.documentElement.clientWidth,
            scale = deviceWidth/320;
    $("#solid_data #richDesc").find("*").removeAttr("width");
    $("#solid_data #richDesc").find("*").removeAttr("height");
}


$(document).ready(function() {
	//initStorage();
	var option = { 
		zoomWidth:400, 
		zoomHeight:400, 
		lens:true, 
		xOffset:10, 
		yOffset:-1, 
		positon:"left", 
		title:true 
	} 
	$(".jqzoom").jqzoom(option);
	initRichText();
	showVIPCard();
	if("00"==wareProvinceCode || ""==wareProvinceCode){
		$("#proviceArea").val(userProvinceCode);
		$("#pShow").text(userProvinceName);
	}else{
		$("#proviceArea").val(wareProvinceCode);
		$("#pShow").text($("#proviceArea option:selected").text());
	}
	
	updateCity(1);

	if(isMagWare == "true"){
		magWareDeal();
	}
	showCollect();
	//初始化当前礼品车数量展示
	initCartNum(tabPath);
});

function collect(){
	if($("#collectHeart").hasClass("click")){
		//已收藏的礼品再次点击则进行取消收藏操作
		deleteFavor(tabPath,ware_id);
	}else{
		//未收藏的礼品再次点击则进行收藏操作
		collectWare(tabPath, ware_id, wareBrand);
	}
}


function showCollect(){
	$.ajax({
	    type:"POST",
        dataType:"json",
        url:tabPath+"/portal/user/web/UserAccountAction?action=showCollectMark",
        data:"wareId="+ware_id,
        success:function(data){
        	if($.trim(data['status']) == 'Y'){
	        	$("#collectHeart").addClass("click");
        	}else{
        		$("#collectHeart").removeClass("click");
	        }
        }
	});
}

function goChangeFrom(addType){
	$("#wareId").val(ware_id);
    $("#warePic").val(mainPic);
    $("#wareCode").val(ware_code);
    $("#wareName").val(ware_name);
    $("#payType").val(payType);
    
    $("#cIntegral").val(selIntegral);
    $("#cPayIntegral").val(selPayIntegral);
    $("#cPayCash").val(selPayCash);
    
    $("#proCode").val($("#selProVal").val());
    $("#cityCode").val($("#selCityVal").val());
    $("#disCode").val($("#selCountryVal").val());
    
    $("#isShowOrderQuantity").val(isShowOrderQuantity);
    $("#aMagName").val($("#magName").val());
    $("#magCount").val($("#magAmount").val());
    $("#isMagWare").val(isMagWare);
    $("#isShowNum").val(isShowNum);
    $("#wareDeliverType").val(wareDeliverType);
    $("#addType").val(addType);
    $("#wareImg").val(ware_img);
    //alert(">1>"+$("#magName").val()+">2>"+isMagWare+">3>"+$("#magCount").val());
    
	$("#change_form").submit();
}

function addShopCart(){
	var ware_amount = $("#shopInventory").val();
	doAddShoppingCart(ware_id,ware_name,ware_img,oriIntegral,oriIntegral,oriIntegral,resultPayType,oPayCash,oPayIntegral,ware_amount);
}

function updateMount(deliverType){	
	var wareNum =$("#shopInventory").val();
	if(wareNum == '' || !g_IsNumber(wareNum) || wareNum <= 0 ||(deliverType!='11'&&deliverType!='01'&&deliverType!='02'&&parseInt(wareNum) > 10)||wareNum.substring(0,1)=='0'){
		msg = "请输入正确的订购数量！非实物类礼品不能超过10件！";
		setDialogMessage(msg_btn, msg);
		$("#shopInventory").val("1");
	}
}
function addAmount(deliver_type){
	   var value='';
	   if($("#shopInventory").val()<10 ) {
		   value=parseInt($("#shopInventory").val())+1;
		   $("#shopInventory").val(value);
	   }else if((deliver_type=='11'||deliver_type=='01'||deliver_type=='02')&&($("#shopInventory").val()<999)){//全网物流配送礼品、本省物流配送礼品、本省营业厅取货礼品 可以超过10件
		   value=parseInt($("#shopInventory").val())+1;
	  	   $("#shopInventory").val(value);
	   }
}
function deductAmount() {
	if($("#shopInventory").val()>1) {
		$("#shopInventory").val(parseInt($("#shopInventory").val())-1);
	}
}

	
function directExchange(){
		var magName = $("#magName").val();
		var magAmount = $("#magAmount").val();
		var amount = "";
	//---用于保存期刊杂志---
	var mags = "";
    if(isMagWare==true){
       mags = magName;
       amount = magAmount;
    } else {
	   // 不是期刊
	   amount = $("#shopInventory").val();
    }
    var proCode=$("#selProVal").val();
    var cityCode=$("#selCityVal").val();
    var disCode=$("#selCountryVal").val();
    getWareDesc(ware_id,ware_name,mags,amount,'',resultPayType,proCode,cityCode,disCode);
}

//转赠直接兑换
function confirmExchange(){
	var magName = $("#magName").val();
	var magAmount = $("#magAmount").val();
	var mags = ""; //用于保存期刊杂志，初始一个值，不会用到。
	var amount = $("#shopInventory").val();
	getConfirmWareDesc(ware_id,ware_name,mags,amount,resultPayType);
}
	

function diyShopping(){
	doDiyShopping(ware_code,1,oriIntegraloriIntegral,oriIntegral,ware_id);
}

function doRemind(wareId,wareBrand){
	var SelProCode=$("#selProVal").val();
	window.open(tabPath+"/portal/ware/web/WareDetailAction?action=showArrivalRemind&wareId="+wareId + "&wareBrand=" + wareBrand + "&provinceCode=" + SelProCode);
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

function donateWareBasic(){
	$.ajax({
        type:"post",
        dataType:"json",
        url:tabPath+"/portal/ware/web/WareDetailAction?action=getWareDescValue",
        data:"wareIds="+ware_id,
        success:function(data) {
            	getAssignee();
        }
	});
}


function doLoginBeforeDonation(ware_id){
	window.location.href = tabPath+"/login/login.jsp?target="+tabPath+"/ware/"+ware_id+".html";
}


function getAssignee(){
	$.ajax({
        type:"post",
        dataType:"json",
        url:tabPath+"/portal/user/web/UserAccountAction?action=getAjaxAssigneeInfo",
        async: false,
        success:function(data) {
        	var show_message = '';
        	var msg_btn = '';
        	var assigneeUrl = accountAction+"getAssigneeInfo";
            if (data.msg == 'success') {
            	show_message += '<div >';
            	show_message += '<h2><div class="bgR"><span class="bgL" style="margin-left:0px">选择受让人</span></div></h2>';
            	show_message += '<div class="moduleBorder"> <div class="userBaseInfo">';
            	show_message += '<div style="color:red;font-weight:bold; margin-bottom: 10px;">请注意:你可以选择“已生效”状态的受让人。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
            	show_message += '如果无可选受让人存在，可进入<a href="'+ assigneeUrl +'" style="color:blue;text-decoration:underline;">【受让人管理】</a>根据受让人管理规则维护受让人信息。<br/></div>';
            	show_message += '<table border="0" cellspacing="0" cellpadding="0" class="myAssigneeList">';
            	show_message += '<tr>';
            	show_message += '<th style="text-align: center;width:80px;"><h1>序号</h1></th>';
            	show_message += '<th style="text-align: center;width:180px;"><h1>受让人手机号</h1></th>';
            	show_message += '<th style="text-align: center;width:180px;"><h1>生效日期</h1></th>';
            	show_message += '<th style="text-align: center;width:180px;"><h1>受让人状态</h1></th>';
            	show_message += '<th style="text-align: center;width:320px;"><h1>操作时间</h1></th>';
            	show_message += '</tr>';
            	if(null!=data.AssigneeInfo && ""!=data.AssigneeInfo){
                	for(var i=0; i<data.AssigneeInfo.length; ++i){
                    	if("01" == data.AssigneeInfo[i].assigneeStatus){
                    		show_message += '<tr style="padding:0px;">';
                    		show_message += '<td><input name="assignee" type="radio" value="'+ data.AssigneeInfo[i].bMobile +'"/>'+(i+1)+'</td>';
                        	show_message += '<td>'+ data.AssigneeInfo[i].bMobile +'</td>';
                        	show_message += '<td>'+ data.AssigneeInfo[i].effectiveDate +'</td>';
                        	show_message += '<td>已生效</td>';
                        	show_message += '<td>'+ data.AssigneeInfo[i].operatorTime +'</td>';
                        	show_message += '</tr>';
                    	}else{
                    		show_message += '<tr style="background-color: #DDDDDD; padding:0px;">';
                    		show_message += '<td><input name="assignee" type="radio" value="'+ data.AssigneeInfo[i].bMobile +'" disabled="true"/>'+(i+1)+'</td>';
                        	show_message += '<td>'+ data.AssigneeInfo[i].bMobile +'</td>';
                        	show_message += '<td>'+ data.AssigneeInfo[i].effectiveDate +'</td>';
                        	if("02"==data.AssigneeInfo[i].assigneeStatus){
	                        	show_message += '<td>待生效</td>';
                            }else{
                            	show_message += '<td>停用</td>';
                            }
                        	show_message += '<td>'+ data.AssigneeInfo[i].operatorTime +'</td>';
                        	show_message += '</tr>';
                    	}
                	}
            	}
            	show_message += '</table>';
            	show_message += '</div>';
            	show_message += '</div>';
            	show_message += '<div style="padding:10px">';
            	show_message += '<h3>受让人规则：</h3>';
            	show_message += '<div>';
            	show_message += '1.最多可设置8名受让人，包括已生效、待生效及停用状态的受让人。<br/>';
            	show_message += '2.受让人仅限中国移动客户，且归属省与客户归属省相同。<br/>';
            	show_message += '3.添加新的受让人后受让人立即生效；更改受让人手机号码后受让人30天后生效，修改受让人其他信息受让人立即生效；停用/启用受让人后受让人立即生效。<br/>';
            	show_message += '4.可对已生效、待生效、停用状态的受让人进行更改 /修改操作；可对已生效、待生效状态的受让人进行停用操作，可对停用状态的受让人进行启用操作。<br/>';
            	show_message += '</div>';
            	show_message += '</div>';

                if(null!=data.AssigneeInfo && ""!=data.AssigneeInfo){
                    msg_btn += '<a class="btnBuy" onclick="confirmAssignee();">确 定</a>';
                }
    	    	setDialogMessage(msg_but, show_message);
            } else if(data.msg == 'notLogin'){
            	msg_btn = '<a class="btnBuy" onclick="doLoginBeforeDonation('+ware_id+')">确定</a>';
				show_message = '转赠礼品前请先登录！';
				setDialogMessage(msg_but, show_message);
            }
        },error:function(){
			show_message = '请求超时，请稍候再试！';
			setDialogMessage(msg_but, show_message);
		}
	});

}

function confirmAssignee(){
	$("#_BMobile").val("");
	var assigneeNum = $("input:radio[name='assignee'][checked]").val();
	if(assigneeNum == undefined || assigneeNum == null){  
		show_message = '尊敬的用户您好，请选择“已生效”状态的受让人！';
		setDialogMessage(msg_but, show_message);
		return;
    }else{
		//设置受让人手机号
		$("#_BMobile").val(assigneeNum);
	}
	//alert("assigneeNum="+assigneeNum+" _BMobile="+$("#_BMobile").val());

	
	//转赠单独走直接兑换方法不直接调用直接兑换的方法
	var amount = $("#shopInventory").val();
	if(!amount){amount=1;}
	
	if(!isShowOrderQuantity || (g_IsNumber(amount) && amount >= 1)) {
		if(g_IsNumber(amount) && amount > 10){
			show_message = '您购买的礼品超过10个，请重新选择数量';
			setDialogMessage(msg_btn, show_message);
		}else{
			confirmExchange();
		}
	}else {
		show_message = '请输入正确的订购数量';
		setDialogMessage(msg_btn, show_message);
	}
}

function thisDirectExchange() {
	var amount = $("#shopInventory").val();
	if(!isShowOrderQuantity || (g_IsNumber(amount) && amount >= 1)) {
		directExchange();
	}else {
		show_message = '请输入正确的订购数量';
		setDialogMessage(msg_btn, show_message);
	}
}


//对富文本添加了超链的文字前台展示时需标出下划线和蓝色字体
function initRichText(){
	$("#detailProduct #detailInfo .infoItem a").each(function(){
	    $(this).css({"color":"#004077","text-decoration":"underline"});
	});
}


//当是VIP礼品时用户登录后需要展示对应的VIP分
function showVIPCard(){


	$.ajax({
	    type:"POST",
        dataType:"json",
        url:tabPath+"/portal/ware/web/WareDetailAction?action=getUserStartIntegral",
        data:"wareId="+ware_id,
        success:function(data){
        	if($.trim(data['status']) == 'Y'){
        		var aUserLevel = data['aUserLevel'];
        		var aOriIntegral = data['aOriIntegral'];
        		var aCurIntegral = data['aCurIntegral'];
        		
        		var aOriPayCash = data['aOriPayCash'];
        		var aOriPayIntegral = data['aOriPayIntegral'];
        		var aCurPayCash = data['aCurPayCash'];
        		var aCurPayIntegral = data['aCurPayIntegral'];
        		
        		//兑换选择页用
        		selIntegral = aCurIntegral;
        		selPayIntegral = aCurPayIntegral;
        		selPayCash = aCurPayCash;
        		
				//alert(aOriIntegral+">>"+aCurIntegral);
				//全积分
        		if(aOriIntegral && 0!=aOriIntegral){
        			if(aOriIntegral != aCurIntegral){
        				$("#allIntgel").html(aCurIntegral+"&nbsp;&nbsp;<del>"+aOriIntegral+"</del></strong>");
        			}else{
        				$("#allIntgel").html(aOriIntegral);
        			}
        		}
        		
        		//现金+
	        	if(aOriPayIntegral && 0!=aOriPayIntegral){
	        		var paySrt ="";
	        		paySrt+="<span style='font-family:Arial;'>&yen;</span><span id='payCash'>"+aCurPayCash+"</span> + <span id='payInt'>"+aCurPayIntegral+"</span>&nbsp;&nbsp;";
	        		if((aOriPayIntegral != aCurPayIntegral) || (aOriPayCash != aCurPayCash)){
	        			isHui = true;
	        			paySrt+="<del id='delPaycash'><span style='font-family:Arial;'>&yen;</span>"+aOriPayCash+"+ "+ aOriPayIntegral+"</del><span id='kGe'>&nbsp;</span>";
		        	}
        			$("#payIntgel").html(paySrt);
        			
		        }
        		
	        	//不管用户是什么品牌,登录之后隐藏VIP优惠框，
	        	$("#tdVIPShow").hide();
        	}else if($.trim(data['status']) == 'NN'){
        		//礼品不支持用户品牌，加入礼品车、立即兑换按钮隐藏
        		$("#exchangeDiv").hide();
				$("#shopcarDiv").hide();
        		
        	}else{
        		$("#tdVIPShow").show();
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
	if(wareStorageType  != wareProvinceHouse){
		$.post(detailAction+"action=getLessStorage",
			"ware_id="+ware_id,
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
					if(wareProvinceCode!= globalWare){
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
				
				isLessWare = flag;
				if(flag || showRemindFlag){
					$("#exchangeId").attr('href',"javascript:void(0);");
					$("#exchangeDiv").addClass("gray");
					$("#shopcarId").attr('href',"javascript:void(0);");
					$("#shopcarDiv").addClass("gray");
				}else{
					//对于期刊杂志类的礼品，有货，有期刊数，直接兑换按钮才可点
					if(isMagWare == true){
						if(0<MagaBookNum){
							$("#exchangeId").attr('href',"javascript:goChangeFrom('1');");
							$("#exchangeDiv").removeClass("gray");
						}
					}else{
						$("#exchangeId").attr('href',"javascript:goChangeFrom('1');");
						$("#exchangeDiv").removeClass("gray");
					}
					
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


//选择县区时重新赋值计算运费积分
function updateResult(selCountryCode){
	$("#selCountryVal").val(selCountryCode);
	var proCode = $("#selProVal").val();
	var cityCode = $("#selCityVal").val();
	var disCode = $("#selCountryVal").val();

	updateFreight(proCode,cityCode,disCode);
	$("#countrytip").text($("#countryArea option:selected").text());
}

//计算参考运费积分
function updateFreight(proCode,cityCode,disCode){

	//是否有货赋值
	$("#hasGoods").html(innerAllow);

}
	
