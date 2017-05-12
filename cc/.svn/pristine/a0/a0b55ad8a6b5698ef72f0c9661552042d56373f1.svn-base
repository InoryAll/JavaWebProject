package com.entity;

import java.util.Map;

import com.args.Constant;

public class Admin extends Person{
	private String id;
	private String name;
	private String password;
	private String gender;
	private String email;
	private String tel;
	private int pflag;
	private int dflag;
	
	public Admin(){
		pflag = Constant.POWER_ADMIN;
		dflag = Constant.NOTDELETE;
	}
	
	public Admin(String id, String name, String password, String gender,
			String email, String tel, int pflag, int dflag) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.tel = tel;
		this.pflag = pflag;
		this.dflag = dflag;
	}

	public Admin(Map<String,Object> map){
		this.id =(String)map.get("id");
		this.name =(String)map.get("name");
		this.password =(String)map.get("password");
		this.gender =(String)map.get("gender");
		this.email =(String)map.get("email");
		this.tel =(String)map.get("tel");
		this.pflag =(Integer)map.get("pflag");
		this.dflag =(Integer)map.get("dflag");
		
	}
	

	public String getId() {return id;}
	
	public void setId(String id) {this.id = id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getPassword() {return password;}
	
	public void setPassword(String password) {this.password = password;}
	
	public String getGender() {return gender;}
	
	public void setGender(String gender) {this.gender = gender;}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPflag() {return pflag;}
	
	public void setPflag(int pflag) {this.pflag = pflag;}
	
	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}
	
	
}
