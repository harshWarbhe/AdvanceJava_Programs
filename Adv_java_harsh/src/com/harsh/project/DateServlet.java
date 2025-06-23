package com.harsh.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//DateServlet.java

//package com.harsh.servlet;

//import javax.servlet;//servlet api
//import java.io.*;   //ioStream api
//import java.util.*;

public class DateServlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		//set response content type
		res.setContentType("text/html");

		//get PrintWriter Stream obj response obj
		PrintWriter pw = res.getWriter();

		//write request processing logic
		Date d = new Date(0);
		
		//write generated output to response onj using PrintWriter Stream
		pw.println("<h1>Date and Time :: "+d+"</h1>");
		
		pw.println("<br><b> current servlet class obj hashCode ::"+this.hashCode()+"</b>");
		pw.println("<br><b> req obj hashCode ::"+req.hashCode()+"</b>");
		pw.println("<br><b> res obj hashCode ::"+res.hashCode()+"</b>");

		pw.println("<br><b> current thread obj hashCode ::"+Thread.currentThread().hashCode()+" ---- current thread name ::</b>"+Thread.currentThread().getName());

		try
		{
			Thread.sleep(10000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		//close the Stream
		pw.close();

	}

}

