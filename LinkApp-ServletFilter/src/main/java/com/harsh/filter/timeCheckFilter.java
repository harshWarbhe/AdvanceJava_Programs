package com.harsh.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class timeCheckFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// get printWriter
		PrintWriter pw = res.getWriter();

		// set context type
		res.setContentType("text/html");

		LocalDateTime ldt = LocalDateTime.now();

		int hour = ldt.getHour();

		if (hour >= 9 && hour <= 17) {
			chain.doFilter(req, res);
		} else {
			pw.println("<h1 style='color: red; text-align: center;'>request must be in given time 9am to 5 pm.:</h1>");
			return;
		}

		pw.close();

	}

}
