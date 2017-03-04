package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAOIMP.JudgeDAOIMP;
import Main.Judge;
import Util.DBUtil;

public class JudgeDAO implements JudgeDAOIMP{
	 public  ArrayList<Judge> gojudge(String s_no){
		 ArrayList<Judge> judges=new ArrayList<Judge>();
		 String sql="";
		 Connection conn=DBUtil.getConnection();
		 Statement stmt=null;
		 ResultSet rs=null;
		
		 sql="select * from s_c,course,t_c,teacher where course.c_no=t_c.c_no and t_c.t_no=teacher.t_no and s_c.c_no=course.c_no and s_c.s_no="+s_no+"";
		 try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Judge new_judge=new Judge();
				new_judge.setC_no(rs.getString("c_no"));
				new_judge.setC_name(rs.getString("c_name"));
				new_judge.setC_score(rs.getString("c_score"));
				new_judge.setT_no(rs.getString("t_no"));
				new_judge.setT_name(rs.getString("t_name"));
				judges.add(new_judge);
			}
			return judges;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		 return null;
	 }
	 public boolean insertjudge(String s_no,Judge judges)
	 {
		 String sql="";
		 Connection conn=DBUtil.getConnection();
		 Statement stmt=null;
		 sql="insert into judge values('"+s_no+"','"+judges.getC_no()+"','"+judges.getT_no()+"','"+judges.getT_look()+"','"+judges.getT_height()+"','"+judges.getT_attitude()+"','"+judges.getT_way()+"','"+judges.getT_atmos()+"','"+judges.getAdvice()+"')";
		 try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, null);
		}
		 return false;
	 }
	 
	 public boolean isJudge(String s_no){
		 String sql="";
		 Connection conn=DBUtil.getConnection();
		 Statement stmt=null;
		 ResultSet rs=null;
		 sql="select * from judge where s_no='"+s_no+"'";
		 Judge jd=new Judge();
		 try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				jd.setC_no(rs.getString("c_no"));
				jd.setT_no(rs.getString("t_no"));
			}
			if(jd.getC_no()!=null&&!jd.getC_no().equals(""))
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		 return false;
	 }
	 
}
