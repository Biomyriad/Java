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
		<title>Category Page</title>
	</head>
	
	<body>
		<div class="container">
			
			<h1 class="mx-auto" style="width:fit-content"> XXX </h1>

			<a class="d-block" href="/">Home</a>

			<hr>

            <h3>Products:</h3>
            <ul>
            	<c:forEach var="product" items="${prodAssigned}">
					    <li><c:out value="${product.name}"/></li>
				</c:forEach>
            </ul>

            <hr>

            <h3>Add Products:</h3>
            
            <form action="/categories/${category.id}" method="post">

	            <select name="productId" class="w-100 mb-3">
	            	<c:forEach var="product" items="${prodUnassigned}">
	            			<option value="${product.id}"><c:out value="${product.name}"/></option>
					</c:forEach>
	            </select>
	
	            <input class="btn-sm btn-primary w-100" type="submit" value="Add"/>
            
            </form>

		</div>
	</body>
</html>