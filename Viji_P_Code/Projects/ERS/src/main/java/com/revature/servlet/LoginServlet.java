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
import com.revature.pojos.ErsUser;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
	    System.out.println("INSIDE LOGIN PAGE...");
	    ErsUser user = mapper.readValue(req.getInputStream(), ErsUser.class);
		user = service.login(user.getUsername(), user.getPassword());
		System.out.println("User Object "+user);
		
		if(user == null) {
			resp.setStatus(204);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("loggedUser", user);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(user));
		}
	System.out.println("Login Servlet Out");
	}
	}
	
