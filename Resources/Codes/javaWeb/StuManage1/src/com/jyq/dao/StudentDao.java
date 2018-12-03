package com.jyq.dao;

import java.sql.SQLException;
import java.util.List;

import com.jyq.domain.Student;

public interface StudentDao {
	
	/**
	 * 查询所有学生
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 根据ID查找学生
	 * @param sid
	 * @return
	 */
	Student findStudentById(int sid) throws SQLException;
	
	/**
	 * 添加学生
	 * @param stu
	 * @throws SQLException
	 */
	void addStudent(Student stu) throws SQLException;
	
	/**
	 * 删除学生
	 * @param sid
	 * @throws SQLException
	 */
	void deleteStudent(int sid) throws SQLException;
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @throws SQLException
	 */
	void updateStudent(Student stu) throws SQLException;
	
	/**
	 * 根据学生姓名和性别查询学生
	 * @param name
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudents(String name,String gender) throws SQLException; 
	
	/**
	 * 查询指定页码的数据
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int pageSize,int currentPage) throws SQLException;
	
	/**
	 * 查询总学生个数
	 * @return
	 */
	int findTotalSize() throws SQLException;
}
