<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Visualizar Date</title>
		<link rel="stylesheet" href="/css/date.css" />
		<script src="js/time.js"></script>
	</head>
	<body>
		<h1><fmt:formatDate type="date" pattern="EEEE," value="${date}" /> the <fmt:formatDate type="date" pattern="dd" value="${date}" /> of <fmt:formatDate type="date" pattern="MMMM" value="${date}" />, <fmt:formatDate type="date" pattern="yyyy" value="${date}" /></h1>
	</body>
</html>