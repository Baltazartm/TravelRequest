<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	
	<c:choose>
	<c:when test="${empty loggedInUser}">
		<a href="login">Login </a>
	</c:when>
	<c:otherwise>
		<p> Helloo ${loggedInUser.name}</p>
		<p>Your trip</p>
		<c:forEach var="tours" items="${allTours}">
			<p>${tours.id}</p>
		</c:forEach>
		<a href="logout">Logout </a>
	</c:otherwise>
	</c:choose>
</body>
</html>
