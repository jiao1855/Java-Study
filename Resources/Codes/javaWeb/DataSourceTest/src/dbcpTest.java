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

public class dbcpTest {
	
	@Test
	public void test() {
		
		try {
			BasicDataSource db = new BasicDataSource();
			db.setDriverClassName("com.mysql.jdbc.Driver");
			db.setUrl("jdbc:mysql://127.0.0.1:3306/javaweb_stumanage");
			db.setUsername("root");
			db.setPassword("jyq");
			Connection conn = db.getConnection();			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			BasicDataSourceFactory dbFactory = new BasicDataSourceFactory();
			Properties properties = new Properties();
			InputStream inStream = new FileInputStream("src//dbcpconfig.properties");
			properties.load(inStream);
			DataSource db = dbFactory.createDataSource(properties);
			Connection conn = db.getConnection();			
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
	
}
