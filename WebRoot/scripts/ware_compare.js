 var stopId;

// 初始化页面选框
function renew(path) {
	IE6Position();//判断ie6，是的话要修改position
	//gPath = path;
	var imgPath = path || '';
	img = imgPath+'/styles/default/images/compare/dele.gif';
	var cooks = GetCookie("listhc").split("/");
	for ( var c = 1; c < cooks.length; c++) {
		var wf = cooks[c].split("_");
		var compareItem = document.getElementById(wf[0]);
		if(compareItem!=undefined){
			compareItem.style.backgroundImage = "url('"+img+"')";
		}
	}
	//cooks为1的时候表示没有对比项加入cookie
	if(cooks.length>1){
		$("#showWindow").css("display","block");
	}
	initCompareWindow(path);
	stopId=window.setInterval(function(){initCompareWindow(path);}, 2000);
}
// 初始化漂浮层
function initCompareWindow(path) {
//	alert("execute it!");
	
	var imgPath = path || '';
	imgdele = imgPath+'/styles/default/images/compare/dele.gif';
	imgadd = imgPath+'/styles/default/images/compare/add.gif';
	var compareItems = $(".addDel");
	for ( var i = 0; i < compareItems.length; i++) {
			compareItems[i].style.backgroundImage = "url('"+imgadd+"')";
	}
	
	var wareList = '', itemNum = 0;
	//将页面对比图标同步，并且同步对比窗口内的对比项
	var cooks = GetCookie("listhc").split("/");
	for ( var c = 1; c < cooks.length; c++) {
		var wf = cooks[c].split("_");
		var compareItem = document.getElementById(wf[0]);
		if(compareItem!=undefined){
			compareItem.style.backgroundImage = "url('"+imgdele+"')";
		}
		
		itemNum++;
		var resultWF=wf[1].replace("&%#","/");
		if(resultWF.length>14){
			resultWF=resultWF.substring(0,13)+"...";
		}
		wareList+= "<li>"+resultWF+"<a class=\"compareUlDel\" onclick=\"delWare("+wf[0]+",\'"+path+"\');\">删除</a></li>";
	}
	
	//alert(wareList);
	$("#compareList").html(wareList);
	$("#compareNum").html(itemNum);
	$('#countNum').html(itemNum);
	
	
	if(wareList==""){
		$("#warn").css("display","block");
		$("#compareList").css("display","none");
		$("#showWindow").animate({width: 'hide', opacity: 'hide'}, 'normal');
		$('#compareWindow').animate({width: 'hide', opacity: 'hide'}, 'normal');
		//对比窗口隐藏了之后改为10秒刷新一次
//		window.clearInterval(stopId);
//		stopId=window.setInterval(function(){initCompareWindow(path);}, 10000);
	}
	else{
		$("#warn").css("display","none");
		$("#compareList").css("display","block");
		$('#showWindow').animate({width: 'show', opacity: 'show'}, 'normal');
//		window.clearInterval(stopId);
//		stopId=window.setInterval(function(){initCompareWindow(path);}, 2000);
	}

}

// 漂浮窗口删除
function delWare(id,path) {

    imgPath = path + '/styles/default/images/compare/add.gif';
	delCookie(id);
	var checkIds = $(".addDel");
	for ( var i = 0; i < checkIds.length; i++) {
		if (checkIds[i].id == id) {
			checkIds[i].style.backgroundImage = "url('"+imgPath+"')";
		}
	}
	var cooks = GetCookie("listhc").split("/");
	if(cooks.length<2){
		hide();
	}
	initCompareWindow(path);
}
// 设置COOKIE
function SetCookie(name, value) {
	document.cookie = name + "=" + escape(value) + ";path=/";
}
// 获得COOKIE
function GetCookie(name) {
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null) {
		return unescape(arr[2]);
	} else {
		return "";
	}
}
// 删除COOKIE
function delCookie(id) {
	var cooks = GetCookie("listhc").split("/"), dstr = "";
	for ( var i = 1; i < cooks.length; i++) {
		if (cooks[i].split("_")[0] != id) {
			dstr += "/" + cooks[i];
		}
	}
	SetCookie("listhc", dstr);
}

