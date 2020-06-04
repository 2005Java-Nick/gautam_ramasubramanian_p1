package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.EmployeeMessage;
import com.revature.projectone.database.EmployeeDAO;
import com.revature.projectone.util.ConnectionFactory;

public class GetHierarchyServlet extends HttpServlet {

  public static final String NOT_LOGGED_IN = "Employee has not logged in to our system.";
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws IOException, ServletException 
  {
      HttpSession session = req.getSession(false);
      Connection conn = ConnectionFactory.getConnection();
      EmployeeMessage emsg;
      if (session == null) {
        emsg = new EmployeeMessage();
        emsg.setSuccessStatus(false);
        emsg.setInfo(NOT_LOGGED_IN);
      } else {
        EmployeeDAO employeeDao = new EmployeeDAO(conn);
        emsg = employeeDao.retrieveRequestHierarchy((Integer) session.getAttribute("id"));
      }
      
      String jsonReturn = (new ObjectMapper()).writeValueAsString(emsg);
      resp.getWriter().write(jsonReturn);

      ConnectionFactory.closeConnection(conn);
  }

}
