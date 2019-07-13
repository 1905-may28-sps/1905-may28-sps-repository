package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlets extends GenericServlet{
	
	
	static int counter =0;
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("initializing hello servlet");
		
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		/*
		 * as we see, this service method is of void return type, 
		 * meaning we do not RETURN our responses. we must use 
		 * PrintWriter in order to append a response body to our 
		 * response object
		 */
		PrintWriter writer = res.getWriter();
		String text ="<h1>Hello, Servlet world!!! request no. <h1>"+ ++counter;
		
		
		String context = getServletContext().getInitParameter("envVar");
		String config = getServletConfig().getInitParameter("servletVar");
		
		text += "<br>Servlet Context: " + context;
		text += "<br> Servlet Config: " + config;
		
		res.setContentType("text/html");
		
	writer.write(text);
	}

	
	@Override
	public void destroy() {
System.out.println("destroying");
super.destroy();
	}
	
	
}
