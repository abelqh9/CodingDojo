<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/newSong.css">
		<title>New Song - LooKify</title>
	</head>
	<body>
		<header>
			<a href="/dashboard">Dashboard</a>
		</header>
		<main>
			<form:form action="/songs/new" method="post" modelAttribute="song">		
				<div>
					<form:label class="col-form-label"  path="title">Title:</form:label>
					<form:input class="form-control" path="title"/>
				</div>
				<form:errors path="title" class="text-danger"/>
				
				<div>
					<form:label class="col-form-label" path="artist">Artist:</form:label>
					<form:input class="form-control" path="artist"/>
				</div>
				<form:errors path="artist" class="text-danger"/>
				
				<div>
					<form:label class="col-form-label" path="rating">Rating (1-10):</form:label>
					<form:input type="number" class="form-control" path="rating"/>
				</div>
				<form:errors path="rating" class="text-danger"/>
				
				<input class="btn btn-primary" type="submit" value="Submit"/>
			</form:form>
		</main>
	</body>
</html>