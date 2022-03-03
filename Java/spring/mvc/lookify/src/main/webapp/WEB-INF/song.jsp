<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/song.css">
		<title><c:out value="${song.id}"/> - LooKify</title>
	</head>
	<body>
		<header>
			<a href="/dashboard">Dashboard</a>
		</header>
		<main>
			<ul>
				<li><b>Title:</b> <c:out value="${song.title}"/> </li>
				<li><b>Artist:</b> <c:out value="${song.artist}"/> </li>
				<li><b>Rating (1-10):</b> <c:out value="${song.rating}"/> </li>
			</ul>
			<form action="/songs/delete/${song.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input class="a link-primary" type="submit" value="Delete">
			</form>
		</main>
	</body>
</html>