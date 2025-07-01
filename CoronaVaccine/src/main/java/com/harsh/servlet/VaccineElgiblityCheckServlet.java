package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VaccineElgiblityCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get printWriter
		PrintWriter pw = res.getWriter();
		
		//set context type
		res.setContentType("text/html");
		
		String name= req.getParameter("pname");
		String city= req.getParameter("pcity");
		int age = Integer.parseInt(req.getParameter("page"));
		
		//write b.logic (request processing logic)
		if (age >18) {
			pw.println("<h1 style='color:green; text-align: center'>"+name+" You are elgible for coronna vaccination, make it happen. </h1>");
		}
		else {
			pw.println("<h1 style='color:red; text-align: center'>"+name+" You are not elgible for coronna vaccination.</h1>");
		}
		
		//add home hyperlink
		pw.println("<a href='http://localhost:2021/CoronaVaccineApp/corona_vaccine.html'><img src='images/home.png'></a>");
		
		
	}
}
