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

@WebServlet ("/update")
public class UpdateServlet extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	Service service = new Service();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
	ObjectMapper mapper = new ObjectMapper();
	Reimbursement reimb = mapper.readValue(req.getInputStream(),Reimbursement.class);
	reimb = service.updateReimb(reimb.getReimbResolver(), reimb.getReimbStatusId(), reimb.getReimbId());
	
		HttpSession session = req.getSession();
		logger.info("Created HttpSession " + session.getId());
		
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		resp.setStatus(200);
		writer.write(mapper.writeValueAsString(reimb));
	
}
}