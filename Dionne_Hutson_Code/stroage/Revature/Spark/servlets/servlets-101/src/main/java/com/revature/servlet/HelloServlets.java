package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * generic servlet
 * life cycle is init service destryoy
 * we must override the service method to provide functionality for how our servlet should process response
 * generic servlet is the parent abstracct class of http servlet
 * gs can respond to requests sent via anny transre protocol
 * */

public class HelloServlets extends GenericServlet{
	
	static int count=0;
	@Override
		public void init() throws ServletException {//only intializes once in the life cycling of a servlet
			// TODO Auto-generated method stub
			super.init();
			System.out.println("Intializing Hello Sevlet");
		}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {//responds to request (everytime a request comes through servlet
		// TODO Auto-generated method stub
		//print writer send response, we send the response via a class bc we don't return in
		//appends a response body to response object
		//server side we get info from requset and send info to response
		PrintWriter writer=res.getWriter();	
		String text="<h1>Hello, Servlet world!! </h1>"+ "request no. "+ ++count;
		String context= getServletContext().getInitParameter("envVar");
		String config=getServletConfig().getInitParameter("servletVar");
		text+="<br>Servlet Context: " +context;
		text+= "<br>Servlet Config: "+config;
		res.setContentType("text/html");
		writer.write(text);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destroying generic servlet");
	}
	

}
