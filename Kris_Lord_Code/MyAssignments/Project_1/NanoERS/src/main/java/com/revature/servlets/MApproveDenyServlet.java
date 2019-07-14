package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Account;
import com.revature.pojos.Account3;
import com.revature.service.UserService;

@WebServlet("/msubmit")
public class MApproveDenyServlet extends HttpServlet {
	
	
	UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		//start Object Mapper
		//retrieve user from req body 
		Account account = mapper.readValue(req.getInputStream(), Account.class);
		account = service.updateStatus(account.getAccountId(), account.getStatusId());
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		resp.setStatus(200);
		writer.write(mapper.writeValueAsString(account));
	}

}
