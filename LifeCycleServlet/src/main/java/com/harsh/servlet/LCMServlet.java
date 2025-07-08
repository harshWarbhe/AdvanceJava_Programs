package com.harsh.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/lcm")
public class LCMServlet implements Servlet {
	private ServletConfig config;
	static {
		System.out.println("Servlet class is loaded, SB is executed");
	}

	public LCMServlet() {
		System.out.println("Servlet class is instantiated, NPC is executed");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet object is initialized, init(config) is execited");
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet is executed, service(req, resp) is executed");
		System.out.println("configuration of servlet:" + getServletConfig());
		resp.getWriter().println("Check server console");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet object is destroyed, destroy() method is executed");
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() is executed, servlet information is returned");
		return "";
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() is executed, ServletConfig object is returned");
		return config;
	}
}
