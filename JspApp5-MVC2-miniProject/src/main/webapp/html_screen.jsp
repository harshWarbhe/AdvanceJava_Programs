<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.harsh.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//read req scope data
	List<Employee> list = (List<Employee>) request.getAttribute("empDetails");

	String desg = request.getParameter("job");

	if (list != null && list.size() != 0) {
	%>
	<h1 style="color: red; text-align: center;">
		Employees belonging to
		<%=desg%></h1>
	<table align="center" bgcolor="cyan" border="1">
		<tr>
			<th>sno</th>
			<th>empno</th>
			<th>ename</th>
			<th>desg</th>
			<th>salary</th>
			<th>grosssalary</th>
			<th>netsalary</th>
		</tr>
		<%
		for (Employee emp : list) {
		%>
		<tr>
			<%-- <td><%=i++%></td> --%>
			<td><%=emp.getEno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getDesg()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getGrosssalary()%></td>
			<td><%=emp.getNetsalary()%></td>
		</tr>
		<%
		}
		%>

	</table>
	<%
	} else {
	%>
	<h1 style="color: red; text-align: center;">Record not found!!!</h1>
	<%
	}
	%>
</body>
</html>