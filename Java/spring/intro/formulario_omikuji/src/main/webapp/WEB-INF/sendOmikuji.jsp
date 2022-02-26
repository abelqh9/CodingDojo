<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Omikuji</title>
		<link rel="stylesheet" href="/css/sendOmikuji.css" />
	</head>
	<body>
		<header>
			<h1>Send an Omikuji</h1>
		</header>
		<main>
			<form action="/omikuji/process" method="post">
				<label>
					Pick any number from 5 to 25
					<input type="number" name="number" min="5" max="25"/>
				</label>
				<label>
					Enter the name of any city
					<input type="text" name="city_name"/>
				</label>
				<label>
					Enter the name of any real person
					<input type="text" name="person_name"/>
				</label>
				<label>
					Enter professional endeavor or hobby
					<input type="text" name="hobby"/>
				</label>
				<label>
					Enter any type of living thing
					<input type="text" name="living_thing"/>
				</label>
				<label>
					Say something nice to someone
					<textarea name="something_nice" cols="20" rows="10"></textarea>
				</label>
				<span>Send and show a friend</span>
				<input type="submit" value="Send"/>
			</form>
		</main>
	</body>
</html>