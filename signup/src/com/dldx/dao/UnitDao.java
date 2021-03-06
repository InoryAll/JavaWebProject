package com.dldx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dldx.util.DBUtil;

public class UnitDao {
	public String queryUnit() throws SQLException {
		Connection connection=DBUtil.getConnection();
		String sql="select distinct unit from unit";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		StringBuffer sf=new StringBuffer();
		boolean flag=false; //判空标志
		sf.append("[");
		while (resultSet.next()) {
			flag=true;
			sf.append("\""+resultSet.getString("unit")+"\""+",");
		}
		if (flag) {
			sf.deleteCharAt(sf.length()-1);
		}
		sf.append("]");
		String units=new String(sf);
		DBUtil.closeConnection(connection, preparedStatement, resultSet);
		System.out.println(units);
		return units;
	}
	
	public String queryPost(String unit) throws SQLException{
		Connection connection=DBUtil.getConnection();
		String sql="select distinct post from unit where unit='"+unit+"'";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		StringBuffer sf=new StringBuffer();
		boolean flag=false; //判空标志
		sf.append("[");
		while (resultSet.next()) {
			String post=resultSet.getString("post");
			if (post!=null) {
				flag=true;
				sf.append("\""+post+"\""+",");
			}
		}
		if (flag) {
			sf.deleteCharAt(sf.length()-1);
		}
		sf.append("]");
		String posts=new String(sf);
		System.out.println(posts);
		return posts;
	}
	
	public String queryEduDegOth(String unit,String post) throws SQLException {
		Connection connection= DBUtil.getConnection();
		String sql="select * from unit where unit ='"+unit+"' and post='"+post+"'";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		StringBuffer sf=new StringBuffer();
		int flag=0; //判空标志
		sf.append("[");
		while (resultSet.next()) {
			if (resultSet.getString("education")!=null) {
				flag++;
				sf.append("\""+resultSet.getString("education")+"\""+",");
			}
			if (resultSet.getString("degree")!=null) {
				flag++;
				sf.append("\""+resultSet.getString("degree")+"\""+",");
			}
			if (resultSet.getString("other")!=null) {
				flag++;
				sf.append("\""+resultSet.getString("other")+"\""+",");
			}
		}
		if (flag>0) {
			sf.deleteCharAt(sf.length()-1);
		}
		sf.append("]");
		String result=new String(sf);
		/*System.out.println(result);*/
		return result;
	}
	
	/*public static void main(String[] args) throws SQLException {
		new UnitDao().queryUnit();
		new UnitDao().queryPost("大连中山医院");
		new UnitDao().queryEduDegOth("大连大学","教师A");
	}*/
}
