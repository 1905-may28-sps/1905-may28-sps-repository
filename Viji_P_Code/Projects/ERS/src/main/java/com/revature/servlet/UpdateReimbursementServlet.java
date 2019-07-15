package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.ReimbursementDao;
import com.revature.pojos.ErsReimbursement;
import com.revature.pojos.ErsUser;
import com.revature.service.UserService;

@WebServlet("/update")
public class UpdateReimbursementServlet extends HttpServlet{

	static ReimbursementDao reimDao = new ReimbursementDao();
	static ErsReimbursement reim = new ErsReimbursement();
	
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    System.out.println("INSIDE UPDATE REIMBURSEMENT SERVLET...");
	    
	    reim = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		reim = service.updateReimbursement(reim.getStatusId(), reim.getReimbId(),reim.getrResId());
		System.out.println("Reimbursement Object "+ reim);
		
		if(reim == null) {
			resp.setStatus(204);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("UpdateReimbursement", reim);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(reim));
		}
		System.out.println("Reimbursement has been added successfully");
	}
	
	}
