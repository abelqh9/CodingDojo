<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/show_language.css"/>
		<title>Show Languages</title>
	</head>
	<body>
		<header>
			<h1>Languages Details</h1>
			<a href="/languages">Dashboard</a>	
		</header>
		<main>
			<ul>
				<li><b>Name: </b><c:out value="${language.name}"/></li>
				<li><b>Creator: </b><c:out value="${language.creator}"/></li>
				<li><b>Version: </b><c:out value="${language.version}"/></li>
			</ul>
			<div class="main_options">
				<a href="/languages/edit/<c:out value="${language.id}"/>">edit</a>
				<form action="/languages/delete/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input class="a link-primary" type="submit" value="delete">
				</form> 
			</div>
		</main>
	</body>
</html>