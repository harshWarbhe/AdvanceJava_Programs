package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set context type
		res.setContentType("text/html");
		
		//write b.logic to generate wish message 
		LocalDateTime ldt = LocalDateTime.now();
		
		int hour = ldt.getHour();
		pw.println("<h1 style='color:red; text-align:center'>"+ldt.toString()+"</h1>");
		if (hour<12) {
			pw.println("<h1 style='color:red; text-align:center'>Good Morning</h1>");
		}
		else if (hour<16) {
			pw.println("<h1 style='color:red; text-align:center'>Good Afternoon</h1>");
		}
		else if (hour<20) {
			pw.println("<h1 style='color:red; text-align:center'>Good Evening</h1>");
		}
		else {
			pw.println("<h1 style='color:red; text-align:center'>Good Night</h1>");
		}
		
		//add home hyperlink to make static page to dynamic page
		pw.println("<br><a href='http://localhost:2021/WishApp/page.html'>home</a>");
		
		pw.close();
	}
}
