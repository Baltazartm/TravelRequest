<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<title>Edit Request</title>
</head>
<body>
	<form:form method="post" modelAttribute="trips" action="tours/${trips.id}">
		<table>
			<tbody>
				<tr>
					<td>
						Trip Purpose: <br>
						<form:textarea rows="3" cols="5" path="description"></form:textarea>
					</td>
				</tr>
				<tr>
					<td>
						Start Date: <br>
						<form:input type="text" path="startDate"/>
					</td>
				</tr>
				<tr>
					<td>
						End Date: <br>
						<form:input type="text" path="endDate"/>
					</td>				
				</tr>
				<tr>
					<td>
						Mode of Travel: <br>
						<form:input type="text" path="modeTravel"/>
					</td>
				</tr>
				<tr>
					<td>
						Ticket Cost: <br>
						<form:input type="text" path="ticketCost"/>
					</td>
				</tr>
				<tr>
					<td>
						Taxi Cost at Home Town : <br>
						<form:input type="text" path="cabH"/>
					</td>
				</tr>
				<tr>
					<td>
						Taxi Cost at Destination Town : <br>
						<form:input type="text" path="cabD"/>
					</td>
				</tr>
				<tr>
					<td>
						Choose Manager : <br>
						<form:select path="tobeApprovedby">
						<c:forEach var="managers" items="${manager}">
							<option value="${managers.id}">${managers.name}</option>
						</c:forEach>
						</form:select>
					</td>
				</tr>
			</tbody>
		</table>
			<input type="submit" value="Submit Request">
	</form:form>
</body>
</html>