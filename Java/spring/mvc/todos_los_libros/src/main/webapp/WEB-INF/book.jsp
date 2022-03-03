<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${book.title}"/></title>
	</head>
	<body>
		<h1><c:out value="${book.title}"/></h1>
		<ul>
			<li>Description: <c:out value="${book.description}"/></li>
			<li>Language: <c:out value="${book.language}"/></li>
			<li>Number of pages: <c:out value="${book.numberOfPages}"/></li>
		</ul>
	</body>
</html>