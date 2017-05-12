package com.entity;

import java.util.Map;
import com.args.Constant;

public class Person {
	private String id;
	private String name;
	private String password;
	private int pflag;
	private int dflag;
	
	public Person() {
		pflag = Constant.POWER_STUDENT;
		dflag = Constant.NOTDELETE;
	}
	
	public Person(String id, String name, String password, String gender,
			int pflag, int dflag) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.pflag = pflag;
		this.dflag = dflag;
	}

	public Person(Map<String, Object> map) {
		this.id =(String)map.get("id");
		this.name =(String)map.get("name");
		this.password =(String)map.get("password");
		this.dflag = (Integer)map.get("dflag");
		this.pflag = (Integer)map.get("pflag");
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public int getDflag() {
		return dflag;
	}
	public void setDflag(int dflag) {
		this.dflag = dflag;
	}
}
