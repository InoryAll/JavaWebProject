package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Person;
import com.util.DBUtil;

public class PersonDao {
	
	public Person login(Person person){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		param.add(person.getId());
		param.add(person.getPassword());
		person = null;
		String sql = "select * from person where dflag=0 and id = ? and password = ?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
			Map<String,Object> map = result.get(0);
			person = new Person(map);
		}
		if(dbUtil!=null)
		{	
			dbUtil.closeAll();
			dbUtil=null;
		}
		return person;
	}
	public boolean exist(String id){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		String sql = "select * from person where dflag=0 and id =?";
		List<Map<String,Object>> result = dbUtil.findResult(sql, param);
		if(result!=null && result.size()>0){
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
}
