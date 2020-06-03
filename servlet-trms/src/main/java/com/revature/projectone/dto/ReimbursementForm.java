package com.revature.projectone.dto;

public class ReimbursementForm {
  
  private int rfId;
  private int rfRequester;
  private String rfDateTimeOfRequest;
  private int rfEvent;
  private String rfReimbursementAmount;
  private boolean rfUrgent;
  private String rfStatus;
  private String rfStatusMessage;
  private String rfGradingFormat;
  private String rfGrade;
  
  /**
   * Get rfId.
   *
   * @return rfId as int.
   */
  public int getRfId()
  {
      return rfId;
  }
  
  /**
   * Set rfId.
   *
   * @param rfId the value to set.
   */
  public void setRfId(int rfId)
  {
      this.rfId = rfId;
  }
  
  /**
   * Get rfRequester.
   *
   * @return rfRequester as int.
   */
  public int getRfRequester()
  {
      return rfRequester;
  }
  
  /**
   * Set rfRequester.
   *
   * @param rfRequester the value to set.
   */
  public void setRfRequester(int rfRequester)
  {
      this.rfRequester = rfRequester;
  }
  
  /**
   * Get rfDateTimeOfRequest.
   *
   * @return rfDateTimeOfRequest as String.
   */
  public String getRfDateTimeOfRequest()
  {
      return rfDateTimeOfRequest;
  }
  
  /**
   * Set rfDateTimeOfRequest.
   *
   * @param rfDateTimeOfRequest the value to set.
   */
  public void setRfDateTimeOfRequest(String rfDateTimeOfRequest)
  {
      this.rfDateTimeOfRequest = rfDateTimeOfRequest;
  }
  
  /**
   * Get rfEvent.
   *
   * @return rfEvent as int.
   */
  public int getRfEvent()
  {
      return rfEvent;
  }
  
  /**
   * Set rfEvent.
   *
   * @param rfEvent the value to set.
   */
  public void setRfEvent(int rfEvent)
  {
      this.rfEvent = rfEvent;
  }
  
  /**
   * Get rfReimbursementAmount.
   *
   * @return rfReimbursementAmount as String.
   */
  public String getRfReimbursementAmount()
  {
      return rfReimbursementAmount;
  }
  
  /**
   * Set rfReimbursementAmount.
   *
   * @param rfReimbursementAmount the value to set.
   */
  public void setRfReimbursementAmount(String rfReimbursementAmount)
  {
      this.rfReimbursementAmount = rfReimbursementAmount;
  }
  
  /**
   * Get rfUrgent.
   *
   * @return rfUrgent as boolean.
   */
  public boolean getRfUrgent()
  {
      return rfUrgent;
  }
  
  /**
   * Set rfUrgent.
   *
   * @param rfUrgent the value to set.
   */
  public void setRfUrgent(boolean rfUrgent)
  {
      this.rfUrgent = rfUrgent;
  }
  
  /**
   * Get rfStatus.
   *
   * @return rfStatus as String.
   */
  public String getRfStatus()
  {
      return rfStatus;
  }
  
  /**
   * Set rfStatus.
   *
   * @param rfStatus the value to set.
   */
  public void setRfStatus(String rfStatus)
  {
      this.rfStatus = rfStatus;
  }
  
  /**
   * Get rfStatusMessage.
   *
   * @return rfStatusMessage as String.
   */
  public String getRfStatusMessage()
  {
      return rfStatusMessage;
  }
  
  /**
   * Set rfStatusMessage.
   *
   * @param rfStatusMessage the value to set.
   */
  public void setRfStatusMessage(String rfStatusMessage)
  {
      this.rfStatusMessage = rfStatusMessage;
  }
  
  /**
   * Get rfGradingFormat.
   *
   * @return rfGradingFormat as String.
   */
  public String getRfGradingFormat()
  {
      return rfGradingFormat;
  }
  
  /**
   * Set rfGradingFormat.
   *
   * @param rfGradingFormat the value to set.
   */
  public void setRfGradingFormat(String rfGradingFormat)
  {
      this.rfGradingFormat = rfGradingFormat;
  }
  
  /**
   * Get rfGrade.
   *
   * @return rfGrade as String.
   */
  public String getRfGrade()
  {
      return rfGrade;
  }
  
  /**
   * Set rfGrade.
   *
   * @param rfGrade the value to set.
   */
  public void setRfGrade(String rfGrade)
  {
      this.rfGrade = rfGrade;
  }
}
