package DAOIMP;

import java.util.ArrayList;

import Main.Course;

public interface CourseDAOIMP {
	public ArrayList<Course> selectcourse();
	public boolean insertcourse(String s_no,Course course);
	public ArrayList<Course> querycourse(String s_no);
	public ArrayList<Course> querycourse(String s_no,int fromIndex,int offset);
	public int getCourseCount(String s_no);
}
