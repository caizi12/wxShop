/**
	文件名称：CommonUtil.js
	黄嵩拷贝自后台，并整理部分方法，对几个验证类进行改造，适合于门户前台 2010-11-24 17:26:38
	
	文件内容：一些常用的js公用类。工具类
	包括方法：
	g_GetObjXY 		 获取页面中某个元素的绝对座标
	g_IsDigit    		 校验是否全由数字组成
	g_IsFloat(s,pDecimal) 校验是否是合法的小数
	g_IsDigit(s)		全数字组成
	g_IsDigitStr(s)   否是数字，并且不能以0开头
	g_Trim(str)  String的trim方法
	g_IsNumber(s)		数字
	g_IsInt(s)			整数
	g_IsEmail 		 判断合法的email地址
	g_IsTeleNumber		 校验普通电话、传真号码：可以“+”开头，除数字外，可含有“-”
	g_IsTeleNumber2		 校验1个普通电话、传真号码：可以“+”开头，除数字外，可含有“-”
	g_IsPostalCode 		校验邮政编码 6位数字
	g_IsMobileNumber 	校验手机号码：必须以数字1开头
	g_IsChinaMobile     验证手机号码是否为中国移动号码，携号转网以后，可能有联通或则电信号
	g_IsDate		判断日期格式是否合法，符合yyyy-mm-dd
	g_IsDateTime		校验日期时间是否合法yyyy-mm-dd H24:MI:SS这种格式的日期+时间
	g_getStrLen 		获取字符串的长度，如果字符串中包括中文等双字节代码，则其长度算为2。
	g_getSubStrInByte			获取子字符串，参数长度为字节长度。
	g_StringTrim		字符串trim方法，取消到前后的空格
  g_CheckInputNum         控制只能输入数字
  g_IDCardNumber      判断是否是身份证号码
  g_FormatDate(aDate,format) 格式化日期时间方法PARAMETER: aDate:js中的aDate对象,format-格式字符串.如:yyyy-MM-dd hh:mm:ss
  g_BeforePasteNum()  粘贴时控制只能贴入数字和回车 需要绑定onbeforePaste事件
  g_BeforePasteEnglish() 粘贴时控制只能贴入数字和字母，需要绑定onbeforePaste事件
  g_CompareDate       判断日期大小
**/


/*********************************************************************************
* FUNCTION: 请求数据库获取数据库的日期和时间
* PARAMETER: null
* RETURNS: string字符串
*********************************************************************************/
function g_GetSysDateTime()
{
     var _gNode = null;
     var xml= new ActiveXObject("Msxml.DOMDocument");
     xml.async = false;
     var url=  _gModuleName+ "/potal/nb.lf.portal.tuan.web.TuanAction?action=getSysDateTime";
     var b = xml.load(url);
     if(!b){
	    alert("无法获取时间信息,请检查:\n当前用户是否已经失效.\n网络连接是否正常.\n数据库运行是否正常");
		return null;
	  }

      var xmlNode = xml.documentElement;
      var ud = createUserDataClass(xmlNode,true);
      return ud.getValueByName("DateTime");
}
/*********************************************************************************
* FUNCTION: 请求数据库获取数据库的时间
* PARAMETER: null
* RETURNS: string字符串
*********************************************************************************/
function g_GetSysTime()
{
   var dateTime = g_GetSysDateTime();
   var time = null;
   if(dateTime!=null && dateTime.indexOf(' ')!=null)
	{
	   time = dateTime.substring(dateTime.indexOf(' ')+1,dateTime.length);
	}
  return time;
}

 /*********************************************************************************
* FUNCTION: g_GetObjXY 获取页面中某个元素的绝对座标
* PARAMETER: obj,dhtml 对象
* RETURNS: array，array['x']=xpos,array['y']=ypos
*********************************************************************************/
function g_GetObjXY(Obj)
 {
	 for(var sumTop=0,sumLeft=0;Obj!=document.body;sumTop+=Obj.offsetTop,sumLeft+=Obj.offsetLeft,Obj=Obj.offsetParent);
	return {left:sumLeft,top:sumTop};

 }



 /*********************************************************************************
* FUNCTION: g_IsEmail 判断合法的email地址
* PARAMETER: String (Email Address)
* RETURNS: TRUE if the String is a valid Email address
* FALSE if the passed string is not a valid Email Address
* @ sign can appear only once in the email address.
*********************************************************************************/
function g_IsEmail (theStr) {
if(theStr==null || theStr=='')return false;
var atIndex = theStr.indexOf('@');
var dotIndex = theStr.indexOf('.', atIndex);
var flag = true;
theSub = theStr.substring(0, dotIndex+1);
var validator_email = /^([a-zA-Z0-9])+([\._-][a-zA-Z0-9_-]+)*@([a-zA-Z0-9_-]{1,})+((\.[a-zA-Z0-9_-]{2,20}){1,4})$/ ;
if ((atIndex < 1)||(atIndex != theStr.lastIndexOf('@'))||(dotIndex < atIndex + 2)||(theStr.length <= theSub.length))
{ return(false); }
	else if(!validator_email.test(theStr)){
		return false;
	}
	else{ return(true); }
}

