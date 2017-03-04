package UserAction;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOIMP.CourseDAOIMP;
import DAOIMP.JudgeDAOIMP;
import DAOIMP.StudentDAOIMP;
import Factory.Factory;
import Main.Course;
import Main.Judge;
import Main.Student;

public class action extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String action=request.getParameter("action");
			/*action==null 要做判断*/
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session=request.getSession();
			StudentDAOIMP sd=Factory.getFactoryMysql().getStudentDAO();
			CourseDAOIMP cd=Factory.getFactoryMysql().getCourseDAO();
			JudgeDAOIMP	jd=Factory.getFactoryMysql().getJudgeDAO();
			ArrayList<String> dept_list=new ArrayList<String>();
			ArrayList<String> class_list=new ArrayList<String>();
			dept_list=sd.selectdepartment();
			class_list=sd.selectclasses();
			if(action!=null)
			{
				/*预加载*/
				if(action.equals("init"))
				{
					request.setAttribute("dept_list", dept_list);
					request.setAttribute("class_list", class_list);
					request.getRequestDispatcher("regedit.jsp").forward(request, response);
				}
				/*登录验证*/
				if(action.equals("login_action"))
				{
					String username=request.getParameter("username");
			    	String password=request.getParameter("password");
			    	String name="";
			    	String message="";
			    	if(username.length()<8)
			    	{
			    		message="用户名格式不正确";
			    		request.setAttribute("message",message);
			    		request.getRequestDispatcher("login.jsp").forward(request, response);
			    	}
					else
					{
						if(password.length()<8)
						{
							message="密码格式不正确";
							request.setAttribute("message",message);
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
						else
						{
							Student stu=sd.select(username);
							if(stu==null)
							{
								message="用户名不存在";
								request.setAttribute("message",message);
								request.getRequestDispatcher("login.jsp").forward(request, response);
							}
							else
							{
								if(!stu.getS_pwd().equals(password))
								{
									message="密码不正确";
									request.setAttribute("message",message);
									request.getRequestDispatcher("login.jsp").forward(request, response);
								}
								else
								{
									name=stu.getS_name();
									session.setAttribute("username", username);
									session.setAttribute("password", password);
									session.setAttribute("name", name);
									request.getRequestDispatcher("index.jsp").forward(request, response);
								}
							}
						}
					}
				}
				/*注册验证*/
				if(action.equals("regedit_action"))
				{
					String message=""; 
			    	String username=request.getParameter("regedit_username");
			    	String password=request.getParameter("regedit_password");
			    	String password_confirm=request.getParameter("regedit_password_confirm");
			    	if(username.length()<8)
			    	{
			    		message="用户名格式不正确";
			    		request.setAttribute("message", message);
			    		request.getRequestDispatcher("regedit.jsp").forward(request, response);
			    	}
			    	else
			    	{
			    		if(password.length()<8)
			    		{
			    			message="密码格式不正确";
				    		request.setAttribute("message", message);
				    		request.getRequestDispatcher("regedit.jsp").forward(request, response);
			    		}
			    		else
			    		{
			    			Student stu=sd.select(username);
			    			if(stu!=null)
			    			{
			    				message="用户名已存在";
					    		request.setAttribute("message", message);
					    		request.getRequestDispatcher("regedit.jsp").forward(request, response);
			    			}
			    			else
			    			{
			    				if(!password.equals(password_confirm))
			    				{
			    					message="两次密码输入不一致";
						    		request.setAttribute("message", message);
						    		request.getRequestDispatcher("regedit.jsp").forward(request, response);
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
									if(sd.add(new_stu))
									{
										message="注册成功,请登录!";
									}
									else
									{
										message="注册失败!";
									}
									request.setAttribute("message", message);
			    					request.getRequestDispatcher("regedit.jsp").forward(request, response);
			    				}
			    			}
			    		}
			    	}
				}
				/*查询课程*/
				int interval=3;
				int count;
				int page=1;
				int start;
				int thisPage;
				if(action.equals("query_course"))
				{
					start=0;
					thisPage=1;		
					String username=(String)session.getAttribute("username");
					count=cd.getCourseCount(username);
					page=1;
					if(count%interval==0)
					{
						page=count/interval;
					}
					else
					{
						page=count/interval+1;
					}
					ArrayList<Course> course_select_list=cd.querycourse(username,start,interval);
					request.setAttribute("course_select_list", course_select_list);
					request.setAttribute("thisPage",thisPage );
					request.setAttribute("page",page );
					request.setAttribute("start", start);
					request.getRequestDispatcher("query.jsp").forward(request, response);
				}			
				/*分页查询课程*/
				if(action.equals("get_course"))
				{
					String username=(String)session.getAttribute("username");
					count=cd.getCourseCount(username);
					if(count%interval==0)
					{
						page=count/interval;
					}
					else
					{
						page=count/interval+1;
					}
					
					start=Integer.parseInt(request.getParameter("start"));
					thisPage=Integer.parseInt(request.getParameter("nowPage"));
					if(page==thisPage)
					{
						interval=count%interval;
					}
					ArrayList<Course> course_select_list=cd.querycourse(username,start,interval);
					request.setAttribute("course_select_list", course_select_list);
					request.setAttribute("thisPage",thisPage );
					request.setAttribute("page",page);
					request.setAttribute("start", start);
					request.getRequestDispatcher("query.jsp").forward(request, response);
				}
				/*选课*/
				if(action.equals("select_course"))
				{
					ArrayList<Course> course_list=cd.selectcourse();	
					request.setAttribute("course_list", course_list);
					request.getRequestDispatcher("course.jsp").forward(request, response);
				}
				/*插入所选课程*/
				
				if(action.equals("insert_course"))
				{
					boolean tag=true;
					String username=(String)session.getAttribute("username");
					ArrayList<Course> course_list=cd.selectcourse();
					int amount=Integer.parseInt(request.getParameter("amount"));
					for(int i=0;i<amount;i++)
					{
						String isselected[]=request.getParameterValues("checkbox"+i);
						if(isselected!=null)
						{
							if(cd.insertcourse(username, course_list.get(i))==false)
							{
								tag=false;
							}
						}
					}
					request.setAttribute("course_list", course_list);
					request.setAttribute("tag", tag);
					request.getRequestDispatcher("course.jsp").forward(request, response);
					
				}
				/*评教*/
				if(action.equals("judgement"))
				{
					String username=(String)session.getAttribute("username");
					ArrayList<Judge> judge_list=jd.gojudge(username);
					request.setAttribute("judge_list", judge_list);
					request.getRequestDispatcher("judge.jsp").forward(request, response);
				}
				/*插入评教*/
				if(action.equals("insert_judge"))
				{
					
					boolean tag=false;
					String username=(String)session.getAttribute("username");
					ArrayList<Judge> judge_list=jd.gojudge(username);
					int amount=Integer.parseInt(request.getParameter("amount"));
					int i;
					for(i=0;i<amount;i++)
					{
						String selectLook[]=request.getParameterValues("selectLook"+i);
						String textLook=request.getParameter("textLook"+i);
						String selectHeight[]=request.getParameterValues("selectHeight"+i);
						String textHeight=request.getParameter("textHeight"+i);
						String selectAttitude[]=request.getParameterValues("selectAttitude"+i);
						String textAttitude=request.getParameter("textAttitude"+i);
						String selectWay[]=request.getParameterValues("selectWay"+i);
						String textWay=request.getParameter("textWay"+i);
						String selectAtmos[]=request.getParameterValues("selectAtmos"+i);
						String textAtmos=request.getParameter("textAtmos"+i);
						String advice=request.getParameter("advice"+i);
						judge_list.get(i).setT_look(selectLook[0]+' '+textLook);
						judge_list.get(i).setT_height(selectHeight[0]+' '+textHeight);
						judge_list.get(i).setT_attitude(selectAttitude[0]+' '+textAttitude);
						judge_list.get(i).setT_way(selectWay[0]+' '+textWay);
						judge_list.get(i).setT_atmos(selectAtmos[0]+' '+textAtmos);
						judge_list.get(i).setAdvice(advice);
						
					}
					if(i<amount||jd.isJudge(username))
					{
						tag=false;
					}
					else
					{
						tag=true;
						for(int j=0;j<amount;j++)
						{
							jd.insertjudge(username, judge_list.get(j));
						}
					}
					request.setAttribute("judge_list", judge_list);
					request.setAttribute("tag", tag);
					request.getRequestDispatcher("judge.jsp").forward(request, response);
				}
			}
				
			
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
