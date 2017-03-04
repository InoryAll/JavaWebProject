package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DaoImp.UserDaoImp;
import Main.User;
import Util.DButil;
/*
 * User类方法：登录、测试方法
 */
public class UserDao implements UserDaoImp{
	public User login(String username){
		Connection conn=DButil.getConnection();
		String sql="select * from user where username='"+username+"'";
		Statement stmt=null;
		ResultSet rs=null;
		User us=new User();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
			}
			if(us.getUsername()==null)
			{
				return null;
			}
			else
			{
				return us;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn, stmt, rs);
		}
		return null;
	}
	public static void main(String[] args) {
		UserDao usd=new UserDao();
		User us=null;
		us=usd.login("110873204");
		if(us!=null)
		{
			System.out.println("Success!");
			System.out.println(us.getUsername()+'\n'+us.getPassword());
		}
		else
		{
			System.out.println("Fail!");
		}
		
	}
}
