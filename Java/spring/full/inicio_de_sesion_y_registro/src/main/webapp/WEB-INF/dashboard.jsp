<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/dashboard.css">
		<title>Register And Login</title>
	</head>
	<body>
		<header>
			<h1>Welcome, <c:out value="${user.getUserName()}"/>!</h1>
		</header>
		<main>
			<p>This is your dashboard. Nothing to see here yet.</p>
		</main>
		<footer>
			<form action="/logout" method="post">
				<input type="submit" value="logout">
			</form>
		</footer>
	</body>
</html>