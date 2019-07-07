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
import com.revature.pojo.User;
import com.revature.service.DummyUserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	static DummyUserService service= new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//return list of all users
		List<User> users=service.getAll();
		/*
		 * Object mapper class can be used to doJava object<-> Json string*/
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(users);
		
		
		PrintWriter writer= resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. get reuest body, turn in to user object
		ObjectMapper mapper= new ObjectMapper();
		User u=mapper.readValue(req.getInputStream(), User.class); //take in a value with many diff data type and turn it into java object of our choosing
		
		//2. add users to data store
				if (service.getByUsername(u.getUsername())==null) {
					u=service.addUser(u);
					resp.setStatus(201);//201=created// this is step three
					PrintWriter writer=resp.getWriter();// this is the response body
					writer.write(mapper.writeValueAsString(u));
				}else {resp.setStatus(409);}//there is conflict, user is not created
		//3. respond with http status of created
		//4. send redp body of user with updated ID
		}

}
