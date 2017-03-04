package DAOIMP;

import java.util.ArrayList;

import Main.Judge;

public interface JudgeDAOIMP {
	public  ArrayList<Judge> gojudge(String s_no);
	public boolean insertjudge(String s_no,Judge judges);
	public boolean isJudge(String s_no);
}
