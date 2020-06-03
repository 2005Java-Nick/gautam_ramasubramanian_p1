package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
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
      if (session == null) {
        RFMessage rfmsg = new RFMessage();
        rfmsg.setSuccessStatus(false);
        rfmsg.setInfo(NOTLOGGED_IN);
        return;
      }

      Connection conn = ConnectionFactory.getConnection();
      ReimbursementFormDAO rfdao = new ReimbursementFormDAO(conn);
      RFMessage rfmsg = rfdao.retrieveReimbursementForms(session.getAttribute("id"));
      String jsonReturn = (new ObjectMapper()).writeValueAsString(rfmsg);
      resp.getWriter().write(jsonReturn);

      ConnectionFactory.closeConnection(conn);
  }
}
