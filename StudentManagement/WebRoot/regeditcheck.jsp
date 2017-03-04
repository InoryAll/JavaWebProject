<%@page import="Main.Student"%>
<%@page import="Factory.Factory"%>
<%@page import="DAOIMP.StudentDAOIMP"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<html>
  <head> 
    <title></title>
  </head>
  
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
    	String message=""; 
    	String username=request.getParameter("regedit_username");
    	String password=request.getParameter("regedit_password");
    	String password_confirm=request.getParameter("regedit_password_confirm");
    	StudentDAOIMP sd=Factory.getFactoryMysql().getStudentDAO();
		ArrayList<String> dept_list=new ArrayList<String>();
		ArrayList<String> class_list=new ArrayList<String>();
		dept_list=sd.selectdepartment();
		class_list=sd.selectclasses();
    	if(username.length()<8)
    	{
    		message="用户名格式不正确";
    		request.setAttribute("message", message);
    		%>
    		<jsp:forward page="regedit.jsp"></jsp:forward>
    		<% 
    	}
    	else
    	{
    		if(password.length()<8)
    		{
    			message="密码格式不正确";
	    		request.setAttribute("message", message);
	    		%>
	    		<jsp:forward page="regedit.jsp"></jsp:forward>
	    		<% 
    		}
    		else
    		{
    			Student stu=sd.select(username);
    			if(stu!=null)
    			{
    				message="用户名已存在";
		    		request.setAttribute("message", message);
		    		%>
		    		<jsp:forward page="regedit.jsp"></jsp:forward>
		    		<% 
    			}
    			else
    			{
    				if(!password.equals(password_confirm))
    				{
    					message="两次密码输入不一致";
			    		request.setAttribute("message", message);
			    		%>
			    		<jsp:forward page="regedit.jsp"></jsp:forward>
			    		<% 
    				}
    				else
    				{
    					session.setAttribute("username",username);
    					session.setAttribute("password", password);
    					String sex=request.getParameter("sex");
    					String name=request.getParameter("regedit_name");
    					String dept=request.getParameter("department_select");
    					String classes=request.getParameter("class_select");
    					String tel=request.getParameter("regedit_phone");
    					Student new_stu=new Student();
		    			new_stu.setS_no(username);
		    			new_stu.setS_pwd(password);
		    			new_stu.setS_name(name);
		    			if(sex.equals("male"))
		    			{
		    				new_stu.setS_sex("男");
		    			}
		    			else
		    			{
		    				new_stu.setS_sex("女");
		    			}
		    			int dept_index=Integer.parseInt(dept);
		    			String deptment=dept_list.get(dept_index);
		    			new_stu.setS_dept(deptment);
		    			new_stu.setS_class(classes);
		    			new_stu.setS_connect(tel);
						sd.add(new_stu);  					
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
