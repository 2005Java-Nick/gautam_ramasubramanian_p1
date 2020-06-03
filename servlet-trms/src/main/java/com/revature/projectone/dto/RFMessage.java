package com.revature.projectone.dto;

public class RFMessage extends Message {

  private ReimbursementForm[] forms; 
  
  /**
   * Get forms.
   *
   * @return forms as ReimbursementForm[].
   */
  public ReimbursementForm[] getForms()
  {
      return forms;
  }
  
  /**
   * Get forms element at specified index.
   *
   * @param index the index.
   * @return forms at index as ReimbursementForm.
   */
  public ReimbursementForm getForms(int index)
  {
      return forms[index];
  }
  
  /**
   * Set forms.
   *
   * @param forms the value to set.
   */
  public void setForms(ReimbursementForm[] forms)
  {
      this.forms = forms;
  }
  
  /**
   * Set forms at the specified index.
   *
   * @param forms the value to set.
   * @param index the index.
   */
  public void setForms(ReimbursementForm forms, int index)
  {
      this.forms[index] = forms;
  }
}
