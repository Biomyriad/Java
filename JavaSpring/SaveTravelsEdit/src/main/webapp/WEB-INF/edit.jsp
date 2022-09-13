<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<div class="d-flex justify-content-between align-items-center">
				<h1 style="color: rgb(0, 0, 196)">Edit Expense</h1>
				<a href="/">Go Back</a>
			</div>
			
			<div>
				<form:form class="expence-form" action="/edit/${expense.id}" method="post" modelAttribute="expense">
					<input type="hidden" name="_method" value="put"/>
				
					<form:label path="expense" for="">Expense Name: </form:label>
					<form:errors class="error" path="expense"/>  
					<form:input path="expense" class="form-control" type="text" name="" id=""/>

					<form:label path="vendor" for="">Vendor:</form:label>
					<form:errors class="error" path="vendor"/>  
					<form:input path="vendor" class="form-control" type="text" name="" id=""/>

					<form:label path="amount" for="">Amount:</form:label>
					<form:errors class="error" path="amount"/>  
					<form:input path="amount" class="form-control" type="text" name="" id=""/>

					<form:label path="description" for="">Description:</form:label>
					<form:errors class="error" path="description"/>  
					<form:textarea path="description" class="form-control" name="" id="" cols="30" rows="10"></form:textarea>

					<div class="d-flex justify-content-end mt-3">
						<input class="btn btn-sm btn-primary" type="Submit" value="Submit"/>
					</div>
				</form:form>
			</div>					
		</div>
	</body>
</html>