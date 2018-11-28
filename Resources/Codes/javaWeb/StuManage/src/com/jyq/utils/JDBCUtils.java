package com.jyq.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JDBCUtils {
	
	static String driverName;
	static String url;
	static String userName;
	static String password;
	
	static{		
		try {
			Properties properties = new Properties();
			//InputStream inStream = new FileInputStream("jdbc.properties");
			InputStream inStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(inStream);
			
			driverName = properties.getProperty("driverName");
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//1,��������
			Class.forName(driverName);
			//2����ȡ���ݿ�����
			conn = DriverManager.getConnection(url,userName,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void release(Connection conn,Statement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null) {
				ps.close();
			}					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAll2() throws Exception{
		//��ȡ���ݿ�����
		Connection conn = getConnection();
		//3������Statement����
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from stu");
		while(rs.next()){
			System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		rs.close();
		st.close();
		conn.close();		
	}
	
	@Test
	public void getAll() throws Exception{
		//1,��������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ���ݿ�����
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1", "root", "root");
		//3������Statement����
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from stu");
		while(rs.next()){
			System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		
		rs.close();
		st.close();
		conn.close();
	}
	
}
