<%@page import="com.harsh.dao.*,com.harsh.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- create or locate java bean class object -->
	<jsp:useBean id="emp" class="com.harsh.dao.Employee" scope="request"></jsp:useBean>

	<!-- Write form data to java bean class object -->
	<jsp:setProperty property="*" name="emp" />

	<!-- create/locate service class object -->
	<jsp:useBean id="service"
		class="com.harsh.service.PaySlipGeneratorService" scope="page"></jsp:useBean>

	<!-- invoke b.method -->
	<%
	service.GeneratedPaySlip(emp);
	%>

	<!-- Read the inputs and results from Java bean class obj and display on the browser  -->
	<h1 style="color: red; text-align: center">Employee paySlip Report</h1>


	<table align="center" bgcolor="cyan" border="1">

		<tr>
			<td>emp name:</td>
			<td><jsp:getProperty property="ename" name="emp" /></td>
		</tr>
		<tr>
			<td>emp address:</td>
			<td><jsp:getProperty property="eadd" name="emp" /></td>
		</tr>
		<tr>
			<td>emp basicSalary:</td>
			<td><jsp:getProperty property="basicSalary" name="emp" /></td>
		</tr>
		<tr>
			<td>emp grossSalary:</td>
			<td><jsp:getProperty property="grossSalary" name="emp" /></td>
		</tr>
		<tr>
			<td>emp netSalary:</td>
			<td><jsp:getProperty property="netSalary" name="emp" /></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="emp_detail.html">home</a>

</body>
</html>