package com.signuppage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sql.SqlCommand;
import sql.User;

public class SignUpServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		long mob = Long.parseLong(req.getParameter("mob"));
		String pass = req.getParameter("password");
		
		User newUser = new User(name,email,dob,pass,mob);
		
		try {
			SqlCommand.addUser(newUser);

		    // forward the request object to the HTML page
		  //  RequestDispatcher dispatcher = req.getRequestDispatcher("login");
		  //  dispatcher.forward(req, res);
		   res.sendRedirect("login");
		   
		  //  req.setAttribute("alertMessage", "This is an alert message!");
//			res.getWriter().println("The result is: " + bool + "Inserted!");
			
		} 
		catch(SQLIntegrityConstraintViolationException E) {
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}

