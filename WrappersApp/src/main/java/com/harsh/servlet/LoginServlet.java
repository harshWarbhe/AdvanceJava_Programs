package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()");
		System.out.println("req and res obj type : "+req.getClass()+" "+resp.getClass());
		
		//get printWriter
		PrintWriter pw = resp.getWriter();
		
		//set context type
		resp.setContentType("text/html");
		
		//read form data
		String mail = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		System.out.println(mail+" "+pwd);
		
		if (mail.equalsIgnoreCase("harsh@gmail.com") && pwd.equalsIgnoreCase("harsh")) {
			pw.println("	<h1 style='color: red; text-align: center;'>Valid Credentails</h1>");
		}
		else {
			pw.println("	<h1 style='color: red; text-align: center;'>Invalid Credentails</h1>");
		}
		
		//add home hyperlink
		pw.println("	<br><h3 style='text-align: center;'><a href='login.html'>Home</a></h3>");

		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
