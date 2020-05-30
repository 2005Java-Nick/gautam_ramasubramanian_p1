package com.revature.projectone.dto;

public class StatusMessage {
  
  private boolean successStatus;
  private String info;

  public StatusMessage() {
    this.successStatus = false;
    this.info = "Message not set by servlet";
  }

  public StatusMessage(boolean successStatus, String info) {
    this.setSuccessStatus(successStatus);
    this.setInfo(info);
  }

  public boolean getSuccessStatus() {
    return this.successStatus;
  }

  public void setSuccessStatus(boolean successStatus) {
    this.successStatus = successStatus;
  }

  public String getInfo() {
    return this.info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

}
