function initCity(proCode){
	var selProvinceCode = proCode;
	var jsonCityInfo = strCityInfo;
	var cityInfo = jsonCityInfo[selProvinceCode];

	$("#pShow").text($("#modifyProvinceCode option[value='"+selProvinceCode+"']").text());
	if(cityInfo!=null){
		var option = '<option value="">--请选择--</option>';
		for(var i=0;i<cityInfo.length;i++){
			var cityCode = cityInfo[i]['code'];
			var cityName = cityInfo[i]['name'];
			if(i==0){
				initDistrict(cityCode);
			}
			option += '<option value="'+cityCode+'">'+cityName+'</option>';
		}
		$("#modifyCityCode").html(option);
	}
	$("#citytip").text($("#modifyCityCode option:selected").text());
}

//加载县区列表1.2
function initDistrict(cityCode){
	var selcityCode = cityCode;
	var jsonDistrictInfo = strDistrictInfo;
	var districtInfo = jsonDistrictInfo[selcityCode];

	$("#citytip").text($("#modifyCityCode option[value='"+selcityCode+"']").text());
	if(districtInfo!=null){
		var option = '<option value="">--请选择--</option>';
		$("#countrytip").text('--请选择--');
		for(var i=0;i<districtInfo.length;i++){
			var countryCode = districtInfo[i]['code'];
			var countryName = districtInfo[i]['name'];
			option += '<option value="'+countryCode+'">'+countryName+'</option>';
		}
		$("#countryCode").html(option);
	}
}

//更新区县
function updateDistrict(selDistrictCode){
	$("#countrytip").text($("#countryCode option[value='"+selDistrictCode+"']").text());
}

$(function(){
	$(".submit a").click(function(){
		confirmModifyAddr();
	});

	var confirmModifyAddr = (function (){
		var selProvinceCode = $("#modifyProvinceCode").val();
		var modifyCustName = $("#receiverName").val();
		var modifyReceiverAddr = $("#receiverAdd").val();
		var modifyReceiverPostCode = $("#receiverPostCode").val();
		var modifyProvinceCode = $("#modifyProvinceCode").val();
		var provinceName = $("#modifyProvinceCode option:selected").text(); 
		var modifyCityCode = $("#modifyCityCode").val();
		var cityName = $("#modifyCityCode option:selected").text(); 
		var modifyDistrictCode = $("#countryCode").val();
		var districtName = $("#countryCode option:selected").text(); 
		var tel = $("#receiverTel").val();

		var userSelectAddrId = userSelectAddrId;
		
		var CheckData = /<|>|'|;|&|#|"|'|\*|\^|\{|\}|\[|\]|%|[\$]|@|!|！|\?|￥|；|…|”|“|？|、/;
		
		$("#Ename").hide();
		$("#Eemail").hide();
		$("#Epostcode").hide();
		$('#ECity').hide();
		$("#Etel").hide();
		$('#errorMsg').hide();

		
		if($.trim($("#receiverName").val()) == ""){
			$("#Ename").show();
			$("#Ename span").text("收货人姓名不能为空！");
			return false;
		}
		
		if($("#receiverName").val().length>16){
			$("#Ename").show();
			$("#Ename span").text("收货人姓名过长！");
			return false;
		}
		if(CheckData.test($("#receiverName").val())){
			$("#Ename").show();
			$("#Ename span").text("您输入了非法字符！");
			return false;
		}

		
		if($.trim(tel) == ""){
			$("#Etel").show();
			$("#Etel  span").text("电话号码不能空！");
			return false;
		}else{		
			var tels = tel.split(";");
			for(var i = 0; i < tels.length; i++){
				if(!g_IsMobileNumber(tels[i]) && !g_IsTeleNumber(tels[i])){
					$("#Etel").show();
					$("#Etel span").text("电话号码格式不正确！");
					return false;	
				}
			}
		} 

		if($.trim($("#receiverPostCode").val())== ""){
			$("#Epostcode").show();
			$("#Epostcode span").text("邮政编码不能为空！");
			return false;
		}
		
		if(!g_IsPostalCode($("#receiverPostCode").val())){
			$("#Epostcode").show();
			$("#Epostcode span").text("邮政编码格式不正确!");
			return false;
		}
		
		if(!modifyProvinceCode||!modifyCityCode||!modifyDistrictCode){
			$("#ECity").show();
			$("#ECity span").text("收货人省市区县信息不能为空！");
			return false;
		}

		if($.trim($("#receiverAdd").val()) == ""){
			$("#Eaddress span").text("收货地址不能为空！");
			return false;
		}
		if($("#receiverAdd").val().length>50){
			$("#Eaddress span").text("收货地址过长！");
			return false;
		}
		if(CheckData.test($("#receiverAdd").val())){
			$("#Eaddress span").text("您输入了非法字符！");
			return false;
		}
		
		
	  var _postUrl = request.getContextPath()+"/portal/nb.lf.portal.user.web.UserAddressAction?action=modifyUserAddr";
	  $.post(
			 _postUrl,
			{sendProvinceCode:modifyProvinceCode,sendCityCode:modifyCityCode,
				countryCode:modifyDistrictCode,receiverPostCode:modifyReceiverPostCode,
				receiverTel:tel,receiverName:modifyCustName,
				receiverAdd:modifyReceiverAddr,
				addrId:userSelectAddrId
			},
			function(data){
				if(data == 'FAIL'){
					$('#errorMsg').show();
					$("#errorMsg span").text("您要保存的地址信息区县不匹配，请重新修改");
				}else{
					$("#userSelectAddrId").val($.trim(data));
				    $("#queryAddrForm").submit();
				}
			}
		);
	});
});
