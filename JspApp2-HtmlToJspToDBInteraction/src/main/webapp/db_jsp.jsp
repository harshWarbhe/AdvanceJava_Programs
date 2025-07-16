<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="jakarta.servlet.jsp.tagext.JspIdConsumer"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML TO JSP TO DB Interaction</title>
</head>
<body>

	<%!Connection con = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	private static final String INSERT_QUERY = "INSERT INTO JSP_PERSON_INFO VALUES(PID1_SEQ.NEXTVAL,?,?,?,?)";
	private static final String SELECT_QUERY = "SELECT PID, PNAME, PAGE, EMAILID, PADDR FROM JSP_PERSON_INFO";

	public void jspInit() {

		//get servletconfig obj directly
		ServletConfig cg = getServletConfig();

		//read init param values (jdbc properties)
		String driver = cg.getInitParameter("driver");
		String jdbcurl = cg.getInitParameter("jdbcurl");
		String dbuser = cg.getInitParameter("dbuser");
		String dbpwd = cg.getInitParameter("dbpwd");

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(jdbcurl, dbuser, dbpwd);

			ps1 = con.prepareStatement(SELECT_QUERY);
			ps2 = con.prepareStatement(INSERT_QUERY);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

	<%
	//read additional req param value
	String pval = request.getParameter("p1");
	if (pval.equalsIgnoreCase("register")) {
		//read form data 
		String pname = request.getParameter("pname");
		int pagee = Integer.parseInt(request.getParameter("page"));
		String mailid = request.getParameter("mailid");
		String paddr = request.getParameter("paddr");

		//set value to query param?
		ps2.setString(1, pname);
		ps2.setInt(2, pagee);
		ps2.setString(3, mailid);
		ps2.setString(4, paddr);

		int result = ps2.executeUpdate();

		if (result == 0) {
	%>
	<h1 style="color: red; text-align: center;">Record not Inserted</h1>
	<%
	} else {
	%>
	<h1 style="color: red; text-align: center;">Record Inserted</h1>
	<%
	}
	} else {

	ResultSet rs = ps1.executeQuery();
	%>
	<table border="1" bgcolor="grey" align="center">
		<tr>
			<th>P_ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>EMAIL ID</th>
			<th>P\ADDRESS</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

	<h2 align="center">
		<a href="person_form.html">HOME</a>
	</h2>

	<%!public void jspDestroy() {
		try {
			if (ps1 != null)
				ps1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ps2 != null)
				ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
</body>
</html>