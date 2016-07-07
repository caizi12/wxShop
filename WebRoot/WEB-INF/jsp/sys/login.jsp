<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html> 
	<head> 
		<title>系统登录</title>
		<%@ include file="/jsp/common/common.jsp" %>
		<link rel="stylesheet" href="${ctx}/resources/sys/base.css" type="text/css" />
		<%@ include file="/jsp/easyui-validate.jsp" %>
		<script type="text/javascript">
		function reset(){
				$('#loginform').form('clear');
			}
		 
		function submitForm(){
			if(!($("#loginform").form('validate'))) {
				return false;
		     }     
			 $.post("${ctx}/sys/loginCheck.do",$("#loginform").serializeArray(),function(data){
			    if(data.login==true){
			     	location.href="${ctx}/sys/index.do";
			     }else{
					$('#infoMess').text(data.infoMess);			     
			     }
			  });
		 }
	    </script>
	</head>
	<body style="height:100%">
		<div class="login-bg">
			<div class="login-title">
					净水商城联盟
			</div>
			<div class="login"> 
				<div class="wrapper-login">
					<form id="loginform" method="post"  novalidate >
						<div style="width:100%;height:50px;"></div>
						<p>
							&nbsp;&nbsp;
						</p>
						<p>
							<label class="required" for="username">
								用户名:
							</label>
							<br />
							<input type="text" id="userName"   validType="length[5,20]" class="formText width2 easyui-validatebox" value="" style="padding:5px 4px 4px 2px;" name="userName" required="true"/>
						</p>
						<p>
							<label class="required" for="password">
								密 码:
							</label>
							<br />
							<input type="password" id="password" validType="length[6,20]" class="formText width2 easyui-validatebox" style="padding:5px 4px 4px 2px;"  value="" name="password" required="true"/>
						</p>
						<p>
							<input type="button" class="loginBtn loginBtn-green big" onclick="submitForm()"value="登 录" />
							&nbsp;
							<a href="javascript:reset();">重 置</a>  <span id="infoMess" class="font-red"  style="padding-left:5px;"></span>
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
					<p> QQ:365770786 Email:caizi12@126.com
					<a href="#" title="http://caizi12.iteye.com/admin"> http://caizi12.iteye.com/admin</a></p>
			</div>
		</div>
	</body>
</html>