<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/edit_language.css"/>
		<title>Edit Language</title>
	</head>
	<body>
		<header>
			<h1>Edit language</h1>
			<div class="header_options">
				<form action="/languages/delete/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input class="a link-primary" type="submit" value="delete">
				</form> 
				<a href="/languages">Dashboard</a>
			</div>
		</header>
		<main>
			<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
					
				<div>
				    <form:label class="col-form-label"  path="name">Name:</form:label>
					<form:errors path="name" class="alert alert-danger"/>
				    <form:input class="form-control" path="name"/>
				</div>
				<div>
				    <form:label class="col-form-label" path="creator">Creator:</form:label>
				    <form:errors path="creator" class="alert alert-danger"/>
				    <form:input class="form-control" path="creator"/>
				</div>
				<div>
					<form:label class="col-form-label" path="version">Version:</form:label>
				    <form:errors path="version" class="alert alert-danger"/>
				    <form:input class="form-control" path="version"/>
				</div>

				<input class="btn btn-primary" type="submit" value="Submit"/>
			</form:form>
		</main>
	</body>
</html>