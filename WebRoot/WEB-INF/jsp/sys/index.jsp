<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/basePath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>
后台管理
</title>

<%@ include file="/jsp/common/common.jsp"%>
<link href="<%=path%>/resources/jquery/framework/redmond/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="<%=path%>/resources/jquery/framework/core.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="<%=path%>/resources/jquery/framework/jquery.leftmenu.src.js"></script>
<script type="text/javascript" src="<%=path%>/resources/jquery/framework/jquery.navtab.src.js"></script>
<%@ include file="/jsp/easyui-validate.jsp"%>
</head>

<body style="overflow-x:hidden;overflow-y:hidden;">
<div id="layout">
<div id="header"> <div id="nav" class="nav"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> <td valign="middle" align="left" rowspan="2"> <div class="logoindex" style=" "> </div>
<div class="sys_logo">广顺信达净水商城联盟</div>
</td>
<td valign="middle" height="16px" width="250px"> 欢迎您：${sysUserSessionInfo.sysUser.realName} &nbsp;|&nbsp;
<a title="系统日期" href="#"><%=cn.frame.platform.common.util.date.DateUtil.formatDateByFormat("yyyy-MM-dd") %></a></td> 
</tr>
<tr> <td colspan="3" height="25" align="left" style="padding-right:20px;"> <a
	href="javascript:openPassword();" target="_self"> 修改密码</a> &nbsp;|&nbsp; <a href="<%=path%>/sys/logout.do"
	target="_self"> 退出</a> </td> </tr>
</table>
</div>
<div id="navMenu" class="navMenu"> <ul></ul> </div>
</div>
<div id="leftside" class="leftmenu"></div>
<div id="container"></div>
<div id="footer"></div>
</div>

<div id="changePwdDialg" style="width:300px;height:106px;padding:6px 12px;display:none;"> <form id="changePwdForm"
	method="post" class="inputForm" novalidate> <div> <label>输入原密码：</label> <input id="oldPwd" name="oldPwd"
	type="password" validType="length[6,20]" class="formText  easyui-validatebox" required="true"></div> <div> <label>输入新密码：</label>
<input id="newPwd" name="newPwd" type="password" validType="length[6,20]" class="formText  easyui-validatebox"
	required="true"></div> <div> <label>重复新密码：</label> <input id="newPwd2" name="newPwd2" type="password"
	validType="equalTo['#newPwd']" invalidMessage="两次输入的新密码不一致，请重新输入" class="formText easyui-validatebox" required="true"></div>
</form> </div>


