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
		<link rel="stylesheet" href="/css/books.css">
		<title>Dashboard</title>
	</head>
	<body>
		<header>
			<div>
				<h1>Welcome, <c:out value="${user.getUserName()}"/>!</h1>
				<p>Books from everyone's shelves</p>			
			</div>
			<div>
				<form action="/logout" method="post">
					<input class="a" type="submit" value="logout">
				</form>
				<a href="/books/new">+Add a to my shelf!</a>
			</div>
		</header>
		<main>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
					    <th scope="col">Title</th>
					    <th scope="col">Author Name</th>
					    <th scope="col">Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<th scope="row"><c:out value="${book.getId()}"/></th>
					        <td><a href="/books/<c:out value="${book.getId()}"/>"><c:out value="${book.getTitle()}"/></a></td>
					        <td><c:out value="${book.getAuthor()}"/></td>
					        <td><c:out value="${book.getUser().getUserName()}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>