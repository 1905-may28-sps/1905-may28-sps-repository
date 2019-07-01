package com.revature.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * GENERIC SERVLETS
 * - using only for demo purposes, we will typically create
 * HttpServlets
 * - the servlet lifecycle is init(), service(), destroy()
 * - in generic servlets, we MUST override the service() method
 * to provide functionality for how our servlet should process responses
 * - GenericServlet is the parent abstract class of HttpServlet
 * - GenericServlet can respond to requests sent via any transfer protocol
 */
public class HelloServlets extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		
	}

}
