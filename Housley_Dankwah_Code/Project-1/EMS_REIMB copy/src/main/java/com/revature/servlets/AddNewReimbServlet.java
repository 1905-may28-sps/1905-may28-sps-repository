package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ErsReimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/addNewReimb")
public class AddNewReimbServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		super.doPost(req, resp);
		
		ReimbursementService service = new ReimbursementService();
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursement newReimb = mapper.readValue(req.getInputStream(), ErsReimbursement.class);
		newReimb = service.addReimb(newReimb);
		PrintWriter writer = resp.getWriter();
		writer.write(mapper.writeValueAsString(newReimb));
		System.out.println("in add reimb Servlet " + newReimb);

	}

}
