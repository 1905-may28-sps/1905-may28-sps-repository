package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.Service;


@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	Service service = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(service.findAllUsers());
		
		resp.setContentType("application/json");
		
		resp.getWriter().write(json);
	}

}