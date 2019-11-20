package com.zc.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zc.servlet.bean.Employee;
import com.zc.servlet.util.DBUtil;

public class EmployeeDao {
	Connection conn = null ;
	PreparedStatement stat = null ;
	ResultSet rs = null ;
	
	/**
	 * 查询全部
	 * @author zhangchao
	 * @throws Exception 
	 */
	public List<Employee> findAll() throws Exception{
		List<Employee> list = new ArrayList<Employee>();
		conn = DBUtil.getConnection();
		String sql = "select * from emp_t" ;
		stat = conn.prepareStatement(sql) ;
		rs = stat.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee(rs.getInt("empId"),rs.getString("empName"),
														rs.getDouble("Salary"),rs.getInt("Age"));
			list.add(emp) ;

		}
		System.out.println("================查询全部成功==============");
		/*System.out.println(list.toString());*/
		DBUtil.close(conn);
		return list;
		
	}
	
	/**
	 * 添加
	 * @param emp
	 * @throws Exception
	 */
	public void save(Employee emp) throws Exception {
		conn = DBUtil.getConnection() ;
		String sql = "insert into emp_t(empName , Salary , Age) values(? , ? , ?)" ;
		stat = conn.prepareStatement(sql) ;
		stat.setString(1	, emp.getEmpName());
		stat.setDouble(2, emp.getSalary());
		stat.setInt(3, emp.getAge());
		stat.executeUpdate();
		System.out.println("================添加成功==============");

		DBUtil.close(conn);
	}
	
	/**
	 * 删除
	 * @param empId
	 * @throws Exception
	 */
	public void delete(int empId) throws Exception {
		conn = DBUtil.getConnection() ;
		String sql = "delete from emp_t where empId = ?" ;
		stat = conn.prepareStatement(sql) ;
		stat.setInt(1, empId);
		stat.executeUpdate();
		System.out.println("================删除成功==============");
		DBUtil.close(conn);
	}
	
	/**
	 * 根据Id查询信息
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	public Employee findById(int empId) throws Exception {
		Employee emp = null ;
		conn = DBUtil.getConnection();
		String sql = "select * from emp_t where empId = ?" ;
		stat = conn.prepareStatement(sql) ;
		stat.setInt(1, empId);
		 rs = stat.executeQuery();
		if (rs.next()) 
			 	emp = new Employee( rs.getInt("empId") , rs.getString("empName"), rs.getDouble("salary") , rs.getInt("age"));
			 System.out.println(emp.toString());
			 System.out.println(emp.getEmpId());
			 System.out.println("================查询EMPID成功==============");
			 DBUtil.close(conn);
			 return emp;
		
	}
	
	/**
	 * 修改
	 * @param emp
	 * @throws Exception
	 */
	public void update(Employee emp) throws Exception {
		conn = DBUtil.getConnection() ;
		String sql = "update emp_t set empName = ? , Salary = ? , Age = ? where empId = ?" ;
		stat = conn.prepareStatement(sql) ;
		stat.setString(1, emp.getEmpName());
		stat.setDouble(2, emp.getSalary());
		stat.setInt(3, emp.getAge());
		stat.setInt(4, emp.getEmpId());
		stat.executeUpdate() ;
		System.out.println("================修改成功==============");
		DBUtil.close(conn);
		
		
	}

}
