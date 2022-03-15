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
		<link rel="stylesheet" href="/css/registerAndLogin.css">
		<title>Register And Login</title>
	</head>
	<body>
		<header>
			<h1>Welcome!</h1>
			<p>Join our growing community</p>
		</header>
		<main>
			<section>
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="user">
					<form:errors class="text-danger" path="userName"></form:errors>
					<div>
						<form:label path="userName">User Name:</form:label>
						<form:input class="form-control" path="userName"/>
					</div>
					
					<form:errors class="text-danger" path="email"></form:errors>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input class="form-control" type="email" path="email"/>
					</div>
					
					<form:errors class="text-danger" path="password"></form:errors>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input class="form-control" type="password" path="password"/>
					</div>
					
					<form:errors class="text-danger" path="confirm"></form:errors>
					<div>
						<form:label path="confirm">Confirm PW:</form:label>
						<form:input class="form-control" type="password" path="confirm"/>
					</div>
					<input type="submit" value="Submit">
				</form:form>
			</section>
			<section>
				<h2>Log in</h2>
				<form:form action="/login" method="post" modelAttribute="loginUser">
					<form:errors class="text-danger" path="email"></form:errors>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input class="form-control" type="email" path="email"/>
					</div>
					
					<form:errors class="text-danger" path="password"></form:errors>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input class="form-control" type="password" path="password"/>
					</div>
					<input type="submit" value="Submit">
				</form:form>
			</section>
		</main>
	</body>
</html>