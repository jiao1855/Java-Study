package com.jyq.actions;

import java.util.Date;

import com.jyq.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据封装方式一：提供属性的set方法的方式
 * @author Administrator
 *
 */
public class StudentAction1 extends ActionSupport {

	private String name;
	private int age;
	private Date birthday;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String execute() throws Exception {
		//Struts2会把页面请求参数封装到具有set的方法的属性里
		System.out.println("name="+name+",age="+age+",birthday="+birthday);
		//手动封装到对象里
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setBirthday(birthday);
		System.out.println(student);
		return super.execute();
	}
}
