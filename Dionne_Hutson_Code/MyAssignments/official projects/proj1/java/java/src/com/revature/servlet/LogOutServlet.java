package src.com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(LogOutServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {  

		logger.info("Recieved equest to "+req.getRequestURI());
		HttpSession session=req.getSession();	
		logger.info("Loaded session "+session.getId());
		resp.setContentType("application/json");
		resp.setStatus(205);

		session.invalidate();  
		logger.removeAllAppenders();


	}  



}
