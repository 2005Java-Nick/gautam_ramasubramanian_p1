package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.StatusMessage;
import com.revature.projectone.database.EmployeeDAO;
import com.revature.projectone.util.ConnectionFactory;

public class RegisterUserServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws IOException, ServletException 
  {
    String firstName = req.getParameter("firstname");
    String lastName = req.getParameter("lastname");
    String email = req.getParameter("email");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String type = req.getParameter("type");
    System.out.println("---------------------------------------------");
    Employee employee = new Employee(firstName, lastName, email, username, password, type);
    
    Connection conn = ConnectionFactory.getConnection();
    EmployeeDAO employeeDao = new EmployeeDAO(conn);
    StatusMessage statusMessage = employeeDao.insertEmployeeToDatabase(employee);
    String jsonReturn = (new ObjectMapper()).writeValueAsString(statusMessage);
    resp.getWriter().write(jsonReturn);
    
    ConnectionFactory.closeConnection(conn);
  }

}
