package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ErsReimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/update")
public class ApproveServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		super.doPost(req, resp);
		
		ReimbursementService service = new ReimbursementService();
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement reimb = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		reimb = service.getApproveReimb(reimb.getReimbStatusId(), reimb.getReimbId());
		System.out.println("in approved Servlet " + reimb);

	}

}
