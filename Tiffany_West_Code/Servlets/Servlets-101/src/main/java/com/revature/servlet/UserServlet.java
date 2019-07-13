package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.DummyUserService;

@WebServlet("/users")
public class UserServlet  extends HttpServlet{

static DummyUserService service = new DummyUserService();
	
	/*
	 * GET method 
	 *  /users returns list of all user objects in dummy user service
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//return list of all users
		List<User> users = service.getAll();
		
		/*
		 * ObjectMapper class can be used to convert Java
		 * objects to JSON string and vice versa
		 */
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
	/*
	 * POST method 
	 * 
	 * 	/users adds user to mock data store 
	 */
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//get request body, turn into user obj 
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		
		//add users to data store
		if(service.getByUsername(u.getUsername()) == null) {
			//we know username is unique, OK to add 
			u = service.addUser(u); //add user method returns user w new id 
			resp.setStatus(201); //201 = CREATED
			PrintWriter writer = resp.getWriter();
			writer.write(mapper.writeValueAsString(u));
		}
		else {
			//username is already taken 
			resp.setStatus(409); //CONFLICT
		}
		
	}
	
	
	
	
	
	
}