function clears(path) {
	var imgPath = path || '';
	imgPath = imgPath + '/styles/default/images/compare/add.gif';
	
	SetCookie("listhc", "");
	initCompareWindow(path);
	var compareItems = $(".addDel");
	for ( var i = 0; i < compareItems.length; i++) {
			compareItems[i].style.backgroundImage = "url('"+imgPath+"')";
	}
	$('#compareWindow').animate({width: 'hide', opacity: 'hide'}, 'normal');
	$("#showWindow").animate({width: 'hide', opacity: 'hide'}, 'normal');
}
// 增加点击开始对比的处理
function beginCompare(path) {
	var cook = GetCookie("listhc");
	var cooks = cook.split("/");
	
	var wareIds = "";
	for ( var i = 0; i < cooks.length; i++) {
		var id = cooks[i].substr(0, cooks[i].indexOf("_"));
		if (id.length > 0)
			wareIds += id+",";
	}
	if (wareIds.length > 0) {
		wareIds = wareIds.substring(0, wareIds.length - 1);
        var url = path + "/ware/than.jsp?wareIds=" + wareIds;
        window.open(url, '_blank');
	} else {
		var msg_btn='';
		msg_btn += '<button class="popbtn" onclick="dialogClose();">确定</button>';
		$.dialog.show({
			type:$.dialog.type.MESSAGE_TYPE_ALARM,
			title:'警告：',
			msg:'请选择要对比的礼品。',
			button:msg_btn
		});
		
	}
	return false;
}

//隐藏对比窗口
function hide() {
	$('#compareWindow').animate({width: 'hide', opacity: 'hide'}, 'normal');
	$("#showWindow").animate({width: 'show', opacity: 'show'}, 'normal');
}

//使用图标实现添加删除
function addDel(id,name,isAdd,path){
	var imgPath = path || '';
	var imgdel = imgPath+'/styles/default/images/compare/dele.gif';
	var imgadd = imgPath+'/styles/default/images/compare/add.gif';
	
	var cook = GetCookie("listhc");
	var cooks = cook.split("/");
	if (1==isAdd) {
			$("#compareWindow").animate({width: 'show', opacity: 'show'}, 'normal');
			// 判断是否重复添加
			if (cook.indexOf("/" + id) > -1) {
				var msg_btn='';
				msg_btn += '<button class="popbtn" onclick="dialogClose();">确定</button>';
				$.dialog.show({
					type:$.dialog.type.MESSAGE_TYPE_ALARM,
					title:'警告：',
					msg:name + "该礼品在对比框中已存在。",
					button:msg_btn
				});
				document.getElementById(id).style.backgroundImage = "url('"+imgdel+"')";
				return;
			}
			if (cooks.length > 5) {
				var msg_btn='';
				msg_btn += '<button class="popbtn" onclick="dialogClose();">确定</button>';
				$.dialog.show({
					type:$.dialog.type.MESSAGE_TYPE_ALARM,
					title:'警告：',
					msg:"放入对比框中的礼品数不能超过5件。",
					button:msg_btn
				});
				document.getElementById(id).style.backgroundImage = "url('"+imgadd+"')";
				$("#compareWindow").animate({width: 'show', opacity: 'show'}, 'normal');
				return;
			} else {
				SetCookie("listhc", cook + "/" + id + "_"
						+ name.replace("/", "&%#"));
			}
	    } else {
	    	delCookie(id);
	    	if(cooks.length>2){
				 $('#compareWindow').animate({width: 'show', opacity: 'show'}, 'normal');	
			}
//	    	var cooks = GetCookie("listhc").split("/");
//			if(cooks.length<2){
//				hide();
//			}
	    }
	    initCompareWindow(path);
}		
 function changeImg(id,name,path) {
	// 事件追踪码
	addEventCode('JF_DB');	
	name = name.replace("_","");
	var imgPath = path || '';
	var imgdel = imgPath+'/styles/default/images/compare/dele.gif';
	var imgadd = imgPath+'/styles/default/images/compare/add.gif';
	var imgBox = document.getElementById(id);
	 if (imgBox.currentStyle) //IE
      {
          var backgroundImg = imgBox.currentStyle['backgroundImage'];
      }
      else if (window.getComputedStyle) //非IE
      {
    	  var backgroundImg = window.getComputedStyle(imgBox, null).getPropertyValue("background-image");
      }
		if (backgroundImg.indexOf("add.gif")!=-1) {
			imgBox.style.backgroundImage = "url('"+imgdel+"')";
			addDel(id,name,1,path);//add图标时，点击加入,变成删除图标
		} else {
			imgBox.style.backgroundImage = "url('"+imgadd+"')";
			addDel(id,name,0,path);//dele图标时，点击删除
		}
	
		}
 
 function showWindow(){
	 $('#compareWindow').animate({width: 'show', opacity: 'show'}, 'normal');
 }
 //IE6兼容悬浮窗的fixed属性
 function IE6ScrollEvent(){
	 var height=40;
	 var getShow = document.getElementById('showWindow');
	 var getZone = document.getElementById('compareZone');
	 getShow.style.top=(height+25+document.documentElement.scrollTop)+"px";
	 getZone.style.top=(height+document.documentElement.scrollTop)+"px";
 }
 function IE6Position(){
	 var IE6=window.ActiveXObject&&(!window.XMLHttpRequest);
	 if(IE6){
		 scroll(0,0);
		 document.getElementById('showWindow').style.top="65px";
		 document.getElementById('compareZone').style.top="40px";
		 window.onscroll=IE6ScrollEvent;
		}
 } 