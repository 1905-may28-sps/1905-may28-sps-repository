package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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


	static int counter = 0;
	
	/*
	 * First method of servlet lifecycle 
	 * here is where we initialize the servlet, potentially with 
	 * servlet variables or special logging functionality
	 * should always call super.init() first 
	 * 
	 * this init method is called by default before 
	 * the first request to this servlet, however with the 
	 * <load-on-startup> tag (or property if using annotations), we
	 * can configure our servlets to be initialized upon startup 
	 * of our container (Tomcat)
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("INTIALIZING HELLO SERVLET");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {

		/*
		 * as we see, this service method is of void return type, 
		 * meaning we do not RETURN our responses. we must use 
		 * PrintWriter in order to append a response body to our 
		 * response object
		 */
		PrintWriter writer = res.getWriter();
		String text = "<h1>Hello, Servlet world!!!</h1>"
				+ "Request no. "+ ++counter;
		
		String context = getServletContext().getInitParameter("envVar");
		String config = getServletConfig().getInitParameter("servletVar");
		
		text += "<br>Servlet Context: " + context;
		text += "<br>Servlet Config: " + config;
		
		res.setContentType("text/html");
		
		writer.write(text);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destroing generic servlet!");
	}

}