function isPostiveInt(s){
	return new RegExp('^[1-9]+\\d*$', 'gi').test(s);
}

function isPostiveFloat(s,minPerLen,maxPerLen){
	return new RegExp('^((\\d+(\\.\\d{'+minPerLen+','+maxPerLen+'})?)|(\\d*(\\.\\d{'+minPerLen+','+maxPerLen+'})?))$', 'gi').test(s);
}
/*********************************************************************************
* FUNCTION: g_IsDigit 校验是否全由数字组成
* PARAMETER: 字符串s
* RETURNS: true/false
*********************************************************************************/

function g_IsDigit(s)
{
 if(s==null) return false;
 if(s=='')return true;
 s=''+s;
 if(s.substring(0,1)=='-' && s.length>1)s=s.substring(1,s.length);

var patrn=/^[0-9]*$/;
if (!patrn.exec(s)) return false;
return true;
}
/*********************************************************************************
* FUNCTION: g_IsDigit 校验是否是数字并且不能以0开头
* PARAMETER: 字符串s
* RETURNS: true/false
*********************************************************************************/
function g_IsDigitStr(s){
    if (s == null || g_Trim(s) == "")
       return true;
    var patrn=/^(0|[1-9][0-9]*)$/;
	if (!patrn.exec(s)) return false;
	return true
}

function g_IsNumber(s)
{
	if(s==null) return false;
	 s=''+s;
	 if(s=='')return true;
	 var reg=/^\d+\.?\d*$/;
	 if(!reg.test(s)) return false;
	 else return true;
}
function g_IsInt(s)
{
	if(s==null) return false;
	 var reg=/^[1-9]\d*$/;
	 if(!reg.test(s)) return false;
	 else return true;
}
/*********************************************************************************
* FUNCTION: g_IsFloat 校验是否是小数
* PARAMETER: 字符串s.pDecimal精度（保留多少位小数 值为0或者－1时不限制精度）
* RETURNS: true/false
*********************************************************************************/
function g_IsFloat(s,pDecimal)
{
 if(s==null) return false;
 s=''+s;
 if(s=='')return true;
 
 if(s.substring(0,1)=='-' && s.length>1)s=s.substring(1,s.length);

 var dec = -1;
 if(parseInt(pDecimal)!=NaN)
   dec = pDecimal;
 var reg = "^[0-9]+(\\.[0-9]{1,"+dec+"})?$";
 if(dec==0 || dec==-1)
 {
   reg = "^[0-9]+(\\.[0-9]{1,10000})?$";
 }
 var re = new RegExp(reg,"g");
 if(!s.match(re)) return false;
 else return true;

}

/***********************************************************************************************
* FUNCTION: g_IsTeleNumber 校验普通电话：可以有3或4位区号，7或8位电话号码，中间可用“-”隔开,也可以有3位以上的分机号
* PARAMETER: 字符串s
* RETURNS: true/false
************************************************************************************************/
function g_IsTeleNumber(s)
{
if(s==null || s=='')return false;
if(s.length>40 || s.length<4)return false;

var re = new RegExp(/^(0[0-9]{2,3}-)?([0-9]{7,8})(-([0-9]{3,}))?$/);
if(s.indexOf(";")>0){
	var s1=s.substring(0,s.indexOf(";"));
	var s2=s.substring(s.indexOf(";")+1,s.length);
	var isNumber=re.test(s1);
	if(isNumber || g_IsMobileNumber(s1)){
		isNumber=re.test(s2);
		if(isNumber || g_IsMobileNumber(s2))
			return true;
		else{
			return false;
		}
	}else{
		return false;
	}
}else{
	if(re.exec(s))return true;
	else return false;
}
}

