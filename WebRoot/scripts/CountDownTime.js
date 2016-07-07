/**
 * 
 * 时间倒计时公共js
 * 
 * sysTime         系统时间，格式为yyyy/mm/dd HH:mm:ss
 * payEndTime      结束时间 格式为yyyy/mm/dd HH:mm:ss
 * displayTimeID   倒计时要显示到那个dom元素上，此处传dom元素的id
 * gotoUrl         时间倒计时结束后要跳转的页面，为空则不跳转
 *  展示效果为：23:30:30
 */

  var NowHour = ""; 
  var NowMinute = ""; 
  var NowMonth = ""; 
  var NowDate = ""; 
  var NowYear = ""; 
  var NowSecond = ""; 
  var endTime="";
  //设置时间
  function countDownTime(sysTime,payEndTime,displayID,gotoUr){ 
	var st=sysTime.split(" ");
	var ymd,hms;
	if(st.length>0){
		ymd=st[0].split("/");
		hms=st[1].split(":");
	}
	NowYear  = ymd[0];   
	NowMonth = ymd[1]-1; 
	NowDate  = ymd[2]; 
  	NowHour   = hms[0];
  	NowMinute = hms[1];
  	NowSecond = hms[2];
  	
  	endTime=unescape(payEndTime);
  	displayTimeID=displayID; 
  	gotoPathUrl=gotoUr;
  	showtime(); 
  } 

  function showtime() { 
  	NowSecond = (parseInt(NowSecond)+1); 
  	
  	var EndTime= new Date(endTime); ;
  	var NowTime= new Date(NowYear,NowMonth,NowDate,NowHour,NowMinute,NowSecond);
  	
  	var nMS =EndTime.getTime() - NowTime.getTime();
  	var nD =Math.floor(nMS/(1000 * 60 * 60 * 24));
  	var nH=Math.floor(nMS/(1000*60*60)) % 24;
  	var nM=Math.floor(nMS/(1000*60)) % 60;
  	var nS=Math.floor(nMS/1000) % 60;
  	var showMsg="";
  	if(nD>= 0){
  		if(nD>0){
  			showMsg=nD+"天 ";
  		}
  		if(nH<10){nH='0'+nH};
  		if(nM<10){nM='0'+nM};
  		if(nS<10){nS='0'+nS}; 
  		showMsg+=nH+":"+nM+":"+nS;
  	}else{
  		showMsg="00:00:00"; 
  		 if(gotoPathUrl&&gotoPathUrl.length>0){
  	    	window.location=gotoPathUrl;	
  	    }
  	}
  	
  	$("#"+displayTimeID).html(showMsg); 
  	setTimeout("showtime()", 1000); 
  } 
 
 
 
 /**
  * 获取系统当前时间
  * @return
  */
 function getNowSysTime(){
	 var dateTime=new Date();
     var hh=dateTime.getHours();
     var mm=dateTime.getMinutes();
	 var ss=dateTime.getSeconds();
     
	 var yy=dateTime.getFullYear();
	 var MM=dateTime.getMonth()+1;  //因为1月这个方法返回为0，所以加1
	 var dd=dateTime.getDate();
	 
	 var sysTime = yy+'-0'+MM+'-'+dd+' '+hh+':'+mm+':'+ss;
	 return sysTime;
 }
 
//ajax获取服务器时间
function getServerTime(){
	var date = new Date($.ajax({async: false,cache:false}).getResponseHeader("Date"));
	var sysTime= date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	return sysTime;
}

//获取指定名称的cookie的值 
function getCookie(objName){
	var arrStr = document.cookie.split("; "); 
	for(var i = 0;i < arrStr.length;i ++){ 
	var temp = arrStr[i].split("="); 
	if(temp[0] == objName) return unescape(temp[1]); 
	} 
} 

//删除cookie
function delCookie(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
 
 