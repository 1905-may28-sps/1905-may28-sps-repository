package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revatrue.Dao.UserDao;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.UserService;

@WebServlet ("/update")
public class UpdateServlet extends HttpServlet {

	static UserDao userDao = new UserDao();
	static Reimbursement reim = new Reimbursement();
	
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    System.out.println("INSIDE UPDATE REIMBURSEMENT SERVLET...");
	    
	    reim = mapper.readValue(req.getInputStream(), Reimbursement.class);
		reim = service.updateReimbursement(reim.getId(), reim.getStatusid());
		System.out.println("Reimbursement Object "+ reim);
		
		if(userDao == null) {
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
		System.out.println("Update Succesfull");
	}
}
