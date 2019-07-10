package src.com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import src.com.revature.service.ERS_USERSERVICE;

@WebServlet("/users")
public class ERS_USERSSERVLET extends HttpServlet {
ERS_USERSERVICE userService=new ERS_USERSERVICE();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	ObjectMapper mapper= new ObjectMapper();
	String json=mapper.writeValueAsString(userService.getUserByUN("tom"));
	resp.setContentType("application/json");
	resp.getWriter().write(json);
};






}

	
