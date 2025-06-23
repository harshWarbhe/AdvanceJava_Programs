package com.harsh.project;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		//set Content Type
		res.setContentType("text/html");

		//get PrintWriter stream
		PrintWriter pw= res.getWriter();

		//output content to browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr> <th>Player name </th> <th> Medal </th> <th> category </th> </tr>");
		pw.println("<tr> <td>Neeraj chopra </td> <td> gold </td> <td> javaline throw </td> </tr>");
		
		pw.println("<tr> <td> </td> <td>  </td> <td> </td> </tr>");		
		pw.println("<tr> <td> Meera Bhai chanu </td> <td>Silver </td> <td>Weight lifting </td> </tr>");
		pw.println("<tr> <td> RaviKumar Dhahiya </td> <td>Silver </td> <td>Wresling </td> </tr>");
		pw.println("<tr> <td> p.v sindhu </td> <td>bronze </td> <td>batminton </td></tr>");
		pw.println("<tr> <td> Lovlina </td> <td>bronze </td> <td>boxing </td> </tr>");
		pw.println("str> std> Hokey c/td> ctd>Bronze c/td> std>Mens Hockey &/td> </tr>");
		pw.println("<tr> <td> Bajarang </td> <td>Bronze </td> <td>wresling </td> </tr>");
		pw.println("</table>");
		//close stream
		pw.close();

	}
}
