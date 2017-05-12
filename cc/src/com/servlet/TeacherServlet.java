package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.BgCourse;
import com.entity.Course;
import com.entity.Pager;
import com.entity.Person;
import com.entity.SCFactRelation;
import com.entity.SCReRelation;
import com.entity.Student;
import com.entity.Teacher;
import com.service.CourseService;
import com.service.SCFactRelationService;
import com.service.SCReRelationService;
import com.service.StudentService;
import com.service.TeacherService;
import com.util.JsonUtil;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherService();
	private CourseService courseService = new CourseService();
	private SCReRelationService screRelationService = new SCReRelationService();
	private SCFactRelationService scfactRelationService = new SCFactRelationService();
	private StudentService studentService = new StudentService();
	private List<String> tempList = null;
	private HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 初始化操作类
		session = request.getSession();
		Enumeration<String> element = null;
		// 操作列表
		/*
		 * modify--修改信息 
		 * add--添加课程
		 * delete--删除课程
		 * manage--学生管理 
		 * record--登记成绩
		 * register--教师注册
		 */
		String action = "";
		boolean first = true;
		action = request.getParameter("action");
		if(action == null){
			action = "register";
		}else 
			first = request.getParameter("first").equals("true") ? true : false;
		PrintWriter out = response.getWriter();
		switch (action) {
		case "register": 
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List<FileItem>  item=new ArrayList<FileItem>();
			Class<?> cls = Teacher.class;
			Date time = new Date();

			Object obj = null;
			try {
				item = upload.parseRequest(request);
				obj = cls.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}for(FileItem x : item){
				if(x.isFormField()){
					String function = "set" 
							+ Character.toUpperCase(x.getFieldName().toCharArray()[0])
							+ x.getFieldName().substring(1);
					Object[] parameter = {x.getString("UTF-8")};
					if(x.getFieldName().equals("image")) parameter[0] = time.toString();
					try {
						Method method = cls.getMethod(function, String.class);
						method.invoke(obj, parameter);
					} catch (NoSuchMethodException | SecurityException e) {
						continue;
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}else{
					String fileName=x.getName();
					String ext=fileName.substring(fileName.lastIndexOf(".")+1);
					String path=this.getServletConfig().getServletContext().getRealPath("/");
					File file=new File(path+"/head",time.getTime()+"."+ext);
					((Teacher)obj).setImage(file.getName());
					try {
						x.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			teacherService.teacherRegister((Teacher)obj);
			out.write(JsonUtil.getJson("ReturnMessage", "注册成功"));
			break;
		case "add":
			boolean ReturnMessage = false;
			Pager <Teacher> tempTeachers = new Pager<Teacher>();
			Pager <Course> CourseResult = new Pager<Course>();
			int pageNum = 1;
			int pageSize = 60;
			Course CourseModel = new Course();
			Teacher TeacherModel = new Teacher();
			TeacherModel.setId(((Person) session.getAttribute("loginUser")).getId());
			tempTeachers = teacherService.findTeacherForPager(TeacherModel, pageNum, pageSize);
			CourseModel.setTeacher(tempTeachers.getDataList().get(0));
			CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
			if(!first){
				Object object = null;
				cls  = null;
				try{
					cls = Course.class;
					object = cls.newInstance();
					Person loginUser = (Person) session.getAttribute("loginUser");
					((Course)object).setTeacher(teacherService.findTeacherById(loginUser.getId()));
				} catch (Exception e) {
					e.printStackTrace();
				}element = request.getParameterNames();
				while (element.hasMoreElements()) {
					String eName = element.nextElement();
					String eValue = request.getParameter(eName);
					if(!eName.substring(0, 1).equals("c")) continue;
					else 
						eName = eName.substring(1);
					String function = "set"
							+ Character.toUpperCase(eName.toCharArray()[0])
							+ eName.substring(1);
					Method method;
					try {
						method = cls.getMethod(function, String.class);
						Object[] parameter = { eValue };
						method.invoke(object, parameter);
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
				}CourseResult.getDataList().add((Course)object);
				courseService.addCourse((Course)object);
			}out.write(JsonUtil.getJson("CourseResult", CourseResult.getDataList()));
			break;
		case "modify":
			Object person = null;
			ReturnMessage = false;
			cls = Teacher.class;
			try {
				person = cls.newInstance();
				person = teacherService.findTeacherById(((Person) session.getAttribute("loginUser")).getId());
			} catch (Exception e) {
				e.printStackTrace();
			} 
			if(first) out.write(JsonUtil.getJson((Teacher) person));
			else{// 如果不是第一次进入
				element = request.getParameterNames();
				while (element.hasMoreElements()) {
					String eName = element.nextElement();
					String eValue = request.getParameter(eName);
					String function = "set"+ Character.toUpperCase(eName.toCharArray()[0])+eName.substring(1);
					Method method;
					try {
						method = cls.getMethod(function, String.class);
						Object[] parameter = {eValue};
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
				ReturnMessage = teacherService.updateTeacher((Teacher) person);
				tempList = new ArrayList<String>();
				tempList.add(JsonUtil.getJson((Teacher) person));
				tempList.add(JsonUtil.getJson("ReturnMessage", ReturnMessage ? "true" : "false"));
				out.write(JsonUtil.groupJeson(tempList));
			}
			break;
		case "delete":
			ReturnMessage = false;
			if(first){
				tempTeachers = new Pager<Teacher>();
				CourseResult = new Pager<Course>();
				pageNum = 1;
				pageSize = 60;
				CourseModel = new Course();
				TeacherModel = new Teacher();
				TeacherModel.setId(((Person) session.getAttribute("loginUser")).getId());
				tempTeachers = teacherService.findTeacherForPager(TeacherModel, pageNum, pageSize);
				CourseModel.setTeacher(tempTeachers.getDataList().get(0));
				CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
				out.write(JsonUtil.getJson("CourseResult", CourseResult.getDataList()));
			}else{
				String deleteItem = request.getParameter("delete_item");
				ReturnMessage = courseService.deleteCourse(Integer.parseInt(deleteItem));
				out.write(JsonUtil.getJson("ReturnMessage", ReturnMessage ? "true" : "false"));
			}
			break;
		case "manage":
			pageNum = 1;
			pageSize = 20;
			Person loginUser = (Person) session.getAttribute("loginUser");
			CourseModel = new Course();
			Teacher t = teacherService.findTeacherById(loginUser.getId());
			CourseModel.setTeacher(t);
			CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
			List<String> CourseName = new ArrayList<String>();
			for(Course x :CourseResult.getDataList()) CourseName.add(x.getName());
			if(first)out.write(JsonUtil.getJson("CourseName", CourseName));
			else{
				Pager<SCReRelation> tempscrerelation = new Pager<SCReRelation>();
				pageNum = 1;
				pageSize = 1;
				loginUser = (Person) session.getAttribute("loginUser");
				String tid = loginUser.getId();
				String cname = request.getParameter("manage_cname");
				CourseModel = new Course();
				CourseModel.setName(cname);
				t = teacherService.findTeacherById(tid);
				CourseModel.setTeacher(t);
				CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
				String CourseId = String.valueOf(CourseResult.getDataList().get(0).getId());
				pageSize = 60;
				SCReRelation sCReRelationModel = new SCReRelation();
				sCReRelationModel.setCid(CourseResult.getDataList().get(0).getId());
				tempscrerelation = screRelationService.findSCReRelationForPager(sCReRelationModel, pageNum, pageSize);
				Pager<Student> studentResult = new Pager<Student>();
				studentResult.setTotalRecord(tempscrerelation.getTotalRecord());
				studentResult.setPageSize(tempscrerelation.getPageSize());
				studentResult.setCurrentPage(tempscrerelation.getCurrentPage());
				studentResult.setTotalPage(tempscrerelation.getTotalPage());
				for(SCReRelation x : tempscrerelation.getDataList()) studentResult.getDataList().add(studentService.findStudentById(x.getSid()));
				tempList = new ArrayList<String>();
				tempList.add(JsonUtil.getJson("studentResult", studentResult.getDataList()));
				tempList.add(JsonUtil.getJson("CourseId", CourseId));
				out.write(JsonUtil.groupJeson(tempList));
			}
			break;
		case "record":
			pageNum = 1;
			pageSize = 20;
			loginUser = (Person) session.getAttribute("loginUser");
			if(first){
				CourseModel = new Course();
				t = teacherService.findTeacherById(loginUser.getId());
				CourseModel.setTeacher(t);
				CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
				CourseName = new ArrayList<String>();
				for(Course x :CourseResult.getDataList()) CourseName.add(x.getName());
				out.write(JsonUtil.getJson("CourseName", CourseName));
			}else{
				Pager<SCFactRelation> scfactRelation = new Pager<SCFactRelation>();
				pageNum = 1;
				pageSize = 1;
				String tid = loginUser.getId();
				String cname = request.getParameter("manage_cname");
				CourseModel = new Course();
				CourseModel.setName(cname);
				t = teacherService.findTeacherById(tid);
				CourseModel.setTeacher(t);
				CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
				String CourseId = String.valueOf(CourseResult.getDataList().get(0).getId());
				pageSize = 60;
				SCFactRelation SCFactRelationModel = new SCFactRelation();
				SCFactRelationModel.setCid(CourseResult.getDataList().get(0).getId());
				scfactRelation = scfactRelationService.findSCFactRelationForPager(SCFactRelationModel, pageNum, pageSize);
				Pager<Student> studentResult = new Pager<Student>();
				studentResult.setTotalRecord(scfactRelation.getTotalRecord());
				studentResult.setPageSize(scfactRelation.getPageSize());
				studentResult.setCurrentPage(scfactRelation.getCurrentPage());
				studentResult.setTotalPage(scfactRelation.getTotalPage());
				for(SCFactRelation x : scfactRelation.getDataList()) studentResult.getDataList().add(studentService.findStudentById(x.getSid()));
				tempList = new ArrayList<String>();
				tempList.add(JsonUtil.getJson("StudentResult", studentResult.getDataList()));
				tempList.add(JsonUtil.getJson("CourseId",CourseId));
				out.write(JsonUtil.groupJeson(tempList));
			}
			break;
		case "mark":
			String remark = request.getParameter("remark");
			String[] remarks = remark.split(",");
			for(String x : remarks){
				String[] parameter = x.split("-");
				SCFactRelation SCFactRelationModel = new SCFactRelation();
				SCFactRelationModel.setCid(Integer.parseInt(parameter[0]));
				SCFactRelationModel.setSid(parameter[1]);
				Pager<SCFactRelation> scfactRelation = new Pager<SCFactRelation>();
				scfactRelation = scfactRelationService.findSCFactRelationForPager(SCFactRelationModel, 1, 1);
				scfactRelation.getDataList().get(0).setRemark(parameter[2]);
				scfactRelationService.updateSCFactRelation(scfactRelation.getDataList().get(0));
			}
			
			out.write(JsonUtil.getJson("ReturnMessage","登记成功"));
			break;
		case "begin":
			if(first){
				loginUser = (Person) session.getAttribute("loginUser");
				Teacher teacher = teacherService.findTeacherById(loginUser.getId());
				CourseModel = new Course();
				CourseModel.setTeacher(teacher);
				CourseModel.setCourseStatus(0);
				pageNum = 1;
				pageSize = 60;
				CourseResult = courseService.findCourseForPager(CourseModel, pageNum, pageSize);
				Integer[] count = new Integer[CourseResult.getTotalRecord()];
				List<BgCourse> list = new ArrayList<BgCourse>();
				for(int i = 0; i< count.length; i++){
					Course ct = CourseResult.getDataList().get(i);
					count[i] = teacherService.totalNumberbyCid(ct.getId());
					BgCourse x = new BgCourse(ct);
					x.setTotalnumber(count[i]);
					list.add(x);
				}
				out.write(JsonUtil.getJson("CourseResult", list));
			}else{	
				int cid = Integer.parseInt(request.getParameter("cid"));
				Course course = courseService.findOneCourse(cid);
				course.setCourseStatus(1);
				courseService.updateCourse(course);
				out.write(JsonUtil.getJson("ReturnMessage", "开课成功"));
			}
			break; 
		}
		
	}

}