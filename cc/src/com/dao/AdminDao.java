package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Admin;
import com.entity.Pager;
import com.util.DBUtil;
import com.util.StringUtil;

public class AdminDao {
	
	public boolean insert(Admin admin){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(admin.getId());
		param.add(admin.getName());
		param.add(admin.getPassword());
		param.add(admin.getGender());
		param.add(admin.getEmail());
		param.add(admin.getTel());
		param.add(admin.getPflag());
		param.add(admin.getDflag());
		
		String sql = "insert into admin values(?,?,?,?,?,?,?,?);";
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
	
	public boolean delete(Admin admin){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(admin.getId());
		
		String sql = "update admin set dflag=1 where id=?;";
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
	
	public boolean update(Admin adminModel){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		
		StringBuffer sql = new StringBuffer("update admin set dflag=0");
		if(!StringUtil.isNullString(adminModel.getName())){
			sql.append(",name = ?");
			param.add(adminModel.getName());
		}
		if(!StringUtil.isNullString(adminModel.getPassword())){
			sql.append(",password = ?");
			param.add(adminModel.getPassword());
		}
		if(!StringUtil.isNullString(adminModel.getGender())){
			sql.append(",gender = ?");
			param.add(adminModel.getGender());
		}
		if(!StringUtil.isNullString(adminModel.getTel())){
			sql.append(",tel = ?");
			param.add(adminModel.getTel());
		}
		if(!StringUtil.isNullString(adminModel.getEmail())){
			sql.append(",email = ?");
			param.add(adminModel.getEmail());
		}
		if(adminModel.getPflag()>=0){
			sql.append(",getPflag = ?");
			param.add(adminModel.getPflag());
		}
		
		sql.append(" where id = ?");
		param.add(adminModel.getId());
		
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
	
	
	public Admin findAdminById(String id){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		Admin admin = null;
		
		param.add(id);
		
		String sql = "select * from admin where dflag=0 and id = ?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			admin = new Admin(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return admin;
	}
	
	
	public  Pager<Admin> findAdminForPager(Admin adminModel, int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		List<Object> param=new ArrayList<Object>();
		DBUtil  dbUtil=new DBUtil();
		dbUtil.getConnection();
		List<Admin> dataList=new ArrayList<Admin>(); 
		StringBuffer sql=new StringBuffer("select * from admin where dflag=0");
		StringBuffer sqltotalRecord=new StringBuffer("select count(id) as totalrecord from admin where dflag=0");
		
		if(!StringUtil.isNullString(adminModel.getId())){
			sql.append(" and id=?");
			sqltotalRecord.append(" and id=?");
			param.add(adminModel.getId());
		}
		if(!StringUtil.isNullString(adminModel.getName())){
			sql.append(" and name like ?");
			sqltotalRecord.append(" and name like ?");
			param.add("%"+adminModel.getName().trim()+"%");
		}
		if(!StringUtil.isNullString(adminModel.getGender())){
			sql.append(" and gender = ?");
			sqltotalRecord.append(" and gender = ?");
			param.add(adminModel.getGender());
		}
		if(!StringUtil.isNullString(adminModel.getTel())){
			sql.append(" and tel = ?");
			sqltotalRecord.append(" and tel = ?");
			param.add(adminModel.getTel());
		}
		if(!StringUtil.isNullString(adminModel.getEmail())){
			sql.append(" and email = ?");
			sqltotalRecord.append(" and email = ?");
			param.add(adminModel.getEmail());
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
			Admin u=new Admin(map);
			dataList.add(u);
		}
		
		//获取总页数
		int totalPage=totalRecord/pageSize;
		if(totalRecord%pageSize!=0){
			totalPage++;
		}
		
		//封装Pager
		Pager<Admin> result=new Pager<Admin>(pageSize, pageNum, totalRecord, totalPage, dataList);
		
		
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return result;
	}

}
