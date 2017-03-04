package DAO;

import java.sql.*;
import java.util.ArrayList;
import DAOIMP.StudentDAOIMP;
import Main.Student;
import Util.DBUtil;

public class StudentDAO implements StudentDAOIMP {
	
	/*登录验证*/
	public Student select(String s_no) {
		Connection conn = DBUtil.getConnection();
		String sql;
		ResultSet rs = null;
		Statement st = null;
		Student su = new Student();
		sql = "select * from student where s_no='" + s_no + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				su.setS_no(rs.getString("s_no"));
				su.setS_name(rs.getString("s_name"));
				su.setS_pwd(rs.getString("s_pwd"));
				return su;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, st, rs);
		}
		return null;
	}
	
	/*注册*/
	public boolean add(Student stu) {
		String sql;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		sql = "insert into student values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getS_no());
			ps.setString(2, stu.getS_name());
			ps.setString(3, stu.getS_sex());
			ps.setString(4, stu.getS_pwd());
			ps.setString(5, stu.getS_dept());
			ps.setString(6, stu.getS_class());
			ps.setString(7, stu.getS_connect());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, null);
		}

		return false;
	}
	/*查询所有班级*/
	public ArrayList<String> selectclasses()
	{
		String sql;
		ArrayList<String> classes=new ArrayList<String>();
		Connection conn=DBUtil.getConnection();
		ResultSet rs=null;
		Statement stmt=null;
		sql="select distinct student.s_class from student";
		String new_classes="";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				new_classes=rs.getString("s_class");
				classes.add(new_classes);
			}
			return classes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}
	
	/*查询所有专业*/
	public ArrayList<String> selectdepartment(){
		String sql="";
		ArrayList<String> departments=new ArrayList<String>();
		ResultSet rs=null;
		Statement stmt=null;
		sql="select distinct student.s_dept from student";
		String new_department="";
		Connection conn=DBUtil.getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				new_department=rs.getString("s_dept");
				departments.add(new_department);
			}
			return departments;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}
	
	
}
