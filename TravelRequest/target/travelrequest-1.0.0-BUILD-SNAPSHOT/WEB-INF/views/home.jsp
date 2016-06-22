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
		<c:choose>
		
			<c:when test="${loggedInUser.userType == 'B'}">
				<c:forEach var="trips" items="${submittedTrips}">
					<p>${trips.id}</p>
				</c:forEach>
			</c:when>
			
			<%-- <c:when test="">
			
			</c:when> --%>
			
			<c:otherwise>
				<p>Your trip: </p>
				<c:forEach var="trips" items="${allTrips}">
					<a href="tours/${trips.id}/edit">${trips.startDate}</a><br>
				</c:forEach>
				<a href="tours?add">Add Trip</a>
			</c:otherwise>
		</c:choose>
		<a href="logout">Logout </a>
	</c:otherwise>
	</c:choose>
</body>
</html>
