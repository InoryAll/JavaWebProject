package com.entity;

import java.util.Map;

import com.args.Constant;
import com.dao.TeacherDao;

public class Course {
	private int id;
	private String name;
	private Teacher teacher;
	private String date;
	private String info;
	private int courseStatus;
	private int dflag;
	
	public Course(){
		dflag = Constant.NOTDELETE;
		id = Constant.DEFAULT_ID;
		courseStatus = Constant.NOOPENCOURSE;		
	}
	
	public Course(int id, String name,Teacher teacher,String date, String info,int courseStatus, int dflag) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.date = date;
		this.info = info;
		this.courseStatus = courseStatus;
		this.dflag = dflag;
	}
	
	public Course(Map<String,Object> map){
		TeacherDao teacherDao = new TeacherDao();
		this.id = (int) map.get("id");
		this.name = (String) map.get("name");
		this.teacher = teacherDao.findTeacherById((String) map.get("tid"));
		this.date = (String) map.get("date");
		this.info = (String) map.get("info");
		this.courseStatus = (int) map.get("coursestatus");
		this.dflag =(int)map.get("dflag");
		//this.courseflag = map.get("courseflag");
		
	}
	

	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	
	public Teacher getTeacher() {return teacher;}

	public void setTeacher(Teacher teacher) {this.teacher = teacher;}

	
	public String getDate() {return date;}

	public void setDate(String date) {this.date = date;}
	
	
	public String getInfo() {return info;}
	
	public void setInfo(String info) {this.info = info;}
	
	
	public int getCourseStatus() {return courseStatus;}

	public void setCourseStatus(int courseStatus) {this.courseStatus = courseStatus;}
	
	
	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}

	
}
