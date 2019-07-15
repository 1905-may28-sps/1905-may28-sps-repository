package src.com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import src.com.revature.pojo.ERS_USERS;
import src.com.revature.pojo.Info;
import src.com.revature.service.ERS_USERSERVICE;


@WebServlet("/userInfo")
public class GetInfoServlet extends HttpServlet {
	
	final static Logger logger=Logger.getLogger(GetInfoServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Recieved equest to "+req.getRequestURI());
		
		HttpSession session=req.getSession();
		logger.info("Loaded session "+session.getId());
		
		ERS_USERS user=(ERS_USERS) session.getAttribute("loggedUser");
		if (user==null) {
			resp.setStatus(403);
		}
		else {
			if(user.getRole()==1) {
			ERS_USERSERVICE service= new ERS_USERSERVICE();
			Info info=service.getInfoThruEmp(user);
			ObjectMapper mapper=new ObjectMapper();
			
			resp.setContentType("application/json");
			resp.setStatus(200);
			
			resp.getWriter().write(mapper.writeValueAsString(info));
			}
			if(user.getRole()==2) {
				ERS_USERSERVICE service= new ERS_USERSERVICE();
				Info info=service.getInfoThruMan(user);
				ObjectMapper mapper=new ObjectMapper();
				
				resp.setContentType("application/json");
				resp.setStatus(200);
				
				resp.getWriter().write(mapper.writeValueAsString(info));
				}
		}
	}
	
	
}
