package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.UserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//handles the GET request. It is invoked by the web container.
		/*
		 *This method is called by servlet service method to handle the HTTP GET
		 *request from client. When overriding this method, read the request data,
		 *write the response headers, get the response’s writer or output stream
		 *object, and finally, write the response data. 
		 */
		ObjectMapper mapper = new ObjectMapper();//start Object Mapper
		/*
		 * ObjectMapper class can be used to convert Java
		 * objects to JSON string and vice versa
		 */
		String json = mapper.writeValueAsString(userService.findAllUsers());//turn
		//objects into string
		
		resp.setContentType("application/json");
		
		resp.getWriter().write(json);
	}

}
