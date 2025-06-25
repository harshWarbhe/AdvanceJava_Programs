package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VaccineElgiblityCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get printWriter
		PrintWriter pw = res.getWriter();

		// set context type
		res.setContentType("text/html");

		String name = req.getParameter("pname");
		String city = req.getParameter("pcity");
		String tage = req.getParameter("page");

		// from validation logic (server side)
		List<String> errorsList = new ArrayList();

		if (name == null || name.length() == 0 || name.equalsIgnoreCase("")) {
			errorsList.add("person name is required");
		}

		if (city == null || city.length() == 0 || city.equalsIgnoreCase("")) {
			errorsList.add("person city is required");
		}

		int age = 0;
		if (tage == null || tage.length() == 0 || tage.equalsIgnoreCase("")) {
			errorsList.add("person age is required");
		}

		try {
			age = Integer.parseInt(tage);
			if (age <= 0 || age > 125) {
				errorsList.add("person age must be inn range 1 to 125");
			}
		} catch (NumberFormatException e) {
			errorsList.add("person age must be in numeric value");
		}

		if (errorsList.size() > 0) {
			pw.println("<ul style:'color: red'>");
			for (String errorMsg : errorsList) {
				pw.println("<li style:'color: red'>" + errorMsg + "</li>");
			}
			pw.println("</ul>");
			//return;//block control going further
		}

		// write b.logic (request processing logic)
		if (age > 18) {
			pw.println("<h1 style='color:green; text-align: center'>" + name
					+ " You are elgible for coronna vaccination, make it happen. </h1>");
		} else {
			pw.println("<h1 style='color:red; text-align: center'>" + name
					+ " You are not elgible for coronna vaccination.</h1>");
		}

		// add home hyperlink
		pw.println(
				"<a href='http://localhost:2021/CoronaVaccineApp/corona_vaccine.html'><img src='images/home.png'></a>");

		
		
	}
}
