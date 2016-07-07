var provinceList;
var cityList;
var districtList;
var isCanSave=true; //标记是否可以保存

function clickFun(nav,navStyle,content){
    $("#"+nav).find("li").click(function(){
        $("#"+nav).find("li").removeClass(navStyle);
        $(this).addClass(navStyle);
        var index = $(this).index();
        $("#"+content).children().hide();
        $("#"+content).children("div").eq(index).show();
    })
}
function loadSelectAddressInfo(){
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=getAddressList",
		data:$("#orderConfirmForm").serialize(),
		dataType:"json",
		success:function(msg){
			if(msg.msg=="success"){
				if(msg.data!=null){
					var htmlString ="";
					for(var i=0;i<msg.data.length;i++){
						var isDefault="";
						var fontString ='<font><input type="radio" value="'+msg.data[i].provinceCode+'_'+msg.data[i].cityCode+'_'+msg.data[i].districtCode+'_'+msg.data[i].addID+'"></font>';
						if(msg.data[i].mailFlag=='1'){
							fontString ='<font  class="active"><input type="radio" value="'+msg.data[i].provinceCode+"_"+msg.data[i].cityCode+"_"+msg.data[i].districtCode+"_"+msg.data[i].addID+'" checked></font>';
							isDefault = '&nbsp;&nbsp;<cite>默认</cite>';
						}
						htmlString +='<div class="chmyAdressMain"><div class="radio">'+fontString+'</div><div class="info"><ul><li class="name"><span>'+msg.data[i].receiverName+'</span> <i>'+msg.data[i].receiverTel+'</i>'+isDefault+'</li><li>'+msg.data[i].provinceName+msg.data[i].districtName+msg.data[i].receiverAdd+'&nbsp;'+msg.data[i].receiverPostCode+'</li></ul></div><a href="'+path+'/user/editMyAddress.jsp?'+$("#orderConfirmForm").serialize()+'&from=choosePage&addId='+msg.data[i].addID+'"><div class="edit"><img src="'+path+'/styles/default/images/edit1.png" /></div></a></div>';
						
					}
					if(msg.data.length==1){
						changeDefaultStatus(msg.data[0].addID,2);
					}
					$('#addrList').html(htmlString);
				}else{
					window.location.href=path+"/user/nomyAddresss.jsp";
				}
			}else if(msg.msg=="login"){
				window.location.href=path+"/login/login.jsp";
			}
		},
		error:function(msg){}
	});
}
function changeDefaultStatusConfirm(id,flag){
	msg_btn = '<a class="btnBuy"  onclick=changeDefaultStatus("'+id+'","'+flag+'")>确定</a><a class="btnBuy"  onclick="quxiaoQr()">取消</a>';
	msg = "确认改变默认地址吗？"
	commonDialog(msg,msg_btn);
}
function quxiaoQr(){
	DialogClose(".detailDialog");
	loadAddressInfo();
}
function changeDefaultStatus(id,flag){
	$.ajax({
		type:"post",
		url:path+"/member/address/setDefault.do",
		data:"addressId="+id,
		dataType:"json",
		async:false,
		success:function(msg){
			if(msg==true){
					msg_btn = '<a class="btnBuy"  onclick="refreshList()">确定</a>';
					msg = '设置成功！';
					commonDialog(msg,msg_btn);
					return;
				}else{
					msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
					msg = '设置失败！';
					commonDialog(msg,msg_btn);
					return;
			    }
		},
		error:function(msg){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '设置失败！';
			commonDialog(msg,msg_btn);
			return;
		}
	});
}
function refreshList(){
	DialogClose(".detailDialog");
	window.location.reload();
}
 