/***********************************************************************************************
* FUNCTION: g_IsTeleNumber 校验1个普通电话：可以有3或4位区号，7或8位电话号码，中间可用“-”隔开,也可以有3位以上的分机号
* PARAMETER: 字符串s
* RETURNS: true/false
************************************************************************************************/
function g_IsTeleNumber2(s)
{
	s=g_Trim(s); 
	if(s==null || s=='')return false;
	if(s.length>40 || s.length<4)return false;
	
	var re = new RegExp(/^(0[0-9]{2,3}-)?([0-9]{7,8})(-([0-9]{3,}))?$/);
	var isNumber=re.test(s);
	if(isNumber){
		if(re.exec(s))
			return true;
		else 
			return false;
	}
	else
		return false;
	
}

//新的手机号码验证，以1打头，11位数字
function g_IsMobileNumber(s)
{
	s=g_Trim(s);
	var patrn = /^1[0-9]{10}$/;
	if (!patrn.exec(s)) return false;
	return true;
}

//验证手机号码是否为中国移动号码，携号转网以后，可能有联通或则电信号
function g_IsChinaMobile(s)
{
	var patrn = /^1[0-9]{10}$/;
	if (!patrn.exec(s)) return false;
	return true;
}

/*********************************************************************************
* FUNCTION: g_IsPostalCode 校验邮政编码 6位数字
* PARAMETER: 字符串s
* RETURNS: true/false
*********************************************************************************/

//
function g_IsPostalCode(s)
{
if(s==null || s=='')return false;
var patrn=/^[0-9]{6}$/;
if (!patrn.exec(s)) return false;
return true;
}

function g_Trim(str){
	  str = str.toString(10);
	  return str.replace(/(^\s*)|(\s*$)/g, "");
}



/*********************************************************************************
* FUNCTION: g_IsDate 校验日期是否合法yyyy-mm-dd这种格式的日期
* PARAMETER: 字符串s
* RETURNS: true/false
*********************************************************************************/
var DATE_SEPARATOR = "-";

function g_IsDate(str)
{
	if(str=='')return false;
   if(DATE_SEPARATOR==null) DATE_SEPARATOR ="-";
   var regExpStr = "^\\d{4}" + DATE_SEPARATOR + "\\d{1,2}" + DATE_SEPARATOR + "\\d{1,2}$";
   var patrn = new RegExp(regExpStr);

   if(!patrn.exec(str)) return false;
   var dateArray  = str.split(DATE_SEPARATOR);
   var d= new Date(dateArray[0],dateArray[1]-1,dateArray[2]);
   var issame =(d && (d.getFullYear()==dateArray[0])&& (d.getMonth()+1==dateArray[1]) &&(d.getDate()==dateArray[2]));
   if (!issame)
       {
	 return false;
       }
   return true;
}

/*********************************************************************************
* FUNCTION: g_IsDateTime 校验日期是否合法yyyy-mm-dd H24:MI:SS这种格式的日期+时间
* PARAMETER: 字符串s
* RETURNS: true/false
*********************************************************************************/
function g_IsDateTime(str)
{
	if(str=='')return false;
   if(DATE_SEPARATOR==null) DATE_SEPARATOR ="-";
   var regExpStr = "^\\d{4}" + DATE_SEPARATOR + "\\d{1,2}" + DATE_SEPARATOR + "\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}$";
   var patrn = new RegExp(regExpStr);

   if(!patrn.exec(str)) return false;
   var dateTimeArray = str.split(" ");
   if(dateTimeArray==null || dateTimeArray.length!=2) return false;
   var dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
   var timeArray = dateTimeArray[1].split(":");
   var d= new Date(dateArray[0],dateArray[1]-1,dateArray[2],timeArray[0],timeArray[1],timeArray[2]);
   var issame =(d && (d.getFullYear()==dateArray[0])&& (d.getMonth()+1==dateArray[1]) &&(d.getDate()==dateArray[2]) && (d.getHours() == timeArray[0]) && (d.getMinutes()== timeArray[1]) && (d.getSeconds()== timeArray[2])  );
   if (!issame)
       {
	 return false;
       }
   return true;
}

/*********************************************************************************
* FUNCTION: 获取字符串的长度，如果字符串中包括中文等双字节代码，则其长度算为2。
* PARAMETER: 字符串s
* RETURNS: int
*********************************************************************************/
function g_GetStrLen(str){
  str = str.toString(10);
  return str.replace(/[^\x00-\xff]/g,"aa").length;
}

