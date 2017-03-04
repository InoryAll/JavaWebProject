<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div id="login_box">
		<div id="login_container">
			<a href="index.jsp" id="login_exit">
				<img src="images/exit.png">
			</a>
			<div id="login_content">
				<form action="useraction" method="post" id="login_form">
					<input type="hidden" name="action" value="login_action" id="action">
					<table class="login_table">
						<tr>
							<td>
								<a href="#" class="login_welcome">
									Login
								</a> 
							</td>
						</tr>
						<tr>
							<td>
								<div class="username_div" id="username_div">
									<img src="images/user.png" class="username_pic">
									<input type="text" name="username" id="username" placeholder="USERNAME">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="password_div" id="password_div">
									<img src="images/password.png" class="password_pic">
									<input type="password" name="password" id="password" placeholder="PASSWORD">
								</div>
							</td>
						</tr>
						<tr>
							<td class="no_regedit_div">
								<span id="toolstrip">${message}</span>
							</td>
						</tr>
						<tr>
							<td>
								<div class="submit_div" >
									<input type="submit" name="" id="submit" value="Sign In">
								</div>
							</td>
						</tr>
						<tr>
							<td class="no_regedit_div">
								<a href="#" class="no_regedit">
									Not a registered user? Register now!
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>