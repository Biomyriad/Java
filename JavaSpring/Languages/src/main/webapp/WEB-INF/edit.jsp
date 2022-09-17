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
			<div>
				<form:form class="expence-form" action="/languages/${language.id}" method="post" modelAttribute="language">
					<input type="hidden" name="_method" value="put"/>
					
					<form:label path="name" for="">Name: </form:label>
					<form:errors class="error" path="name"/>  
					<form:input path="name" class="form-control" type="text" name="" id=""/>

					<form:label path="creator" for="">Creator:</form:label>
					<form:errors class="error" path="creator"/>  
					<form:input path="creator" class="form-control" type="text" name="" id=""/>

					<form:label path="version" for="">Version:</form:label>
					<form:errors class="error" path="version"/>  
					<form:input path="version" class="form-control" type="text" name="" id=""/>

					<div class="d-flex justify-content-end mt-3">
						<input class="btn btn-sm btn-primary" type="Submit" value="Submit"/>
					</div>
				</form:form>
			</div>					
		</div>
	</body>
</html>