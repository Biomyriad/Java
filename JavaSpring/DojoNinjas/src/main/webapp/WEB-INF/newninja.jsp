<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- c:out ; c:forEach etc. --> 
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
			<h1>New Ninja</h1>
		
			<form:form action="/ninjas/new" method="post" modelAttribute="newNinja">
				<form:errors path="dojo"/> 
				<p>
					<form:select path="dojo" class="form-select">
					
					  <option selected value="null">Open this select menu</option>
					  
						<c:forEach var="item" items="${dojos}">
								<option value="${item.id}"><c:out value="${item.name}"></c:out></option>
						</c:forEach>
					  
					</form:select>				
				</p>

			    <p>
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>     
			        <form:input class="form-control" type="text" path="firstName"/>
			    </p>    
			    <p>
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>     
			        <form:input class="form-control" type="text" path="lastName"/>
			    </p> 
				<p>
			        <form:label path="age">Age</form:label>
			        <form:errors path="age"/>     
			        <form:input class="form-control" type="number" path="age"/>
			    </p> 
			    <input class="btn btn-primary" type="submit" value="Submit"/>
			</form:form> 
		</div>
	</body>
</html>