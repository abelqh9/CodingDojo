<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		    <link rel="stylesheet" href="/css/newNinja.css">
		<title>New Ninja</title>
	</head>
	<body>
		<main>
			<h1>New Ninja</h1>
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
				<div>
					<form:label path="dojo">Dojo</form:label>
					<form:select class="form-select" path="dojo">
						<c:forEach var="dojo" items="${dojos}">
							<form:option value="${dojo.getId()}">
								<c:out value="${dojo.getName()}"/>
							</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:errors path="first_name" class="text-danger"></form:errors>
				<div>
					<form:label path="first_name">First Name</form:label>
					<form:input class="form-control" path="first_name"/>
				</div>
				<form:errors path="last_name" class="text-danger"></form:errors>
				<div>
					<form:label path="last_name">Last Name</form:label>
					<form:input class="form-control" path="last_name"/>
				</div>
				<form:errors path="age" class="text-danger"></form:errors>
				<div>
					<form:label path="age">Age</form:label>
					<form:input class="form-control" type="number" path="age"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Create">
			</form:form>
		</main>
	</body>
</html>