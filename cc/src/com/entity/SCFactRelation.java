package com.entity;

import java.util.Map;

import com.args.Constant;

public class SCFactRelation {
	private String sid;
	private int cid;
	private String date;
	private int grade;//评分
	private String evaluate;//评价
	private String remark;//备注
	private int dflag;
	
	public SCFactRelation(){
		dflag = Constant.NOTDELETE;
		grade = 0;
	}
	
	public SCFactRelation(String sid, int cid, String date,int grade,
			String evaluate,String remark,int dflag) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.date = date;
		this.grade = grade;
		this.evaluate = evaluate;
		this.remark = remark;
		this.dflag = dflag;
	}
	public SCFactRelation(Map<String, Object> map) {
		this.sid =(String)map.get("sid");
		this.cid =(Integer)map.get("cid");
		this.date =(String)map.get("date");
		this.grade = (Integer)map.get("grade");
		this.evaluate =(String)map.get("evaluate");
		this.remark =(String)map.get("remark");
		this.dflag = (Integer)map.get("dflag");
	}
	
	public String getSid() {return sid;}
	public void setSid(String sid) {this.sid = sid;}
	public int getCid() {return cid;}
	public void setCid(int cid) {this.cid = cid;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	
	public int getGrade() {return grade;}

	public void setGrade(int grade) {this.grade = grade;}

	public String getEvaluate() {return evaluate;}

	public void setEvaluate(String evaluate) {this.evaluate = evaluate;}

	public String getRemark() {return remark;}

	public void setRemark(String remark) {this.remark = remark;}

	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}
	
	
}
