package com.revature.projectone.dto;

public class Message {
  
  private boolean successStatus = false;
  private String info = "Message not set by servlet";
  
  /**
   * Get successStatus.
   *
   * @return successStatus as boolean.
   */
  public boolean getSuccessStatus()
  {
      return successStatus;
  }
  
  /**
   * Set successStatus.
   *
   * @param successStatus the value to set.
   */
  public void setSuccessStatus(boolean successStatus)
  {
      this.successStatus = successStatus;
  }
  
  /**
   * Get info.
   *
   * @return info as String.
   */
  public String getInfo()
  {
      return info;
  }
  
  /**
   * Set info.
   *
   * @param info the value to set.
   */
  public void setInfo(String info)
  {
      this.info = info;
  }
}
