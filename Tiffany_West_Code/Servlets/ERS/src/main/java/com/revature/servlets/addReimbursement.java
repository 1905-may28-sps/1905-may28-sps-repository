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
import com.revature.service.Reimbursementservice;

@WebServlet("/addreimb")
public class addReimbursement  extends HttpServlet{
	
	
	final static Logger logger = Logger.getLogger(upReimbServlet.class);
	Reimbursementservice service = new Reimbursementservice();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		//retrieve user from req body 
		
		Reimbursement reim = mapper.readValue(req.getInputStream(), Reimbursement.class);
		
		//reim = service.upreimb(reim.getId(), reim.getStatus(), reim.getResolver());
		System.out.println(reim);
		reim = service.addReimb(reim.getAmount(), reim.getDescription(),reim.getAuthor() ,reim.getType());
		//if obj == null, invalid credentials. send back null
		
		
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
			
			
			
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(reim));
		
	}

}
