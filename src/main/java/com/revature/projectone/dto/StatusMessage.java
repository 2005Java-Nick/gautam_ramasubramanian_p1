package com.revature.projectone.dto;

public class StatusMessage {
  
  private boolean successStatus;
  private String message;

  public StatusMessage() {
    this.successStatus = false;
    this.message = "Message not set by servlet";
  }

  public StatucMessage(boolean successStatus, String message) {
    this.setSuccessStatus(successStatus);
    this.setMessage(message);
  }

  public boolean getSuccessStatus() {
    return this.successStatus;
  }

  public void setSuccessStatus(boolean successStatus) {
    this.successStatus = successStatus;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
