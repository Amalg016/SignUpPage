package com.signuppage;

import java.io.IOException;
import java.sql.SQLException;

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
//				 String json = new Gson().toJson(user);
//				    
				String json = "{ \"name\": \"" + user.uname + "\", "
		                + "\"email\": \"" + user.uemail + "\", "
		                + "\"dob\": \"" + user.udob + "\", "
		                + "\"password\": \"" + user.upass + "\", "
		                + "\"mobile\": \"" + user.umob + "\" }";
				
				// set the response type to JSON
				res.setContentType("application/json");
				
				// send the JSON string back to the client as a response
				res.getWriter().write(json);
			}
			else {
				req.logout();
				System.out.println("shit!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
