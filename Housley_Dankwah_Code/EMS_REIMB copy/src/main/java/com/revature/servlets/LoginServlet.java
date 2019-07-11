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
import com.revature.pojo.ErsUser;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ErsUser user = mapper.readValue(req.getInputStream(), ErsUser.class);
		user = service.login(user.getErsUsername(), user.getPassword());
//		System.out.println("in login servlet" + user.getErsUsername() + " " );
		if(user == null) {
			resp.setStatus(204);
		} 
		else {
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
			
			session.setAttribute("loggedUser", user);
			logger.info("logged in user " + user);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(user));
		}
		
	}
}
