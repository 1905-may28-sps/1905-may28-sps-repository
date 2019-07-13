package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadLogin")

public class LoadLoginViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		/*	
		 * FORWARD
		 * here, we use the request object's request dispatcher 
		 * to forward a resource (in src/main/webapp) as a response
		 */
		
		req.getRequestDispatcher("partials/login.html").forward(req, resp);
	}
	
}
