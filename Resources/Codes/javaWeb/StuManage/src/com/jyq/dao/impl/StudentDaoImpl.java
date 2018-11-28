package com.jyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jyq.dao.StudentDao;
import com.jyq.domain.Student;
import com.jyq.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<Student>();
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setAddress(rs.getString("address"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(conn, ps, rs);
		}
		return students;
	}

}
