package com.service;

import com.dao.SCFactRelationDao;
import com.entity.SCFactRelation;
import com.entity.Pager;

public class SCFactRelationService {
	private SCFactRelationDao sCFactRelationDao;
	
	public SCFactRelationService(){
		sCFactRelationDao = new SCFactRelationDao();
	}
	
	public Pager<SCFactRelation> findSCFactRelationForPager(SCFactRelation sCFactRelationModel, int pageNum, int pageSize){
		Pager<SCFactRelation> result = sCFactRelationDao.findSCFactRelationForPager(sCFactRelationModel, pageNum,
				pageSize);
		return result;
	}
	//修改信息
	public boolean updateSCFactRelation(SCFactRelation SCFactRelation){
		if(sCFactRelationDao.update(SCFactRelation)){
			return true;
		}
		return false;
	}

	public boolean insertSCFactRelation(SCFactRelation scfr) {
		// TODO Auto-generated method stub
		if(sCFactRelationDao.insert(scfr)){
			return true;
		}
		return false;
	}

    public boolean isexist(String cid, String sid) {
		// TODO Auto-generated method stub
		SCFactRelation sc = null;
		sc = sCFactRelationDao.findOne(cid,sid);
		if(sc!=null){
			return true;
		}
		return false;
	}
    
	public boolean delete(SCFactRelation sc){
		
		return sCFactRelationDao.delete(sc);
	}
}
