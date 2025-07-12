package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		// read cookies
		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			// display cookies details as HTML table content

			pw.println("<table border='1' align='center' bgcolor='pink'>");
			for (Cookie cookie : cookies) {
				pw.println("<tr><td>" + cookie.getName() + "<td><td>" + cookie.getValue() + "<td><tr>");
			}
			pw.println("</table>");
		}
		else {
			pw.println("<h1 style='color: red; text-align:center;'>NO cookies found</h1>");

		}

		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
