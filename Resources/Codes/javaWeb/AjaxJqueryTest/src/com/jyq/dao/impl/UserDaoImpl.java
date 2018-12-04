package com.jyq.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jyq.dao.UserDao;
import com.jyq.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Long count = (Long)runner.query("select count(*) from user where name=?", new ScalarHandler(),username); 
		return count>0;
	}

}
