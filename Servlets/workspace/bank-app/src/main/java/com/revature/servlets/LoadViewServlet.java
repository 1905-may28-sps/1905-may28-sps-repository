package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{
	
	/*
	 * This servlet will follow the Front Controller
	 * design pattern (one servlet handling all requests
	 * and dispatching requests to appropriate 
	 * helper methods and/or classes) * to an extent 
	 * we will not send _every_ request here, only those
	 * with the suffix .view
	 * 
	 * We will name our partial html pages appropriately
	 * so that we will, for example, forward login.html
	 * along as a response to a request addressed to 
	 * login.view
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println(req.getRequestURI());
		String[] path = req.getRequestURI().split("/");
		
		String resource = path[2].substring(0, path[2].length() - 5);
		System.out.println("LOADING " + resource + ".html");
		
		
		String resourcePath = "partials/" + resource  + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);

	}

}
