package com.service;

import com.dao.SCFactRelationDao;
import com.dao.SCReRelationDao;
import com.dao.StudentDao;
import com.entity.SCFactRelation;
import com.entity.SCReRelation;
import com.entity.Student;
import com.entity.Pager;

public class StudentService {
	private StudentDao studentDao;
	private SCFactRelationDao scfr;
	private SCReRelationDao scrr;
	public StudentService(){
		studentDao = new StudentDao();
		scfr=new SCFactRelationDao();
		scrr = new SCReRelationDao();
	}
	
	public Pager<Student> findStudentForPager(Student studentModel, int pageNum, int pageSize){
		Pager<Student> result = studentDao.findStudentForPager(studentModel, pageNum,
				pageSize);
		return result;
//		return null;
	}
	//修改信息
	public boolean updateStudent(Student student){
		if(studentDao.update(student)){
			return true;
		}
		return false;
	}
	
	public Student findStudentById(String id){
		Student stuMatch = studentDao.findStudentById(id);
		return stuMatch;
	}
	
	public boolean insert(Student student){
		return studentDao.insert(student);
	}
	public boolean delete(String id){
		Student stu = new Student();
		stu.setId(id);
		SCFactRelation scf = new SCFactRelation();
		SCReRelation scr = new SCReRelation();
		scf.setSid(id);
		scr.setSid(id);
		return studentDao.delete(stu)&&scrr.delete(scr)&&scfr.delete(scf);
	}

}
