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
		
		//send hyperlink to brower having url to complete sendRedirection
		String url = null;
		

		if ("google".equalsIgnoreCase(engine)) {
			url = "https://www.google.com/search?q=" + ss;
		} else if ("bing".equalsIgnoreCase(engine)) {
			url = "https://www.bing.com/search?q=" + ss;
		} else {
			url = "https://www.yahoo.com/search?q=" + ss;
		}

		//perform sendDirection
		System.out.println("before res.sendRedirection");
		
		pw.println("<b>HELLO</b>");
		res.sendRedirect(url);
		
		System.out.println("After res.sendRedirection");

		pw.println("<b>hai</b>");
		
		//pw.println("<h1 style='color:red;text-align:center'>" + "<a href='" + url + "'>Go to " + engine + "</a></h1>");

		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
