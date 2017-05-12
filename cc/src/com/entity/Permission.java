package com.entity;

import java.util.Map;

import com.args.Constant;

public class Permission {
	private int id;
	private String name;
	private int level;
	private int parentid;
	private int power;
	private int dflag;
	
	public Permission(){
		dflag = Constant.NOTDELETE;
	}
	
	public Permission(int id, String name, int level, int parentid, int power,
			int dflag) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parentid = parentid;
		this.power = power;
		this.dflag = dflag;
	}
	public Permission(Map<String,Object> map){
		this.id =(Integer)map.get("id");
		this.name =(String)map.get("name");
		this.level =(Integer)map.get("level");
		this.parentid =(Integer)map.get("parentid");
		this.power =(Integer)map.get("power");
		this.dflag =Integer.valueOf((String)map.get("dflag"));
		
	}

	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public int getLevel() {return level;}
	
	public void setLevel(int level) {this.level = level;}
	
	public int getParentid() {return parentid;}
	
	public void setParentid(int parentid) {this.parentid = parentid;}
	
	public int getPower() {return power;}
	
	public void setPower(int power) {this.power = power;}
	
	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}
	
	
}
