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
		<link rel="stylesheet" href="/css/showBook.css">
		<title><c:out value="${book.getTitle()}"/></title>
	</head>
	<body>
		<header>
			<h1><c:out value="${book.getTitle()}"/></h1>
			<a href="/">Back to the market!</a>
		</header>
		<main>
			<h2>
				<span class="book_user">
					<c:choose>
					    <c:when test="${isTheUser}">You</c:when>
					    <c:otherwise><c:out value="${book.getUser().getUserName()}"/></c:otherwise>
					</c:choose>
				</span> read 
				<span class="book_title"><c:out value="${book.getTitle()}"/></span> by 
				<span class="book_author"><c:out value="${book.getAuthor()}"/></span>
			</h2>
			<h3>
				<c:choose>
					<c:when test="${isTheUser}">
						Here are Your thoughts:
					</c:when>
					<c:otherwise>
						Here are <c:out value="${book.getUser().getUserName()}"/>'s thoughts:
					</c:otherwise>
				</c:choose>
			</h3>
			<p class="book_thoughts">
				<c:out value="${book.getThoughts()}"/>
			</p>
		</main>
		<c:if test="${isTheUser}">
			<footer>
				<a href="/books/<c:out value="${book.getId()}"/>/edit">edit</a>
			</footer>
		</c:if>
	</body>
</html>