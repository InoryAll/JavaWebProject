<%@page import="Main.Student"%>
<%@page import="Factory.Factory"%>
<%@page import="DAOIMP.StudentDAOIMP"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/regedit.css">
	<script type="text/javascript" src="js/regedit.js"></script>
</head>
<body>
	<div id="regedit_box">
		<div id="regedit_container">
			<a href="index.jsp" class="regedit_exit">
				<img src="images/exit.png">
			</a>
			<form action="useraction" method="post" id="regedit_form">
			<input type="hidden" name="action" id="action" value="regedit_action">
				<div id="regedit_content1">
					<table class="regedit_table">
						<tr>
							<td colspan="3">
								<a href="#" class="regedit_welcome">
									Regedit
								</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="#" class="regedit_step active">
									1
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step">
									2
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step">
									3
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="3"> 
								<span id="submit_server_tip">
								${message }
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_username_div">
									<img src="images/regedit_username.png" class="regedit_username_pic">
									<input type="text" name="regedit_username" id="regedit_username" placeholder="USERNAME">
									<span id="username_tip">*</span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_password_div">
									<img src="images/regedit_password.png" class="regedit_password_pic">
									<input type="password" name="regedit_password" id="regedit_password" placeholder="PASSWORD">
									<span id="password_tip">*</span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_password_confirm_div">
									<img src="images/regedit_password.png" class="regedit_password_confirm_pic">
									<input type="password" name="regedit_password_confirm" id="regedit_password_confirm" placeholder="PASSWORD AGAIN">
									<span id="password_confirm_tip">*</span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<a href="#" class="regedit_next" id="regedit_next_1">
									NEXT
								</a>
							</td>
						</tr>
					</table>
				</div>
				<div id="regedit_content2">
					<table class="regedit_table">
						<tr>
							<td colspan="3">
								<a href="#" class="regedit_welcome">
									Regedit
								</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="#" class="regedit_step">
									1
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step active">
									2
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step">
									3
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_name_div">
									<img src="images/regedit_name.png" class="regedit_name_pic">
									<input type="text" name="regedit_name" id="regedit_name" placeholder="NAME">
									<span id="name_tip">*</span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_sex_div">
									<span class="sex_area_male">
										<input type="radio" name="sex" class="sex_button" checked="true" id="male" value="male">&nbsp;&nbsp;男
									</span>
									<span class="sex_area_female">
										<input type="radio" name="sex" class="sex_button" id="female" value="female">&nbsp;&nbsp;女
									</span>
									<span id="sex_tip">*</span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
							<!--
								ArrayList<String> dept_list=(ArrayList<String>)request.getAttribute("dept_list");	
							-->
								<div class="regedit_department_div">
									<img src="images/regedit_department.png" class="regedit_department_pic">
									<select id="department_select" name="department_select">
										<option value="">请选择专业</option>
										<%
											int i=0;				
											ArrayList<String> dept_list=(ArrayList<String>)request.getAttribute("dept_list");
											if(dept_list!=null)
											{
												for(String pre:dept_list)
												{
													%>
														<option value="<%=i++%>"><%=pre %></option>
													<% 
												}
											}
										 %>
									</select>
									<span id="department_tip"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<a href="#" class="regedit_next" id="regedit_next_2">
									NEXT
								</a>
							</td>
						</tr>
					</table>
				</div>
				<div id="regedit_content3">
					<table class="regedit_table">
						<tr>
							<td colspan="3">
								<a href="#" class="regedit_welcome">
									Regedit
								</a>
							</td>
						</tr>
						<tr>
							<td>
								<a href="#" class="regedit_step">
									1
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step">
									2
								</a>
							</td>
							<td>
								<a href="#" class="regedit_step active">
									3
								</a>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_class_div">
									<img src="images/regedit_class.png" class="regedit_class_pic">
									<select id="class_select" name="class_select"> 
										<option value="0">请选择班级</option>
										<%
											ArrayList<String> class_list=(ArrayList<String>)request.getAttribute("class_list");
											if(class_list!=null)
											{
												for(String pre:class_list)
												{
													out.println("<option value='"+pre+"'>"+pre+"</option>");
												}
											}
											
										 %>
									</select>
									<span id="class_tip"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_phone_div">
									<img src="images/regedit_phone.png" class="regedit_phone_pic">
									<input type="text" name="regedit_phone" id="regedit_phone" placeholder="PHONE">
									<span id="phone_tip"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3"> 
								<span id="submit_check_tip">
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="regedit_submit_div">
									<input type="submit" name="" id="regedit_submit" value="Regedit">
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>