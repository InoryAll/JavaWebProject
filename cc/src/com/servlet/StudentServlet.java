package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Course;
import com.entity.Person;
import com.entity.Student;
import com.entity.Teacher;
import com.service.CourseService;
import com.service.PersonService;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.JsonUtil;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 2812036443380895818L;
	private StudentService studentService = new StudentService();
	private PersonService personService = new PersonService();
	private TeacherService teacherService = new TeacherService();
	private CourseService courseService = new CourseService();
	private List<String> tempList = null;
	private HttpSession session;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	//@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 初始化操作类
		session = request.getSession();
		Enumeration<String> element = null;
		Map<String, Object> map = null;
		// 操作列表
		/*
		 * login--用户登录
		 * register--用户注册 
		 * modify--修改信息 
		 * getcourse -- 获取课程信息
		 * getteacher -- 获取教师信息
		 */
		String action = "";
		boolean gotos = false;
		action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		switch (action) {
		case "register":
			element = request.getParameterNames();
			map = new HashMap<String, Object>();
			while (element.hasMoreElements()) {
				String eName = element.nextElement();
				String eValue = request.getParameter(eName);
				if(eName.equals("id") && personService.isExist(eValue)){
					out.write("{\"code\":\"0\",\"message\":\"用户名重复\"}");
					gotos = true;
					break;
				}
				map.put(eName, eValue);
			}if(gotos) break;
			map.put("dflag", 0);
			map.put("pflag", 0);
			try {
				Class<?> cls = Student.class;
				Constructor<?> con = cls.getConstructor(Map.class);
				Object object = con.newInstance(map);
				studentService.insert((Student) object);
				out.write("{\"code\":\"1\",\"message\":\"注册成功\"}");
			} catch (Exception e) {
				e.printStackTrace();
			}break;
		case "modify":
			Object person = null;
			boolean ReturnMessage = false;
			boolean first = (request.getParameter("first").equals("true")) ? true : false;
			Class<?> cls = null;
			try {
				cls = Student.class;
				person = cls.newInstance();
				person = studentService.findStudentById(((Person) session.getAttribute("loginUser")).getId());
				if(first) out.write(JsonUtil.getJson((Student)person));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!first) {// 如果不是第一次进入
				cls = Student.class;
				element = request.getParameterNames();
				while (element.hasMoreElements()) {
					String eName = element.nextElement();
					String eValue = request.getParameter(eName);
					String function = "set"
							+ Character.toUpperCase(eName.toCharArray()[0])
							+ eName.substring(1);
					Method method;
					try {
						method = cls.getMethod(function, String.class);
						Object[] parameter = { eValue };
						method.invoke(person, parameter);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						continue;
					} catch (SecurityException e) {
						e.printStackTrace();
					}
				}
				ReturnMessage = studentService.updateStudent((Student) person);
				tempList = new ArrayList<String>();
				tempList.add(JsonUtil.getJson((Student)person));
				if(ReturnMessage) tempList.add("{\"code\":\"1\",\"message\":\"修改成功\"}");
				else tempList.add("{\"code\":\"0\",\"message\":\"修改失败，请联系管理员\"}");
				out.write(JsonUtil.groupJeson(tempList));
			}
			break;
		case "getcourse":
			String courseId = request.getParameter("courseId");
			Course course = courseService.findOneCourse(Integer.parseInt(courseId));
			out.write(JsonUtil.getJson(course));
			break;
		case "getteacher":
			String teacherId = request.getParameter("teacherId");
			Teacher teacher = teacherService.findTeacherById(teacherId);
			out.write(JsonUtil.getJson(teacher));
			break;
		case "logout":
			session.removeAttribute("loginUser");
			break;
		default:
		}
	}
}
