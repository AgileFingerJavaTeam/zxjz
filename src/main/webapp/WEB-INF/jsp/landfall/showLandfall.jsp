<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" href="i/favicon.png">
  	<link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
  	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
  	<link rel="stylesheet" href="Fontawesome/css/amazeui.min.css" />
  	<link rel="stylesheet" href="Fontawesome/css/admin.css">
  	<link rel="stylesheet" href="Fontawesome/css/app.css">
	<title>欢迎来到登陆界面</title>
</head>
<body data-type="login">
	<div class="am-g myapp-login">
		<div class="myapp-login-logo-block  tpl-login-max">
			<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
			职信 管理<span> 系统</span> <i class="am-icon-skyatlas"></i>
			</div>
		</div>
		<div class="login-font">
			<i>Log In </i> or <span> Sign Up</span>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form">
				<fieldset>
					<div class="am-form-group">
						<input type="text" name="employees_num" id="username" placeholder="输入员工账号"/>
					</div>
					<div class="am-form-group">
						<input type="password" name="login_password" id="password" placeholder="输入员工密码"/>
					</div>
					<p>
					<button type="button" class="am-btn am-btn-default" id="login">登录</button></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/amazeui.min.js"></script>
<script type="text/javascript" src="scripts/app.js"></script>
<script type="text/javascript">
  $(function(){
		$('#login').click(function(){
  		var employees_num= $("#username").val();
  		var login_password= $("#password").val();
			$.ajax({
      		type:"POST",
      		url:"LandFall/getShowLandFall",
      		dataType:"json",
      		data:{"employees_num":employees_num,"login_password":login_password},// 你的formid
      		success: function(data) {
      			/*if(data.status==0){
          			alert(data.info);
          			return;
          		}*/
          		window.location.href="index/index";
      		}
  		})
		})
	})
  </script>
</body>
</html>