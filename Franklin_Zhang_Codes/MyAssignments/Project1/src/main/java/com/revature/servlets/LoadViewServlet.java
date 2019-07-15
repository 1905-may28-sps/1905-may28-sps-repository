package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.UserService;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println(req.getRequestURI());
		String[] path = req.getRequestURI().split("/");
		
		String resource = path[2].substring(0, path[2].length() - 5);
		System.out.println("LOADING " + resource + ".html");
		
		
		String resourcePath = "partials/" + resource  + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);

	}

//test if i did connectionfactory correct...
//	UserService userService = new UserService();
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(userService.findAllUsers());
//		
//		resp.setContentType("application/json");
//		
//		resp.getWriter().write(json);
//	}
//	
//	
	
	
}