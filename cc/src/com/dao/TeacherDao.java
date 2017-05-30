package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Teacher;
import com.entity.Pager;
import com.util.DBUtil;
import com.util.StringUtil;

public class TeacherDao {
	
	public boolean insert(Teacher teacher){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(teacher.getId());
		param.add(teacher.getName());
		param.add(teacher.getPassword());
		param.add(teacher.getGender());
		param.add(teacher.getBirthday());
		param.add(teacher.getGschool());
		param.add(teacher.getMajor());
		param.add(teacher.getOnlinetool());
		param.add(teacher.getEmail());
		param.add(teacher.getTel());
		param.add(teacher.getNation());
		param.add(teacher.getPost());
		param.add(teacher.getTitle());
		param.add(teacher.getDepartment());
		param.add(teacher.getTags());
		param.add(teacher.getImage());
		param.add(teacher.getInfo1());
		param.add(teacher.getInfo2());
		param.add(teacher.getInfo3());
		param.add(teacher.getGoodfield());
		param.add(teacher.getPflag());
		param.add(teacher.getDflag());
		
		String sql = "insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
	//删除或者激活
	public boolean delete(Teacher teacher){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(teacher.getDflag());
		param.add(teacher.getId());
		
		String sql = "update teacher set dflag=? where id=?;";
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
	
	public boolean update(Teacher teacherModel){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("update teacher set dflag=0");
		if(!StringUtil.isNullString(teacherModel.getName())){
			sql.append(",name = ?");
			param.add(teacherModel.getName());
		}
		if(!StringUtil.isNullString(teacherModel.getPassword())){
			sql.append(",password = ?");
			param.add(teacherModel.getPassword());
		}
		if(!StringUtil.isNullString(teacherModel.getGender())){
			sql.append(",gender = ?");
			param.add(teacherModel.getGender());
		}
		if(!StringUtil.isNullString(teacherModel.getBirthday())){
			sql.append(",birthday = ?");
			param.add(teacherModel.getBirthday());
		}
		if(!StringUtil.isNullString(teacherModel.getGender())){
			sql.append(",gschool = ?");
			param.add(teacherModel.getGschool());
		}
		if(!StringUtil.isNullString(teacherModel.getGender())){
			sql.append(",major = ?");
			param.add(teacherModel.getMajor());
		}
		if(!StringUtil.isNullString(teacherModel.getTel())){
			sql.append(",tel = ?");
			param.add(teacherModel.getTel());
		}
		if(!StringUtil.isNullString(teacherModel.getEmail())){
			sql.append(",email = ?");
			param.add(teacherModel.getEmail());
		}
		if(!StringUtil.isNullString(teacherModel.getOnlinetool())){
			sql.append(",onlinetool = ?");
			param.add(teacherModel.getOnlinetool());
		}
		if(!StringUtil.isNullString(teacherModel.getNation())){
			sql.append(",nation = ?");
			param.add(teacherModel.getNation());
		}
		if(!StringUtil.isNullString(teacherModel.getPost())){
			sql.append(",post = ?");
			param.add(teacherModel.getPost());
		}
		if(!StringUtil.isNullString(teacherModel.getTitle())){
			sql.append(",title = ?");
			param.add(teacherModel.getTitle());
		}
		if(!StringUtil.isNullString(teacherModel.getDepartment())){
			sql.append(",department = ?");
			param.add(teacherModel.getDepartment());
		}
		if(!StringUtil.isNullString(teacherModel.getTags())){
			sql.append(",tags = ?");
			param.add(teacherModel.getTags());
		}
		if(!StringUtil.isNullString(teacherModel.getImage())){
			sql.append(",image = ?");
			param.add(teacherModel.getImage());
		}
		if(!StringUtil.isNullString(teacherModel.getInfo1())){
			sql.append(",info1 = ?");
			param.add(teacherModel.getInfo1());
		}
		if(!StringUtil.isNullString(teacherModel.getInfo2())){
			sql.append(",info2 = ?");
			param.add(teacherModel.getInfo2());
		}
		if(!StringUtil.isNullString(teacherModel.getInfo3())){
			sql.append(",info3 = ?");
			param.add(teacherModel.getInfo3());
		}
		if(!StringUtil.isNullString(teacherModel.getGoodfield())){
			sql.append(",goodfield = ?");
			param.add(teacherModel.getGoodfield());
		}
		
		if(teacherModel.getPflag()>=0){
			sql.append(",pflag = ?");
			param.add(teacherModel.getPflag());
		}
		
		sql.append(" where id = ?");
		param.add(teacherModel.getId());
		
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
	
	/**
	 * 
	 * @param tags 0-校内导师,1-校外导师
	 * @param index 代表rows
	 * @param offset 代表偏移量  -1:代表查到表末尾
	 * @return List for Teacher
	 */
	public List<Teacher> findAllTeacher(String tags,int index,int offset){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		List<Teacher> teacherlist = new ArrayList<Teacher>();
		Teacher teacher = null;
		
		String sql = "select * from teacher where dflag=0 and tags like ? LIMIT ?,?";
		param.add(tags);
		if(offset>=0){
			if(index<=0){
				param.add(0);
				param.add(offset);
			}else{
				param.add(index);
				param.add(offset);
			}
		}else{
			if(index<0){
				param.add(0);
				param.add(999999999);
			}else{
				param.add(index);
				param.add(999999999);
			}
		}		
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			//Map<String,Object> map = result.get(0);
			for (Map<String,Object> map : result){
				teacher = new Teacher(map);
				teacherlist.add(teacher);
			}
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return teacherlist;
	}
	
	public Teacher findTeacherById(String id){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		Teacher Teacher = null;
		
		param.add(id);
		
		String sql = "select * from teacher where dflag=0 and id = ?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			Teacher = new Teacher(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return Teacher;
	}
	
	public List<String> findAllName() {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		List<String> namelist =new ArrayList<String>();
		
		String sql = "select name from teacher where dflag=0 ";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			for(Map<String,Object> map : result){
				namelist.add((String)map.get("name"));
			}
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return namelist;
	}
	
	public  Pager<Teacher> findTeacherForPager(Teacher teacherModel, int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		List<Object> param=new ArrayList<Object>();
		DBUtil  dbUtil=new DBUtil();
		dbUtil.getConnection();
		List<Teacher> dataList=new ArrayList<Teacher>(); 
		StringBuffer sql=new StringBuffer("select * from teacher where dflag=0");
		StringBuffer sqltotalRecord=new StringBuffer("select count(id) as totalrecord from teacher where dflag=0");
		
		if(!StringUtil.isNullString(teacherModel.getId())){
			sql.append(" and id=?");
			sqltotalRecord.append(" and id=?");
			param.add(teacherModel.getId());
		}
		if(!StringUtil.isNullString(teacherModel.getName())){
			sql.append(" and name like ?");
			sqltotalRecord.append(" and name like ?");
			param.add("%"+teacherModel.getName().trim()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getGender())){
			sql.append(" and gender = ?");
			sqltotalRecord.append(" and gender = ?");
			param.add(teacherModel.getGender());
		}
		if(!StringUtil.isNullString(teacherModel.getBirthday())){
			sql.append(" and birthday = ?");
			sqltotalRecord.append(" and birthday = ?");
			param.add(teacherModel.getBirthday());
		}
		if(!StringUtil.isNullString(teacherModel.getGschool())){
			sql.append(" and gschool = ?");
			sqltotalRecord.append(" and gschool = ?");
			param.add(teacherModel.getGschool());
		}
		if(!StringUtil.isNullString(teacherModel.getMajor())){
			sql.append(" and major = ?");
			sqltotalRecord.append(" and major = ?");
			param.add(teacherModel.getMajor());
		}
		if(!StringUtil.isNullString(teacherModel.getOnlinetool())){
			sql.append(" and onlinetool = ?");
			sqltotalRecord.append(" and onlinetool = ?");
			param.add(teacherModel.getOnlinetool());
		}
		if(!StringUtil.isNullString(teacherModel.getTel())){
			sql.append(" and tel = ?");
			sqltotalRecord.append(" and tel = ?");
			param.add(teacherModel.getTel());
		}
		if(!StringUtil.isNullString(teacherModel.getEmail())){
			sql.append(" and email = ?");
			sqltotalRecord.append(" and email = ?");
			param.add(teacherModel.getEmail());
		}
		if(!StringUtil.isNullString(teacherModel.getNation())){
			sql.append(" and nation like ?");
			sqltotalRecord.append(" and nation like ?");
			param.add("%"+teacherModel.getNation().trim()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getPost())){
			sql.append(" and post like ?");
			sqltotalRecord.append(" and post like ?");
			param.add("%"+teacherModel.getPost()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getTitle())){
			sql.append(" and title like ?");
			sqltotalRecord.append(" and title like ?");
			param.add("%"+teacherModel.getTitle().trim()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getDepartment())){
			sql.append(" and department like ?");
			sqltotalRecord.append(" and department like ?");
			param.add("%"+teacherModel.getDepartment().trim()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getTags())){
			sql.append(" and tags like ?");
			sqltotalRecord.append(" and tags like ?");
			param.add("%"+teacherModel.getTags().trim()+"%");
		}
		if(!StringUtil.isNullString(teacherModel.getGoodfield())){
			sql.append(" and goodfield like ?");
			sqltotalRecord.append(" and goodfield like ?");
			param.add("%"+teacherModel.getGoodfield().trim()+"%");
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
			Teacher u=new Teacher(map);
			dataList.add(u);
		}
		
		//获取总页数
		int totalPage=totalRecord/pageSize;
		if(totalRecord%pageSize!=0){
			totalPage++;
		}
		
		//封装Pager
		Pager<Teacher> result=new Pager<Teacher>(pageSize, pageNum, totalRecord, totalPage, dataList);
		
		
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return result;
	}
	

}
