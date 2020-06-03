package com.revature.projectone.dto;

public class ApprovalInfoChangeRequest {
  
  private int aicId;
  private int aicRF;
  private int aicOrder;
  private int aicFrom;
  private int aicTo;
  private String aicType;
  private String aicStatus;
  private String aicMessage;
  private String aicInitDateTime;
  private String aicDoneDateTime;
  
  /**
   * Get aicId.
   *
   * @return aicId as int.
   */
  public int getAicId()
  {
      return aicId;
  }
  
  /**
   * Set aicId.
   *
   * @param aicId the value to set.
   */
  public void setAicId(int aicId)
  {
      this.aicId = aicId;
  }
  
  /**
   * Get aicRF.
   *
   * @return aicRF as int.
   */
  public int getAicRF()
  {
      return aicRF;
  }
  
  /**
   * Set aicRF.
   *
   * @param aicRF the value to set.
   */
  public void setAicRF(int aicRF)
  {
      this.aicRF = aicRF;
  }
  
  /**
   * Get aicOrder.
   *
   * @return aicOrder as int.
   */
  public int getAicOrder()
  {
      return aicOrder;
  }
  
  /**
   * Set aicOrder.
   *
   * @param aicOrder the value to set.
   */
  public void setAicOrder(int aicOrder)
  {
      this.aicOrder = aicOrder;
  }
  
  /**
   * Get aicFrom.
   *
   * @return aicFrom as int.
   */
  public int getAicFrom()
  {
      return aicFrom;
  }
  
  /**
   * Set aicFrom.
   *
   * @param aicFrom the value to set.
   */
  public void setAicFrom(int aicFrom)
  {
      this.aicFrom = aicFrom;
  }
  
  /**
   * Get aicTo.
   *
   * @return aicTo as int.
   */
  public int getAicTo()
  {
      return aicTo;
  }
  
  /**
   * Set aicTo.
   *
   * @param aicTo the value to set.
   */
  public void setAicTo(int aicTo)
  {
      this.aicTo = aicTo;
  }
  
  /**
   * Get aicType.
   *
   * @return aicType as String.
   */
  public String getAicType()
  {
      return aicType;
  }
  
  /**
   * Set aicType.
   *
   * @param aicType the value to set.
   */
  public void setAicType(String aicType)
  {
      this.aicType = aicType;
  }
  
  /**
   * Get aicStatus.
   *
   * @return aicStatus as String.
   */
  public String getAicStatus()
  {
      return aicStatus;
  }
  
  /**
   * Set aicStatus.
   *
   * @param aicStatus the value to set.
   */
  public void setAicStatus(String aicStatus)
  {
      this.aicStatus = aicStatus;
  }
  
  /**
   * Get aicMessage.
   *
   * @return aicMessage as String.
   */
  public String getAicMessage()
  {
      return aicMessage;
  }
  
  /**
   * Set aicMessage.
   *
   * @param aicMessage the value to set.
   */
  public void setAicMessage(String aicMessage)
  {
      this.aicMessage = aicMessage;
  }
  
  /**
   * Get aicInitDateTime.
   *
   * @return aicInitDateTime as String.
   */
  public String getAicInitDateTime()
  {
      return aicInitDateTime;
  }
  
  /**
   * Set aicInitDateTime.
   *
   * @param aicInitDateTime the value to set.
   */
  public void setAicInitDateTime(String aicInitDateTime)
  {
      this.aicInitDateTime = aicInitDateTime;
  }
  
  /**
   * Get aicDoneDateTime.
   *
   * @return aicDoneDateTime as String.
   */
  public String getAicDoneDateTime()
  {
      return aicDoneDateTime;
  }
  
  /**
   * Set aicDoneDateTime.
   *
   * @param aicDoneDateTime the value to set.
   */
  public void setAicDoneDateTime(String aicDoneDateTime)
  {
      this.aicDoneDateTime = aicDoneDateTime;
  }
}
