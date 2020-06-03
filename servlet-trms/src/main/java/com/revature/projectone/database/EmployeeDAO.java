package com.revature.projectone.database;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.EmployeeMessage;
import com.revature.projectone.util.ConnectionFactory;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

  private Connection conn;
  private static final String SUCCESS_INFO = "Employees successfully retrieved from database";

  public EmployeeDAO(Connection conn) {
    this.conn = conn;
  }

  public EmployeeMessage retrieveRequestHierarchy(String username, String password) {
    EmployeeMessage lmsg = new EmployeeMessage();
    ArrayList<Employee> empList = new ArrayList<Employee>();
    try {
      PreparedStatement ps = this.conn.prepareStatement("select * from p1.getRequestHierarchy(?,?);");
      ps.setString(1, username);
      ps.setString(2, password);
      ResultSet res = ps.executeQuery();
      while (res.next()) {
        Employee emp = new Employee();
        emp.setEmpId(res.getInt("empId"));
        emp.setEmpFirstName(res.getString("empFirstName"));
        emp.setEmpLastName(res.getString("empLastName"));
        emp.setEmpUsername(res.getString("empUsername"));
        emp.setEmpPassword(res.getString("empPassword"));
        emp.setEmpHireDate(res.getString("empHireDate"));
        emp.setEmpBirthDate(res.getString("empBirthDate"));
        emp.setEmpAddress(res.getString("empAddress"));
        emp.setEmpCity(res.getString("empCity"));
        emp.setEmpState(res.getString("empState"));
        emp.setEmpCountry(res.getString("empCountry"));
        emp.setEmpPostalCode(res.getString("empPostalCode"));
        emp.setEmpPhone(res.getString("empPhone"));
        emp.setEmpDirectSup(res.getInt("empDirectSup"));
        emp.setEmpDeptHead(res.getInt("empDeptHead"));
        emp.setEmpBenCo(res.getInt("empBenCo"));
        empList.add(emp);
      }
      Employee[] empArray = new Employee[empList.size()];
      lmsg.setRequestHierarchy(empList.toArray(empArray));
      lmsg.setSuccessStatus(true);
      lmsg.setInfo(SUCCESS_INFO);
    } catch (SQLException e) {
      lmsg.setSuccessStatus(false);
      lmsg.setInfo(e.getMessage()); 
    }
    return lmsg; 
  }

}
  
