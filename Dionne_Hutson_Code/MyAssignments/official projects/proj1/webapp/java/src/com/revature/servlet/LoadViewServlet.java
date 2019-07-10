package src.com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(req.getRequestURI());
		String[] path=req.getRequestURI().split("/");
		String resource=path[2].substring(0, path[2].length()-5);
		String resourcePath="partial/"+resource+".html";
		req.getRequestDispatcher(resourcePath).forward(req,resp);
	}

}
