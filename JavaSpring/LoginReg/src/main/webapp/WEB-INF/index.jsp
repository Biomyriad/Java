<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form ((See Model & Validation OneNote Tab)) -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes ((See Model & Validation OneNote Tab)) -->
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>
		
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="container">
		
			<h2 style="color: rgb(223, 0, 223)">Welcome!</h2>
			<p>Join our growing community.</p>
			
			<div class="d-flex justify-content-between">
				<div style="width: 270px;">
					<h3>Register</h3>

					<form:form action="/register" method="post" modelAttribute="newUser">
						<label for="">User Name: </label>
						<form:errors path="userName" class="text-danger"/>
						<form:input class="form-control" type="text" path="userName"/>

						<label for="">Email:</label>
						<form:errors path="email" class="text-danger"/>
						<form:input class="form-control" type="text" path="email"/>

						<label for="">Password:</label>
						<form:errors path="password" class="text-danger"/>
						<form:input class="form-control" type="text" path="password"/>

						<label for="">Confirm Password:</label>
						<form:errors path="confirm" class="text-danger"/>
						<form:input class="form-control" type="text" path="confirm"/>

						<div class="d-flex justify-content-end mt-3">
							<input class="btn btn-sm btn-primary" type="submit" value="Submit"/>
						</div>

					</form:form>
				</div>	

				<div style="width: 270px;">
					<h3>Log in</h3>

					<form:form action="/login" method="post" modelAttribute="newLogin">
						<label for="">Email: </label>
						<form:errors path="email" class="text-danger"/>
						<form:input class="form-control" type="text" path="email"/>

						<label for="">Password:</label>
						<form:errors path="password" class="text-danger"/>
						<form:input class="form-control" type="text" path="password"/>

						<div class="d-flex justify-content-end mt-3">
							<input class="btn btn-sm btn-primary" type="submit" value="Submit"/>
						</div>

					</form:form>
				</div>				
			</div>
		</div>
	</body>
</html>