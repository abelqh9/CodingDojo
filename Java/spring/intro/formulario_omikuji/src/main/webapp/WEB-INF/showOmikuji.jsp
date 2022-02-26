<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Omikuji</title>
		<link rel="stylesheet" href="/css/showOmikuji.css" />
	</head>
	<body>
		<header>
			<h1>Here is Your OmiKuji</h1>
		</header>
		<main>
			<section>
				<p>
					In <c:out value="${number}"/> years, you will live in <c:out value="${city_name}"/> with <c:out value="${person_name}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${living_thing}"/>, you will have good luck. Also, <c:out value="${something_nice}"/>
				</p>
			</section>
		</main>
			<footer><a href="/omikuji">Go Back</a></footer>
	</body>
</html>