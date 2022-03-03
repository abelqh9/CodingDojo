<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/books.css" />
		<title>All Books</title>
	</head>
	<body>
		<header>
			<h1>All Books</h1>
		</header>
		<main>
			<table class="table table-dark table-striped">
				<thead>
				    <tr>
				      <th scope="col">ID</th>
				      <th scope="col">Title</th>
				      <th scope="col">Language</th>
				      <th scope="col"># Pages</th>
				    </tr>
				 </thead>
				 <tbody>
					<c:forEach var="book" items="${books}">
					 	<tr>
					      <th scope="row"><c:out value="${book.id}"/></th>
					      <td><a href="/books/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
					      <td><c:out value="${book.language}"/></td>
					      <td><c:out value="${book.numberOfPages}"/></td>
					    </tr>
					</c:forEach>
				 </tbody>
			</table>
		</main>		
	</body>
</html>