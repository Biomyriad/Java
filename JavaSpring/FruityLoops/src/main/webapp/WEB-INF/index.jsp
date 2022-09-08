<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/styles.css"/>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="container">
		
			<h1 style="color: pink">Fruit Store</h1>
			
			<div class="p-2" style="background-color: pink; width: 435px;">
				<table class="table m-2" style="background-color: white; width: 400px; border-color: pink;">
					<thead>
						<tr>
							<th>Name</th>
							<th>Price</th>
						</tr>				
					</thead>
					<tbody>
						<c:forEach var="fruit" items="${fruits}">
						<tr>
							<td><c:out value="${fruit.name}"></c:out></td>
							<td><c:out value="${fruit.price}"></c:out></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>						
		</div>
	</body>
</html>