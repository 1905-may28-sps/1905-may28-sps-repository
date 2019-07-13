package com.revature.servlet;

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
import com.revature.pojos.Reimb;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/submit")
public class EmSubmit extends HttpServlet{
	
	/*
	 * USING LOG4J!
	 */
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		//retrieve user from req body 
		//User us = mapper.readValue(req.getInputStream(), User.class);
		Reimb re = mapper.readValue(req.getInputStream(), Reimb.class);
		//pass in username and password to service layer, get user obj
		service.submit(re.getAmount(), re.getDescription(), re.getId(), re.getTypeId());
		//if obj == null, invalid credentials. send back null
//		if(us == null) {
//			resp.setStatus(204);
//		}
		//if obj != null, add user to session, send back 
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
			
			//session.setAttribute("loggedUser", us);
			//logger.info("Logged in user " + us);
			
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(re));
		}
	}

