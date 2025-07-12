package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get Printwrermwres.getW
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		// read form1/request1 data
		String name = req.getParameter("pname");
		String fname = req.getParameter("fname");
		String addrs = req.getParameter("address");
		String ms = req.getParameter("ms");

		// Create/Access SEssion object for current request HttpSession ses =
		HttpSession ses = req.getSession(true);

		// keep form1/req1 data in Session obj as session attribute values
		ses.setAttribute("name", name);
		ses.setAttribute("fname", fname);
		ses.setAttribute("addrs", addrs);
		ses.setAttribute("ms", ms); 

		// generate form2 based on marital status value
		if (ms.equalsIgnoreCase("married")) {
			pw.println("<form action='"+res.encodeURL("secondurl")+"' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td> spouse name :: </td> <td> <input type='text' name='f2t1'></td></tr>");
			pw.println(
					"<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'> </td></tr>");
			pw.println("</table>");
			pw.println("<input type='hidden' name='hname' value='" + name + "'>");
			pw.println("<input type='hidden' name='hfname' value='" + fname + "'>");
			pw.println("<input type='hidden' name='haddrs' value='" + addrs + "'>");
			pw.println("<input type='hidden' name='hms' value='" + ms + "'>");
			pw.println("</form>");
		} else {
			pw.println("<form action='"+res.encodeURL("secondurl")+"' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td> Why do u want to marry :: </td> <td> <input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td> When do u want to marry :: </td> <td> <input type='text' name='f2t2'></td></tr>");
			pw.println(
					"<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			pw.println("<input type='hidden' name='hname' value='" + name + "'>");
			pw.println("<input type='hidden' name='hfname' value='" + fname + "'>");
			pw.println("<input type='hidden' name='haddrs' value='" + addrs + "'>");
			pw.println("<input type='hidden' name='hms' value='" + ms + "'>");
			pw.println("</form>");
		}

		//session id seperate for seperate browser
		pw.println("<br><br> <b> Session id :: " + ses.getId() + "</b>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
}
