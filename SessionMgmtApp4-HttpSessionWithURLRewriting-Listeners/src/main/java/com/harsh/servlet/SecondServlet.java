package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get Printwriter stream
		PrintWriter pw = res.getWriter();
		// set context type
		res.setContentType("text/html");
		
		// read form2/req2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");

		// Get access to HttpSession object
		HttpSession ses = req.getSession(false);

		// read form1/req1 from the Session attributes ( session tracking)
		String name = (String) ses.getAttribute("name");
		String fname = (String) ses.getAttribute("fname");
		String addrs = (String) ses.getAttribute("addrs");
		String ms = (String) ses.getAttribute("ms");

		// display form1/req1 data

		pw.println("<h1 style='color:red'>Two forms/requests data </h1>");
		pw.println("<br><b> from1/real data .. " + name + " ... " + fname + " ..... " + addrs + " ..... " + ms);
		pw.println("<br><b> from2/reg2 data :: " + f2val1 + " .... " + f2val2);

		// invalidate the session
		 ses.invalidate();

		// add home hyperlink
		pw.println("<br><a href='person_detail.html'>Home</a>");

		pw.println("<br><br><b> sesion Id : "+ses.getId());

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
