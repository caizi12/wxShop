<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.frame.platform.entitys.MemberInfo;"%>
 <%
  HttpSession  memberSession= request.getSession();
  MemberInfo memberInfo =(MemberInfo)memberSession.getAttribute("memberSessionInfo");
  %>
<footer>
<div class="all_infor clearfix">
 <span id="loginUserInfo">
	<c:if   test="${memberSessionInfo !=null }">
	 用户：<a href="<%=path%>/member/myAccount.do" class="userClass">${memberSessionInfo.mobileNo}</a>&nbsp;
	 您可用积分:<font color="red">${memberSessionInfo.canPoint}</font>&nbsp;| <a href="<%=path%>/member/logout.do">退出</a>
	</c:if>
	<c:if  test="${memberSessionInfo ==null }">
	 您好 ，请 [<a href="<%=path %>/member/loginPage.do">登录</a>] [<a href="<%=path %>/member/memberRegisterPage.do">新用户注册</a>] [<a href="<%=path %>/index.do">首页</a>]
	</c:if>
  </span>
</div>
<div class="footer">
    <span class="fR"><img src="<%=path%>/styles/elements/gongshang.gif" title="工商备案" height="16" />
  	京ICP备15044164号&nbsp;|&nbsp;北京广信顺达科贸有限公司版权所有
  	</span>
</div>
</footer>
<div class="gotop">
        <span class="top" id="indextop"></span>
        <span class="goindex" id="goindex"></span>
</div>
<script type="text/javascript" src="<%=path%>/scripts/gotop.js"></script>
<script>
 
function CurrentUser(nickName, mobileNumber, userStarLevel){
    this.nickName = nickName;
    this.mobileNumber = mobileNumber;
    this.userStarLevel = userStarLevel;
}
$('#goindex').click(function(){
	window.location.href=path+"/index.do";
});
/**
 * 全局变量，用以存放当前登录者的信息，为CurrentUer的实例。如未登录，该变量为null;
 */
window.currentUser = null;
/**
 * 全局变量，标记是否已检测过当前登录者的信息。（发起-响应过一次ajax请求，则标为true）
 */
window.checkedCurrentUser = false;


function checkUser(){
$.ajax({
	type:"post",
	url:path + "/asynlogin/user/web/UserLoginAction?action=isUserLogin&time=" + (new Date().getTime().toString(36)),
	dataType:"json",
	success:function(data){
        var _user = data["info"];
        var logged = data["status"] != user_login_status_not_login && _user;
        //将登录信息放到全局变量中，方便后续在页面的javascript中直接使用
        if(logged){
            window.currentUser = new CurrentUser(_user.nickName,
                    _user.mobileNumber,
                    _user.userStarLevel,
                    _user.memcacheKey);
        }
        //设置标识已检测过当前登录者的信息
        window.checkedCurrentUser = true;
        //触发onCheckedCurrentUser事件，以通知感兴趣的处理者进行处理
        $(document).trigger('onCheckedCurrentUser');
		
		var html = "";

		//未登录
		if(!logged){
			return false;
		}
		
		var _nickName = data["nickName"];
		var _showName = _user["mobileNumber"];
		var userStarLevel = _user["userStarLevel"];
		if(_nickName)
			_showName = _nickName ;
		
		userClass = "gotone";
		var wareValueclass="black";
		html += "<a class=\"" + userClass + "\">"+_showName+ "</a>&nbsp;<i>"+userStarLevel+"</i>&nbsp;<i>可用积分：<i><a id='userPoints' class='" + wareValueclass + "'>" + _user["userCurrentIntegral"] + " </a>&nbsp;&nbsp;| <a href='"+path+"/login/mLogout.jsp'>退出</a>";

		$("#loginUserInfo").html(html);
		
    	//首页顶部用户积分样式
       	var isIndexPage =document.getElementById("Integral");
       	if(isIndexPage){
       		$("#Integral").html("<span>您当前的可用积分为：<b>" + $("#userPoints").text() + "</b></span>");
    	}
		
	 
	}
});
}
</script>

 