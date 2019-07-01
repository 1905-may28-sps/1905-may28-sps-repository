package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.User;
import com.revature.service.DummyUserService;

@WebServlet("/login")
public class FormServlet extends HttpServlet{
	
	static DummyUserService service = new DummyUserService();
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * One way to retrieve form data from request is 
		 * the getParameter() method! It takes the name of 
		 * the input field and returns the value entered
		 */
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		User u = service.getByUsername(name);
		String out = "";
		if(u == null) {
			//no user by this username exists
			out += "Sorry! Incorrect credentials. Please try again";
		}else if(u.getPassword().equals(pass)) {
			//user is logged in 
			out += "Welcome, " + name  +"!";
		}
		else {
			//incorrect password
			out += "Sorry! Incorrect credentials. Please try again";
		}
		PrintWriter writer = resp.getWriter();
		writer.write(out);
		
	}


}
