package com.revature.projectone.database;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.LoginMessage;
import com.revature.projectone.dto.EmployeeMessage;
import com.revature.projectone.util.ConnectionFactory;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

  private Connection conn;
  private static final String LOGIN_SUCCESS_INFO = "Employee successfully retrieved from database";
  private static final String LOGIN_FAIL_INFO = "Employee does not exist in this database";
  private static final String H_SUCCESS_INFO = "Employee Reimbursement Form  Hierarchy successfully retrieved from database";

  public EmployeeDAO(Connection conn) {
    this.conn = conn;
  }

  public LoginMessage loginUser(String username, String password) {
    LoginMessage lmsg = new LoginMessage();
    try {
      PreparedStatement ps = this.conn.prepareStatement("select p1.loginUser(?,?);");
      ps.setString(1, username);
      ps.setString(2, password);
      ResultSet res = ps.executeQuery();
      while (res.next()) {
        Integer eid = res.getInt("loginUser");
        if (eid != null) {
          lmsg.setSuccessStatus(true);
          lmsg.setInfo(LOGIN_SUCCESS_INFO);
          lmsg.setEmployeeId(eid);
        } else {
          lmsg.setSuccessStatus(false);
          lmsg.setInfo(LOGIN_FAIL_INFO);
        }
      }
    } catch (SQLException e) {
      lmsg.setSuccessStatus(false);
      lmsg.setInfo(e.getMessage());
    }
    return lmsg;
  }

  public EmployeeMessage retrieveRequestHierarchy(int employeeId) {
    EmployeeMessage emsg = new EmployeeMessage();
    ArrayList<Employee> empList = new ArrayList<Employee>();
    try {
      PreparedStatement ps = this.conn.prepareStatement("select * from p1.getRequestHierarchy(?);");
      ps.setInt(1, employeeId);
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
      emsg.setRequestHierarchy(empList.toArray(empArray));
      emsg.setSuccessStatus(true);
      emsg.setInfo(H_SUCCESS_INFO);
    } catch (SQLException e) {
      emsg.setSuccessStatus(false);
      emsg.setInfo(e.getMessage()); 
    }
    return emsg; 
  }

}
  
