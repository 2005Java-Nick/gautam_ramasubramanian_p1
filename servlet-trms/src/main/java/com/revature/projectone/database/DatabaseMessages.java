/* Deprecated Class */

package com.revature.projectone.database;

public class DatabaseMessages {
  
  private static final String SQL_DUPLICATE_EMAIL_SNIP = "ERROR: duplicate key value violates unique constraint \"employee_email_key\"";
  private static final String SQL_DUPLICATE_USERNAME_SNIP = "ERROR: duplicate key value violates unique constraint \"employee_emp_username_key\"";
  private static final String APP_DUPLICATE_EMAIL = "Employee with that email id already exists in our database. Please provide a different email.";
  private static final String APP_DUPLICATE_USERNAME = "Employee with that username already exists in our database. Please provide a different username.";
  private static final String APP_SUCCESS = "New user entered into database";

  public static String getReadableFailMessage(String exceptionMessage) {
    if (exceptionMessage.contains(SQL_DUPLICATE_EMAIL_SNIP)) {
      return APP_DUPLICATE_EMAIL; 
    } else if (exceptionMessage.contains(SQL_DUPLICATE_USERNAME_SNIP)) {
      return APP_DUPLICATE_USERNAME;
    } else {
      return exceptionMessage;
    }    
  }

  public static String getSuccessMessage() {
    return APP_SUCCESS; 
  }

}

/*
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
  */
