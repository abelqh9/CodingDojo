<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/show_expense.css"/>
		<title>Show Expense</title>
	</head>
	<body>
		<main>
			<section>
				<h1>Expense Details <a href="/expenses">Go Back</a></h1>
				<ul>
					<li><b>Expense Name: </b><c:out value="${expense.name}"/></li>
					<li><b>Description: </b><c:out value="${expense.description}"/></li>
					<li><b>Vendor: </b><c:out value="${expense.vendor}"/></li>
					<li><b>Amount: </b>$<c:out value="${expense.amount}"/></li>
				</ul>
			</section>
		</main>
	</body>
</html>