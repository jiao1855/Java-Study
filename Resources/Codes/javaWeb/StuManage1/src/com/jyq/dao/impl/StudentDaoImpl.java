package com.jyq.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jyq.dao.StudentDao;
import com.jyq.domain.Student;
import com.jyq.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query("select * from stu",new BeanListHandler<Student>(Student.class));		
	}

	@Override
	public void addStudent(Student stu) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
				stu.getSname(),
				stu.getGender(),
				stu.getPhone(),
				stu.getBirthday(),
				stu.getHobby(),
				stu.getInfo());
	}

	@Override
	public void deleteStudent(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		runner.update("delete from stu where sid=?",sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query("select * from stu where sid=?",new BeanHandler<Student>(Student.class),sid);
	}

	@Override
	public void updateStudent(Student stu) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		runner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
				stu.getSname(),
				stu.getGender(),
				stu.getPhone(),
				stu.getBirthday(),
				stu.getHobby(),
				stu.getInfo(),
				stu.getSid());
	}

	@Override
	public List<Student> findStudents(String name, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		
		String sql = "select * from stu where 1=1 ";
		List<String> params = new ArrayList<String>(); 
		if(name!=null && !name.equals("")) {
			sql+=" and sname like ? ";
			params.add("%"+name+"%");
		}
		if(gender!=null && !gender.equals("")) {
			sql+=" and gender like ? ";
			params.add(gender);
		}
		
		return runner.query(sql, new BeanListHandler<Student>(Student.class),params.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int pageSize, int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
		return runner.query("select * from stu limit ? offset ?", 
				new BeanListHandler<Student>(Student.class),pageSize,(currentPage-1)*pageSize);
	}

	@Override
	public int findTotalSize() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Long totalSize = (Long)runner.query("select count(*) from stu",new ScalarHandler());
		return totalSize.intValue();
	}

}
