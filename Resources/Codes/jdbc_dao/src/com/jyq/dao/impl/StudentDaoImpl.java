package com.jyq.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jyq.dao.StudentDao;
import com.jyq.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		try {
			Connection conn = JDBCUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery("select * from stu");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
