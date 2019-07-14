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
import com.revature.pojos.Account2;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/esubmit")
public class ESubmitServlet extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(ESubmitServlet.class);
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loggedUser");
		logger.info(user.toString());
		ObjectMapper mapper = new ObjectMapper();//start Object Mapper
		//retrieve user from req body 
		Account2 account2 = mapper.readValue(req.getInputStream(), Account2.class);

		account2.setAuthor(user.getUserId());
		account2 = service.esubmit(account2.getBalance(), account2.getDescription(), account2.getAuthor(), account2.getAccountType());

		logger.trace("New reimbursement request added: " + account2);
//		if(account == null) {
//			resp.setStatus(204);
//		}
//		//if obj != null, add user to session, send back user data 
//		else {
//			session.getAttribute("loggedUser", user);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(account2));
//		}
		
		}
}

	
