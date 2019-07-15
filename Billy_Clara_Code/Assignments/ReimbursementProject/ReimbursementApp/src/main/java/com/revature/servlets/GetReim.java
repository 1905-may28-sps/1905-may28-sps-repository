package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Manager;
import com.revature.service.UserService;

@WebServlet ("/reim")
public class GetReim extends HttpServlet{
	

		final static Logger logger = Logger.getLogger(GetReim.class);

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			logger.info("Received request to " + req.getRequestURI());

			HttpSession session = req.getSession();
			logger.info("Loaded session " + session.getId());

			UserService service = new UserService();

			List<Manager> info = service.findAllReimb();
			
			ObjectMapper mapper = new ObjectMapper();
			
			resp.setContentType("application/json");
			resp.setStatus(200);
			
			resp.getWriter().write(mapper.writeValueAsString(info));
		}
}