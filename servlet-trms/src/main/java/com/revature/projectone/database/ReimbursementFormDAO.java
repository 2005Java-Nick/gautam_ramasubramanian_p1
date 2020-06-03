package com.revature.projectone.database;

import com.revature.projectone.dto.ReimbursementForm;
import com.revature.projectone.dto.RFMessage;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReimbursementFormDAO {

  private Connection conn;
  private static final String SUCCESS_INFO = "Reimbursement Forms successfully retrieved from database";

  public ReimbursementFormDAO(Connection conn) {
    this.conn = conn;
  }

  public RFMessage retrieveReimbursementForms(int empId) {
    RFMessage rfmsg = new RFMessage();
    ArrayList<ReimbursementForm> rfList = new ArrayList<ReimbursementForm>();
    try {
      PreparedStatement ps = this.conn.prepareStatement("select * from p1.getReimbursementForms(?);");
      ps.setInt(1, empId);
      ResultSet res = ps.executeQuery();
      while (res.next()) {
        ReimbursementForm form = new ReimbursementForm();
        form.setRfId(res.getInt("rfId"));
        form.setRfRequester(res.getInt("rfRequester"));
        form.setRfDateTimeOfRequest(res.getString("rfDateTimeOfRequest"));
        form.setRfEvent(res.getInt("rfEvent"));
        form.setRfUrgent(res.getBoolean("rfUrgent"));
        form.setRfStatus(res.getString("rfStatus"));
        form.setRfStatusMessage(res.getString("rfStatusMessage"));
        form.setRfGradingFormat(res.getString("rfGradingFormat"));
        form.setRfGrade(res.getString("rfGrade"));
        rfList.add(form);
      }
      ReimbursementForm[] rfArray = new ReimbursementForm[rfList.size()];
      rfmsg.setForms(rfList.toArray(rfArray));
      rfmsg.setSuccessStatus(true);
      rfmsg.setInfo(SUCCESS_INFO);
    } catch (SQLException e) {
      rfmsg.setSuccessStatus(false);
      rfmsg.setInfo(e.getMessage());
    }
    return rfmsg;
  }  

}
