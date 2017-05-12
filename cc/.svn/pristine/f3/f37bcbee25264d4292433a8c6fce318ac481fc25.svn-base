package com.entity;

import java.util.Map;

import com.args.Constant;

public class SCReRelation {
	private String sid;
	private int cid;
	private String date;
	private String remark;//备注
	private int dflag;
	
	public SCReRelation(){
		dflag = Constant.NOTDELETE;
	}
	
	public SCReRelation(String sid, int cid, String date,
			String remark,int dflag) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.date = date;
		this.remark = remark;
		this.dflag = dflag;
	}
	
	public SCReRelation(Map<String, Object> map) {
		this.sid =(String)map.get("sid");
		this.cid =(Integer)map.get("cid");
		this.date =(String)map.get("date");
		this.remark =(String)map.get("remark");
		this.dflag = (Integer)map.get("dflag");
	}
	
	public String getSid() {return sid;}
	public void setSid(String sid) {this.sid = sid;}
	public int getCid() {return cid;}
	public void setCid(int cid) {this.cid = cid;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	
	public String getRemark() {return remark;}

	public void setRemark(String remark) {this.remark = remark;}

	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}
	
	
}
