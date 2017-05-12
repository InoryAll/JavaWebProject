package com.util;

import java.util.Set;

public class StringUtil {
	//判断是否为空字符串
	public static boolean isNullString(String s){
		if(s==null||"".equals(s.trim())){
			return true;
		}
		return false;
	}
	public static boolean isNullString(StringBuffer sb){
		if(sb==null||"".equals(sb.toString().trim())){
			return true;
		}
		return false;
	}
	//判断随机生成的id是否已存在	
	public static boolean isExist(Set<String> idset,String s){
		int size=idset.size();
		idset.add(s);
		if(size<idset.size()){
			return false;
		}
		return true;
	}
	//返回新的id
	public  static String returnNewIdbyMaxId(String s){
		int len=s.length();
		long a=Long.valueOf(s);
		a=a+1;
		s=String.valueOf(a);
		if(s.length()<len){
			int cnt=len-s.length();
			for(int i=0;i<cnt;i++){
				s="0"+s;
			}
		}
		return s;
	}
	//返回新的id
	public  static String returnLongId(String s){
		int len=12;
		if(s.length()<len){
			int cnt=len-s.length();
			for(int i=0;i<cnt;i++){
				s="0"+s;
			}
		}
		return s;
	}
	
	public static String getSex(String usex) {
		String gender="";
		if(usex.equals("0")||"0".equals(usex))
			gender="男";
		else if(usex.equals("1")||"1".equals(usex)){
			gender="女";
		}
		return gender;
	}

}
