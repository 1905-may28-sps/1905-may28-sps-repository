package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;
import com.revature.service.DummyUserService;

@WebServlet("/login")// a special way to make end point when http is extend/ is to give an adress no slash is to acess adress
public class FormServlet extends HttpServlet{
	static DummyUserService service = new DummyUserService();
	@Override//method signiture\|/
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		User u=service.getByUsername(name);
		String out="";
		if (u==null) {
			//username no exsist
			out+="incorrect credentials";
		}else if (u.getPassword().contentEquals(pass)) {
			//user is logged in
			out+="Welcome " + name;
		}else {
			//incorrect password
			out+="incorrect credentials";
		}
		PrintWriter writer=resp.getWriter();
		writer.write(out);
		System.out.println("Do post");
	}

}
