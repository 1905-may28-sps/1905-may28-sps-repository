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
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.UserService;

@WebServlet("/submit")
public class ReSubmit extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(Login.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		logger.info("Loaded session " + session.getId());

		User user = (User)session.getAttribute("loggedUser");
		
		Reimbursement re = mapper.readValue(req.getInputStream(), Reimbursement.class);
		
		service.submit(re.getAmount(),re.getSubmitted(),re.getResolved(), re.getDescription(), user.getUserid(), re.getResolver(), re.getStatusid(), re.getTypeid());

		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		resp.setStatus(200);
		writer.write(mapper.writeValueAsString(re));
	}
	

}
