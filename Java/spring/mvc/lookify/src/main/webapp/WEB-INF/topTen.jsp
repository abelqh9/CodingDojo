<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/topTen.css">
		<title>Insert title here</title>
	</head>
	<body>
		<header>
			<h1>Top Ten Songs:</h1> <a href="/dashboard">Dashboard</a>		
		</header>
		<main>
			<ul>
				<c:forEach var="song" items="${songs}">
					<li>
						<b><c:out value="${song.rating}"/>-</b>
						<a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a>
						<b>-<c:out value="${song.artist}"/></b>
					</li>
				</c:forEach>
			</ul>
		</main>
	</body>
</html>