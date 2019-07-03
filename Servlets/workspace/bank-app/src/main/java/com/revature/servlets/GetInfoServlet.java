package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.service.UserService;

@WebServlet("/userInfo")
public class GetInfoServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(GetInfoServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Received request to " + req.getRequestURI());

		HttpSession session = req.getSession();
		logger.info("Loaded session " + session.getId());

		User user = (User) session.getAttribute("loggedUser");
		if(user == null) {
			//return some sort of error message. 
			resp.setStatus(403);
		}
		else {
			UserService service = new UserService();

			UserInformation info = service.getInfo(user);
			
			ObjectMapper mapper = new ObjectMapper();
			
			resp.setContentType("application/json");
			resp.setStatus(200);
			
			resp.getWriter().write(mapper.writeValueAsString(info));
		}

	}

}
