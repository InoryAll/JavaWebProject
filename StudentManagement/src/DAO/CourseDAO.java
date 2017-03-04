package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DAOIMP.CourseDAOIMP;
import Main.Course;
import Util.DBUtil;

public class CourseDAO implements CourseDAOIMP{
	
	/*选课功能*/
	public ArrayList<Course> selectcourse()
	{
		String sql="";
		Connection conn=DBUtil.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		sql="select * from course,t_c,teacher where course.c_no=t_c.c_no and t_c.t_no=teacher.t_no";
		ArrayList<Course> courses=new ArrayList<Course>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Course new_course=new Course();
				new_course.setC_no(rs.getString("c_no"));
				new_course.setC_name(rs.getString("c_name"));
				new_course.setC_score(rs.getString("c_score"));
				new_course.setT_no(rs.getString("t_no"));
				new_course.setT_name(rs.getString("t_name"));
				courses.add(new_course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}
	
	/*分页选出所有课程*/
	public ArrayList<Course> querycourse(String s_no,int fromIndex,int offset)
	{
		String sql="";
		Connection conn=DBUtil.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		sql="select * from student,course,s_c,t_c,teacher where student.s_no=s_c.s_no and course.c_no=s_c.c_no and t_c.c_no=course.c_no and t_c.t_no=teacher.t_no and student.s_no='"+s_no+"'";
		sql+=" limit "+fromIndex+" ,"+offset;
		ArrayList<Course> course_list=new ArrayList<Course>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Course new_course=new Course();
				new_course.setC_no(rs.getString("c_no"));
				new_course.setC_name(rs.getString("c_name"));
				new_course.setC_score(rs.getString("c_score"));
				new_course.setT_no(rs.getString("t_no"));
				new_course.setT_name(rs.getString("t_name"));
				course_list.add(new_course);
			}
			return course_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}
	
	/*得到课程的数目*/
	public int getCourseCount(String s_no)
	{
		int count=0;
		String sql="";
		Connection conn=DBUtil.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		sql="select count(*) from student,course,s_c,t_c,teacher where student.s_no=s_c.s_no and course.c_no=s_c.c_no and t_c.c_no=course.c_no and t_c.t_no=teacher.t_no and student.s_no='"+s_no+"'";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*插入所选课程*/
	public boolean insertcourse(String s_no,Course course){
		
		String sql="";
		Connection conn=DBUtil.getConnection();
		Statement stmt=null;
		sql="insert into s_c values('"+s_no+"','"+course.getC_no()+"')";
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
	
	/*查看已选课程*/
	public ArrayList<Course> querycourse(String s_no) {
		Connection conn=DBUtil.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		String sql="";
		ArrayList<Course> select_course_list=new ArrayList<Course>();
		sql="select * from student,course,s_c,t_c,teacher where student.s_no=s_c.s_no and course.c_no=s_c.c_no and t_c.c_no=course.c_no and t_c.t_no=teacher.t_no and student.s_no='"+s_no+"'";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Course new_course=new Course();
				new_course.setC_no(rs.getString("c_no"));
				new_course.setC_name(rs.getString("c_name"));
				new_course.setC_score(rs.getString("c_score"));
				new_course.setT_no(rs.getString("t_no"));
				new_course.setT_name(rs.getString("t_name"));
				select_course_list.add(new_course);
			}
			return select_course_list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt, rs);
		}
		return null;
	}
}
