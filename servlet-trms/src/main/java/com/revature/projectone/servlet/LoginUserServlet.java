package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.LoginMessage;
import com.revature.projectone.database.EmployeeDAO;
import com.revature.projectone.util.ConnectionFactory;

public class LoginUserServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws IOException, ServletException
  {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    Connection conn = ConnectionFactory.getConnection();

    EmployeeDAO employeeDao = new EmployeeDAO(conn);
    LoginMessage lmsg = employeeDao.loginUser(username, password);
    
    if (lmsg.getSuccessStatus()) {
      HttpSession session = req.getSession(true);
      session.setAttribute("username", username);
      session.setAttribute("password", password);
      session.setAttribute("id", lmsg.getEmployeeId());
    }

    String jsonReturn = (new ObjectMapper()).writeValueAsString(lmsg);
    resp.getWriter().write(jsonReturn);  
    
    ConnectionFactory.closeConnection(conn);
  }
}
