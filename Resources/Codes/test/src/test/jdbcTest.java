package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

public class jdbcTest {

	public static void main(String[] args) throws Exception {
		// insertImg("D:\\Java\\Java-Study\\Resources\\JavaSE\\13MySql和JDBC\\1.png");

		
	}

	/**
	 * @param imgName
	 * @throws Exception
	 */
	public static void insertImgTest(String imgName) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		File f = new File(imgName);
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");
				// 通过这种PreparedStatement创建的ResultSet就是可滚动可更新的
				PreparedStatement ps = conn.prepareStatement("insert into img_table values(null,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				InputStream is = new FileInputStream(f);) {
			ps.setString(1, imgName);
			ps.setBinaryStream(2, is);
			int affect = ps.executeUpdate();
			System.out.println(affect);
		}
	}

	// String sql = "select * from stu";
	// preparedStatementUpdateableTest(sql);
	/**
	 * @param sql
	 * @throws Exception
	 */
	public static void preparedStatementUpdateableTest(String sql) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");

				// 通过这种PreparedStatement创建的ResultSet就是可滚动可更新的
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = ps.executeQuery();) {
			if (rs.last()) {
				// 修改记录指针所指行，特定列的值
				// 发出Error:Incorrect string value: '\xC4\xD0' for column
				// 'gender' at row 1
				rs.updateString(2, "jyq");
				// 提交修改
				rs.updateRow();
			}
		}
	}

	public static void CallableStatementTest() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		try (
				// 2.使用DriverManager获取数据库连接
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");

				// 3.使用Connection创建一个CallableStatement对象
				CallableStatement cp = conn.prepareCall("{call add_pro_test(?,?,?)}");) {
			cp.setInt(1, 4);
			cp.setInt(2, 8);
			// 注册存储过程的传出参数是int类型
			cp.registerOutParameter(3, Types.INTEGER);
			// 执行并输出存储过程的传出参数
			cp.execute();
			System.out.println(cp.getInt(3));
		}
	}

	// String sql = "insert into stu values(null,?,?,?)";
	// preparedStatementTest(sql);
	public static void preparedStatementTest(String sql) throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		try (
				// 2.使用DriverManager获取数据库连接
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");

				// 3.使用Connection创建一个Statment对象
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, "test");
			ps.setString(2, "男");
			ps.setInt(3, 32);

			int rel = ps.executeUpdate();
			System.out.println(rel);
		}
	}

	public static void jdbcStepTest() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		try (
				// 2.使用DriverManager获取数据库连接
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");

				// 3.使用Connection创建一个Statment对象
				Statement stmt = conn.createStatement();

				// 4.执行SQL语句
				ResultSet rs = stmt.executeQuery("select * from stu")) {
			// 5.操作结果集
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			}
		}
	}

	public static void jdbcStepTest2() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		try (
				// 2.使用DriverManager获取数据库连接
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useSSL=true&user=root&password=root");

				// 3.使用Connection创建一个Statment对象
				Statement stmt = conn.createStatement();

				// 4.执行SQL语句
				ResultSet rs = stmt.executeQuery("select * from stu")) {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnType(i) + " "
						+ metaData.getColumnTypeName(i));
			}
		}
	}

}
