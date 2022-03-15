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
		<link rel="stylesheet" href="/css/showCategory.css">
		<title><c:out value="${category.getName()}"/></title>
	</head>
	<body>
		<header>
			<h1><c:out value="${category.getName()}"/></h1>		
		</header>
		<main>
			<section>
				<h2>Products:</h2>
				<ul>
					<c:forEach var="product" items="${categoryProducts}">
						<li><c:out value="${product.getName()}"/></li>
					</c:forEach>
				</ul>
			</section>
			<section>
				<form action="/categories/<c:out value="${category.getId()}"/>" method="post">
					<div>
						<label for="select">Add Product:</label>
						<select name="newProduct" id="select" class="form-select">
							<c:forEach var="product" items="${notCategoryProducts}">
								<option value="<c:out value="${product.getId()}"/>"><c:out value="${product.getName()}"/></option>
							</c:forEach>
						</select>
					</div>
					<input class="btn btn-primary" type="submit" value="Add">
				</form>
			</section>
		</main>
	</body>
</html>