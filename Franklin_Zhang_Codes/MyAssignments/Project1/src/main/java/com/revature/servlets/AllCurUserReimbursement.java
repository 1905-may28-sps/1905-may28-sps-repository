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
import com.revature.pojo.ReimbursementInfo;
import com.revature.pojo.UserInfo;
import com.revature.pojo.Users;
import com.revature.service.UserService;

@WebServlet("/AllCurUserReimbursement")
public class AllCurUserReimbursement extends HttpServlet{
	UserService userService = new UserService();
	
	final static Logger logger = Logger.getLogger(AllCurUserReimbursement.class);

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("Received request to " + req.getRequestURI());

		HttpSession session = req.getSession();
		logger.info("Loaded session " + session.getId());
		Users user = (Users) session.getAttribute("loggedUser");
		UserService service = new UserService();
		UserInfo info = service.findALLCurUserReimbursement(user);
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		
		resp.getWriter().write(mapper.writeValueAsString(info));
	}
}
