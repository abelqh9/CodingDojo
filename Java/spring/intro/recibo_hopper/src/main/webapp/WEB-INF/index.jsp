<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Recibo de Hopper</title>
	</head>
	<body>
		<h1>Customer Name: <c:out value="${customer_name}"></c:out></h1>
		<h2>Item Name: <c:out value="${item_name}"></c:out></h2>
		<h2>Price: $<c:out value="${item_price}"></c:out></h2>
		<h2>Description: $<c:out value="${item_description}"></c:out></h2>
		<h2>Vendor: <c:out value="${item_vendor}"></c:out></h2>
	</body>
</html>