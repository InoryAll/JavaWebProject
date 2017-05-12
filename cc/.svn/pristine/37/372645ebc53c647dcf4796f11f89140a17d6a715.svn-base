package com.service;

import java.util.List;

import com.dao.CourseDao;
import com.dao.SCReRelationDao;
import com.dao.TeacherDao;
import com.entity.Course;
import com.entity.Pager;
import com.entity.Teacher;

public class TeacherService {
	private TeacherDao teacherDao;
	private CourseDao courseDao;
	private SCReRelationDao sCReRelationDao;
	
	public TeacherService(){
		teacherDao = new TeacherDao();
		courseDao = new CourseDao();
		sCReRelationDao = new SCReRelationDao();
	}
	
	public Pager<Teacher> findTeacherForPager(Teacher TeacherModel, int pageNum, int pageSize){
		Pager<Teacher> result = teacherDao.findTeacherForPager(TeacherModel, pageNum,
				pageSize);
		return result;
	}
	//修改密码
	public boolean updatePassword(String id,String password){
		Teacher Teacher = new Teacher();
		Teacher.setId(id);
		Teacher.setPassword(password);
		if(teacherDao.update(Teacher)){
			return true;
		}
		return false;
	}
	//修改信息
	public boolean updateTeacher(Teacher Teacher){
		if(teacherDao.update(Teacher)){
			return true;
		}
		return false;
	}
	//修改权限，注：必须有超级管理员权限
	public boolean updatePower(String id,int pflag){
		Teacher Teacher = new Teacher();
		Teacher.setId(id);
		Teacher.setPflag(pflag);
		if(teacherDao.update(Teacher)){
			return true;
		}
		return false;
	}
	//老师注册
	public boolean teacherRegister(Teacher teacher){
		
		return teacherDao.insert(teacher);
	}
	//查找所有选cid课的人数
	public int totalNumberbyCid(int cid){
		
		return sCReRelationDao.countPerson(cid);
	}
	
	
	/**
	 * set courseStatus 
	 */
	public boolean setCourseStatus(int id ,int courseStatus){
		
		return courseDao.setcourseStatus(id, courseStatus);
	}
	
	public Teacher findTeacherById(String id){
		Teacher teacher = teacherDao.findTeacherById(id);
		return teacher;
	}

	public  boolean teacherdeleteCourse(Course course){
		return courseDao.delete(course);
	}
	
	public  boolean teacheraddCourse(Course course){
		return courseDao.insert(course);
	}
	
	public  boolean teacherupdateCourse(Course course){
		return courseDao.update(course);
	}
	
	public List<String> findAllName() {
		
		return teacherDao.findAllName();
	}

}
