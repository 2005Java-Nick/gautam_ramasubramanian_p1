package com.revature.projectone.database;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.StatusMessage;
import com.revature.projectone.util.ConnectionFactory;
import com.revature.projectone.database.DatabaseMessages;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

  private Connection conn;
  private static final String SUCCESS_INFO = "New user entered into database";

  public EmployeeDAO(Connection conn) {
    this.conn = conn;
  }

  // Put parameters here later
  public StatusMessage insertEmployeeToDatabase(Employee employee) {
    StatusMessage msg = new StatusMessage();
    try {
      PreparedStatement ps = this.conn.prepareStatement("insert into p1.employee values (?,?,?,?,?,?,?);");
      ps.setInt(1, employee.getId());
      ps.setString(2, employee.getFirstName());
      ps.setString(3, employee.getLastName());
      ps.setString(4, employee.getEmail());
      ps.setString(5, employee.getUsername());
      ps.setString(6, employee.getPassword());
      ps.setString(7, employee.getType());
      ps.executeUpdate();
    } catch (SQLException e) {
      msg.setSuccessStatus(false);
      msg.setInfo(e.getMessage());
      return msg;
    } 
    msg.setSuccessStatus(true);
    msg.setInfo(SUCCESS_INFO);
    return msg;
  } 

  public Object[] retrieveEmployee() {
    return null; 
  }

}
