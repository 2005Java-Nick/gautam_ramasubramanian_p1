package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.Employee;
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
    HttpSession session = req.getSession(true);
    Connection conn = ConnectionFactory.getConnection();

    EmployeeDAO employeeDao = new EmployeeDAO(conn);
    LoginMessage loginMessage = employeeDao.retrieveRequestHierarchy(username, password);
    
    session.setAttribute("username", loginMessage.getRequestHierarchy(0).getEmpUsername());
    session.setAttribute("password", loginMessage.getRequestHierarchy(0).getEmpPassword());
    session.setAttribute("id", loginMessage.getRequestHierarchy(0).getEmpId());
    
    String jsonReturn = (new ObjectMapper()).writeValueAsString(loginMessage);
    resp.getWriter().write(jsonReturn);  
  }
}
