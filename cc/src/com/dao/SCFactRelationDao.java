package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Pager;
import com.entity.SCFactRelation;
import com.util.DBUtil;
import com.util.StringUtil;


public class SCFactRelationDao {
	public boolean insert(SCFactRelation sCFactRelation) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(sCFactRelation.getSid());
		param.add(sCFactRelation.getCid());
		param.add(sCFactRelation.getDate());
		param.add(sCFactRelation.getGrade());
		param.add(sCFactRelation.getEvaluate());
		param.add(sCFactRelation.getRemark());
		param.add(sCFactRelation.getDflag());
		
		String sql = "insert into sc_fact_relation values(?,?,?,?,?,?,?);";
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
	public SCFactRelation findOne(String cid, String sid) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		SCFactRelation sc = null;

		param.add(sid);
		param.add(cid);
		
		String sql = "select * from sc_fact_relation sid=? and cid=?;";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			sc = new SCFactRelation(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return sc;
	}
	public boolean delete(SCFactRelation sCFactRelation) {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer( "update sc_fact_relation set dflag=1 where 1=1");
		if(sCFactRelation.getCid()>0){
			sql.append(" and cid = ?");
			param.add(sCFactRelation.getCid());
		}
		if(!StringUtil.isNullString(sCFactRelation.getDate())){
			sql.append(" and sid = ?");
			param.add(sCFactRelation.getSid());
		}
		if(!StringUtil.isNullString(sCFactRelation.getDate())){
			sql.append(" and date = ?");
			param.add(sCFactRelation.getDate());
		}
		if(dbUtil.excutePUpdate(sql.toString(), param)){
			if(dbUtil!=null)
			{	
				dbUtil.closeAll();
				dbUtil=null;
			}
			
		}
		return true;
	}
	public boolean update(SCFactRelation sCFactRelation) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("update sc_fact_relation set dflag=0");
		if(!StringUtil.isNullString(sCFactRelation.getDate())){
			sql.append(",date = ?");
			param.add(sCFactRelation.getDate());
		}
		if(!StringUtil.isNullString(sCFactRelation.getRemark())){
			sql.append(",remark = ?");
			param.add(sCFactRelation.getRemark());
		}
		if(!StringUtil.isNullString(sCFactRelation.getEvaluate())){
			sql.append(",evaluate = ?");
			param.add(sCFactRelation.getEvaluate());
		}
		if(sCFactRelation.getGrade()>0){
			sql.append(",grade = ?");
			param.add(sCFactRelation.getGrade());
		}
		
		sql.append(" where sid = ? and cid = ?");
		param.add(sCFactRelation.getSid());
		param.add(sCFactRelation.getCid());
		
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
	public Pager<SCFactRelation> findSCFactRelationForPager(
			SCFactRelation sCFactRelationModel, int pageNum, int pageSize) {
		List<Object> param=new ArrayList<Object>();
		DBUtil  dbUtil=new DBUtil();
		dbUtil.getConnection();
		List<SCFactRelation> dataList=new ArrayList<SCFactRelation>(); 
		StringBuffer sql=new StringBuffer("select * from sc_fact_relation where dflag=0");
		StringBuffer sqltotalRecord=new StringBuffer("select count(sid) as totalrecord from sc_fact_relation where dflag=0");
		
		if(!StringUtil.isNullString(sCFactRelationModel.getSid())){
			sql.append(" and sid=?");
			sqltotalRecord.append(" and sid=?");
			param.add(sCFactRelationModel.getSid());
		}
		if(sCFactRelationModel.getCid()>0){
			sql.append(" and cid = ?");
			sqltotalRecord.append(" and cid = ?");
			param.add(sCFactRelationModel.getCid());
		}
		if(!StringUtil.isNullString(sCFactRelationModel.getDate())){
			sql.append(" and date like ?");
			sqltotalRecord.append(" and date like ?");
			param.add(sCFactRelationModel.getDate());
		}
		if(!StringUtil.isNullString(sCFactRelationModel.getEvaluate())){
			sql.append(" and evaluate like ?");
			sqltotalRecord.append(" and evaluate like ?");
			param.add(sCFactRelationModel.getEvaluate());
		}
		if(sCFactRelationModel.getGrade()>0){
			sql.append(" and grade = ?");
			sqltotalRecord.append(" and grade = ?");
			param.add(sCFactRelationModel.getGrade());
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
			SCFactRelation u=new SCFactRelation(map);
			dataList.add(u);
		}
		
		//获取总页数
		int totalPage=totalRecord/pageSize;
		if(totalRecord%pageSize!=0){
			totalPage++;
		}
		
		//封装Pager
		Pager<SCFactRelation> result=new Pager<SCFactRelation>(pageSize, pageNum, totalRecord, totalPage, dataList);
		
		
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return result;
	}

}
