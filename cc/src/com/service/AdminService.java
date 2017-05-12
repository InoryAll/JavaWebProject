package com.service;

import com.dao.AdminDao;
import com.entity.Admin;
import com.entity.Pager;

public class AdminService {
	private AdminDao adminDao;
	
	public AdminService(){
		adminDao = new AdminDao();
	}
	
	public Pager<Admin> findAdminForPager(Admin adminModel, int pageNum, int pageSize){
		Pager<Admin> result = adminDao.findAdminForPager(adminModel, pageNum,
				pageSize);
		return result;
	}
	//修改密码
	public boolean updatePassword(String id,String password){
		Admin admin = new Admin();
		admin.setId(id);
		admin.setPassword(password);
		if(adminDao.update(admin)){
			return true;
		}
		return false;
	}
	//修改信息
	public boolean updateAdmin(Admin admin){
		if(adminDao.update(admin)){
			return true;
		}
		return false;
	}
	//修改权限，注：必须有超级管理员权限
	public boolean updatePower(String id,int pflag){
		Admin admin = new Admin();
		admin.setId(id);
		admin.setPflag(pflag);
		if(adminDao.update(admin)){
			return true;
		}
		return false;
	}

}
