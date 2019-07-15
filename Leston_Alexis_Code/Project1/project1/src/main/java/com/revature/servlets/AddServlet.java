package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.service.Service;


@WebServlet("/add")
public class AddServlet extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	Service service = new Service();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
	ObjectMapper mapper = new ObjectMapper();
	Reimbursement reimburse = mapper.readValue(req.getInputStream(),Reimbursement.class);
	System.out.println(reimburse);
	reimburse = service.addReimb( reimburse.getReimbAmount(), reimburse.getReimbDescription(), reimburse.getReimbAuthor(), reimburse.getReimbTypeId());
	
	
	PrintWriter writer = resp.getWriter();
	resp.setContentType("application/json");
	resp.setStatus(200);
	writer.write(mapper.writeValueAsString(reimburse));
	}
}