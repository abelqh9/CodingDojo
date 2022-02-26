<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Visualizar Date</title>
		<link rel="stylesheet" href="/css/time.css" />
		<script src="js/time.js"></script>
	</head>
	<body>
		<h1><fmt:formatDate type="time" pattern="kk:mm a" value="${date}"/></h1>
	</body>
</html>