<%@page import="java.util.Date"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!public String generateWishMessage(String user) {
		
		//get system date and time 
		// int a = 10; => java comment
		
		
		java.time.LocalDateTime ldt = java.time.LocalDateTime.now();
		//get current hour of the day
		int hour = ldt.getHour();

		if (hour < 12)
			return "Good Morning : " + user;
		else if (hour < 16)
			return "Good Afternoon : " + user;
		else if (hour < 20)
			return "Good Evening : " + user;
		else
			return "Good Night : " + user;
	}%>

	<h1 style="color: red; text-align: center;">welcome to Java Servlet pages</h1>

	<br>
	<h1 style="color: green; text-align: center;">
		Date and time :<%=new Date()%></h1>
	<%
	String name = "Harsh";
	%>
	<br>
	<b style="display: block; text-align: center;"><%= generateWishMessage(name) %></b>
	
	
	<!-- 	<h1>welcome to Java Servlet pages</h1> html comment/ output comment  --> 
	<%-- <%= generateWishMessage(name) %> jsp comment / hidden comment --%>
</body>
</html>