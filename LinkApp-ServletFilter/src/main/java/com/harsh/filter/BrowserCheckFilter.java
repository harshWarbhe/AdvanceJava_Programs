package com.harsh.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// get printWriter
		PrintWriter pw = res.getWriter();

		// set context type
		res.setContentType("text/html");

		String browser = req.getHeader("user-agent");
		
		System.out.println(browser);
		
		if (browser.contains("Chrome")) {
			chain.doFilter(req, res);
		} else {
			pw.println("<h1 style='color: red; text-align: center;'>Access Denied: This application only supports Chrome browser.</h1>");
			return;
		}

		pw.close();

	}
}
