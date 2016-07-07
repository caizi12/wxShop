<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html> 
	<head>
		<title>系统登录</title>
		<%@ include file="/jsp/common/common.jsp" %>
		<link rel="stylesheet" href="<%=basePath%>/jsp/admin/css/base.css" type="text/css" />
		<script type="text/javascript">
		function reset(){
				$('#loginform').form('clear');
			}
		 
		function submitForm(){
			return  $("#loginform").form('validate');
		 }
	    </script>
	</head>
	<body>
		<div class="login-bg">
			<div class="login-title">
					菜籽商城
			</div>
			<div class="login"> 
				<div class="wrapper-login">
					<form id="loginform" method="post" onsubmit="return submitForm();" novalidate action="admin/loginCheck.do">
						<p>
							&nbsp;
						</p>
						<p>
							&nbsp;
						</p>
						<p>
							<label class="required" for="username">
								用户名:
							</label>
							<br />
							<input type="text" id="userName"   validType="length[5,20]" class="formText" value="" name="userName" required="true"/>
						</p>
						<p>
							<label class="required" for="password">
								密 码:
							</label>
							<br />
							<input type="password" id="password" validType="length[6,20]" class="formText width2 easyui-validatebox" value="" name="password" required="true"/>
						</p>
						<p>
							<input type="submit" class="btn btn-green big" value="登 录" />
							&nbsp;
							<a href="javascript:reset();">重 置</a>  <span class="font-red" style="padding-left:5px;">${infoMess}</span>
						</p>
						<div class="clear">
							&nbsp;
						</div>

					</form>

					<form id="emailform" style="display: none" method="post" action="#">
						<div class="box">
							<p id="emailinput">
								<label for="email">
									Email:
								</label>
								<br />
								<input type="text" id="email" class="full" value="" name="email" />
							</p>
							<p>
								<input type="submit" class="btn" value="Send" />
							</p>
						</div>
					</form>
				</div>
			</div>

			<div class="div-center">
					<p>Copyright &copy; 2012
					<a href="http://www.myShop.cn" title="http://www.myShop.cn">www.myShop.cn</a></p>
			</div>
		</div>
	</body>
</html>