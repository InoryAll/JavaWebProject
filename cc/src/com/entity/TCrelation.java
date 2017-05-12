package com.entity;

import com.args.Constant;

public class TCrelation {
	private String tid;
	private int cid;
	private String date;
	private int dflag;
	
	public TCrelation(){
		dflag = Constant.NOTDELETE;
	}
	
	public TCrelation(String tid, int cid, String date, int dflag) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.date = date;
		this.dflag = dflag;
	}

	public String getTid() {return tid;}
	
	public void setTid(String tid) {this.tid = tid;}
	
	public int getCid() {return cid;}
	
	public void setCid(int cid) {this.cid = cid;}
	
	public String getDate() {return date;}
	
	public void setDate(String date) {this.date = date;}
	
	public int getDflag() {return dflag;}
	
	public void setDflag(int dflag) {this.dflag = dflag;}
}