/*********************************************************************************
* FUNCTION: 获取子字符串，参数长度为字节长度
* PARAMETER: str字符串，length获取长度，已字节为单位，如双字节，按照2处理，子串取ground
* RETURNS: int
*********************************************************************************/
function g_getSubStrInByte(str,lenth){
  str = str.toString(10);
  var tmpstr= str.replace(/[^\x00-\xff]/g,"\x0b\x0c");

	tmpstr =tmpstr.substring(0,lenth);
	tmpstr = tmpstr.replace(/\x0b/g,'');
	return str.substring(0,tmpstr.length);
}

/*********************************************************************************
* FUNCTION: 字符串trim方法，取消到前后的空格
* PARAMETER: 字符串s
* RETURNS: string字符串
*********************************************************************************/
function g_StringTrim(str){
  str = str.toString(10);
  return str.replace(/(^\s*)|(\s*$)/g, "");
}

/*********************************************************************************
* FUNCTION: 控制只能输入数字和回车
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_CheckInputNum(obj){
  var keyCode = event.keyCode;

  if(keyCode==8)return;
  if(keyCode==46)return;
  if(keyCode==35)return;
  if(keyCode==36)return;
  if(keyCode==37)return;
  if(keyCode==39)return;
  if(event.keyCode==13)return;

  //支持ctrl + a、v、x、c
  if(event.ctrlKey && (keyCode==65 || keyCode==67
    ||keyCode==86 || keyCode==88)){
    if(keyCode==86){
      var str = window.clipboardData.getData('text');
      if(str!=null){
        str = str.replace(/[^\d\n]/g,'');
        str = str.replace(/[\n]+/g,'\n');
        window.clipboardData.setData('Text',str);
      }
    }
    return;
  }

  if(48>event.keyCode || (event.keyCode > 57 && event.keyCode < 96)
     || event.keyCode >105 ){
    event.returnValue=false;
  }
  //对微软输入法的特殊限制
  if(keyCode ==229 && obj !=null){
    obj.disabled = true;
    obj.disabled = false;
    obj.focus();
    obj.value = obj.value.replace(/[^\d]/g,'');
  }
}

/*********************************************************************************
* FUNCTION: 控制只能输入数字或字母等
* 允许的字母如下："0123456789-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "
* PARAMETER: null
* RETURNS: null
*********************************************************************************/

function g_CheckInputEnglish(obj){
  var keyCode = event.keyCode;

  if(keyCode==8)return;
  if(keyCode==46)return;
  if(keyCode==35)return;
  if(keyCode==36)return;
  if(keyCode==37)return;
  if(keyCode==39)return;
  if(event.keyCode==13)return;

  //支持ctrl + a、v、x、c
  if(event.ctrlKey && (keyCode==65 || keyCode==67
    ||keyCode==86 || keyCode==88)){
    //
    if(keyCode==86){
      var str = window.clipboardData.getData('text');
      if(str!=null){
        str = str.replace(/[\W]/g,'');
        window.clipboardData.setData('Text',str);
      }
    }
    return;
  }

  var checkOK = "0123456789-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

  var str = String.fromCharCode(keyCode);

  if(checkOK.indexOf(str)<0 ){
    event.returnValue=false;
  }
  //对微软输入法的特殊限制
  if(keyCode ==229 && obj !=null){
    obj.disabled = true;
    obj.disabled = false;
    obj.focus();
    obj.value = obj.value.replace(/[\W]/g,'')
  }
}


//判断是否是身份证号码
function g_IDCardNumber(value){
  if(value=='' || value==null)return false;
  var length = value.length;

  if(length ==15){
    if(!g_IsDigit(value) || value.substring(0,1)=='-'){
      return false;
    }
    return true;
  }else if(length ==18){
    //前17位必须是数字
    for (i= 0; i < 17;  i++){
      code = value.charCodeAt(i);
      if(code<48 || code>57)return false;
    }
    //18位身份证号码的最后一位可以是数字或英文字母
    code = value.charCodeAt(17);
    if(code>=48 && code<=57 || code>=65 && code<=90 || code>=97 && code<=122){
      return true;
    }
  }
  //位数不为15或者18则返回
  return false;
}

