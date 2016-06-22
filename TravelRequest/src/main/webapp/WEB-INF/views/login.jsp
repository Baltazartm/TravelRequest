<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
	<link href="resources/css/login.css" rel="stylesheet">
<title>login</title>
</head>
<body>
	<div id="formLayout">
		<form action="login" method="post" id="login-form" class="form-signin">
			<h2 class="form-signin-heading">Please login</h2>
					<label for="userId" class="sr-only">Username</label>
					<input type="text" class="form-control" id="userId" name="userId" placeholder="username">
					
					<label for="password" class="sr-only">Password</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="password">
					
					<!-- <div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
	
</body>
</html>