package com.jyq.dao;

import java.sql.SQLException;

public interface UserDao {
	boolean checkUsername(String username) throws SQLException;
}
