package com.revature.projectone.database;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

  private Connection conn;
  //private boolean wasSuccessful = false;
  //private String queryMessage = "";
  

  public EmployeeDAO() {
    conn = ConnectionFactory.getConnection();
  }

  // Put parameters here later
  public void insertEmployeeToDatabase(Employee employee) {
    try {
      PreparedStatement ps = conn.prepareStatement("insert into p1.employee values (?,?,?,?,?,?,?)");
      ps.setInt(1, employee.getId());
      ps.setString(2, employee.getFirstName());
      ps.setString(3, employee.getLastName());
      ps.setString(4, employee.getEmail());
      ps.setString(5, employee.getUsername());
      ps.setString(6, employee.getPassword());
      ps.setString(7, employee.getType());
      ps.executeUpdate();
    } catch (SQLException e) {
      this.wasSuccessful = false;
      this.queryMessage = e.getMessage();
    } 
    this.wasSuccessful = true;
    this.queryMessage = "New user entered into database";
  } 

  public Object[] retrieveEmployee() {
    return null; 
  }
  
}
