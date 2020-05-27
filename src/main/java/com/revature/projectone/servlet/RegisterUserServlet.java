package com.revature.projectone.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUserServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws IOException, ServletException 
  {
    String firstName = req.getParameter("firstname");
    String lastName = req.getParameter("lastname");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String type = req.getParameter("type");
    Employee employee = new Employee();
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
    employee.setUsername(username);
    employee.setPassword(password);
    employee.setType(type);
    RegisterUserDTO dto = new RegisterUserDTO(employee.pushToDatabase());
    String jsonReturn = (new ObjectMapper()).writeValueAsString(dto);
    resp.getWriter().write(jsonReturn);
  }
}
