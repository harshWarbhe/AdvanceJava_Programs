package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LCTestServlet extends HttpServlet {

	static {
		System.out.println("LCTestServlet :: Static Block");
	}

	public LCTestServlet() {
		System.out.println("LCTestServlet :: 0- parameter constructor");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LCTestServlet :: init(ServletConfig config)");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("LCTestServlet.service(req,resp)");
		// get printWriter
		PrintWriter pw = resp.getWriter();
		// set contest type
		resp.setContentType("text/html");
		// write message to response to object using printwriter
		pw.println("<h1 style:'color:red; text-align:center;'>Date and Time: " + new java.util.Date() + "</h1>");
		// close Stream
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("LCTestServlet :: destroy()");
	}

}
