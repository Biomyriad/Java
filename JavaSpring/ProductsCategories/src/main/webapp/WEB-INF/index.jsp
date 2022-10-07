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
		<title>Home</title>
	</head>
	
	<body>
		<div class="container">
			
			<h1 class="mx-auto" style="width:fit-content">Home Page</h1>

			<a class="d-block" href="/products/new">New Product</a>
			<a class="d-block" href="/categories/new">New Category</a>

			<hr>

			<table class="items-list" style="width: 600px;">
				<thead>
					<tr>
						<th><h3>Products</h3></th>
						<th><h3>Categories</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>

							<ul style="list-style-type:none; padding: 0px;">
								<c:forEach var="product" items="${products}">
									<li>- <a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
								</c:forEach>
							</ul>

						</td>
						<td>

							<ul style="list-style-type:none; padding: 0px;">
							
								<c:forEach var="category" items="${categories}">
									<li>- <a href="/categories/${category.id}"><c:out value="${category.name}"></c:out></a></li>
								</c:forEach>							
							
							</ul>
							
						</td>
					</tr>
				</tbody>
			</table>

		</div>
	</body>
</html>