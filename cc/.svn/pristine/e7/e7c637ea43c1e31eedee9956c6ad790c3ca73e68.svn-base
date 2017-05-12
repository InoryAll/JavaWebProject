package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Student;
import com.entity.Pager;
import com.util.DBUtil;
import com.util.StringUtil;

public class StudentDao {
	
	public boolean insert(Student Student){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(Student.getId());
		param.add(Student.getName());
		param.add(Student.getPassword());
		param.add(Student.getGender());
		param.add(Student.getEmail());
		param.add(Student.getTel());
		param.add(Student.getDepartment());
		param.add(Student.getClasses());
		param.add(Student.getPflag());
		param.add(Student.getDflag());
		
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?);";
		if(dbUtil.excutePUpdate(sql, param)){
			if(dbUtil!=null)
			{	
				dbUtil.closeAll();
				dbUtil=null;
			}
			return true;
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return false;
	}
	
	//删除
	public boolean delete(Student student){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(student.getId());
		
		String sql = "update student set dflag=1 where id=?;";
		if(dbUtil.excutePUpdate(sql, param)){
			if(dbUtil!=null)
			{	
				dbUtil.closeAll();
				dbUtil=null;
			}
			return true;
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return false;
	}
	
	public boolean update(Student studentModel){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		
		StringBuffer sql = new StringBuffer("update Student set dflag=0");
		if(!StringUtil.isNullString(studentModel.getName())){
			sql.append(",name = ?");
			param.add(studentModel.getName());
		}
		if(!StringUtil.isNullString(studentModel.getPassword())){
			sql.append(",password = ?");
			param.add(studentModel.getPassword());
		}
		if(!StringUtil.isNullString(studentModel.getGender())){
			sql.append(",gender = ?");
			param.add(studentModel.getGender());
		}
		if(!StringUtil.isNullString(studentModel.getEmail())){
			sql.append(",email = ?");
			param.add(studentModel.getEmail());
		}
		if(!StringUtil.isNullString(studentModel.getTel())){
			sql.append(",tel = ?");
			param.add(studentModel.getTel());
		}
		if(!StringUtil.isNullString(studentModel.getTel())){
			sql.append(",department = ?");
			param.add(studentModel.getDepartment());
		}
		if(!StringUtil.isNullString(studentModel.getTel())){
			sql.append(",classes = ?");
			param.add(studentModel.getClasses());
		}
		if(studentModel.getPflag()>=0){
			sql.append(",pflag = ?");
			param.add(studentModel.getPflag());
		}
		
		sql.append(" where id = ?");
		param.add(studentModel.getId());
		
		if(dbUtil.excutePUpdate(sql.toString(), param)){
			if(dbUtil!=null)
			{	
				dbUtil.closeAll();
				dbUtil=null;
			}
			return true;
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return false;
	}
	
	
	public Student findStudentById(String id){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		Student Student = null;
		
		param.add(id);
		
		String sql = "select * from Student where dflag=0 and id = ?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			Student = new Student(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return Student;
	}
	
	
	public  Pager<Student> findStudentForPager(Student studentModel, int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		List<Object> param=new ArrayList<Object>();
		DBUtil  dbUtil=new DBUtil();
		dbUtil.getConnection();
		List<Student> dataList=new ArrayList<Student>(); 
		StringBuffer sql=new StringBuffer("select * from student where dflag=0");
		StringBuffer sqltotalRecord=new StringBuffer("select count(id) as totalrecord from student where dflag=0");
		
		if(!StringUtil.isNullString(studentModel.getId())){
			sql.append(" and id=?");
			sqltotalRecord.append(" and id=?");
			param.add(studentModel.getId());
		}
		if(!StringUtil.isNullString(studentModel.getName())){
			sql.append(" and name like ?");
			sqltotalRecord.append(" and name like ?");
			param.add("%"+studentModel.getName().trim()+"%");
		}
		if(!StringUtil.isNullString(studentModel.getGender())){
			sql.append(" and gender = ?");
			sqltotalRecord.append(" and gender = ?");
			param.add(studentModel.getGender());
		}
		if(!StringUtil.isNullString(studentModel.getEmail())){
			sql.append(" and email = ?");
			sqltotalRecord.append(" and email = ?");
			param.add(studentModel.getEmail());
		}
		if(!StringUtil.isNullString(studentModel.getTel())){
			sql.append(" and tel = ?");
			sqltotalRecord.append(" and tel = ?");
			param.add(studentModel.getTel());
		}
		if(!StringUtil.isNullString(studentModel.getDepartment())){
			sql.append(" and department like ?");
			sqltotalRecord.append(" and department like ?");
			param.add("%"+studentModel.getDepartment().trim()+"%");
		}
		if(!StringUtil.isNullString(studentModel.getClasses())){
			sql.append(" and classes like ?");
			sqltotalRecord.append(" and classes like ?");
			param.add("%"+studentModel.getClasses()+"%");
		}
		// 起始索引
		int fromIndex	= pageSize * (pageNum -1);
				
		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize );
		//获取总记录数
		List<Map<String,Object>> countResult=dbUtil.findResult(sqltotalRecord.toString(), param);
		Map<String,Object> countmap=countResult.get(0);
		int totalRecord=Integer.parseInt(String.valueOf(countmap.get("totalrecord")));
		
		//获取所有记录
		List<Map<String,Object>> resultlist=dbUtil.findResult(sql.toString(), param);
		for(Map<String,Object> map:resultlist){
			Student u=new Student(map);
			dataList.add(u);
		}
		
		//获取总页数
		int totalPage=totalRecord/pageSize;
		if(totalRecord%pageSize!=0){
			totalPage++;
		}
		
		//封装Pager
		Pager<Student> result=new Pager<Student>(pageSize, pageNum, totalRecord, totalPage, dataList);
		
		
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return result;
	}
	

}
