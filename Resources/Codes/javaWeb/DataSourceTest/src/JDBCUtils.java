import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	static ComboPooledDataSource cpds = null;
	
	static{		
		//默认加载“c3p0-config.xml”名字的配置文件
		cpds = new ComboPooledDataSource();
	}
	
	public static Connection getConnection() throws SQLException{
		return cpds.getConnection();	
	}	
	
	public static void release(Connection conn,Statement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null) {
				ps.close();
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
