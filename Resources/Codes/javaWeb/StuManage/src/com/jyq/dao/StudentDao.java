package com.jyq.dao;

import java.util.List;

import com.jyq.domain.Student;

public interface StudentDao {
	List<Student> findAll();
}
