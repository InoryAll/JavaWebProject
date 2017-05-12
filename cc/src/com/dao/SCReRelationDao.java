package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Pager;
import com.entity.SCReRelation;
import com.util.DBUtil;
import com.util.StringUtil;


public class SCReRelationDao {

	public boolean insert(SCReRelation sCReRelation) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		param.add(sCReRelation.getSid());
		param.add(sCReRelation.getCid());
		param.add(sCReRelation.getDate());
		param.add(sCReRelation.getRemark());
		param.add(sCReRelation.getDflag());
		
		String sql = "insert into sc_re_relation values(?,?,?,?,?);";
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
	public SCReRelation findOne(String cid, String sid) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		SCReRelation sc = null;

		param.add(sid);
		param.add(cid);
		
		String sql = "select * from sc_re_relation where sid=? and cid=?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			sc = new SCReRelation(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return sc;
	}
	
	public List<Integer> findCidbySid(String sid) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Integer> cidlist = new ArrayList<Integer>();
		List<Object> param = new ArrayList<Object>();

		param.add(sid);
		
		String sql = "select cid from sc_re_relation where sid=? and dflag=0";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			for(Map<String,Object> map : result){
				cidlist.add((int)map.get("cid"));
			}
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return cidlist;
	}
	
	public boolean delete(SCReRelation sCReRelation){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("update sc_re_relation set dflag=1 where 1=1");
		if(sCReRelation.getCid()>0){
			
			sql.append(" and cid = ?");
			param.add(sCReRelation.getCid());
		}
		if(!StringUtil.isNullString(sCReRelation.getDate())){
			sql.append(" and sid = ?");
			param.add(sCReRelation.getSid());
		}
		if(!StringUtil.isNullString(sCReRelation.getDate())){
			sql.append(" and date = ?");
			param.add(sCReRelation.getDate());
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
	
	public boolean update(SCReRelation sCReRelation) {
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("update sc_re_relation set dflag=0");
		if(!StringUtil.isNullString(sCReRelation.getDate())){
			sql.append(",date = ?");
			param.add(sCReRelation.getDate());
		}
		if(!StringUtil.isNullString(sCReRelation.getRemark())){
			sql.append(",remark = ?");
			param.add(sCReRelation.getRemark());
		}
		
		sql.append(" where sid = ? and cid = ?");
		param.add(sCReRelation.getSid());
		param.add(sCReRelation.getCid());
		
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
	
	//返回所有预定人数
	public int countPerson(int cid) {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		
		List<Map<String,Object>> resultlist = new ArrayList<Map<String,Object>>();
		param.add(cid);
		String sql = "select count(sid) as totalrecord from sc_re_relation where cid=? and dflag=0";
		resultlist = dbUtil.findResult(sql, param);
		Map<String,Object> countmap=resultlist.get(0);
		int totalRecord=Integer.parseInt(String.valueOf(countmap.get("totalrecord")));
		
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return totalRecord;
	}


	
	public Pager<SCReRelation> findSCReRelationForPager(
			SCReRelation sCReRelationModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
				List<Object> param=new ArrayList<Object>();
				DBUtil  dbUtil=new DBUtil();
				dbUtil.getConnection();
				List<SCReRelation> dataList=new ArrayList<SCReRelation>(); 
				StringBuffer sql=new StringBuffer("select * from sc_re_relation where dflag=0");
				StringBuffer sqltotalRecord=new StringBuffer("select count(sid) as totalrecord from sc_re_relation where dflag=0");
				
				if(!StringUtil.isNullString(sCReRelationModel.getSid())){
					sql.append(" and sid=?");
					sqltotalRecord.append(" and sid=?");
					param.add(sCReRelationModel.getSid());
				}
				if(sCReRelationModel.getCid()>0){
					sql.append(" and cid = ?");
					sqltotalRecord.append(" and cid = ?");
					param.add(sCReRelationModel.getCid());
				}
				if(!StringUtil.isNullString(sCReRelationModel.getDate())){
					sql.append(" and date like ?");
					sqltotalRecord.append(" and date like ?");
					param.add(sCReRelationModel.getDate());
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
					SCReRelation u=new SCReRelation(map);
					dataList.add(u);
				}
				
				//获取总页数
				int totalPage=totalRecord/pageSize;
				if(totalRecord%pageSize!=0){
					totalPage++;
				}
				
				//封装Pager
				Pager<SCReRelation> result=new Pager<SCReRelation>(pageSize, pageNum, totalRecord, totalPage, dataList);
				
				
				if(dbUtil!=null)
				{	
					dbUtil.closeAll();
					dbUtil=null;
				}
				return result;
	}

 
}
