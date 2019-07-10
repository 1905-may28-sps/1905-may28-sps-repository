package src.com.revature.servlet;
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

import src.com.revature.pojo.ERS_USERS;
import src.com.revature.service.ERS_USERSERVICE;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{

	final static Logger logger = Logger.getLogger(LoginServlet.class);
	ERS_USERSERVICE service = new ERS_USERSERVICE();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		//retrieve user from req body 
		ERS_USERS user = mapper.readValue(req.getInputStream(), ERS_USERS.class);
		//pass in username and password to service layer, get user obj
		if(user!=null) {
		user = service.login(user.getERS_USERNAME(), user.getPass());
		}
		//if obj == null, invalid credentials. send back null
		if(user == null) {
			resp.setStatus(204);
		}
		//if obj != null, add user to session, send back user data 
		else {
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
			session.setAttribute("loggedUser", user);
			logger.info("Logged in user " + user);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(user));
		}

	}



}



