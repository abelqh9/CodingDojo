<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/css/index.css" />
	</head>
	<body>
		<header>
			<h1>Fruit Store</h1>		
		</header>
		<main>
			<table class="items_container">
				<tr> <th>Name</th> <th>Price</th> </tr>
				<c:forEach var="item" items="${items}">
        			<tr> <td><c:out value="${item.name}" /></td> <td><c:out value="${item.price}" /></td> </tr>
    			</c:forEach>
			</table>
		</main>		
	</body>
</html>