<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/languages.css"/>
		<title>Languages</title>
	</head>
	<body>
		<main>
			<section>
				<h1>Languages</h1>
				<table class="table table-dark table-striped align-middle">
					<thead>
					    <tr>
					    	<th scope="col">Name</th>
					    	<th scope="col">Creator</th>
					    	<th scope="col">Version</th>
					    	<th scope="col">Actions</th>
					    </tr>
					</thead>
					<tbody>
						<c:forEach var="language" items="${languages}">
							<tr>
						    	<td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
						    	<td><c:out value="${language.creator}"/></td>
						    	<td><c:out value="${language.version}"/></td>
						    	<td class="actions_row">
						    		<form action="/languages/delete/${language.id}" method="post">
						    			<input type="hidden" name="_method" value="delete">
						    			<input class="a link-primary" type="submit" value="delete">
						    		</form> 
						    		<a href="/languages/edit/<c:out value="${language.id}"/>">edit</a>
						    	</td>
						    </tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<section>
				<h2>Add Language</h2>
				<form:form action="/languages" method="post" modelAttribute="language">		
						<form:errors path="name" class="alert alert-danger"/>
				    <div>
				        <form:label class="col-form-label"  path="name">Name:</form:label>
				        <form:input class="form-control" path="name"/>
				    </div>
				        <form:errors path="creator" class="alert alert-danger"/>
				    <div>
				        <form:label class="col-form-label" path="creator">Creator:</form:label>
				        <form:input class="form-control" path="creator"/>
				    </div>
				        <form:errors path="version" class="alert alert-danger"/>
				    <div>
				        <form:label class="col-form-label" path="version">Version:</form:label>
				        <form:input class="form-control" path="version"/>
				    </div>
				    <input class="btn btn-primary" type="submit" value="Submit"/>
				</form:form>
			</section>
		</main>
	</body>
</html>