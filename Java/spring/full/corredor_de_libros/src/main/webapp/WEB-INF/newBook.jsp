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
		<link rel="stylesheet" href="/css/newBook.css">
		<title>New Book</title>
	</head>
	<body>
		<header>
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/bookmarket">Back to the market!</a>
		</header>
		<main>
			<form:form action="/books/new" method="post" modelAttribute="book">
				<form:input type="hidden" path="user" value="${user.getId()}"/>
				<form:errors class="text-danger" path="title"></form:errors>
				<div>
					<form:label path="title">Title</form:label>
					<form:input class="form-control" path="title"/>
				</div>
				<form:errors class="text-danger" path="author"></form:errors>
				<div>
					<form:label path="author">Author</form:label>
					<form:input class="form-control" path="author"/>
				</div>
				<form:errors class="text-danger" path="thoughts"></form:errors>
				<div>
					<form:label path="thoughts">My thoughts</form:label>
					<form:textarea class="form-control" path="thoughts"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Submit">
			</form:form>
		</main>
	</body>
</html>