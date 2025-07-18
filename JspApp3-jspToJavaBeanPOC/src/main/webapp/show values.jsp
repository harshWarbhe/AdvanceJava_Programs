<%@page import="com.harsh.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- create or lacate java bean class obj -->
	<jsp:useBean id="st" class="com.harsh.servlet.StrudentInfo"
		scope="session"></jsp:useBean>

	<!-- set value to bean properties -->
	<jsp:setProperty property="sno" name="st" value="1001" />
	<jsp:setProperty property="sname" name="st" value="harsh" />
	<jsp:setProperty property="sadd" name="st" value="warora" />
	<jsp:setProperty property="avg" name="st" value="81.81F" />

	<b> Values are set java Bean properties...</b>

</body>
</html>