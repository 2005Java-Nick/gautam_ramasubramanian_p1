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
