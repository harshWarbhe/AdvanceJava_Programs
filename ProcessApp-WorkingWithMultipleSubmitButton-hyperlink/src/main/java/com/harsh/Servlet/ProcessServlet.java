package com.harsh.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");
		// read special request param value s1
		String s1val = req.getParameter("s1");

		int val1 = 0, val2 = 0;

		// read text box value only when request is not form hyperlink
		if (!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2"))
			try {
				val1 = Integer.parseInt(req.getParameter("t1"));
				val2 = Integer.parseInt(req.getParameter("t2"));
			} catch (NumberFormatException e) {
				pw.println("<h2 style='color:red;'>Invalid numeric input!</h2>");
				pw.println("<a href='form.html'>Go back</a>");
				return;
			}

		// differentiate logics for submit buttons and hyperlinks
		if (s1val.equalsIgnoreCase("add"))
			pw.println("<h1>Sum of " + val1 + " and " + val2 + " is : " + (val1 + val2) + "</h1>");
		else if (s1val.equalsIgnoreCase("sub"))
			pw.println("<h1>Sub of " + val1 + " and " + val2 + " is :: " + (val1 - val2) + "</h1>");

		else if (s1val.equalsIgnoreCase("mul"))
			pw.println("<h1>Mul of " + val1 + " and " + val2 + " is :: " + (val1 * val2) + "</h1>");

		else if (s1val.equalsIgnoreCase("div"))
			pw.println("<h1>Div of " + val1 + " and " + val2 + " is :: " + ((float) val1 / val2) + "</h1>");

		else if (s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1> System properties are </h1>");
			pw.println("<b>" + System.getProperties() + "</b>");
		} else {
			pw.println("<h1> system date and time : " + LocalDateTime.now() + "</h1>");
		}

		// add home hyperlink
		pw.println("<br><a href='form.html'>home</a>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