//判断日期大小,输入两个日期字符串，返回两个日期的大小
// 0一样大 ，1 第一日期大 ，-1 第二个日期大 , -2 日期格式不合法
function g_CompareDate(date_str1 ,date_str2){
  if(date_str1 ==null) date_str1='';
  if(date_str2==null ) date_str2='';

  if(date_str1 ==date_str2)return 0;
  
  if( !g_IsDateTime(date_str1) && !g_IsDate(date_str1)
      || !g_IsDateTime(date_str2) && !g_IsDate(date_str2) ){
    return -2;
  }

  if(date_str1 =='' && date_str2 !='') return -1;
  if(date_str2 =='' && date_str1 !='') return 1;

  var hour =0;
  var min =0;
  var sec =0;

  var dateTimeArray = date_str1.split(" ");
  var dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  if(dateTimeArray.length>1){
    var timeArray = dateTimeArray[1].split(":");
    hour = timeArray[0];
    min = timeArray[1];
    sec = timeArray[2];
  }
  var d1= new Date(dateArray[0],dateArray[1]-1,dateArray[2],hour ,min ,sec);

  hour =0;
  min =0;
  sec =0;

  dateTimeArray = date_str2.split(" ");
  dateArray  = dateTimeArray[0].split(DATE_SEPARATOR);
  if(dateTimeArray.length>1){
    var timeArray = dateTimeArray[1].split(":");
    hour = timeArray[0];
    min = timeArray[1];
    sec = timeArray[2];
  }
  var d2= new Date(dateArray[0],dateArray[1]-1,dateArray[2],hour ,min ,sec);

  if (d1.getTime()==d2.getTime()) return 0;
  if(d1.getTime()>d2.getTime())return 1;
  else return -1;
}

/*********************************************************************************
* FUNCTION: 格式化日期时间方法
* PARAMETER: aDate:js中的aDate对象,format-格式字符串.如:yyyy-MM-dd hh:mm:ss
* RETURNS: 格式后的日期时间字符串
* AUTHOR:ZLH
*********************************************************************************/
function g_FormatDate(aDate,format)
  {
    var o = {
    "M+" : aDate.getMonth()+1, //month
    "d+" : aDate.getDate(),    //day
    "h+" : aDate.getHours(),   //hour
    "m+" : aDate.getMinutes(), //minute
    "s+" : aDate.getSeconds(), //second
    "q+" : Math.floor((aDate.getMonth()+3)/3),  //quarter
    "S" : aDate.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
    (aDate.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,
    RegExp.$1.length==1 ? o[k] :
    ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
  }

/*********************************************************************************
* FUNCTION: 粘贴时控制只能贴入数字和回车
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_BeforePasteNum(){
  var str = window.clipboardData.getData('text');
  if(str!=null){
    str = str.replace(/[^\d\n]/g,'');
    str = str.replace(/[\n]+/g,'\n');
    str = str.replace(/(^\s*)|(\s*$)/g, "");
    window.clipboardData.setData('Text',str);
  }
}

/*********************************************************************************
* FUNCTION: 粘贴时控制只能贴入数字和字母
* PARAMETER: null
* RETURNS: null
*********************************************************************************/
function g_BeforePasteEnglish(){
  var str = window.clipboardData.getData('text');
  if(str!=null){
    str = str.replace(/[\W]/g,'');
    window.clipboardData.setData('Text',str);
  }
}

/**
 * js取得当前时间 
 * @return
 */
function getSysDateTimeStrJS(){
	 var myDate = new Date();	
	 var year = myDate.getFullYear(); 
	 var curmonth = myDate.getMonth()+1; 
	 var month = curmonth >9?curmonth.toString():'0' + curmonth; 
	 var day = myDate.getDate() >9?myDate.getDate().toString():'0' + myDate.getDate();    
	 var hour = myDate.getHours() > 9 ? myDate.getHours().toString() : '0' + myDate.getHours();
	 var minute = myDate.getMinutes() > 9 ? myDate.getMinutes().toString() : '0' + myDate.getMinutes();
	 var second = myDate.getSeconds() > 9 ? myDate.getSeconds().toString() : '0' + myDate.getSeconds();
	 var curTime = year+"-"+month+"-"+day+" " + hour + ":" + minute + ":" + second;
	 return curTime;
}
/**
 * 校验只能是中文和英文字母
 * @return true or false
 */
function g_isChEngNum(value){
	var pattern = /^[\u4e00-\u9fa5A-Za-z0-9]*$/;
	if(pattern.test(value)){
		return true;
	}else{
		return false;
	}
}
 
 
/**
 * 解决订单确认页，select不兼容ios问题
 * @param value
 * @return
 */
 function updateDeliverTime(value){
	 var showDeliverTime = '不限时间';
	 if(value=='01'){
		 showDeliverTime = '周一至周五';
	 }else if(value=='02'){
		 showDeliverTime = '周六日及公共假期';
	 }
	 $("#deliverTimeShow").text(showDeliverTime);
 }
