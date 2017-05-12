package com.service;

import java.util.List;

import com.dao.SCReRelationDao;
import com.entity.SCReRelation;
import com.entity.Pager;

public class SCReRelationService {
	private SCReRelationDao sCReRelationDao;
	
	public SCReRelationService(){
		sCReRelationDao = new SCReRelationDao();
	}
	
	public Pager<SCReRelation> findSCReRelationForPager(SCReRelation sCReRelationModel, int pageNum, int pageSize){
		Pager<SCReRelation> result = sCReRelationDao.findSCReRelationForPager(sCReRelationModel, pageNum,
				pageSize);
		return result;
	}
	//修改信息
	public boolean updateSCReRelation(SCReRelation sCReRelation){
		if(sCReRelationDao.update(sCReRelation)){
			return true;
		}
		return false;
	}
	
	
	
	public boolean insertSCReRelation(SCReRelation scrr){
		if(sCReRelationDao.insert(scrr)){
			return true;
		}
		return false;
	}

	/*功能：判断该关系是否存在
	 *参数：课程id，学生id
	 *返回值：存在返回true 不存在返回 false
	 * */
	public boolean isexist(String cid, String sid) {
		// TODO Auto-generated method stub
		SCReRelation sc = null;
		sc = sCReRelationDao.findOne(cid,sid);
		if(sc!=null){
			return true;
		}
		return false;
	}
	
	public boolean delete(int cid, String sid){
		
		SCReRelation sc= new SCReRelation();
		sc.setCid(cid);
		sc.setSid(sid);
		return sCReRelationDao.delete(sc);
	}

	public SCReRelation findOneSCReRelation(String cid, String sid) {
		SCReRelation sc = sCReRelationDao.findOne(cid, sid);
		if(sc != null) return sc;
		return null;
	}

	public List<Integer> findCidbySid(String sid) {
		// TODO Auto-generated method stub
		
		return sCReRelationDao.findCidbySid(sid);
	}
	

}
