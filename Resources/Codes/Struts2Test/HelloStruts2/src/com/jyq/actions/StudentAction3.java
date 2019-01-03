package com.jyq.actions;

import java.util.Date;

import com.jyq.domain.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 数据封装方式一：提供属性的set方法的方式
 * @author Administrator
 *
 */
public class StudentAction3 extends ActionSupport implements ModelDriven<Student> {

	//必须手动实例化对象
	private Student student = new Student();
	public Student getModel() {
		return student;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(student);
		return super.execute();
	}
}
