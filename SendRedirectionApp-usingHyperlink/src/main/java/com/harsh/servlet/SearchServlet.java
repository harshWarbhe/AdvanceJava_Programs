package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String ss = req.getParameter("s");
		String engine = req.getParameter("engine");
		

		if ("google".equalsIgnoreCase(engine)) {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q="+ss+"'> Go to " + engine + "</a></h1>");
		} else if ("bing".equalsIgnoreCase(engine)) {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.bing.com/search?q="+ss+"'> Go to " + engine + "</a></h1>");
		} else {
			pw.println("<h1 style='color:red;text-align:center'><a href='https://www.yahoo.com/search?q="+ss+"'> Go to " + engine + "</a></h1>");

		}

		//pw.println("<h1 style='color:red;text-align:center'>" + "<a href='" + url + "'>Go to " + engine + "</a></h1>");

		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
