<%@page import="Main.Judge"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%
	String name=(String)session.getAttribute("name");
	String username=(String)session.getAttribute("username");
	String password=(String)session.getAttribute("password");
	ArrayList<Judge> judge_list=new ArrayList<Judge>();
	judge_list=(ArrayList<Judge>)request.getAttribute("judge_list");
	int i=0;
	Boolean tag=(Boolean)request.getAttribute("tag");
 %>
<!DOCTYPE html>
<html id="html">
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/judge.css">
	<script type="text/javascript" src="js/judge.js"></script>
</head>
<%
	if(tag!=null)
	{
		if(tag==false)
		{
			out.println("<script>confirm('评教失败');</script>");
		}
		else
		{
			out.println("<script>confirm('评教成功');</script>");
		}
	} 
%>
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
			<img src="images/tools.png" class="student_judge_pic">
			<dl class="student_judge_list">
				<dt>Student Judgement</dt>
				<dd>You can judge the teacher which you have lesson with him.</dd>
				<dd>If you want to get the information</dd>
				<dd>Please push the following button</dd>
			</dl>
		</div>
	</div>
	<div id="main">
		<div id="main_content">
			<form action="useraction" method="post">
			<input type="hidden" name="action" value="insert_judge">
				<table class="student_judge_table">
						<thead>
							<tr>
								<th>课号</th>
								<th>课名</th>
								<th>学分</th>
								<th>教师号</th>
								<th>教师</th>
								<th>着装</th>
								<th>水平</th>
								<th>态度</th>
								<th>方法</th>
								<th>气氛</th>
								<th>建议</th>
							</tr>
						</thead>
						<tbody>
							<% 
							if(judge_list!=null)
								{
									for(i=0;i<judge_list.size();i++)
									{
										Judge pre=judge_list.get(i);
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
										out.println("<select name=\'selectLook"+i+"\'>");
										out.println("<option value='A'>A</option>");
										out.println("<option value='B'>B</option>");
										out.println("<option value='C'>C</option>");
										out.println("<option value='D'>D</option>");
										out.println("</select>");
										out.println("<input type=\'textbox\' name=\'textLook"+i+"\'"+" id=\'textLook"+i+"\' placeholder=\'请输入理由\' >");
										out.println("</td>");
										
										out.println("<td>");
										out.println("<select name=\'selectHeight"+i+"\'>");
										out.println("<option value='A'>A</option>");
										out.println("<option value='B'>B</option>");
										out.println("<option value='C'>C</option>");
										out.println("<option value='D'>D</option>");
										out.println("</select>");
										out.println("<input type=\'textbox\' name=\'textHeight"+i+"\'"+" id=\'textHeight"+i+"\' placeholder=\'请输入理由\' >");
										out.println("</td>");
										
										out.println("<td>");
										out.println("<select name=\'selectAttitude"+i+"\'>");
										out.println("<option value='A'>A</option>");
										out.println("<option value='B'>B</option>");
										out.println("<option value='C'>C</option>");
										out.println("<option value='D'>D</option>");
										out.println("</select>");
										out.println("<input type=\'textbox\' name=\'textAttitude"+i+"\'"+" id=\'textAttitude"+i+"\' placeholder=\'请输入理由\' >");
										out.println("</td>");
										
										out.println("<td>");
										out.println("<select name=\'selectWay"+i+"\'>");
										out.println("<option value='A'>A</option>");
										out.println("<option value='B'>B</option>");
										out.println("<option value='C'>C</option>");
										out.println("<option value='D'>D</option>");
										out.println("</select>");
										out.println("<input type=\'textbox\' name=\'textWay"+i+"\'"+" id=\'textWay"+i+"\' placeholder=\'请输入理由\' >");
										out.println("</td>");
										
										out.println("<td>");
										out.println("<select name=\'selectAtmos"+i+"\'>");
										out.println("<option value='A'>A</option>");
										out.println("<option value='B'>B</option>");
										out.println("<option value='C'>C</option>");
										out.println("<option value='D'>D</option>");
										out.println("</select>");
										out.println("<input type=\'textbox\' name=\'textAtmos"+i+"\'"+" id=\'textAtmos"+i+"\' placeholder=\'请输入理由\' >");
										out.println("</td>");
										
										out.println("<td>");
										out.println("<input type=\'text\' name=\'advice"+i+"\'>");
										out.println("</td>");
										
										out.println("</tr>");
									}
										/*显示页码*/
										out.println("<tr>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("<td>");
										out.println("</td>");
										out.println("</tr>");
							}
							%>
							 <tr>
							 	<td colspan="11">
							 		<input type="submit" id="judge_submit" value="提&nbsp;&nbsp;交">
							 	</td>
							 </tr>
						</tbody>
				</table>
				<input type="hidden" name="amount" value="<%=i%>">
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