<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		    <link rel="stylesheet" href="/css/newDojo.css">
		<title>New Dojo</title>
	</head>
	<body>
		<main>
			<h1>New Dojo</h1>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<form:errors path="name" class="text-danger"></form:errors>
				<div>
					<form:label path="name">Name:</form:label>
					<form:input class="form-control" path="name"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Create">
			</form:form>
		</main>
	</body>
</html>