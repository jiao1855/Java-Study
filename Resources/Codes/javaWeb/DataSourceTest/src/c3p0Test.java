import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Test {
	
	@Test
	public void test() {		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/javaweb_stumanage");
			cpds.setUser("root");
			cpds.setPassword("jyq");
			Connection conn = cpds.getConnection();			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			//默认加载“c3p0-config.xml”名字的配置文件
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection conn = cpds.getConnection();			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();			
			st = conn.createStatement();
			rs = st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
}
