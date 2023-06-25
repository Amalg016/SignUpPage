package com.signuppage;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sql.SqlCommand;
import sql.User;

public class SignInServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
        try {
			User user=SqlCommand.FetchUser(email, pass);
			
			if(user != null) {
				    
				String json = "{ \"uname\": \"" + user.uname + "\", "
		                + "\"uemail\": \"" + user.uemail + "\", "
		                + "\"udob\": \"" + user.udob + "\", "
		                + "\"upass\": \"" + user.upass + "\", "
		                + "\"umob\": \"" + user.umob + "\" }";
				
				// set the response type to JSON
				res.setContentType("application/json");
				
				// send the JSON string back to the client as a response
				//res.getWriter().write(json);
			    req.setAttribute("jsonData", json);
			    //System.out.println(req.getAttribute("jsonData"));
				//res.sendRedirect("HomePage.jsp");
			    RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage.jsp");
				dispatcher.forward(req, res);
			}
			else {
				//req.logout();
				req.setAttribute("message","Incorrect email/password!");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("login");
//			    dispatcher.forward(req, res);
			//	res.sendRedirect("index.html");
				System.out.println("shit!!");				
			}
		} 
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
	
	}
}
