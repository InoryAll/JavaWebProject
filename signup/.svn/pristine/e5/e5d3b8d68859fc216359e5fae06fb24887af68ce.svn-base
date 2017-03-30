package com.dldx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dldx.entity.Persson;
import com.dldx.util.DBUtil;

public class PerssonDao {
	public int addPersson(Persson persson) throws SQLException{
		Connection connection =DBUtil.getConnection();
		String sql="insert into persson (name,sex,idcard,political,photo,work,"
				+ "telephone,punit,ppost,education,"
				+ "degree,birthday,degschool,degmajor,pother,other) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt=connection.prepareStatement(sql);
		ptmt.setString(1, persson.getName());
		ptmt.setString(2, persson.getSex());
		ptmt.setString(3, persson.getIdcard());
		ptmt.setString(4, persson.getPolitical());
		ptmt.setString(5, persson.getPhoto());
		ptmt.setString(6, persson.getWork());
		ptmt.setString(7, persson.getTelephone());
		ptmt.setString(8, persson.getPunit());
		ptmt.setString(9, persson.getPpost());
		ptmt.setString(10, persson.getEducation());
		ptmt.setString(11, persson.getDegree());
		ptmt.setString(12, persson.getBirthday());
		ptmt.setString(13, persson.getDegschool());
		ptmt.setString(14, persson.getDegmajor());
		ptmt.setString(15, persson.getPother());
		ptmt.setString(16, persson.getOther());
		int flag=ptmt.executeUpdate();
		DBUtil.closeConnection(connection, ptmt);
		System.out.println(flag);
		return flag;
	}
	
	public int CheckIdCard(String idcard) throws SQLException{
		Connection connection=DBUtil.getConnection();
		String sql="select id from persson where idcard = '"+idcard+"'";
		PreparedStatement ptmt=connection.prepareStatement(sql);
		ResultSet  resultSet=ptmt.executeQuery();
		int flag=0;
		if (resultSet.next()) {
			flag=Integer.parseInt(resultSet.getString("id"));
		}
		DBUtil.closeConnection(connection, ptmt, resultSet);
		return flag;
	}
/*	public static void main(String[] args) throws SQLException {
		System.out.println(new PerssonDao().CheckIdCard("321088199606014132"));
	}*/
}
