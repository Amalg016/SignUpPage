package com.signuppage;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String msg=(String) req.getAttribute("message");
		System.out.println("message: "+msg);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.html?message="+msg);
		dispatcher.forward(req, res);
	}
	
}