package src.com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Blob;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import src.com.revature.pojo.ERS_REIMBURSEMENT;
import src.com.revature.service.ERS_REIMBURSEMENTSERVICE;

@WebServlet("/add")
public class AddReimServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	ERS_REIMBURSEMENTSERVICE service = new ERS_REIMBURSEMENTSERVICE();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper=new ObjectMapper();
		ERS_REIMBURSEMENT reim=mapper.readValue(req.getInputStream(), ERS_REIMBURSEMENT.class);
		reim=service.addReim(reim.getAmount(), reim.getDescrp(), reim.getEmp(), reim.getType()/*,reim.getPic()*/);
		
		
			
			HttpSession session = req.getSession();
			logger.info("Created HttpSession " + session.getId());
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(mapper.writeValueAsString(reim));
		

	} 
	}
