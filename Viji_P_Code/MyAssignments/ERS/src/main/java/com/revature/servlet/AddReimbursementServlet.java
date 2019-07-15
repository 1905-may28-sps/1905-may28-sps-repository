package com.revature.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.DAO.ReimbursementDao;
import com.revature.pojos.*;
import com.revature.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/addReimbursement")
public class AddReimbursementServlet extends HttpServlet{
	
	static ReimbursementDao reimDao = new ReimbursementDao();
	static ErsReimbursement reim = new ErsReimbursement();
	
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
	    System.out.println("INSIDE REIMBURSEMENT PAGE...");
	    reim = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		reim = service.addReimbursement(reim.getAmount(), 
				reim.getDescription(), reim.getrResId(),
				reim.getStatusId(), reim.getTypeId(),reim.getrAuthId());
		System.out.println("Reimbursement Object "+ reim);
		
		if(reim == null) 
		{
			resp.setStatus(204);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("loggedUser", reim);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(reim));
		}
	System.out.println("Reimbursement has been added successfully");
		
	}

}
