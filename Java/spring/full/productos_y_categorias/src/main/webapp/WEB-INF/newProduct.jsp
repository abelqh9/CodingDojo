<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/newProduct.css">
		<title>New Product</title>
	</head>
	<body>
		<main>
			<h1>New Product</h1>
			<form:form action="/products/new" method="post" modelAttribute="product">
				<form:errors class="text-danger" path="name"></form:errors>
				<div>
					<form:label path="name">Name:</form:label>
					<form:input class="form-control" path="name"/>
				</div>
				
				<form:errors class="text-danger" path="description"></form:errors>
				<div>
					<form:label path="description">Description:</form:label>
					<form:input class="form-control" path="description"/>
				</div>
				
				<form:errors class="text-danger" path="price"></form:errors>
				<div>
					<form:label path="price">Price</form:label>
					<form:input class="form-control" path="price"/>
				</div>
				
				<input class="btn btn-primary" type="submit" value="Create">
			</form:form>
		</main>
	</body>
</html>