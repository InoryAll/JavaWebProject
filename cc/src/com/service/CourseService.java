package com.service;

import java.util.List;

import com.dao.CourseDao;
import com.dao.SCFactRelationDao;
import com.dao.SCReRelationDao;
import com.entity.Course;
import com.entity.Pager;
import com.entity.SCFactRelation;
import com.entity.SCReRelation;

public class CourseService {
	private CourseDao courseDao;
	private SCReRelationDao scrr;
	private SCFactRelationDao scfr;
	
	public CourseService(){
		courseDao = new CourseDao();
		scrr = new SCReRelationDao();
		scfr = new SCFactRelationDao();
	}
	
	public Pager<Course> findCourseForPager(Course CourseModel, int pageNum, int pageSize){
		Pager<Course> result = courseDao.findCourseForPager(CourseModel, pageNum,
				pageSize);
		return result;
	}
	
	public Pager<Course> StufindCourseForPager(String sid,Course CourseModel, int pageNum, int pageSize){
		
		List<Integer> cid = scrr.findCidbySid(sid);
		
		Pager<Course> result = courseDao.findCourseGiveUpRepeatForPager(cid,CourseModel, pageNum,
				pageSize);
		
		return result;
	}
	
	//修改信息
	public boolean updateCourse(Course course){
		if(courseDao.update(course)){
			return true;
		}
		return false;
	}
	//学生预定选课
	public boolean selectReCourse(SCReRelation scr){
		return scrr.insert(scr);
	}
	//学生实际选课
	public boolean selectFactCourse(SCFactRelation scf){
		
		return scfr.insert(scf);
	}
	//老师加课
	public boolean addCourse(Course course){
		if(courseDao.insert(course))
			return true;
		return false;
	}
	public boolean deleteCourse(int id){
		Course c = new Course();
		c.setId(id);
		SCFactRelation scf = new SCFactRelation();
		SCReRelation scr = new SCReRelation();
		scf.setCid(id);
		scr.setCid(id);
		return courseDao.delete(c)&&scfr.delete(scf)&&scrr.delete(scr);
	}
	public  Course findOneCourse(int id){
		return courseDao.findCourseById(id);
	}

	public List<String> findAllName() {
		// TODO Auto-generated method stub
		return courseDao.findAllName();
	}
	

}
