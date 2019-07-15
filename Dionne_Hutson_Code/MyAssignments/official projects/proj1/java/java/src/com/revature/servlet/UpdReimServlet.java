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

import src.com.revature.pojo.ERS_REIMBURSEMENT;
import src.com.revature.service.ERS_REIMBURSEMENTSERVICE;

@WebServlet("/upd")
public class UpdReimServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	ERS_REIMBURSEMENTSERVICE service = new ERS_REIMBURSEMENTSERVICE();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper=new ObjectMapper();
		ERS_REIMBURSEMENT reim=mapper.readValue(req.getInputStream(), ERS_REIMBURSEMENT.class);
		reim=service.updReim(reim.getId(), reim.getStatus(), reim.getMan());
		
		
			
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(reim));
		

	} 
	}
