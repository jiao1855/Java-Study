package com.jyq.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jyq.dao.StudentDao;
import com.jyq.dao.impl.StudentDaoImpl;
import com.jyq.domain.PageBean;
import com.jyq.domain.Student;
import com.jyq.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findAll();
	}

	@Override
	public void addStudent(Student stu) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.addStudent(stu);
	}

	@Override
	public void deleteStudent(int sid) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.deleteStudent(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findStudentById(sid);
	}

	@Override
	public void updateStudent(Student stu) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(stu);
	}

	@Override
	public List<Student> findStudents(String name, String gender) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findStudents(name,gender);
	}

	@Override
	public PageBean<Student> findStudentByPage(int pageSize, int currentPage) throws SQLException {
		
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);	//设置当前页码
		pageBean.setPageSize(pageSize);			//设置每页页数
		
		StudentDao studentDao = new StudentDaoImpl();
		int totalSize = studentDao.findTotalSize();
		int totalPage = (totalSize%pageSize==0)?(totalSize/pageSize):(totalSize/pageSize+1);
		pageBean.setTotalSize(totalSize);		//设置总记录数
		pageBean.setTotalPage(totalPage);		//设置总页数
		
		//设置当前页的数据
		pageBean.setList(studentDao.findStudentByPage(pageSize,currentPage));
		
		return pageBean;
	}

}
