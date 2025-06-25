package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = resp.getWriter();
		
		//set context type
		resp.setContentType("text/html");
		
		int country= Integer.parseInt(req.getParameter("country"));
		
		String capitals[] = {"New Delhi", "WashingtonDC", "Beiling", "London", "Paris"};
		String Countries[] = {"India", "USA", "China", "United Kingdom", "France"};
		
		pw.println("<h1 style='color: red; text-align: center;'>Capital of country "+Countries[country]+" is : " +capitals[country]+" </h1>");
		
		pw.println("<a href='page.html'> Home </a>");
		
		pw.close();
		
		
		
	}
}
