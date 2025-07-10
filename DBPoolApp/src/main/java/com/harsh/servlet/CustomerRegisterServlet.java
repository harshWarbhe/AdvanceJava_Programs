package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerRegisterServlet extends HttpServlet {
	private static final String CUSTUMER_INSERT_QUERY = "INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO.NEXTVAL, ?, ? ,? ,?) ";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");

		// read form data
		String name = req.getParameter("cname");
		String addr = req.getParameter("cadd");
		float billamt = Float.parseFloat(req.getParameter("billAmt"));
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		
		try(Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(CUSTUMER_INSERT_QUERY);) {
			
			//set value to query params
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setFloat(3, billamt);
			ps.setLong(4, mobileNo);
			
			int result = ps.executeUpdate();
			if (result == 1) {
				pw.println("<h1 style='color: green; text-align: center'>Customer is Register</h1>");
			}
			else {
				pw.println("<h1 style='color: green; text-align: center'>Customer is not Register</h1>");

			}
			
			pw.println("<a href='customer_register.html'>Back to Search</a>");
			pw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h2 style='color:red; text-align:center;'>Internal error occurred</h2>");
			pw.println("<a href='customer_register.html'>Back to Search</a>");
		}

	}

	private Connection getPooledConnection() throws Exception {
		
		//create InitialContext obj
		InitialContext ic = new InitialContext();
		
		//get datasource obj ref through lookup operation
		//DataSource ds = (DataSource) ic.lookup(null);		//grassfish
		
		//* DataSource ds = (DataSource) ic.lookup("DBjndi");		//tomcat
		
		//get it from inti param
		String jndiName = getServletConfig().getInitParameter("DBjndi-inti");
		
		DataSource ds = (DataSource) ic.lookup(jndiName);
		
		//get pooled jdbc connection 
		Connection con= ds.getConnection();
		
		return con;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
