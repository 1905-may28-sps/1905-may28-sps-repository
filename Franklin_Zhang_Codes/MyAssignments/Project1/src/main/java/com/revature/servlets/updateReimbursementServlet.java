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
import com.revature.pojo.ReimbursementInfo;
import com.revature.pojo.UserInfo;
import com.revature.pojo.Users;
import com.revature.service.UserService;

@WebServlet("/UpdateNewReimbursement")
public class updateReimbursementServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	UserService service = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Users usersess = (Users) session.getAttribute("loggedUser");
		System.out.println(usersess);
		ObjectMapper mapper = new ObjectMapper();
		//retrieve user from req body 
		ReimbursementInfo user = mapper.readValue(req.getInputStream(), ReimbursementInfo.class);
	
		user=service.updateReimbursements(user,usersess);			
		
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(user));
		

	}
}