<%@page import="Main.Student"%>
<%@page import="DAOIMP.StudentDAOIMP"%>
<%@page import="Factory.Factory"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<html>
  <head>  
    <title></title>
  </head>
  
  <body>
    <%
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	String message="";
    	if(username.length()<8)
    	{
    		message="用户名格式不正确";
    		request.setAttribute("message",message);
    		%>
				<jsp:forward page="login.jsp"></jsp:forward>
			<%
    	}
		else
		{
			if(password.length()<8)
			{
				message="密码格式不正确";
				request.setAttribute("message",message);
				%>
					<jsp:forward page="login.jsp"></jsp:forward>
				<%
			}
			else
			{
				StudentDAOIMP sd=Factory.getFactoryMysql().getStudentDAO();
				Student stu=sd.select(username);
				if(stu==null)
				{
					message="用户名不存在";
					request.setAttribute("message",message);
					%>
						<jsp:forward page="login.jsp"></jsp:forward>
					<%
				}
				else
				{
					if(stu.getS_pwd()!=password)
					{
						message="密码不正确";
						request.setAttribute("message",message);
						%>
						<jsp:forward page="login.jsp"></jsp:forward>
						<%
					}
					else
					{
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						%>
						<jsp:forward page="index.jsp"></jsp:forward>
						<%
						
					}
				}
			}
		}
     %>
  </body>
</html>
