<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title>Products Page</title>
	</head>
	
	<body>
		<div class="container">
			
			<h1 class="mx-auto" style="width:fit-content"> <c:out value="${product.name}"/> </h1>

			<a class="d-block" href="/">Home</a>

			<hr>

            <h3>Categories:</h3>
            <ul>
            
            	<c:forEach var="category" items="${catAssigned}">
					    <li><c:out value="${category.name}"/></li>
				</c:forEach>
            
            </ul>

            <hr>

            <h3>Add Category:</h3>
			
			<form action="/products/${product.id}" method="post">
			
	            <select name="categoryId" class="w-100 mb-3">
	            	<c:forEach var="category" items="${catUnassigned}">
	            			<option value="${category.id}"><c:out value="${category.name}"/></option>
					</c:forEach>
	            </select>
	
	            <input class="btn-sm btn-primary w-100" type="submit" value="Add"/>

			</form>
			
		</div>
	</body>
</html>