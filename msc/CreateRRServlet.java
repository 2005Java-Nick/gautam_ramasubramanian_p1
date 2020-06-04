/* --------------------------------- Deprecated ---------------------------------

package com.revature.projectone.servlet;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dto.Employee;
import com.revature.projectone.dto.StatusMessage;
import com.revature.projectone.database.EmployeeDAO;
import com.revature.projectone.util.ConnectionFactory;

public class CreateRRServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws IOException, ServletException
  {
    String rr_type = req.getParameter("rr_type");
    String rr_amount = req.getParameter("rr_amount");
    String rr_empid = req.getParameter("rr_empid");
    String rr_dsid = req.getParameter("rr_dsid");
    String rr_dhid = req.getParameter("rr_dhid");
    String rr_bcid = req.getParameter("rr_bcid");
    String status = req.getParameter("status");
    String info = req.getParameter("info");
    RR rr = new RR(rr_type, rr_amount, rr_empid, rr_dsid, rr_dhid, rr_bcid, status, info);

    Connection conn = ConnectionFactory.getConnection();
    RRDAO employeeDao = new RRDAO(conn);
    StatusMessage statusMessage = RRDAO.insertRRintoDatabase(rr);
    String jsonReturn = (new ObjectMapper()).writeValueAsString(statusMessage);
    resp.getWriter().write(jsonReturn);
  } 
}
--------------------------------- Deprecated --------------------------------- */ 
