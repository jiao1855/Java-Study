package com.jyq.test;

import org.junit.Test;

import com.jyq.dao.StudentDao;
import com.jyq.dao.impl.StudentDaoImpl;

public class daoTest {
	@Test
	public void test() {
		StudentDao stuDao = new StudentDaoImpl();
		stuDao.getAll();
	}
}
