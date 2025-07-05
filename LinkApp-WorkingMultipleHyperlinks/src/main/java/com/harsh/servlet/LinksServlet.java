package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");
		// read special request param value p1
		String pval = req.getParameter("p1");
		
		//get all available Locales
		Locale locale[] = Locale.getAvailableLocales();
		
		//differentiate logic for hyperlinks
		if (pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style='color: red; text-align: center;'>All language are :");
			for (Locale l : locale) {
				pw.println(l.getDisplayLanguage()+"<br>");
			}
		}
		
		else if (pval.equalsIgnoreCase("link2")) {
			pw.println("<h1 style='color: red; text-align: center;'>All countries are:");
			for (Locale l : locale) {
				if (!l.getDisplayCountry().isEmpty()) 
			        pw.println(l.getDisplayCountry() + "<br>");
			}

		}
		
		else {
			pw.println("<h1 style='color: red; text-align: center;'> System Date and time : "+LocalDateTime.now()+"</h1>");
		}
		
		pw.println("<br><a href='links.html'>home</a>");
		
		
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
