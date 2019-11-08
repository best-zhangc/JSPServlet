package com.zc.user.bean;

import com.zc.course.bean.Course;

public class User {
	/**
	 *实体类：用户 
	 */
	private String UserName;
	private int Age;
	private Course course;
	private String [] interest;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
}

