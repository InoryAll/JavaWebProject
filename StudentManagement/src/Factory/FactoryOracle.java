package Factory;

import DAO.CourseDAO;
import DAO.JudgeDAO;
import DAO.StudentDAO;
import DAOIMP.CourseDAOIMP;
import DAOIMP.JudgeDAOIMP;
import DAOIMP.StudentDAOIMP;


public class FactoryOracle extends Factory {
	public StudentDAOIMP getStudentDAO() {
		return new StudentDAO();
	}
	public CourseDAOIMP getCourseDAO(){
		return new CourseDAO();
	}
	public JudgeDAOIMP getJudgeDAO(){
		return new JudgeDAO();
	}


}
