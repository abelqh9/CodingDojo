<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		    <link rel="stylesheet" href="/css/showDojo.css">
		<title>dojo.name</title>
	</head>
	<body>
		<main>
			<h1><c:out value="${dojo.name}"/></h1>
			<table class="table">
				<thead>
				    <tr>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Age</th>
				    </tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.ninjas}">
					    <tr>
						    <td><c:out value="${ninja.first_name}"/></td>
						    <td><c:out value="${ninja.last_name}"/></td>
						    <td><c:out value="${ninja.age}"/></td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>