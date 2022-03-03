<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/artistSearch.css">
		<title><c:out value="${artist}"/> - LooKify</title>
	</head>
	<body>
		<header>
			<p>Song by artist: <span><c:out value="${artist}"/></span></p>
			<form action="/search">
				<input type="search" value="<c:out value="${artist}"/>" placeholder="Artist" name="artist">
				<input type="submit" value="Search Artists">
			</form>
			<a href="/dashboard">Dashboard</a>
		</header>
		<main>
			<table class="table table-dark table-striped align-middle">
					<thead>
					    <tr>
					    	<th scope="col">Name</th>
					    	<th scope="col">Rating</th>
					    	<th scope="col">Actions</th>
					    </tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${songs}">
							<tr>
						    	<td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
						    	<td><c:out value="${song.rating}"/></td>
						    	<td class="actions_row">
						    		<form action="/songs/delete/${song.id}" method="post">
						    			<input type="hidden" name="_method" value="delete">
						    			<input class="a link-primary" type="submit" value="delete">
						    		</form>
						    	</td>
						    </tr>
						</c:forEach>
					</tbody>
				</table>
		</main>
	</body>
</html>