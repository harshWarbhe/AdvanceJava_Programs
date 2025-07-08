package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DbTestServlet extends HttpServlet{

	static {
		System.out.println("DbTestServlet :: Static block");
	}

	public DbTestServlet() {
		System.out.println("DbTestServlet :: 0-param constructor");
	}
	
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("DbTestServlet :: init(ServletConfig cg)");
		//read inti param values from servletconfig obj
		System.out.println("Driver class name :: "+cg.getInitParameter("driverClass"));
		System.out.println("JDBC url :: "+cg.getInitParameter("url"));
		System.out.println("db username :: "+cg.getInitParameter("dbuser"));
		System.out.println("db password :: "+cg.getInitParameter("dbpwd"));
		
		//write jdbc code here... using the jdbc propeerties available in servletConfig
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DbTestServlet.service(req,resp)");
		//destroy();
		//get printWriter
		PrintWriter pw = resp.getWriter();
		//set context type
		resp.setContentType("text/html");
		//write message to response object using printWriter
		pw.println("<h1 style='color:red; text-align: center'>Date and Time :: "+new java.util.Date()+"</h1>");

		pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("DbTestServlet :: destroy()");
		super.destroy();
	}
	
}
