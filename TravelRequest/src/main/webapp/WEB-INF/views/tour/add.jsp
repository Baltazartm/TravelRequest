<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<link href="resources/css/userProfile.css" rel="stylesheet">
<title>New Travel Request</title>
</head>
<body>
	<div class="container">
	<form:form action="tours" method="post" modelAttribute="tour">
		<div>
			<h3 class="title" >Please provide specific details</h3>
		</div>
		<table>
			<tbody>
				<tr>
					<td>
						Trip Purpose: <br>
						<textarea rows="10" cols="4" path="description"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Start Date: <br>
						<input type="text" path="startDate"/>
					</td>
				</tr>
				<tr>
					<td>
						End Date: <br>
						<input type="text" path="endDate"/>
					</td>				
				</tr>
				<tr>
					<td>
						Mode of Travel: <br>
						<input type="text" path="modeTravel"/>
					</td>
				</tr>
				<tr>
					<td>
						Ticket Cost: <br>
						<input type="text" path="ticketCost"/>
					</td>
				</tr>
				<tr>
					<td>
						Taxi Cost at Home Town : <br>
						<input type="text" path="cabH"/>
					</td>
				</tr>
				<tr>
					<td>
						Taxi Cost at Destination Town : <br>
						<input type="text" path="cabD"/>
					</td>
				</tr>
			</tbody>
		</table>
		 <div class="form-group">
				<label for="modeOfTransportDestination">Select an approving Manager</label>
				<form:select path="tobeApprovedby" class="form-control" id="modeOfTransportDestination">
					<c:forEach var="managers" items="${manager}">
						<option value="${managers.id}">${managers.name}</option>
					</c:forEach>
				</form:select>
				</div>
			<input type="submit" value="Save as draft">
	</form:form>
	</div>

</body>
</html>