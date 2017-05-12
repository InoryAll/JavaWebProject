package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.Course;
import com.entity.Pager;
import com.entity.Person;
import com.entity.SCFactRelation;
import com.entity.SCReRelation;
import com.entity.Teacher;
import com.service.CourseService;
import com.service.SCFactRelationService;
import com.service.SCReRelationService;
import com.service.TeacherService;
import com.util.JsonUtil;

public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = -7733335237330732615L;
	private CourseService courseService = new CourseService();
	private TeacherService teacherService = new TeacherService();
	private SCReRelationService SCRerelationService = new SCReRelationService();
	private SCFactRelationService SCFactrelationService =new SCFactRelationService();
	private List<String> tempList = null;
	private HttpSession session;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession();              
		/*操作列表*/
		/* add--添加课程
		 * delete--删除课程
		 * modify--修改课程
		 * query--查询课程
		 * select--选择课程
		 * back --退选课程
		 */
		String action = request.getParameter("action");
		boolean first = request.getParameter("first").equals("true") ? true : false;
		PrintWriter out = response.getWriter();
		switch(action){
		case "add":
			break;
		case "delete":
			Person loginUser = (Person) session.getAttribute("loginUser");
			String sid = loginUser.getId();
			int cid = Integer.parseInt(request.getParameter("cid")==null?"0":request.getParameter("cid"));
			SCRerelationService.delete(cid, sid);
			break;
		case "modify":
			break;
		case "query":
			Pager<Course> CourseResult;
			Pager<Teacher> TeacherResult;
			List<String> TeacherNames;
			List<String> CourseNames;
			Course courseModel = new Course();
			int pageNum = 1;
			int pageSize = 60;
			if(first){
				TeacherNames = teacherService.findAllName();
				CourseNames = courseService.findAllName();
				tempList = new ArrayList<String>();
				tempList.add(JsonUtil.getJson("TeacherNames", TeacherNames));
				tempList.add(JsonUtil.getJson("CourseNames", CourseNames));
				out.write(JsonUtil.groupJeson(tempList));		
			}else{
				String CourseName = request.getParameter("CourseName");
				String TeacherName = request.getParameter("TeacherName");
				Teacher teacherModel = new Teacher();
				teacherModel.setName(TeacherName);
				TeacherResult = teacherService.findTeacherForPager(teacherModel, pageNum, pageSize);
				courseModel.setName(CourseName);
				if (TeacherResult.getDataList().size() == 1) courseModel.setTeacher(TeacherResult.getDataList().get(0));
				CourseResult = courseService.StufindCourseForPager(((Person)(session.getAttribute("loginUser"))).getId(),courseModel, pageNum, pageSize);
				out.write(JsonUtil.getJson("CourseResult", CourseResult.getDataList()));
			}
			break;
		case "querysel":
			Pager<Course> queryResult = new Pager<Course>();
			Pager<SCReRelation> tempResult = new Pager<SCReRelation>();
			loginUser = (Person) session.getAttribute("loginUser");
			sid = loginUser.getId();
			SCReRelation sCReRelationModel = new SCReRelation();
			sCReRelationModel.setSid(sid);
			pageNum = 1;
			pageSize = 60;
			tempResult = SCRerelationService.findSCReRelationForPager(sCReRelationModel, pageNum, pageSize);
			for(SCReRelation x : tempResult.getDataList()) queryResult.getDataList().add(courseService.findOneCourse(x.getCid()));
			out.write(JsonUtil.getJson("queryResult", queryResult.getDataList()));
			break;
		case "select":
			String cids = request.getParameter("courseId");
			String[] courseId = cids.split(" ");
			boolean code = false;
			for(String x : courseId){
				String[] message = x.split(","); 
				SCReRelation scrr = new SCReRelation();
				Person person = (Person) session.getAttribute("loginUser");
				if(SCRerelationService.isexist(message[0],person.getId())) {
					SCReRelation sc = SCRerelationService.findOneSCReRelation(message[0], person.getId());
					sc.setDflag(0);
					SCRerelationService.updateSCReRelation(sc);
					code = true;
					continue;
				}
				scrr.setCid(Integer.parseInt(message[0]));
				scrr.setSid(person.getId());
				scrr.setDate(message[1]);
				if(message.length > 2) scrr.setRemark(message[2]);
				if(courseService.selectReCourse(scrr)) code = true;	
				else {code = false; break;}
			}tempList = new ArrayList<String>();
			if(code){
				tempList.add(JsonUtil.getJson("code", "1"));
				tempList.add(JsonUtil.getJson("message", "选课成功,请准时报到"));
			}else{
				tempList.add(JsonUtil.getJson("code", "0"));
				tempList.add(JsonUtil.getJson("message", "选课失败，请联系管理员"));
			}out.write(JsonUtil.groupJeson(tempList));
			break;
		case "back":
			loginUser = (Person) session.getAttribute("loginUser");
			sid = loginUser.getId();
			String temp = request.getParameter("delete_item");
			cid = Integer.parseInt(temp);
			tempList = new ArrayList<String>();
			if(SCRerelationService.delete(cid,sid)){
				tempList.add(JsonUtil.getJson("code", "1"));
				tempList.add(JsonUtil.getJson("message", "退选成功"));
			}else{
				tempList.add(JsonUtil.getJson("code", "0"));
				tempList.add(JsonUtil.getJson("message", "退选失败，请联系管理员"));
			}out.write(JsonUtil.groupJeson(tempList));
			break;
		case "judge":
			if(first){
				queryResult = new Pager<Course>();
				Pager<SCFactRelation> tempResults = new Pager<SCFactRelation>();
				loginUser = (Person) session.getAttribute("loginUser");
				sid = loginUser.getId();
				SCFactRelation SCFactRelationModel = new SCFactRelation();
				SCFactRelationModel.setSid(sid);
				pageNum = 1;
				pageSize = 60;
				tempResults = SCFactrelationService.findSCFactRelationForPager(SCFactRelationModel, pageNum, pageSize);
				for(SCFactRelation x : tempResults.getDataList()) queryResult.getDataList().add(courseService.findOneCourse(x.getCid()));
				out.write(JsonUtil.getJson("queryResult", queryResult.getDataList()));
			}else{
			Pager<SCFactRelation> tempSCFact = new Pager<SCFactRelation>();
			String judgeItem = request.getParameter("judge_item");
			String judgeDetail = request.getParameter("judge_detail");
			String extraContent = request.getParameter("extra_content");
			SCFactRelation sCFactRelationModel = new SCFactRelation();
			String [] tempjudgeDetail = judgeDetail.split(" ");
			int grade = 0;
			for(int i = 0; i < 4; i++) grade += Integer.parseInt(tempjudgeDetail[i]);
			grade /= 2;
			sCFactRelationModel.setCid(Integer.parseInt(judgeItem));
			sCFactRelationModel.setSid(((Person)session.getAttribute("loginUser")).getId());
			tempSCFact = SCFactrelationService.findSCFactRelationForPager(sCFactRelationModel, 1, 10);
			extraContent = judgeDetail+","+extraContent;
			tempSCFact.getDataList().get(0).setGrade(grade);
			tempSCFact.getDataList().get(0).setEvaluate(extraContent);
			tempList = new ArrayList<String>();
			if(SCFactrelationService.updateSCFactRelation(tempSCFact.getDataList().get(0))){
				tempList.add(JsonUtil.getJson("code", "1"));
				tempList.add(JsonUtil.getJson("message", "评价成功"));
			}else{
				tempList.add(JsonUtil.getJson("code", "0"));
				tempList.add(JsonUtil.getJson("message", "退选失败，请联系管理员"));
			}out.write(JsonUtil.groupJeson(tempList));
			}break;
		default:
		}
	}
}
