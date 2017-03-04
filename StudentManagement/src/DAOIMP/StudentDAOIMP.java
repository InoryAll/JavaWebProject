package DAOIMP;

import java.util.ArrayList;

import Main.Student;

public interface StudentDAOIMP {
	public Student select(String s_no);
	public boolean add(Student stu);
	public ArrayList<String> selectclasses();
	public ArrayList<String> selectdepartment();
}
