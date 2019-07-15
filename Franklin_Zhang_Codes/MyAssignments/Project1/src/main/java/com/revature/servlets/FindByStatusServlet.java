package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ReimbursementInfo;
import com.revature.pojo.StatusInfo;
import com.revature.pojo.UserInfo;
import com.revature.pojo.Users;
import com.revature.service.UserService;

@WebServlet("/FindByStatus")
public class FindByStatusServlet  extends HttpServlet{
	UserService service = new UserService();
	
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("fail heelp");
		//retrieve user from req body 
		StatusInfo filter = mapper.readValue(req.getInputStream(), StatusInfo.class);
		System.out.println("fail 1heelp");
	System.out.println(filter);
	filter=service.findReimbursementByStatus(filter);					
		
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(filter));
	
	}

}
