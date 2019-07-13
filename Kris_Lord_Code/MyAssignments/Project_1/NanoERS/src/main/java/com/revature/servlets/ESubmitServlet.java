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
import com.revature.pojos.Account;
import com.revature.pojos.User;
import com.revature.pojos.UserInformation;
import com.revature.service.UserService;

@WebServlet("/esubmit")
public class ESubmitServlet extends HttpServlet {

	UserService service = new UserService();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();//start Object Mapper
		//retrieve user from req body 
		Account account = mapper.readValue(req.getInputStream(), Account.class);
		account = service.esubmit(account.getBalance(), account.getDescription(), account.getAccountType());
		//if obj == null, invalid credentials. send back null
		if(account == null) {
			resp.setStatus(204);
		}
		//if obj != null, add user to session, send back user data 
		else {
//			session.getAttribute("loggedUser", user);
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(account));
		}
		
		}
}

	
