package Util;

import java.sql.Connection;
/*
 * DB连接测试方法
 */
public class test {
	public static void main(String[] args) {
		Connection conn=null;
		conn=DButil.getConnection();
		if(conn!=null)
		{
			System.out.println("Success!");
			DButil.close(conn,null,null);
		}
		else
		{
			System.out.println("Fail!");
		}
	}
}
