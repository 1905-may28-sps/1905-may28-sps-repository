package com.revature.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.revature.pojos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.UserInformation;
import com.revature.service.UserService;

	@WebServlet("/userInfo")
	public class GetUserInfoServlet extends HttpServlet {

		final static Logger logger = Logger.getLogger(GetUserInfoServlet.class);

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			logger.info("Received request to " + req.getRequestURI());

			HttpSession session = req.getSession();
			logger.info("Loaded session " + session.getId());

			ErsUser user = (ErsUser) session.getAttribute("loggedUser");
			System.out.println("Inside GetUser info Servlet ...");
			if(user == null) {
				//return some sort of error message. 
				resp.setStatus(403);
			}
			else {
				if (user.getUserRoleId() == 1) {
					UserService service = new UserService();
					UserInformation info = service.getInfo(user);
					ObjectMapper mapper = new ObjectMapper();
					resp.setContentType("application/json");
					resp.setStatus(200);
					resp.getWriter().write(mapper.writeValueAsString(info));
				}
				else {
					UserService service = new UserService();
					UserInformation info = service.getManagerPage(user);
					ObjectMapper mapper = new ObjectMapper();
					resp.setContentType("application/json");
					resp.setStatus(200);
					resp.getWriter().write(mapper.writeValueAsString(info));
					}
			}

		}

	}




