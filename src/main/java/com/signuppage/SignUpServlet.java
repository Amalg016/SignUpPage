package com.signuppage;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import sql.SqlCommand;
import sql.User;

public class SignUpServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		int mob = Integer.parseInt(req.getParameter("mob"));
		String pass = req.getParameter("password");
		
		User newUser = new User(name,email,dob,pass,mob);
		
		try {
			boolean bool = SqlCommand.addUser(newUser);
			res.getWriter().println("The result is: " + bool + "Inserted!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}

