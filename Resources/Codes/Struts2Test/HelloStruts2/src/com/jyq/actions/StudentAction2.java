package com.jyq.actions;

import java.util.Date;

import com.jyq.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据封装方式一：提供属性的set方法的方式
 * @author Administrator
 *
 */
public class StudentAction2 extends ActionSupport {

	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(student);
		return super.execute();
	}
}
