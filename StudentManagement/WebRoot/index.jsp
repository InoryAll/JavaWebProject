<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%
	String name=(String)session.getAttribute("name");
	String username=(String)session.getAttribute("username");
	String password=(String)session.getAttribute("password");
 %>
<!DOCTYPE html>
<html id="html">
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/index.js"></script>
</head>
<body id="body">
	<form id="init_form" action="useraction" method="post">
		<input type="hidden" id="action" name="action" value="init">
	</form>
	<div id="hide_content_box">
		<div id="hide_content_container">
				<a href="#" id="exit">
					<img src="images/exit.png">
				</a>
			<div id="hide_content">
				<table class="hide_content_table">
				<tr>
					<td colspan="2">
						<a href="#" class="hide_logo">
							Welcome
						</a>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="hide_title">
						<p>Welcome to the TRJ Student Mangement System.</p>
						<p>You can choose what you do by select the button following.</p>
						<p id="user_info">
						<%
							if(name!=null)
							out.print("<strong>"+"Welcome You!"+"&nbsp;&nbsp;&nbsp;&nbsp;"+username+"&nbsp;&nbsp;&nbsp;&nbsp;"+name+"</strong>"); 
						%>
						</p>
					</td>
				</tr>
				<tr>
					<td class="function">
						<a href="index.jsp">
							<p class="head">Home</p>
							<p class="detail">Go to the home page</p>
						</a>
						
					</td>
					<td class="function">
						<a href="login.jsp">
							<p class="head">Login</p>
							<p class="detail">Login the system</p>
						</a>
						
					</td>
				</tr>
				<tr>
					<td class="function">
						<a href="#" id="go_to_regedit">
							<p class="head">Regedit</p>
							<p class="detail">Regedit a user</p>
						</a>
						
					</td>
					<td class="function">
						<a href="#">
							<p class="head">Contact</p>
							<p class="detail">Contact us</p>
						</a>
						
					</td>
				</tr>
				</table>
			</div>
		</div>
	</div>
	<div id="header">
		<ul class="pic_tab">
			<li class="item1">
				<a href="#" id="menu">
					<img src="images/menu.png">
				</a>
				<a href="#" id="precious">
					<img src="images/precious.png">
				</a>
				<a href="#" id="next">
					<img src="images/next.png">
				</a>
				<table class="top_container">
					<tr>
						<td>
							<h1 class="top_tag">
								B
							</h1>
						</td>
					</tr>
					<tr>
						<td>
							<h1 class="title">
								Student Mangement
							</h1>
						</td>
					</tr>
					<tr>
						<td>
							<p class="introduction">
								A new system for the student and the teacher.
							</p>
						</td>
					</tr>
				</table>
			</li>
		</ul>
	</div>
	<div id="main">
		<div id="student_search_container">
			<div id="student_search">
				<img src="images/devices.png" class="student_search_pic">
				<dl class="student_search_list">
					<dt>Student Lesson Search</dt>
					<dd>You can get the information about the lesson which you choose.</dd>
					<dd>If you want to get the information</dd>
					<dd>Please push the following button</dd>
					<dd id="student_search_btn_container">
						<a href="javascript:;" id="student_search_btn">
							Get More
						</a>
					</dd>
				</dl>
			</div>
		</div>
		<div id="student_select_container">
			<div id="student_select">
				<dl class="student_select_list">
					<dt>Student Lesson Select</dt>
					<dd>You can select your lesson and teacher here.</dd>
					<dd>If you want to get the information</dd>
					<dd>Please push the following button</dd>
					<dd id="student_select_btn_container">
						<a href="javascript:;" id="student_select_btn">
							Get More
						</a>
					</dd>
				</dl>
				<img src="images/photoshop.png" class="student_select_pic">
			</div>
		</div>
		<div id="student_judgement_container">
			<div id="student_judgement">
				<img src="images/tools.png" class="student_judgement_pic">
				<dl class="student_judgement_list">
					<dt>Student Judgement</dt>
					<dd>You can judge the teacher which you have lesson with him.</dd>
					<dd>If you want to get the information</dd>
					<dd>Please push the following button</dd>
					<dd id="student_judgement_btn_container">
						<a href="javascript:;" id="student_judgement_btn">
							Get More
						</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div id="footer">
		<table class="footer_container">
			<tr>
				<td colspan="3">
					<a href="#header" class="top" id="top">
						<img src="images/top.png">
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="footer_title">
					<h1>"The more I learn,the less I realize I know."</h1>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="copy">
					<p>Copyright &copy; 2016.9.16</p>
					<p>TRJ Management Company&reg;</p>
				</td>
			</tr>
			<tr>
				<td class="footer_content">
					<p>From books of</p>
					<p>mazes that I drew</p>
					<p>and sold in</p>
					<p>kindergarden,to the</p>
					<p>obsessively detailed</p>
					<p>pencil drawings I did</p>
					<p>in high school,I've</p>
					<p>always been an</p>
					<p>artist.So naturally I</p>
					<p>pursued a job in</p>
					<p>graphic design after</p>
					<p>college</p>
				</td>
				<td class="footer_content">
					<p>Print design didn't</p>
					<p>cut it though.It didn't</p>
					<p>satisfy the left-brain</p>
					<p>itch that craved more</p>
					<p>analytical</p>
					<p>challenges.I started</p>
					<p>teaching myself the</p>
					<p>web trade and</p>
					<p>snagged a great job</p>
					<p>in Nashville where I</p>
					<p>got to focus on digtal</p>
					<p>experiences.</p>
				</td>
				<td class="footer_content">
					<p>As I grew in web</p>
					<p>design,the world of</p>
					<p>product design</p>
					<p>emerged.Again I</p>
					<p>embarked on the</p>
					<p>journey of new</p>
					<p>challenges.And I</p>
					<p>now konw that the</p>
					<p>journey is the</p>
					<p>adventure,and</p>
					<p>stopping isn't an</p>
					<p>option.Onward and</p>
					<p>upward.</p>
				</td>
			</tr>
		</table>
	</div>
</body>
<% 
	if(username==null)
	{
		out.println("<script>confirm('请您先登录!');</script>");
	}
%>
</html>