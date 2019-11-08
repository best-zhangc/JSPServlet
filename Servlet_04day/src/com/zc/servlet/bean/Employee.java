package com.zc.servlet.bean;

public class Employee {
	private int empId ; 
	private String empName ;
	private Double Salary ;
	private int Age ;
	
	
	@Override
	public String toString() {
		return  empId + "  "+ empName + "  " + Salary + "  " + Age;
	}
	//构造方法
	public Employee(int empId, String empName, Double salary, int age) {
		super();
		this.empId = empId;
		this.empName = empName;
		Salary = salary;
		Age = age;
	}
	public Employee() {
		super();

	}
	
	//Get、Set方法
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
}
