<%@page import="Factory.Factory"%>
<%@page import="DAOIMP.CourseDAOIMP"%>
<%@page import="Main.Course"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%	
	String name=(String)session.getAttribute("name");
	String username=(String)session.getAttribute("username");
	String password=(String)session.getAttribute("password");
	ArrayList<Course> course_select_list=new ArrayList<Course>();
	Integer thisPage=(Integer)request.getAttribute("thisPage");
	Integer start=(Integer)request.getAttribute("start");
	Integer pages=(Integer)request.getAttribute("page");
	if(pages==0||pages==null)
		thisPage=0;
	course_select_list=(ArrayList<Course>)request.getAttribute("course_select_list");
 %>
<!DOCTYPE html>
<html id="html">
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/query.css">
	<script type="text/javascript" src="js/query.js"></script>
</head>
<body id="body">	
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
						<a href="regedit.jsp">
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
		<a href="#" id="menu">
			<img src="images/menu.png">
		</a>
		<div id="title">
			<img src="images/devices.png" class="student_search_pic">
			<dl class="student_search_list">
				<dt>Student Lesson Search</dt>
				<dd>You can get the information about the lesson which you choose.</dd>
				<dd>If you want to get the information</dd>
				<dd>Please push the following button</dd>
			</dl>
		</div>
	</div>
	<div id="main">
		<div id="main_content">
			<form action="useraction" method="post" id="queryForm">
				<input type="hidden" name="start" id="start" value=<%=start %>>
				<input type="hidden" name="nowPage" id="nowPage" value=<%=thisPage %>>
				<input type="hidden" name="pages" id="pages" value=<%=pages %> >
				<input type="hidden" name="action" value="get_course">
				<table class="student_query_table">
					<thead>
						<tr>
							<th>课号</th>
							<th>课名</th>
							<th>学分</th>
							<th>教师号</th>
							<th>教师</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<% 
						if(course_select_list!=null)
							{
								for(int i=0;i<course_select_list.size();i++)
								{
									Course pre=course_select_list.get(i);
									if(i%2==0)
									{
										out.println("<tr");
										out.println("class=\"float\"");
										out.println(">");
									}
									else
									{
										out.println("<tr");
										out.println("class=\"double\"");
										out.println(">");
									}
									out.println("<td>");
									out.println(pre.getC_no());
									out.println("</td>");				
									out.println("<td>");
									out.println(pre.getC_name());
									out.println("</td>");
									out.println("<td>");
									out.println(pre.getC_score());
									out.println("</td>");
									out.println("<td>");
									out.println(pre.getT_no());
									out.println("</td>");
									out.println("<td>");
									out.println(pre.getT_name());
									out.println("</td>");
									out.println("<td>");
									out.println("已选");
									out.println("</td>");
									out.println("</tr>");
								}
						}
						%>
						<tr id="pageTab">
							<td colspan='2'>
								<a href="javascript:;" id="prePage">上一页</a>
							</td>
							<td colspan='2'>
								<span id="page">
								<%=thisPage %>/<%=pages %>
								</span>
							</td>
							<td colspan='2'>
								<a href="javascript:;" id="nextPage">下一页</a>
							</td>
						</tr>
						<tr>
						 	<td colspan="6">
						 		<a href="index.jsp" id="course_query_back">返回主页</a>
						 	</td>
						</tr>
					</tbody>
				</table>
			</form>
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
</html>