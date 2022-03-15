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
		<link rel="stylesheet" href="/css/bookmarket.css">
		<title>BookMarket</title>
	</head>
	<body>
		<header>
			<div>
				<h2>Welcome, <c:out value="${user.getUserName()}"/>. Welcome to..</h2>
				<h1>The Book Broker!</h1>
			</div>
			<div>
				<form action="/logout" method="post">
					<input class="a" type="submit" value="logout">
				</form>
				<a href="/books/new">+Add Book</a>
			</div>
		</header>
		<main>
			<section class="to_borrow">
				<h3>Available Books to Borrow</h3>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
						    <th scope="col">Title</th>
						    <th scope="col">Author Name</th>
						    <th scope="col">Owner</th>
						    <th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books_to_borrow}">
							<tr>
								<th scope="row"><c:out value="${book.getId()}"/></th>
						        <td><a href="/books/<c:out value="${book.getId()}"/>"><c:out value="${book.getTitle()}"/></a></td>
						        <td><c:out value="${book.getAuthor()}"/></td>
						        <td><c:out value="${book.getUser().getUserName()}"/></td>
						        <td class="option_column">
							        <c:choose>
									    <c:when test="${user.getId() == book.getUser().getId()}">
									        <a href="/books/<c:out value="${book.getId()}"/>/edit">edit</a>
									        <form:form action="/books/delete" method="post">
									        	<input type="hidden" name="_method" value="delete">
									        	<input type="hidden" name="book_id" value="${book.getId()}">
									        	<input class="a" type="submit" value="delete" >
									        </form:form>
									    </c:when>    
									    <c:otherwise>
									        <form:form action="/borrows/new" method="post" modelAttribute="borrow">
									        	<input type="hidden" name="user" value="<c:out value="${user.getId()}"/>">
									        	<input type="hidden" name="book" value="<c:out value="${book.getId()}"/>">
									        	<input class="a" type="submit" value="borrow">
									        </form:form>
									    </c:otherwise>
									</c:choose>						        
						        </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<section class="borrowing">
				<h3>Books I'm Borrowing..</h3>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
						    <th scope="col">Title</th>
						    <th scope="col">Author Name</th>
						    <th scope="col">Owner</th>
						    <th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="borrow" items="${user_borrows}">
							<tr>
								<th scope="row"><c:out value="${borrow.getBook().getId()}"/></th>
						        <td><a href="/books/<c:out value="${borrow.getBook().getId()}"/>"><c:out value="${borrow.getBook().getTitle()}"/></a></td>
						        <td><c:out value="${borrow.getBook().getAuthor()}"/></td>
						        <td><c:out value="${borrow.getBook().getUser().getUserName()}"/></td>
						        <td>
							        <form:form action="/borrows/delete" method="post">
										<input type="hidden" name="_method" value="delete">
									    <input type="hidden" name="book_id" value="${borrow.getBook().getId()}">
										<input class="a" type="submit" value="return">
									</form:form>						        
						        </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</main>
	</body>
</html>