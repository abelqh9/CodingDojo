<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/index.css">
    <title>Oro Ninja</title>
</head>
<body>
    <header>
        <h1><span>Your Gold:</span><span class="titleCounter generalBorder"><c:out value="${ninja_gold}"/></span></h1>
    </header>
    <main>
        <div class="buildingCard generalBorder">
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="farm" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="cave" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="house" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
        <div class="buildingCard generalBorder">
            <h2>Casino!</h2>
            <p>(earns 0-50 golds)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="casino" />
                <input type="submit" value="Find Gold!"/>
            </form>
        </div>
    </main>
    <footer>
        <span>Activities</span>
        <div class="activities_chart generalBorder">
        	<c:forEach var="text" items="${activities_texts}">
				<p class=${text[0] ? "true_text" : "false_text"}><c:out value="${text[1]}"/></p>        		
			</c:forEach>
        </div>
    </footer>
</body>
</html>