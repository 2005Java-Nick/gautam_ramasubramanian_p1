package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.RFMessage;
import com.revature.projectone.dto.ReimbursementForm;
import com.revature.projectone.database.ReimbursementFormDAO;
import com.revature.projectone.util.ConnectionFactory;

public class GetRFServlet extends HttpServlet {

  public static final String NOT_LOGGED_IN = "Employee has not logged in to our system.";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws IOException, ServletException
  {
      HttpSession session = req.getSession(false);
      Connection conn = ConnectionFactory.getConnection();
      RFMessage rfmsg;
      if (session == null) {
        rfmsg = new RFMessage();
        rfmsg.setSuccessStatus(false);
        rfmsg.setInfo(NOT_LOGGED_IN);
      } else {
        ReimbursementFormDAO rfdao = new ReimbursementFormDAO(conn);
        rfmsg = rfdao.retrieveReimbursementForms((Integer) session.getAttribute("id"));
      }
      
      String jsonReturn = (new ObjectMapper()).writeValueAsString(rfmsg);
      resp.getWriter().write(jsonReturn);

      ConnectionFactory.closeConnection(conn);
  }
}
