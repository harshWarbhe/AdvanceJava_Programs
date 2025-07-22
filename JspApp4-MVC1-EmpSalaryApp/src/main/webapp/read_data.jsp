<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

attr1 (page Scope) value : ${pageScope.attr1}<br>
attr2 (request Scope) value : ${requestScope.attr2}<br>
attr3 (session Scope) value : ${sessionScope.attr3}<br>
attr4 (application Scope) value : ${applicationScope.attr4}<br>


</body>
</html>