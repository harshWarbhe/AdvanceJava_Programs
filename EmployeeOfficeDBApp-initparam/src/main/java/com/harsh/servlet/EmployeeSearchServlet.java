package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMPLOYEE_BY_ENO = "SELECT EMPNO, ENAME, SAL, JOB, DEPTNO FROM EMP WHERE EMPNO=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");

		// read form data
		int no = Integer.parseInt(req.getParameter("eno"));
		
		ServletConfig cg = getServletConfig();
		
		//read servlet init param value
		String driver = cg.getInitParameter("drive class");
		String url = cg.getInitParameter("url");
		String dbuser = cg.getInitParameter("dbuser");
		String dbpwd = cg.getInitParameter("dbpwd");

		pw.println("<!DOCTYPE html>");
		pw.println("<html><head><title>Employee Details</title>");
		pw.println("<style>");
		pw.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px; }");
		pw.println("h1 { text-align: center; color: #2c3e50; }");
		pw.println(
				"table { margin: 0 auto; border-collapse: collapse; background-color: #e3f2fd; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
		pw.println("td { padding: 12px 18px; font-size: 16px; }");
		pw.println(
				"a { display: block; text-align: center; margin-top: 20px; text-decoration: none; color: #007BFF; font-weight: bold; }");
		pw.println("a:hover { text-decoration: underline; }");
		pw.println("</style>");
		pw.println("</head><body>");

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url,dbuser,dbpwd);
				PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_BY_ENO)) {
			if (ps != null) {
				ps.setInt(1, no);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs != null) {
					if (rs.next()) {
						pw.println("<h1 style='color:blue; text-align:center'>Employee number :- </h1>");

						pw.println("<p style='text-align:center'><b>Employee number :: " + rs.getInt(1) + "</b><br>");
						pw.println("<b>Employee Name :: " + rs.getString(2) + "</b><br>");
						pw.println("<b>Employee Salary :: " + rs.getFloat(3) + "</b><br>");
						pw.println("<b>Employee Job :: " + rs.getString(4) + "</b><br>");
						pw.println("<b>Department number :: " + rs.getInt(5) + "</b></p>");

					} else {
						pw.println("<h1 style='color:red; text-align:center'>Employee not found. </h1>");

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h2 style='color:red; text-align:center;'>Internal error occurred</h2>");
			pw.println("<a href='search.html'>Back to Search</a>");
			
		}

		pw.println("<a href='search.html'>Back to Search</a>");
		pw.println("</body></html>");
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