function loadAddressInfo(){
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=getAddressList",
		data:"",
		dataType:"json",
		async:true,
		success:function(msg){
			if(msg.msg=="success"){
				if(msg.data!=null){
					var htmlString ="";
					for(var i=0;i<msg.data.length;i++){
						var fontString ='<font><input type="checkbox" value="'+msg.data[i].addID+'" ></font><span>&nbsp;&nbsp;&nbsp;设为默认地址</span></div>';
						if(msg.data[i].mailFlag=='1'){
							fontString = '<font class="active"><input type="checkbox" value="'+msg.data[i].addID+'" checked="checked"></font><span>&nbsp;&nbsp;&nbsp;默认地址</span></div>';
						}
						htmlString  += '<div class="myAdressMain"><ul><li class="name"><span>'+msg.data[i].receiverName+'</span> <i>'+msg.data[i].receiverTel+'</i></li><li>'+msg.data[i].provinceName+msg.data[i].districtName+msg.data[i].receiverAdd+'&nbsp;'+msg.data[i].receiverPostCode+'</li></ul>'+
							    '<div class="default clearfix"><div class="fl"><div class="radio fl">'+fontString+'</div>'+
							    '<div class="fr"><a href="./editMyAddress.jsp?addId='+msg.data[i].addID+'"><span class="edit"><i><img src="../styles/default/images/edit.png" /></i>编辑</span></a>'+
							    '<a href="#" onclick="deleteAddrComfirm('+msg.data[i].addID+');"><span class="del"><i><img src="../styles/default/images/del.png" /></i>删除</span></a></div></div></div>';
						
					}
					if(msg.data.length==1){
						changeDefaultStatus(msg.data[0].addID,2);
					}
					$('#addrList').html(htmlString);
				}else{
					window.location.href=path+"/user/nomyAddresss.jsp";
				}
			}else if(msg.msg=="login"){
				window.location.href=path+"/login/login.jsp";
			}
		},
		error:function(msg){}
	});
}
function editAddrComfirm(id){
	Dialog('.detailDialog');
	msg_btn = '<a class="btnBuy"  onclick=editAddr("'+id+'")>确定</a><a class="btnBuy"  onclick=DialogClose(".detailDialog")>取消</a>';
	msg = '您确认要保存吗？';
	$("#showMessage").html(msg);
    $("#btnShow").html(msg_btn);
}
function deleteAddrComfirm(id){
	msg_btn = '<a class="btnBuy"  onclick=deleteAddr("'+id+'")>确定</a><a class="btnBuy"  onclick=DialogClose(".detailDialog")>取消</a>';
	msg = '您确认要删除此收获地址吗？';
    commonDialog(msg,msg_btn);
}
function deleteAddr(id){
	$.ajax({
		type:"post",
		url:path+"/member/address/delete.do",
		data:"addressId="+id,
		dataType:"json",
		success:function(msg){
			if(msg==true){
				msg_btn = '<a class="btnBuy"  onclick=refreshList(".detailDialog")>确定</a>';
				msg = '删除成功！';
			}else{
				msg = '删除失败！';
				msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			}
			commonDialog(msg,msg_btn);
			return;
		},
		error:function(msg){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '删除失败！';
	 		commonDialog(msg,msg_btn);
		}
	});
}
function editAddr(id){
	DialogClose(".detailDialog");
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=updateAddress",
		data:"addrId="+id,
		dataType:"json",
		success:function(msg){
			if(msg!=null){
				
			}else{
				
			}
		},
		error:function(msg){}
	});
}
function initEditMyAddress(){
	if(addId!="null"){//更新
		$.ajax({
			type:"post",
			url:path+"/portal/user/web/UserAccountAction?action=getAddrInfoById",
			data:"addrId="+addId,
			dataType:"json",
			async:false,
			success:function(msg){
				if(msg!=null){
					$("input[name='receiverName']").val(msg.data.receiverName);
					$("input[name='receiverTel']").val(msg.data.receiverTel);
					$("textarea[name='receiverAdd']").val(msg.data.receiverAdd);
					$("input[name='receiverPostCode']").val(msg.data.receiverPostCode);
					
					$("#pShow").text(msg.data.provinceName);
					$("#selProVal").val(msg.data.provinceCode);
					
					$("#citytip").text(msg.data.cityName);
					$("#selCityVal").val(msg.data.cityCode);
					
					$("#countrytip").text(msg.data.districtName);
					$("#selCountryVal").val(msg.data.districtCode);
					if("1"==msg.data.mailFlag){
						$("#isDefault").attr("checked","checked");
					}else{
						$("#isDefault").removeAttr("checked");
					}
					$("#proviceArea option[value="+msg.data.provinceCode+"]").attr("selected","selected");
				}
			},
			error:function(msg){

			}
		});
		
	}
	$(".new_nav span").find("a").attr("href","#");
	$(".new_nav span").find("a").bind("click",function(){
		if(from=='null'){
			window.location.href=path+'/user/myAddress.jsp';
		}else{
			$("#orderConfirmForm").attr("action",path+"/portal/user/web/UserAddressAction?action=queryAddrInfos");
			$("#orderConfirmForm").submit();
		}
	});
}
function closeDiv(thisObjID,isOK) {
	$("#BgDiv").css("display", "none");
    $("#" + thisObjID).css("display", "none");
    $("#head").css("display", "none");
    $(".jf-prop").css("display", "none");
}
function chooseProvCity(index){
	$("#head").css("display", "");
	$("#BgDiv").css({ display: "block", height: $(document).height() });
    var yscroll = document.documentElement.scrollTop;
    $(".jf-prop").css("display", "block");
    document.documentElement.scrollTop = 0;
	//$(".jf-prop").css({"display":""});i
}
function saveAddress(){
	var data ={"receiverName":$("input[name='receiverName']").val(),"receiverTel":$("input[name='receiverTel']").val(),
			"receiverAdd":$("textarea[name='receiverAdd']").val(),"receiverPostCode":$("input[name='receiverPostCode']").val(),
			"sendProvinceCode":$("input[name='sendProvinceCode']").val(),"sendCityCode":$("input[name='sendCityCode']").val(),
			"countryCode":$("input[name='countryCode']").val(),"addrId":addId,"clientOrMobile":"client",
			"isDefault":$("#isDefault").attr("checked")}
 
	if($("input[name='linkman']").val()=='收货人姓名' || $("input[name='linkman']").val()==''){
		msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
		msg = '请输入收货人姓名！';
		commonDialog(msg,msg_btn);
		return;
	}
	if($("input[name='mobileNo']").val()=='联系人手机号' || $("input[name='mobileNo']").val()==''){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '请输入联系人手机号！';
			commonDialog(msg,msg_btn);
			return;
	}
	if($("input[name='addressDetail']").val()=='详细地址' || $("input[name='addressDetail']").val()==''){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '请输入详细地址！';
			commonDialog(msg,msg_btn);
			return;
		}
	if($("input[name='postCode']").val()=='邮政编码'||$("input[name='postCode']").val()==''){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '请输入邮政编码！';
			commonDialog(msg,msg_btn);
			return;
	}
	if($("#proviceArea").val()==''){
		msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
		msg = '请选择省市区！';
		commonDialog(msg,msg_btn);
		return;
	}
	if(!isCanSave){
		msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
		msg = '您的输入不符合要求，请检查！';
		commonDialog(msg,msg_btn);
		return;
	}
	$.ajax({
		type:"post",
		url:path+"/member/address/add.do",
		data:$("#addressForm").serializeArray(),
		dataType:"json",
		success:function(msg){
			 
			if(msg	==true){
				msg_btn = '<a class="btnBuy"  onclick=redirectUrl()>确定</a>';
				msg = '保存成功！';
				commonDialog(msg,msg_btn);
			}else{
				msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
				msg = '保存失败！';
				commonDialog(msg,msg_btn);
			}
		},
		error:function(msg){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '保存失败！';
			commonDialog(msg,msg_btn);
		}
	});
}
function redirectUrl(){
	DialogClose(".detailDialog");
		if(addrCount>0 || addrCount=='null'){
			$("#orderConfirmForm").submit();
		} 
	 
		//window.location.href=path+"/user/myAddress.jsp";
}
function loadProvCity(){
	$.ajax({
		type:"post",
		url:path+"/portal/user/web/UserAccountAction?action=getProvince",
		data:"",
		dataType:"json",
		success:function(msg){
			if(msg!=null){
				if(msg.type=='success'){
					var data = msg.data;
					provinceList=data.provinceList;
					cityList = data.cityList;
					districtList = data.districtList;
					var provinceString='<option value="">全部</option>';
					for(var i=0;i<provinceList.length;i++){
						provinceString += '<option value="'+provinceList[i].code+'">'+provinceList[i].name+'</option>';
					}
					$('#proviceArea').append(provinceString);
				}else if(msg.type=='login'){
					window.location.href=path+"/login/login.jsp";
				}else{
					
				}
			}
		},
		error:function(msg){

		}
	});
}
function updateProvince(obj){
	var provinceCode = $(obj).val(); 
	if(provinceCode==""){
		$("#cityArea").empty();
		$("#countryArea").empty();
	}else{
		updateCity(provinceCode);
	}
}
function updateCity(isInit){
	var selProvinceCode = $("#proviceArea option:selected").val(); 
	var selProvinceName = $("#proviceArea option:selected").text();
	$("#pShow").text(selProvinceName);
	$("#selProVal").val(selProvinceCode);
	var cityInfo = cityList[selProvinceCode];
	if(cityInfo!=null){
		var option = '';
		for(var i=0;i<cityInfo.length;i++){
			var cityCode = cityInfo[i]['code'];
			var cityName = cityInfo[i]['name'];
			updateDistrict(cityCode);
			option += '<option value="'+cityCode+'">'+cityName+'</option>';
		} 
		$('#cityArea').html(option);
	}
	$("#citytip").text($("#cityArea option:selected").text());
}
//加载县区列表1.2
function updateDistrict(cityCode){
	var selcityCode = cityCode;
	$("#selCityVal").val(selcityCode);
	var districtInfo = districtList[selcityCode];
	if(districtInfo!=null){
		var option = "";
		for(var i=0;i<districtInfo.length;i++){
			var countryCode = districtInfo[i]['code'];
			var countryName = districtInfo[i]['name'];
			if(i==0){
				$("#countrytip").text(countryName);
				$("#selCountryVal").val(countryCode);
			}
			option += '<option value="'+countryCode+'">'+countryName+'</option>';
		}
		$("#countryArea").html(option);
	}
	//$("#citytip").text($("#cityArea option:selected").text());
	
}
function updateResult(obj){
	$("#selCountryVal").val(obj);
	$("#countrytip").text($("#countryArea option:selected").text());
}
function receiverPostCodeBlur(obj){
	var value = $(obj).val();
	if(value!=''){
		var reg = /d{11}/;
		if(reg.test(value) || value.length!=6){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '邮政编码必须是6个数字!';
			commonDialog(msg,msg_btn);
			$(obj).val('');
			isCanSave=false;
		}else{
			isCanSave=true;
		}
	}
}
function receiverAddrBlur(obj){
	var value = $(obj).val();
	if(value!=''){
		if(value.length>50){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '详细地址不能超过50个字!';
			commonDialog(msg,msg_btn);
			$(obj).val('');
			isCanSave=false;
		}else{
			isCanSave=true;
		}
	}
	
}
function receiverNameBlur(obj){
	var value = $(obj).val();
	if(value!=''){
		if(value.length>10){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '收货人姓名不能超过10个字!';
			commonDialog(msg,msg_btn);
			$(obj).val('');
			isCanSave=false;
		}else{
			isCanSave=true;
		}
	}
}
function receiverTelBlur(obj){
	var value = $(obj).val();
	if(value!=''){
		var reg = /^\d{11}$/;
		if(!reg.test(value)){
			msg_btn = '<a class="btnBuy"  onclick=DialogClose(".detailDialog")>确定</a>';
			msg = '联系人手机号必须是11位数字!';
			commonDialog(msg,msg_btn);
			$(obj).val('');
			isCanSave=false;
		}else{
			isCanSave=true;
		}
	}
}
function commonDialog(msg,msg_btn){
	Dialog('.detailDialog');
	$("#showMessage").html(msg);
    $("#btnShow").html(msg_btn);
}
