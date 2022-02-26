<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 style="text-align:center;">You have visited the <a href="/">index</a> page <c:out value="${times}"/> times</h1>
		<a href="/">Test another visit?</a>
	</body>
</html>