package com.revature.projectone.dto;

public class EmployeeMessage extends Message {

  private Employee[] requestHierarchy = null;

  /**
   * Get requestHierarchy.
   *
   * @return requestHierarchy as Employee[].
   */
  public Employee[] getRequestHierarchy()
  {
      return requestHierarchy;
  }
  
  /**
   * Get requestHierarchy element at specified index.
   *
   * @param index the index.
   * @return requestHierarchy at index as Employee.
   */
  public Employee getRequestHierarchy(int index)
  {
      return requestHierarchy[index];
  }
  
  /**
   * Set requestHierarchy.
   *
   * @param requestHierarchy the value to set.
   */
  public void setRequestHierarchy(Employee[] requestHierarchy)
  {
      this.requestHierarchy = requestHierarchy;
  }
  
  /**
   * Set requestHierarchy at the specified index.
   *
   * @param requestHierarchy the value to set.
   * @param index the index.
   */
  public void setRequestHierarchy(Employee requestHierarchy, int index)
  {
      this.requestHierarchy[index] = requestHierarchy;
  }
}
