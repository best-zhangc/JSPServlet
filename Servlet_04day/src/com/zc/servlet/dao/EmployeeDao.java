package com.zc.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zc.servlet.bean.Employee;
import com.zc.servlet.util.DBUtil;


public class EmployeeDao {
	/**
	 * 查询全部
	 * @return
	 */
	public  List<Employee> findAll(){
		List<Employee> emps = new ArrayList<Employee>();
		Connection conn = null ;
		PreparedStatement stat = null ;
		ResultSet rs = null ;
		conn =	DBUtil.getConnection();
		//conn = new DBUtil().getConnection();
		String sql = "select * from emp_test";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee(rs.getInt("empId"),
															rs.getString("empName"),
															rs.getDouble("Salary"),
															rs.getInt("Age")
															);
				emps.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(conn);
				//new DBUtil().close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emps;
		}

/**
 *@return
 *添加员工
 * @throws SQLException 
 */
public void add(Employee emp)  throws Exception{
	Connection conn =null ;
	PreparedStatement  stmt = null ;
	
	conn = DBUtil.getConnection() ;
	String sql = "insert into emp_test(empName , Salary , Age) values (? , ? , ?)";
	try {
		stmt = conn.prepareStatement(sql) ;
		stmt.setString(1, emp.getEmpName());
		stmt.setDouble(2, emp.getSalary());
		stmt.setInt(3, emp.getAge());
		stmt.executeUpdate();
		System.out.println("-----------------添加成功");
	} catch (Exception e) {
		e.printStackTrace();
		throw e ;
	}finally {
		DBUtil.close(conn);
	}
}

/**
 * @return
 * 删除
 */
	
public void delete (int empId) throws Exception {
	Connection conn = null ;
	PreparedStatement stmt = null ;
	try {
	conn = DBUtil.getConnection() ;
	String sql = "delete from emp_test where empId = ?" ;
	stmt = conn.prepareStatement(sql) ;
	stmt.setInt(1, empId);
	stmt.executeUpdate() ;
	} catch (Exception e) {
		e.printStackTrace();
		throw e ;
	}finally {
		DBUtil.close(conn);
	}
	
	
}	

}
