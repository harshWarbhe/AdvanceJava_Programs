package com.harsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {

	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO UPLOAD_EMPLOYEE VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get printWriter
		PrintWriter pw = resp.getWriter();

		// set context type
		resp.setContentType("text/html");

		Connection con = null;
		PreparedStatement ps = null;
		try {
			// read special req object
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(req);

			// read from data
			String name = nreq.getParameter("ename");
			String addr = nreq.getParameter("eaddr");

			// create uploadBean class obj
			UploadBean upb = new UploadBean();
			upb.setFolderstore("D:/store"); // folder location in the server machine file location

			upb.setOverwrite(false);
			upb.setFilesizelimit(1024 * 1024 * 5); // 5 MB

			// complete file upload process
			upb.store(nreq);

			pw.println("<b>File are uploaded sucessfully</b>");

			// get the name of the upload file
			Vector<UploadParameters> vector = upb.getHistory();

			ArrayList<String> filesList = new ArrayList<>();

			vector.forEach(up -> {
				filesList.add("D:/store/" + up.getFilename());
			});

			// write jdbc code to form data and files location to db table as record
			// Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			// create PreparedStatemet obiect
			ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);

			// set values to query params
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, filesList.get(0));
			ps.setString(4, filesList.get(1));

			// execute the Query
			int count = ps.executeUpdate();
			if (count == 1) {
				pw.println("<h1 style='color:red;text-align:center'>Employee registered </h1>");
			} else {
				pw.println("<h1 style='color:red;text-align:center'>Employee is not registered </h1>");

			}

		} catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h2 style='color:red;text-align:center'>Database error occurred</h2>");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			pw.println("<h2 style='color:red;text-align:center'>File I/O error occurred</h2>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<h2 style='color:red;text-align:center'>Unexpected error occurred</h2>");
		}

		finally {
			if (con != null) {
				con.close();
			}
		}
		
		pw.println("<br/><a href='employee_register.html'>Register another employee</a>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
