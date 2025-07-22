<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	pageContext.setAttribute("attr1", "val1");
	pageContext.setAttribute("attr2", "val2", pageContext.REQUEST_SCOPE);
	pageContext.setAttribute("attr3", "val3", pageContext.SESSION_SCOPE);
	pageContext.setAttribute("attr4", "val4", pageContext.APPLICATION_SCOPE);
	%>


</body>
</html>