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
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	/*
	 * USING LOG4J!
	 */
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	UserService service = new UserService();/*
	* First import the (UserService) class.
	* import packageName.ClassName; (import com.revature.service.UserService;)
	* 
	* If the method is static, I could simply do this:
	* ClassName.method(); (UserService.login(user.getUsername(),user.getPassword());)
	* 
	* If it is not, I need to create a new object and call it on that:
	* ClassName c = new ClassName(); (UserService service = new UserService();)
	* c.method(); (service.login((user.getUsername(), user.getPassword());)
	*/
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		/*
		 * ObjectMapper class can be used to convert Java
		 * objects to JSON string and vice versa
		 */
		ObjectMapper mapper = new ObjectMapper();//start Object Mapper
		//retrieve user from req body 
		User user = mapper.readValue(req.getInputStream(), User.class);/*
		* readValue method allows us to take in a value from many different data
		* types and turn it into the java object of our choosing. Here we take in
		* from the request object the input stream. A stream can be defined as a
		* sequence of data. The InputStream is used to read data from a source.
		* When info gets sent over the net, it is sent as a series of bytes. We're
		* retrieving our data as an input stream from our request body. This is how
		* I can always retrieve my request body. Then I must say that I will turn it
		* from input stream to User.class. I'm reading the input stream from the
		* request into this method. Then I declare that I want this input stream to
		* be a user. Then add the user to the data store.
		*/
		//pass in username and password to service layer, get user obj
		user = service.login(user.getUsername(), user.getPassword());
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