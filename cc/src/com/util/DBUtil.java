package com.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;





public class DBUtil {
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/cc?useUnicode=true&characterEncoding=UTF-8";
	private final static String username = "root";
	private final static String password = "123456";
//	private final static String url = "jdbc:mysql://10.66.182.50:3306/cc?useUnicode=true&characterEncoding=UTF-8";
//	private final static String username = "root";
//	private final static String password = "zjq1996518";
//	
	
	//public static Connection conn=null;
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	//	static{
	//		try {
	//			Class.forName(driver);
	//		} catch (ClassNotFoundException e) {
	//			e.printStackTrace();
	//		}
	//	}
	public static DataSource ds = null;
	
	static {
		ComboPooledDataSource cp = new ComboPooledDataSource(); 
		try {
			cp.setDriverClass(driver);
			cp.setUser(username);
			cp.setJdbcUrl(url);
			cp.setPassword(password);
			cp.setInitialPoolSize(100);
			cp.setMaxPoolSize(500);
			ds=cp;
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  Connection getConnection() {
		
		try {
			return conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn==null){
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {

				conn=DriverManager.getConnection(url,username, password);


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;
	}

	public  void closeAll() {
		try {
			if(pstm!=null){
				pstm.close();
				pstm=null;
			}if(rs!=null){
				rs.close();
				rs=null;
			}
			if (conn != null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void closeAll(Connection con , Statement st ,ResultSet rt) {
		try {
			if(rt!=null){
				rt.close();
				rt=null;
			}
			if(st!=null){
				st.close();
				st=null;
			}
			if (conn != null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean excutePUpdate(String sql,List<?> param){
		int row=-1;
		try {
			pstm=conn.prepareStatement(sql);
			if(param!=null&&!param.isEmpty()){
				for(int i=0;i<param.size();i++){
					pstm.setObject(i+1,param.get(i));
				}
			}
			row=pstm.executeUpdate();
			if(row>0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Map<String,Object>> findResult(String sql,List<?> param) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try {

			pstm=conn.prepareStatement(sql);
			if(param!=null&&!param.isEmpty()){
				for(int i=0;i<param.size();i++){
					pstm.setObject(i+1,param.get(i));
				}
			}
			rs=pstm.executeQuery();
			ResultSetMetaData metaData= rs.getMetaData();
			int col_count=metaData.getColumnCount();

			while(rs.next()){

				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=0;i<col_count;i++){
					String col_name=metaData.getColumnName(i+1).toLowerCase();
					Object value=rs.getObject(col_name);
					if(value==null){
						value="";
					}
					map.put(col_name, value);
				}
				list.add(map);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
