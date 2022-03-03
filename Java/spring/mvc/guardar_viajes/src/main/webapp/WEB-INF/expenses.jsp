<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/expenses.css"/>
		<title>Expenses</title>
	</head>
	<body>
		<main>
			<section>
				<h1>Save Travels</h1>
				<table class="table table-dark table-striped">
					<thead>
					    <tr>
					    	<th scope="col">Expense</th>
					    	<th scope="col">Vendor</th>
					    	<th scope="col">Amount</th>
					    </tr>
					</thead>
					<tbody>
						<c:forEach var="expense" items="${expenses}">
							<tr>
						    	<td><c:out value="${expense.name}"/></td>
						    	<td><c:out value="${expense.vendor}"/></td>
						    	<td>$<c:out value="${expense.amount}"/></td>
						    </tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<section>
				<h2>Add an expense:</h2>
				<form:form action="/add_expense" method="post" modelAttribute="expense">
					
					    <form:errors path="name" class="alert alert-danger"/>
					    <form:errors path="vendor" class="alert alert-danger"/>
					    <form:errors path="amount" class="alert alert-danger"/>
					    <form:errors path="description" class="alert alert-danger"/>
					
				    <div>
				        <form:label class="col-form-label"  path="name">Expense Name:</form:label>
				        <form:input class="form-control" path="name"/>
				    </div>
				    <div>
				        <form:label class="col-form-label" path="vendor">Vendor:</form:label>
				        <form:input class="form-control" path="vendor"/>
				    </div>
				    <div>
				        <form:label class="col-form-label" path="amount">Amount:</form:label>
				        <form:input class="form-control" type="number" path="amount"/>
				    </div>
				    <div>
				        <form:label class="col-form-label" path="description">Description:</form:label>
				        <form:textarea class="form-control" rows="3"  path="description"/>
				    </div>
				    <input class="btn btn-primary" type="submit" value="Submit"/>
				</form:form>   
			</section>
		</main>
	</body>
</html>