package Factory;


import DAOIMP.CourseDAOIMP;
import DAOIMP.JudgeDAOIMP;
import DAOIMP.StudentDAOIMP;


public abstract class Factory {
	public static FactoryMysql getFactoryMysql() {
		return new FactoryMysql();
	}

	public static FactoryOracle getFactoryOracle() {
		return new FactoryOracle();
	}

	public abstract StudentDAOIMP getStudentDAO();
	public abstract CourseDAOIMP getCourseDAO();
	public abstract JudgeDAOIMP getJudgeDAO();
	
}
