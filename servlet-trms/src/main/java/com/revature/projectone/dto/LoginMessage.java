package com.revature.projectone.dto;

public class LoginMessage extends Message {

  Integer employeeId;
  
  /**
   * Get employeeId.
   *
   * @return employeeId as Integer.
   */
  public Integer getEmployeeId()
  {
      return employeeId;
  }
  
  /**
   * Set employeeId.
   *
   * @param employeeId the value to set.
   */
  public void setEmployeeId(Integer employeeId)
  {
      this.employeeId = employeeId;
  }
}