<script type="text/javascript">
		var menus = [
		  		<c:forEach items="${sysUserSessionInfo.userMenus}" var="menu" >
		  	    {menuId: '<c:out value="${menu.menuId}"/>', menuName:'<c:out value="${menu.menuName}"/>',
		  	     parentMenuId: '<c:out value="${menu.parentMenuId}"/>'=='0'?'':'<c:out value="${menu.parentMenuId}"/>', menuUrl: '<%=path%><c:out value="${menu.menuUrl}"/>'},
		        </c:forEach>
		  	    {}
		];

	  	$(document).ready(function() {
	  		winResize(true);
	  		var isSel = false;
	  		for(var i=0; i<menus.length; i++) {
	  			if(menus[i].parentMenuId == '') {
	  				if(!isSel) {
	  					$('#navMenu>ul').append('<li style=" padding:0;" menuId="' + menus[i].menuId + '" class="selected"><div class="nav_l"></div><div id="lis' + i + '" class="nav_m"><a href="#">' + menus[i].menuName + '</a></div><div class="nav_r"></div></li>');
	  				} else {
	  					$('#navMenu>ul').append('<li menuId="' + menus[i].menuId + '"><div class="nav_l"></div><div id="li' + i + '" class="nav_m"><a href="#">' + menus[i].menuName + '</a></div><div class="nav_r"></div></li>');
	  				}
	  				$('#navMenu>ul').append('<li class="line"><img src="<%=path%>/resources/jquery/framework/redmond/images/menu/tiop_06.gif" /></li>');
	  				$('#li' + i).css('width', (15 * menus[i].menuName.length) + 'px');
	  				$('#lis' + i).css('width', (15 * menus[i].menuName.length) + 'px');
	  				if(!isSel) {
	  					initMenu(menus[i].menuId);
	  				}
	  				isSel = true;
	  			}
	  		}
	  		$('#navMenu li').click(function() {
	  			$('#leftside').empty();
	  			$('#navMenu li').removeClass('selected');
	  			$(this).addClass('selected');
	  			initMenu($(this).attr("menuId"));
	  		});
	  		
	  		$('#container').navtab();
	  		
	  
	  		$(window).resize(timeResize);
	  		
	  		if($.browser.msie && $.browser.version < 7) {
	  			$('html').css('overflow', 'hidden');
	  			$(window).resize();
	  		}

	  	});
	 
	  	
	  	/**
	  	 * 初始化左边菜单
	  	 */
	  	function initMenu(parentMenuId) {
	  		try {
	  			$('#leftside').leftmenu('collapse');
	  		} catch(e){}
	  		$('#leftside').leftmenu({
	  			parentMenuId: parentMenuId,
	  			openTabMethod: 'openTabLm',
	  			containerLeft: $('#container').position().left,
	  			containerWidth: $('#container').width(),
	  			menus: menus
	  		});
	  	}
	  	
	  	/**
	  	 * 打开tab页面
	  	 * isClose是否可以关闭
	  	 * isFresh切换是否重新加载页面
	  	 */
	  	function openTab(id, title, url, isClose, isFresh) {
	  		$('#container').navtab("open", id, url, {
	  			title: title,
	  			close: isClose, 
	  			fresh: isFresh
	  		});
	  	}
	  	
	  	/**
	  	 * 用于左边菜单打开
	  	 * isClose是否可以关闭
	  	 * isFresh切换是否重新加载页面
	  	 */
	  	function openTabLm(opts) { 
	  		$('#container').navtab("open", opts.id, opts.url, {
	  			title: opts.title,
	  			close: opts.close, 
	  			fresh: opts.fresh
	  		});
	  	}
	  	
	  	
	 	function openPassword(){
	 	    $('#changePwdForm').form('clear');
	 	    var winPassword=$.ligerDialog.show({target:$("#changePwdDialg"),title:'修改密码',width:350,
		 	    buttons:
		 	     [
		            {text:'确定',onclick:function(){changeUserPassword(winPassword)}},
		            {text:'取消',onclick:function(){winPassword.hide();}}
	             ]
	       		 });
		}
	  	
	  	
	  function changeUserPassword(winPassword){
		   if(!$('#changePwdForm').form('validate')) {
				return false;
		   }   
		     
		  $.post("<%=path%>/sys/changeUserPassword.do",$("#changePwdForm").serializeArray(),function(data){
					$.ligerDialog.warn(data.msg);
					if(data.result==true){
					  winPassword.hide();
					}	
		  });
	  }
	  	
	  	/**
	  	 * 关闭tab页面
	  	 */
	  	function closeTab(id) {
	  		$('#container').navtab("close", id);
	  	}
	  	
	  	/**
	  	 * 定时调整大小
	  	 */
	  	function timeResize() {
	  		setTimeout("winResize()", 10);
	  	} 
	  	
	  	/**
	  	 * 调整大小
	  	 */
	  	function winResize(f) {
	  		var winWidth = $(window).width();
	  		var winHeight = $(window).height();
	  		var midHeight = winHeight - $('#header').outerHeight() - 7;
	  		$('#header').width(winWidth - 6);
	  		$('#leftside').height(midHeight);
	  		$('#container').height(midHeight);
	  		$('#container').width(winWidth - ($('#container').position().left + 6));
	  		if(f !== true) {
	  			$('#leftside').leftmenu('resize', midHeight);
	  			$('#container').navtab("resize", midHeight);
	  		}
	  	}
	  	
	  	/**
	  	 * 获取容器的宽度
	  	 */
	  	function getContainerWidth() {
	  		return $('#container').width();
	  	}
	  	
		/**
	  	 * 获取容器的高度
	  	 */
	  	function getContainerHeight() {
	  		return $('#container').height() - 50;
	  	}
	  	
	  	
	  	//加载默认页面
	  	$(function(){
	  	 openTabLm({id: "homePage", title:"首页", url:"${ctx}/sys/homePage.do"});
	  	})
  </script>
</body>
</html>
