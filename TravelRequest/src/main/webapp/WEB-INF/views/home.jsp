<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<link href="resources/css/home.css" rel="stylesheet">
	
</head>

<body>

<div class="container">
	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">abc Travel Portal</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="active">${serverTime}</li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav><!--/.navbar navbar-default-->
      
      
      <div class="jumbotron">
      	<h1>Welcome to Travel Portal.</h1>
        </br>
        <div id="profileLayout">
    	<c:if test="${not empty loggedInUser}">
			<div id="profileInfo">
			  <p>Name: ${loggedInUser.name}</p>
			</div>
       	</c:if>	
        	<c:choose>
				<c:when test="${empty loggedInUser}">
				<a href="login">Login </a>
				</c:when>
				<c:otherwise>
					<a href="logout">Logout</a>
				</c:otherwise>
			</c:choose>
		</div>
      </div>
      
      <c:if test="${loggedInUser.userType == 'A'}">
		<!-- user can click button to get access to form to add new record -->
		<div class="center">
		 	<a href="tours?add"><button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Add new Tour Record</button></a>
		</div>
     
      		<!-- user can view tour records here -->
<section>
		<h1 align="center">View Records</h1>
		<div class="tbl-header">
	<table cellpadding="1" cellspacing="1" border="1">
	  <thead>
	    <tr>
	      <th>Record ID</th>
	      <th>Description</th>
			<th>Approving Manger</th>
	      <th>Status</th>
	      <th>Edit as draft</th> <!-- this feature is not yet supported -->
	    </tr>
	  </thead>
	</table>
		</div>
		<div class="tbl-content">
			<table cellpadding="1" cellspacing="1" border="1">
			  <tbody>
			  	<c:forEach var="trips" items="${allTrips}">
			  		<tr>
			      	<td>${trips.id}</td>
			      	<td>${trips.description}</td>
			      	<!-- <td>Mrs. Amoria</td> -->
			      	<td>${trips.status}</td>
						<td><a href="tours/${trips.id}/edit"><button class="btn btn-primary">Edit</button></a></td>
			    	</tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
</section>
       </c:if>
</div>
      
      <!--  line modal
	 <div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	 	  <div class="modal-content">
	 		<div class="modal-header">
	 			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	 			<h3 class="modal-title" id="lineModalLabel">Please provide specific details</h3>
	 		</div>
	 			<div class="modal-body">
						 		
				</div>
			</div>
		</div>
		</div> -->

	
		<%-- <c:choose>
		
			<c:when test="${loggedInUser.userType == 'B'}">
				<c:forEach var="trips" items="${submittedTrips}">
					<p>${trips.id}</p>
				</c:forEach>
			</c:when>
			
			<c:when test="">
			
			</c:when>
			
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
	</c:choose> --%>
</body>
</html>
