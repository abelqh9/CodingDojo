<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/showProduct.css">
		<title><c:out value="${product.getName()}"/></title>
	</head>
	<body>
		<header>
			<h1><c:out value="${product.getName()}"/></h1>		
		</header>
		<main>
			<section>
				<h2>Categories:</h2>
				<ul>
					<c:forEach var="category" items="${productCategories}">
						<li><c:out value="${category.getName()}"/></li>
					</c:forEach>
				</ul>
			</section>
			<section>
				<form action="/products/<c:out value="${product.getId()}"/>" method="post">
					<div>
						<label for="select">Add Category:</label>
						<select name="newCategory" id="select" class="form-select">
							<c:forEach var="category" items="${notProductCategories}">
								<option value="<c:out value="${category.getId()}"/>"><c:out value="${category.getName()}"/></option>
							</c:forEach>
						</select>
					</div>
					<input class="btn btn-primary" type="submit" value="Add">
				</form>
			</section>
		</main>
	</body>
</html>