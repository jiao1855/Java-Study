import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class dbutilsTest {

	//默认加载“c3p0-config.xml”名字的配置文件
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static QueryRunner run =new QueryRunner(dataSource);
	
	@Test
	public void insertTest() throws SQLException {	
		String sql = "insert into student values(null,?,?,?,?)";
		int result = run.update(sql,"jyq",32,"男","长安");
		System.out.println(result);
	}
	
	@Test
	public void deleteTest() throws SQLException {
		String sql = "delete from student where id = ?";
		int result = run.update(sql,6);
		System.out.println(result);
	}
	
	@Test
	public void updateTest() throws SQLException {
		String sql = "update student set name=? where id=?";
		int result = run.update(sql,"黄忠",7);
		System.out.println(result);
	}
	
	@Test
	public void queryTest() throws SQLException {
		String sql = "select * from student where id = ?";
		Student stu = run.query(sql, new ResultSetHandler<Student>() {
			@Override
			public Student handle(ResultSet rs) throws SQLException {
				Student stu = new Student();
				if(rs.next()) {
					stu.setId(rs.getInt("id"));
					stu.setName(rs.getString("name"));
					stu.setAge(rs.getInt("age"));
					stu.setGender(rs.getString("gender"));
					stu.setAddress(rs.getString("address"));
				}
				return stu;
			}},7);
		System.out.println(stu);
	}
	
	@Test
	public void queryBeanTest() throws SQLException {
		String sql = "select * from student where id = ?";
		Student stu = run.query(sql,new BeanHandler<Student>(Student.class),7);
		System.out.println(stu);
	}
	
	@Test
	public void queryBeanListTest() throws SQLException {
		String sql = "select * from student";
		List<Student> stus = run.query(sql,new BeanListHandler<Student>(Student.class));
		for (Student student : stus) {
			System.out.println(student);
		}
	}
}
